package com.example.assignment2st200539594;

public class Riff extends Song {

    /**
     * riff class instance variable declarations
     */
    private String riffImagePath;
    private String difficulty;
    private String capoPosition;
    private int beatsPerMinute;
    private int riffNumber;








    /**
     * riff class constructor, the riff class inherits from the song class as there can be several riffs for each song
     */
    public Riff(String title, String author, String album, int releaseYear, String genre, String songKey, String riffImagePath, String difficulty, String capoPosition, int beatsPerMinute, int riffNumber) {
        super(title, author, album, releaseYear, genre, songKey);
        setRiffImagePath(riffImagePath);
        setDifficulty(difficulty);
        setCapoPosition(capoPosition);
        setBeatsPerMinute(beatsPerMinute);
        setRiffNumber(String.valueOf(riffNumber));
    }









    /**
     * getters and setters for the riff image, ensures that its not null and uses the .pmng extension and is in the format of songNameRiff#
     */
    public String getRiffImagePath() {
        return riffImagePath;
    }

    public void setRiffImagePath(String riffImagePath) {

        if (riffImagePath == null || riffImagePath.isEmpty()) {
            throw new IllegalArgumentException("Image path cannot be null or empty");
        }


        //check if the string matches the format songNameRiff#
       if (!riffImagePath.endsWith(".png") || !riffImagePath.contains("riff") || !riffImagePath.contains(String.valueOf(riffNumber))) {
           throw new IllegalArgumentException("Image path must be in the format: songTitleRiff#");
       }

        this.riffImagePath = riffImagePath;
    }








    /**
     * getters and setters for the difficulty variable, ensures that the difficulty is not empty and that it is less than 8 characters and no whitespace or special characters
     */
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {

        if (difficulty == null) {
            throw new IllegalArgumentException("Difficulty Cannot be empty.");
        }

        if (difficulty.length() > 8) {
            throw new IllegalArgumentException("Difficulty too long, must be no more than 8 characters");
        }

        for (char c: difficulty.toCharArray())
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Difficulty contains invalid characters, Difficulty can't contain special characters or whitespace");
            }

        this.difficulty = difficulty;
    }







    /**
     * getters and setters for the capo position, ensures its within a valid position on the guitar neck and an integer
     */
    public String getCapoPosition() {
        return capoPosition;
    }

    public void setCapoPosition(String capoPosition) {

        try {
            int capo = Integer.parseInt(capoPosition);
            if (capo < 1 || capo > 12) {
                throw new IllegalArgumentException("Capo position must be between 1 and 12.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Capo position must be a valid integer.");
        }

        this.capoPosition = capoPosition;
    }








    /**
     * getters and setters for the beatsPerMin, makes sure that the value is an int
     */
    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }

    public void setBeatsPerMinute(int beatsPerMinute) {

        try {
            Integer.parseInt(String.valueOf(beatsPerMinute));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Beats per minute must be a valid integer.");
        }
        this.beatsPerMinute = beatsPerMinute;
    }






    /**
     * getters and setter for the riff num, ensures that its in an acceptable range and not null and makes sure its an int
     */
    public int getRiffNumber() {
        return riffNumber;
    }

    public void setRiffNumber(String riffNumber) {

        if (riffNumber == null) {
            throw new IllegalArgumentException("Riff number cannot be null");
        }

        try {
            int num = Integer.parseInt(riffNumber);
            if (num < 1 || num > 100) {
                throw new IllegalArgumentException("Riff number must be between 1 and 100.");
            }
            this.riffNumber = num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Riff number must be a valid integer.");
        }
    }

}
