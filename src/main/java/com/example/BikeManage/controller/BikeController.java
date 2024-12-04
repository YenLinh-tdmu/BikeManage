package com.example.BikeManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BikeManage.entity.Bike;
import com.example.BikeManage.service.BikeService;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    // Lấy danh sách xe đạp
    @GetMapping
    public List<Bike> getAllBikes() {
        return bikeService.getAllBikes();
    }

    // Thêm xe đạp mới
    @PostMapping
    public Bike addBike(@RequestBody Bike bike) {
        return bikeService.addBike(bike);
    }

    // Xóa xe đạp theo ID
    @DeleteMapping("/{id}")
    public void deleteBike(@PathVariable Long id) {
        bikeService.deleteBike(id);
    }
}

