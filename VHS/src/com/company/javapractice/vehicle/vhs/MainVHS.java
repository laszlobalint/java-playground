package com.company.javapractice.vehicle.vhs;

import java.io.*;
import java.util.Map;

public class MainVHS {

    public static void main(String[] args) {
        VideoLibrary library = new VideoLibrary();
        int movieCount = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./src/input.txt"));
            String line;
            line = reader.readLine();
            movieCount = Integer.parseInt(line);
            System.out.println("The number of movies in the library: " + movieCount);
            int makeMovies = 0;
            while (makeMovies != movieCount) {
                line = reader.readLine();
                String[] details = line.split(";");
                if (details.length == 3) {
                    Video video = new Video(details[0], details[1], Integer.parseInt(details[2]));
                    library.addVideo(video);
                    makeMovies++;
                } else if (details.length == 2) {
                    EducationVideo education = new EducationVideo((details[0]), details[1]);
                    library.addVideo(education);
                    makeMovies++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        library.printMap();
        System.out.println(library.search("Matrix", false));
        System.out.println(library.search("Mission: impossible", false));
        System.out.println(library.search("Anal Attack", true));
        rentVideos(library);
        serialize(library);
    }

    public static VideoLibrary rentVideos(VideoLibrary library) {
        library.videos.forEach((key, value) -> {
            int randomAge = (int) (Math.random() * 100 + 1);
            int randomRentFor = (int) (Math.random() * 5 + 1);
            try {
                library.videos.get(key).rentFor(randomAge, randomRentFor);
                System.out.println(library.videos.get(key));
            } catch (InvalidRentException r) {
                r.printStackTrace();
            }

        });
        library.educations.forEach((key, value) -> {
            int randomAge = (int) (Math.random() * 100 + 1);
            int randomRentFor = (int) (Math.random() * 5 + 1);
            try {
                library.educations.get(key).rentFor(randomAge, randomRentFor);
                System.out.println(library.educations.get(key));
            } catch (InvalidRentException r) {
                r.printStackTrace();
            }
        });
        return library;
    }

    public static void serialize(VideoLibrary library) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("./src/videoLibrary.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(library.videos);
            out.writeObject(library.educations);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /src/videoLibrary.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

        /*
        Video transporter = new Video("The Transporter", "One-day", 16);
        Video matrix = new Video("Matrix", "Two-day", 12);
        EducationVideo anal = new EducationVideo("Anal Attack", "Unlimited");
        library.addVideo(transporter);
        library.addVideo(matrix);
        library.addVideo(anal);
        System.out.println(transporter);
        System.out.println(library.search("Matrix", false));
        System.out.println(library.search("Mission: impossible", false));
        matrix.bringBack();
        try {
            System.out.println(matrix.rentFor(31, 1));
        } catch (InvalidRentException e) {
            e.printStackTrace();
        } */