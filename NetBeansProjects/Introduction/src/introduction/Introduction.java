package introduction;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Introduction extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane pane1 = new StackPane();
        pane1.getChildren().add(new Button("First Button"));
        Scene scene1 = new Scene(pane1, 300, 50);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("First Stage");
        primaryStage.show();
        
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(new Button("Second Button"), 300, 100));
        stage2.show();
        
        Stage stage3 = new Stage();
        Circle circle1 = new Circle();
        Pane pane3 = new Pane();
        
        circle1.setRadius(50);
        // circle1.setCenterX(70);
        // circle1.setCenterY(70);
        circle1.centerXProperty().bind(pane3.widthProperty().divide(2));
        circle1.centerYProperty().bind(pane3.heightProperty().divide(2));
        circle1.setFill(Color.WHITE);
      
        Color color1 = new Color(0.7, 0.2, 0.5, 0.5);
        Color color2 = color1.brighter();
        circle1.setFill(color1);
        circle1.setStyle("-fx-fill:green;-fx-stroke:red;");
        
        pane3.getChildren().add(circle1);
        stage3.setScene(new Scene(pane3, 300, 300));
        stage3.setTitle("Third Stage");
        stage3.show();
        
        StackPane pane2 = new StackPane();
        Image image = new Image("www.picture.com/pic.svg");
        ImageView imageView = new ImageView(image);
        pane2.getChildren().add(imageView);
        pane2.setAlignment(imageView, Pos.TOP_LEFT);
        
        imageView.fitWidthProperty().bind(pane2.widthProperty());
        
        Scene scene2 = new Scene(pane2, 1200, 800);
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Our program");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
