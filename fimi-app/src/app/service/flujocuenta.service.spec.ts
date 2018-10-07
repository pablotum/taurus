import { TestBed, inject } from '@angular/core/testing';

import { FlujocuentaService } from './flujocuenta.service';

describe('FlujocuentaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FlujocuentaService]
    });
  });

  it('should be created', inject([FlujocuentaService], (service: FlujocuentaService) => {
    expect(service).toBeTruthy();
  }));
});
