import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule} from "@angular/common/http"
import { ReactiveFormsModule } from '@angular/forms';
import { ConnectionService } from './Connection.service';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { SideBarComponent } from './admin-panel/side-bar/side-bar.component';
import { ShowProjectsComponent } from './admin-panel/Projects/show-projects/show-projects.component';
import { AddProjectComponent } from './admin-panel/Projects/add-project/add-project.component';
import { EditProjectComponent } from './admin-panel/Projects/edit-project/edit-project.component';
import { AppRoutingModule } from './app-routing.model';
import { EditEducationComponent } from './admin-panel/Education/edit-education/edit-education.component';
import { AddEducationComponent } from './admin-panel/Education/add-education/add-education.component';
import { ShowEducationsComponent } from './admin-panel/Education/show-educations/show-educations.component';
import { AddExperienceComponent } from './admin-panel/Experience/add-experience/add-experience.component';
import { ShowExperiencesComponent } from './admin-panel/Experience/show-experiences/show-experiences.component';
import { EditExperienceComponent } from './admin-panel/Experience/edit-experience/edit-experience.component';
import { EditFieldComponent } from './admin-panel/Field/edit-field/edit-field.component';
import { AddFieldComponent } from './admin-panel/Field/add-field/add-field.component';
import { ShowFieldsComponent } from './admin-panel/Field/show-fields/show-fields.component';
import { ShowTechnologiesComponent } from './admin-panel/Technologie/show-technologies/show-technologies.component';
import { EditTechnologieComponent } from './admin-panel/Technologie/edit-technologie/edit-technologie.component';
import { AddTechnologieComponent } from './admin-panel/Technologie/add-technologie/add-technologie.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminPanelComponent,
    SideBarComponent,
    ShowProjectsComponent,
    AddProjectComponent,
    EditProjectComponent,
    EditEducationComponent,
    AddEducationComponent,
    ShowEducationsComponent,
   
    ShowExperiencesComponent,
        AddExperienceComponent,
        EditExperienceComponent,
        EditFieldComponent,
        AddFieldComponent,
        ShowFieldsComponent,
        ShowTechnologiesComponent,
        EditTechnologieComponent,
        AddTechnologieComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,
  ],
  providers: [ConnectionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
