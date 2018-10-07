import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Contacto } from './contacto';
import { ContactoService } from '../../service/contacto.service';
import { Sexo } from './sexo';
import { Estadocivil } from './estadocivil';
import { EstadocivilService } from '../../service/estadocivil.service';
import { SexoService } from '../../service/sexo.service';
import { Pais } from '../pais/pais';
import { PaisService } from '../../service/pais.service';
import { ProfesionService } from '../../service/profesion.service';
import { Profesion } from './profesion';
import { Contactotelefono } from './contactotelefono';
import { Contactocorreo } from './contactocorreo';


@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {

  contactos: Contacto[];
  dataSource = new MatTableDataSource<Contacto>();
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private contactoService: ContactoService,
    private dialog: MatDialog) { }

  ngOnInit() {
    this.getContactos();
  }

  getContactos(): void {
    this.contactoService.getContactos()
      .subscribe(contactos => {
        this.dataSource = new MatTableDataSource<Contacto>(contactos)
        this.dataSource.paginator = this.paginator;
      });
  }

  openDialog(contacto): void {
    let tmp: Contacto = Object.assign(new Contacto(), contacto);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    if (contacto)
      dialogConfig.data = tmp;
    dialogConfig.maxHeight = '500';
    dialogConfig.height = '500';
    const dialogRef = this.dialog.open(saveContacto, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (contacto == null) {
        this.getContactos();
      } else {
        Object.assign(contacto, result);
      }
    });
  }

}

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.nuevo.html',
  styleUrls: ['./contacto.component.css']
})
export class saveContacto {

  contacto: Contacto;
  sexos: Sexo[];
  estados: Estadocivil[];
  paises: Pais[];
  profesiones: Profesion[];

  constructor(public dialogRef: MatDialogRef<saveContacto>,
    @Inject(MAT_DIALOG_DATA) data: Contacto,
    private contactoService: ContactoService,
    private sexoService: SexoService,
    private estadoService: EstadocivilService,
    private paisService: PaisService,
    private profesionService: ProfesionService,
    private dialog: MatDialog) {

    this.getEstados();
    this.getSexos();
    this.getPaises();
    this.getProfesiones();
    if (data === null) {
      this.contacto = new Contacto();
      this.contacto.estado = true;
    } else {
      this.contacto = data;
    }
  }

  compareEstado(o1: any, o2: any): boolean {
    return o1.idEstadoCivil === o2.idEstadoCivil && o1.estadoCivil === o2.estadoCivil;
  }

  compareSexo(o1: any, o2: any): boolean {
    return o1.idSexo === o2.idSexo && o1.sexo === o2.sexo;
  }

  comparePais(o1: any, o2: any): boolean {
    return o1.idPais === o2.idPais && o1.pais === o2.pais;
  }

  compareProfesion(o1: any, o2: any): boolean {
    return o1.idProfesion === o2.idProfesion && o1.profesion === o2.profesion;
  }

  saveContacto(): void {
    this.contactoService.addContacto(this.contacto).subscribe(
      contacto => this.dialogRef.close(contacto)
    );
    
  }

  getSexos(): void {
    this.sexoService.getSexos()
      .subscribe(sexo => this.sexos = sexo);
  }

  getEstados(): void {
    this.estadoService.getEstadosciviles()
      .subscribe(estados => this.estados = estados);
  }

  getPaises(): void {
    this.paisService.getPaises()
      .subscribe(paises => this.paises = paises);
  }

  getProfesiones(): void {
    this.profesionService.getProfesiones()
      .subscribe(profesiones => this.profesiones = profesiones);
  }

  telefonoContacto(contacto): void {
    let tmp: Contacto = Object.assign(new Contacto(), contacto);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    if (contacto)
      dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(telefonoContacto, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        Object.assign(contacto, result);
      }
    });
  }

  correoContacto(contacto): void {
    let tmp: Contacto = Object.assign(new Contacto(), contacto);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    if (contacto)
      dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(correoContacto, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (contacto == null) {
        null;
      } else {
        Object.assign(contacto, result);
      }
    });
  }

}


@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.telefono.html',
  styleUrls: ['./contacto.component.css']
})
export class telefonoContacto {

  contacto: Contacto;
  telefono: Contactotelefono = new Contactotelefono();

  constructor(public dialogRef: MatDialogRef<saveContacto>,
    @Inject(MAT_DIALOG_DATA) data: Contacto,
    private contactoService: ContactoService) {

    this.contacto = data;
    this.telefono.estado = true;
  }


  saveContacto(): void {
    if (!this.contacto.telefonos) {
      this.contacto.telefonos = [];
    }
    this.contacto.telefonos.push(this.telefono);
    //this.dialogRef.close(this.contacto);
    this.contactoService.addContacto(this.contacto).subscribe(
      contacto => this.dialogRef.close(contacto)
    );
    
  }

}


@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.correo.html',
  styleUrls: ['./contacto.component.css']
})
export class correoContacto {

  contacto: Contacto;
  correo: Contactocorreo = new Contactocorreo();

  constructor(public dialogRef: MatDialogRef<saveContacto>,
    @Inject(MAT_DIALOG_DATA) data: Contacto,
    private contactoService: ContactoService) {

    this.contacto = data;
    this.correo.estado = true;
  }


  saveContacto(): void {
    if (!this.contacto.correos) {
      this.contacto.correos = [];
    }
    this.contacto.correos.push(this.correo);
    //this.dialogRef.close(this.contacto);
    this.contactoService.addContacto(this.contacto).subscribe(
      contacto => this.dialogRef.close(contacto)
    );  
    
  }

}
