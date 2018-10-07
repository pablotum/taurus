import { TestBed, inject } from '@angular/core/testing';

import { ClasificacioncuentaService } from './clasificacioncuenta.service';

describe('ClasificacioncuentaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClasificacioncuentaService]
    });
  });

  it('should be created', inject([ClasificacioncuentaService], (service: ClasificacioncuentaService) => {
    expect(service).toBeTruthy();
  }));
});
