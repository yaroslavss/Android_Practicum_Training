package com.example.user.javacoretraining.classes;

import com.example.user.javacoretraining.collections.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
  VI

  Задача на взаимодействие между классами. Разработать систему «Вступительные экзамены».
  Абитуриент регистрируется на Факультет, сдает Экзамены. Преподаватель выставляет Оценку.
  Система подсчитывает средний бал и определяет Абитуриента, зачисленного в учебное заведение.
 */
public class Faculty {

    private final int MAX_EXAM_RESULT = 5;

    private final String name;
    private List<Applicant> applicants = new ArrayList<>();
    private Teacher teacher;
    private double averageResult;

    public Faculty(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    /*
      Абитуриент регистрируется на Факультет
     */
    public void registerApplicant(String lastName, String firstName, String secondName, int birthYear) {
        applicants.add(new Applicant(lastName, firstName, secondName, birthYear));
    }

    /*
      Абитуриент сдает Экзамены
     */
    public void takeExam(Applicant applicant) {
        teacher.setExamResult(applicant);
    }

    /*
      Подсчитывает средний бал
     */
    private void setAverageExamResult() {
        int total = 0;
        for (Applicant ap : applicants) {
            total += ap.getExamResult();
        }
        averageResult = (double) total / applicants.size();
    }

    /*
      Возвращает список Абитуриентов, зачисленных в учебное заведение
     */
    public List<Applicant> getAcceptedApplicants() {
        setAverageExamResult();
        return applicants.stream()
                .filter(a -> a.getExamResult() > averageResult)
                .collect(Collectors.toList());
    }

    /*
      Класс Абитуриент
     */
    class Applicant extends Person {

        private int examResult;

        public int getExamResult() {
            return examResult;
        }

        public void setExamResult(int examResult) {
            this.examResult = examResult;
        }

        public Applicant(String lastName, String firstName, String secondName, int birthYear) {
            super(lastName, firstName, secondName, birthYear);
        }
    }

    /*
      Класс Преподаватель
     */
    class Teacher extends Person {

        public Teacher(String lastName, String firstName, String secondName, int birthYear) {
            super(lastName, firstName, secondName, birthYear);
        }

        /*
          Преподаватель выставляет Оценку
         */
        public void setExamResult(Applicant applicant) {
            Random random = new Random();
            applicant.setExamResult(random.nextInt(MAX_EXAM_RESULT));
        }
    }
}