import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Moneda } from '../views/moneda/moneda';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MonedaService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getMonedas(): Observable<Moneda[]> {
    return this.http.get<Moneda[]>(this.host + 'monedas');
  }

  addMoneda (moneda: Moneda): Observable<Moneda> {
    return this.http.post<Moneda>(this.host + 'moneda', moneda, httpOptions);
  }

  deleteMoneda (moneda: number): Observable<Moneda> {
    let monedaUrl = this.host + "moneda";
    const url = `${monedaUrl}/${moneda}`;
    return this.http.delete<any>(url);
  }

}
