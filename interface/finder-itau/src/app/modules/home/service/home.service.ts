
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DataUser } from 'src/app/shared/model/dataUser';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }

  getAgencies(lat: string, long: string): Observable<any> {
    return this.http.get(`${environment.url}/agency/${lat}/${long}`, {});
  }

  saveAgency(data: DataUser): Observable<any> {
    return this.http.post(`${environment.url}/agency`, data);
  }
}
