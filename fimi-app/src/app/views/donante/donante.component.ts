import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from "@angular/material";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Donante } from './donante';
import { DonanteService } from '../../service/donante.service';
import { Pais } from '../pais/pais';
import { PaisService } from '../../service/pais.service';

@Component({
  selector: 'app-donante',
  templateUrl: './donante.component.html',
  styleUrls: ['./donante.component.css']
})
export class DonanteComponent implements OnInit {

  donantes: Donante[];

  constructor(private donanteService: DonanteService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.getDonantes();
  }

  openDialog(donante): void {

    let tmp: Donante = Object.assign(new Donante(), donante);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(saveDonante, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if ( donante == null ) {
        this.getDonantes();
      } else {
        Object.assign(donante, result);
      }
    });
  }

  getDonantes(): void {
    this.donanteService.getDonantes()
    .subscribe(donantes => this.donantes = donantes);
  }

}

@Component({
  selector: 'app-donante',
  templateUrl: './donante.nuevo.html',
  styleUrls: ['./donante.component.css']
})
export class saveDonante {

  donante: Donante;
  paises: Pais[];
  
  constructor(public dialogRef: MatDialogRef<saveDonante>,
    @Inject(MAT_DIALOG_DATA) data: Donante, 
    private donanteService: DonanteService,
    private paisService: PaisService) {
    if (data === null)
      this.donante = new Donante();
    else
      this.donante = data;
      
    this.getPais();
  }

  compareObjects(o1: any, o2: any): boolean {
    return o1.pais === o2.pais && o1.id_pais === o2.id_pais;
  }

  saveDonante(): void {
    this.donanteService.addDonante(this.donante).subscribe();
    this.dialogRef.close(this.donante);
  }

  getPais(): void {
    this.paisService.getPaises()
    .subscribe(pais => this.paises = pais);
  }

}


