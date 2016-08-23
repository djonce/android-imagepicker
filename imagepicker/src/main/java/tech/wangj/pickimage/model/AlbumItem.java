package tech.wangj.pickimage.model;

/**
 * Created by wangj on 2016/8/22
 */
public class AlbumItem {

    private String pathName;
    private int fileCount;
    private String firstImagePath;

    public AlbumItem(String pathName, int fileCount, String firstImagePath) {
        this.pathName = pathName;
        this.fileCount = fileCount;
        this.firstImagePath = firstImagePath;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public String getFirstImagePath() {
        return firstImagePath;
    }

    public void setFirstImagePath(String firstImagePath) {
        this.firstImagePath = firstImagePath;
    }
}
