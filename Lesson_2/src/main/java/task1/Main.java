package task1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    private static final Main.Person[] RAW_DATA = new Main.Person[]{
            new Main.Person(0, "Harry"),
            new Main.Person(0, "Harry"), //дубликат
            new Main.Person(1, "Harry"), //не дубликат
            new Main.Person(2, "Harry"),
            new Main.Person(3, "Emily"),
            new Main.Person(4, "Jack"),
            new Main.Person(4, "Jack"),
            new Main.Person(5, "Amelia"),
            new Main.Person(5, "Amelia"),
            new Main.Person(6, "Amelia"),
            new Main.Person(7, "Amelia"),
            new Main.Person(8, "Amelia"),
            new Main.Person(9, null),
            null
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();
        /*Main.Person[] var1 = RAW_DATA;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Main.Person person = var1[var3];
            System.out.println(person.id + " - " + person.name);
        }*/

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        if (Objects.nonNull(RAW_DATA)){
            groupedByName(RAW_DATA).forEach((key, value) -> {
                System.out.println("Key: " + key);
                System.out.println("Value: " + value);
            });
        }
    }


    public static Map<String, Long> groupedByName(Person[] data) {
        Predicate<Person> checkNullPerson = (person)-> Objects.nonNull(person) && Objects.nonNull(person.getName());
        return Arrays.stream(data)
                .filter(checkNullPerson)
                .distinct()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
    }

    static class Person {
        final int id;
        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } else if (!(o instanceof Person person)) {
                return false;
            } else {
                return this.getId() == person.getId() && this.getName().equals(person.getName());
            }
        }

        public int hashCode() {
            return Objects.hash(this.getId(), this.getName());
        }
    }
}
