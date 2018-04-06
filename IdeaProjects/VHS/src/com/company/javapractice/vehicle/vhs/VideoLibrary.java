package com.company.javapractice.vehicle.vhs;

import java.util.HashMap;
import java.util.Map;

public class VideoLibrary implements Rentable {

    Map<String, Rentable> videos = new HashMap <>();
    Map<String, Rentable> educations = new HashMap <>();

    public VideoLibrary() {
    }

    public void addVideo(Video video) {
        if (video.getClass() == Video.class) {
            videos.put(video.getTitleMovie(), video);
        }
        if (video.getClass() == EducationVideo.class) {
            educations.put(video.getTitleMovie(), video);
        }
    }

    public Rentable search(String title, boolean isEducationMovie) {
        if (isEducationMovie && educations.containsKey(title)) {
            return educations.get(title);
        } else if (!isEducationMovie && videos.containsKey(title)) {
            return videos.get(title);
        } else {
            try {
                throw new NotFoundException("Sorry, we do not have this movie!");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void printMap() {
        videos.forEach((key, value) -> System.out.println("Videos: " + key + "; " + value));
        educations.forEach((key, value) -> System.out.println("Education videos: " + key + "; " + value));
    }

    @Override
    public String toString() {
        return "Video library contains - " + '\n' +
                "Regular movies: " + videos + '\n' +
                "Education movies: " + educations;
    }

    @Override
    public boolean rentFor(int ageOfRenter, int daysForRent) throws InvalidRentException {
        return false;
    }

    @Override
    public boolean bringBack() {
        return false;
    }
}
