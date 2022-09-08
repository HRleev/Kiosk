package com.its.kiosk;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    Long id;
    String menu;
    Long price;
    String type;
    int shot1;
    int shot2;

}
