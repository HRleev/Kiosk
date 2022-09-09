package com.its.kiosk.dto;


import com.its.kiosk.entity.MenuEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    Long id;
    String menu;
    int price;

    public static MenuDTO toDTO(MenuEntity menuEntity){
        MenuDTO menuDTO=new MenuDTO();

        menuDTO.setId(menuEntity.getId());
        menuDTO.setMenu(menuEntity.getMenu());
        menuDTO.setPrice(menuEntity.getPrice());

        return menuDTO;
    }
}
