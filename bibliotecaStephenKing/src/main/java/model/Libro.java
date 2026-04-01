package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar los campos que no existen en la clase

public class Libro implements Serializable{

    @JsonIgnore
    private List<Object> villains; // Ignorar atributo

    @JsonIgnore
    private List<String> notes;


    private int id;

    @JsonProperty("Year") // conversion datos de API a proyecto. Year (asi aparece en la API) a title
    private int year;

    @JsonProperty("Title")
    private String title;

    private String handle;

    @JsonProperty("Publisher")
    private String publisher;

    @JsonProperty("ISBN")
    private String ISBN;

    @JsonProperty("Pages")
    private int pages;


    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Título: " + title + "\n" +
                "Año: " + year + "\n" +
                "Editorial: " + publisher + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Páginas: " + pages + "\n" +
                "------------------------";
    }
}