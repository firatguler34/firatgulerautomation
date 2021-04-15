import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;
import java.util.List;

public class StepsPage extends BasePage {
    //driver BaseTest class içinde.
    final static Logger logger = Logger.getLogger(StepsPage.class);

    public StepsPage verifyMainPage(String baseurl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Ana sayfa açılmadı.", currentUrl, baseurl);
        logger.info("!! Ana sayfa doğrulandı !! :"+driver.getTitle());
        return this;
    }
    public StepsPage login(String userName, String password) {
        moveToElement(Constants.loginButton1);
        click(Constants.loginButton2);
        sendKeys(Constants.usernameInput, userName);
        sendKeys(Constants.passwordInput, password);
        click(Constants.loginButton3);
        return this;
    }
    public StepsPage verifyLogin(String accountName) {
        String incomingAccountName = findElement(Constants.accountNameBox).getText();
        Assert.assertEquals("giriş yapılamadı", incomingAccountName, accountName);
        logger.info("!! Kullanıcı giriş yaptığı doğrulandı. !!");
        return this;
    }

    public StepsPage search(String word) {
        sendKeys(Constants.searchInput, word);
        List<WebElement> searchSuggestions = findElements(Constants.searchSuggestions);
        searchSuggestions.get(1).click();
        logger.info("Arama sonuçlarından 2. sayfa açıldı.");
        return this;
    }
    public StepsPage verifySearchPage(String searchName) {
        String searchPageTextTitle = findElement(Constants.pageSearchText).getText();
        Assert.assertTrue("Arama sonuçları sayfası açılmadı.", searchPageTextTitle.contains(searchName));
        logger.info("!! Arama Sonucu 2. Sayfa Açıldığı Doğrulandı !! : " + driver.getTitle());
        return this;
    }

    public StepsPage chooseProductRandomly() {
        List<WebElement> productBoxes = findElements(Constants.productsBoxs);
        clickByJs((productBoxes.get(getRandomNumber(3)).findElement(Constants.productTitles)));
        logger.info("Random bir ürün seçildi.");
        return this;
    }

    public String getSelectedProductPrice() {
        return findElement(Constants.productDetailLastPrice).getText();
    }

    public StepsPage addToCart() throws InterruptedException {
        clickByJs(Constants.productDetailAddToCartButton);
        logger.info("Ürün sepete eklendi.");
        Thread.sleep(2000);
        return this;
    }

    public StepsPage goToCart() {
        moveToElement(Constants.cartTitle);
        clickByJs(Constants.cartTitle);
        logger.info("Sepetime giriş yapıldı : "+driver.getTitle());
        return this;
    }

    public StepsPage verifyTheAddedProductPriceFromTheCart(String expectedPrice) throws InterruptedException {
        boolean isPriceCorrect = false;
        List<WebElement> cartProductBoxes = findElements(Constants.cartProductsBoxs);
        for (int i = 0; i < cartProductBoxes.size(); i++) {
            if (cartProductBoxes.get(i).findElement(Constants.cartProductsDiscountedPrices).getText().contains(expectedPrice)) {
                isPriceCorrect = true;
                break;
            }
        }
        Assert.assertTrue("ürün doğrulanmadı", isPriceCorrect);
        logger.info("!! Ürün fiyatı doğrulandı. !!");
        return this;
    }

    public StepsPage addProductAmount(String amount){
        selectElementByText(Constants.amountChanges,amount);
        logger.info("Ürün miktarı 2 olarak değiştirildi.");
        return this;
    }

    public StepsPage verifyAmountCard (String amount){
        Assert.assertEquals("Ürün miktarı yanlış.", getAttributeOfElement( Constants.amountControlChange,"value"), amount);
        logger.info("!! Ürün miktarı 2 olduğu kontrol edildi. !!");
        return this;
    }

    public StepsPage deleteProductCard () throws InterruptedException {
        click(Constants.deleteCardIcon);
        logger.info("Ürün sepetten çıkarıldı.");
        Thread.sleep(1000);
        return this;
    }
    public StepsPage verifyCard (String controlCardText){
        String verifyNullCard = findElement(Constants.controlTextCard).getText();
        Assert.assertEquals("Ürün silinmedi.", verifyNullCard, controlCardText);
        logger.info("!! Sepetin boş olduğu doğrulandı. !!");
        return this;
    }


    public StepsPage closeTest() {
        driverQuit();
        logger.info("Test tamamlandı.");
        return this;
    }

}
