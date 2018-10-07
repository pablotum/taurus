import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable } from 'rxjs';
import { Convenioactividad } from '../views/convenio/convenioactividad';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ActividadService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getActividades(): Observable<Convenioactividad[]> {
    return this.http.get<Convenioactividad[]>(this.host + 'actividades');
  }

}
