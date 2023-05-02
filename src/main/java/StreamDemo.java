import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void writeIntArrayToOutputStream(OutputStream outputStream, int[] arr) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            for (int value : arr) {
                dataOutputStream.writeInt(value);
            }
        }
    }
    public static int[] readIntArrayFromInputStream(InputStream inputStream, int[] arr) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = dataInputStream.readInt();
            }
            return arr;

        }
    }
    public static void writeIntArrayByWriter(Writer writer, int[] arr) throws IOException{
        try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (int i = 0; i < arr.length; i++) {
                bufferedWriter.write(String.valueOf(arr[i]));
                if (i < arr.length - 1) {
                    bufferedWriter.write(" ");
                }
            }
        }
    }
    public static int[] readIntArrayFromReader(Reader reader, int[] arr) throws IOException{
        /*try (BufferedReader bufferedReader = new BufferedReader(reader)){
            for (int i = 0; i<arr.length; i++){
                arr[i] = (char) reader.read();
            }
            return arr;
        }  previous version */
        try (var stringReader = new BufferedReader(reader)) {
            String[] strs = stringReader.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            return arr;
        }
    }
    public static int[] readIntArrayFromFileWithOffset(String filename, int[] arr, int offset) throws IOException{
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "r")){
            if (arr.length+offset >=randomAccessFile.length()) throw new IllegalArgumentException();
            randomAccessFile.seek(offset*2L);
            String[] strs = randomAccessFile.readLine().split(" ");
            for (int i = 0; i<arr.length & i<strs.length; i++){
                arr[i] = Integer.parseInt(strs[i]);
            }
            return arr;
        }
    }
    public static ArrayList<File> getFilesByExtension(String directoryName, String extension){
        File[] files = new File(directoryName).listFiles(File::isFile);
        if (files == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(files).filter(x->x.getName().endsWith("."+extension)).sorted().map(x->new File(x.getAbsolutePath())).collect(Collectors.toCollection(ArrayList::new));
    }
    public static ArrayList<File> getFilesByExtensionInAllSubdirectories(String directoryName, String extension){
        File[] files = new File(directoryName).listFiles(File::isFile);
        File[] dirs = new File(directoryName).listFiles(File::isDirectory);
        ArrayList<File> res = new ArrayList<>();
        if (files != null && Arrays.stream(files).anyMatch(x -> x.getAbsolutePath().endsWith("." + extension))){
            res.addAll(Arrays.stream(files).filter(x->x.getAbsolutePath().endsWith("."+extension)).sorted().map(x->new File(x.getAbsolutePath())).toList());
        }
        if (dirs != null){
            for (File dir:dirs){
                res.addAll(getFilesByExtensionInAllSubdirectories(dir.getAbsolutePath(), extension));
            }
        }
        return res;
    }
}
