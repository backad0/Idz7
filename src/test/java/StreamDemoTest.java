import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StreamDemoTest {

    @Test
    public void writeIntArrayToOutputStream1() throws IOException{
        try (var outputStream = new FileOutputStream("test.bin")) {
            StreamDemo.writeIntArrayToOutputStream(outputStream, new int[]{0, 1, 2, 3});
            var inputStream = new FileInputStream("test.bin");
            int[] arr = new int[4];
            assertArrayEquals(new int[]{0, 1, 2, 3}, StreamDemo.readIntArrayFromInputStream(inputStream, arr));
        }
    }

    @Test
    public void writeIntArrayToOutputStream() throws IOException{
        try (var outputStream = new ByteArrayOutputStream()) {
            StreamDemo.writeIntArrayToOutputStream(outputStream, new int[]{0, 1, 2, 3});
            var inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            int[] arr = new int[4];
            assertArrayEquals(new int[]{0, 1, 2, 3}, StreamDemo.readIntArrayFromInputStream(inputStream, arr));
        }
    }

    @Test
    public void readIntArrayFromInputStream() throws IOException {
        try (var bs = new FileInputStream("test.bin")) {
            try (var outputStream = new FileOutputStream("test.bin")) {
                StreamDemo.writeIntArrayToOutputStream(outputStream, new int[]{0, 1, 2, 3});
            }
            int[] resultArray = new int[]{0, 0, 0, 0};
            StreamDemo.readIntArrayFromInputStream(bs, resultArray);
            assertArrayEquals(new int[]{0, 1, 2, 3}, resultArray);
        }
    }

    @org.junit.Test
    public void writeIntArrayByWriter() throws IOException {
        try (var cr = new CharArrayWriter()){
            char[] inputArr = new char[]{'1',' ','2',' ', '3'};
            StreamDemo.writeIntArrayByWriter(cr, new int[]{1,2,3});
            assertArrayEquals(inputArr, cr.toCharArray());
        }
    }

    @Test
    public void writeIntArrayToWriter1() throws IOException {
        try (var cs = new StringWriter()) {
            StreamDemo.writeIntArrayByWriter(cs, new int[]{1, 17, 178, 17809});
            var reader = new StringReader(cs.toString());
            int[] arr = new int[4];
            assertArrayEquals(new int[]{1, 17, 178, 17809}, StreamDemo.readIntArrayFromReader(reader, arr));
        }
    }

    @Test
    public void writeIntArrayToWriter0() throws IOException {
        try (var cs = new CharArrayWriter()) {
            StreamDemo.writeIntArrayByWriter(cs, new int[]{0, 1, 2, 3});
            var reader = new CharArrayReader(cs.toCharArray());
            int[] arr = new int[4];
            assertArrayEquals(new int[]{0, 1, 2, 3}, StreamDemo.readIntArrayFromReader(reader, arr));
        }
    }
    @Test
    public void readIntArrayFromReaderTest0() throws IOException {
        try (var cs = new StringReader("0 1 2 3")) {
            int[] resultArray = new int[]{0, 0, 0, 0};
            StreamDemo.readIntArrayFromReader(cs, resultArray);
            assertArrayEquals(new int[]{0, 1, 2, 3}, resultArray);
        }
    }
    @Test
    public void readIntArrayFromFileWithOffsetTest0() throws IOException {
        try (var outputStream = new FileWriter("test.bin")) {
            StreamDemo.writeIntArrayByWriter(outputStream, new int[]{0, 0, 0, 1, 2, 3, 4});
        }
        int[] arrResult = new int[]{0, 1, 2, 3, 4};
        int[] result = new int[5];
        assertArrayEquals(arrResult, StreamDemo.readIntArrayFromFileWithOffset("test.bin", result, 2));
    }
    @Test
    public void getAllFilenameWithExtensionTest0() {
        ArrayList<File> files = new ArrayList<>();
        Collections.addAll(files, new File("C://Users//alesh//IdeaProjects//Idz7/./pom.xml"));
        assertEquals(files, StreamDemo.getFilesByExtension(".", "xml"));
    }
    @Test
    public void getAllFilenameWithExtensionTest1() {
        ArrayList<File> files = new ArrayList<>();
        Collections.addAll(files, new File("C:\\Users\\alesh\\IdeaProjects\\Idz7\\house_1.csv"),new File("C:\\Users\\alesh\\IdeaProjects\\Idz7\\house_112-rtx.csv"));
        assertEquals(files, StreamDemo.getFilesByExtension("C:\\Users\\alesh\\IdeaProjects\\Idz7", "csv"));
    }

    @Test
    public void getFilesByExtensionInAllSubdirectoriesTest(){
        ArrayList<File> files = new ArrayList<>();
        Collections.addAll(files, new File("C:\\Users\\alesh\\IdeaProjects\\Idz7\\../Idz7\\subDirTest\\dir1\\house_1.csv"),new File("C:\\Users\\alesh\\IdeaProjects\\Idz7\\../Idz7\\subDirTest\\dir2\\house_112-rtx.csv"));
        assertEquals(files, StreamDemo.getFilesByExtensionInAllSubdirectories("../\\Idz7", "csv"));
    }/*C:\Users\alesh\IdeaProjects*/
}
