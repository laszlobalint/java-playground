package com.flowacademy.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FirstTests {
    Count count = new Count();
    Employee emp = new Employee();

    @Test
    public void mySimpleEqualsTest() {
        String expectedName = "José";
        assertEquals(expectedName, "José");
    }

    @Test
    public void sumTest() {
        assertEquals(count.sum(4, 3), 7);
    }

    @Test
    public void divTest() {
        assertNotEquals(count.div(4, 3), 7);
    }

    @Test
    public void jsonTest() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("example.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Employee emp = objectMapper.readValue(jsonData, Employee.class);
        assertEquals(emp.getName(), "Pankaj");
    }

    @Test
    public void jsonTest2() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("example.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Employee emp = objectMapper.readValue(jsonData, Employee.class);
        assertEquals(emp.getName(), "Balint");
    }
}
