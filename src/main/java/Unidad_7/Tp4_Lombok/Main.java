package Unidad_7.Tp4_Lombok;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ProductoRecord> lista = new ArrayList<>();

        Producto producto = new Producto("123asd", "Atun", "Atuncito", 100.0);
        Producto producto1 = new Producto("123ZXC","frijol","atuncito",120.5);
        Producto producto2 = new Producto("123QWE","Pescado","Atuncito",150.5);

        ProductoRecord productoDTO = new ProductoRecord(producto.getCodigo(),producto.getNombre(),producto.getPrecio());
        ProductoRecord productoDTO1 = new ProductoRecord(producto1.getCodigo(),producto1.getNombre(),producto1.getPrecio());
        ProductoRecord productoDTO2 = new ProductoRecord(producto2.getCodigo(),producto2.getNombre(),producto2.getPrecio());


        lista.add(productoDTO);
        lista.add(productoDTO2);
        lista.add(productoDTO1);

        for(ProductoRecord pDTO : lista){
            System.out.println("DETALLES PRODUCTO");
            System.out.println("Codigo: " + pDTO.codigo()+ "\nNombre: " + pDTO.nombre() + "\nPrecio: "+ pDTO.precio());
            System.out.println();
        }
    }
}
