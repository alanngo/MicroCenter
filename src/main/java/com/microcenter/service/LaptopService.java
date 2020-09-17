package com.microcenter.service;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.exception.MicroCenterException;

import java.util.List;

public interface LaptopService
{
    //basic operations
    LaptopDTO addLaptop(LaptopDTO laptopDTO);
    LaptopDTO getLaptop(Integer id) throws MicroCenterException;
    List<LaptopDTO> getLaptops();
    void updateSpecs(LaptopDTO laptopDTO) throws MicroCenterException;
    LaptopDTO deleteLaptop(Integer id) throws MicroCenterException;

    //advanced operations
    List<LaptopDTO> getAllByRam(Integer ramSize);
    List<LaptopDTO> getAllByCPU(String cpuCompany);
}
