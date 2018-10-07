import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Moneda } from '../moneda';
import { MonedaService } from '../../../service/moneda.service';


@Component({
  selector: 'app-moneda-dialog',
  templateUrl: './moneda-dialog.component.html',
  styleUrls: ['./moneda-dialog.component.css']
})
export class MonedaDialogComponent implements OnInit {

  moneda: Moneda;


  constructor(public dialogRef: MatDialogRef<MonedaDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data: Moneda, private monedaService: MonedaService) {
    if (data === null)
      this.moneda = new Moneda();
    else
      this.moneda = data;
  }

  ngOnInit() {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  saveMoneda(): void {
    this.monedaService.addMoneda(this.moneda).subscribe();
    this.dialogRef.close(this.moneda);
  }

}
