package controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import model.Libro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class BibliotecaController {

    private List<Libro> todosLibros;
    private List<Libro> librosFavoritos;
    private ApiController apiController;

    public BibliotecaController() {
        todosLibros = new ArrayList<>();
        librosFavoritos = new ArrayList<>();
        apiController = new ApiController();
    }

    public void importarLibros() throws IOException {
        String json = apiController.obtenerLibros(); // Conversion del texto de la API a un JSON (texto plano)
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json); // Lectura de json en estructura de arbol ("carpetas")
        JsonNode dataNode = rootNode.get("data"); // Obtencion datos

        todosLibros = mapper.readValue(dataNode.toString(),
                mapper.getTypeFactory().constructCollectionType(List.class, Libro.class)); //conversion a lista libros

    }

    public Libro buscarLibroID(int id) throws IOException {

        String json = apiController.obtenerLibroPorId(id);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);
        JsonNode dataNode = rootNode.get("data");

        Libro libro = mapper.treeToValue(dataNode, Libro.class); // Conversion  a un onjeto

        return libro;

    }


    public void agregarFavorito(int id) throws IOException {

        librosFavoritos.add(buscarLibroID(id));
        System.out.println("Libro añadido a favoritos!");

    }

    public void mostrarFavoritos() {
        librosFavoritos.forEach(libro -> System.out.println(libro));
    }
}
