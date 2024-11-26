package ProductList;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class List {

    private static final String listFileName = "productList";
    private static int productCount;

    public static int getProductCount() {
        return productCount;
    }

    public static void addProduct(RandProduct product) {
        try (RandomAccessFile file = new RandomAccessFile(listFileName, "rw")) {
            file.seek((long) getProductCount() * RandProduct.getRecordSize());
            file.write(product.getName().getBytes(StandardCharsets.UTF_8));
            file.write(product.getDescription().getBytes(StandardCharsets.UTF_8));
            file.write(product.getId().getBytes(StandardCharsets.UTF_8));
            file.writeDouble(product.getCost());
        } catch (IOException e) {
            e.printStackTrace();
        }
        productCount++;
    }

    public static String searchProduct(String partialName) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < getProductCount(); i++) {
            RandProduct product = readProduct(i);
            if (product.getName().toLowerCase().contains(partialName.toLowerCase())) {
                result.append(product.getFormattedOutput());
            }
        }
        return result.toString();
    }

    public static RandProduct readProduct(int index) {
        if (index < 0 || index >= getProductCount()) {
            return null;
        }
        try (RandomAccessFile file = new RandomAccessFile(listFileName, "r")) {
            file.seek((long) index * RandProduct.getRecordSize());
            byte[] name = new byte[RandProduct.NAME_LEN];
            byte[] description = new byte[RandProduct.DESCRIPTION_LEN];
            byte[] id = new byte[RandProduct.ID_LEN];
            file.read(name);
            file.read(description);
            file.read(id);
            double cost = file.readDouble();
            return new RandProduct(new String(id), new String(name), new String(description), cost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateProductCount() {
        try (RandomAccessFile file = new RandomAccessFile(listFileName, "r")) {
            productCount = (int) file.length() / RandProduct.getRecordSize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
