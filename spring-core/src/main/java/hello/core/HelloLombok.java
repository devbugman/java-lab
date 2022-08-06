package hello.core;

import lombok.*;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("Hello World");
        String name1 = helloLombok.getName();
        System.out.println("name1 = " + name1);
        System.out.println("helloLombok = " + helloLombok);
    }
}
