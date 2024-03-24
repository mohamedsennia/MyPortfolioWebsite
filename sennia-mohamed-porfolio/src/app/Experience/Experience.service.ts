import { Injectable } from "@angular/core";
import { Experience } from "./Experience.model";
import { Observable, Subscription, map } from "rxjs";
import { ConnectionService } from "../Connection.service";

@Injectable({providedIn:"root"})
export class ExperienceService{
private experiences:Experience[]
private getExperiencesSubscription:Subscription
constructor(private connectionService:ConnectionService){
   this.experiences=null
   this.getExperiencesSubscription=connectionService.getExperiences().subscribe(param=>{
    this.experiences=param
   })
}
getExperiences():Experience[]|Observable<Experience[]>{
if(this.experiences!=null){
return this.experiences
}else{
    this.getExperiencesSubscription.unsubscribe()
    return this.connectionService.getExperiences().pipe(map(param=>{
        this.experiences=param;
        return param
    }))
}
}
getExperienceById(id:number){
    return this.connectionService.getExperienceById(id).pipe(map(param=>{
        param._startDate=new Date(param._startDate)
        param._endDate=new Date(param._endDate)
        return param
    }))
}
addExperience(experience:Experience){
   return this.connectionService.addExperience(experience).pipe(map(param=>{
        experience._experience_id=param
        this.experiences.push(experience)
    }))
}
editExperience(experience:Experience){

    return this.connectionService.addExperience(experience).pipe(map(param=>{
        this.experiences[this.experiences.findIndex(E=>E._experience_id==experience._experience_id)]=experience
        return param
    }))
}
deleteExperience(experience:Experience){
    return this.connectionService.deleteExperience(experience).pipe(map(param=>{
        this.experiences.slice(this.experiences.indexOf(experience),1)
        return this.experiences
    }))
}
}