import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Profesion } from '../views/contacto/profesion';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProfesionService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getProfesiones(): Observable<Profesion[]> {
    return this.http.get<Profesion[]>(this.host + 'profesiones');
  }

  addProfesion (profesion: Profesion): Observable<Profesion> {
    return this.http.post<Profesion>(this.host + 'profesion', profesion, httpOptions);
  }

  deleteProfesion (profesion: number): Observable<Profesion> {
    let monedaUrl = this.host + "profesion";
    const url = `${monedaUrl}/${profesion}`;
    return this.http.delete<any>(url);
  }
}

