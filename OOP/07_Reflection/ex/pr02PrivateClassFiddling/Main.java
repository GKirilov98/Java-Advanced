package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt boxInt = constructor.newInstance();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("_");
            int number = Integer.parseInt(tokens[1]);

            Method method = BlackBoxInt.class.getDeclaredMethod(tokens[0], int.class);
            method.setAccessible(true);
            method.invoke(boxInt, number);

            Field innerValue = boxInt.getClass().getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(boxInt));

            command = scanner.nextLine();
        }
        //Arrays.stream(BlackBoxInt.class.getDeclaredMethods()).forEach(e -> System.out.println(e.getName()));
    }
}
