package ro.ieugen.demo.cxf.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileResult {

    private String name;
    private String extension;
    private long fileSizeBytes;
    private long timeStamp;
    private boolean isTextFile;
    private byte[] content;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public boolean isTextFile() {
        return isTextFile;
    }

    public void setTextFile(boolean textFile) {
        isTextFile = textFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
