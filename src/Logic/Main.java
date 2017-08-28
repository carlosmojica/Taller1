
package Logic;

import Data.*;
import UI.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) {
        ArrayList<Producto> arrProductos = new ArrayList<>();
        ArrayList<Factura> arrFacturas = new ArrayList<>();
        
        Vendedor vendedor1 = new Vendedor(2563, "JUAN", "SUAREZ");
        Vendedor vendedor2 = new Vendedor(2564, "JOSE", "VILLALOBOS");
        Vendedor vendedor3 = new Vendedor(2565, "LUIS", "BAEZ");
        
        Vendedor[] vendedores = new Vendedor[3];
        vendedores[0] = vendedor1;
        vendedores[1] = vendedor2;
        vendedores[2] = vendedor3;
        
        
        Scanner sc = new Scanner(System.in);
        UI.bienvenida();
        int command = sc.nextInt();
        
        while (command != 6){
            if (command == 1) {
                System.out.println("Ingrese el codigo del producto : ");
                int codigo = sc.nextInt();
                System.out.println("Ingrese la descripcion del producto : ");
                String descripcion = sc.next();
                System.out.println("Ingrese el precio del producto : ");
                double precio = sc.nextDouble();
                arrProductos.add(crearProducto(codigo, descripcion, precio));
            }else if(command == 2) {
                System.out.println("\n=============================================\n");
                int aleatorio = (int) (Math.random() * 3);
                vendedores[aleatorio].setNumeroDeVentas(vendedores[aleatorio].getNumeroDeVentas()+1); 
                System.out.println("El vendedor : " + vendedores[aleatorio].getNombre() 
                        + " " + vendedores[aleatorio].getApellido() + " Te va atender");
                
                UI.ingresarAlaCanasta();
                int numeroCommand = sc.nextInt();
                ArrayList<Producto> listaDeProductosCliente = new  ArrayList<>();
                while (numeroCommand != 2) {
                    if (numeroCommand == 1){
                        System.out.println("Que producto desea comprar : ");
                        String producto = sc.next();
                        System.out.println("Ingrese la cantidad : ");
                        int cantidad = sc.nextInt();
                        Producto productoNuevo = null;
                        for (int i = 0; i < arrProductos.size(); i++) {
                            if(arrProductos.get(i).getDescripcion().equals(producto)){
                                productoNuevo = arrProductos.get(i);
                                break;
                            }
                        }
                        if(productoNuevo == null){
                            System.out.println("No se encontro el producto");
                        }else{
                            productoNuevo.setCantidad(cantidad); 
                            listaDeProductosCliente.add(productoNuevo);
                            vendedores[aleatorio].productosVendidos.add(productoNuevo);
                        }
                    }else{
                        break;
                    }
                    UI.ingresarAlaCanasta();
                    numeroCommand = sc.nextInt();
                }
                UI.elegirTipoDePago();
                int tipoDePago = sc.nextInt();
                
                Factura f = new Factura(vendedores[aleatorio], new Fecha(26, 8, 2017), tipoDePago);
                f.productos = listaDeProductosCliente;
                System.out.println(f.toString());
                arrFacturas.add(f);
                System.out.println("\n=============================================\n");
            }else if(command == 3){
                System.out.println("\n=============================================\n");
                int indexVendedor = 0;
                for (int i = 0; i < vendedores.length - 1; i++) {
                    if(vendedores[i].getNumeroDeVentas()>= vendedores[i+1].getNumeroDeVentas()) {
                        indexVendedor = i;
                    }else{
                        indexVendedor = i + 1;
                    }
                }
                System.out.println("El vendedor que mas ventas realizo fue ["
                            + vendedores[indexVendedor].getNombre() + " " 
                            +vendedores[indexVendedor].getApellido()+"]");
                System.out.println("\n=============================================\n");
            }else if(command == 4){
                System.out.println("Ingrese el nombre del vendedor");
                String nombreVendedor = sc.next();
                System.out.println("Ingrese el nombre del producto");
                String nombreProducto = sc.next();
                System.out.println("\n=============================================\n");
                for (int i = 0; i < vendedores.length; i++) {
                    if(vendedores[i].getNombre().equals(nombreVendedor)){
                        for (int j = 0; j < vendedores[i].productosVendidos.size(); j++) {
                            if(vendedores[i].productosVendidos.get(j).getDescripcion().equalsIgnoreCase(nombreProducto)){
                                System.out.println(vendedores[i].productosVendidos.get(j).toString());
                            }
                        }
                        break;
                    }
                }
                System.out.println("\n=============================================\n");
            }else if(command == 5){
                double acumuladorTotal = 0;
                System.out.println("\n=============================================\n");
                for (int i = 0; i < arrFacturas.size(); i++) {
                    acumuladorTotal += arrFacturas.get(i).getPrecioTotal();
                }
                System.out.println("El monto total de la ventas realizadas fue : " + acumuladorTotal);
                System.out.println("\n=============================================\n");
            }
            
            UI.command();
            command = sc.nextInt();
        }
      
        
    }
    
    public static Producto crearProducto(int codigo, String descripcion, double precio){
        return new Producto(codigo, descripcion, precio);
    }
    
}

/*
Producto crema = new Producto(842223, "Crema Dental", 2340);
Producto papel = new Producto(842224, "papel", 1345);
Producto carne = new Producto(842225, "carne", 135667);
Producto arroz = new Producto(842226, "arroz", 3563);

Vendedor v = new Vendedor(1345, "Carlos", "Mojica");

Factura f = new Factura(v, new Fecha(26, 8, 2017), 1);
f.productos.add(crema);
f.productos.add(papel);
f.productos.add(carne);
f.productos.add(arroz);
System.out.println(f.toString());
*/