package designchallenge1;

import javax.swing.*;
import java.util.List;

public abstract class FileRead {

    protected String filePath;

    public void getFilePath() {
        JFileChooser fileChooser = new JFileChooser();
        int nResp = fileChooser.showOpenDialog(null);
        if (nResp == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().toString();
        } else {
            System.out.println("FAILED TO GET FILE PATH");
        }
    }
    abstract List<Event> fileLoad();

}
