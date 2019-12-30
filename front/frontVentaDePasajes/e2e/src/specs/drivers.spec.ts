import { drivers_page } from '../pages/drivers';
import { Navbar } from '../pages/navbar'
import { browser } from 'protractor';

describe('Testing driver section:', () =>{
    
    const _navbar = new Navbar();
    const _driver = new drivers_page();
    const _expectedCurrentUrl = 'http://localhost:4200/driver/create';
    const _driver_id = '1';
    const _driver_name = 'Brayan';
    const _driver_last_name = 'Estrada';
    const _driver_identification = '1017275678';

    beforeAll(async () =>{
        _navbar.getUrl(browser.baseUrl);
        _navbar.drivers_button_click();        
    });

    it('Validate current URL', () =>{     
        _driver.crate_button_click();
        let url = browser.getCurrentUrl();
        expect(url).toEqual(_expectedCurrentUrl);
    });

    it('Creating a driver', () =>{
        _driver.fill_name_input(_driver_name);
        _driver.fill_last_name_input(_driver_last_name);
        _driver.fill_identification_input(_driver_identification);
        _driver.click_save_button();
    });

    it('Validate created driver', () =>{
        _driver.crate_button_click();
        _driver.fill_name_input(_driver_name);
        _driver.fill_last_name_input(_driver_last_name);
        _driver.fill_identification_input(_driver_identification);
        _driver.click_save_button();
        browser.sleep(2000);
        expect(_driver.get_first_id_record()).toEqual(_driver_id);
        expect(_driver.get_first_name_record()).toEqual(_driver_name);
        expect(_driver.get_first_last_name_record()).toEqual(_driver_last_name);
        expect(_driver.get_first_identification_record()).toEqual(_driver_identification);
    })
});