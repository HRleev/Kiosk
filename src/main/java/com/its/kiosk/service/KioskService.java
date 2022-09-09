package com.its.kiosk.service;

import com.its.kiosk.dto.KioskDTO;
import com.its.kiosk.entity.KioskEntity;
import com.its.kiosk.repository.KioskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KioskService {

    private final KioskRepository kioskRepository;
    public KioskDTO orderSave(KioskDTO kioskDTO) {
        kioskRepository.save(KioskEntity.toEntity(kioskDTO));
        return KioskDTO.toDTO(kioskRepository.save(KioskEntity.toEntity(kioskDTO)));
    }
}
