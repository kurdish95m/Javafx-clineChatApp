package com.krd.notificationSong;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class SongEvent {

    public SongEvent() {
    }
    static SongEvent se = null;

    public static SongEvent getInstance() {
        if (se == null) {
            se = new SongEvent();
        }
        return se;
    }

//    double getVolume() {
//        return Double.parseDouble(
//                Objects.requireNonNull(SettingProperties.get()).getVolume());
//    }
    private void play(String path) {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Objects.requireNonNull(getClass().getResource(path)).toString()));
        //mediaPlayer.setVolume(getVolume());
        mediaPlayer.setVolume(1);
        mediaPlayer.play();
    }

    public void onScanBarcodeClicked() {
        play("onScanBarcodeClicked.mp3");
        System.out.println("onScanBarcodeClicked barcoding song  ... ");
    }

    public void onScanBarcodeClickedTwo() {
        play("onScanBarcodeClickedv2.mp3");
        System.out.println("onScanBarcodeClickedTwo barcoding song  ... ");
    }

    public void onComplet() {
        play("zapsplat_multimedia_alert_notification_message_or_pop_up_001_45047.mp3");
        System.out.println("onComplet compliting song  ... ");
    }

    public void onClickOne() {
        play("zapsplat_technology_computer_mouse_click_apple_001_47277.mp3");
        System.out.println("onClickOne clicking song  ... ");
    }

    public void onClickTwo() {
        play("zapsplat_technology_computer_mouse_click_apple_002_47278.mp3");
        System.out.println("onClickTwo clicking song  ... ");
    }

    public void onMessage() {
        play("Windows Notify Messaging.wav");
        System.out.println("onMessage Messaging song  ... ");
    }

    public void onWindowsError() {
        play("Windows Error.wav");
        System.out.println("onWindowsError Erroring song  ... ");
    }

    public void onDelete() {
        play("Windows Recycle.wav");
        System.out.println("onDelete deleteing song  ... ");
    }

    public void onKeyType() {
        play("onKeyType.mp3");
        System.out.println("onKeyType typing song ... ");
    }

    public void onInsert() {
        play("success_short insert.mp3");
        System.out.println("onDelete deleteing song  ... ");
    }

    public void onUpdate() {
        play("success_003 update.mp3");
        System.out.println("onDelete deleteing song  ... ");
    }



    public void onKeyType(TextField[] textFields) {

        for (TextField tf : textFields) {
            tf.setOnKeyTyped((KeyEvent event) -> onKeyType());
        }
    }
//    public void onKeyType(JFXTextField[] textFields) {
//        for (JFXTextField tf : textFields) {
//            tf.setOnKeyTyped((KeyEvent event) -> onKeyType());
//        }
//    }
//    public void onKeyType(JFXPasswordField[] passwordFields) {
//        for (JFXPasswordField tf : passwordFields) {
//            tf.setOnKeyTyped((KeyEvent event) -> onKeyType());
//        }
//    }

    public void onKeyType(PasswordField[] passwordFields) {
        for (PasswordField tf : passwordFields) {
            tf.setOnKeyTyped((KeyEvent event) -> onKeyType());
        }
    }

}
