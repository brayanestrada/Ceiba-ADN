import { element, by } from 'protractor';

export class driverPage {
    private createButton = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/button'));
    private nameInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-driver/div/form/div/div[1]/div/input'));
    private lastNameinput = element(by.xpath('/html/body/app-root/app-navbar/app-create-driver/div/form/div/div[2]/div/input'));
    private identificationInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-driver/div/form/div/div[3]/div/input'));
    private saveButton = element(by.xpath('/html/body/app-root/app-navbar/app-create-driver/div/form/div/div[4]/div/input'));
    private idFirstRecord = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/table/tbody[1]/tr/td[1]'));
    private nameFirstRecord = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/table/tbody[1]/tr/td[2]'));
    private lastNameFirstRecord = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/table/tbody[1]/tr/td[3]'));
    private identificationFirstRecord = element(by.xpath('/html/body/app-root/app-navbar/app-list-driver/div/table/tbody[2]/tr/td[4]'));

    constructor() {}

    public crate_button_click() { this.createButton.click(); }

    public fill_name_input(value: string) { this.nameInput.sendKeys(value); }

    public fill_last_name_input(value: string) { this.lastNameinput.sendKeys(value); }

    public fill_identification_input(value: string) { this.identificationInput.sendKeys(value); }

    public click_save_button() { this.saveButton.click(); }

    public get_first_id_record() {return this.idFirstRecord.getText(); }

    public get_first_name_record() {return this.nameFirstRecord.getText(); }

    public get_first_last_name_record() {return this.lastNameFirstRecord.getText(); }

    public get_first_identification_record() {return this.identificationFirstRecord.getText(); }
}
