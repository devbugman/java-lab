package kr.devbugman.convert;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plays", columnDefinition = "TEXT")
    @Convert(converter = PlayConverter.class)
    private List<Long> plays = new ArrayList<>();

    public void addPlay(final Play play) {
        plays.add(play.getId());
    }

    public boolean isSamePlayId(final Long id) {
        return plays.stream().anyMatch(it -> isSamePlayId(it, id));
    }

    private boolean isSamePlayId(final Long playId, final Long otherId) {
        return playId.equals(otherId);
    }

    public String playsToString() {
        return plays.toString();
    }

    public Long getId() {
        return id;
    }

    public List<Long> getPlays() {
        return plays;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final PlayList playList)) {
            return false;
        }
        return Objects.equals(getId(), playList.getId()) && Objects.equals(getPlays(),
            playList.getPlays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plays);
    }
}
