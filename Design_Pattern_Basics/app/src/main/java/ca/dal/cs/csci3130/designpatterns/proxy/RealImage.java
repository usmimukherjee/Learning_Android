package ca.dal.cs.csci3130.designpatterns.proxy;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        this.loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading from disk: " + fileName);
    }

}
