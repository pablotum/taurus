import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable } from 'rxjs';
import { Diario } from '../views/diario/diario';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DiarioService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getDiarios(): Observable<Diario[]> {
    return this.http.get<Diario[]>(this.host + 'diarios');
  }

  addDiario (diario: Diario): Observable<Diario> {
    return this.http.post<Diario>(this.host + 'diario', diario, httpOptions);
  }

  deleteDiario (diario: number): Observable<Diario> {
    let monedaUrl = this.host + "diario";
    const url = `${monedaUrl}/${diario}`;
    return this.http.delete<any>(url);
  }
}
