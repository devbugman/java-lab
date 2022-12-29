package chapter2.item2.telescopingconstructor;

public class User {
    private final String name; // 필수
    private final String phoneNumber; // 필수
    private final int age; // 선택
    private final String nickname; // 선택
    private final String address;

    // 필수 정보
    public User(String name, String phoneNumber) {
        this(name, phoneNumber, 0, null, null);
    }

    // 매개변수 3개
    public User(String name, String phoneNumber, int age) {
        this(name, phoneNumber, age, null, null);
    }

    // 매개변수 3개
    public User(String name, String phoneNumber, int age, String nickname) {
        this(name, phoneNumber, age, nickname, null);
    }

    // 매개변수 5개
    public User(String name, String phoneNumber, int age, String nickname, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.nickname = nickname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }
}
