package Search;

import ProductList.List;

public class RandProductSearchController {

        private RandProductSearchGUI gui;

        public RandProductSearchController(RandProductSearchGUI gui) {
            this.gui = gui;
            this.gui.setSearchButtonListener(e -> Search());
            List.updateProductCount();
        }

        private void Search() {
            String partialName = gui.getSearch();
            String result = List.searchProduct(partialName);
            gui.setSearchResults(result);
            if (result.isEmpty()) {
                gui.setSearchResults("No products found");
            }
        }
}
