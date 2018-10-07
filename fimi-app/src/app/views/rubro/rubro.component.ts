import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { RubroService } from '../../service/rubro.service';
import { Rubro } from './rubro';
import { Cuenta } from '../cuenta/cuenta';
import { CuentaService } from '../../service/cuenta.service';

@Component({
  selector: 'app-rubro',
  templateUrl: './rubro.component.html',
  styleUrls: ['./rubro.component.css']
})
export class RubroComponent implements OnInit {

  rubros: Rubro[];

  constructor(private rubroService: RubroService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.getRubros();
  }

  openDialog(rubro): void {

    let tmp: Rubro = Object.assign(new Rubro(), rubro);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(saveRubro, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if ( rubro == null ) {
        this.getRubros();
      } else {
        Object.assign(rubro, result);
      }
    });
  }

  getRubros(): void {
    this.rubroService.getRubros()
    .subscribe(rubros => this.rubros = rubros);
  }

}

@Component({
  selector: 'app-rubro',
  templateUrl: './rubro.nuevo.html',
  styleUrls: ['./rubro.component.css']
})
export class saveRubro {

  rubro: Rubro;
  cuentas: Cuenta[];
  
  constructor(public dialogRef: MatDialogRef<saveRubro>,
    @Inject(MAT_DIALOG_DATA) data: Rubro, 
    private rubroService: RubroService,
    private cuentaService: CuentaService) {
    if (data === null)
      this.rubro = new Rubro();
    else
      this.rubro = data;
      
    this.getCuentas();
  }

  saveRubro(): void {
    this.rubroService.addRubro(this.rubro).subscribe();
    this.dialogRef.close(this.rubro);
  }

  compareCuenta(o1: any, o2: any): boolean {
    return o1.idCuentaContable === o2.idCuentaContable && o1.cuentaContable === o2.cuentaContable;
  }

  getCuentas(): void {
    this.cuentaService.getCuentas()
    .subscribe(cuentas => this.cuentas = cuentas);
  }

}

