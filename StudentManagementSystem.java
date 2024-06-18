import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                return;
            }
        }
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Grade: " + student.getGrade());
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel);

        JTextField nameField = new JTextField(20);
        panel.add(nameField);

        JLabel rollNumberLabel = new JLabel("Roll Number:");
        panel.add(rollNumberLabel);

        JTextField rollNumberField = new JTextField(20);
        panel.add(rollNumberField);

        JLabel gradeLabel = new JLabel("Grade:");
        panel.add(gradeLabel);

        JTextField gradeField = new JTextField(20);
        panel.add(gradeField);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int rollNumber = Integer.parseInt(rollNumberField.getText());
                String grade = gradeField.getText();
                Student student = new Student(name, rollNumber, grade);
                studentManagementSystem.addStudent(student);
                nameField.setText("");
                rollNumberField.setText("");
                gradeField.setText("");
            }
        });
        panel.add(addButton);

        JButton removeButton = new JButton("Remove Student");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rollNumber = Integer.parseInt(rollNumberField.getText());
                studentManagementSystem.removeStudent(rollNumber);
                rollNumberField.setText("");
            }
        });
        panel.add(removeButton);

        JButton searchButton = new JButton("Search Student");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rollNumber = Integer.parseInt(rollNumberField.getText());
                Student student = studentManagementSystem.searchStudent(rollNumber);
                if (student != null) {
                    System.out.println("Student found:");
                    System.out.println("Name: " + student.getName());
                    System.out.println("Roll Number: " + student.getRollNumber());
                    System.out.println("Grade: " + student.getGrade());
                } else {
                    System.out.println("Student not found.");
                }
                rollNumberField.setText("");
            }
        });
        panel.add(searchButton);

        JButton displayButton = new JButton("Display Students");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentManagementSystem.displayStudents();
            }
        });
        panel.add(displayButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
