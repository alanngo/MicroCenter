package com.microcenter.api;

import com.microcenter.dto.LaptopDTO;
import com.microcenter.entity.Laptop;
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
    public ResponseEntity<Laptop> getLaptop(@PathVariable Integer id)
    {
        //TODO: implement
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<List<LaptopDTO>>  getLaptops()
    {
        //TODO: implement
        List<LaptopDTO> laptops = laptopService.getLaptops();
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }

    @PostMapping("/")
    public Integer addLaptop(@RequestBody LaptopDTO laptopDTO)
    {
        //TODO: implement
        return null;
    }

    @PutMapping("/")
    public void updateSpecs(@RequestBody LaptopDTO laptopDTO)
    {
        //TODO: implement
    }

    @DeleteMapping("{id}")
    public void deleteLaptop(@PathVariable Integer id)
    {
        //TODO: implement
    }

}
