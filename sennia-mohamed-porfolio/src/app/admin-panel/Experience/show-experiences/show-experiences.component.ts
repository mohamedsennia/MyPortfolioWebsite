import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { Experience } from 'src/app/Experience/Experience.model';
import { ExperienceService } from 'src/app/Experience/Experience.service';

@Component({
  selector: 'app-show-experiences',
  templateUrl: './show-experiences.component.html',
  styleUrls: ['./show-experiences.component.css']
})
export class ShowExperiencesComponent implements OnInit, OnDestroy {
experiences:Experience[]
private subscreptions:Subscription[]
constructor(private experienceService:ExperienceService,private router:Router){
  this.experiences=[]
  this.subscreptions=[]
}
 
  ngOnInit(): void {
    if(this.experienceService.getExperiences() instanceof Observable){
      this.subscreptions.push((this.experienceService.getExperiences() as Observable<Experience[]>).subscribe(param=>{
        this.experiences=param
      }))
    }else{
      this.experiences=this.experienceService.getExperiences() as Experience[]
    }
  }
  edit(id:number){
    this.router.navigate(["admin-panel/experiences/editExperience/"+id])
  }
  delete(experience:Experience){
   if(window.confirm("Are you sure you want to delete this experience")){
    this.experienceService.deleteExperience(experience).subscribe(param=>{
      this.experiences.slice(this.experiences.indexOf(experience),1)

      this.experiences=param
    })
   }
  }
  ngOnDestroy(): void {
    for(let subscreption of this.subscreptions){
      subscreption.unsubscribe()
    }
  }
}
