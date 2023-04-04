package com.example.assignment2st200539594;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    private Song song;


    /**
     * Set up for the junit testing class
     */
    @BeforeEach
    void setUp() {
        song = new Song("Crazy Train", "Ozzy Osbourne", "Blizzard of Oz", 1978, "Metal", "F#");
    }







    /**
     * tests for the title
     */
    @Test
    void getTitle() {
    }

    @Test
    void setTitleInvalid() {
        // tesst for empty title
        try {
            song.setTitle("");
            fail("Empty title in setTitle should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught empty genre in setTitle");
        } catch (Exception e) {
            fail("Wrong exception thrown for setGenre");
        }
        // Test for null value
        try {
            song.setTitle(null);
            fail("Null value in setTitle should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught null value in setTitle");
        } catch (Exception e) {
            fail("Wrong exception thrown for setTitle");
        }

        // Test for short title
        try {
            song.setTitle("A");
            fail("Short title in setTitle should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught short title in setTitle");
        } catch (Exception e) {
            fail("Wrong exception thrown for setTitle");
        }

        // Test for long title
        String longTitle = "This is a very long title that exceeds the maximum length allowed";
        try {
            song.setTitle(longTitle);
            fail("Long title in setTitle should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught long title in setTitle");
        } catch (Exception e) {
            fail("Wrong exception thrown for setTitle");
        }

        // Test for special characters
        try {
            song.setTitle("Invalid@Title");
            fail("Title with special characters in setTitle should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught title with special characters in setTitle");
        } catch (Exception e) {
            fail("Wrong exception thrown for setTitle");
        }
    }

    //valid test example for the title
    @Test
    void setTitleValid() {
        String validTitle = "Stairway to Heaven";
        song.setTitle(validTitle);
        assertEquals(validTitle, song.getTitle());
    }










    /**
     * tests for the album
     */
    @Test
    void getAlbum() {
    }

    @Test
    void setAlbumInvalid() {
        // tesst for empty album
        try {
            song.setAlbum("");
            fail("Empty album in setAlbum should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught empty album in setAlbum");
        } catch (Exception e) {
            fail("Wrong exception thrown for setGenre");
        }
        //if null
        try {
            song.setAlbum("");
            fail("Null value in setAlbum should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught null value in setAlbum");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAlbum");
        }

        //if too short
        try {
            song.setAlbum("A");
            fail("Short value in setAlbum should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught short value in setAlbum");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAlbum");
        }

        //if too long
        try {
            String longAlbum = "This is a very long album title that exceeds the maximum length allowed";
            song.setAlbum(longAlbum);
            fail("Long value in setAlbum should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught long value in setAlbum");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAlbum");
        }

        //if contains special chars
        try {
            song.setAlbum("Invalid@Album");
            fail("Invalid characters in setAlbum should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught invalid characters in setAlbum");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAlbum");
        }
    }

    //valid album
    @Test
    void setAlbumValid() {
        String validAlbum = "Californication";
        song.setAlbum(validAlbum);
        assertEquals(validAlbum, song.getAlbum());
    }











    //tests fior the author
    @Test
    void getAuthor() {
    }

    @Test
    void setAuthorInvalid() {
        // tesst for empty author
        try {
            song.setAuthor("");
            fail("Empty author in setAuthor should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught empty author in setAuthor");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAuthor");
        }
        //if null
        try {
            song.setAuthor("");
            fail("Null value in setAuthor should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught null value in setAuthor");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAuthor");
        }

        //if too short
        try {
            song.setAuthor("A");
            fail("Too short value in setAuthor should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught too short value in setAuthor");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAuthor");
        }

        //if too long
        String longAuthor = "This is a very long author name that exceeds the maximum length allowed";
        try {
            song.setAuthor(longAuthor);
            fail("Too long value in setAuthor should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught too long value in setAuthor");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAuthor");
        }

        //if contains special chars
        try {
            song.setAuthor("Invalid@Author");
            fail("Value with special characters in setAuthor should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught value with special characters in setAuthor");
        } catch (Exception e) {
            fail("Wrong exception thrown for setAuthor");
        }
    }

    //valid author
    @Test
    void setAuthorValid() {
        String validAuthor = "Eric Clapton";
        song.setAuthor(validAuthor);
        assertEquals(validAuthor, song.getAuthor());
    }












    //release year tests
    @Test
    void getReleaseYear() {
    }

    @Test
    void testSetReleaseYearInvalid() {
        // Test for release year before 1700
        try {
            song.setReleaseYear(1600);
            fail("Release year before 1700 should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught release year before 1700");
        } catch (Exception e) {
            fail("Wrong exception thrown for release year before 1700");
        }

        // Test for release year in the future
        int futureYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
        try {
            song.setReleaseYear(futureYear);
            fail("Release year in the future should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught release year in the future");
        } catch (Exception e) {
            fail("Wrong exception thrown for release year in the future");
        }

        // Test for negative release year
        try {
            song.setReleaseYear(-2000);
            fail("Negative release year should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught negative release year");
        } catch (Exception e) {
            fail("Wrong exception thrown for negative release year");
        }
    }

    @Test
    void testSetReleaseYearValid() {
        // Test for valid release year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int validYear = currentYear - 5;
        song.setReleaseYear(validYear);
        assertEquals(validYear, song.getReleaseYear());
    }








    //tests for genre
    @Test
    void getGenre() {
    }

    @Test
    void setGenreInvalid() {
        // tesst for empty genre
        try {
            song.setGenre("");
            fail("Empty genre in setGenre should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught empty genre in setGenre");
        } catch (Exception e) {
            fail("Wrong exception thrown for setGenre");
        }

        // Test for null value
        try {
            song.setGenre(null);
            fail("Null value in setGenre should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught null value in setGenre");
        } catch (Exception e) {
            fail("Wrong exception thrown for setGenre");
        }

        // Test for short genre
        try {
            song.setGenre("A");
            fail("Short genre in setGenre should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught short genre in setGenre");
        } catch (Exception e) {
            fail("Wrong exception thrown for setGenre");
        }

        // Test for long genre
        String longGenre = "This is a very long genre that exceeds the maximum length allowed";
        try {
            song.setGenre(longGenre);
            fail("Long genre in setGenre should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught long genre in setGenre");
        } catch (Exception e) {
            fail("Wrong exception thrown for setGenre");
        }

        // Test for genre with special characters
        try {
            song.setGenre("Invalid@Genre");
            fail("Genre with special characters in setGenre should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught genre with special characters in setGenre");
        } catch (Exception e) {
            fail("Wrong exception thrown for setGenre");
        }
    }

    //valid method for genre
    @Test
    void setGenreValid() {
        String validGenre = "Rock";
        try {
            song.setGenre(validGenre);
            assertEquals(validGenre, song.getGenre());
        } catch (Exception e) {
            fail("Unexpected exception thrown for setGenre");
        }
    }

















    //tests for songkey
    @Test
    void getSongKey() {
    }

    @Test
    void setSongKeyInvalid() {
        // Test for empty string
        try {
            song.setSongKey("");
            fail("Empty string in setSongKey should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught empty string in setSongKey");
        } catch (Exception e) {
            fail("Wrong exception thrown for setSongKey");
        }

        // Test for key longer than 2 characters
        try {
            song.setSongKey("ABC");
            fail("Key longer than 2 characters in setSongKey should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught key longer than 2 characters in setSongKey");
        } catch (Exception e) {
            fail("Wrong exception thrown for setSongKey");
        }
    }

    //valid test
    @Test
    void setSongKeyValid() {
        String validKey = "C";
        try {
            song.setSongKey(validKey);
            assertEquals(validKey, song.getSongKey());
        } catch (Exception e) {
            fail("Unexpected exception thrown for setSongKey");
        }
    }


}