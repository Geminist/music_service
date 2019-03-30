package music.controller;

import music.entity.Track;
import music.exception.NotFoundException;
import music.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    private MusicService musicService;

    public MusicController(MusicService musicService){
        this.musicService = musicService;
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handleException (NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/")
    public String hello(){
        return "this is a music service";
    }

    @GetMapping(value = "/tracks", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Track> getTracks(
            @RequestParam(name = "search_name") String request){
        return musicService.findTrack(request);
    }

    @PostMapping(value = "/tracks/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addSong(@RequestBody Track track){
        musicService.save(track);
    }
}
