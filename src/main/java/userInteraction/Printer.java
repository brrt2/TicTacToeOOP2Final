package userInteraction;

import gameManagement.*;
import gameManagement.boardTools.Height;
import gameManagement.boardTools.TilesToWin;
import gameManagement.boardTools.Width;
import gameManagement.locale.Language;
import gameManagement.tiles.TakenTileSign;
import gameManagement.validation.InputValidator;
import players.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Printer {

    private Output output;
    private InputValidator inputValidator = new InputValidator();
    private String name = "DefaultFirstPlayer";
    private String name2 = "DefaultSecondPlayer";
    private Scanner scan = new Scanner(System.in);
    private Height height;
    private Width width;
    private TilesToWin tilesToWin;
    private Language language;
    boolean keepTurning;

    public void runTheMenu() {
        boolean keepTurning = false;
        printIntroduction(keepTurning);
    }

    public void printIntroduction(boolean keepTurning){
        System.out.println("Welcome to the OOP Tic Tac Toe game | Witaj w grze Kolko i Krzyzyk ");
        System.out.println("Please select the output target System.err- e / System.out - o ");
        String target=String.valueOf(scan.next()).toLowerCase();
        configureTarget(target);
    }

    public void configureTarget(String target){
        if(target.equals("e")) output=new SystemErrOutput();
        else if(target.equals("o")) output= new SystemOutOutput();
        configureLanguage();
    }

    public void configureLanguage(){
        System.out.println("Please select your language e - English | p- Polish | Wybierz jezyk e-angielski | p-polski" +
                "| Seleccione su idioma e-Ingles | p=polaco | e-espanol ");


        String lang = String.valueOf(scan.next()).toLowerCase();
        scan.nextLine();
        setLanguage(lang,keepTurning);
    }

    public void setLanguage(String symbol,boolean keepTurning){
        language=new Language(symbol);
        obtainUsername1(language.getAskForFirstUserName());
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

    public void obtainBoardHeight(String message,boolean keepTurning) {

        while (keepTurning == false) {
            output.displayMessage(message);
            try {
                int h = scan.nextInt();
                height= new Height(h);
            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (inputValidator.validateBoardDimensions(height.getValue()) == false) {
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
                int w = scan.nextInt();
                width = new Width(w);
            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (inputValidator.validateBoardDimensions(width.getValue()) == false) {
                output.displayMessage(language.getBoardDimensionError());
            } else {
                keepTurning = true;
            }
        }
        keepTurning = false;
        obtainNumberOfAdjacentSigns(keepTurning);
    }

    public void obtainNumberOfAdjacentSigns(boolean keepTurning) {

        while (keepTurning == false) {
            output.displayMessage(language.getAskForNumberofAdjacentSigns());
            try {
                int adjacentSigns = scan.nextInt();
                tilesToWin= new TilesToWin(adjacentSigns);
            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (inputValidator.validateAdjacentSignsToWin(tilesToWin.getValue(), height.getValue(), width.getValue()) == false) {
                output.displayMessage(language.getPositiveLowerOrEqualError());
            } else {
                keepTurning = true;
            }
        }
        keepTurning = false;
        String whoStarts = obtainInformationOnWhoStarts(keepTurning);
        configureGame(whoStarts,name,name2,height,width,tilesToWin,output,language);
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

    public void configureGame(String str, String name, String name2,Height height, Width width,TilesToWin tilesTowin, Output output,Language language){
        Configurator configurator = new Configurator();
        configurator.configureGame(str,name,name2,height,width,tilesTowin,output,language);
    }
}