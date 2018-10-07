import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Pais } from '../pais/pais';
import { PaisService } from '../../service/pais.service';
import { Entidad } from './entidad';
import { EntidadService } from '../../service/entidad.service';

@Component({
  selector: 'app-entidad',
  templateUrl: './entidad.component.html',
  styleUrls: ['./entidad.component.css']
})
export class EntidadComponent implements OnInit {

  entidades: Entidad[];

  constructor(private entidadService: EntidadService,
    private dialog: MatDialog) { }

  ngOnInit() {
    this.getEntidads();
  }

  openDialog(entidad): void {

    let tmp: Entidad = Object.assign(new Entidad(), entidad);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(saveEntidad, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if ( entidad == null ) {
        this.getEntidads();
      } else {
        Object.assign(entidad, result);
      }
    });
  }

  getEntidads(): void {
    this.entidadService.getEntidades()
    .subscribe(entidads => this.entidades = entidads);
  }

}

@Component({
  selector: 'app-entidad',
  templateUrl: './entidad.nuevo.html',
  styleUrls: ['./entidad.component.css']
})
export class saveEntidad {

  entidad: Entidad;
  paises: Pais[];
  
  constructor(public dialogRef: MatDialogRef<saveEntidad>,
    @Inject(MAT_DIALOG_DATA) data: Entidad, 
    private entidadService: EntidadService,
    private paisService: PaisService) {
    if (data === null)
      this.entidad = new Entidad();
    else
      this.entidad = data;
      
    this.getPais();
  }

  compareObjects(o1: any, o2: any): boolean {
    return o1.pais === o2.pais && o1.id_pais === o2.id_pais;
  }

  saveEntidad(): void {
    this.entidadService.addEntidad(this.entidad).subscribe(
      entidad => this.dialogRef.close(entidad)
    );
    
  }

  getPais(): void {
    this.paisService.getPaises()
    .subscribe(pais => this.paises = pais);
  }

}
