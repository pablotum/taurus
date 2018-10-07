import { Component, Inject, OnInit } from '@angular/core';
import { BancoService } from '../../service/banco.service';
import { MatDialog, MatDialogConfig } from '@angular/material';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Banco } from './banco';
import { PaisService } from '../../service/pais.service';
import { Pais } from '../pais/pais';

@Component({
  selector: 'app-banco',
  templateUrl: './banco.component.html',
  styleUrls: ['./banco.component.css']
})
export class BancoComponent implements OnInit {

  bancos: Banco[];
  
  constructor(private bancoService: BancoService, 
              private dialog: MatDialog) { }

  ngOnInit() {
    this.getBancos();
  }

  openDialog(banco): void {

    let tmp: Banco = Object.assign(new Banco(), banco);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = tmp;

    const dialogRef = this.dialog.open(saveBanco, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if ( banco == null ) {
        this.getBancos();
      } else {
        Object.assign(banco, result);
      }
    });
  }

  getBancos(): void {
    this.bancoService.getBancos()
    .subscribe(bancos => this.bancos = bancos);
  }

}

@Component({
  selector: 'app-banco',
  templateUrl: './banco.nuevo.html',
  styleUrls: ['./banco.component.css']
})
export class saveBanco {

  banco: Banco;
  paises: Pais[];
  
  constructor(public dialogRef: MatDialogRef<saveBanco>,
    @Inject(MAT_DIALOG_DATA) data: Banco, 
    private bancoService: BancoService,
    private paisService: PaisService) {
    if (data === null)
      this.banco = new Banco();
    else
      this.banco = data;
      
    this.getPaises();
  }

  compareObjects(o1: any, o2: any): boolean {
    return o1.pais === o2.pais && o1.id_pais === o2.id_pais;
  }


  saveBanco(): void {
    this.bancoService.addBanco(this.banco).subscribe();
    this.dialogRef.close(this.banco);
  }

  getPaises(): void {
    this.paisService.getPaises()
    .subscribe(paises => this.paises = paises);
  }

}
