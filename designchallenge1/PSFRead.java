package designchallenge1;

import java.util.List;

public class PSFRead extends FileRead {

    @Override
    public void getFilePath() {
        super.getFilePath();
    }

    @Override
    List<Event> fileLoad() {
        System.out.println(super.filePath + "\n\n\n");
        return null;
    }
}
