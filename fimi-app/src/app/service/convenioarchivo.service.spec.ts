import { TestBed, inject } from '@angular/core/testing';

import { ConvenioarchivoService } from './convenioarchivo.service';

describe('ConvenioarchivoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConvenioarchivoService]
    });
  });

  it('should be created', inject([ConvenioarchivoService], (service: ConvenioarchivoService) => {
    expect(service).toBeTruthy();
  }));
});
