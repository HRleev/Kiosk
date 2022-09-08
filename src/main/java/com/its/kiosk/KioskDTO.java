package com.its.kiosk;


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
}
