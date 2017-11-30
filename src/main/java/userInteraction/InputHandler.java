package userInteraction;

import gamemanagement.*;
import gamemanagement.configuration.*;
import gamemanagement.locale.Language;
import gamemanagement.locale.LanguageFactory;
import gamemanagement.validation.InputValidator;


import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private Output output;
    private InputValidator inputValidator = new InputValidator();
    private String name = "DefaultFirstPlayer";
    private String name2 = "DefaultSecondPlayer";
    private Scanner scan = new Scanner(System.in);
    private Height height;
    private Width width;
    private TilesToWin tilesToWin;
    private Language language;
    private NumberOfRounds numberOfRounds;
    private PointsForWin pointsForWin;
    private boolean keepTurning;
    private String whoStarts;
    private String selectedDataStructure;

    public void runTheMenu() {
        printIntroduction();
    }

    private void printIntroduction(){
        System.out.println("Welcome to the  Tic Tac Toe game | Witaj w grze Kolko i Krzyzyk| Bienvenido al juego de Tres en Linea ");
        configureTarget();
    }

    private void configureTarget(){
        String target="";
        while (!keepTurning) {
            System.out.println("Please select the ouptput target Sys.err - e | Sys.out - o | Wybierz strumien wyjscia Sys.err - e | Sys.out - o " +
                    "Seleccione el canal de salida Sys.err - e | Sys.out - o");
            target = scan.nextLine();
            if (!inputValidator.validateTargetConfig(target)) {
                System.out.println("Wrong value ! | Nieprawidlowa wartosc ! | Valor incorrecto !  ");
            } else {
                keepTurning = true;
            }
        }

        try{
            if(target.equals("e")) output=new SystemErrOutput();
            else if(target.equals("o")) output= new SystemOutOutput();
        }catch(NullPointerException e){
           output.displayMessage(language.getIncorrectValue());
        }
        configureLanguage();
    }

    private void configureLanguage(){
        String lang="";
        keepTurning=false;
        while (!keepTurning) {
            System.out.println("Press e for English | Wcisnij p aby wybrac jezyk polski | Pulse s para seleccionar la lengua española");
            try {
                lang = scan.nextLine();
            } catch (InputMismatchException e) {
                scan.next();
            }

            if (!inputValidator.validateLanguage(lang)) {
                System.out.println("Wrong value ! | Nieprawidlowa wartosc ! | Valor incorrecto !  ");
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
        obtainUsername1();

    }

    private void obtainUsername1() {
        keepTurning=false;
        while (!keepTurning) {
            output.displayMessage(language.getAskForFirstUserName());
            name = scan.nextLine();
            if (!inputValidator.validatePlayerName(name)) {
                output.displayMessage(language.getWrongName());
            } else {
                keepTurning = true;
            }
        }
        keepTurning = false;
        obtainUsername2(language.getAskForSecondUserName());
    }

    private void obtainUsername2(String message) {
        keepTurning=false;
        while (!keepTurning) {
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

    private void obtainBoardHeight(String message) {
        String boardHeight;
        int parsedInput3=0;
        keepTurning = false;
        while (!keepTurning) {
            output.displayMessage(message);
            try {
                boardHeight = String.valueOf(scan.nextLine());
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
        obtainBoardWidth();

    }

    private void obtainBoardWidth() {
        String boardWidth;
        int parsedInput2=0;
        keepTurning = false;
        while (!keepTurning) {
            output.displayMessage(language.getAskForBoardWidth());
            try {
                boardWidth = String.valueOf(scan.nextLine());
                parsedInput2 = Integer.parseInt(boardWidth);
            } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.nextLine();
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

    private void obtainNumberOfAdjacentSigns() {
        String adjacentSigns;
        int parsedInput2=0;
        keepTurning = false;
        while (!keepTurning) {
            output.displayMessage(language.getAskForNumberofAdjacentSigns());
            try {
                adjacentSigns = String.valueOf(scan.nextLine());
                parsedInput2 = Integer.parseInt(adjacentSigns);

           } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.nextLine();
            }
            tilesToWin = new TilesToWin(parsedInput2);
            if (!inputValidator.validateAdjacentSignsToWin(tilesToWin.getValue(),height.getValue(),width.getValue())) {
                output.displayMessage(language.getBoardDimensionError());
            } else {
                keepTurning = true;
            }
        }

       whoStarts = obtainInformationOnWhoStarts();
        obtainInformationHowManyMatches();
    }

    private String obtainInformationOnWhoStarts(){
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

    private void obtainInformationHowManyMatches() {
        String numberofMatches1;
        int parsedInput=0;
        keepTurning = false;
        while (!keepTurning) {
            output.displayMessage(language.getAskHowManyMatches());
            try {

                numberofMatches1 = scan.nextLine();
                parsedInput = Integer.parseInt(numberofMatches1);

            } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.nextLine();
            }
            numberOfRounds = new NumberOfRounds(parsedInput);
            if (!inputValidator.validateHowManyMatches(numberOfRounds)) {
                output.displayMessage(language.getIncorrectValue());
            } else {
                keepTurning = true;
            }
        }
        obtainInformationHowManyPointsForWin();
        }


    private void obtainInformationHowManyPointsForWin() {
        String inputFromUser;
        int parsedInput=0;
        keepTurning=false;
        while (!keepTurning) {
            output.displayMessage(language.getAskHowManyPointsForWin());
            try {
                inputFromUser = scan.nextLine();
                parsedInput = Integer.parseInt(inputFromUser);
            } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.nextLine();
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

    private void obtainInformationOnDataStructure() {
        keepTurning=false;
        while (!keepTurning) {
            output.displayMessage(language.getAskIfChangeDataStructure());
            try {
                selectedDataStructure = String.valueOf(scan.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                output.displayMessage(language.getIncorrectValue());
                scan.nextLine();
            }
            if (!inputValidator.validateDataStructureSelection(selectedDataStructure)) {
                output.displayMessage(language.getIncorrectValue());
            } else {
                keepTurning = true;
            }
        }
        configureGame();
    }

    private void configureGame(){
        Configurator configurator = new Configurator();
        configurator.configureGame(whoStarts,name,name2,height,width,tilesToWin,output,language, numberOfRounds,pointsForWin,selectedDataStructure,scan);
    }
}