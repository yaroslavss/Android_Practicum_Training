package com.example.user.javacoretraining.classes;

import androidx.annotation.NonNull;

import com.example.user.javacoretraining.collections.Person;

/*
  V

  Класс Абонент: Идентификационный номер, Фамилия, Имя, Отчество, Адрес,
  Номер кредитной карточки, Дебет, Кредит, Время междугородных и городских переговоров;
  Конструктор; Методы: установка значений атрибутов, получение значений атрибутов,
  вывод информации.
 */
public class Abonent extends Person {

    public static final int MAX_CITY_CALL_TIME = 60;

    private long id;
    private String address;
    private String creditCardNumber;
    private int debit;
    private int credit;
    private int longDistanceCallTime;
    private int cityCallTime;

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getDebit() {
        return debit;
    }

    public int getCredit() {
        return credit;
    }

    public int getLongDistanceCallTime() {
        return longDistanceCallTime;
    }

    public int getCityCallTime() {
        return cityCallTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setLongDistanceCallTime(int longDistanceCallTime) {
        this.longDistanceCallTime = longDistanceCallTime;
    }

    public void setCityCallTime(int cityCallTime) {
        this.cityCallTime = cityCallTime;
    }

    public Abonent(String lastName, String firstName, String secondName, int birthYear) {
        super(lastName, firstName, secondName, birthYear);
    }

    public Abonent(String lastName, String firstName, String secondName, int birthYear, long id, String address, String creditCardNumber, int debit, int credit, int longDistanceCallTime, int cityCallTime) {
        super(lastName, firstName, secondName, birthYear);
        this.id = id;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.longDistanceCallTime = longDistanceCallTime;
        this.cityCallTime = cityCallTime;
    }

    @NonNull
    @Override
    public String toString() {
        return "Abonent{" +
                "id=" + id +
                ", ФИО=" + getFullName() +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", longDistanceCallTime=" + longDistanceCallTime +
                ", cityCallTime=" + cityCallTime +
                '}';
    }
}