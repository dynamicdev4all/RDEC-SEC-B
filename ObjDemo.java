public class ObjDemo {
    public static void main(String[] args) {
        Car car1 = new Car("Tata", 4, 4, 5);
        System.out.println(car1.name);
        System.out.println(car1.doorCount);
        System.out.println(car1.wheelCount);
        System.out.println(car1.seatCount);
        System.out.println("***************************");
        Car car2 = new Car("Mahindra", 4, 4, 7);
        System.out.println(car2.name);
        System.out.println(car2.doorCount);
        System.out.println(car2.wheelCount);
        System.out.println(car2.seatCount);
    }
}

class Car {
    String name;
    int wheelCount;
    int doorCount;
    int seatCount;

    Car(String nam, int wheelCount, int doorCount, int seatCount) {
        name = nam;
        this.wheelCount = wheelCount;
        this.doorCount = doorCount;
        this.seatCount = seatCount;
    }
}
