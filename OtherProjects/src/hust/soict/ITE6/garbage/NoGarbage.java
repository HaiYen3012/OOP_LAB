package src.hust.soict.ITE6.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        
        String filename = "src/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        startTime = System.currentTimeMillis();
        
        StringBuilder outpStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outpStringBuilder.append((char)b);
        }
        
        endTime = System.currentTimeMillis();
        
        System.out.println("Time: " + (endTime - startTime) + " ms");
        
        System.out.println("First 100 characters: " + outpStringBuilder.substring(0, Math.min(outpStringBuilder.length(), 100)));
    }
}
