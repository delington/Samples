import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public String readByRelativePath(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Reader.class.getResourceAsStream(path)))
        ) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String readByRelativePathOtherWay(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream(path)))
        ) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
