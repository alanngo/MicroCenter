package com.microcenter.service;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.entity.Laptop;

import java.util.List;

public interface LaptopService
{
    Integer addLaptop(LaptopDTO laptopDTO);
    Laptop getLaptop(Integer id);
    List<LaptopDTO> getLaptops();
    void updateSpecs(LaptopDTO laptopDTO);
    void deleteLaptop(Integer id);
}
