package com.its.kiosk;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final KioskService kioskService;

    @GetMapping("/")
    public String index () {
        return "index";
    }
}
