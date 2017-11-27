package gameManagement.locale;

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
    private String whoGoesFirstError;
    private String incorrectValue;
    private String wrongName;
    private String positiveLowerOrEqualError;
    private String boardDimensionError;
    private String askIfWantsToContinueAfterDraw;
    private String askIfWantsToContinue;
    private String lostMoveMessage;
    private String askToProvideTileNumber;
    private String nowIsTurnOf;
    private String signOfPlayer;
    private String wrongValueType;
    private String hasWonThisRound;
    private String askIfwantsToPlayAnotherMatch;
    private String noneOfTheValuesSelected;
    private String thankYouForPlaying;
    private String numberOutsideTheBoard;
    private String tileTaken;
    private String playerXhas;
    private String playerOhas;
    private String selectOutputTarget;
    private String askHowManyMatches;
    private String askHowManyPointsForWin;
    private String askIfWantsToSwapXandO;
    private String askIfChangeDataStructure;

    private String fileName = null;

    public Language(String fileName)  {
        this.fileName=fileName;
        configureLanguage();
    }

    private void configureLanguage(){
        Properties properties = new Properties();
        InputStream config =null;
        try {
            config = ClassLoader.getSystemResourceAsStream(fileName);
            properties.load(config);
            askForFirstUserName = properties.getProperty("askForFirstUserName");
            askForSecondUserName = properties.getProperty("askForSecondUserName");
            askForBoardHeight = properties.getProperty("askForBoardHeight");
            askForBoardWidth = properties.getProperty("askForBoardWidth");
            askForNumberofAdjacentSigns = properties.getProperty("askForNumberofAdjacentSigns");
            askWhoGoesFirst=properties.getProperty("askWhoGoesFirst");
            whoGoesFirstError = properties.getProperty("whoGoesFirstError");
            incorrectValue = properties.getProperty("incorrectValue");
            wrongName = properties.getProperty("wrongName");
            positiveLowerOrEqualError = properties.getProperty("positiveLowerOrEqualError");
            boardDimensionError = properties.getProperty("boardDimensionError");
            askIfWantsToContinueAfterDraw = properties.getProperty("askIfWantsToContinueAfterDraw");
            askIfWantsToContinue = properties.getProperty("askIfWantsToContinue");
            lostMoveMessage = properties.getProperty("lostMoveMessage");
            askToProvideTileNumber = properties.getProperty("askToProvideTileNumber");
            nowIsTurnOf = properties.getProperty("nowIsTurnOf");
            signOfPlayer = properties.getProperty("signOfPlayer");
            wrongValueType = properties.getProperty("wrongValueType");
            hasWonThisRound = properties.getProperty("hasWonThisRound");
            askIfwantsToPlayAnotherMatch = properties.getProperty("askIfwantsToPlayAnotherMatch");
            noneOfTheValuesSelected = properties.getProperty("noneOfTheValuesSelected");
            thankYouForPlaying = properties.getProperty("thankYouForPlaying");
            numberOutsideTheBoard = properties.getProperty("numberOutsideTheBoard");
            tileTaken = properties.getProperty("tileTaken");
            playerXhas=properties.getProperty("playerXhas");
            playerOhas=properties.getProperty("playerOhas");
            selectOutputTarget= properties.getProperty("selectOutputTarget");
            askHowManyMatches = properties.getProperty("askHowManyMatches");
            askHowManyPointsForWin = properties.getProperty("askHowManyPointsForWin");
            askIfWantsToSwapXandO=properties.getProperty("askIfWantsToSwapXandO");
            askIfChangeDataStructure = properties.getProperty("askIfChangeDataStructure");

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

    public String getPositiveLowerOrEqualError() {
        return positiveLowerOrEqualError;
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

    public String getWhoGoesFirstError() {
        return whoGoesFirstError;
    }

    public String getWrongValueType() {
        return wrongValueType;
    }

    public String getNumberOutsideTheBoard() {
        return numberOutsideTheBoard;
    }

    public String getTileTaken() {
        return tileTaken;
    }

    public String getSelectOutputTarget() {
        return selectOutputTarget;
    }

    public String getAskHowManyPointsForWin() {
        return askHowManyPointsForWin;
    }

    public String getAskIfWantsToSwapXandO() {
        return askIfWantsToSwapXandO;
    }

    public String getFileName() {
        return fileName;
    }
}
