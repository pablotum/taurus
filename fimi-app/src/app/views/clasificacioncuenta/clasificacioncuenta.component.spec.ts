import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClasificacioncuentaComponent } from './clasificacioncuenta.component';

describe('ClasificacioncuentaComponent', () => {
  let component: ClasificacioncuentaComponent;
  let fixture: ComponentFixture<ClasificacioncuentaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClasificacioncuentaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClasificacioncuentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
