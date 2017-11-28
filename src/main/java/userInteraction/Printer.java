package userInteraction;

import gameManagement.*;
import gameManagement.boardTools.Height;
import gameManagement.boardTools.TilesToWin;
import gameManagement.boardTools.Width;
import gameManagement.locale.Language;
import gameManagement.locale.LanguageFactory;
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
        }
       setLanguage(lang);
    }

    private void setLanguage(String symbol){
        String fileName=null;

        if (symbol.equals("e")) fileName = "english.properties";
        else if (symbol.equals("p")) fileName = "polish.properties";
        else if (symbol.equals("s")) fileName = "spanish.properties";
        language= LanguageFactory.createLanguage(fileName);
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
            if (!inputValidator.validatePlayerName(name2)) {
                output.displayMessage(language.getWrongName());
            } else {
                keepTurning = true;
            }
        }

        obtainBoardHeight(language.getAskForBoardHeight());
    }

    public void obtainBoardHeight(String message) {
        String boardHeight;
        int parsedInput3=0;
        keepTurning = false;
        while (keepTurning == false) {
            output.displayMessage(message);
            try {
                boardHeight = String.valueOf(scan.next());
                parsedInput3 = Integer.parseInt(boardHeight);

            } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.nextLine();
            }
            height = new Height(parsedInput3);
            if (!inputValidator.validateBoardDimensions(height.getValue())) {
                output.displayMessage(language.getBoardDimensionError());
            } else {
                keepTurning = true;
            }
        }
        obtainBoardWidth(language.getAskForBoardWidth());

    }

    public void obtainBoardWidth(String msg) {
        String boardWidth;
        int parsedInput2=0;
        keepTurning = false;
        while (!keepTurning) {
            output.displayMessage(language.getAskForBoardWidth());
            try {
                boardWidth = String.valueOf(scan.next());
                parsedInput2 = Integer.parseInt(boardWidth);
            } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            width = new Width(parsedInput2);
            if (!inputValidator.validateBoardDimensions(width.getValue())) {
                output.displayMessage(language.getBoardDimensionError());
            } else {
                keepTurning = true;
            }
        }

        obtainNumberOfAdjacentSigns();
    }

    public void obtainNumberOfAdjacentSigns() {
        String adjacentSigns;
        int parsedInput2=0;
        keepTurning = false;
        while (!keepTurning) {
            output.displayMessage(language.getAskForNumberofAdjacentSigns());
            try {
                adjacentSigns = String.valueOf(scan.next());
                parsedInput2 = Integer.parseInt(adjacentSigns);
            } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            tilesToWin = new TilesToWin(parsedInput2);
            if (!inputValidator.validateBoardDimensions(width.getValue())) {
                output.displayMessage(language.getBoardDimensionError());
            } else {
                keepTurning = true;
            }
        }

       whoStarts = obtainInformationOnWhoStarts();
        obtainInformationHowManyMatches();
    }

    public String obtainInformationOnWhoStarts(){
        Scanner scan = new Scanner(System.in);
        String s1=null;
        keepTurning = false;
        while (!keepTurning) {

            output.displayMessage(language.getAskWhoGoesFirst());
             s1 = String.valueOf(scan.nextLine());

            if (!inputValidator.validateWhoGoesFirstSign(s1)) {
               output.displayMessage(language.getIncorrectValue());
            } else {
                keepTurning = true;
            }
        }
        return s1;
    }

    public void obtainInformationHowManyMatches() {
        String numberofMatches1=null;
        int parsedInput=0;
        keepTurning = false;
        while (!keepTurning) {
            output.displayMessage(language.getAskHowManyMatches());
            try {

                numberofMatches1 = scan.next();
                parsedInput = Integer.parseInt(numberofMatches1);

            } catch (InputMismatchException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            numberOfMatches = new NumberOfMatches(parsedInput);
            if (!inputValidator.validateHowManyMatches(numberOfMatches)) {
                output.displayMessage(language.getIncorrectValue());
            } else {
                keepTurning = true;
            }
        }
        obtainInformationHowManyPointsForWin();
        }


    public void obtainInformationHowManyPointsForWin() {
        String inputFromUser;
        int parsedInput=0;
        keepTurning=false;
        while (!keepTurning) {
            output.displayMessage(language.getAskHowManyPointsForWin());
            try {
                inputFromUser = scan.next();
                parsedInput = Integer.parseInt(inputFromUser);
            } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.next();
            }
            pointsForWin = new PointsForWin(parsedInput);
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
                selectedDataStructure = String.valueOf(scan.next());
            } catch (InputMismatchException | NumberFormatException e) {
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