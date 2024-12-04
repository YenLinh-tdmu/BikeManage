package com.example.BikeManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BikeManage.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {}
