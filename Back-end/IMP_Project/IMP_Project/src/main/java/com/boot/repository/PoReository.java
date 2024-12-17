package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Po;



@Repository

public interface PoReository extends JpaRepository<Po, Long> {
//	List<Po> findByName(String authorName);
//	Author searchByName(String {

}
