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


abstract public class AbstractRepository<T extends Identifiable> {
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

    public boolean remove(Integer id) {
        List<T> existingValues = this.getAll();
        T valueToRemove = null;
        for (T value : existingValues) {
            if (value.getId().equals(id)) {
                valueToRemove = value;
            }
        }
        if (valueToRemove != null) {
            existingValues.remove(valueToRemove);

            return this.writeToData(existingValues);
        }

        return false;
    }

    public boolean save(T value) {
        List<T> existingValues = this.getAll();
        if (value.getId() == null) {
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
        } else {
            for (T existingValue : existingValues) {
                if (Objects.equals(existingValue.getId(), value.getId())) {
                    int index = existingValues.indexOf(existingValue);
                    existingValues.set(index, value);
                }
            }
        }

        return this.writeToData(existingValues);
    }

    private boolean writeToData(List<T> values) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File newFile = new File("src/main/resources/" + this.fileName);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(values);
            System.out.println(jsonString);
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            writer.write(jsonString);
            writer.close();

            return true;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected abstract List<T> readFromData();

}
