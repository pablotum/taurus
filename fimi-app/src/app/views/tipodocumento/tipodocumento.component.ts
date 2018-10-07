import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Tipodocumento } from './tipodocumento';
import { TipodocumentoService } from '../../service/tipodocumento.service';
import { Cuentabancaria } from '../cuentabancaria/cuentabancaria';
import { CuentabancariaService } from '../../service/cuentabancaria.service';
import { CuentaService } from '../../service/cuenta.service';
import { Cuenta } from '../cuenta/cuenta';

@Component({
  selector: 'app-tipodocumento',
  templateUrl: './tipodocumento.component.html',
  styleUrls: ['./tipodocumento.component.css']
})
export class TipodocumentoComponent implements OnInit {
  documentos: Tipodocumento[];

  constructor(private tipoService: TipodocumentoService,
    private dialog: MatDialog) { }

  ngOnInit() {
    this.getTipoDocumentos();
  }

  openDialog(tipodocumento): void {

    let tmp: Tipodocumento = Object.assign(new Tipodocumento(), tipodocumento);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(NuevoTipoDocumento, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (tipodocumento == null) {
        this.getTipoDocumentos();
      } else {
        Object.assign(tipodocumento, result);
      }
    });
  }

  getTipoDocumentos(): void {
    this.tipoService.getTipoDocumentos()
      .subscribe(tipos => this.documentos = tipos);
  }

}

@Component({
  selector: 'app-tipodocumento',
  templateUrl: './tipodocumento.nuevo.html',
  styleUrls: ['./tipodocumento.component.css']
})

export class NuevoTipoDocumento implements OnInit {

  documento: Tipodocumento;
  cuentas: Cuentabancaria[];
  contables: Cuenta[];

  constructor(public dialogRef: MatDialogRef<NuevoTipoDocumento>,
    @Inject(MAT_DIALOG_DATA) data: Tipodocumento,
    private tipoService: TipodocumentoService,
    private cuentaService: CuentabancariaService,
    private contableService: CuentaService) {
    if (data === null)
      this.documento = new Tipodocumento();
    else
      this.documento = data;
  }

  compareCuenta(o1: any, o2: any): boolean {
    return o1.idCuentaContable === o2.idCuentaContable && o1.cuentaContable === o2.cuentaContable;
  }

  compareBanco(o1: any, o2: any): boolean {
    return o1.idBanco === o2.idBanco && o1.nombre === o2.nombre;
  }

  saveDocumento(): void {
    this.tipoService.addTipoDocumento(this.documento)
      .subscribe( data => {
        this.dialogRef.close(this.documento);
      });
  }

  ngOnInit() {
    this.getContables();
    this.getCuentas();
  }

  getCuentas(): void {
    this.cuentaService.getCuentasBancarias()
      .subscribe(cuentas => this.cuentas = cuentas);
  }

  getContables(): void {
    this.contableService.getCuentas()
      .subscribe(cuentas => this.contables = cuentas);
  }

}