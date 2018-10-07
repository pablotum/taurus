import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Entidad } from '../views/entidad/entidad';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class EntidadService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getEntidades(): Observable<Entidad[]> {
    return this.http.get<Entidad[]>(this.host + 'entidades');
  }

  addEntidad (entidad: Entidad): Observable<Entidad> {
    return this.http.post<Entidad>(this.host + 'entidad', entidad, httpOptions);
  }

  deleteEntidad (entidad: number): Observable<Entidad> {
    let monedaUrl = this.host + "entidad";
    const url = `${monedaUrl}/${entidad}`;
    return this.http.delete<any>(url);
  }
}
