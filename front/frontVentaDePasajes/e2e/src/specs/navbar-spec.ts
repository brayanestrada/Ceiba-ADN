import { NavBarPO } from 'e2e/src/PO/NavBar'
import { browser } from 'protractor';

class navbarTest{

    navbarTest(){
        describe('Test clicking navbar buttons', () => {
            
            it('Tap on Home button', () =>{
                browser.get('http://localhost:4200/');
                NavBarPO.clickHomeButton();
            });
            it('Tap on Purchase button', () =>{
                browser.get('http://localhost:4200/');
                NavBarPO.clickPurchaseButton();
            });
            it('Tap on Trip button', ()=>{
                browser.get('http://localhost:4200/');
                NavBarPO.clickTripsButton();
            });
        });
    }

}