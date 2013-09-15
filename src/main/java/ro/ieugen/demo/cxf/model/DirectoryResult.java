package ro.ieugen.demo.cxf.model;


import com.google.common.collect.Lists;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DirectoryResult {

    private List<Directory> directories;
    private List<MyFile> myFiles;

    public DirectoryResult() {
        this(Lists.<Directory>newArrayList(), Lists.<MyFile>newArrayList());
    }

    public DirectoryResult(List<Directory> directories, List<MyFile> myFiles) {
        this.directories = directories;
        this.myFiles = myFiles;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }

    public List<MyFile> getMyFiles() {
        return myFiles;
    }

    public void setMyFiles(List<MyFile> myFiles) {
        this.myFiles = myFiles;
    }

    @Override
    public String toString() {
        return "DirectoryResult{" +
                "directories=" + directories +
                ", myFiles=" + myFiles +
                '}';
    }
}
