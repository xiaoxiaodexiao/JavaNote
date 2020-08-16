public enum LeaveType {
    病假,年假 , 婚假, 产假, 丧假, 调休;

    public static LeaveType getEnumOrder(int type) {
        switch (type) {
            case 1:
                return 病假;
            case 2:
                return 年假;
            case 3:
                return 婚假;
            case 4:
                return 产假;
            case 5:
                return 丧假;
            case 6:
                return 调休;
            default:
                return null;
        }
    }
}
