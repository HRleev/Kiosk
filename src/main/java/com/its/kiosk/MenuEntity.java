package com.its.kiosk;

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

    @Column
    private String type;

    @Column
    private int shot1;

    @Column
    private int shot2;

}
