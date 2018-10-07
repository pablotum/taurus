import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Estadocivil } from '../views/contacto/estadocivil';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class EstadocivilService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getEstadosciviles(): Observable<Estadocivil[]> {
    return this.http.get<Estadocivil[]>(this.host + 'estados');
  }

  addEstadocivil (estadocivil: Estadocivil): Observable<Estadocivil> {
    return this.http.post<Estadocivil>(this.host + 'estadocivil', estadocivil, httpOptions);
  }

  deleteEstadocivil (estadocivil: number): Observable<Estadocivil> {
    let monedaUrl = this.host + "estadocivil";
    const url = `${monedaUrl}/${estadocivil}`;
    return this.http.delete<any>(url);
  }
}

