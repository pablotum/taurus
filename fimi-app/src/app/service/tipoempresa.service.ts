import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { Tipoempresa } from '../views/tipoempresa/tipoempresa';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TipoempresaService {

  constructor(private http: HttpClient) { }

  getTipoEmpresa(): Observable<Tipoempresa[]> {
    return this.http.get<Tipoempresa[]>('http://localhost:2021/api/tiposempresa');
  }
}
