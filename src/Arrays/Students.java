package Arrays;

//这是一个测试类，用来测试数组的泛型用的
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
