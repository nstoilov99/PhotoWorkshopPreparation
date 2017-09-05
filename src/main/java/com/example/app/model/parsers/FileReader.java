package com.example.app.model.parsers;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileReader  {
    public String readFile(String path){
        StringBuilder stringBuilder = new StringBuilder();
        try (
                InputStream is = this.getClass().getResourceAsStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))
        ) {
            String line = reader.readLine();
            while (line != null){
                stringBuilder.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void writeFile(String fileName, String content) throws IOException {
        String path = System.getProperty("user.dir") + File.separator + fileName;
        File f = new File(path);
        if(!f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
        try (OutputStream os = new FileOutputStream(fileName);
             BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os))
        ) {
            bfw.write(String.valueOf(content));
        }
    }
}
