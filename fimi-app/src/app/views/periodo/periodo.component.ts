import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { PeriodoService } from '../../service/periodo.service';
import { Periodo } from './periodo';

@Component({
  selector: 'app-periodo',
  templateUrl: './periodo.component.html',
  styleUrls: ['./periodo.component.css']
})
export class PeriodoComponent implements OnInit {

  periodos: Periodo[];
  periodoSeleccionado: Periodo = new Periodo();

  constructor(private periodoService: PeriodoService, private dialog: MatDialog) { }

  ngOnInit() {
    this.getPeriodos();
  }

  getPeriodos(): void {
    this.periodoService.getPeriodos()
      .subscribe(periodos => this.periodos = periodos);
  }

  seleccionar(row): void {
    this.periodoSeleccionado = row;
  }
  editar(row): void {

  }
}
