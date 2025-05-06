package solid;// 3. Liskov Substitution Principle -
// If class B is a subtype of class A, then we should be
// able to replace object of A with B
// without breaking behaviour of the program

interface Bike {
    void turnOnEngine();
    void accelerate();
}

class MotorCycle implements Bike {
    boolean isEngineOn;
    int speed;

    public void turnOnEngine(){
        this.isEngineOn = true;
    }

    public void accelerate(){
        this.speed += 10;
    }
}

class Bicycle implements Bike {
    // **** Below method is wrong as it violates Liskov Substitution Principle
//    @Override
//    public void turnOnEngine() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    @Override
    public void turnOnEngine() {
        System.out.println("Turning on engine");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating");
    }
}