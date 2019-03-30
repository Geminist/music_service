package music;

import music.controller.MusicController;
import music.service.MusicService;
import music.service.jamendo.JamendoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicControllerConfiguration {

    @Bean
    public JamendoService jamendoService(){
        return new JamendoService();
    }

    @Bean
    public MusicService musicService(){
        return new MusicService();
    }

    @Bean
    public MusicController musicController(final MusicService musicService){
        return new MusicController(musicService);
    }
}
