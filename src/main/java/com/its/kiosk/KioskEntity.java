package com.its.kiosk;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kiosk_table")
public class KioskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String beverage;

    @Column
    int shot;

    @Column
    int price;

    @Column
    int coupon;
}
