import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Puesto } from '../views/puesto/puesto';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PuestoService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getPuestos(): Observable<Puesto[]> {
    return this.http.get<Puesto[]>(this.host + 'puestos');
  }

  addPuesto (puesto: Puesto): Observable<Puesto> {
    return this.http.post<Puesto>(this.host + 'puesto', puesto, httpOptions);
  }

  deletePuesto (puesto: number): Observable<Puesto> {
    let monedaUrl = this.host + "puesto";
    const url = `${monedaUrl}/${puesto}`;
    return this.http.delete<any>(url);
  }
}
