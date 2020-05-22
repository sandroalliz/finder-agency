import { Component, OnInit } from '@angular/core';
import { HomeService } from '../service/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private service: HomeService) { }

  latitude;
  longitude;

  agencies = [];

  ngOnInit() {
    this.getLocation();
  }

  getAgencies(lat, longi) {
    this.service.getAgencies(lat, longi)
      .subscribe(
        result => {
          this.agencies = result;
        },
        error => {
          setTimeout(() => {
            console.log(error);
          }, 1000);
        }
      );
  }

  getLocation(): void {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.longitude;
        this.longitude = position.coords.latitude;
        this.getAgencies(this.latitude, this.longitude);
      });
    } else {
      console.log("No support for geolocation")
    }
  }


}
