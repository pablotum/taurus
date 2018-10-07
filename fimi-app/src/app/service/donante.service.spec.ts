import { TestBed, inject } from '@angular/core/testing';

import { DonanteService } from './donante.service';

describe('DonanteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DonanteService]
    });
  });

  it('should be created', inject([DonanteService], (service: DonanteService) => {
    expect(service).toBeTruthy();
  }));
});
