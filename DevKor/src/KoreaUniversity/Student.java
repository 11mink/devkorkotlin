package KoreaUniversity;

import java.util.ArrayList;

public class Student extends Member {
    static ArrayList<Student> studentList = new ArrayList<>();

    ArrayList<Subject> takingSubject = new ArrayList<>();
    ArrayList<Subject> takenSubject = new ArrayList<>();

    Student(String name, String id, String pw, Boolean sex) {
        super(name, id, pw, sex);
        studentList.add(this);
    }

    void showGrade() { // 2
        for (Subject subject : takenSubject) {
            System.out.println(subject.subjectName + "(" + subject.subjectNum + ") : " + subject.studentList.get(this.id).grade);
        }
        System.out.println();
    }

    // overload
    void showGrade(String subjectNum) { // 2
        for (Subject subject : takenSubject) {
            if (subject.subjectNum.equals(subjectNum)) {
                System.out.println(subject.subjectName + "(" + subject.subjectNum + ") : " + subject.studentList.get(this.id).grade);
                System.out.println();
                return;
            }
        }
        System.out.println("해당 과목이 존재하지 않습니다");
        System.out.println();
        return;
    }

    void showAttendance() { // 3
        System.out.println("*****수강완료 과목*****");
        if(takenSubject.size() != 0) {
            for (Subject subject : takenSubject){
                System.out.println("--------------------");
                System.out.println(subject.subjectName+"("+subject.subjectNum+")");
                int time = 0;
                for(Boolean attendance: subject.studentList.get(this.id).attendance){
                    char check = (attendance == true)? 'O' : 'X';
                    System.out.println(time+1+"회차 : "+check);
                    time++;
                }
                System.out.println("--------------------");
            }
        }
        System.out.println("*****수강중인 과목*****");
        if(takingSubject.size() != 0) {
            for (Subject subject : takingSubject){
                System.out.println("--------------------");
                System.out.println(subject.subjectName+"("+subject.subjectNum+")");
                int time = 0;
                for(Boolean attendance: subject.studentList.get(this.id).attendance){
                    char check = (attendance == true)? 'O' : 'X';
                    System.out.println(time+1+"회차 : "+check);
                    time++;
                }
                System.out.println("--------------------");
            }
        }
        System.out.println();
    }

    // overload
    void showAttendance(String subjectNum) { //3
        ArrayList<Subject> subjectList = new ArrayList<Subject>();
        subjectList.addAll(takenSubject);
        subjectList.addAll(takingSubject);

        for (Subject subject : subjectList){
            if(subject.subjectNum.equals(subjectNum)) {
                System.out.println("--------------------");
                System.out.println(subject.subjectName + "(" + subject.subjectNum + ")");
                int time = 0;
                for (Boolean attendance : subject.studentList.get(this.id).attendance) {
                    char check = (attendance == true) ? 'O' : 'X';
                    System.out.println(time + 1 + "회차 : " + check);
                    time++;
                }
                System.out.println("--------------------");
                break;
                }
            }
        System.out.println();
    }

    void registerSubject(String subjectNum) {   //4
        Subject subject = null;
        StudentInfo studentInfo = new StudentInfo();
        for (Subject sub : Subject.subjectList) {
            if (sub.subjectNum.equals(subjectNum))
                subject = sub;
        }
        if (subject == null) {
            System.out.println("해당 과목이 존재하지 않습니다");
            return;
        }
        takingSubject.add(subject);
        subject.studentList.put(this.id, studentInfo);
        System.out.println("과목이 등록되었습니다");
        System.out.println();
    }

    void dropSubject(String subjectNum) {       //5
        for (Subject sub : takingSubject) {
            if (sub.subjectNum.equals(subjectNum)) {
                sub.studentList.remove(this.id);
                takingSubject.remove(sub);
                System.out.println("과목이 삭제되었습니다");
                System.out.println();
                return;
            }
        }
        System.out.println("수강하는 과목이 아닙니다");
        System.out.println();
        return;
    }
}

