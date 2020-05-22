import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeComponent } from './home.component';
import { HomeService } from '../service/home.service';
import { DeviceDetectorService, DeviceDetectorModule } from 'ngx-device-detector';
import { Agency } from 'src/app/shared/model/agency';
import { HeaderComponent } from '../components/header/header.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let service: HomeService
  let deviceService: DeviceDetectorService

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HomeComponent, HeaderComponent],
      imports: [
        DeviceDetectorModule.forRoot(),
        HttpClientTestingModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    service = TestBed.get(HomeService);
    deviceService = TestBed.get(DeviceDetectorService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call getInfos on ngInit', () => {
    spyOn(component, 'getInfos');

    component.ngOnInit();

    expect(component.getInfos).toHaveBeenCalled();
  });

  it('should get latitude, longitude and info about mobile', () => {
    spyOn(navigator.geolocation, "getCurrentPosition").and.callFake(function () {
      var position = { coords: { latitude: 32, longitude: -96 } };
      arguments[0](position);
    });
    component.getInfos();

    expect(navigator.geolocation.getCurrentPosition).toHaveBeenCalled();
    expect(component.latitude).toBeDefined();
    expect(component.longitude).toBeDefined();
  });

  it('should show or hide detail about agency', () => {
    spyOn(component, 'saveInfos');

    const agency = new Agency({ address: 'Teste', oppeningHours: '10:00', number: '(11) 11111-1111' });
    component.showDetail(agency);

    expect(agency.showDetail).toBeTruthy();
    expect(component.saveInfos).toHaveBeenCalled();

  });

  it('should save infos by agency', () => {
    const mockResponse = [
      { address: 'teste', number: '(11) 11111-1111', oppeningHours: '10:00' },
      { address: 'teste', number: '(11) 11111-1111', oppeningHours: '10:00' },
      { address: 'teste', number: '(11) 11111-1111', oppeningHours: '10:00' }
    ]
    spyOn(service, 'saveAgency').and.returnValue(of(mockResponse));

    const agency = new Agency({ address: 'Teste', oppeningHours: '10:00', number: '(11) 11111-1111' });

    component.saveInfos(agency);

    expect(service.saveAgency).toHaveBeenCalled();
  });
});
