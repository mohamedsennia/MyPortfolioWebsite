import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ConnectionService } from 'src/app/Connection.service';
import { FieldSerivce } from 'src/app/Field/Field.Service';
import { Field } from 'src/app/Field/Field.model';

@Component({
  selector: 'app-show-fields',
  templateUrl: './show-fields.component.html',
  styleUrls: ['./show-fields.component.css']
})
export class ShowFieldsComponent implements OnInit,OnDestroy{

  fields:Field[]
 private connectionSubsecribtions:Subscription[]
constructor( private fieldService:FieldSerivce,private connectionService:ConnectionService,private router:Router){
this.fields=[]
this.connectionSubsecribtions=[]
}

ngOnInit(): void {
 this.connectionSubsecribtions.push (  this.connectionService.getFields().subscribe(param=>{
      this.fields=param
      this.fieldService.fields=param

    }))
}
edit(id:number){
this.router.navigate(["admin-panel/fields/editField/"+id])
}
delete(field: Field) {
  if(window.confirm("Are you sure you want to delete this field")){
  this.connectionSubsecribtions.push (this.connectionService.deleteField(field).subscribe((param)=>{this.fieldService.fields.splice(this.fieldService.fields.indexOf(field));
  this.fields=this.fieldService.fields
  }))}
  }
ngOnDestroy(): void {
 for (let subscription of this.connectionSubsecribtions){subscription.unsubscribe()}
}
}
