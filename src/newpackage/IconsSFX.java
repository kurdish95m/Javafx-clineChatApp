package newpackage;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IconsSFX {
    public static final String ICON_IMAGE_LOC = "/img/icon.png";
        public static void setStageIcon(Stage stage) {
        stage.getIcons().add(new Image(IconsSFX.ICON_IMAGE_LOC));
    }
}
