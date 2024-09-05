package com.beansNbrew.app.domain;

import com.beansNbrew.app.validators.ValidDeletePart;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@ValidDeletePart
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;



    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;

    @Min(value = 1, message = "Minimum value is 0")
    int min;
    @Max(value = 500, message = "Max value is 500")
    int max;

    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {
    }


    // New constructors including min and max values
    public Part(String name, double price, int inv, int min, int max) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.min = min;
        this.max = max;
    }

    public Part(long id, String name, double price, int inv, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.min = min;
        this.max = max;
    }


//    public Part(String name, double price, int inv) {
//        this.name = name;
//        this.price = price;
//        this.inv = inv;
//    }

//    public Part(long id, String name, double price, int inv) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.inv = inv;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    @Min(value = 1, message = "Minimum value is 0")
    public int getMin() {
        return min;
    }

    public void setMin(@Min(value = 1, message = "Minimum value is 0") int min) {
        this.min = min;
    }

    @Max(value = 500, message = "Max value is 500")
    public int getMax() {
        return max;
    }

    public void setMax(@Max(value = 500, message = "Max value is 500") int max) {
        this.max = max;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    public boolean isInvValid() {
        return this.inv >= this.min && this.inv <= this.max;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
