package Unidad_7.Tp2_Lombok;

public class Main {
    public static void main(String[] args) {
        Usuario usuario= Usuario.builder()
                .id(1234)
                .nombre("Nicolas")
                .email("nico@email.com")
                .build();

        System.out.println(usuario);

    }
}
