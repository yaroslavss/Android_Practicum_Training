package com.example.user.javacoretraining.classes;

import com.example.user.javacoretraining.collections.Person;

import java.util.ArrayList;
import java.util.List;

/*
  VII

  Задача на взаимодействие между классами. Разработать систему «Интернет-магазин».
  Товаровед добавляет информацию о Товаре. Клиент делает и оплачивает Заказ на Товары.
  Товаровед регистрирует Продажу и может занести неплательщика в «черный список».
 */
public class Eshop {

    private final String name;
    private List<Item> items = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Customer> bannedCustomers = new ArrayList<>();
    private Seller seller;

    private static int orderId;

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Seller getSeller() {
        return seller;
    }

    public Eshop(String name, Seller seller) {
        this.name = name;
        this.seller = seller;
    }

    public int generateId() {
        return ++orderId;
    }

    /*
      Класс Товар
     */
    class Item {

        private final int id;
        private String name;
        private double price;

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public Item(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    /*
      Класс Заказ
     */
    class Order {

        private final int id;
        private int customerId;
        private List<Item> items = new ArrayList<>();
        private double totalAmount;
        private boolean isPaid = false;

        public int getId() {
            return id;
        }

        public int getCustomerId() {
            return customerId;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        Order(int customerId) {
            this.id = generateId();
            this.customerId = customerId;
        }

        public void addItem(Item item) {
            items.add(item);
            totalAmount += item.getPrice();
        }
    }

    /*
      Класс Товаровед
     */
    class Seller extends Person {

        public Seller(String lastName, String firstName, String secondName, int birthYear) {
            super(lastName, firstName, secondName, birthYear);
        }

        /*
          Товаровед добавляет информацию о Товаре
         */
        public void addItem(Item item) {
            items.add(item);
        }

        /*
          Товаровед регистрирует Продажу
         */
        public void registerOrder(int orderId, double amount, Customer customer) {
            Order order = orders.get(orderId);
            if (amount == order.totalAmount) {
                order.isPaid = true;
            } else
                banCustomer(customer);
        }

        /*
          Товаровед может занести неплательщика в «черный список»
         */
        public void banCustomer(Customer customer) {
            bannedCustomers.add(customer);
        }
    }

    /*
      Класс Клиент
     */
    class Customer extends Person {

        private final int id;

        public int getId() {
            return id;
        }

        public Customer(String lastName, String firstName, String secondName, int birthYear, int id) {
            super(lastName, firstName, secondName, birthYear);
            this.id = id;
        }

        /*
          Клиент делает Заказ на Товары.
         */
        public void createOrder(List<Item> items) {
            Order order = new Order(id); // customer id
            for (Item item : items) {
                order.addItem(item);
            }
            orders.add(order);
        }

        /*
          Клиент оплачивает Заказ на Товары.
         */
        public void payOrder(int orderId, double amount) {
            seller.registerOrder(orderId, amount, this);
        }
    }
}