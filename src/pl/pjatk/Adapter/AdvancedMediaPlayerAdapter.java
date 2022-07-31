package pl.pjatk.Adapter;

public class AdvancedMediaPlayerAdapter implements MediaPlayerInterface {
    AdvancedMediaPlayerInterface advancedMusicPlayer;

    public AdvancedMediaPlayerAdapter(AdvancedMediaPlayerInterface myMediaPlayer) {
        this.advancedMusicPlayer = myMediaPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        advancedMusicPlayer.loadFilename(fileName);
        advancedMusicPlayer.listen();
    }
}
