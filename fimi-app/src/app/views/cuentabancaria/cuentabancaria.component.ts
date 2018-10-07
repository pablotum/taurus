import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { CuentabancariaService } from '../../service/cuentabancaria.service';
import { Cuentabancaria } from './cuentabancaria';
import { BancoService } from '../../service/banco.service';
import { TipocuentaService } from '../../service/tipocuenta.service';
import { MonedaService } from '../../service/moneda.service';
import { Tipocuenta } from '../tipocuenta/tipocuenta';
import { Banco } from '../banco/banco';
import { Moneda } from '../moneda/moneda';
import { CuentaService } from '../../service/cuenta.service';
import { Cuenta } from '../cuenta/cuenta';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

@Component({
  selector: 'app-cuentabancaria',
  templateUrl: './cuentabancaria.component.html',
  styleUrls: ['./cuentabancaria.component.css']
})
export class CuentabancariaComponent implements OnInit {

  cuentasbancarias: Cuentabancaria[];
  constructor(private cuentaService: CuentabancariaService, private dialog: MatDialog) { }

  ngOnInit() {
    this.getCuentasBancarias();
  }

  openDialog(cuenta): void {

    let tmp: Cuentabancaria = Object.assign(new Cuentabancaria(), cuenta);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(NuevaCuenta, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (cuenta == null) {
        this.getCuentasBancarias();
      } else {
        Object.assign(cuenta, result);
      }
    });
  }

  getCuentasBancarias(): void {
    this.cuentaService.getCuentasBancarias()
      .subscribe(cuentas => this.cuentasbancarias = cuentas);
  }

}

@Component({
  selector: 'app-cuentabancaria',
  templateUrl: './nueva.cuenta.html',
  styleUrls: ['./cuentabancaria.component.css']
})

export class NuevaCuenta implements OnInit {

  bancos: Banco[];
  monedas: Moneda[];
  tipocuentas: Tipocuenta[];
  cuenta: Cuentabancaria;
  cuentaForm: FormGroup;
  cuentas: Cuenta[];
  filteredCuentas: Observable<Cuenta[]>;

  constructor(public dialogRef: MatDialogRef<NuevaCuenta>,
    @Inject(MAT_DIALOG_DATA) data: Cuentabancaria,
    private bancoService: BancoService,
    private tipoService: TipocuentaService,
    private monedaService: MonedaService,
    private cuentaService: CuentabancariaService,
    private cuentaContable: CuentaService) {
    if (data === null)
      this.cuenta = new Cuentabancaria();
    else
      this.cuenta = data;

    this.cuentaForm = new FormGroup({
      idCuentaBancaria: new FormControl(this.cuenta.idCuentaBancaria),
      cuentaBancaria: new FormControl(this.cuenta.cuentaBancaria, Validators.maxLength(150)),
      descripcion: new FormControl(this.cuenta.descripcion, Validators.maxLength(150)),
      estado: new FormControl(this.cuenta.estado),
      banco: new FormControl(this.cuenta.banco, Validators.required),
      moneda: new FormControl(this.cuenta.moneda, Validators.required),
      tipoCuenta: new FormControl(this.cuenta.tipoCuenta, Validators.required),
      cuenta: new FormControl(this.cuenta.cuentaContable, Validators.required)
    });

  }

  ngOnInit() {
    this.getBancos();
    this.getMonedas();
    this.getTiposCuenta();
    this.getCuentas();
    this.filteredCuentas = this.cuentaForm.get('cuenta').valueChanges
      .pipe(
        startWith(''),
        map(cuenta => cuenta ? this._filterCuentas(cuenta) : this.cuentas)
      );
  }

  private _filterCuentas(value: string): Cuenta[] {
    const filterValue = value;

    return this.cuentas.filter(state => state.cuentaContable.indexOf(filterValue) === 0);
  }

  onFormSubmit(): void {
    this.saveCuenta();
  }

  saveCuenta(): void {
    this.cuenta.idCuentaBancaria = this.cuentaForm.get('idCuentaBancaria').value;
    this.cuenta.cuentaBancaria = this.cuentaForm.get('cuentaBancaria').value;
    this.cuenta.descripcion = this.cuentaForm.get('descripcion').value;
    this.cuenta.banco = this.cuentaForm.get('banco').value;
    this.cuenta.moneda = this.cuentaForm.get('moneda').value;
    this.cuenta.tipoCuenta = this.cuentaForm.get('tipoCuenta').value;
    this.cuenta.estado = this.cuentaForm.get('estado').value;
    this.cuenta.cuentaContable = this.cuentaForm.get('cuenta').value;
    this.cuentaService.addCuentaBancaria(this.cuenta).subscribe(cuenta => {
      this.dialogRef.close(cuenta);
    });

  }

  compareTipo(o1: any, o2: any): boolean {
    return o1.idTipoCuenta === o2.idTipoCuenta && o1.tipoCuenta === o2.tipoCuenta;
  }

  compareMoneda(o1: any, o2: any): boolean {
    return o1.idMoneda === o2.idMoneda && o1.moneda === o2.moneda;
  }

  compareBanco(o1: any, o2: any): boolean {
    return o1.idBanco === o2.idBanco && o1.nombre === o2.nombre;
  }

  compareCuenta(o1: any, o2: any): boolean {
    return o1.idCuentaContable === o2.idCuentaContable && o1.cuentaContable === o2.cuentaContable;
  }

  getBancos(): void {
    this.bancoService.getBancos()
      .subscribe(bancos => this.bancos = bancos);
  }

  getMonedas(): void {
    this.monedaService.getMonedas()
      .subscribe(monedas => this.monedas = monedas);
  }

  getTiposCuenta(): void {
    this.tipoService.getTipoCuentas()
      .subscribe(tipocuentas => this.tipocuentas = tipocuentas);
  }

  getCuentas(): void {
    this.cuentaContable.getCuentas()
      .subscribe(cuenta => this.cuentas = cuenta);
  }
}