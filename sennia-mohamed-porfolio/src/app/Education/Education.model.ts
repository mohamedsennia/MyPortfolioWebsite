export class Education{
    constructor(private _id: number,private _degree: string,private _school: string,private _startDate: Date,private _endDate: Date,private _description: string){}

    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
    public get endDate(): Date {
        return this._endDate;
    }
    public set endDate(value: Date) {
        this._endDate = value;
    }
    public get startDate(): Date {
        return this._startDate;
    }
    public set startDate(value: Date) {
        this._startDate = value;
    }
    public get school(): string {
        return this._school;
    }
    public set school(value: string) {
        this._school = value;
    }
    public get degree(): string {
        return this._degree;
    }
    public set degree(value: string) {
        this._degree = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
}