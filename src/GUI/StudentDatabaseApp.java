package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Database.*;

public class StudentDatabaseApp {
    private List<Student> students;
    private List<Marks> marks;

    public StudentDatabaseApp() {
        try {
            students = Database.loadStudents();
            marks = Database.loadMarks();
        } catch (IOException | ClassNotFoundException e) {
            students = new ArrayList<>();
            marks = new ArrayList<>();
        }

        JFrame frame = new JFrame("Student Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.add("Students", createStudentPanel());
        tabbedPane.add("Marks", createMarksPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private JPanel createStudentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> studentList = new JList<>(listModel);
        updateStudentList(listModel);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        inputPanel.add(new JLabel("Student ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                students.add(new Student(id, name, age));
                Database.saveStudents(students);
                updateStudentList(listModel);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            int selectedIndex = studentList.getSelectedIndex();
            if (selectedIndex != -1) {
                students.remove(selectedIndex);
                try {
                    Database.saveStudents(students);
                    updateStudentList(listModel);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving data");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        panel.add(new JScrollPane(studentList), BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createMarksPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> marksList = new JList<>(listModel);
        updateMarksList(listModel);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JTextField studentIdField = new JTextField();
        JTextField subjectIdField = new JTextField();
        JTextField marksField = new JTextField();
        inputPanel.add(new JLabel("Student ID:"));
        inputPanel.add(studentIdField);
        inputPanel.add(new JLabel("Subject ID:"));
        inputPanel.add(subjectIdField);
        inputPanel.add(new JLabel("Marks:"));
        inputPanel.add(marksField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            try {
                int studentId = Integer.parseInt(studentIdField.getText());
                int subjectId = Integer.parseInt(subjectIdField.getText());
                int marksValue = Integer.parseInt(marksField.getText());
                marks.add(new Marks(studentId, subjectId, marksValue));
                Database.saveMarks(marks);
                updateMarksList(listModel);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            int selectedIndex = marksList.getSelectedIndex();
            if (selectedIndex != -1) {
                marks.remove(selectedIndex);
                try {
                    Database.saveMarks(marks);
                    updateMarksList(listModel);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving data");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        panel.add(new JScrollPane(marksList), BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void updateStudentList(DefaultListModel<String> listModel) {
        listModel.clear();
        for (Student student : students) {
            listModel.addElement(student.toString());
        }
    }

    private void updateMarksList(DefaultListModel<String> listModel) {
        listModel.clear();
        for (Marks mark : marks) {
            listModel.addElement(mark.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentDatabaseApp::new);
    }
}
