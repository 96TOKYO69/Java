package org.example.zadanie2Var5;

import org.example.zadanie2Var5.model.*;
import org.example.zadanie2Var5.service.Album;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestUnut2 {

    @Test
    void testAddTrack() {
        Album album = new Album();
        MusicTrack track = new RockTrack("Bohemian Rhapsody", 5.55);

        album.addTrack(track);
        assertEquals(1, album.findTracksByDuration(0, 10).size());
        assertTrue(album.findTracksByDuration(0, 10).contains(track));
    }

    @Test
    void testGetTotalDuration() {
        Album album = new Album();
        album.addTrack(new RockTrack("Bohemian Rhapsody", 5.55));
        album.addTrack(new PopTrack("Thriller", 5.57));

        double totalDuration = album.getTotalDuration();
        assertEquals(11.12, totalDuration, 0.01);
    }

    @Test
    void testSortTracksByStyle() {
        Album album = new Album();
        album.addTrack(new JazzTrack("Take Five", 5.24));
        album.addTrack(new RockTrack("Stairway to Heaven", 8.02));
        album.addTrack(new PopTrack("Thriller", 5.57));

        album.sortTracksByStyle();

        List<MusicTrack> sortedTracks = album.findTracksByDuration(0, 10);
        assertEquals("Jazz", sortedTracks.get(0).getGenre());
        assertEquals("Pop", sortedTracks.get(1).getGenre());
        assertEquals("Rock", sortedTracks.get(2).getGenre());
    }

    @Test
    void testFindTracksByDuration() {
        Album album = new Album();
        album.addTrack(new RockTrack("Bohemian Rhapsody", 5.55));
        album.addTrack(new PopTrack("Thriller", 5.57));
        album.addTrack(new JazzTrack("Take Five", 5.24));
        album.addTrack(new RockTrack("Stairway to Heaven", 8.02));

        List<MusicTrack> foundTracks = album.findTracksByDuration(5.5, 6.0);

        assertEquals(2, foundTracks.size());
        assertTrue(foundTracks.stream().anyMatch(t -> t.getTitle().equals("Bohemian Rhapsody")));
        assertTrue(foundTracks.stream().anyMatch(t -> t.getTitle().equals("Thriller")));
    }

    @Test
    void testPrintTracks() {
        Album album = new Album();
        album.addTrack(new RockTrack("Bohemian Rhapsody", 5.55));
        album.addTrack(new PopTrack("Thriller", 5.57));

        // Redirect System.out to capture output
        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        album.printTracks();

        String output = outputStream.toString();
        System.setOut(System.out);

        assertTrue(output.contains("Bohemian Rhapsody"));
        assertTrue(output.contains("Thriller"));
    }
}
