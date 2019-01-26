package KoreaUniversity;

public class Member {
    String name;
    String id;
    String pw;
    Boolean sex;

    Member(String name, String id, String pw, Boolean sex) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.sex = sex;
    }

    void modifyInfo(String target, String value) { //1
        if(target=="name")
            this.name = value;
        else if(target=="pw")
            this.pw = value;
        else{
            System.out.println("타겟이 잘못되었습니다");
            return;
        }
        System.out.println("정보가 변경되었습니다");
        System.out.println("이름 : " + this.name);
        System.out.println("아이디 : " + this.id);
        System.out.println("패스워드 : " + this.pw);
        System.out.println("성별 : " + this.sex);
        return;
    }
}
