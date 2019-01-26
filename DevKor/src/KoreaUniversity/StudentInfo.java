package KoreaUniversity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

public class StudentInfo {
    Grade grade = Grade.F;
    Boolean[] attendance = new Boolean[16];

    StudentInfo(){
        Arrays.fill(attendance,false);
    }

    void putAttendance(int time) { //10
        attendance[time-1] = true;
    }
}
