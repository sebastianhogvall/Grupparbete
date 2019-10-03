package sample;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import static java.awt.Color.white;
import static java.awt.Color.yellow;

public class Controller {


    public void Textfield(Stage s) throws Exception {

        s.setTitle("Notepad(ish)");
        TextArea box = new TextArea();
        // String text = b.getText();

        VBox vbox = new VBox(box);

        Scene scene = new Scene(vbox, 400, 400);
        s.setScene(scene);
        s.show();

        Button save = new Button("Save to Desktop");
        save.setMinWidth(50);
        Button load = new Button("Load From Desktop");
        load.setMinWidth(50);
        Button new1 = new Button("New File");
        new1.setMinWidth(50);


        save.setOnAction(action -> {

            s.setTitle("Choose Filename");

            String saveToFile = box.getText();

            String file = "file";

            save(saveToFile,s);


            box.setText("Saved to " + file);
        });

        load.setOnAction(action -> {

            s.setTitle("Loaded from Desktop");




            try {
                box.setText(Load("file",s));
            } catch (Exception e) {
                box.setText("NO File found");
            }
        });

        new1.setOnAction(action -> {
            box.setText("New file");
        });


        BorderPane border = new BorderPane();
        HBox textbox = new HBox(box);
        HBox buttons = new HBox(save,load,new1);

        buttons.setStyle("-fx-background-color: #336699;");
        border.setCenter(textbox);
        border.setTop(buttons);


        Scene scene2 = new Scene(border, 400, 400);

        s.setScene(scene2);
        s.show();
    }


    public void save(String saveToFile,Stage s) {

        FileChooser fileChooser = new FileChooser();
        File files = fileChooser.showSaveDialog(s);

        try {

            FileWriter fw = new FileWriter(files);

            fw.write(saveToFile);
            fw.close();


        } catch (Exception e) {

        }
    }

    public String Load(String fileName,Stage s) throws Exception {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(s);


        FileReader Fr = new FileReader(selectedFile);
        StringBuilder laddare = new StringBuilder();
        int i;
        while ((i = Fr.read()) != -1)
            laddare.append((char) i);
        Fr.close();
        String load = laddare.toString();

        return load;


    }


}
