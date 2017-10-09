import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            List<String> fileContent = Files.readAllLines(
                    new File("data.txt").toPath(),
                    Charset.defaultCharset()
            );

            List<Student> students = new ArrayList<>();

            String groupName = new String();

            for (String line : fileContent) {

                if (line.contains(":")) {
                    groupName = line.replaceAll(":", "").trim();
                    continue;
                }

                String[] attributes = line.split(";");

                students.add(new Student(attributes[0], attributes[1], Integer.parseInt(attributes[2]), groupName));

            }

            Collections.sort(students);

            students.forEach(student -> System.out.println(student));
            
            System.out.println("--------------------------");

            Collections.sort(students, (a, b) -> new StudentComparator().compare(a, b));

            String studentName = new String();

            PrintWriter writer = new PrintWriter("result.txt", "UTF-8");

            for (Student student : students) {

                if(!studentName.equals(student.getFirstName())) writer.println(student.getFirstName().concat(":"));

                studentName = student.getFirstName();

                writer.println(student.getLastName() + " " + student.getId() + " " + student.getGroup());


            }


            writer.close();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
