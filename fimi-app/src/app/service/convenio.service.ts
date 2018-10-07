import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable } from 'rxjs';
import { Convenio } from '../views/convenio/convenio';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class ConvenioService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getConvenios(): Observable<Convenio[]> {
    return this.http.get<Convenio[]>(this.host + 'convenios');
  }

  addConvenio (convenio: Convenio): Observable<Convenio> {
    return this.http.post<Convenio>(this.host + 'convenio', convenio, httpOptions);
  }

  deleteConvenio (convenio: number): Observable<Convenio> {
    let tipoUrl = this.host + "convenio";
    const url = `${tipoUrl}/${convenio}`;
    return this.http.delete<any>(url);
  }
}
