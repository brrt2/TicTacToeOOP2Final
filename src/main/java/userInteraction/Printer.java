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
    private NumberOfMatches numberOfMatches;
    private PointsForWin pointsForWin;
    private boolean keepTurning;
    private String whoStarts;
    private String selectedDataStructure;

    public void runTheMenu() {
        printIntroduction();
    }

    public void printIntroduction(){
        System.out.println("Welcome to the OOP Tic Tac Toe game | Witaj w grze Kolko i Krzyzyk| Bienvenido");
        configureTarget();
    }

    public void configureTarget(){
        String target=null;
        while (keepTurning == false) {
            System.out.println("Please select the ouptput target Sys.err - e | Sys.out - o");
            target = scan.nextLine();
            if (!inputValidator.validateTargetConfig(target)) {
                System.out.println("Wrong value ! ");
            } else {
                keepTurning = true;
            }
        }

        if(target.equals("e")) output=new SystemErrOutput();
        else if(target.equals("o")) output= new SystemOutOutput();
        configureLanguage();
    }

    private void configureLanguage(){
       // Scanner scan1 = new Scanner(System.in);
        String lang=null;
        keepTurning=false;
        while (keepTurning==false) {
            System.out.println("Please select your language e - English | p - Polish | s - Spanish  Wybierz jezyk e-angielski | p-polski | s -hiszpanski" +
                    "| Seleccione su idioma e- ingles | p - polaco | s - español ");

            try {
                lang = scan.nextLine();
            } catch (InputMismatchException e) {
                scan.next();
            }

            if (!inputValidator.validateLanguage(lang)) {
                System.out.println("Wrong value !");
            } else {
                keepTurning = true;
            }
            keepTurning=true;
        }
       setLanguage(lang);
    }



    private void setLanguage(String symbol){
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
        obtainUsername2(language.getAskForSecondUserName());
    }

    public void obtainUsername2(String message) {
        keepTurning=false;
        while (keepTurning == false) {
            output.displayMessage(message);
            name2 = scan.nextLine();
            if (inputValidator.validatePlayerName(name2) == false) {
                output.displayMessage(language.getWrongName());
            } else {
                keepTurning = true;
            }
        }

        obtainBoardHeight(language.getAskForBoardHeight());
    }

    public void obtainBoardHeight(String message) {
        keepTurning = false;
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

        obtainBoardWidth(language.getAskForBoardWidth());

    }

    public void obtainBoardWidth(String msg) {
        keepTurning = false;
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

        obtainNumberOfAdjacentSigns();
    }

    public void obtainNumberOfAdjacentSigns() {
        keepTurning = false;
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
        scan.nextLine();
        whoStarts = obtainInformationOnWhoStarts();
        obtainInformationHowManyMatches();
    }

    public String obtainInformationOnWhoStarts(){
        String s1=null;
        keepTurning = false;
        while (!keepTurning) {
            output.displayMessage(language.getAskWhoGoesFirst());
             s1 = scan.nextLine();
            if (!inputValidator.validateWhoGoesFirstSign(s1)) {
                output.displayMessage(language.getIncorrectValue());
            } else {
                keepTurning = true;
            }
        }
        return s1;
    }

    public void obtainInformationHowManyMatches() {
        int number=0;
        while (keepTurning == false) {
            output.displayMessage(language.getAskHowManyMatches());
            try {
                number = scan.nextInt();

            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (inputValidator.validateHowManyMatches(numberOfMatches)) {
                output.displayMessage(language.getIncorrectValue());
            } else {
                keepTurning = true;
            }
        }
        numberOfMatches = new NumberOfMatches(number);
        obtainInformationHowManyPointsForWin();
        }


    public void obtainInformationHowManyPointsForWin() {
        int pointsForWin1;
        keepTurning=false;
        while (!keepTurning) {
            output.displayMessage(language.getAskHowManyMatches());
            try {
                pointsForWin1 = scan.nextInt();
                pointsForWin = new PointsForWin(pointsForWin1);
            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (!inputValidator.validateHowManyPointsForWin(pointsForWin)) {
                output.displayMessage(language.getIncorrectValue());
            } else {
                keepTurning = true;
            }
        }
        obtainInformationOnDataStructure();
    }

    public void obtainInformationOnDataStructure() {
        keepTurning=false;
        while (!keepTurning) {
            output.displayMessage(language.getAskIfChangeDataStructure());
            try {
                selectedDataStructure = scan.next();
            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            if (!inputValidator.validateDataStructureSelection(selectedDataStructure)) {
                output.displayMessage(language.getIncorrectValue());
            } else {
                keepTurning = true;
            }
        }
        configureGame();
    }

    public void configureGame(){
        Configurator configurator = new Configurator();
        configurator.configureGame(whoStarts,name,name2,height,width,tilesToWin,output,language,numberOfMatches,pointsForWin,selectedDataStructure);
    }
}