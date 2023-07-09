import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketProjectionsComponent } from './ticket-projections.component';

describe('TicketProjectionsComponent', () => {
  let component: TicketProjectionsComponent;
  let fixture: ComponentFixture<TicketProjectionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketProjectionsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TicketProjectionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
