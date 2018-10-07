import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ConvenioService } from '../../service/convenio.service';
import { Convenio } from './convenio';
import { Donante } from '../donante/donante';
import { DonanteService } from '../../service/donante.service';
import { MonedaService } from '../../service/moneda.service';
import { Moneda } from '../moneda/moneda';
import { Convenioactividad } from './convenioactividad';
import { Convenioarchivo } from './convenioarchivo';
import { Conveniorubro } from './conveniorubro';
import { RubroService } from '../../service/rubro.service';
import { Rubro } from '../rubro/rubro';
import { Conveniodesembolso } from './conveniodesembolso';
import { ConvenioarchivoService } from '../../service/convenioarchivo.service';

@Component({
  selector: 'app-convenio',
  templateUrl: './convenio.component.html',
  styleUrls: ['./convenio.component.css']
})
export class ConvenioComponent implements OnInit {

  convenios: Convenio[];
  dataSource = new MatTableDataSource<Convenio>();  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private convenioService: ConvenioService,
    private dialog: MatDialog) {
    }

  ngOnInit() {
    this.getConvenios();
  }

  openDialog(convenio): void {

    let tmp: Convenio = Object.assign(new Convenio(), convenio);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.maxHeight = "100%";
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(saveConvenio, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (convenio == null) {
        this.getConvenios();
      } else {
        Object.assign(convenio, result);
      }
    });
  }

  openActividad(convenio): void {
    let tmp: Convenio = Object.assign(new Convenio(), convenio);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(actividadConvenio, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (convenio == null) {
        this.getConvenios();
      } else {
        Object.assign(convenio, result);
      }
    });
  }

  openArchivo(convenio): void {
    let tmp: Convenio = Object.assign(new Convenio(), convenio);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(archivoConvenio, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (convenio == null) {
        this.getConvenios();
      } else {
        Object.assign(convenio, result);
      }
    });
  }

  openRubro(convenio): void {
    let tmp: Convenio = Object.assign(new Convenio(), convenio);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(rubroConvenio, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (convenio == null) {
        this.getConvenios();
      } else {
        Object.assign(convenio, result);
      }
    });
  }

  openDesembolso(convenio): void {
    let tmp: Convenio = Object.assign(new Convenio(), convenio);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(desembolsoConvenio, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (convenio == null) {
        this.getConvenios();
      } else {
        Object.assign(convenio, result);
      }
    });
  }

  getConvenios(): void {
    this.convenioService.getConvenios()
      .subscribe(convenios => { 
        this.dataSource = new MatTableDataSource<Convenio>(convenios)
        this.dataSource.paginator = this.paginator;    
      });
  }

}

@Component({
  selector: 'app-convenio',
  templateUrl: './convenio.nuevo.html',
  styleUrls: ['./convenio.component.css']
})
export class saveConvenio {

  convenio: Convenio;
  donantes: Donante[];
  monedas: Moneda[];

  constructor(public dialogRef: MatDialogRef<saveConvenio>,
    @Inject(MAT_DIALOG_DATA) data: Convenio,
    private convenioService: ConvenioService,
    private donanteService: DonanteService,
    private monedaService: MonedaService) {
    if (data === null)
      this.convenio = new Convenio();
    else
      this.convenio = data;

    this.getMonedas();
    this.getDonantes();
  }

  compareDonante(o1: any, o2: any): boolean {
    return o1.idDonante === o2.idDonante && o1.nombre === o2.nombre;
  }

  compareMoneda(o1: any, o2: any): boolean {
    return o1.idMoneda === o2.idMoneda && o1.moneda === o2.moneda;
  }

  saveConvenio(): void {
    this.convenioService.addConvenio(this.convenio).subscribe();
    this.dialogRef.close(this.convenio);
  }

  getMonedas(): void {
    this.monedaService.getMonedas()
      .subscribe(moneda => this.monedas = moneda);
  }

  getDonantes(): void {
    this.donanteService.getDonantes()
      .subscribe(donantes => this.donantes = donantes);
  }

}


@Component({
  selector: 'app-convenio',
  templateUrl: './convenio.actividad.html',
  styleUrls: ['./convenio.component.css']
})
export class actividadConvenio {

  convenio: Convenio;
  convenioActividad: Convenioactividad;

  constructor(public dialogRef: MatDialogRef<Convenio>,
    @Inject(MAT_DIALOG_DATA) data: Convenio,
    private convenioService: ConvenioService) {
    if (data === null)
      this.convenio = new Convenio();
    else
      this.convenio = data;

    this.convenioActividad = new Convenioactividad();
  }

  saveConvenio(): void {
    if (!this.convenio.actividades) {
      this.convenio.actividades = [];
    }
    this.convenio.actividades.push(this.convenioActividad);
    Object.assign(this.convenio, this.convenio);
    this.convenioService.addConvenio(this.convenio).subscribe();
  }

}


//Adjuntar achivos
@Component({
  selector: 'app-convenio',
  templateUrl: './convenio.archivo.html',
  styleUrls: ['./convenio.component.css']
})
export class archivoConvenio {

  convenio: Convenio;
  convenioArchivo: Convenioarchivo;

  constructor(public dialogRef: MatDialogRef<Convenio>,
    @Inject(MAT_DIALOG_DATA) data: Convenio,
    private convenioService: ConvenioService,
    private archivoService: ConvenioarchivoService) {
    if (data === null)
      this.convenio = new Convenio();
    else
      this.convenio = data;

    this.convenioArchivo = new Convenioarchivo();
  }

  onChange(event: EventTarget): void {
    if (!this.convenio.archivos) {
      this.convenio.archivos = [];
    }
    this.convenio.archivos.push(this.convenioArchivo);
    Object.assign(this.convenio, this.convenio);
    let formData:FormData = new FormData();
    let eventObj: MSInputMethodContext = <MSInputMethodContext> event;
        let target: HTMLInputElement = <HTMLInputElement> eventObj.target;
        let files: FileList = target.files;
    let file = files[0];
        formData.append('file', file, file.name);
    this.archivoService.addConvenioArchivo(formData).subscribe();
  }

}

//Rubros de convenio
@Component({
  selector: 'app-convenio',
  templateUrl: './convenio.rubro.html',
  styleUrls: ['./convenio.component.css']
})
export class rubroConvenio {
  rubros: Rubro[];
  convenio: Convenio;
  convenioRubro: Conveniorubro;

  constructor(public dialogRef: MatDialogRef<Convenio>,
    @Inject(MAT_DIALOG_DATA) data: Convenio,
    private convenioService: ConvenioService,
    private rubroService: RubroService) {
    if (data === null)
      this.convenio = new Convenio();
    else
      this.convenio = data;

    this.convenioRubro = new Conveniorubro();
    this.getRubros();
  }

  saveConvenio(): void {
    if (!this.convenio.rubros) {
      this.convenio.rubros = [];
    }
    this.convenio.rubros.push(this.convenioRubro);
    Object.assign(this.convenio, this.convenio);
    this.convenioService.addConvenio(this.convenio).subscribe();
  }

  getRubros(): void {
    this.rubroService.getRubros()
      .subscribe(rubros => this.rubros = rubros);
  }

}

//Desembolsos programados de convenio
@Component({
  selector: 'app-convenio',
  templateUrl: './convenio.desembolso.html',
  styleUrls: ['./convenio.component.css']
})
export class desembolsoConvenio {
  convenio: Convenio;
  convenioDesembolso: Conveniodesembolso;

  constructor(public dialogRef: MatDialogRef<Convenio>,
    @Inject(MAT_DIALOG_DATA) data: Convenio,
    private convenioService: ConvenioService) {
    if (data === null)
      this.convenio = new Convenio();
    else
      this.convenio = data;

    this.convenioDesembolso = new Conveniodesembolso();
  }

  saveConvenio(): void {
    if (!this.convenio.desembolsos) {
      this.convenio.desembolsos = [];
    }
    this.convenio.desembolsos.push(this.convenioDesembolso);
    Object.assign(this.convenio, this.convenio);
    this.convenioService.addConvenio(this.convenio).subscribe();
  }

}