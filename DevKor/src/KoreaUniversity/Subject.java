package KoreaUniversity;

import java.util.*;

enum Grade { F, unused, D0, Dp, C0, Cp, B0, Bp, A0, Ap }

public class Subject {
    static int subjectNumCount = 1;
    static ArrayList<Subject> subjectList = new ArrayList<>();


    static void showAllSubject(){
        System.out.println("현재 열린 강의");
        if(subjectList.size() == 0){
            System.out.println("현재 열린 강의가 없습니다");
            return;
        }
        for(Subject subject : subjectList){
            System.out.println("------------------------------");
            System.out.println("담당교수 = " + subject.professorName);
            System.out.println("과목명 = " + subject.subjectName);
            System.out.println("학수번호 = " + subject.subjectNum);
            System.out.println("학점 = " + subject.credit);
            System.out.println("강의시간 = " + subject.time);
        }
        System.out.println("------------------------------");
        System.out.println();
        return;
    }

    Subject(){
        Subject.subjectList.add(this);
    }

    int credit;
    String professorName;
    String subjectName;
    String subjectNum;
    ArrayList<String> time = new ArrayList<>();
    HashMap<String,StudentInfo> studentList = new HashMap<String,StudentInfo>();

    void showStudentsById() {   //9
        TreeMap<String,StudentInfo> studentListById = new TreeMap<String,StudentInfo>(studentList);
        Iterator<String> iteratorKey = studentListById.keySet().iterator( );
        while(iteratorKey.hasNext()) {
            String key = iteratorKey.next();
            System.out.println("학번 : "+key+", 학점 : "+studentListById.get(key).grade);
        }
        System.out.println();
    }

}
