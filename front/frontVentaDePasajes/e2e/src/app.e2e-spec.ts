import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    page.clickPurchaseButton();
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.get('http://localhost:8181/home');
  });
});

