package com.microcenter.api;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
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
    public ResponseEntity<String> addLaptop(@RequestBody LaptopDTO laptopDTO)
    {
        Integer laptopId = laptopService.addLaptop(laptopDTO);
        return new ResponseEntity<>(environment.getProperty("API.LAPTOP_ADD_SUCCESS")+laptopId,
                HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateSpecs(@RequestBody LaptopDTO laptopDTO)
    {
        laptopService.updateSpecs(laptopDTO);
        return new ResponseEntity<>(environment.getProperty("API.LAPTOP_UPDATE_SUCCESS")+laptopDTO.getId(),
                HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable Integer id)
    {
        laptopService.deleteLaptop(id);
        return new ResponseEntity<>(environment.getProperty("API.LAPTOP_DELETE_SUCCESS")+id,
                HttpStatus.OK);
    }

}
