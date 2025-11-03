package Unidad_8.Actividad_2;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            //Obtener la clase
            Class<?> clazz = Class.forName("Unidad_8.Actividad_2.Persona");
            // Obtener los constructores
            Constructor<?>[] constructors = clazz.getConstructors();
            System.out.println("\nConstructores: ");
            for (Constructor<?> constructor : constructors) {
                System.out.print(" " + constructor.getName() + "(");
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getSimpleName());
                    if (i < parameterTypes.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }
            // Instancia un objeto
            Constructor<?> constructor = clazz.getConstructor();
            Object persona = constructor.newInstance();
            System.out.println(persona);

            Field nameField = clazz.getDeclaredField("nombre");
            nameField.setAccessible(true);
            nameField.set(persona, "Nico");
            System.out.println(persona);

            //Invoca un metodo
            Method saludoMetodo = clazz.getDeclaredMethod("saludar");
            saludoMetodo.setAccessible(true);
            saludoMetodo.invoke(persona);


        } catch (ClassNotFoundException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException |
                 NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
