import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Usocuenta } from '../views/usocuenta/usocuenta';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class UsocuentaService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getUso(): Observable<Usocuenta[]> {
    return this.http.get<Usocuenta[]>(this.host + 'usoscuenta');
  }
}
