package marioargandona.com.petagram4;

/**
 * Created by Robert on 7/23/2016.
 */
public class Mascota {

    private String nombreMascota;
    private Integer likes;
    private Integer foto;

    public Mascota(String nombreMascota , Integer likes , Integer foto)
    {
        this.nombreMascota = nombreMascota;
        this.likes = likes;
        this.foto = foto;
    }


    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
