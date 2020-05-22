export class DataUser {
    public latitude: string;
    public longitude: string;
    public device: string;
    public browser: string;
    public agency: string;

    constructor(latitude, longitude, device, browser, agency) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.device = device;
        this.browser = browser;
        this.agency = agency;
    }
}