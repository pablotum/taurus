import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable } from 'rxjs';
import { Donante } from '../views/donante/donante';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DonanteService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getDonantes(): Observable<Donante[]> {
    return this.http.get<Donante[]>(this.host + 'donantes');
  }

  addDonante (donante: Donante): Observable<Donante> {
    return this.http.post<Donante>(this.host + 'donante', donante, httpOptions);
  }

  deleteDonante (donante: number): Observable<Donante> {
    let tipoUrl = this.host + "donante";
    const url = `${tipoUrl}/${donante}`;
    return this.http.delete<any>(url);
  }

}
