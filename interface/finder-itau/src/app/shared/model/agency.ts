export class Agency {
    public address: string;
    public oppeningHours: string;
    public number: string;
    public showDetail: boolean;

    constructor(res) {
        this.address = res.address;
        this.oppeningHours = res.oppeningHours;
        this.number = res.number;
        this.showDetail = false;
    }


}