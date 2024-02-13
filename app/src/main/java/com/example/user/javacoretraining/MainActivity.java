package com.example.user.javacoretraining;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.user.javacoretraining.classes.Abonent;
import com.example.user.javacoretraining.collections.Course;
import com.example.user.javacoretraining.collections.Person;
import com.example.user.javacoretraining.collections.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initStudents();
    }

    private void initStudents() {
        class InnerStudentsClass {
            public Set<Integer> getGroups() {
                Set<Integer> groups = new HashSet<Integer>();
                groups = studentList.stream()
                        .map(Student::getGroup)
                        .collect(Collectors.toSet());
                return groups;
            }

            /*
              Находит средний балл группы по каждому предмету по номеру группы.
             */
            public HashMap<Course, Double> averageGradesForGroup(int group) {
                HashMap<Course, Integer> totalGrades = new HashMap<>();
                HashMap<Course, Integer> qnts = new HashMap<>();
                HashMap<Course, Double> result = new HashMap<>();

                for (Student student :
                        studentList.stream().filter(st -> st.getGroup() == group).collect(Collectors.toList())) {

                    for (Map.Entry<Course, Integer> entry : student.getGrades().entrySet()) {
                        Course key = entry.getKey();
                        totalGrades.put(key, totalGrades.getOrDefault(key, 0) + entry.getValue());
                        qnts.put(key, qnts.getOrDefault(key, 0) + 1);
                    }
                }

                for (Map.Entry<Course, Integer> entry : totalGrades.entrySet()) {
                    Course key = entry.getKey();
                    result.put(key, (double) entry.getValue() / qnts.getOrDefault(key, 1));
                }

                return result;
            }

            /*
              Находит лучшего студента в группе по номеру группы
             */
            public Student bestGradedStudentForGroup(int group) {
                return studentList
                        .stream()
                        .filter(st -> st.getGroup() == group)
                        .max(Comparator.comparing(Student::getAverageGrade))
                        .orElse(null);
            }
        }

        Course c1 = new Course("Высшая алгебра");
        Course c2 = new Course("Аналитическая геометрия");
        Course c3 = new Course("Математический анализ");
        Course c4 = new Course("Теоретическая механика");
        Course c5 = new Course("Философия");

        Student st1 = new Student(
                "Иванов", "Иван", "Иванович",
                2001, 1, 1
        );
        st1.addGrade(c1, 5);
        st1.addGrade(c2, 1);
        st1.addGrade(c3, 1);
        st1.addGrade(c4, 1);
        st1.addGrade(c5, 5);

        Student st2 = new Student(
                "Петров", "Петр", "Петрович",
                2005, 1, 1
        );
        st2.addGrade(c1, 5);
        st2.addGrade(c2, 4);
        st2.addGrade(c3, 5);
        st2.addGrade(c4, 3);
        st2.addGrade(c5, 5);

        Student st3 = new Student(
                "Арбузов", "Иван", "Иванович",
                2003, 2, 2
        );
        st3.addGrade(c1, 5);
        st3.addGrade(c2, 4);
        st3.addGrade(c3, 5);
        st3.addGrade(c4, 4);
        st3.addGrade(c5, 5);

        studentList.add(st2);
        studentList.add(st1);
        studentList.add(st3);

        // sort by year
        // then by full name
        studentList.sort((Comparator.comparing(Student::getYear)).thenComparing(Student::getFullName));

        // get oldest student
        Student oldest = studentList
                .stream()
                .min(Comparator.comparing(Person::getBirthYear))
                .orElse(null);

        // get youngest student
        Student youngest = studentList
                .stream()
                .max(Comparator.comparing(Person::getBirthYear))
                .orElse(null);

        System.out.println("!!! " + studentList);
        System.out.println("!!! Oldest: " + oldest);
        System.out.println("!!! Youngest: " + youngest);

        // Для каждой группы найдите лучшего с точки зрения успеваемости студента.
        InnerStudentsClass innerStudentsClass = new InnerStudentsClass();
        Set<Integer> groups = innerStudentsClass.getGroups();

        for (Integer group : groups) {
            System.out.println("!!! Group " + group + " best student is " + innerStudentsClass.bestGradedStudentForGroup(group));
        }

        // Найдите средний балл каждой группы по каждому предмету.
        for (Integer group : groups) {
            HashMap<Course, Double> avg = innerStudentsClass.averageGradesForGroup(group);
            String mapAsString = avg.keySet().stream()
                    .map(key -> key + "=" + avg.get(key))
                    .collect(Collectors.joining(", ", "{", "}"));
            System.out.println("!!! " + mapAsString);
        }
    }

    /*
      V
    */
    private void initAbonents() {
        Abonent a1 = new Abonent(
                "Петров", "Петр", "Петрович", 1980,
                123456789L, "Москва, Ломоносовский пр-т, д.1, кв.2",
                "1234-1234-1234-1234", 1000, 500,
                60, 120
        );
        Abonent a2 = new Abonent(
                "Иванов", "Иван", "Иванович", 1992,
                123456789L, "Москва, Ломоносовский пр-т, д.2, кв.1",
                "4321-4321-4321-4321", 1500, 800,
                0, 61
        );

        // Создать массив объектов данного класса.
        Abonent[] abonents = new Abonent[]{a1, a2};

        // Вывести сведения относительно абонентов, у которых время городских переговоров
        // превышает заданное.
        Arrays.stream(abonents)
                .filter(a -> a.getCityCallTime() > Abonent.MAX_CITY_CALL_TIME)
                .forEach(System.out::println);

        // Сведения относительно абонентов, которые пользовались
        // междугородной связью.
        Arrays.stream(abonents)
                .filter(a -> a.getLongDistanceCallTime() > 0)
                .forEach(System.out::println);

        // Список абонентов в алфавитном порядке.
        Arrays.stream(abonents)
                .sorted(Comparator.comparing(Person::getFullName))
                .forEach(System.out::println);
    }
}
