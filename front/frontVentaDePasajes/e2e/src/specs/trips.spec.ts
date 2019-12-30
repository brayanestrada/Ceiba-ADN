import { tripsPage } from '../pages/trips';
import { navBar } from '../pages/navbar';
import { browser } from 'protractor';
import { driverPage } from '../pages/drivers';

describe('Testing trips section', async () => {
  const trips = new tripsPage();
  const navbar = new navBar();
  const driver = new driverPage();
  const expectedCurrentUrl = 'http://localhost:4200/trip/list';
  const driverId = '1';
  const driverName = 'Brayan';
  const driverLastName = 'Estrada';
  const driverIdentification = '1017275678';

  beforeAll( () => {
    browser.get(browser.baseUrl);
    navbar.drivers_button_click();
    driver.crate_button_click();
    driver.fill_name_input(driverName);
    driver.fill_last_name_input(driverLastName);
    driver.fill_identification_input(driverIdentification);
    driver.click_save_button();
    navbar.trips_button_click();
  });

  it('Create Trip', () => {
    trips.clickCreateButton();
    trips.fillSeatsAvailableInput(10);
    trips.fillStartCityInput('Medellín');
    trips.fillEndCityInput('Bogotá');
    trips.fillTicketCostInput(35000);
    trips.fillDateInput('12032020');
    trips.selectDriver(1);
    trips.clickSaveButton();
    expect(browser.getCurrentUrl()).toEqual(expectedCurrentUrl);
  });
});
