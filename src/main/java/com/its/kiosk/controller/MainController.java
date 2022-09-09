package com.its.kiosk.controller;

import com.its.kiosk.dto.KioskDTO;
import com.its.kiosk.dto.MenuDTO;
import com.its.kiosk.service.KioskService;
import com.its.kiosk.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final KioskService kioskService;
    private final MenuService menuService;

    @GetMapping("/")
    public String index () {
        return "index";
    }

    @GetMapping("/kioskMain")
    public String menu(Model model) {
        List<MenuDTO> menuDTOList = new ArrayList<>();
        menuDTOList = menuService.findAll();

        model.addAttribute("menu", menuDTOList);
        return "kioskMain";
    }
    //    @GetMapping("/menuChoose")
//    public String menuChoose(@RequestParam("coffeeId") Long coffeeId, Model model) {
//        return null;
//    }
    @PostMapping("/orderSave")
    public @ResponseBody KioskDTO orderSave(@ModelAttribute KioskDTO kioskDTO,
                            Model model) {
        KioskDTO result = kioskService.orderSave(kioskDTO);

        return result;
    }

    @GetMapping("/orderDelete/{id}")
    public String orderDelete(@PathVariable("id") Long id) {
        kioskService.orderDelete(id);
        return "redirect:/kioskMain";
    }
}