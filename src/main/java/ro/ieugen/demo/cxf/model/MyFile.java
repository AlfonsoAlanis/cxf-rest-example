package ro.ieugen.demo.cxf.model;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlRootElement
public class MyFile {

    private String name;
    private long fileSizeBytes;
    private long modifiedDate;

    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static MyFile fromFile(File associatedFile) {
        checkNotNull(associatedFile, "File is null");

        MyFile myFile = new MyFile();
        myFile.setName(associatedFile.getName());
        myFile.setModifiedDate(associatedFile.lastModified());
        myFile.setFileSizeBytes(associatedFile.length());

        return myFile;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                ", name='" + name + '\'' +
                ", fileSizeBytes=" + fileSizeBytes +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
