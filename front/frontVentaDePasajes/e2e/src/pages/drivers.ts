import { element, by } from 'protractor'

export class drivers_page {
    private _create_button = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/button'));
    private _name_input = element(by.xpath('/html/body/app-root/app-navbar/app-create-driver/div/form/div/div[1]/div/input'));
    private _last_name_input = element(by.xpath('/html/body/app-root/app-navbar/app-create-driver/div/form/div/div[2]/div/input'));
    private _identification_input = element(by.xpath('/html/body/app-root/app-navbar/app-create-driver/div/form/div/div[3]/div/input'));
    private _save_button = element(by.xpath('/html/body/app-root/app-navbar/app-create-driver/div/form/div/div[4]/div/input'));
    private _id_first_record = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/table/tbody[1]/tr/td[1]'));
    private _name_first_record = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/table/tbody[1]/tr/td[2]'));
    private _last_name_first_record = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/table/tbody[1]/tr/td[3]'));
    private _identification_first_record = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/table/tbody[2]/tr/td[4]'));

    constructor(){}

    public crate_button_click(){ this._create_button.click();}

    public fill_name_input(value: string){ this._name_input.sendKeys(value);}

    public fill_last_name_input(value: string){ this._last_name_input.sendKeys(value);}

    public fill_identification_input(value: string){ this._identification_input.sendKeys(value);}

    public click_save_button(){ this._save_button.click();}

    public get_first_id_record() {return this._id_first_record.getText();}

    public get_first_name_record() {return this._name_first_record.getText();}

    public get_first_last_name_record() {return this._last_name_first_record.getText();}

    public get_first_identification_record() {return this._identification_first_record.getText();}
}