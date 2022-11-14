package com.my.jpastudy.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ItemTest {

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("상속관계 매핑 Book으로 저장")
    void saveBookTest() {
        Book book = Book.builder()
                .author("김영한")
                .isbn("book-isbn")
                .name("자바 ORM 표준 JPA 프로그래밍")
                .price(43000)
                .build();
        em.persist(book);
        em.flush();
        em.clear();
        Book findBook = (Book) em.find(Item.class, book.getId()); // casting
//        Book findBook = em.find(Book.class, book.getId());

        assertThat(findBook.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(findBook.getName()).isEqualTo(book.getName());
        assertThat(findBook.getPrice()).isEqualTo(book.getPrice());
    }

    @Test
    @DisplayName("상속관계 매핑 Album으로 저장")
    void saveAlbumTest() {
        Album album = Album.builder()
                .artist("블랙핑크")
                .name("BORN PINK")
                .price(50000)
                .build();
        em.persist(album);
        em.flush();
        em.clear();

        Album findAlbum = em.find(Album.class, album.getId());

        assertThat(findAlbum.getArtist()).isEqualTo("블랙핑크");
    }
    @Test
    @DisplayName("상속관계 매핑 Movie으로 저장")
    void saveMovieTest() {
        Movie movie = Movie.builder()
                .director("데이비드 핀처")
                .actor("제시 아이젠버그")
                .name("소셜 네트워크")
                .price(4000)
                .build();

        em.persist(movie);
        em.flush();
        em.clear();

        Movie findMovie = em.find(Movie.class, movie.getId());

        assertThat(findMovie.getDirector()).isEqualTo("데이비드 핀처");
        assertThat(findMovie.getId()).isEqualTo(movie.getId());
    }

    @Test
    @DisplayName("@MappedSuperclass 를 상속할 시 칼럼이 추가된다")
    void superMappedTest() {
        Album album = Album.builder()
                .artist("블랙핑크")
                .name("BORN PINK")
                .price(50000)
                .build();
        em.persist(album);

        assertThat(album.getCreatedDate()).isNull();
        assertThat(album.getModifiedDate()).isNull();

    }
}