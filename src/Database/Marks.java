package Database;

import java.io.Serializable;

class Marks implements Serializable {
    private int studentId;
    private int subjectId;
    private int marks;

    public Marks(int studentId, int subjectId, int marks) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Subject ID: " + subjectId + ", Marks: " + marks;
    }
}