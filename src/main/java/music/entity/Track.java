package music.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tracks")
public class Track{

    @Id
    @NaturalId
    @Column(name = "trackId")
    Integer trackId;

    @NotEmpty
    @NotNull
    @Column(name = "author")
    String author;

    @NotEmpty
    @NotNull
    @Column(name = "name")
    String name;

    @NotEmpty
    @NotNull
    @Column(name = "trackURL")
    String trackURL;

    protected Track() {}

    public Track(
            @NotEmpty @NotNull Integer trackId,
            @NotEmpty @NotNull String author,
            @NotEmpty @NotNull String name,
            @NotEmpty @NotNull String trackURL) {
        this.trackId = trackId;
        this.author = author;
        this.name = name;
        this.trackURL = trackURL;
    }

    @Override
    public String toString() {
        return String.format("JamendoTrack[trackId=%d, author=%s, name=%s, trackURL='%s']",
                trackId, author, name, trackURL);
    }
}
