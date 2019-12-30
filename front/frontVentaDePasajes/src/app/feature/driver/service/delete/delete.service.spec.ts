import { TestBed } from '@angular/core/testing';

import { DeleteDriverService } from './delete.service';

describe('DeleteDriverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DeleteDriverService = TestBed.get(DeleteDriverService);
    expect(service).toBeTruthy();
  });
});
