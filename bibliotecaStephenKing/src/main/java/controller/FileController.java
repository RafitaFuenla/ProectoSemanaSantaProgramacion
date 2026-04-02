package controller;

import model.Libro;

import java.io.*;
import java.util.List;

public class FileController {

    public void exportarFavoritos(List<Libro> favoritos) throws IOException {
        FileOutputStream fos = new FileOutputStream("favoritos.obj"); // Escribir en el fichero fav...obj, si no existe, crealo
        ObjectOutputStream oos = new ObjectOutputStream(fos); // Convertir objeto a bytes
        oos.writeObject(favoritos); // Escribe la lista en el fichero
        oos.close(); //Cierre fichero, para que no haya errores
    }

    public List<Libro> importarFavoritos() throws IOException, ClassNotFoundException {

        FileInputStream fos = new FileInputStream("favoritos.obj");
        ObjectInputStream ois = new ObjectInputStream(fos);
        List<Libro> favoritos = (List<Libro>) ois.readObject();
        ois.close();
        return favoritos;
    }
}
