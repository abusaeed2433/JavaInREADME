package r_Enum;

public enum MyWeekDay {
    SATURDAY(true),SUNDAY(false),MONDAY(false),
    TUESDAY(false), WEDNESDAY(false),THURSDAY(false), FRIDAY(false);

    // see above constant carefully. They all are objects. We are actually using the constructor of this class to create constant.

    private final boolean isHoliday;
    private MyWeekDay(boolean isHoliday){
        this.isHoliday = isHoliday;
    }


    public boolean isHoliday() {
        return isHoliday;
    }

}
