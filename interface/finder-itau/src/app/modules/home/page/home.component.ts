import { Component, OnInit } from '@angular/core';
import { HomeService } from '../service/home.service';
import { Agency } from 'src/app/shared/model/agency';
import { DeviceDetectorService } from 'ngx-device-detector';

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

    console.info(this.deviceService.getDeviceInfo());
    this.device = this.deviceService.getDeviceInfo().device;
    this.browser = this.deviceService.getDeviceInfo().browser;

  }


}
