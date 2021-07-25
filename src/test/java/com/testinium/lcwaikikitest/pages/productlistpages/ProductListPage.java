package com.testinium.lcwaikikitest.pages.productlistpages;

import com.testinium.lcwaikikitest.operations.Operations;
import com.testinium.lcwaikikitest.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class ProductListPage extends BasePage {
    public ProductListPage(WebDriver driver, Operations operations) {
        super(driver, operations);
    }

    public void add_nth_item_to_favourites(int n){
        String baseKey = "productListPage_product_list"; // Product List Container
        String relAddress = "/div[" + n + "]/div[1]";           // Relative address of the nth element
        operations.click_inner_element_by_xpath(baseKey, relAddress);
    }
}
