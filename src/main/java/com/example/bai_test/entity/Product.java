package com.example.bai_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

        @Column(name = "color")
    private String color;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "origin_price")
    private Double originPrice;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "subcate_id",referencedColumnName = "id")
    private SubCategory subCategory;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_brand",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private Set<Brand> product_Brand;

}
