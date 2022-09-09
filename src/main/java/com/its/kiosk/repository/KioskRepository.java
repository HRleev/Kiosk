package com.its.kiosk.repository;

import com.its.kiosk.entity.KioskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KioskRepository extends JpaRepository<KioskEntity,Long> {

}
