import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CuentabancariaComponent } from './cuentabancaria.component';

describe('CuentabancariaComponent', () => {
  let component: CuentabancariaComponent;
  let fixture: ComponentFixture<CuentabancariaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CuentabancariaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CuentabancariaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
