import { TestBed, inject } from '@angular/core/testing';

import { TipoempresaService } from './tipoempresa.service';

describe('TipoempresaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TipoempresaService]
    });
  });

  it('should be created', inject([TipoempresaService], (service: TipoempresaService) => {
    expect(service).toBeTruthy();
  }));
});
