package com.example.iterator;

import javafx.scene.image.Image;

public interface Iterator {
    public boolean hasNext();
    public boolean hasPreview();
    public Image preview();
    public Image next();
    public Image startImage();
    public Image endImage();
}
