package com.microcenter.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Objects;

public class LaptopDTO
{
    private Integer id;
    @NotNull(message = "microcenter.name.required")
    private String name;


    @NotNull(message = "microcenter.cpu.required")
    @Pattern(regexp = "(Intel core i[3579] [0-9]{4,}[A-Za-z]*)" +
                        "|(AMD Ryzen [3579] [0-9]{4,}[A-Za-z]*)",
            message = "microcenter.cpu.invalid")
    private String cpu;

    @NotNull(message = "microcenter.ram.required")
    @Min(value = 4, message = "microcenter.ram.invalid")
    private Integer ram;


    private Integer nvme;


    private Integer ssd;


    private Integer hdd;

    @NotNull(message = "microcenter.gpu.required")
    @Pattern(regexp = "(Intel U?HD [56][23]0)|" +
                        "([Nn]vidia Geforce [GR]TX [123][06][5678]0)(| super| Ti)",
            message = "microcenter.gpu.invalid")
    private String gpu;

    public LaptopDTO(){}

    public LaptopDTO
            (
                 Integer id,
                 String name,
                 String cpu,
                 Integer ram,
                 Integer nvme,
                 Integer ssd,
                 Integer hdd,
                 String gpu
            )
    {
        this();
        setId(id);
        setName(name);
        setCpu(cpu);
        setRam(ram);
        setNvme(nvme);
        setSsd(ssd);
        setHdd(hdd);
        setGpu(gpu);
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

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
        if (!(obj instanceof LaptopDTO)) return false;
        if (obj == this) return true;

        LaptopDTO other = (LaptopDTO) obj;

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
