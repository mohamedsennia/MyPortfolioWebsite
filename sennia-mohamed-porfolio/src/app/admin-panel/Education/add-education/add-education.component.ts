import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Education } from 'src/app/Education/Education.model';

@Component({
  selector: 'app-add-education',
  templateUrl: './add-education.component.html',
  styleUrls: ['./add-education.component.css']
})
export class AddEducationComponent implements OnInit{
  public addEducationForm:FormGroup;
  constructor(private educationService:Education,private router:Router){
  
  }
    ngOnInit(): void {
      this.addEducationForm=new FormGroup({
        Degree:new FormControl(null,[Validators.required])
      })
    }
    addField(){
     if(this.addEducationForm.valid){//console.log()
      //this.educationService.addField(new Field(null,this.addEducationForm.value["FieldName"]))
      window.alert("Field add successfully")
      this.router.navigate(["/admin-panel/educations/1"])
     }
    }
}
