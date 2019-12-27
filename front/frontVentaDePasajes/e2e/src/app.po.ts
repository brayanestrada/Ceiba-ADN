import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  clickPurchaseButton() {
    return element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/a[2]')).click;
  }
}
