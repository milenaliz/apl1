package apl1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
1. Stwórz nowy projekt.
2. Stwórz klasę Student z polami imię, nazwisko, rok (+ settery, getery, toString)
3. Napisz metodę, która metodą refleksji będzie wyświetlała w "przyjazny" sposób zawartość tej klasy.
4. Utwórz anotację @Label, w której pola klasy będą miały "przyjazną" nazwę.
5. Utwórz anotację @Writable
6. Oznacz anotacją @Writable settery klasy Student.
7. Program na podstawie anotacji ma umożliwiać użytkownikowi ustawienie pól tej klasy.
 */
public class App {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Student student = new Student();

        setupFields(student);

        System.out.println(student);

        displayFields(student);
    }

    private static void setupFields(Object o) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Scanner scanner = new Scanner(System.in);

        for (Method setter : o.getClass().getMethods()) {
            if (setter.isAnnotationPresent(Writable.class)) {
                Writable writable = setter.getAnnotation(Writable.class);

                System.out.println(writable.value());
                System.out.println(writable.order());
                Class<?> type = setter.getParameterTypes()[0];

                if (type == String.class) {
                    String value = scanner.nextLine();
                    setter.invoke(o, value);
                } else if (type == double.class) {
                    double value = scanner.nextDouble();
                    scanner.nextLine();
                    setter.invoke(o, value);
                } else if (type == int.class) {
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    setter.invoke(o, value);
                } else {
                    Object o1 = type.newInstance();
                    setupFields(o1);
                    setter.invoke(o, o1);
                }
            }
        }
    }

    private static void displayFields(Object o) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = o.getClass().getMethods();
      List<Method> methodList = Arrays.stream(methods).filter(method ->isAnnotationPresent(Label.class)).collect(Collectors)
        methodList.sort(Comparator.comparingInt(method -> method)
        for (Method getter : Student.class.getDeclaredMethods()) {
            if (getter.isAnnotationPresent(Label.class)) {
                Label label = getter.getAnnotation(Label.class);

                Class<?> type = getter.getReturnType();

                if (type == int.class || type == double.class || type == String.class) {
                    String value = getter.invoke(o).toString();
                    System.out.println(label.value() + " - " + value);
                } else {
                    System.out.println(" === " + label.value() + " === ");
                    displayFields(o);
                    System.out.println(" === ===");
                }
            }
        }
    }
}
