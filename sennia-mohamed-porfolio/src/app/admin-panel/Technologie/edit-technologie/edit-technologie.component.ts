import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ConnectionService } from 'src/app/Connection.service';
import { Field } from 'src/app/Field/Field.model';
import { Technologie } from 'src/app/Technologie/Technologie.model';

@Component({
  selector: 'app-edit-technologie',
  templateUrl: './edit-technologie.component.html',
  styleUrls: ['./edit-technologie.component.css']
})
export class EditTechnologieComponent {
  public editTechForm:FormGroup;
    public technologie:Technologie
  constructor(private connectionService:ConnectionService,private activatedRoute:ActivatedRoute,private router:Router){
  this.technologie=new Technologie(0,"","")
  }
    ngOnInit(): void {
      this.editTechForm=new FormGroup({
        TechName:new FormControl(null,[Validators.required]),
        TechIcon:new FormControl(null,[Validators.required])
        
      })
      this.activatedRoute.params.subscribe(params=>{
      this.connectionService.getTechnologieById(+params["id"]).subscribe(param=>{
          this.technologie=param
          
          this.editTechForm.patchValue({TechName:this.technologie._name,
            TechIcon:this.technologie._icon
          })
        })
      })
    }
    editTechnologie(){
    if(this.editTechForm.valid){//console.log()
      this.technologie._name=this.editTechForm.value['TechName']
    this.technologie._icon=this.editTechForm.value['TechIcon']
 
      this.connectionService.addTechnologie(this.technologie).subscribe((param)=>{
        window.alert("Field edited successfully")
        this.router.navigate(["/admin-panel/technologies/1"])

      })     }//fa-brands fa-react fa-2xl
    }
}
