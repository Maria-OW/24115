package edu.ar.data;

import static edu.ar.data.Conexion.close;
import static edu.ar.data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ar.model.Pelicula;

public class PeliculaDAO {

    private static final String SQL_SELECT = "SELECT * FROM pelicula";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM pelicula WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO pelicula (titulo, anio, genero, descripcion, calificacion, estrellas, director) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE pelicula SET titulo =?, anio =?, genero =?, descripcion =?, calificacion =?, estrellas =?, director =? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM pelicula WHERE id = ?";

    public static List<Pelicula> obtener(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pelicula pelicula = null;
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            //Itero resultados devueltos por la BD en el ResulSet rs
            //Obtengo los atributos de cada pelicula y los seteo a los objetos Peliculas
            //finalmente guardo cada pelicula en el listado de peliculas(ArrayList)
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                int anio = rs.getInt("anio");
                String genero = rs.getString("genero");
                String descripcion = rs.getString("descripcion");
                int calificacion = rs.getInt("calificacion");
                byte estrellas = rs.getByte("estrellas");
                String director = rs.getString("director");

                pelicula = new Pelicula(id, titulo, anio, genero, descripcion, calificacion, estrellas, director);

                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(ps);
                close(conn);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return peliculas;
    }

    public static int insertar(Pelicula peli){
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;//ver ABAJO
        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, peli.getTitulo());
            ps.setInt(2, peli.getAnio());
            ps.setString(3, peli.getGenero());
            ps.setString(4, peli.getDescripcion());
            ps.setInt(5, peli.getCalificacion());
            ps.setByte(6, peli.getEstrellas());
            ps.setString(7, peli.getDirector());

            registros = ps.executeUpdate();//ver ARRIBA


        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally{
            try {
                close(ps);
                close(conn);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
