package chapter3.item11;

import java.util.Objects;

public class Member {
    private final String name;
    private final int age;

    public Member(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        final Member member = (Member) o;
        return age == member.age && Objects.equals(name, member.name);
    }

}
