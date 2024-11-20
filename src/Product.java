/*
class Product implements IProduct{
    String productId;
    int salesVelocity;
    int stockLevel;

    public Product(String productId, int salesVelocity, int stockLevel) {
        this.productId = productId;
        this.salesVelocity = salesVelocity;
        this.stockLevel = stockLevel;
    }
}


class InventoryClearance {
    public List<String> identifyClearanceItems(List<Product> products) {
        List<String> clearanceItems = new ArrayList<>();
        for (Product product : products) {
            if (product.salesVelocity <= 2 && product.stockLevel >= 10) {
                clearanceItems.add(product.productId);
            }
        }
        return clearanceItems;
    }
}
*/
