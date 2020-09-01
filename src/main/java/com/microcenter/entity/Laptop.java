package com.microcenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Laptop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String cpu;
    private Integer ram;
    private Integer nvme;
    private Integer ssd;
    private Integer hdd;
    private String gpu;

    public Laptop(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getNvme() {
        return nvme;
    }

    public void setNvme(Integer nvme) {
        this.nvme = nvme;
    }

    public Integer getSsd() {
        return ssd;
    }

    public void setSsd(Integer ssd) {
        this.ssd = ssd;
    }

    public Integer getHdd() {
        return hdd;
    }

    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Laptop)) return false;
        if (obj == this) return true;

        Laptop other = (Laptop) obj;

        return id.equals(other.id);
    }

    @Override
    public String toString()
    {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", nvme=" + nvme +
                ", ssd=" + ssd +
                ", hdd=" + hdd +
                ", gpu='" + gpu + '\'' +
                '}';
    }
}
