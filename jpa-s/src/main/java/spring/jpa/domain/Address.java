package spring.jpa.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    
    private String street;

    private String zipcode;

    // Jpa 스펙상 맞는거구나 함부로 new로 생성하지말자 ;
    protected Address(){}

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
