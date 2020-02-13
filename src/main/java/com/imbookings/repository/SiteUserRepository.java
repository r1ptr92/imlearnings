package com.imbookings.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imbookings.model.SiteUser;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {

    Optional<SiteUser> findByName(String name);
}
