import { Injectable } from "@angular/core";
import { ConnectionService } from "../Connection.service";
import { Field } from "./Field.model";
@Injectable({providedIn:"root"})
export class FieldSerivce{
  
     fields:Field[]
constructor(private connectionService:ConnectionService){
    this.fields=[]
   


}
addField(field:Field){
    this.connectionService.addField(field).subscribe((param)=>{
       

    })

}

}