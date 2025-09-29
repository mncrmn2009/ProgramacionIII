package Unidad_7.Tp3_Lombok;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("123-ASD","Libro",150.9,"Nico");
        Producto p2 = new Producto("456-ZXC","Libro2",120.4,"Marcos");
        Producto p3 = new Producto("789-QWE","Libro3",130.4,"Angeles");

        ProductoDTO pdto = new ProductoDTO();
        ProductoDTO pdto2 = new ProductoDTO();
        ProductoDTO pdto3 = new ProductoDTO();

        pdto.setCodigo(p1.getCodigo());
        pdto.setNombre(p1.getNombre());
        pdto.setPrecio(p1.getPrecio());

        pdto2.setCodigo(p2.getCodigo());
        pdto2.setNombre(p2.getNombre());
        pdto2.setPrecio(p2.getPrecio());

        pdto3.setCodigo(p3.getCodigo());
        pdto3.setNombre(p3.getNombre());
        pdto3.setPrecio(p3.getPrecio());

        ArrayList<ProductoDTO> productos = new ArrayList<>();

        productos.add(pdto);
        productos.add(pdto2);
        productos.add(pdto3);

        for(ProductoDTO producto : productos){
            System.out.println(producto);
        }

    }
}
