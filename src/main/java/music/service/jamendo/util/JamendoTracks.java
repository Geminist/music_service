package music.service.jamendo.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JamendoTracks {

    JamendoTrack[] jamendoTracks;

    public JamendoTracks(JamendoTrack[] jamendoTracks) {
        this.jamendoTracks = jamendoTracks;
    }

    public JamendoTracks(){

    }

    public JamendoTrack[] getJamendoTracks() {
        return jamendoTracks;
    }

    public void setJamendoTracks(JamendoTrack[] jamendoTracks) {
        this.jamendoTracks = jamendoTracks;
    }
}
