package com.eshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carousel_table")
@Getter@Setter@ToString@NoArgsConstructor
public class CarouselLoader {

    @Id
    private String carouselId;
    @Column
    private String carouselImageUrl;
}
