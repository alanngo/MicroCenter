package com.microcenter.service;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.entity.Laptop;
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

    @Override
    public Integer addLaptop(LaptopDTO laptopDTO) {
        return null;
    }

    @Override
    public LaptopDTO getLaptop(Integer id)
    {
        Laptop laptop = laptopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MicroCenterException"));
        return new LaptopDTO
                (
                    laptop.getId(),
                    laptop.getName(),
                    laptop.getCpu(),
                    laptop.getRam(),
                    laptop.getNvme(),
                    laptop.getSsd(),
                    laptop.getHdd(),
                    laptop.getGpu()
                );
    }

    @Override
    public List<LaptopDTO> getLaptops()
    {
        List<LaptopDTO> laptopList = new ArrayList<>();
        laptopRepository.findAll().forEach(laptop ->
        {
            LaptopDTO laptopDTO = new LaptopDTO
                    (
                            laptop.getId(),
                            laptop.getName(),
                            laptop.getCpu(),
                            laptop.getRam(),
                            laptop.getNvme(),
                            laptop.getSsd(),
                            laptop.getHdd(),
                            laptop.getGpu()
                    );
            laptopList.add(laptopDTO);
        });
        return laptopList;
    }

    @Override
    public void updateSpecs(LaptopDTO laptopDTO) {

    }

    @Override
    public void deleteLaptop(Integer id) {

    }
}
