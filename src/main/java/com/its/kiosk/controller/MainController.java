package com.its.kiosk.controller;

import com.its.kiosk.dto.KioskDTO;
import com.its.kiosk.service.KioskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final KioskService kioskService;

    @GetMapping("/")
    public String index () {
        return "index";
    }

    @GetMapping("/menu")
    public String menu() {
        return "kioskMain";
    }
    //    @GetMapping("/menuChoose")
//    public String menuChoose(@RequestParam("coffeeId") Long coffeeId, Model model) {
//        return null;
//    }
    @PostMapping("/orderSave")
    public String orderSave(@ModelAttribute KioskDTO kioskDTO,
                            Model model) {
        KioskDTO kioskDTO1 = kioskService.orderSave(kioskDTO);
        model.addAttribute("orderDetail", kioskDTO1);
        return "kioskMain";
    }
}
