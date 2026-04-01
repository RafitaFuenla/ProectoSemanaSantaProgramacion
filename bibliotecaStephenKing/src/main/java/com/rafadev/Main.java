package com.rafadev;

import controller.BibliotecaController;
import controller.FileController;
import model.Libro;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

    BibliotecaController biblioteca = new BibliotecaController();
    FileController fileController = new FileController();

    Scanner sc = new Scanner(System.in);
    int opcion;
        do {
            System.out.println("1. Importar libros");
            System.out.println("2. Buscar libro por ID");
            System.out.println("3. Agregar favorito");
            System.out.println("4. Exportar favoritos");
            System.out.println("5. Importar favoritos");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    biblioteca.importarLibros();
                    for (Libro libro : biblioteca.getTodosLibros()) {
                        System.out.println(libro);
                    }
                    break;
                case 2:
                    System.out.println("Introduce el ID:");
                    int id = sc.nextInt();
                    Libro libro = biblioteca.buscarLibroID(id);
                    System.out.println(libro);
                    break;
                case 3:
                    System.out.println("Introduce el ID:");
                    int id2 = sc.nextInt();
                    biblioteca.agregarFavorito(id2);
                    break;
                case 4:
                    fileController.exportarFavoritos(biblioteca.getLibrosFavoritos());
                    break;
                case 5:
                    List<Libro> favoritos = fileController.importarFavoritos();
                    System.out.println("Libros agregados anteriormente a favoritos:");
                    for (Libro libroFav : favoritos) {
                        System.out.println(libroFav);
                    }
                    break;
            }
        } while (opcion != 0);

}
}