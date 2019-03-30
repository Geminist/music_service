package music.service.jamendo.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JamendoTrack {
    int id;
    String name;
    int artist_id;
    String artist_name;
    String album_name;
    int album_id;
    URL album_image;
    URL audiodownload;

    public JamendoTrack(int id, String name, int artist_id, String artist_name, String album_name, int album_id, URL album_image, URL audiodownload) {
        this.id = id;
        this.name = name;
        this.artist_id = artist_id;
        this.artist_name = artist_name;
        this.album_name = album_name;
        this.album_id = album_id;
        this.album_image = album_image;
        this.audiodownload = audiodownload;
    }

    public JamendoTrack() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public URL getAlbum_image() {
        return album_image;
    }

    public void setAlbum_image(URL album_image) {
        this.album_image = album_image;
    }

    public URL getAudiodownload() {
        return audiodownload;
    }

    public void setAudiodownload(URL audiodownload) {
        this.audiodownload = audiodownload;
    }
}
