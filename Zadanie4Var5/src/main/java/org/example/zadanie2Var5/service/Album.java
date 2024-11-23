package org.example.zadanie2Var5.service;

import org.example.zadanie2Var5.model.MusicTrack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Album {
    private List<MusicTrack> tracks;

    public Album() {
        tracks = new ArrayList<>();
    }

    public void addTrack(MusicTrack track) {
        tracks.add(track);
    }

    public double getTotalDuration() {
        return tracks.stream().mapToDouble(MusicTrack::getDuration).sum();
    }

    public void sortTracksByStyle() {
        tracks.sort(Comparator.comparing(MusicTrack::getGenre));
    }

    public List<MusicTrack> findTracksByDuration(double min, double max) {
        List<MusicTrack> result = new ArrayList<>();
        for (MusicTrack track : tracks) {
            if (track.getDuration() >= min && track.getDuration() <= max) {
                result.add(track);
            }
        }
        return result;
    }

    public List<MusicTrack> getTracks() {
        return new ArrayList<>(tracks);
    }
}
