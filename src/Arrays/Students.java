package Arrays;

//����һ�������࣬������������ķ����õ�
public class Students {
    private String name;
    private int score;
    public Students(String studentName, int studentScore){
        name = studentName;
        score = studentScore;
    }

    @Override
    public  String toString(){
        return String.format("Student(name: %s, score: %d)", name,score);
    }


}
