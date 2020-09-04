package com.microcenter.api;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/laptops")
@Validated
public class LaptopApi
{
    @Autowired
    private LaptopService laptopService;

    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public ResponseEntity<LaptopDTO> getLaptop(@PathVariable Integer id)
    {
        LaptopDTO laptop = laptopService.getLaptop(id);
        return new ResponseEntity<>(laptop, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<LaptopDTO>> getLaptops()
    {
        List<LaptopDTO> laptops = laptopService.getLaptops();
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<LaptopDTO> addLaptop(@Valid @RequestBody  LaptopDTO laptopDTO)
    {
        Integer laptopId = laptopService.addLaptop(laptopDTO);
        return new ResponseEntity<>(laptopDTO, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<LaptopDTO> updateSpecs(@Valid @RequestBody LaptopDTO laptopDTO)
    {
        laptopService.updateSpecs(laptopDTO);
        return new ResponseEntity<>(laptopDTO, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable Integer id)
    {
        laptopService.deleteLaptop(id);
        return new ResponseEntity<>(environment.getProperty("API.LAPTOP_DELETE_SUCCESS")+" "+id,
                HttpStatus.OK);
    }

    @GetMapping("/ram/{ram}")
    public ResponseEntity<List<LaptopDTO>> getAllLaptopsWithRam(@PathVariable Integer ram)
    {
        List<LaptopDTO> laptops = laptopService.getAllByRam(ram);
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }
}
