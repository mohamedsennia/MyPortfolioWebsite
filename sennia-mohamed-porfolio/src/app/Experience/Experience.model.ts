import { Project } from "../Project/Project.model";

export class Experience{

    constructor(private _id: string,private _role: string,private _company: string,private _startDate: Date,private _endDate: Date,private _description: string,private _projects: Project[]){}
    public get id(): string {
        return this._id;
    }
    public set id(value: string) {
        this._id = value;
    }
    public get role(): string {
        return this._role;
    }
    public set role(value: string) {
        this._role = value;
    }
    public get company(): string {
        return this._company;
    }
    public set company(value: string) {
        this._company = value;
    }
    public get startDate(): Date {
        return this._startDate;
    }
    public set startDate(value: Date) {
        this._startDate = value;
    }
    public get endDate(): Date {
        return this._endDate;
    }
    public set endDate(value: Date) {
        this._endDate = value;
    }
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
    public get projects(): Project[] {
        return this._projects;
    }
    public set projects(value: Project[]) {
        this._projects = value;
    }
}