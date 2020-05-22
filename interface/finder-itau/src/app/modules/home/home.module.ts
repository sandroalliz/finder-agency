import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './page/home.component';
import { HomeService } from './service/home.service';
import { HeaderComponent } from './components/header/header.component';
import { DeviceDetectorModule } from 'ngx-device-detector';



@NgModule({
  declarations: [HomeComponent, HeaderComponent],
  imports: [
    CommonModule,
    DeviceDetectorModule.forRoot()
  ],
  providers: [
    HomeService,
    Navigator
  ]
})
export class HomeModule { }
