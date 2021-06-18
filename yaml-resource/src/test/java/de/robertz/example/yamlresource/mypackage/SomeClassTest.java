package de.robertz.example.yamlresource.mypackage;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class SomeClassTest {
    @Test
    public void testLoadResource() throws URISyntaxException, IOException {
        URL url = this.getClass().getResource("myFile.yml");
        File f = new File(url.toURI());
        Yaml yaml = new Yaml();
        String contents =  Files.readAllLines(f.toPath(), StandardCharsets.UTF_8).stream().reduce((r, p) -> { return r + p + System.lineSeparator(); }).get();
        var obj = yaml.load(contents);
        System.out.println(obj);
    }
}
