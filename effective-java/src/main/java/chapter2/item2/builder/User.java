package chapter2.item2.builder;

public class User {
    private final String name; // 필수
    private final String phoneNumber; // 필수
    private final int age; // 선택
    private final String nickname; // 선택
    private final String address;

    static class Builder {
        private final String name; // 필수
        private final String phoneNumber; // 필수

        private int age; // 선택
        private String nickname; // 선택
        private String address;

        public Builder(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public User(Builder builder) {
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
        this.nickname = builder.nickname;
        this.address = builder.address;
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
