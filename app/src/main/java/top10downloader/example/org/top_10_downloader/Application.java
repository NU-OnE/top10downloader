package top10downloader.example.org.top_10_downloader;

import android.support.annotation.Nullable;

/**
 * Created by work on 26.03.16.
 */
public class Application {
    @Nullable
    private  String name;

    @Nullable
    private  String artist;

    @Nullable
    private String releaseDate;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Nullable
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String toString(){
        return "name: "+this.name+"\n"+
                "artist: "+ this.artist +"\n"+
                "date: "+ this.releaseDate +"\n"+
                "image: "+ this.image;

    }
}
