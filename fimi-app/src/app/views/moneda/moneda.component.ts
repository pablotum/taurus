import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Moneda } from './moneda';
import { MonedaService } from '../../service/moneda.service';
import { MonedaDialogComponent } from './moneda-dialog/moneda-dialog.component';

@Component({
  selector: 'app-moneda',
  templateUrl: './moneda.component.html',
  styleUrls: ['./moneda.component.css']
})
export class MonedaComponent implements OnInit {

  monedas: Moneda[];

  constructor(private monedaService: MonedaService, private dialog: MatDialog) { }

  openDialog(moneda): void {

    let tmp: Moneda = Object.assign(new Moneda(), moneda);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(MonedaDialogComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if ( moneda == null ) {
        this.getMonedas();
      } else {
        Object.assign(moneda, result);
      }
    });
  }

  openConfirmar(moneda): void {

    const eliminarConfig = new MatDialogConfig();

    eliminarConfig.disableClose = true;
    eliminarConfig.autoFocus = true;
    eliminarConfig.data = moneda;

    const eliminarRef = this.dialog.open(EliminarMoneda, eliminarConfig);

    eliminarRef.afterClosed().subscribe(result => {
      if (result === 1) {
        this.monedas.push(moneda);
      }
    });
  }

  ngOnInit() {
    this.getMonedas();
  }

  getMonedas(): void {
    this.monedaService.getMonedas()
      .subscribe(monedas => this.monedas = monedas)
  }

  editar(row): void {
    this.openDialog(row);
  }

}

@Component({
  selector: 'app-moneda',
  templateUrl: './eliminar.component.html',
  styleUrls: ['./moneda.component.css']
})
export class EliminarMoneda {

  moneda: Moneda;

  constructor(public dialogRef: MatDialogRef<MonedaDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data: Moneda, private monedaService: MonedaService) {
    if (data === null)
      this.moneda = new Moneda();
    else
      this.moneda = data;
  }

  eliminar(): void {
    alert(this.moneda.idMoneda);
    this.monedaService.deleteMoneda(this.moneda.idMoneda);
    this.dialogRef.close(1);
  }

}
