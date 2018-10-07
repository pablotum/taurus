import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Periodo } from '../views/periodo/periodo';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PeriodoService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getPeriodos(): Observable<Periodo[]> {
    return this.http.get<Periodo[]>(this.host + 'periodos');
  }

  addPeriodo (periodo: Periodo): Observable<Periodo> {
    return this.http.post<Periodo>(this.host + 'periodo', periodo, httpOptions);
  }

  deletePeriodo (periodo: number): Observable<Periodo> {
    let periodoUrl = this.host + "periodo";
    const url = `${periodoUrl}/${periodo}`;
    return this.http.delete<any>(url, httpOptions);
  }

}
