package org.example.zadanie2Var5.model;

public abstract class MusicTrack {
    private String title;
    private double duration;
    private String genre; // Добавляем поле для жанра

    public MusicTrack(String title, double duration, String genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() { // Добавляем геттер для жанра
        return genre;
    }

    @Override
    public String toString() {
        return String.format("Track: %s | Duration: %.2f min | Genre: %s", title, duration, genre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MusicTrack that = (MusicTrack) obj;
        return Double.compare(that.duration, duration) == 0 &&
                title.equals(that.title) &&
                genre.equals(that.genre);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + Double.hashCode(duration);
        result = 31 * result + genre.hashCode();
        return result;
    }
}