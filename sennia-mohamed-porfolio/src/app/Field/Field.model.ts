export class Field{

    constructor(private field_id: number,private fieldName: string){}
    public get _field_id(): number {
        return this.field_id;
    }
    public set _field_id(value: number) {
        this.field_id = value;
    }
    public get _fieldName(): string {
        return this.fieldName;
    }
    public set _fieldName(value: string) {
        this.fieldName = value;
    }
}