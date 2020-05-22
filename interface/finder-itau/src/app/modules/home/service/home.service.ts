
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }

  getAgencies(lat: string, long: string): Observable<any> {
    return this.http.get(`${environment.url}/agency/${lat}/${long}`, {});
  }

  // saveAgency() {
  //   return this.http.get(`${environment.url}/agency/${lat}/${long}`, {});
  // }
}
