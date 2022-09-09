package com.its.kiosk.entity;


import com.its.kiosk.dto.KioskDTO;
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

    @Column
    String mobile;
    public static KioskEntity toEntity(KioskDTO kioskDTO){

        KioskEntity kioskEntity=new KioskEntity();

        kioskEntity.setBeverage(kioskDTO.getBeverage());
        kioskEntity.setShot(kioskDTO.getShot());
        kioskEntity.setPrice(kioskDTO.getPrice());
        kioskEntity.setCoupon(kioskDTO.getPrice());
        kioskEntity.setMobile(kioskDTO.getMobile());

        return kioskEntity;

    }
}
