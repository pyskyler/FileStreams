package Maker;

import ProductList.List;
import ProductList.RandProduct;

public class RandProductMakerController {

    private RandProductMakerGUI gui;

    public RandProductMakerController(RandProductMakerGUI gui) {
        this.gui = gui;
        List.updateProductCount();
        gui.setProductCount(List.getProductCount());

        gui.setSubmitButtonListener(e -> {
            String name = gui.getName();
            String description = gui.getDescription();
            String price = gui.getPrice();
            String id = gui.getId();
            if (validateInput(name, description, price, id)) {
                RandProduct product = new RandProduct(id, name, description, Double.parseDouble(price));
                List.addProduct(product);
                gui.clearFields();
            }
            gui.setProductCount(List.getProductCount());

        });

    }

    private boolean validateInput(String name, String description, String price, String id) {
        if (name.length() > RandProduct.NAME_LEN) {
            gui.displayErrorMessage("Name must be less than " + RandProduct.NAME_LEN + " characters");
            return false;
        } else if (description.length() > RandProduct.DESCRIPTION_LEN) {
            gui.displayErrorMessage("Description must be less than " + RandProduct.DESCRIPTION_LEN + " characters");
            return false;
        } else if (id.length() > RandProduct.ID_LEN) {
            gui.displayErrorMessage("ID must be less than" + RandProduct.ID_LEN + " characters");
            return false;
        } else {
            try {
                Double.parseDouble(price);
            } catch (Exception e) {
                gui.displayErrorMessage("Price must be a number");
                return false;
            }
            return true;
        }

    }

}
