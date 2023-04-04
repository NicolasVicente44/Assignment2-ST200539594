package com.example.assignment2st200539594;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiffTest {
    private Riff riff;

    @BeforeEach
    void setUp() {
        Song song = new Song("Crazy Train", "Ozzy Osbourne", "Blizzard of Oz", 1978, "Metal", "F#");
        riff = new Riff(song, "crazyTrainRiff1.png", "Medium", "0", 138, 1);
    }


    //riff image path tests
    @Test
    void getRiffImagePath() {
    }
    @Test
    void setRiffImagePathInvalid() {
        // test for null value
        try {
            riff.setRiffImagePath(null);
            fail("Null value in setRiffImagePath should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught null value in setRiffImagePath");
        } catch (Exception e) {
            fail("Wrong exception thrown for setRiffImagePath");
        }

        // test for empty string
        try {
            riff.setRiffImagePath("");
            fail("Empty string in setRiffImagePath should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught empty string in setRiffImagePath");
        } catch (Exception e) {
            fail("Wrong exception thrown for setRiffImagePath");
        }

        // test for invalid format
        try {
            riff.setRiffImagePath("crazyTrain.png");
            fail("Invalid format in setRiffImagePath should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught invalid format in setRiffImagePath");
        } catch (Exception e) {
            fail("Wrong exception thrown for setRiffImagePath");
        }
    }

    //valid method
    @Test
    void setRiffImagePathValid() {
        String validPath = "crazyTrainRiff1.png";
        riff.setRiffImagePath(validPath);
        assertEquals(validPath, riff.getRiffImagePath());
    }










    //tests for difficulty value
    @Test
    void getDifficulty() {
    }

    @Test
    void setDifficultyInvalid() {
        // test for null value
        try {
            riff.setDifficulty(null);
            fail("Null value in setDifficulty should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught null value in setDifficulty");
        } catch (Exception e) {
            fail("Wrong exception thrown for setDifficulty");
        }

        // test for empty string
        try {
            riff.setDifficulty("");
            fail("Empty string in setDifficulty should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught empty string in setDifficulty");
        } catch (Exception e) {
            fail("Wrong exception thrown for setDifficulty");
        }

        // test for too long string
        try {
            riff.setDifficulty("VeryHardDifficulty");
            fail("Too long string in setDifficulty should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught too long string in setDifficulty");
        } catch (Exception e) {
            fail("Wrong exception thrown for setDifficulty");
        }

        // test for invalid characters
        try {
            riff.setDifficulty("Diff#ulty");
            fail("Invalid characters in setDifficulty should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught invalid characters in setDifficulty");
        } catch (Exception e) {
            fail("Wrong exception thrown for setDifficulty");
        }
    }
    //valid method
    @Test
    void setDifficultyValid() {
        String validDifficulty = "Medium";
        riff.setDifficulty(validDifficulty);
        assertEquals(validDifficulty, riff.getDifficulty());
    }













    @Test
    void getCapoPosition() {
    }

    @Test
    void setCapoPositionInvalid() {
        // test for null value
        try {
            riff.setCapoPosition(null);
            fail("Null value in setCapoPosition should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught null value in setCapoPosition");
        } catch (Exception e) {
            fail("Wrong exception thrown for setCapoPosition");
        }

        // test for empty string
        try {
            riff.setCapoPosition("");
            fail("Empty string in setCapoPosition should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught empty string in setCapoPosition");
        } catch (Exception e) {
            fail("Wrong exception thrown for setCapoPosition");
        }

        // test for invalid format
        try {
            riff.setCapoPosition("five");
            fail("Invalid format in setCapoPosition should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught invalid format in setCapoPosition");
        } catch (Exception e) {
            fail("Wrong exception thrown for setCapoPosition");
        }

        // test for invalid range
        try {
            riff.setCapoPosition("13");
            fail("Capo position out of range in setCapoPosition should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught capo position out of range in setCapoPosition");
        } catch (Exception e) {
            fail("Wrong exception thrown for setCapoPosition");
        }
    }
    //valid method
    @Test
    void setCapoPositionValid() {
        String validCapo = "2";
        riff.setCapoPosition(validCapo);
        assertEquals(validCapo, riff.getCapoPosition());
    }














    @Test
    void getBeatsPerMinute() {
    }

    @Test
    void setBeatsPerMinuteInvalid() {
        // test for negative value
        try {
            riff.setBeatsPerMinute(-1);
            fail("Negative value in setBeatsPerMinute should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught negative value in setBeatsPerMinute");
        } catch (Exception e) {
            fail("Wrong exception thrown for setBeatsPerMinute");
        }

        // test for non-integer value
        try {
            riff.setBeatsPerMinute(Integer.parseInt("120.5"));
            fail("Non-integer value in setBeatsPerMinute should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught non-integer value in setBeatsPerMinute");
        } catch (Exception e) {
            fail("Wrong exception thrown for setBeatsPerMinute");
        }
    }
    //valid emthod
    @Test
    void setBeatsPerMinuteValid() {
        int validBpm = 120;
        riff.setBeatsPerMinute(validBpm);
        assertEquals(validBpm, riff.getBeatsPerMinute());
    }










    //tests for riffNumber
    @Test
    void getRiffNumber() {
    }

    @Test
    void testSetRiffNumberInvalid() {
        // test for null value
        try {
            riff.setRiffNumber(null);
            fail("Null value in setRiffNumber should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught null value in setRiffNumber");
        } catch (Exception e) {
            fail("Wrong exception thrown for setRiffNumber");
        }

        // test for integer value outside of range
        try {
            riff.setRiffNumber("101");
            fail("Riff number outside of range in setRiffNumber should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught riff number outside of range in setRiffNumber");
        } catch (Exception e) {
            fail("Wrong exception thrown for setRiffNumber");
        }

        // test for non-integer value
        try {
            riff.setRiffNumber("abc");
            fail("Non-integer value in setRiffNumber should trigger an exception but didn't");
        } catch (IllegalArgumentException e) {
            System.out.println("Properly caught non-integer value in setRiffNumber");
        } catch (Exception e) {
            fail("Wrong exception thrown for setRiffNumber");
        }
    }
    //valid method for riff number
    @Test
    void setRiffNumberValid() {
        // test for valid input
        try {
            riff.setRiffNumber("50");
            assertEquals(50, riff.getRiffNumber());
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException for valid input in setRiffNumber");
        }
    }


}