package com.its.kiosk.service;

import com.its.kiosk.dto.KioskDTO;
import com.its.kiosk.entity.KioskEntity;
import com.its.kiosk.repository.KioskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KioskService {

    private final KioskRepository kioskRepository;

    public void orderSave(KioskDTO kioskDTO) {
        kioskRepository.save(KioskEntity.toEntity(kioskDTO));
    }

    public List<KioskDTO> findAll() {
        List<KioskDTO> kioskDTOList = new ArrayList<>();

        List<KioskEntity> kioskEntityList = kioskRepository.findAll();
        for (KioskEntity kiosk: kioskEntityList) {
            kioskDTOList.add(KioskDTO.toDTO(kiosk));
        }
        return kioskDTOList;
    }

    public void cartDelete(Long id) {
        kioskRepository.deleteById(id);
    }

    public void orderDelete() {
        kioskRepository.deleteAll();
    }
}
