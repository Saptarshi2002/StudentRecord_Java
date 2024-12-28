package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Database {
    private static final String STUDENT_FILE = "students.dat";
    private static final String MARKS_FILE = "marks.dat";

    public static void saveStudents(List<Student> students) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE))) {
            oos.writeObject(students);
        }
    }

    public static List<Student> loadStudents() throws IOException, ClassNotFoundException {
        File file = new File(STUDENT_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Student>) ois.readObject();
        }
    }

    public static void saveMarks(List<Marks> marks) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MARKS_FILE))) {
            oos.writeObject(marks);
        }
    }

    public static List<Marks> loadMarks() throws IOException, ClassNotFoundException {
        File file = new File(MARKS_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Marks>) ois.readObject();
        }
    }
}

