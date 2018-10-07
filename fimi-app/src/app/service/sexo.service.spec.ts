import { TestBed, inject } from '@angular/core/testing';

import { SexoService } from './sexo.service';

describe('SexoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SexoService]
    });
  });

  it('should be created', inject([SexoService], (service: SexoService) => {
    expect(service).toBeTruthy();
  }));
});
