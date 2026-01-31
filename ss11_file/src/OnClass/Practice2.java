package OnClass;

import java.io.*;
import java.rmi.RemoteException;

public class Practice2 {
    private static void writeFile(String path, String data){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            File file = new File(path);
            fileWriter =new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                bufferedWriter.close();
            }
            catch (IOException e ){
                throw new RuntimeException(e);
            }
            try{
                fileWriter.close();
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        writeFile("src/OnClass/input.csv","this is data");
    }

}
