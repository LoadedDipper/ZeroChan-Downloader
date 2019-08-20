package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField pageURL;
    @FXML
    private TextField folderPath;

    @FXML
    public void onDownload(){
        zeroChanDownloader download = new zeroChanDownloader();
        download.downloadImages(pageURL.getText(), folderPath.getText());
    }
}
