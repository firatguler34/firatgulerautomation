import org.openqa.selenium.By;

public class Constants {
    public static final By loginButton1 = By.cssSelector("[title='Giriş Yap']");
    public static final By loginButton2 = By.cssSelector("[data-cy='header-login-button']");
    public static final By usernameInput = By.id("L-UserNameField");
    public static final By passwordInput = By.id("L-PasswordField");
    public static final By loginButton3 = By.id("gg-login-enter");
    public static final By searchInput = By.name("k");
    public static final By pageSearchText = By.cssSelector("[class*='info-container']");
    public static final By searchSuggestions = By.cssSelector("ul[data-cy='auto-complete-list-container'] li");
    public static final By productsBoxs = By.cssSelector("li[id^='product_id_']");
    public static final By productTitles = By.cssSelector("h3 span");
    public static final By productDetailLastPrice = By.cssSelector("[class*='lastPrice']");
    public static final By productDetailAddToCartButton = By.id("add-to-basket");
    public static final By cartTitle = By.className("basket-title");
    public static final By cartProductsBoxs = By.cssSelector("[id^='cart-item-']");
    public static final By cartProductsDiscountedPrices = By.cssSelector("[class='total-price']");
    public static final By accountNameBox = By.cssSelector("[title='Hesabım'] span");
    public static final By amountProductCard = By.cssSelector("[class='amount']");
    public static final By deleteCardIcon = By.cssSelector("div[class*='update-buttons-container'] a[title='Sil']");
    public static final By controlTextCard = By.cssSelector("[class*='empty-cart-info'] h2");
    public static final By amountChanges = By.cssSelector("[class='amount']");
    public static final By amountControlChange = By.cssSelector("select[value='2']");






}
