package com.example.iterator;

import javafx.scene.image.Image;

import java.io.File;
import java.nio.file.Paths;

public class ImageAgregate implements Agreagate{
    private final String filetop;
    public ImageAgregate(String filetop) {
        this.filetop = filetop;
    }
    @Override
    public ImageIterator getIterator() {
        return new ImageIterator();
    }
    public class ImageIterator implements Iterator {
        private int current = 0;
        private String getRoute(int i){
            return Paths.get(filetop + i + ".png").toUri().toString();
        }
        public boolean hasNext() {
            return !new Image(getRoute(current + 1)).isError();
        }
        @Override
        public boolean hasPreview() {
            return !new Image(getRoute(current - 1)).isError();
        }
        @Override
        public Image next() {
            return new Image(getRoute(++current));
        }
        @Override
        public Image preview() {
            return new Image(getRoute(--current));
        }
        public Image startImage() {
            current = 1;
            return new Image(getRoute(current));
        }
        @Override
        public Image endImage() {
            current = 3;
            return new Image(getRoute(current));
        }
    }
}