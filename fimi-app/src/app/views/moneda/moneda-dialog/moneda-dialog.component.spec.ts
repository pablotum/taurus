import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonedaDialogComponent } from './moneda-dialog.component';

describe('MonedaDialogComponent', () => {
  let component: MonedaDialogComponent;
  let fixture: ComponentFixture<MonedaDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonedaDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonedaDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
