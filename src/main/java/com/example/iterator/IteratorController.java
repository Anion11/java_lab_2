package com.example.iterator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class IteratorController {
    public javafx.scene.image.ImageView imageView;
    public TextField inputDelay;
    Timeline time = new Timeline();
    ImageAgregate slides = new ImageAgregate("src/main/resources/");
    Iterator iterator = slides.getIterator();
    @FXML
    protected void onNextButtonClick() {
        if (iterator.hasNext()) imageView.setImage(iterator.next());
        else imageView.setImage(iterator.startImage());
    }
    public void onPrevButtonClick(ActionEvent actionEvent) {
        if (iterator.hasPreview()) imageView.setImage(iterator.preview());
        else imageView.setImage(iterator.endImage());
    }
    public void onStartButtonClick(ActionEvent actionEvent) {
        int delay = Integer.parseInt(inputDelay.getText());
        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(new KeyFrame(Duration.seconds(delay), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (iterator.hasNext()) imageView.setImage(iterator.next());
                else imageView.setImage(iterator.startImage());
            }
        }));
        time.play();
    }

    public void onStopButtonClick(ActionEvent actionEvent) {
        time.stop();
        time.getKeyFrames().clear();
    }
}