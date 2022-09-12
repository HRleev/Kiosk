package com.its.kiosk.service;

import com.its.kiosk.dto.CouponDTO;
import com.its.kiosk.entity.CouponEntity;
import com.its.kiosk.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;


    public int coupon(CouponDTO couponDTO) {
        Optional<CouponEntity> optionalCouponEntity = couponRepository.findByMobile(couponDTO.getMobile());
        int couponCount = 0;
        if (optionalCouponEntity.isPresent()) {
            CouponEntity couponEntity = optionalCouponEntity.get();
            int coupon = couponEntity.getCoupon();
            int totalCoupon = coupon + 1;
            couponEntity.setCoupon(totalCoupon);
            couponRepository.save(couponEntity);
            couponCount = couponEntity.getCoupon();
        } else {
            couponRepository.save(CouponEntity.toEntity(couponDTO));
            couponCount = 1;
        }
        return couponCount;
    }
}
