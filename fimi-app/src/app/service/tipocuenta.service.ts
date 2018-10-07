import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable } from 'rxjs';
import { Tipocuenta } from '../views/tipocuenta/tipocuenta';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TipocuentaService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getTipoCuentas(): Observable<Tipocuenta[]> {
    return this.http.get<Tipocuenta[]>(this.host + 'tipocuentas');
  }

  addTipoCuenta (tipocuenta: Tipocuenta): Observable<Tipocuenta> {
    return this.http.post<Tipocuenta>(this.host + 'tipocuenta', tipocuenta, httpOptions);
  }

  deleteMoneda (tipocuenta: number): Observable<Tipocuenta> {
    let monedaUrl = this.host + "tipocuenta";
    const url = `${monedaUrl}/${tipocuenta}`;
    return this.http.delete<any>(url);
  }
}
