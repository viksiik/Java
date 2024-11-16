import java.io.*;

public class EncryptionWriter extends FilterOutputStream {
    private char key;

    public EncryptionWriter(OutputStream out, char key) {
        super(out);
        this.key = key;
    }

    public EncryptionWriter(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int c) throws IOException {
        int encryptedChar = c + key;
        super.write(encryptedChar);
    }
}