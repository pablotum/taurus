import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlujocuentaComponent } from './flujocuenta.component';

describe('FlujocuentaComponent', () => {
  let component: FlujocuentaComponent;
  let fixture: ComponentFixture<FlujocuentaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlujocuentaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlujocuentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
