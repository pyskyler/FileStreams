package Search;

public class RandProductSearch {
    public static void main(String[] args) {
        RandProductSearchGUI gui = new RandProductSearchGUI();
        RandProductSearchController controller = new RandProductSearchController(gui);
        gui.setVisible(true);
    }
}
