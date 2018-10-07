import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest, HttpEvent } from '@angular/common/http';
import { environment } from '../../environments/environment';

import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded;' })
};

@Injectable({
  providedIn: 'root'
})
export class ConvenioarchivoService {

  private host: string = environment.host;
  constructor(private http: HttpClient) { }

  addConvenioArchivo (convenioArchivo: FormData): Observable<HttpEvent<any>> {
    //return this.http.post<string>(this.host + 'convenioarchivo', convenioArchivo, httpOptions);
    let xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

      
    xhr.open("POST", "http://localhost:2021/api/convenioarchivo", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.setRequestHeader("Cache-Control", "no-cache");
    xhr.setRequestHeader("Access-Control-Allow-Credentials", "true");
    xhr.setRequestHeader("Access-Control-Allow-Methods", "POST");
    xhr.onload = function () {
      if (this['status'] === 200) {
          const responseText = this['responseText'];
          const files = JSON.parse(responseText);
          //todo: emit event
      } else {
        //todo: error handling
      }
    };
    xhr.send(convenioArchivo);
    return this.http.request(null);
  }

}
