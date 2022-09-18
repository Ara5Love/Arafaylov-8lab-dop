
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Staff[] staffs = new Staff[]{
                new Staff("Пётр", 18, 140000, "Engineer"),
                new Staff("Сергей", 54, 100000, "Engineer"),
                new Staff("Артём", 23, 90000, "Manager"),
                new Staff("Никита", 100, 110000, "Manager"),
                new Staff("Егор", 19, 180000, "Engineer"),
                new Staff("Лёня", 36, 120000, "Director"),
                new Staff("Владимир", 78, 280000, "Engineer"),
                new Staff("Ян", 78, 280000, "Engineer"),
                new Staff("Алексей", 40, 280000, "Engineer")
        };
        System.out.println("1 Task");
        System.out.println(Arrays.stream(staffs)
                .map(s -> s.name)
                .collect(Collectors
                        .groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map
                        .Entry
                        .comparingByValue())
                .get()
                .getKey());

        System.out.println();

        System.out.println("2 Task");
        System.out.println(Arrays.stream(staffs).collect(Collectors.averagingDouble(Staff::getMoney)));
        System.out.println();

        System.out.println("3 Task");
        findolds(3,staffs);
    }

    static public void findolds(int n, Staff[] x) {
        System.out.println(Arrays.stream(x)
                // .filter(ele -> ele.equals("Engineer"))
                .filter(Worker -> Worker.function.startsWith("Engineer"))
                .sorted((i1, i2) -> i2.age - i1.age)
                .map(Worker -> Worker.name)
                .limit(n)
                .sorted()
                .collect(Collectors
                        .joining(", ", n + " самых старших сотрудников в должности Engineer зовут ", ";")));
    }
}