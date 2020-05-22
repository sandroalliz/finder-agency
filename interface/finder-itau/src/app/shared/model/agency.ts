export class Agency {
    public address: string;
    public openingHours: string;
    public number: string;
    public showDetail: boolean;

    constructor(res) {
        this.address = res.address;
        this.openingHours = res.openingHours;
        this.number = res.number;
        this.showDetail = false;
    }


}