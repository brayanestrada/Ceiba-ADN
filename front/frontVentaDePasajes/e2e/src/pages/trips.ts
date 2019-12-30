import { element, by, browser } from 'protractor';

// tslint:disable-next-line: class-name
export class tripsPage {
  private createButton = element(by.xpath('/html/body/app-root/app-navbar/app-list-trip/div/button'));
  private seatsAvailableInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-trip/div/form/div/div[1]/div/input'));
  private startCityInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-trip/div/form/div/div[2]/div/input'));
  private endCityInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-trip/div/form/div/div[3]/div/input'));
  private ticketCostInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-trip/div/form/div/div[4]/div/input'));
  private dateInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-trip/div/form/div/div[5]/div/input'));
  private selectFirstDriver = element(by.xpath('/html/body/app-root/app-navbar/app-create-trip/div/form/div/div[6]/div/select/option[2]'));
  private saveButton = element(by.xpath('/html/body/app-root/app-navbar/app-create-trip/div/form/div/div[7]/button'));
  private tripTitle = element(by.xpath('/html/body/app-root/app-navbar/app-create-trip/div/h2'));

  constructor() {}

  public clickCreateButton() {
    this.createButton.click();
  }

  public fillSeatsAvailableInput(value: number) {
    this.seatsAvailableInput .sendKeys(value);
  }

  public fillStartCityInput(value: string) {
    this.startCityInput.sendKeys(value);
  }

  public fillEndCityInput(value: string) {
    this.endCityInput.sendKeys(value);
  }

  public fillTicketCostInput(value: number) {
    this.ticketCostInput.sendKeys(value);
  }

  public fillDateInput(value: string) {
    this.dateInput.sendKeys(value);
  }

  public selectDriver(index: number) {
    this.selectFirstDriver.click();
  }

  public clickSaveButton() {
    this.saveButton.click();
  }

  public clickTripTitle() {
    this.tripTitle.click();
  }
}
