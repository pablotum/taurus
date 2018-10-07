import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Sexo } from '../views/contacto/sexo';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class SexoService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getSexos(): Observable<Sexo[]> {
    return this.http.get<Sexo[]>(this.host + 'sexos');
  }

  addSexo (sexo: Sexo): Observable<Sexo> {
    return this.http.post<Sexo>(this.host + 'sexo', sexo, httpOptions);
  }

  deleteSexo (sexo: number): Observable<Sexo> {
    let monedaUrl = this.host + "sexo";
    const url = `${monedaUrl}/${sexo}`;
    return this.http.delete<any>(url);
  }
}

