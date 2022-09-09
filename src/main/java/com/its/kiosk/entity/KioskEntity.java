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
    String menu;

    @Column
    int shot;

    @Column
    int price;

    @Column
    String temp;
    public static KioskEntity toEntity(KioskDTO kioskDTO){

        KioskEntity kioskEntity=new KioskEntity();

        kioskEntity.setMenu(kioskDTO.getMenu());
        kioskEntity.setShot(kioskDTO.getShot());
        kioskEntity.setTemp(kioskDTO.getTemp());
        kioskEntity.setPrice(kioskDTO.getPrice());

        return kioskEntity;

    }
}
