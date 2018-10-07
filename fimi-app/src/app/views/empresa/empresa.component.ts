import { Component, OnInit } from '@angular/core';
import { Empresa } from './empresa';
import { Pais } from '../pais/pais';
import { PaisService } from '../../service/pais.service';
import { Tipoempresa } from '../tipoempresa/tipoempresa';
import { TipoempresaService } from '../../service/tipoempresa.service';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {

  empresas: Empresa[] = [];
  paises: Pais[];
  tiposEmpresa: Tipoempresa[];

  constructor(
    private paisService: PaisService,
    private tipoempresaService: TipoempresaService
  ) {
    let tmp: Empresa = {
      id_empresa: 1,
      codigo: '001',
      nombre: 'FIMI',
      razon: 'FIMI',
      nit: '123',
      estado: true,
      direccion: 'Ciudad de Guatemala, Guatemala',
      colonia: '',
      ciudad: '',
      pais: { idPais: 1, pais: 'Guatemala', codigo:'gt'},
      tipoEmpresa: { idTipoEmpresa: 1, tipoEmpresa: 'Juridica'}
    };
    this.empresas.push(tmp);
  }

  ngOnInit() {
    this.getPais();
    this.getTiposEmpresa();
  }

  getPais(): void {
    this.paisService.getPaises()
      .subscribe(paises => this.paises = paises);
  }

  getTiposEmpresa(): void {
    this.tipoempresaService.getTipoEmpresa()
      .subscribe(tiposEmpresa => this.tiposEmpresa = tiposEmpresa)
  }

}
