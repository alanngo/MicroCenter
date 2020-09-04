package com.microcenter.utility;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.entity.Laptop;

public class Utils
{
    public static LaptopDTO getDTOFrom(Laptop laptop)
    {
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

    public static Laptop getEntityFrom(LaptopDTO laptopDTO)
    {
        Laptop laptop = new Laptop();
        if (laptopDTO!=null)
        {
            laptop.setName(laptopDTO.getName());
            laptop.setCpu(laptopDTO.getCpu());
            laptop.setRam(laptopDTO.getRam());
            laptop.setNvme(laptopDTO.getNvme());
            laptop.setSsd(laptopDTO.getSsd());
            laptop.setHdd(laptopDTO.getHdd());
            laptop.setGpu(laptopDTO.getGpu());
        }
        return laptop;
    }
}
