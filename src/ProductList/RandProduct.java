package ProductList;

public class RandProduct extends Product{

    private static final int ID_LEN = 6;
    private static final int NAME_LEN = 35;
    private static final int DESCRIPTION_LEN = 75;

    public RandProduct(String id, String name, String description, double cost) {
        super(RightPad(id, ID_LEN), RightPad(name, NAME_LEN), RightPad(description, DESCRIPTION_LEN), cost);
    }

    public String getFormattedID() {
        return super.getId().trim();
    }

    public String getFormattedName() {
        return super.getName().trim();
    }

    public String getFormattedDescription() {
        return super.getDescription().trim();
    }

    static private String RightPad(String string, int length) {
        if (string.length() >= length) {
            return string.substring(0, length);
        }
        return String.format("%-" + length + "s", string);
    }
}
