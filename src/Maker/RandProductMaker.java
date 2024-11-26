package Maker;

public class RandProductMaker {

    public static void main(String[] args) {
        RandProductMakerGUI gui = new RandProductMakerGUI();
        RandProductMakerController controller = new RandProductMakerController(gui);
        gui.setVisible(true);
    }
}
