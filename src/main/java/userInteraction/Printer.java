package userInteraction;

import gameManagement.Board;
import gameManagement.Game;
import gameManagement.GameState;
import gameManagement.Turn;
import gameManagement.locale.Language;
import gameManagement.tiles.TakenTileSign;
import gameManagement.validation.InputValidator;
import players.Player;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.function.Predicate;

public class Printer {

    String fileName="english.properties";

    //    String lang="en";
//    String country ="US";
//    Locale l = new Locale(lang,country);
//    ResourceBundle r = ResourceBundle.getBundle("src.main.java.resources.Bundle",l);
//    String str=r.getString("wish");
    Output output;
    private InputValidator inputValidator = new InputValidator();
    private String name = "DefaultFirstPlayer";
    private String name2 = "DefaultSecondPlayer";
    private Scanner scan = new Scanner(System.in);
    private int height = 0;
    private int width = 0;
    private int adjacentSigns = 0;
    private Language language;
    boolean keepTurning;

    public void runTheMenu() {
        boolean keepTurning = false;
        printIntroduction(keepTurning);
    }

    public String obtainInformationOnWhoStarts(boolean keepTurning){
        String s1=null;
        output.displayMessage(language.getAskWhoGoesFirst());
        while (keepTurning == false) {

             s1 = scan.nextLine();

            if (inputValidator.validateWhoGoesFirstSign(s1) == false) {
                output.displayMessage(language.getAskWhoGoesFirst());
            } else {
                keepTurning = true;
            }
        }
        return s1;
    }

    public void configureGame(String str){
        Player first = new Player(name, TakenTileSign.NOUGHT);
        Player second = new Player(name2, TakenTileSign.CROSS);
        Board board = new Board(height, width);
        Turn turn = new Turn(first,second);
        Game game = new Game(turn,board, adjacentSigns,output,language);
        if(str.equals("x")) game.getTurn().setCurrentPlayer(second);
        else if(str.equals("o")) game.getTurn().setCurrentPlayer(first);
        do {
            game.play();

        } while (game.getGameState()!= GameState.WIN&&game.getGameState()!= GameState.DRAW);
    }


    public void setLanguage(String symbol,boolean keepTurning){
        language=new Language(symbol);
        obtainUsername1(language.getAskForFirstUserName());
    }

    public void configureTarget(String target){
        if(target.equals("e")) output=new SystemErrOutput();
        else if(target.equals("o")) output= new SystemOutOutput();
        configureLanguage();
    }

    public void configureLanguage(){
        System.out.println("Please select your language e - English | p- Polish | Wybierz jezyk e-angielski | p-polski ");
        String lang = String.valueOf(scan.next()).toLowerCase();
        scan.nextLine();
        setLanguage(lang,keepTurning);
    }

    public void printIntroduction(boolean keepTurning){
        System.out.println("Welcome to the OOP Tic Tac Toe game | Witaj w grze Kolko i Krzyzyk ");
        System.out.println("Please select the output target System.err- e / System.out - o ");
        String target=String.valueOf(scan.next()).toLowerCase();
        configureTarget(target);

    }

    public void obtainUsername1(String message) {
        keepTurning=false;
        while (keepTurning == false) {
            output.displayMessage(message);
            name = scan.nextLine();
            if (inputValidator.validatePlayerName(name) == false) {
                output.displayMessage(language.getWrongName());
            } else {
                keepTurning = true;
            }
        }
        keepTurning = false;
        obtainUsername2(language.getAskForSecondUserName(), keepTurning);
    }

    public void obtainUsername2(String message, boolean keepTurning) {
        while (keepTurning == false) {
            output.displayMessage(message);
            name2 = scan.nextLine();
            if (inputValidator.validatePlayerName(name2) == false) {
                output.displayMessage(language.getWrongName());
            } else {
                keepTurning = true;
            }
        }
        keepTurning = false;
        obtainBoardHeight(language.getAskForBoardHeight(),keepTurning);
    }

    public void obtainNumberOfAdjacentSigns(boolean keepTurning) {

        while (keepTurning == false) {
            output.displayMessage(language.getAskForNumberofAdjacentSigns());
            try {
                adjacentSigns = scan.nextInt();
            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (inputValidator.validateAdjacentSignsToWin(adjacentSigns, height, width) == false) {
                output.displayMessage(language.getPositiveLowerOrEqualError());
            } else {
                keepTurning = true;
            }
        }
        keepTurning = false;
        String whoStarts = obtainInformationOnWhoStarts(keepTurning);
        configureGame(whoStarts);
    }

    public void obtainBoardHeight(String message,boolean keepTurning) {

        while (keepTurning == false) {
            output.displayMessage(message);
            try {
                height = scan.nextInt();
            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (inputValidator.validateBoardDimensions(height) == false) {
                output.displayMessage(language.getBoardDimensionError());
            } else {
                keepTurning = true;
            }
        }
        keepTurning = false;
        obtainBoardWidth(language.getAskForBoardWidth(),keepTurning);

    }

    public void obtainBoardWidth(String msg,boolean keepTurning) {

        while (keepTurning == false) {
            output.displayMessage(language.getAskForBoardWidth());
            try {
                width = scan.nextInt();
            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (inputValidator.validateBoardDimensions(width) == false) {
                output.displayMessage(language.getBoardDimensionError());
            } else {
                keepTurning = true;
            }
        }
        keepTurning = false;
        obtainNumberOfAdjacentSigns(keepTurning);
    }
}