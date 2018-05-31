/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxtamsu;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author xuanhung
 */
public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ListView<TamSu> listView = new ListView<>();
        ArrayList<TamSu> list = CrawlerMot.getTin("https://vnexpress.net/rss/tam-su.rss");
        for (TamSu tamSu : list) {
            listView.getItems().add(tamSu);
        }
        listView.setCellFactory(new Callback<ListView<TamSu>, ListCell<TamSu>>() {
            @Override
            public ListCell<TamSu> call(ListView<TamSu> param) {
                ListCell<TamSu> cell = new ListCell<TamSu>() {
                    @Override
                    protected void updateItem(TamSu item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            Image img = new Image(item.getImage(), 70, 70, false, false);
                            ImageView imgView = new ImageView(img);
                            setGraphic(imgView);

                            setText(item.getTitle());
                        }
                    }
                };
                return cell;
            }
        });
//        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                KhoaiTin tin = listView.getSelectionModel().getSelectedItem();
//                EuroWindows.display(tin);
//            }
//        });

        Scene scene = new Scene(listView, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
