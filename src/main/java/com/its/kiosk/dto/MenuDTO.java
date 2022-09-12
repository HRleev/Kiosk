package com.its.kiosk.dto;


import com.its.kiosk.entity.MenuEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    private Long id;
    private String menu;
    private int price;
    private String menuFileName;

    public static MenuDTO toDTO(MenuEntity menuEntity){
        MenuDTO menuDTO=new MenuDTO();

        menuDTO.setId(menuEntity.getId());
        menuDTO.setMenu(menuEntity.getMenu());
        menuDTO.setPrice(menuEntity.getPrice());
        menuDTO.setMenuFileName(menuEntity.getMenuFileName());
        return menuDTO;
    }
}
