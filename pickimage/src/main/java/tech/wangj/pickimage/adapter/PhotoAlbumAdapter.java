package tech.wangj.pickimage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import tech.wangj.pickimage.R;
import tech.wangj.pickimage.model.AlbumItem;
import tech.wangj.pickimage.utils.DisplaysUtil;
import tech.wangj.pickimage.utils.SdcardImageLoader;

/**
 * Created by wangj on 2016/8/22
 */
public class PhotoAlbumAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<AlbumItem> list;

    private SdcardImageLoader loader;

    public PhotoAlbumAdapter(Context context, ArrayList<AlbumItem> list) {
        this.context = context;
        this.list = list;

        loader = new SdcardImageLoader(DisplaysUtil.SCREEN_WIDTH_PIXELS, DisplaysUtil.SCREEN_HEIGHT_PIXELS);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.view_photo_album_lv_item, null);
            holder = new ViewHolder();

            holder.firstImageIV = (ImageView) convertView.findViewById(R.id.select_img_gridView_img);
            holder.pathNameTV = (TextView) convertView.findViewById(R.id.select_img_gridView_path);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //图片（缩略图）
        String filePath = list.get(position).getFirstImagePath();
        holder.firstImageIV.setTag(filePath);
        loader.loadImage(4, filePath, holder.firstImageIV);
        //文字
        holder.pathNameTV.setText(getPathNameToShow(list.get(position)));

        return convertView;
    }

    private class ViewHolder {
        ImageView firstImageIV;
        TextView pathNameTV;
    }

    /**根据完整路径，获取最后一级路径，并拼上文件数用以显示。*/
    private String getPathNameToShow(AlbumItem item) {
        String absolutePath = item.getPathName();
        int lastSeparator = absolutePath.lastIndexOf(File.separator);
        return absolutePath.substring(lastSeparator + 1) + "(" + item.getFileCount() + ")";
    }
}
