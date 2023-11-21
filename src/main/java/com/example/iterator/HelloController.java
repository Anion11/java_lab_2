package com.example.iterator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    public javafx.scene.image.ImageView imageView;
    ImageAgregate slides = new ImageAgregate("/");
    Iterator iterator = slides.getIterator();
    @FXML
    protected void onHelloButtonClick() {
        if (iterator.hasNext()){
            imageView.setImage(iterator.next());
        }
    }
}