import { TestBed, inject } from '@angular/core/testing';

import { UsocuentaService } from './usocuenta.service';

describe('UsocuentaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UsocuentaService]
    });
  });

  it('should be created', inject([UsocuentaService], (service: UsocuentaService) => {
    expect(service).toBeTruthy();
  }));
});
