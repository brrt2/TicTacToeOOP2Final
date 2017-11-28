package userInteraction;

import gameManagement.Main;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class PrinterTest {

    @Test
    public void testPrintIntroduction() throws Exception {

        String sequence = "o\ne\nbartek\nadam\n3\n3\n3\nx\n1\n3\na\n1\n4\n2\n5\n3\nn\n";

        System.setIn(new ByteArrayInputStream(sequence.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        Main.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        List<String> gameOutput = Arrays.asList(byteArrayOutputStream.toString().split("\n"));
        String actualLastLine = gameOutput.get(gameOutput.size() -1);
        String expectedResult= "Do you want to play another match Y/N ?";

        assertEquals(actualLastLine,expectedResult);

    }



}






