package edu.ar.model;

public class Pelicula {
    //atributos
    private int id;
    private String titulo;
    private int anio;
    private String genero;
    private String descripcion;
    private int calificacion;
    private byte estrellas;
    private String director;

    //constructores
    public Pelicula(){}

    public Pelicula(int id, String titulo, int anio, String genero, String descripcion, int calificacion, byte estrellas, String director){
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.estrellas = estrellas; 
        this.director = director;   
    }
    
    public Pelicula(String titulo, int anio, String genero, String descripcion, int calificacion, byte estrellas, String director){
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.estrellas = estrellas; 
        this.director = director;   
    }


    public Pelicula(int id, String titulo, int anio){
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
    }


    //métodos getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public byte getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(byte estrellas) {
        this.estrellas = estrellas;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

//métodos personalizados
    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", titulo=" + titulo + ", anio=" + anio + ", genero=" + genero + ", descripcion="
                + descripcion + ", calificacion=" + calificacion + ", estrellas=" + estrellas + ", director=" + director + "]";
    }



    }
    



