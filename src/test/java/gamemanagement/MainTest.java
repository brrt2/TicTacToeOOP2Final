//package gamemanagement;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.io.*;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.testng.Assert.*;
//
//public class MainTest {
//
//    FileWriter fw;
//
//    @BeforeTest
//    public void startFileWriter(){
//        try {
//            fw=new FileWriter("entireOutput.txt",true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @AfterTest
//    void closeFileWriter() throws IOException {
//        fw.close();
//    }
//
//    @DataProvider(name = "gameFlowSequence")
//    public Object[][] getData3() {
//
//        return new Object[][]{
//
//                {"o\ne\nbartek\nadam\n3\n3\n3\nx\n2\n3\na\n1\n4\n2\n5\n3", "fdswhose sign is :| x  |has won this round!"},
////                {"o\ne\nroman\nandrzej\n4\n4\n3\nx\n1\n3\na\n1\n4\n2\n5\n3\nn\n", "Do you want to play another match Y/N ?"},
////                {"o\np\nWojtek\nMichal\n4\n4\n3\nx\n1\n3\na\n1\n4\n2\n5\n3\nn\n", "Czy chcesz zagrac kolejny mecz y-tak /n-nie ?"},
////                {"o\ns\nWojtek\nMichal\n4\n4\n3\nx\n1\n3\na\n1\n4\n2\n5\n3\nn\n", "Desea jugar otra vez y/n ?"},
//        };
//    }
//
//
//    @Test(dataProvider = "gameFlowSequence")
//    public void testGameFlow(String s, String e) throws Exception {
//
//        String sequence = s;
//        String expectedResult = e;
//
//        System.setIn(new ByteArrayInputStream(sequence.getBytes()));
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        PrintStream ps = new PrintStream(byteArrayOutputStream);
//       // System.setOut(ps);
//        Main.main(new String[]{});
//       // System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
//        List<String> gameOutput = Arrays.asList(byteArrayOutputStream.toString().split("\n"));
//        String actualLastLine = gameOutput.get(gameOutput.size() - 1);
//        fw.write(Collections.singletonList(byteArrayOutputStream.toString()).toString());
//
//        assertEquals(actualLastLine, expectedResult);
//    }
//}