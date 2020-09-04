package com.microcenter.repository;

import com.microcenter.entity.Laptop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LaptopRepository  extends CrudRepository<Laptop, Integer>
{
    List<Laptop> findAllByRam(Integer ram);
}
