import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsocuentaComponent } from './usocuenta.component';

describe('UsocuentaComponent', () => {
  let component: UsocuentaComponent;
  let fixture: ComponentFixture<UsocuentaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsocuentaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsocuentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
