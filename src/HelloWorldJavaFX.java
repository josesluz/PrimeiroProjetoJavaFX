import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloWorldJavaFX extends Application{
    
    public static void main(String[] args) {
        launch();
    }
    
    String musica = getClass().getResource("TeatroMagico.mp3").toString();
            
    @Override
    public void start (Stage palco) {
        //Trilha Sonora
        AudioClip clip = new AudioClip(musica);
        clip.play();
        //Personagem
        Rectangle ceu = new Rectangle(900, 450, Color.DARKRED);
        Rectangle mar = new Rectangle(900, 450, Color.DARKBLUE);
        Circle sol = new Circle(90, Color.YELLOW);
        //Posicionamento
        ceu.setTranslateY(-200);
        mar.setTranslateY(200);
        sol.setTranslateY(50);
        //Movimento Sol
        TranslateTransition mov = new TranslateTransition(Duration.millis(6000), sol);
        mov.setByY(-300);
        mov.setCycleCount(Timeline.INDEFINITE);
        mov.setAutoReverse(true);
        mov.play();
        //Animação de Transição
        FadeTransition ft = new FadeTransition(Duration.millis(6000), ceu);
        ft.setFromValue(1.0);
        ft.setToValue(0.5);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        //CSS
        mar.setStyle("-fx-fill: "
            + "linear-gradient(#7FFFD4, #00CED1),"
            + "linear-gradient(#008B8B, #2F4F4F),"
            + "linear-gradient(#00CED1 0%, #20B2AA 50%, #0000CD 100%),"
            + "linear-gradient(from 0% 0% to 55% 50%, "
            + "rgba(255,255,255,0.9), rgba(255,255,255,0));");

        ceu.setStyle("-fx-fill: "
            + "linear-gradient(#efaa22, #ffea6a),"
            + "linear-gradient(#f2ba44, #ffef84),"
            + "linear-gradient(#e68400, #ffd65b),"
            + "linear-gradient(#ffe657 100%, #f8c202 50%, #eea10b 0%),"
            + "linear-gradient(from 0% 0% to 55% 50%, "
            + "rgba(255,255,255,0.9), rgba(255,255,255,0));");

        //História
        StackPane historia = new StackPane();
        historia.getChildren().addAll(ceu, sol, mar);
        //Cena
        Scene cena = new Scene(historia, 900, 900);
        //Colocando a cena no palco
        palco.setScene(cena);
        palco.setTitle("Paramares");
        palco.show();
    }
    
}