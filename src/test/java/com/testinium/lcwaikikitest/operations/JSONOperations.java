package com.testinium.lcwaikikitest.operations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class JSONOperations {
    private final List<String> jsonDB;

    public JSONOperations(List<String> jsonDB){
        this.jsonDB = jsonDB;
    }


    private String readJSONFromResourcesFolder(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("key_database/"+fileName)).getFile());
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private List<LocatorElement> convertJSON2ElementList(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, new TypeReference<List<LocatorElement>>(){});
    }


    public LocatorElement findElementByKey(String key){
        for (String s : jsonDB) {
            String jsonString = readJSONFromResourcesFolder(s);
            List<LocatorElement> listElems = null;
            try {
                listElems = convertJSON2ElementList(jsonString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            for (LocatorElement listElem : Objects.requireNonNull(listElems)) {
                if (listElem.getKey().equals(key))
                    return listElem;
            }
        }
        return null;
    }
}
