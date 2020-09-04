package com.microcenter.service;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.entity.Laptop;
import com.microcenter.exception.MicroCenterException;

import java.util.List;

public interface LaptopService
{
    //basic operations
    Integer addLaptop(LaptopDTO laptopDTO);
    LaptopDTO getLaptop(Integer id) throws MicroCenterException;
    List<LaptopDTO> getLaptops();
    void updateSpecs(LaptopDTO laptopDTO) throws MicroCenterException;
    void deleteLaptop(Integer id);

    //advanced operations
    List<LaptopDTO> getAllByRam(Integer ramSize);
    List<LaptopDTO> getAllByCPU(String cpuCompany);
}
