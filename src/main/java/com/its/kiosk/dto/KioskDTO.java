package com.its.kiosk.dto;


import com.its.kiosk.entity.KioskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KioskDTO {
    private Long id;
    private String menu;
    private String temp;
    private int shot;
    private int price;

    public static KioskDTO toDTO(KioskEntity kioskEntity){
        KioskDTO kioskDTO=new KioskDTO();

        kioskDTO.setId(kioskEntity.getId());
        kioskDTO.setTemp(kioskEntity.getTemp());
        kioskDTO.setMenu(kioskEntity.getMenu());
        kioskDTO.setShot(kioskEntity.getShot());
        kioskDTO.setPrice(kioskEntity.getPrice());
        return kioskDTO;
    }

}
