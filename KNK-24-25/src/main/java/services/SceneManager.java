package services;

import java10.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

// nje klase statike, ka vetem 1 inicializim, rrjedhimisht ska nevoje me kriju objekte per to se veq 1 her na vyn mu deklaru
public class SceneManager {
    private static SceneManager sceneManager;
    private Scene scene;    // shiko HomePageController, rreshti 18. e krijum antarin statik; e inicializojm kur e krijojm skenen. nese e kena ni antar statik, krijohet ne nje adrese ne memorie, e mo si ndrron adresa, rrjedhimisht i qasemi kur dojm, permes klases

    private SceneManager(Scene scene) {  // pe bojm privat, se me leju me kriju vetem 1 instance
        this.scene = scene;
    }

    public static void initialize(Scene scene) {
        sceneManager = new SceneManager(scene);
    }

    public static void load(String path) throws Exception {
        if(sceneManager == null) {   // duhet mu siguru fillimisht a u deklaru, tani me vazhdu me ju qas metodes private loadParent
            throw new Exception("Scene Manager is not initialized yet");
        }
        sceneManager.loadParent(path);   // else
    }

    public static void load(String path, Pane pane) throws Exception {
        if(sceneManager == null) {   // duhet mu siguru fillimisht a u deklaru, tani me vazhdu me ju qas metodes private loadParent
            throw new Exception("Scene Manager is not initialized yet");
        }
        sceneManager.loadParent(path, pane);   // else
    }



    private void loadParent(String path) throws Exception {
        Parent parent = getParent(path);
        scene.setRoot(parent);
    }

    // sillet si klase statike, por eshte klase konkrete - klase e cila ka vetem 1 objekt (spe di cila)
    private void loadParent(String path, Pane pane) throws Exception {  // ksaj metode i qasemi permes nje objekti qe e kemi deklaru brenda klases (sceneManager)
        pane.getChildren().clear();

        Parent parent = getParent(path);
        pane.getChildren().add(parent);
    }

    private Parent getParent(String path) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                this.getClass().getResource(path)    // sun i thu this.getClass se fjala this sperdoret te antart statik se ata jane veq 1?  tash mun i thu se sosht public static void, po private
        );
        return loader.load();
    }

}
