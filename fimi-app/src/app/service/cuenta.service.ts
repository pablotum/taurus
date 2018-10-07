import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Cuenta } from '../views/cuenta/cuenta';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class CuentaService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getCuentas(): Observable<Cuenta[]> {
    return this.http.get<Cuenta[]>(this.host + 'cuentascontables');
  }

  addCuenta (cuenta: Cuenta): Observable<Cuenta> {
    return this.http.post<Cuenta>(this.host + 'cuentacontable', cuenta, httpOptions);
  }
}
