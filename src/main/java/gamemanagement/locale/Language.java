package gamemanagement.locale;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Language {

    private String askForFirstUserName;
    private String askForSecondUserName;
    private String askForBoardHeight;
    private String askForBoardWidth;
    private String askForNumberofAdjacentSigns;
    private String askWhoGoesFirst;
    private String incorrectValue;
    private String wrongName;
    private String boardDimensionError;
    private String askIfWantsToContinueAfterDraw;
    private String askIfWantsToContinue;
    private String lostMoveMessage;
    private String askToProvideTileNumber;
    private String nowIsTurnOf;
    private String signOfPlayer;
    private String hasWonThisRound;
    private String askIfwantsToPlayAnotherMatch;
    private String noneOfTheValuesSelected;
    private String thankYouForPlaying;
    private String playerXhas;
    private String playerOhas;
    private String askHowManyMatches;
    private String askHowManyPointsForWin;
    private String askIfChangeDataStructure;
    private String valuesSwapped;
    private String pressAnyKeyToContinue;
    private String fileName = null;

    public Language(String fileName)  {
        this.fileName=fileName;
        configureLanguage();
    }

    private void configureLanguage(){
        Properties properties = new Properties();
        InputStream config;
        try {
            config = ClassLoader.getSystemResourceAsStream(fileName);
            properties.load(config);
            askForFirstUserName = properties.getProperty("askForFirstUserName");
            askForSecondUserName = properties.getProperty("askForSecondUserName");
            askForBoardHeight = properties.getProperty("askForBoardHeight");
            askForBoardWidth = properties.getProperty("askForBoardWidth");
            askForNumberofAdjacentSigns = properties.getProperty("askForNumberofAdjacentSigns");
            askWhoGoesFirst=properties.getProperty("askWhoGoesFirst");
            incorrectValue = properties.getProperty("incorrectValue");
            wrongName = properties.getProperty("wrongName");
            boardDimensionError = properties.getProperty("boardDimensionError");
            askIfWantsToContinueAfterDraw = properties.getProperty("askIfWantsToContinueAfterDraw");
            askIfWantsToContinue = properties.getProperty("askIfWantsToContinue");
            lostMoveMessage = properties.getProperty("lostMoveMessage");
            askToProvideTileNumber = properties.getProperty("askToProvideTileNumber");
            nowIsTurnOf = properties.getProperty("nowIsTurnOf");
            signOfPlayer = properties.getProperty("signOfPlayer");
            hasWonThisRound = properties.getProperty("hasWonThisRound");
            askIfwantsToPlayAnotherMatch = properties.getProperty("askIfwantsToPlayAnotherMatch");
            noneOfTheValuesSelected = properties.getProperty("noneOfTheValuesSelected");
            thankYouForPlaying = properties.getProperty("thankYouForPlaying");
            playerXhas=properties.getProperty("playerXhas");
            playerOhas=properties.getProperty("playerOhas");
            askHowManyMatches = properties.getProperty("askHowManyMatches");
            askHowManyPointsForWin = properties.getProperty("askHowManyPointsForWin");
            askIfChangeDataStructure = properties.getProperty("askIfChangeDataStructure");
            valuesSwapped=properties.getProperty("valuesSwapped");
            pressAnyKeyToContinue=properties.getProperty("pressAnyKeyToContinue");
        } catch (IOException ex) {
            System.out.println("An IOException has occurred");
        }

    }

    public String getAskForFirstUserName() {
        return askForFirstUserName;
    }

    public String getAskForSecondUserName() {
        return askForSecondUserName;
    }

    public String getAskForBoardHeight() {
        return askForBoardHeight;
    }

    public String getAskForBoardWidth() {
        return askForBoardWidth;
    }

    public String getAskForNumberofAdjacentSigns() {
        return askForNumberofAdjacentSigns;
    }

    public String getAskWhoGoesFirst() {
        return askWhoGoesFirst;
    }

    public String getIncorrectValue() {
        return incorrectValue;
    }

    public String getWrongName() {
        return wrongName;
    }

    public String getBoardDimensionError() {
        return boardDimensionError;
    }

    public String getAskIfWantsToContinueAfterDraw() {
        return askIfWantsToContinueAfterDraw;
    }

    public String getAskIfWantsToContinue() {
        return askIfWantsToContinue;
    }

    public String getLostMoveMessage() {
        return lostMoveMessage;
    }

    public String getAskToProvideTileNumber() {
        return askToProvideTileNumber;
    }

    public String getNowIsTurnOf() {
        return nowIsTurnOf;
    }

    public String getSignOfPlayer() {
        return signOfPlayer;
    }

    public String getHasWonThisRound() {
        return hasWonThisRound;
    }

    public String getAskIfwantsToPlayAnotherMatch() {
        return askIfwantsToPlayAnotherMatch;
    }

    public String getNoneOfTheValuesSelected() {
        return noneOfTheValuesSelected;
    }

    public String getThankYouForPlaying() {
        return thankYouForPlaying;
    }

    public String getPlayerXhas() {
        return playerXhas;
    }

    public String getPlayerOhas() {
        return playerOhas;
    }

    public String getAskHowManyMatches() {
        return askHowManyMatches;
    }

    public String getAskIfChangeDataStructure() {
        return askIfChangeDataStructure;
    }

    public String getAskHowManyPointsForWin() {
        return askHowManyPointsForWin;
    }

    public String getValuesSwapped() { return valuesSwapped; }

    public String getPressAnyKeyToContinue() {
        return pressAnyKeyToContinue;
    }
}
