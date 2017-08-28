
package UI;

public class UI {
    
    public static void bienvenida() {
        System.out.println("=============================");
        System.out.println("|==========BIENVENIDO=======|");
        System.out.println("=============================");
        command();
    }
    
    
    public static void command(){
        System.out.println("INGRESE EL NUMERO : ");
        System.out.println("(1) PARA INGRESAR LOS DATOS DE UN PRODUCTO");
        System.out.println("(2) PARA REGISTRAR UNA VENTA");
        System.out.println("(3) MIRAR CUAL FUE EL VENDEDOR QUE REALIZO LA MAYOR CANTIDAD DE VENTAS");
        System.out.println("(4) MIRAR QUE VENDEDOR REALIZO LA VENTA DE UN PRODUCTO");
        System.out.println("(5) MONTO TOTAL DE VENTAS REALIZADAS");
        System.out.println("(6) PARA SALIR");
    }
    
    
    public static void ingresarAlaCanasta(){
        System.out.println("Ingrese un numero : ");
        System.out.println("(1) si desea agregar un producto a la canasta");
        System.out.println("(2) si desea salir");
    }
    
    public static void elegirTipoDePago(){
        System.out.println("Ingrese un numero : ");
        System.out.println("(0) Efectivo");
        System.out.println("(1) Debito");
        System.out.println("(2) Tarjeta : ");
    }
    
}
