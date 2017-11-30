package gamemanagement.locale;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LanguageTest {


    Language language = new Language("english.properties");


    @Test
    public void testGetAskForFirstUserName() throws Exception {

        assertEquals(language.getAskForFirstUserName(),"Please provide the name of the first user (o)");
    }

    @Test
    public void testGetAskForSecondUserName() throws Exception {
        assertEquals(language.getAskForSecondUserName(),"Please provide the name of the second user(x)");
    }

    @Test
    public void testGetAskForBoardHeight() throws Exception {
        assertEquals(language.getAskForBoardHeight(),"Please provide the board height ");
    }

    @Test
    public void testGetAskForBoardWidth() throws Exception {
        assertEquals(language.getAskForBoardWidth(),"Please provide the board width");

    }

    @Test
    public void testGetAskForNumberofAdjacentSigns() throws Exception {
        assertEquals(language.getAskForNumberofAdjacentSigns(),"Please provide the number of adjacent signs necessary to win");
    }

    @Test
    public void testGetAskWhoGoesFirst() throws Exception {
        assertEquals(language.getAskWhoGoesFirst(),"Who goes first x/o ?");
    }

    @Test
    public void testGetIncorrectValue() throws Exception {
        assertEquals(language.getIncorrectValue(),"Incorrect Value ! ");
    }

    @Test
    public void testGetWrongName() throws Exception {
        assertEquals(language.getWrongName(),"Wrong name !");
    }

    @Test
    public void testGetBoardDimensionError() throws Exception {
        assertEquals(language.getBoardDimensionError(),"Please provide a number higher than 2 and lower than 1000!");
    }



    @Test
    public void testGetLostMoveMessage() throws Exception {
        assertEquals(language.getLostMoveMessage(),"Wrong number - it has to be positive, fit within the board and point to an empty tile. You have lost your move.");
    }

    @Test
    public void testGetAskToProvideTileNumber() throws Exception {
        assertEquals(language.getAskToProvideTileNumber(),"Please provide the  number of the tile you want to mark | Type \"swap\" at any time to swap the player's points !");
    }

    @Test
    public void testGetNowIsTurnOf() throws Exception {
        assertEquals(language.getNowIsTurnOf(),"Now is the turn of :");
    }

    @Test
    public void testGetSignOfPlayer() throws Exception {
        assertEquals(language.getNowIsTurnOf(),"Now is the turn of :");
    }

    @Test
    public void testGetNoneOfTheValuesSelected() throws Exception {
        assertEquals(language.getNoneOfTheValuesSelected(),"None of the possible values selected, the game will be terminated");
    }

    @Test
    public void testGetThankYouForPlaying() throws Exception {
        assertEquals(language.getThankYouForPlaying(),"Thank you for playing");
    }



    @Test
    public void testGetAskIfChangeDataStructure() throws Exception {
        assertEquals(language.getAskIfChangeDataStructure(),"What data structure would you like to use a - ArrayList | l - LinkedList ? ");
    }



    @Test
    public void testGetValuesSwapped() throws Exception {
        assertEquals(language.getValuesSwapped(),"The players' points have been swapped");
    }


}