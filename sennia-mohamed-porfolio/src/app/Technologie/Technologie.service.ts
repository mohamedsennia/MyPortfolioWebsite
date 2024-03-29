import { Injectable } from "@angular/core";
import { ConnectionService } from "../Connection.service";
import { Technologie } from "./Technologie.model";
import { Observable, Subscription, map } from "rxjs";

@Injectable({providedIn:"root"})
export class TechnologieService{
    private technologies:Technologie[]
  private  getTechs:Subscription
constructor(private connectionService:ConnectionService){
this.technologies=null
    this.getTechs=this.connectionService.getTechnologies().subscribe((param)=>{
    this.technologies=param;console.log('a')
})

}

getTechnologies():Technologie[] | Observable<any []>{
if(this.technologies!=null){
    return this.technologies
}

this.getTechs.unsubscribe()
return this.connectionService.getTechnologies().pipe(map((param)=>
{
  
    this.technologies=param
    return param
}))
}
deleteTechnologie(technologie:Technologie){
  return  this.connectionService.deleteTechnologie(technologie).pipe(map((param)=>{
        
        this.technologies.splice(this.technologies.indexOf(technologie),1)
        return this.technologies
      }))

}
getTechnologieById(id:number){console.log(this.technologies)
 return this.connectionService.getTechnologieById(id);   
}
addTechnologie(technologie:Technologie){
    
return this.connectionService.addTechnologie(technologie).pipe(map((param)=>{
    technologie.id=param
    this.technologies.push(technologie)
   
})).subscribe();
        
}
editTechnologie(technologie:Technologie){
    
    return this.connectionService.addTechnologie(technologie).pipe(map((param)=>{
       
        this.technologies[this.technologies.findIndex(tech=> tech.id==technologie.id)]=technologie
       
       
    })).subscribe();
            
    }
}