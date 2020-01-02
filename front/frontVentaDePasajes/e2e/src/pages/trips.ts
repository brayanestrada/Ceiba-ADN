import { element, by, browser } from 'protractor';

// tslint:disable-next-line: class-name
export class tripsPage {
  private createButton = element(by.xpath('/html/body/app-root/app-navbar/app-list-trip/div/button'));
  private seatsAvailableInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-second/div/div/form/div[2]/input'));
  private startCityInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-second/div/div/form/div[1]/div[2]/input'));
  private endCityInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-second/div/div/form/div[1]/div[3]/input'));
  private ticketCostInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-second/div/div/form/div[3]/div[1]/input'));
  private dateInput = element(by.xpath('/html/body/app-root/app-navbar/app-create-second/div/div/form/div[3]/div[2]/input'));
  private selectFirstDriver = element(by.xpath('/html/body/app-root/app-navbar/app-create-second/div/div/form/div[1]/div[1]/select/option[2]'));
  private saveButton = element(by.xpath('/html/body/app-root/app-navbar/app-create-second/div/div/form/div[4]/div/input'));
  private numberOfTicketsInput = element(by.xpath('/html/body/app-root/app-navbar/app-list-trip/div/div/div[1]/div/div[3]/div[1]/form/input[1]'));
  private buyTicketButton = element(by.xpath('/html/body/app-root/app-navbar/app-list-trip/div/div/div[1]/div/div[3]/div[1]/form/input[2]'));
  private deleteTripButton = element(by.xpath('/html/body/app-root/app-navbar/app-list-trip/div/div/div[1]/div/div[3]/div[3]/button'));

  constructor() {}

  public clickAnyPart() {
    browser.actions().mouseMove(this.seatsAvailableInput, {x: 20, y: 0}).click().perform();
  }

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

  public fillNumberOfTicketsInput(value: string){
    this.numberOfTicketsInput.sendKeys(value);
  }

  public clickBuyTicketsButton(){
    this.buyTicketButton.click();
  }

  public clickDeleteTripButton(){
    this.deleteTripButton.click();
  }
}
