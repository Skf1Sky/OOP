package OnClass;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Practice {
    private static List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(path);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return lines;
    }
    public static List<Student> readStudent(String path){
        List<Student> students = new ArrayList<>();
        List<String> lines = readFile(path);
        for (String line:lines){
            String[] info=line.split(",");
            Student student = new Student(Integer.parseInt(info[0]),info[1],Double.parseDouble(info[2]));
            students.add(student);
        }

        return students;

    }

    public static void main(String[] args) {
        List<Student> students = readStudent("src/OnClass/input.csv");
        for(Student student:students){
            System.out.println(student);
        }
    }
}
