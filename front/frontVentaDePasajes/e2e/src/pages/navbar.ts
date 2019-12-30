import { element, by, browser } from "protractor"

export class navBar {

    private homeButton = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[1]'));
    private driversButton = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[2]'));
    private tripsButton = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[3]'));
    private purchaseButton = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[4]'));

    constructor() {}

    public getUrl(url) { browser.get(url) }

    public home_button_click() { this.homeButton.click(); }

    public drivers_button_click() { this.driversButton.click(); }

    public trips_button_click() { this.tripsButton.click(); }

    public purchase_button_click() { this.purchaseButton.click(); }

}
