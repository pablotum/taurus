import { Component, OnInit } from '@angular/core';
import { Convenioactividad } from '../convenio/convenioactividad';
import { ActividadService } from '../../service/actividad.service';

@Component({
  selector: 'app-actividad',
  templateUrl: './actividad.component.html',
  styleUrls: ['./actividad.component.css']
})
export class ActividadComponent implements OnInit {

  actividades: Convenioactividad[];

  constructor(private actividadService: ActividadService) { }

  ngOnInit() {
    this.getActividades();
  }

  getActividades(): void {
    this.actividadService.getActividades()
    .subscribe(actividades => this.actividades = actividades);
  }

}
