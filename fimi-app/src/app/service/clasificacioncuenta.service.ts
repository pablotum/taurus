import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable, of } from 'rxjs';
import { Clasificacioncuenta } from '../views/clasificacioncuenta/clasificacioncuenta';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ClasificacioncuentaService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getClasificacion(): Observable<Clasificacioncuenta[]> {
    return this.http.get<Clasificacioncuenta[]>(this.host + 'clasificacioncuentas');
  }

}
