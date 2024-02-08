package com.example.user.javacoretraining;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.user.javacoretraining.collections.Course;
import com.example.user.javacoretraining.collections.Person;
import com.example.user.javacoretraining.collections.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        st1.addGrade(c2, 3);
        st1.addGrade(c3, 3);
        st1.addGrade(c4, 4);
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
        st1.addGrade(c1, 5);
        st1.addGrade(c2, 4);
        st1.addGrade(c3, 5);
        st1.addGrade(c4, 4);
        st1.addGrade(c5, 5);

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

        // get best student for group == 2
        Student best = studentList
                .stream()
                .filter(st -> st.getGroup() == 2)
                .max(Comparator.comparing(Student::getAverageGrade))
                .orElse(null);

        System.out.println("!!! " + studentList);
        System.out.println("!!! Oldest: " + oldest);
        System.out.println("!!! Youngest: " + youngest);
        System.out.println("!!! Best: " + best);
    }
}
