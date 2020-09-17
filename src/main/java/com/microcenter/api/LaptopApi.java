package com.microcenter.api;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.exception.MicroCenterException;
import com.microcenter.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/laptops")
@CrossOrigin
@Validated
public class LaptopApi
{
    @Autowired
    private LaptopService laptopService;

    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public ResponseEntity<LaptopDTO> getLaptop(@PathVariable Integer id) throws MicroCenterException
    {
        LaptopDTO laptop = laptopService.getLaptop(id);
        return new ResponseEntity<>(laptop, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<LaptopDTO>> getLaptops()
    {
        List<LaptopDTO> laptops = laptopService.getLaptops();
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<LaptopDTO> addLaptop(@Valid @RequestBody LaptopDTO laptopDTO)
    {
        LaptopDTO added = laptopService.addLaptop(laptopDTO);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<LaptopDTO> updateSpecs(@Valid @RequestBody LaptopDTO laptopDTO)
            throws MicroCenterException
    {
        laptopService.updateSpecs(laptopDTO);
        return new ResponseEntity<>(laptopDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LaptopDTO> deleteLaptop(@PathVariable Integer id)
            throws MicroCenterException
    {
        LaptopDTO deleted = laptopService.deleteLaptop(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }


    @GetMapping("/cpu/{cpu}")
    public ResponseEntity<List<LaptopDTO>> getAllLaptopsWithCPU(@PathVariable String cpu)
    {
        List<LaptopDTO> laptops = laptopService.getAllByCPU(cpu);
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }

    @GetMapping("/ram/{ram}")
    public ResponseEntity<List<LaptopDTO>> getAllLaptopsWithRam(@PathVariable Integer ram)
    {
        List<LaptopDTO> laptops = laptopService.getAllByRam(ram);
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }
}
