import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Rubro } from '../views/rubro/rubro';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RubroService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getRubros(): Observable<Rubro[]> {
    return this.http.get<Rubro[]>(this.host + 'rubros');
  }

  addRubro (rubro: Rubro): Observable<Rubro> {
    return this.http.post<Rubro>(this.host + 'rubro', rubro, httpOptions);
  }

  deleteRubro (rubro: number): Observable<Rubro> {
    let tipoUrl = this.host + "rubro";
    const url = `${tipoUrl}/${rubro}`;
    return this.http.delete<any>(url);
  }
}
