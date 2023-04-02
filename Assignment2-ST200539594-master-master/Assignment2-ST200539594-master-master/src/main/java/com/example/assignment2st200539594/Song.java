package com.example.assignment2st200539594;

import java.util.Calendar;

public class Song {
    /*
    Song class instance variable declarations
     */
    private String title;
    private String author;
    private String album;
    private int releaseYear;
    private String genre;
    private String songKey;


    /**
     * the song class represents a song that the user wants to store in the library, it is the parent of the riff class as there is only one song per riff
     */
    public Song(String title, String author, String album, int releaseYear, String genre, String songKey) {
        setTitle(title);
        setAuthor(author);
        setAlbum(album);
        setReleaseYear(releaseYear);
        setGenre(genre);
        setSongKey(songKey);
    }







    /**
     * getters and setter for the title variable. the setter validates the title entered and ensures that the title is made up of acceptable characters, the length is acceptable, and it is not empty.
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be empty.");
         }

        if (title.length() < 2 || title.length() > 50) {
            throw new IllegalArgumentException("Title must be between 2 and 50 characters.");
        }

        for (char c: title.toCharArray())
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Title contains invalid characters, title can't contain special characters or whitespace");
            }

        this.title = title;
    }









    /**
     * getters and setters for the album, the setter validates that the album field isn't empty and that it is within an acceptable range and contains only acceptable values.
     */
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {

        if (album == null) {
            throw new IllegalArgumentException("Album cannot be empty.");
        }

        if (album.length() < 2 || album.length() > 50) {
            throw new IllegalArgumentException("Album must be between 2 and 50 characters.");
        }

        for (char c: album.toCharArray())
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Album contains invalid characters, album can't contain special characters or whitespace");
            }

        this.album = album;
    }










    /**
     * getters and setter for the author variable, ensures that the author is not empty, proper length, and contains acceptable characters only
     */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {

        if (author == null) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }

        if (author.length() < 2 || album.length() > 50) {
            throw new IllegalArgumentException("Author must be between 2 and 50 characters.");
        }

        for (char c: author.toCharArray())
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Author contains invalid characters, Author can't contain special characters or whitespace");
            }

        this.author = author;
    }







    /**
     * getters and setters for the release year field, the setter ensures that the release year is within an acceptable time frame and not a negative number and throws errors accordingly
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {

        //this gets the current year and stores it in a variable using Calendar
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (releaseYear < 1700 || releaseYear > currentYear) {
            throw new IllegalArgumentException("Release year must be between 1700 and the current year.");
        }

        if (releaseYear < 0) {
            throw new IllegalArgumentException("Release year cannot be negative.");
        }

        this.releaseYear = releaseYear;
    }










    /**
     * genre getters and setters, the genre validation checks that the filed is not null, is in an acceptable range of chars, and contains valid characters
     */
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {

        if (genre == null) {
            throw new IllegalArgumentException("Genre cannot be empty.");
        }

        if (genre.length() < 2 || genre.length() > 50) {
            throw new IllegalArgumentException("Genre must be between 2 and 50 characters.");
        }

        for (char c: genre.toCharArray())
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Genre contains invalid characters, Genre can't contain special characters or whitespace");
            }

        this.genre = genre;
    }









    /**
     * setters and getters for the song key, they ensure if the user decides to enter a song key that it is transformed to uppers case and 2 character long example would be key of C
     */
    public String getSongKey() {
        return songKey;
    }

    public void setSongKey(String songKey) {

        if (songKey.length() > 2) {
            throw new IllegalArgumentException("Key must be 1 or 2 characters.");
        }

        this.songKey = songKey.toUpperCase();
    }
}
