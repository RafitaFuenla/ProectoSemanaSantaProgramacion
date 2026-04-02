package controller;

import model.Libro;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiController {

    // Hacemos el metodo para la petición GENERAL a la API
    private String hacerPeticion(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        return response.toString();
    }

    // creamos un metodo para obtener los libros de la API, modificando la URL de esta misma
    public String obtenerLibros() throws IOException {
        return hacerPeticion("https://stephen-king-api.onrender.com/api/books");
    }

    // creamos un metodo para obtener los libros de la API por ID, modificando la URL de esta misma
    public String obtenerLibroPorId(int id) throws IOException {
        return hacerPeticion("https://stephen-king-api.onrender.com/api/book/" + id);
    }
}
