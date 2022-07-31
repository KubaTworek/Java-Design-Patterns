package pl.pjatk.Adapter;

public class Mp4Player implements AdvancedMediaPlayerInterface{
    private String myFile;

    @Override
    public void loadFilename(String fileName) {
        myFile = fileName;
    }

    @Override
    public void listen() {
        System.out.println("Playing vlc file. Name: " + myFile);
    }
}
