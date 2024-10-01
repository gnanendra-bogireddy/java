package enums;

public enum EnumValuesExample {

    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);

    final int index;

    EnumValuesExample(int indexValue) {
        this.index = indexValue;
    }

}

class MainClass {
    public static void main(String[] args) {
        for (EnumValuesExample value : EnumValuesExample.values()) {
            System.out.println("Printing index values for Enum : " + value.index);
        }
    }
}
