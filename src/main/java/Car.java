

public class Car {

    private int wheels;
    private String engine;
    private int fuel;
    // We added volatile to avoid this variable to became partially initialized
    private static volatile Car instance;

    private Car(int wheels, String engine, int fuel){
        this.wheels = wheels;
        this.engine = engine;
        this.fuel = fuel;
    }

    public static Car getInstance(int wheels, String engine, int fuel){
        //Synchronized is used to turn this singleton thread-safe
        synchronized (Car.class){
            if(instance == null){
                instance = new Car(wheels, engine, fuel);
            }
        }
        return instance;
    }
}
