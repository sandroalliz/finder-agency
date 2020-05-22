import { Component, OnInit } from '@angular/core';
import { HomeService } from '../service/home.service';
import { Agency } from 'src/app/shared/model/agency';
import { DeviceDetectorService } from 'ngx-device-detector';
import { DataUser } from 'src/app/shared/model/dataUser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private service: HomeService,
    private deviceService: DeviceDetectorService) { }

  latitude;
  longitude;
  device;
  browser;

  agencies = [];

  ngOnInit() {
    this.getInfos();
  }
  getDevice() {
    throw new Error("Method not implemented.");
  }

  getAgencies(lat, longi) {
    this.service.getAgencies(lat, longi)
      .subscribe(
        result => {
          this.agencies = result.map(res => new Agency(res));
        },
        error => {
          setTimeout(() => {
            console.log(error);
          }, 1000);
        }
      );
  }

  getInfos(): void {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.longitude;
        this.longitude = position.coords.latitude;
        this.getAgencies(this.latitude, this.longitude);
      });
    } else {
      console.log("No support for geolocation")
    }
    this.device = this.deviceService.getDeviceInfo().os;
    this.browser = this.deviceService.getDeviceInfo().browser;
  }

  showDetail(agency: Agency) {
    agency.showDetail = !agency.showDetail;

    if (agency.showDetail) this.saveInfos(agency);
  }


  saveInfos(agency: Agency) {
    const data = new DataUser(this.latitude, this.longitude, this.device, this.browser, agency.number);

    this.service.saveAgency(data)
      .subscribe(
        result => {
          alert('Dados salvos com sucesso!');
        },
        error => {
          setTimeout(() => {
            console.log(error);
          }, 1000);
        }
      );
  }


}
