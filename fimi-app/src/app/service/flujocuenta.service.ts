import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Flujocuenta } from '../views/flujocuenta/flujocuenta';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FlujocuentaService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getFlujos(): Observable<Flujocuenta[]> {
    return this.http.get<Flujocuenta[]>(this.host + 'flujoscuenta');
  }

}
