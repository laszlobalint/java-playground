package com.flowacademy.test;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.flowacademy.test.Address;
import com.flowacademy.test.Employee;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonObjectMapperExample {

    public static void main(String[] args) throws IOException {

        //Read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get("example.json"));

        //Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //Convert Json string to object
        Employee emp = objectMapper.readValue(jsonData, Employee.class);

        System.out.println("com.flowacademy.test.Employee Object\n" + emp);

        //Convert Object to Json string
        Employee emp1 = createEmployeeAndWriteFile();

        //Configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //Writing to console, can write to any output stream such as file
        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, emp1);
        System.out.println("com.flowacademy.test.Employee JSON is\n" + stringEmp);
    }

    public static Employee createEmployeeAndWriteFile() throws IOException {

        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("David");
        emp.setPermanent(false);
        emp.setPhoneNumbers(new long[]{123456, 987654});
        emp.setRole("Manager");

        Address add = new Address();
        add.setCity("Bangalore");
        add.setStreet("BTM 1st Stage");
        add.setZipcode(560100);
        emp.setAddress(add);

        List <String> cities = new ArrayList <>();
        cities.add("Los Angeles");
        cities.add("New York");
        emp.setCities(cities);

        Map <String, String> props = new HashMap <>();
        props.put("salary", "1000 Rs");
        props.put("age", "28 years");
        emp.setProperties(props);

        // Write Json to file:
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("newJson.json"), emp);
        return emp;
    }
}