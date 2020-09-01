package com.microcenter.repository;

import com.microcenter.entity.Laptop;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository  extends CrudRepository<Laptop, Integer>
{
}
