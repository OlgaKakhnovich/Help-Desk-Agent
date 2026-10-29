package com.citywheels.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PolicyRepository {

    private final Path policiciesDerictory;

    public PolicyRepository(Path policiciesDerictory){
        this.policiciesDerictory = policiciesDerictory;
    }

    public String readPolicy(String fileName) throws IOException{
        Path file = policiciesDerictory.resolve(fileName);

        return Files.readString(file, StandardCharsets.UTF_8);
    }




}
