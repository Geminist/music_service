package music.service.jamendo;

import com.fasterxml.jackson.databind.ObjectMapper;
import music.entity.Track;
import music.service.jamendo.util.JamendoFinder;
import music.service.jamendo.util.JamendoJSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JamendoService {

    private static final String LINK = "https://api.jamendo.com/v3.0/tracks/";

    private List<Track> getTracks(JamendoFinder finder) {
        try {
            URL url = new URL(LINK + finder.toURL());

            ObjectMapper mapper = new ObjectMapper();

            JamendoJSONObject obj = mapper.readValue(url, JamendoJSONObject.class);

            return Arrays.stream(obj.getResults())
                    .map(track -> new Track(
                            track.getId(),
                            track.getArtist_name(),
                            track.getName(),
                            track.getAudiodownload().toString()))
                    .collect(Collectors.toList());
        } catch (IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Track> find(String req) {
        JamendoFinder jf = JamendoFinder.newBuilder().client_id("a93e103b").format(JamendoFinder.Format.jsonpretty).fullcount(true).namesearch(req).build();
        return getTracks(jf);
    }
}
