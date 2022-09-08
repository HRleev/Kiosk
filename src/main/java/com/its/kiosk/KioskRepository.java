package com.its.kiosk;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KioskRepository extends JpaRepository<MenuEntity,Long> {
}
