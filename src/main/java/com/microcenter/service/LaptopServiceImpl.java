package com.microcenter.service;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.entity.Laptop;

import static com.microcenter.util.Utils.getDTOFrom;
import static com.microcenter.util.Utils.getEntityFrom;
import com.microcenter.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Service(value = "laptopService")
@Transactional
public class LaptopServiceImpl implements LaptopService
{
    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public Integer addLaptop(LaptopDTO laptopDTO)
    {
        Laptop laptop = getEntityFrom(laptopDTO);
        return laptopRepository.save(laptop).getId();
    }

    @Override
    public LaptopDTO getLaptop(Integer id)
    {
        Laptop laptop = laptopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MicroCenterException"));
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
    public void updateSpecs(LaptopDTO laptopDTO)
    {
        Laptop laptop = laptopRepository.findById(laptopDTO.getId())
                .orElseThrow(() -> new RuntimeException("MicroCenterException"));
        laptop.setName(laptopDTO.getName());
        laptop.setCpu(laptopDTO.getCpu());
        laptop.setRam(laptopDTO.getRam());
        laptop.setNvme(laptopDTO.getNvme());
        laptop.setSsd(laptopDTO.getSsd());
        laptop.setHdd(laptopDTO.getHdd());
        laptop.setGpu(laptopDTO.getGpu());

    }

    @Override
    public void deleteLaptop(Integer id)
    {
        laptopRepository.deleteById(id);
    }
}
