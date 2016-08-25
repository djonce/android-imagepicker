package teach.wangjie.imagepicker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import tech.wangj.pickimage.R;
import teach.wangjie.imagepicker.utils.DisplaysUtil;
import teach.wangjie.imagepicker.utils.SdcardImageLoader;

/**
 * 图片墙 （SDCard 上所有的图片）
 *
 * Created by wangj on 2016/8/22
 */
public class PhotoWallAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<String> imagePathList = null;

    private SdcardImageLoader loader;


    public PhotoWallAdapter(Context context, ArrayList<String> imagePathList) {
        this.context = context;
        this.imagePathList = imagePathList;

        loader = new SdcardImageLoader(DisplaysUtil.SCREEN_WIDTH_PIXELS, DisplaysUtil.SCREEN_HEIGHT_PIXELS);

    }

    @Override
    public int getCount() {
        return imagePathList == null ? 0 : imagePathList.size();
    }

    @Override
    public Object getItem(int position) {
        return imagePathList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String filePath = (String) getItem(position);

        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.view_photo_wall_item, null);
            holder = new ViewHolder();

            holder.imageView = (ImageView) convertView.findViewById(R.id.photo_wall_item_photo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setTag(filePath);
        loader.loadImage(4, filePath, holder.imageView);
        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
    }
}
