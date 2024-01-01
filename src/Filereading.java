import java.io.*;

public class Filereading {
    public static void main(String[] args){

        String b =  ("bob");

        try {
            String name = "";
            name += b;


            FileOutputStream fos = new FileOutputStream("slay.txt");
            OutputStreamWriter outwrite = new OutputStreamWriter(fos);
            outwrite.write(name);
            outwrite.flush();
            outwrite.close();
            fos.close();

            System.out.print(name);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
