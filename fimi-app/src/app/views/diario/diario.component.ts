import { Component, OnInit, Inject, ViewChild  } from '@angular/core';
import { DiarioService } from '../../service/diario.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Diario } from './diario';
import { Cuenta } from '../cuenta/cuenta';
import { CuentaService } from '../../service/cuenta.service';
import { Diariodetalle } from './diariodetalle';

@Component({
  selector: 'app-diario',
  templateUrl: './diario.component.html',
  styleUrls: ['./diario.component.css']
})
export class DiarioComponent implements OnInit {

  diarios: Diario[];
  dataSource = new MatTableDataSource<Diario>();  
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private diarioService: DiarioService,
    private dialog: MatDialog) { }

  ngOnInit() {
    this.getDiarios();
  }

  getDiarios(): void {
    this.diarioService.getDiarios()
      .subscribe(diarios => {
        this.dataSource = new MatTableDataSource<Diario>(diarios)
        this.dataSource.paginator = this.paginator;  
        this.dataSource.sort = this.sort; 
      });
  }

  openDialog(diario): void {

    //let tmp: Diario = Object.assign(new Diario(), diario);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = diario;

    const dialogRef = this.dialog.open(saveDiario, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (diario == null) {
        this.getDiarios();
      } else {
        Object.assign(diario, result);
      }
    });
  }

}

@Component({
  selector: 'app-diario',
  templateUrl: './diario.nuevo.html',
  styleUrls: ['./diario.component.css']
})
export class saveDiario {

  cuentas: Cuenta[];
  diario: Diario;

  constructor(public dialogRef: MatDialogRef<saveDiario>,
    @Inject(MAT_DIALOG_DATA) data: Diario,
    private diarioService: DiarioService,
    private cuentaService: CuentaService) {
    if (data === null){
      this.diario = new Diario();
      this.diario.detalle = [];
      this.diario.detalle.push( new Diariodetalle());
      this.diario.detalle.push( new Diariodetalle());
    } else {
      this.diario = data;
    }
    this.getCuentas();
  }

  compareCuenta(o1: any, o2: any): boolean {
    return o1.idCuentaContable === o2.idCuentaContable && o1.cuentaContable === o2.cuentaContable;
  }

  saveDiario(): void {
    this.diarioService.addDiario(this.diario).subscribe();
    this.dialogRef.close(this.diario);
  }

  getCuentas(): void {
    this.cuentaService.getCuentas()
      .subscribe(cuentas => this.cuentas = cuentas);
  }

}