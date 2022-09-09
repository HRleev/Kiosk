package com.its.kiosk.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Beverage_Table")
public class OptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int shot1;

    @Column
    private int shot2;

    @Column
    private String type;


}
