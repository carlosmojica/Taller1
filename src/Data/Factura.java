
package Data;
import java.util.ArrayList;

public class Factura {

    private Vendedor vendedor;
    public ArrayList<Producto> productos;
    private Fecha fecha;
    private int tipoDePago;
    private String pago;
    private double precioTotal;

    public Factura(Vendedor vendedor, Fecha fecha, int tipoDePago) {
        this.vendedor = vendedor;
        this.productos = new ArrayList<>();
        this.fecha = fecha;
        this.tipoDePago = tipoDePago;
        this.precioTotal = 0.0;
        
        if (tipoDePago == 0) {
            pago = "Efectivo";
        }else if (tipoDePago == 1){
            pago = "Debito";
        }else if(tipoDePago == 2){
            pago = "Tarjeta";
        }else{
           pago = "No se eligio un tipo de pago"; 
        }
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public int getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(int tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    

    @Override
    public String toString() {
        String factura = "\n=============================================\n";
        factura += vendedor.toString();
        factura += fecha.toString();
        
        for (int i = 0; i < productos.size(); i++) {
            factura += productos.get(i).toString();
            precioTotal += productos.get(i).getPrecio() * productos.get(i).getCantidad();
        }
        
        factura +="Precio sin descuento : "+ precioTotal +"\n";
        
        int numero = (int) (Math.random() * 100);
        
        if(numero % 3 == 0){
            factura +="Descuento : " + (precioTotal * 0.1) + "\n";
            precioTotal = precioTotal - (precioTotal * 0.1);
            factura +="Precio Total : "+ (precioTotal) +"\n";
            factura +="Tipo de pago : "+ pago;
        }else{
            factura +="Descuento : " + (0.0) + "\n";
            precioTotal = precioTotal - (0.0);
            factura +="Precio Total : "+ (precioTotal) +"\n";
            factura +="Tipo de pago : "+ pago;
        }
        factura += "\n=============================================\n";
        return factura;
    }
    
    
}
