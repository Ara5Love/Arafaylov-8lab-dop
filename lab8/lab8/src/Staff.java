
public class Staff {
    public String name;
    public int age;
    public int money;
    public String function;

    public Staff(String name, int age, int money, String function) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.function = function;
    }

    public int getMoney(){
        return this.money;
    }
    public int getAge(){
        return this.age;
    }
}