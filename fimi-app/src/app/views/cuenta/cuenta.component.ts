import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Cuenta } from './cuenta';
import { CuentaService } from '../../service/cuenta.service';
import { UsocuentaService } from '../../service/usocuenta.service';
import { FlujocuentaService } from '../../service/flujocuenta.service';
import { ClasificacioncuentaService } from '../../service/clasificacioncuenta.service';
import { Usocuenta } from '../usocuenta/usocuenta';
import { Flujocuenta } from '../flujocuenta/flujocuenta';
import { Clasificacioncuenta } from '../clasificacioncuenta/clasificacioncuenta';

@Component({
  selector: 'app-cuenta',
  templateUrl: './cuenta.component.html',
  styleUrls: ['./cuenta.component.css']
})
export class CuentaComponent implements OnInit {

  cuentas: Cuenta[];

  constructor(private cuentaService: CuentaService,
    private dialog: MatDialog) { }

  ngOnInit() {
    this.getCuentas();
  }

  openDialog(cuenta): void {

    let tmp: Cuenta = Object.assign(new Cuenta(), cuenta);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(saveCuenta, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (cuenta == null) {
        this.getCuentas();
      } else {
        Object.assign(cuenta, result);
      }
    });
  }

  getCuentas(): void {
    this.cuentaService.getCuentas()
      .subscribe(cuentas => this.cuentas = cuentas);
  }

}

@Component({
  selector: 'app-cuenta',
  templateUrl: './cuenta.nuevo.html',
  styleUrls: ['./cuenta.component.css']
})

export class saveCuenta {

  cuenta: Cuenta;
  usos: Usocuenta[];
  flujos: Flujocuenta[];
  clasificaciones: Clasificacioncuenta[];


  constructor(public dialogRef: MatDialogRef<saveCuenta>,
    @Inject(MAT_DIALOG_DATA) data: Cuenta,
    private cuentaService: CuentaService,
    private usoService: UsocuentaService,
    private flujoService: FlujocuentaService,
    private clasificacionServicie: ClasificacioncuentaService) {
    if (data === null)
      this.cuenta = new Cuenta();
    else
      this.cuenta = data;

    this.getClasificacion();
    this.getFlujo();
    this.getUso();

  }

  compareClasificacion(o1: any, o2: any): boolean {
    return o1.clasificacionCuenta === o2.clasificacionCuenta && o1.idClasificacionCuenta === o2.idClasificacionCuenta;
  }

  compareUso(o1: any, o2: any): boolean {
    return o1.idUsoCuenta === o2.idUsoCuenta && o1.usoCuenta === o2.usoCuenta;
  }

  compareFlujo(o1: any, o2: any): boolean {
    return o1.idFlujoCuenta === o2.idFlujoCuenta && o1.flujoCuenta === o2.flujoCuenta;
  }

  saveCuenta(): void {
    this.cuentaService.addCuenta(this.cuenta).subscribe();
    this.dialogRef.close(this.cuenta);
  }

  getUso(): void {
    this.usoService.getUso()
      .subscribe(usos => this.usos = usos); 
  }

  getClasificacion(): void {
    this.clasificacionServicie.getClasificacion()
    .subscribe(clasificaciones => this.clasificaciones = clasificaciones);
  }

  getFlujo(): void {
    this.flujoService.getFlujos()
    .subscribe( flujos => this.flujos = flujos);
  }

}
