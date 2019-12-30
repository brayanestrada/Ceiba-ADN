import { driverPage } from '../pages/drivers';
import { navBar } from '../pages/navbar';
import { browser } from 'protractor';

describe('Testing driver section:', () => {

    const navbar = new navBar();
    const driver = new driverPage();
    const expectedCurrentUrl = 'http://localhost:4200/driver/create';
    const driverId = '1';
    const driverName = 'Brayan';
    const driverLastName = 'Estrada';
    const driverIdentification = '1017275678';

    beforeAll(async () => {
      navbar.getUrl(browser.baseUrl);
      navbar.drivers_button_click();
    });

    it('Validate current URL', () => {
      driver.crate_button_click();
      const url = browser.getCurrentUrl();
      expect(url).toEqual(expectedCurrentUrl);
    });

    it('Creating a driver', () => {
      driver.fill_name_input(driverName);
      driver.fill_last_name_input(driverLastName);
      driver.fill_identification_input(driverIdentification);
      driver.click_save_button();
    });

    it('Validate created driver', () => {
      driver.crate_button_click();
      driver.fill_name_input(driverName);
      driver.fill_last_name_input(driverLastName);
      driver.fill_identification_input(driverIdentification);
      driver.click_save_button();
      browser.sleep(2000);
      expect(driver.get_first_id_record()).toEqual(driverId);
      expect(driver.get_first_name_record()).toEqual(driverName);
      expect(driver.get_first_last_name_record()).toEqual(driverLastName);
      expect(driver.get_first_identification_record()).toEqual(driverIdentification);
    });
});
