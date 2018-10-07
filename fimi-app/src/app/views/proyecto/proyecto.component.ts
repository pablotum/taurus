import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Proyecto } from './proyecto';
import { ProyectoService } from '../../service/proyecto.service';
import { Entidad } from '../entidad/entidad';
import { Moneda } from '../moneda/moneda';
import { EntidadService } from '../../service/entidad.service';
import { MonedaService } from '../../service/moneda.service';
import { Proyectoactividad } from './proyectoactividad';
import { Proyectoarchivo } from './proyectoarchivo';
import { Rubro } from '../rubro/rubro';
import { Proyectorubro } from './proyectorubro';
import { RubroService } from '../../service/rubro.service';
import { Proyectodesembolso } from './proyectodesembolso';
import { ConvenioarchivoService } from '../../service/convenioarchivo.service';
import { Convenio } from '../convenio/convenio';
import { ConvenioService } from '../../service/convenio.service';


@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css']
})
export class ProyectoComponent implements OnInit {

  proyectos: Proyecto[];
  dataSource = new MatTableDataSource<Proyecto>();  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private proyectoService: ProyectoService,
    private dialog: MatDialog) {
    }

  ngOnInit() {
    this.getProyectos();
  }

  openDialog(proyecto): void {

    let tmp: Proyecto = Object.assign(new Proyecto(), proyecto);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.maxHeight = "100%";
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(saveProyecto, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (proyecto == null) {
        this.getProyectos();
      } else {
        Object.assign(proyecto, result);
      }
    });
  }

  openActividad(proyecto): void {
    let tmp: Proyecto = Object.assign(new Proyecto(), proyecto);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(actividadProyecto, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (proyecto == null) {
        this.getProyectos();
      } else {
        Object.assign(proyecto, result);
      }
    });
  }

  openArchivo(proyecto): void {
    let tmp: Proyecto = Object.assign(new Proyecto(), proyecto);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(archivoProyecto, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (proyecto == null) {
        this.getProyectos();
      } else {
        Object.assign(proyecto, result);
      }
    });
  }

  openRubro(proyecto): void {
    let tmp: Proyecto = Object.assign(new Proyecto(), proyecto);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(rubroProyecto, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (proyecto == null) {
        this.getProyectos();
      } else {
        Object.assign(proyecto, result);
      }
    });
  }

  openDesembolso(proyecto): void {
    let tmp: Proyecto = Object.assign(new Proyecto(), proyecto);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;
    const dialogRef = this.dialog.open(desembolsoProyecto, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (proyecto == null) {
        this.getProyectos();
      } else {
        Object.assign(proyecto, result);
      }
    });
  }

  getProyectos(): void {
    this.proyectoService.getProyectos()
      .subscribe(proyectos => { 
        this.dataSource = new MatTableDataSource<Proyecto>(proyectos)
        this.dataSource.paginator = this.paginator;    
      });
  }

}

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.nuevo.html',
  styleUrls: ['./proyecto.component.css']
})
export class saveProyecto {

  proyecto: Proyecto;
  entidades: Entidad[];
  monedas: Moneda[];
  convenios: Convenio[];

  constructor(public dialogRef: MatDialogRef<saveProyecto>,
    @Inject(MAT_DIALOG_DATA) data: Proyecto,
    private proyectoService: ProyectoService,
    private entidadService: EntidadService,
    private monedaService: MonedaService,
    private convenioService: ConvenioService) {
    if (data === null)
      this.proyecto = new Proyecto();
    else
      this.proyecto = data;

    this.getMonedas();
    this.getEntidades();
    this.getConvenios();
  }

  compareEntidad(o1: any, o2: any): boolean {
    return o1.idEntidad === o2.idEntidad && o1.nombre === o2.nombre;
  }

  compareConvenio(o1: any, o2: any): boolean {
    return o1.idConvenio === o2.idConvenio && o1.nombre === o2.nombre;
  }

  compareMoneda(o1: any, o2: any): boolean {
    return o1.idMoneda === o2.idMoneda && o1.moneda === o2.moneda;
  }

  saveProyecto(): void {
    this.proyectoService.addProyecto(this.proyecto).subscribe();
    this.dialogRef.close(this.proyecto);
  }

  getConvenios(): void {
    this.convenioService.getConvenios()
      .subscribe(convenios => this.convenios = convenios);
  }

  getMonedas(): void {
    this.monedaService.getMonedas()
      .subscribe(moneda => this.monedas = moneda);
  }

  getEntidades(): void {
    this.entidadService.getEntidades()
      .subscribe(entidades => this.entidades = entidades);
  }

}


@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.actividad.html',
  styleUrls: ['./proyecto.component.css']
})
export class actividadProyecto {

  proyecto: Proyecto;
  proyectoActividad: Proyectoactividad;

  constructor(public dialogRef: MatDialogRef<Proyecto>,
    @Inject(MAT_DIALOG_DATA) data: Proyecto,
    private proyectoService: ProyectoService) {
    if (data === null)
      this.proyecto = new Proyecto();
    else
      this.proyecto = data;

    this.proyectoActividad = new Proyectoactividad();
  }

  saveProyecto(): void {
    if (!this.proyecto.actividades) {
      this.proyecto.actividades = [];
    }
    this.proyecto.actividades.push(this.proyectoActividad);
    Object.assign(this.proyecto, this.proyecto);
    this.proyectoService.addProyecto(this.proyecto).subscribe();
  }

}


//Adjuntar achivos
@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.archivo.html',
  styleUrls: ['./proyecto.component.css']
})
export class archivoProyecto {

  proyecto: Proyecto;
  proyectoArchivo: Proyectoarchivo;

  constructor(public dialogRef: MatDialogRef<Proyecto>,
    @Inject(MAT_DIALOG_DATA) data: Proyecto,
    private proyectoService: ProyectoService,
    private archivoService: ConvenioarchivoService) {
    if (data === null)
      this.proyecto = new Proyecto();
    else
      this.proyecto = data;

    this.proyectoArchivo = new Proyectoarchivo();
  }

  onChange(event: EventTarget): void {
    if (!this.proyecto.archivos) {
      this.proyecto.archivos = [];
    }
    this.proyecto.archivos.push(this.proyectoArchivo);
    Object.assign(this.proyecto, this.proyecto);
    let formData:FormData = new FormData();
    let eventObj: MSInputMethodContext = <MSInputMethodContext> event;
        let target: HTMLInputElement = <HTMLInputElement> eventObj.target;
        let files: FileList = target.files;
    let file = files[0];
        formData.append('file', file, file.name);
    //this.archivoService.addProyectoArchivo(formData).subscribe();
  }

}

//Rubros de proyecto
@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.rubro.html',
  styleUrls: ['./proyecto.component.css']
})
export class rubroProyecto {
  rubros: Rubro[];
  proyecto: Proyecto;
  proyectoRubro: Proyectorubro;

  constructor(public dialogRef: MatDialogRef<Proyecto>,
    @Inject(MAT_DIALOG_DATA) data: Proyecto,
    private proyectoService: ProyectoService,
    private rubroService: RubroService) {
    if (data === null)
      this.proyecto = new Proyecto();
    else
      this.proyecto = data;

    this.proyectoRubro = new Proyectorubro();
    this.getRubros();
  }

  saveProyecto(): void {
    if (!this.proyecto.rubros) {
      this.proyecto.rubros = [];
    }
    this.proyecto.rubros.push(this.proyectoRubro);
    Object.assign(this.proyecto, this.proyecto);
    this.proyectoService.addProyecto(this.proyecto).subscribe();
  }

  getRubros(): void {
    this.rubroService.getRubros()
      .subscribe(rubros => this.rubros = rubros);
  }

}

//Desembolsos programados de proyecto
@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.desembolso.html',
  styleUrls: ['./proyecto.component.css']
})
export class desembolsoProyecto {
  proyecto: Proyecto;
  proyectoDesembolso: Proyectodesembolso;

  constructor(public dialogRef: MatDialogRef<Proyecto>,
    @Inject(MAT_DIALOG_DATA) data: Proyecto,
    private proyectoService: ProyectoService) {
    if (data === null)
      this.proyecto = new Proyecto();
    else
      this.proyecto = data;

    this.proyectoDesembolso = new Proyectodesembolso();
  }

  saveProyecto(): void {
    if (!this.proyecto.desembolsos) {
      this.proyecto.desembolsos = [];
    }
    this.proyecto.desembolsos.push(this.proyectoDesembolso);
    Object.assign(this.proyecto, this.proyecto);
    this.proyectoService.addProyecto(this.proyecto).subscribe();
  }

}