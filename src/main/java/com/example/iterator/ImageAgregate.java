package com.example.iterator;

import javafx.scene.image.Image;

import java.io.File;

public class ImageAgregate implements Agreagate{
    private String filetop;
    private Image bi;
    public ImageAgregate(String filetop) {
        this.filetop = filetop;
    }
    @Override
    public ImageIterator getIterator() {
        return new ImageIterator();
    }
    public class ImageIterator implements Iterator{
        private int current = 1;
        private String getRoute(){
            return  filetop + current + ".png";
        }
        public boolean hasNext() {
            File file = new File(getRoute());
            return  file.canRead();
        }

        @Override
        public Image next() {
            Image img = new Image(getRoute());
            current++;
            return img;
        }
    }
}