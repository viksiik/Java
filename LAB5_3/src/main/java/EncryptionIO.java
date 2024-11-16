import java.io.*;
import java.util.Scanner;

public class EncryptionIO {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final char key;

    public EncryptionIO(char key) {
        this.key = key;

    }

    public void encrypt(String input, String outputFile) {
        try (EncryptionWriter writer = new EncryptionWriter(byteArrayOutputStream, key)) {
            writer.write(input.getBytes());
            writer.flush();

            try (FileOutputStream fileOut = new FileOutputStream(outputFile)) {
                byteArrayOutputStream.writeTo(fileOut);
            }
            System.out.println("Encrypted text: " + byteArrayOutputStream.toString());

        } catch (IOException e) {
            System.err.println("Error with encryption: " + e.getMessage());
        }
    }

    public String decrypt(String inputFile) {
        StringBuilder decryptedText = new StringBuilder();

        try (FileInputStream fileIn = new FileInputStream(inputFile);
             EncryptionReader reader = new EncryptionReader(fileIn, key)) {

            int character;
            while ((character = reader.read()) != -1) {
                decryptedText.append((char) character);
            }
            System.out.println("Decrypted text: " + decryptedText.toString());
        } catch (IOException e) {
            System.err.println("Error with decryption: " + e.getMessage());
        }
        return decryptedText.toString();
    }
}