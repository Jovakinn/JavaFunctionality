package ua.univer.DemoApp.converter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;

@Log
public class SerializationExample {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Certificate certificateOracle = new Certificate();
        certificateOracle.name = "ORACLE";
        certificateOracle.year = 2000;
        Certificate certificateSun = new Certificate();
        certificateSun.name = "SUN";
        certificateSun.year = 2015;

        Department department = new Department();
        department.setName("Computer Science");

        Student student = new Student();
        student.id = 2;
        student.department = department;
        student.name = "Ali Z";
        student.certificates = Arrays.asList(certificateOracle, certificateSun);

        String json = objectMapper.writeValueAsString(student);
        log.info(json);
    }

    static class Student {
        private int id;
        private String name;

        @JsonProperty("dep")
        private Department department;

        private List<Certificate> certificates;

        public List<Certificate> getCertificates() {
            return certificates;
        }

        public void setCertificates(List<Certificate> certificates) {
            this.certificates = certificates;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Student{"
                    + "name='" + name + '\'' + ", id='" + id + '\''
                    + '}';
        }
    }

    static class Department {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Certificate {

        private String name;
        private int year;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
