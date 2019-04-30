package p05_CarSalesman;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedList<Engine> engines = new LinkedList<>();
        LinkedList<Car>cars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[]engine = reader.readLine().split(" ");
            String model = engine[0];
            int power = Integer.parseInt(engine[1]);
            Engine engine1 =null;

            if (engine.length==4){
                String displacement = engine[2];
                String efficiency = engine[3];
                engine1=new Engine(model,power,displacement,efficiency);
            }else if(engine.length==3){
                if (isNum(engine[2])){
                    engine1 = new Engine(model,power,engine[2],"n/a");
                }else{
                    engine1 = new Engine(model,power,"n/a",engine[2]);
                }
            }else{
                engine1 = new Engine(model,power);
            }
            engines.add(engine1);
        }
        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            Car car = null;
            String[]carsInput = reader.readLine().split(" ");
            String model = carsInput[0];
            String engineName = carsInput[1];
            Engine engine = null;
            for (Engine engine1 : engines) {
                if (engine1.getModel().equals(engineName)){
                    engine=engine1;
                    break;
                }
            }
            if (carsInput.length==4){
                String weight = carsInput[2];
                String color = carsInput[3];
                car = new Car(model,engine,weight,color);
            }else if(carsInput.length==3){
                if (isNum(carsInput[2])){
                    String weight = carsInput[2];
                    car=new Car(model,engine,weight,"n/a");
                }else{
                    String color = carsInput[2];
                    car=new Car(model,engine,"n/a",color);
                }
            }else{
                car=new Car(model,engine);
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    private static boolean isNum(String s) {
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
