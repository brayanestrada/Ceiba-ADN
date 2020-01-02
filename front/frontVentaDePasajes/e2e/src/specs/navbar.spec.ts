import { navBar } from '../pages/navbar';
import { browser } from 'protractor';

describe('Testing the navbar redirectiong', () => {
    const navbar = new navBar();

    beforeAll(async ( ) => {
        navbar.getUrl('http://localhost:4200/');
    });

    it('Test all navbar links', () => {
      browser.waitForAngular();
      browser.sleep(3000);
      navbar.home_button_click();
      navbar.drivers_button_click();
      navbar.trips_button_click();
      navbar.purchase_button_click();
    });
});
