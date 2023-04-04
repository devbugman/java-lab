package kr.devbugman.convert;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PlayListRepositoryTest {

    @Autowired private PlayRepository playRepository;

    @Autowired private PlayListRepository playListRepository;

    @PersistenceContext private EntityManager em;

    @Test
    void emptyStringPlays() {
        final PlayList playList = playListRepository.save(new PlayList());

        assertThat(playList.playsToString()).isEqualTo("[]");
    }

    @Test
    void convertPlays() {
        final Play play = playRepository.save(new Play("BLACK"));
        final Play play1 = playRepository.save(new Play("IMAGE"));
        final Play play2 = playRepository.save(new Play("SUuu"));

        final PlayList playList = new PlayList();
        StringBuilder sb = new StringBuilder();
        final String expected = sb.append("[")
            .append(play.getId()).append(", ")
            .append(play1.getId()).append(", ")
            .append(play2.getId()).append("]")
            .toString();

        playList.addPlay(play);
        playList.addPlay(play1);
        playList.addPlay(play2);
        playListRepository.save(playList);

        em.flush();
        em.clear();

        final PlayList findPlayList =
            playListRepository.findById(playList.getId()).get();

        assertThat(findPlayList.playsToString()).isEqualTo(expected);
    }
}