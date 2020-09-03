package com.microcenter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
class MicroCenterApplicationTests
{

	static final String cpuRegex = "(Intel core i[3579] [0-9]{4,}[A-Za-z]*)" +
									"|(AMD Ryzen [3579] [0-9]{4,}[A-Za-z]*)";

	static final String gpuRegex = "(Intel U?HD [56][23]0)|" +
			"([Nn]vidia Geforce [GR]TX [123][06][5678]0)(| super| Ti)";

	@Test
	void testCpuInvalid0()
	{
		String cpu = "Intel core i7";
		assertFalse(cpu.matches(cpuRegex));
	}

	@Test
	void testCpuInvalid1()
	{
		String cpu = "AMD Ryzen 9";
		assertFalse(cpu.matches(cpuRegex));
	}

	@Test
	void testCpuValid0()
	{
		String cpu = "Intel core i3 8350k";
		assertTrue(cpu.matches(cpuRegex));
	}

	@Test
	void testCpuValid1()
	{
		String cpu = "AMD Ryzen 9 3900uh";
		assertTrue(cpu.matches(cpuRegex));
	}

	@Test
	void testGpuInvalid0()
	{
		String gpu = "nvidia";
		assertFalse(gpu.matches(gpuRegex));
	}

	@Test
	void testGpuInvalid1()
	{
		String gpu = "Intel HD";
		assertFalse(gpu.matches(gpuRegex));
	}

	@Test
	void testGpuValid0()
	{
		String gpu = "Nvidia Geforce RTX 2070 super";
		assertTrue(gpu.matches(gpuRegex));
	}
	@Test
	void testGpuValid1()
	{
		String gpu = "Intel UHD 630";
		assertTrue(gpu.matches(gpuRegex));
	}
	@Test
	void testGpuValid2()
	{
		String gpu = "Nvidia Geforce GTX 1070 Ti";
		assertTrue(gpu.matches(gpuRegex));
	}
	@Test
	void testGpuValid3()
	{
		String gpu = "Nvidia Geforce GTX 1080";
		assertTrue(gpu.matches(gpuRegex));
	}

}
