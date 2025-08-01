package org.mmf.webpagescraperapi.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class EscapeRoomScenario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String address;
    private String difficulty;
    private String genre;
    private String link;

    @Column(name = "image_url")
    private String imageUrl;

    public EscapeRoomScenario() {
    }

    public EscapeRoomScenario(String title, String address, String difficulty, String genre, String link, String imageUrl) {
        this.title = title;
        this.address = address;
        this.difficulty = difficulty;
        this.genre = genre;
        this.link = link;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EscapeRoomScenario that = (EscapeRoomScenario) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(address, that.address) && Objects.equals(difficulty, that.difficulty) && Objects.equals(genre, that.genre) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, address, difficulty, genre, link);
    }

    @Override
    public String toString() {
        return "(" + title + ',' + address + ',' + difficulty + ',' + genre + "," + link + ')';
    }
}
