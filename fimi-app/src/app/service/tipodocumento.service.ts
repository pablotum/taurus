import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Tipodocumento } from '../views/tipodocumento/tipodocumento';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TipodocumentoService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getTipoDocumentos(): Observable<Tipodocumento[]> {
    return this.http.get<Tipodocumento[]>(this.host + 'tipodocumentos');
  }

  addTipoDocumento (tipodocumento: Tipodocumento): Observable<Tipodocumento> {
    return this.http.post<Tipodocumento>(this.host + 'tipodocumento', tipodocumento, httpOptions);
  }

  deleteTipoDocumento (tipodocumento: number): Observable<Tipodocumento> {
    let tipoUrl = this.host + "tipodocumento";
    const url = `${tipoUrl}/${tipodocumento}`;
    return this.http.delete<any>(url);
  }
}
