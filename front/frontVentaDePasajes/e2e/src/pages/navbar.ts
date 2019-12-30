import { element, by, browser } from "protractor"

export class Navbar {

    private home_button = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[1]'));
    private drivers_button = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[2]'));
    private trips_button = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[3]'));
    private purchase_button = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[4]'));

    constructor(){}

    public getUrl(url) { browser.get(url) }

    public home_button_click() { this.home_button.click(); }

    public drivers_button_click() { this.drivers_button.click(); }

    public trips_button_click() { this.trips_button.click(); }

    public purchase_button_click() { this.purchase_button.click(); }

}
