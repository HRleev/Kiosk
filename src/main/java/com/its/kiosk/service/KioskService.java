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

    public KioskDTO orderSave(KioskDTO kioskDTO) {
        return KioskDTO.toDTO(kioskRepository.save(KioskEntity.toEntity(kioskDTO)));
    }

    public List<KioskDTO> findAll() {
        List<KioskDTO> kioskDTOList = new ArrayList<>();

        List<KioskEntity> kioskEntityList = kioskRepository.findAll();
        for (KioskEntity kiosk: kioskEntityList) {
            kioskDTOList.add(KioskDTO.toDTO(kiosk));
        }
        return kioskDTOList;
    }

    public void orderDelete(Long id) {
        kioskRepository.deleteById(id);
    }
}
