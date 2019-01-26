package KoreaUniversity;

import java.util.Scanner;

public class KoreaUniversity {
    public static void main(String[] args) {
        System.out.println("KoreaUniv Devkor attendence report");
        Professor wjLee = new Professor("WonJun Lee", "wjlee1234", "password", true);
        Student mink = new Student("Minkyun Kim", "11mink", "minkmink", true);
        Student mink2 = new Student("Minkyun Kim2", "12mink", "minkmank", true);
        Student mink3 = new Student("Minkyun Kim3", "13mink", "minkmonk", false);


        wjLee.createSubject("네트워크", 3, "TUE2", "THU3");                          //7
        Subject.showAllSubject();
        wjLee.deleteSubject("CYDF-001");    //8
        Subject.showAllSubject();

        Subject subject1 = wjLee.createSubject("네트워크", 3, "TUE2", "THU3");
        Subject subject2 = wjLee.createSubject("객지", 2, "WED3", "FRI4");
        Subject subject3 = wjLee.createSubject("무선네트워크", 1, "MON3", "FRI7");

        mink.registerSubject(subject1.subjectNum);
        mink2.registerSubject(subject1.subjectNum);
        mink3.registerSubject(subject1.subjectNum);

        mink.registerSubject(subject2.subjectNum);
        mink2.registerSubject(subject2.subjectNum);

        mink3.registerSubject(subject3.subjectNum);

        mink3.dropSubject(subject3.subjectNum);

        wjLee.putGrade(mink.id, subject1.subjectNum, Grade.A0);
        wjLee.putGrade(mink.id, subject2.subjectNum, Grade.B0);
        mink.showGrade();
        mink.showGrade(subject2.subjectNum);
        subject1.showStudentsById();
        subject1.studentList.get(mink.id).putAttendance(1);
        subject1.studentList.get(mink.id).putAttendance(3);
        subject2.studentList.get(mink.id).putAttendance(4);
        mink.showAttendance();
        mink.showAttendance(subject2.subjectNum);











        return;
    }
}
