package com.microcenter.service;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.entity.Laptop;

import static com.microcenter.utility.Utils.getDTOFrom;
import static com.microcenter.utility.Utils.getEntityFrom;

import com.microcenter.exception.MicroCenterException;
import com.microcenter.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service(value = "laptopService")
@Transactional
public class LaptopServiceImpl implements LaptopService
{
    @Autowired
    private LaptopRepository laptopRepository;

    // basic operations
    @Override
    public LaptopDTO addLaptop(LaptopDTO laptopDTO)
    {
        Laptop laptop = getEntityFrom(laptopDTO);
        Integer id = laptopRepository.save(laptop).getId();
        laptopDTO.setId(id);
        return laptopDTO;
    }

    @Override
    public LaptopDTO getLaptop(Integer id) throws MicroCenterException 
    {
        Laptop laptop = laptopRepository.findById(id)
                .orElseThrow(() -> new MicroCenterException("Service.LAPTOP_NOT_FOUND"));
        return getDTOFrom(laptop);
    }

    @Override
    public List<LaptopDTO> getLaptops()
    {
        List<LaptopDTO> laptopList = new ArrayList<>();
        laptopRepository.findAll().forEach(laptop ->
        {
            LaptopDTO laptopDTO = getDTOFrom(laptop);
            laptopList.add(laptopDTO);
        });
        return laptopList;
    }

    @Override
    public void updateSpecs(LaptopDTO laptopDTO) throws MicroCenterException
    {
        Laptop laptop = laptopRepository.findById(laptopDTO.getId())
                .orElseThrow(() -> new MicroCenterException("Service.LAPTOP_NOT_FOUND"));
        laptop.setName(laptopDTO.getName());
        laptop.setCpu(laptopDTO.getCpu());
        laptop.setRam(laptopDTO.getRam());
        laptop.setNvme(laptopDTO.getNvme());
        laptop.setSsd(laptopDTO.getSsd());
        laptop.setHdd(laptopDTO.getHdd());
        laptop.setGpu(laptopDTO.getGpu());

    }

    @Override
    public LaptopDTO deleteLaptop(Integer id) throws MicroCenterException
    {
        Laptop laptop = laptopRepository.findById(id)
                .orElseThrow(() -> new MicroCenterException("Service.LAPTOP_NOT_FOUND"));
        laptopRepository.deleteById(id);
        return getDTOFrom(laptop);
    }

    @Override
    public List<LaptopDTO> getAllByRam(Integer ramSize)
    {
        List<LaptopDTO> laptopDTOList = new ArrayList<>();
        List<Laptop> laptops = laptopRepository.findAllByRam(ramSize);
        laptops.forEach(laptop ->
        {
            LaptopDTO laptopDTO = getDTOFrom(laptop);
            laptopDTOList.add(laptopDTO);
        });
        return laptopDTOList;
    }

    @Override
    public List<LaptopDTO> getAllByCPU(String cpuCompany)
    {
        List<LaptopDTO> laptopDTOList = new ArrayList<>();
        List<Laptop> laptops = laptopRepository.getByCPUCompany(cpuCompany);
        laptops.forEach(laptop ->
        {
            LaptopDTO laptopDTO = getDTOFrom(laptop);
            laptopDTOList.add(laptopDTO);
        });
        return laptopDTOList;
    }


}
