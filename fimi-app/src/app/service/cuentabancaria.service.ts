import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable } from 'rxjs';
import { Cuentabancaria } from '../views/cuentabancaria/cuentabancaria';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class CuentabancariaService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getCuentasBancarias(): Observable<Cuentabancaria[]> {
    return this.http.get<Cuentabancaria[]>(this.host + 'cuentabancarias');
  }

  addCuentaBancaria (cuentabancaria: Cuentabancaria): Observable<Cuentabancaria> {
    return this.http.post<Cuentabancaria>(this.host + 'cuentabancaria', cuentabancaria, httpOptions);
  }

  deleteCuentaBancaria (cuentabancaria: number): Observable<Cuentabancaria> {
    let monedaUrl = this.host + "cuentabancaria";
    const url = `${monedaUrl}/${cuentabancaria}`;
    return this.http.delete<any>(url);
  }
}
