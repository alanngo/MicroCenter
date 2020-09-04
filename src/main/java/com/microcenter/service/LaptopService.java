package com.microcenter.service;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.entity.Laptop;

import java.util.List;

public interface LaptopService
{
    //basic operations
    Integer addLaptop(LaptopDTO laptopDTO);
    LaptopDTO getLaptop(Integer id);
    List<LaptopDTO> getLaptops();
    void updateSpecs(LaptopDTO laptopDTO);
    void deleteLaptop(Integer id);

    //advanced operations
    List<LaptopDTO> getAllByRam(Integer ramSize);
    List<LaptopDTO> getAllByCPU(String cpuCompany);
}
