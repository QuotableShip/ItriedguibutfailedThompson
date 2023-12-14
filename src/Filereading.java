import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Filereading {
    public static void main(String[] args){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Slay.txt"));
            writer.write("We r academic slays");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
