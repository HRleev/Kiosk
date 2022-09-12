package com.its.kiosk.entity;


import com.its.kiosk.dto.CouponDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Coupon_table")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String mobile;

    @Column
    private int coupon;


    public static CouponEntity toEntity(CouponDTO couponDTO) {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setMobile(couponDTO.getMobile());
        couponEntity.setCoupon(1);
        return couponEntity;
    }
}
