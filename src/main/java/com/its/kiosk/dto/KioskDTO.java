package com.its.kiosk.dto;


import com.its.kiosk.entity.KioskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KioskDTO {
    Long id;
    String beverage;
    String mobile;
    int shot;
    int price;
    int coupon;

    public static KioskDTO toDTO(KioskEntity kioskEntity){
        KioskDTO kioskDTO=new KioskDTO();

        kioskDTO.setId(kioskEntity.getId());
        kioskDTO.setBeverage(kioskEntity.getBeverage());
        kioskDTO.setMobile(kioskEntity.getMobile());
        kioskDTO.setShot(kioskEntity.getShot());
        kioskDTO.setPrice(kioskEntity.getPrice());
        kioskDTO.setCoupon(kioskDTO.getCoupon());
        return kioskDTO;
    }

}
