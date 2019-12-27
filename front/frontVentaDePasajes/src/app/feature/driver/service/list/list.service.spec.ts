import { TestBed } from '@angular/core/testing';

import { ListDriverService } from './list.service';

describe('ListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListDriverService = TestBed.get(ListDriverService);
    expect(service).toBeTruthy();
  });
});
