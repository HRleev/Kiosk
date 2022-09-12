package com.its.kiosk.service;

import com.its.kiosk.dto.MenuDTO;
import com.its.kiosk.entity.MenuEntity;
import com.its.kiosk.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<MenuDTO> findAll() {
        List<MenuDTO> menuDTOList = new ArrayList<>();

        List<MenuEntity> menuEntityList = menuRepository.findAll();
        for (MenuEntity menu: menuEntityList) {
            menuDTOList.add(MenuDTO.toDTO(menu));
        }
        return menuDTOList;
    }
}
