import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable } from 'rxjs';
import { Contacto } from '../views/contacto/contacto';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ContactoService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  getContactos(): Observable<Contacto[]> {
    return this.http.get<Contacto[]>(this.host + 'contactos');
  }

  addContacto (contacto: Contacto): Observable<Contacto> {
    return this.http.post<Contacto>(this.host + 'contacto', contacto, httpOptions);
  }

  deleteContacto (contacto: number): Observable<Contacto> {
    let tipoUrl = this.host + "contacto";
    const url = `${tipoUrl}/${contacto}`;
    return this.http.delete<any>(url);
  }
}
