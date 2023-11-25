package Model;

public class Comida {

    private int idComida;
    private String codigoBarra;
    private String descripcion;

    private int idCategoria;
    private String urlFoto;
    private double precio;
    private String oCategoria;
    private String nombre;





    public Comida(int idComida, String codigoBarra, String descripcion, int idCategoria, String urlFoto, double precio, String oCategoria) {
        this.idComida = idComida;
        this.codigoBarra = codigoBarra;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.urlFoto = urlFoto;
        this.precio = precio;
        this.oCategoria = oCategoria;
    }

    public Comida(int idComida, String codigoBarra, String descripcion, int idCategoria, String urlFoto, double precio) {
        this.idComida = idComida;
        this.codigoBarra = codigoBarra;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.urlFoto = urlFoto;
        this.precio = precio;
    }

    public String getoCategoria() {
        return oCategoria;
    }

    public void setoCategoria(String oCategoria) {
        this.oCategoria = oCategoria;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
