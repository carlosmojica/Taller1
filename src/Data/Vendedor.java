
package Data;

import java.util.ArrayList;

public class Vendedor {
    
    private int iD;
    private String nombre;
    private String apellido;
    private int numeroDeVentas;
    public ArrayList<Producto> productosVendidos;

    public Vendedor(int iD, String nombre, String apellido) {
        this.iD = iD;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeVentas = 0;
        this.productosVendidos = new ArrayList<>();
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroDeVentas() {
        return numeroDeVentas;
    }

    public void setNumeroDeVentas(int numeroDeVentas) {
        this.numeroDeVentas = numeroDeVentas;
    }

    
    @Override
    public String toString() {
        return "Vendedor : " +"Nombre : "+nombre+" | Apellido : "+apellido+" | Codigo : "+ iD+ "\n";
    }
    
    
}
