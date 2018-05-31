/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxtamsu;

import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author xuanhung
 */
public class EuroWindows {

    public static void display(TamSu tamSu) {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load(tamSu.getLink());
        Scene scene = new Scene(webView, 600, 600);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
