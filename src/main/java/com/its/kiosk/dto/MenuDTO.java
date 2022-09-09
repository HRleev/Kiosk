package com.its.kiosk.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    Long id;
    String menu;
    Long price;
}
