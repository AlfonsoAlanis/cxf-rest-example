package ro.ieugen.demo.cxf.model;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlRootElement
public class Directory {

    private String name;
    private long dateTime;
    private int fileCount;

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Directory fromFile(File associatedFile) {
        checkNotNull(associatedFile, "File is null");

        Directory dir = new Directory();
        dir.setName(associatedFile.getName());
        dir.setDateTime(associatedFile.lastModified());
        dir.setFileCount(associatedFile.list().length);

        return dir;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "dateTime=" + dateTime +
                ", name='" + name + '\'' +
                ", fileCount=" + fileCount +
                '}';
    }
}
