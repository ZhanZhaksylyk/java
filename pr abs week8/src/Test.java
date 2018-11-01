import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application{

    private BorderPane borderPane = new BorderPane();
    private VBox vBox = new VBox();
    private Button copyButton = new Button("Copy");
    private Button cutButton = new Button("Cut");
    private Button pasteButton = new Button("Paste");
    private Button undoButton = new Button("Undo");
    private static TextArea textArea = new TextArea();

    private SimpleRemoteControl remoteControl = new SimpleRemoteControl();

    private Text text = new Text();
    private Command copyCommand = new Copy(text);
    private Command cutCommand = new Cut(text);
    private Command pasteCommand = new Paste(text);

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        textArea.setWrapText(true);

        remoteControl.setCommand(0, copyCommand);
        remoteControl.setCommand(1, cutCommand);
        remoteControl.setCommand(2, pasteCommand);

        borderPane.setPadding(new Insets(20));

        vBox.setSpacing(20);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().addAll(copyButton, cutButton, pasteButton, undoButton);

        borderPane.setCenter(textArea);
        borderPane.setRight(vBox);
        borderPane.setStyle("-fx-background-color:#808080;");
        Scene scene = new Scene(borderPane, 500, 300);

        primaryStage.setScene(scene);
        primaryStage.show();

        copyButton.setOnAction(e -> {
            text.oldText = textArea.getText();
            text.indexRange = textArea.getSelection();
            text.text = textArea.getSelectedText();

            remoteControl.buttonWasPressed(0);
        });

        cutButton.setOnAction(e -> {
            text.oldText = textArea.getText();
            text.text = textArea.getSelectedText();
            text.indexRange = textArea.getSelection();

            remoteControl.buttonWasPressed(1);
            textArea.setText(text.toDisplay);
        });

        pasteButton.setOnAction(e -> {
            text.oldText = textArea.getText();
            text.indexRange = textArea.getSelection();

            remoteControl.buttonWasPressed(2);
            textArea.setText(text.toDisplay);
        });

        undoButton.setOnAction(e -> {
            remoteControl.undoButtonWasPressed();
            textArea.setText(text.toDisplay);
        });

    }
}