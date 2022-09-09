package com.its.kiosk.entity;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "Beverage_Table")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String menu;

    @Column
    private int price;


}
