package factory;

/**
 * Created by npor1112 on 30.01.2018.
 */
public class SeatManagementFactory {
    public static Object build() {
        return DefaultFactory.build("seatmanagement.jar", "SeatManagement");
    }
}
