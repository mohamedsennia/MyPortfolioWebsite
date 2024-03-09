import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ConnectionService } from 'src/app/Connection.service';
import { FieldSerivce } from 'src/app/Field/Field.Service';

import { Technologie } from 'src/app/Technologie/Technologie.model';

@Component({
  selector: 'app-show-technologies',
  templateUrl: './show-technologies.component.html',
  styleUrls: ['./show-technologies.component.css']
})
export class ShowTechnologiesComponent implements OnInit,OnDestroy{

  technologies:Technologie[]
 private connectionSubsecribtions:Subscription[]
constructor(private connectionService:ConnectionService,private router:Router){
this.technologies=[]
this.connectionSubsecribtions=[]
}

ngOnInit(): void {
 this.connectionSubsecribtions.push (  this.connectionService.getTechnologies().subscribe(param=>{
      this.technologies=param
      console.log(param)
     // this.fieldService.fields=param

    }))
}
edit(id:number){
this.router.navigate(["admin-panel/technologies/editTechnologie/"+id])
}
delete(technologie: Technologie) {
  if(window.confirm("Are you sure you want to delete this field")){
  this.connectionSubsecribtions.push (this.connectionService.deleteTechnologie(technologie).subscribe((param)=>{
    this.technologies=param;
  }))}
  }
ngOnDestroy(): void {
 for (let subscription of this.connectionSubsecribtions){subscription.unsubscribe()}
}

}
