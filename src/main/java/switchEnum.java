import java.util.TreeMap;

public enum switchEnum {
    LEAVE,OVERTIME ,TRAVEL,MAKEUPCARD,EMPLOYEE,QUIT;

    public static switchEnum getEnumOrder(int order) {
        switch (order) {
            case 1:
                return LEAVE;
            case 2:
                return OVERTIME;
            case 3:
                return TRAVEL;
            case 4:
                return MAKEUPCARD;
            case 5:
                return EMPLOYEE;
            case 6:
                return QUIT;
            default:
                return null;
        }
    }
}
