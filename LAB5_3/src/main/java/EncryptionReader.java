import java.io.*;

public class EncryptionReader extends FilterInputStream {
    private char key;

    public EncryptionReader(InputStream in, char key) {
        super(in);
        this.key = key;
    }

    public EncryptionReader(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c == -1) {
            return -1;
        }
        return c - key;
    }
}