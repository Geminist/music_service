package music.service;

import music.entity.Track;
import music.exception.NotFoundException;
import music.repository.TrackRepository;
import music.service.jamendo.JamendoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("musicService")
public class MusicService {

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    JamendoService jamendoService;

    public List<Track> findTrack(String request){
        List<Track> tracks = jamendoService.find(request);
        if(tracks == null) throw new NotFoundException("no tracks found");
        return tracks;
    }

    public void save(Track track){
        trackRepository.save(track);
    }
}
