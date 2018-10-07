import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Puesto } from './puesto';
import { PuestoService } from '../../service/puesto.service';

@Component({
  selector: 'app-puesto',
  templateUrl: './puesto.component.html',
  styleUrls: ['./puesto.component.css']
})
export class PuestoComponent implements OnInit {

  puestos: Puesto[];
  
  constructor(private puestoService: PuestoService, 
              private dialog: MatDialog) { }

  ngOnInit() {
    this.getPuestos();
  }

  openDialog(puesto): void {

    let tmp: Puesto = Object.assign(new Puesto(), puesto);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(savePuesto, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if ( puesto == null ) {
        this.getPuestos();
      } else {
        Object.assign(puesto, result);
      }
    });
  }

  getPuestos(): void {
    this.puestoService.getPuestos()
    .subscribe(puestos => this.puestos = puestos);
  }

}

@Component({
  selector: 'app-puesto',
  templateUrl: './puesto.nuevo.html',
  styleUrls: ['./puesto.component.css']
})
export class savePuesto {

  puesto: Puesto;
  
  constructor(public dialogRef: MatDialogRef<savePuesto>,
    @Inject(MAT_DIALOG_DATA) data: Puesto, 
    private puestoService: PuestoService) {
    if (data === null)
      this.puesto = new Puesto();
    else
      this.puesto = data;

  }

  compareObjects(o1: any, o2: any): boolean {
    return o1.idPuesto === o2.idPuesto && o1.puesto === o2.puesto;
  }


  savePuesto(): void {
    this.puestoService.addPuesto(this.puesto).subscribe();
    this.dialogRef.close(this.puesto);
  }


}
