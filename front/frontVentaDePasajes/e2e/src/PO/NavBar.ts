import { element, by } from "protractor";

export class NavBarPO{
    private static homeButton = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[1]'));
    private static purchaseButton = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[2]'))
    private static tripsButton = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[3]'));


    public static clickHomeButton(){
        this.homeButton.click();
    }

    public static clickPurchaseButton(){
        this.purchaseButton.click();
    }

    public static clickTripsButton(){
        this.tripsButton.click();
    }
}