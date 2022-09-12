package com.its.kiosk.controller;

import com.its.kiosk.dto.CouponDTO;
import com.its.kiosk.dto.KioskDTO;
import com.its.kiosk.dto.MenuDTO;
import com.its.kiosk.service.CouponService;
import com.its.kiosk.service.KioskService;
import com.its.kiosk.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final KioskService kioskService;
    private final MenuService menuService;

    private final CouponService couponService;

    // 인덱스 처음페이지
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 메뉴 선택 페이지 호출 + 메뉴 뿌리기
    @GetMapping("/kioskMain")
    public String menu(Model model) {
        List<MenuDTO> menuDTOList = new ArrayList<>();
        List<KioskDTO> kioskDTOList = new ArrayList<>();
        menuDTOList = menuService.findAll();

        model.addAttribute("menu", menuDTOList);
        return "main";
    }

    // 주문한거 저장
    @PostMapping("/orderSave")
    public @ResponseBody List<KioskDTO> orderSave(@ModelAttribute KioskDTO kioskDTO,
                                                  Model model) {

        List<KioskDTO> kioskDTOList = new ArrayList<>();
        kioskService.orderSave(kioskDTO);
        kioskDTOList = kioskService.findAll();
        return kioskDTOList;
    }

    // 카트목록 삭제
    @DeleteMapping("/cartDelete")
    public @ResponseBody List<KioskDTO> cartDelete(@RequestParam("id") Long id) {
        List<KioskDTO> kioskDTOList = new ArrayList<>();
        kioskService.cartDelete(id);
        kioskDTOList = kioskService.findAll();

        return kioskDTOList;
    }

    // 주문후 주문내역 삭제
    @DeleteMapping("/orderDelete")
    public @ResponseBody void orderDelete() {
        kioskService.orderDelete();
    }

    // 쿠폰적립
    @PostMapping("/coupon")
    public @ResponseBody int coupon(@ModelAttribute CouponDTO couponDTO) {
        int result = couponService.coupon(couponDTO);

        return result;
    }

    // 주문 총 가격
    @GetMapping("/totalPrice")
    public @ResponseBody String totalPrice() {
        List<KioskDTO> kioskDTOList = new ArrayList<>();
        kioskDTOList = kioskService.findAll();
        int totalPrice = 0;
        int result = 0;
        for (int i = 0; i < kioskDTOList.size(); i++) {
            totalPrice = kioskDTOList.get(i).getPrice() + kioskDTOList.get(i).getShot();
            result += totalPrice;
        }
        String str = String.valueOf(result);
        return str;
    }
}