import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Proyecto } from '../views/proyecto/proyecto';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getProyectos(): Observable<Proyecto[]> {
    return this.http.get<Proyecto[]>(this.host + 'proyectos');
  }

  addProyecto (proyecto: Proyecto): Observable<Proyecto> {
    return this.http.post<Proyecto>(this.host + 'proyecto', proyecto, httpOptions);
  }

  deleteProyecto (proyecto: number): Observable<Proyecto> {
    let monedaUrl = this.host + "proyecto";
    const url = `${monedaUrl}/${proyecto}`;
    return this.http.delete<any>(url);
  }
}
