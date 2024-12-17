package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Clerk;

public interface ClerkRepository extends JpaRepository<Clerk, Long> {

}
