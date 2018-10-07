import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable, of } from 'rxjs';
import { Banco } from '../views/banco/banco';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class BancoService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getBancos(): Observable<Banco[]> {
    return this.http.get<Banco[]>(this.host + 'bancos');
  }

  addBanco (banco: Banco): Observable<Banco> {
    return this.http.post<Banco>(this.host + 'banco', banco, httpOptions);
  }

  deleteBanco (banco: number): Observable<Banco> {
    let monedaUrl = this.host + "banco";
    const url = `${monedaUrl}/${banco}`;
    return this.http.delete<any>(url);
  }
}

