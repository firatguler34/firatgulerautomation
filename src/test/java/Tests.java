import org.junit.Test;

public class Tests extends BaseTest {

    @Test
    public void gittiGidiyorTest() throws InterruptedException {
        StepsPage stepsPage = new StepsPage();
        stepsPage
                .verifyMainPage("https://www.gittigidiyor.com/")
                .login("firtglrr@gmail.com", "Firat.Work9")
                .verifyLogin("firatguler111875")
                .search("bilgisayar")
                .verifySearchPage("bulundu.")
                .chooseProductRandomly();
        String expectedPrice = stepsPage.getSelectedProductPrice();
        stepsPage
                .addToCart()
                .goToCart()
                .verifyTheAddedProductPriceFromTheCart(expectedPrice)
                .addProductAmount("2")
                .verifyAmountCard("2")
                .deleteProductCard()
                .verifyCard("Sepetinizde ürün bulunmamaktadır.")
                .closeTest();

    }

}
