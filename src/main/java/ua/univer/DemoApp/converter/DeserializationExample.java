package ua.univer.DemoApp.converter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Log
public class DeserializationExample {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = """
                {"id":2,"name":"Ali Z","certificates":[{"name":"ORACLE","year":2000},{"name":"SUN","year":2015}],"dep":{"name":"Computer Science"}}
                """;
        Student student = objectMapper.readValue(json, Student.class);
        log.info(String.valueOf(student));
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
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
