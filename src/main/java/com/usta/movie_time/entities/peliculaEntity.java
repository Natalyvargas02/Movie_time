package com.usta.movie_time.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "peliculas")
public class peliculaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //lave primaria se genera sola
    @Column(name = "idpelicula")
    private Long idpelicula;

    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "titulo", unique = true)
    private String titulo;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sinopsis")
    private String sinopsis;

    @NotNull
    @Column(name = "fecha_estreno")
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_estreno;



    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "youtube_trailer_id")
    private String youtube_trailer_id;

    @NotNull
    @Column(name = "imagen")
    private String imagen;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Long getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Long idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getYoutube_trailer_id() {
        return youtube_trailer_id;
    }

    public void setYoutube_trailer_id(String youtube_trailer_id) {
        this.youtube_trailer_id = youtube_trailer_id;
    }


}

