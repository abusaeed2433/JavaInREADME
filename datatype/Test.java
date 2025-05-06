package datatype;

public class Test {

    public static void main(String[] args) {
        int n1 = 100;
        int n2 = 102;

        int res = add(n1,n2);
        System.out.println(res); // 202
        System.out.println(n1); // 100


        Human human = new Human("Saeed",21);
        printHumanData(human); // Saeed -> 21

        System.out.println(human.getAge()); // 26

    }

    private static void printHumanData(Human human){
        System.out.println(human.getName()+" -> "+human.getAge());

        human.setAge(26); // will modify main object
    }

    private static int add(int num1, int num2){
        int res = num1+num2;

        num1 = 25; //won't affect real data
        return res;
    }

}
