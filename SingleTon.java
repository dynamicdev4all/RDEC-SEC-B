public class SingleTon {
    public static void main(String[] args) {
        Car car1 = Car.createObj("Tata", 4, 4, 5);
        System.out.println(car1.name);
        System.out.println(car1.doorCount);
        System.out.println(car1.wheelCount);
        System.out.println(car1.seatCount);
        System.out.println("***************************");
        Car car2 = Car.createObj("Mahindra", 4, 4, 7);
        System.out.println(car2.name);
        System.out.println(car2.doorCount);
        System.out.println(car2.wheelCount);
        System.out.println(car2.seatCount);
    }
}

class Car {
    static Car obj;
    String name;
    int wheelCount;
    int doorCount;
    int seatCount;

    private Car(String nam, int wheelCount, int doorCount, int seatCount) {
        name = nam;
        this.wheelCount = wheelCount;
        this.doorCount = doorCount;
        this.seatCount = seatCount;
    }

    static Car createObj(String name, int wheelCount, int doorCount, int seatCount) {
        if (obj == null) {
            obj = new Car(name, wheelCount, doorCount, seatCount);
        }
        return obj;
    }
}
