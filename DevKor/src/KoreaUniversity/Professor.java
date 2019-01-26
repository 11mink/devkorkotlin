package KoreaUniversity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Professor extends Member {


    Professor(String name, String id, String pw, Boolean sex) {
        super(name, id, pw, sex);
    }

    void putGrade( String studentNum, String subjectNum, Grade grade) {//6
        Subject subject = null;
        StudentInfo studentinfo;
        for(Subject sub : Subject.subjectList){
            if(sub.subjectNum.equals(subjectNum) && sub.professorName.equals(this.name))
                subject = sub;
        }
        if(subject == null){
            System.out.println("과목이 존재하지 않습니다");
            return;
        }
        if(subject.studentList.containsKey(studentNum)){
            studentinfo = subject.studentList.get(studentNum);
            studentinfo.grade = grade;
            for(Student student : Student.studentList){
                if(student.id.equals(studentNum)){
                    student.takenSubject.add(subject);
                    student.takingSubject.remove(subject);
                }
            }
        }
        else{
            System.out.println("학생이름이 출석부에 존재하지 않습니다");
            return;
        }
    }

    Subject createSubject(String subjectName, int credit, String ... times) {  //7
        Subject subject = new Subject();

        /*if (credit<1 || credit>3) {
            System.out.println("학점은 1~3 사이 값만 가능합니다");
            return null;
        }*/

        subject.credit = credit;
        subject.professorName = this.name;
        subject.subjectName = subjectName;
        subject.subjectNum = "CYDF-"+String.format("%03d", Subject.subjectNumCount++);


        for(String time: times){
            /*if(time.length() == 0){
                if(i == 0){
                    System.out.println("적어도 하나의 강의시간은 입력해야 합니다");
                    return null;
                }
                break;
            }
            if(time.length() < 4){
                System.out.println("강의시간을 정확히 입력하세요");
                return null;
            }
            if(!Arrays.asList("MON","TUE","WED","THU","FRI","SAT","SUN").contains(time.substring(0,3))){
                System.out.println("요일을 정확히 입력하세요");
                return null;
            }
            int period = Integer.parseInt(time.substring(3,time.length()));
            if(period<1 || period>10){
                System.out.println("교시를 정확히 입력하세요");
                continue;
            }*/
            subject.time.add(time);
        }
        Subject.subjectList.add(subject);
        System.out.println("-----------생성된 강의-----------");
        System.out.println("담당교수 = " + subject.professorName);
        System.out.println("과목명 = " + subject.subjectName);
        System.out.println("학수번호 = " + subject.subjectNum);
        System.out.println("학점 = " + subject.credit);
        System.out.println("강의시간 = " + subject.time);
        System.out.println("------------------------------");
        System.out.println();
        return subject;
    }

    void deleteSubject(String subjectNum) { //8
        for(int i=0; i<Subject.subjectList.size(); i++){
            if(Subject.subjectList.get(i).subjectNum.equals(subjectNum) &&
                Subject.subjectList.get(i).professorName.equals(this.name)){
                Subject.subjectList.remove(i);
                System.out.println("과목 "+subjectNum+"이 삭제되었습니다.");
                System.out.println();
                return;
            }
        }
        System.out.println("학수번호를 정확히 입력하세요");
        System.out.println();
        return;
    }
}

