package com.hb.guillaume_jason.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hb.guillaume_jason.model.Identifiable;
import com.hb.guillaume_jason.model.Post;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AbstractRepository<T extends Identifiable> {
    protected String fileName;

    public AbstractRepository(String fileName) {
        this.fileName = fileName;
    }

    public List<T> getAll() {
        return this.readFromData();
    }

    public T findById(Integer id) {
        for(T value : this.getAll()) {
            if (Objects.equals(value.getId(), id)) {
                return value;
            }
        }
        return null;
    }

    public boolean save(T value) {
        List<T> existingValues = this.getAll();
        int newId = 0;
        for (T existingValue : existingValues) {
            if (existingValue.getId().equals(value.getId())) {
                return false;
            }
            if (existingValue.getId() >= newId) {
                newId = existingValue.getId() + 1;
            }
        }

        value.setId(newId);
        existingValues.add(value);

        ObjectMapper mapper = new ObjectMapper();
        try {
            File newFile = new File("src/main/resources/" + this.fileName);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(existingValues);
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            writer.write(jsonString);
            writer.close();

            return true;
        }catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    protected List<T> readFromData() {
        ObjectMapper mapper = new ObjectMapper();
        List<T> values = new ArrayList<>();
        try {
            File jsonDataFile = new ClassPathResource(this.fileName).getFile();
            values = mapper.readValue(
                    jsonDataFile,
                    new TypeReference<List<T>>() {}
            );
        }catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }
}