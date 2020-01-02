import { element, by } from 'protractor';

export class purchasePage{
    private deleteButton = element(by.xpath('/html/body/app-root/app-navbar/app-list-purchase/div/table/tbody[1]/tr/td[6]/button'));
    private purchaseId = element(by.xpath('/html/body/app-root/app-navbar/app-list-purchase/div/table/tbody[1]/tr/td[1]'));

    constructor() {}

    public clickDeleteButton(){
        this.deleteButton.click();
    }

    public getPurchaseId(){
        return this.purchaseId.getText();
    }

    public validateDeletedRow(id: number){
        this.getPurchaseId();

    }
}