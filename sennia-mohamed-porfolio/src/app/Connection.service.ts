import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, map } from "rxjs";
import { User } from "./User/User.model";
import { Injectable } from "@angular/core";
import { Field } from "./Field/Field.model";
import { Technologie } from "./Technologie/Technologie.model";
import { Education } from "./Education/Education.model";
import { Experience } from "./Experience/Experience.model";
@Injectable({providedIn:"root"})
export class ConnectionService{


    private link="http://localhost:8090/api";
    private user:User;
    private logedIn:boolean;
constructor(private httpClient:HttpClient) {this.logedIn=false; this.user=new User("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2hhbWVkc2VubmlhQGdtYWlsLmNvbSIsImlhdCI6MTcxMTI5OTMzNywiZXhwIjoxNzEyMDIwNzc3fQ.B4cRrUqE7IFhe3pvuGnq8ULc20KSHRXcFAKRuqKUytY","Admin")
}
logIn(userEmail:string,password:string) :Observable<boolean>{
    return this.httpClient.post<User>(this.link+"/auth/logIn",{
        "userEmail":userEmail,
        "password":password
    },{headers:{}}).pipe(map(
        (response)=>{
            this.user=new User(response.token,response.role)
            this.logedIn=true;console.log(response)
        return true}
    ))
}
isLoged(){
    return this.logedIn
}
isAdmin(){
    if(this.user.role=="Admin"){return true}
    return false;
}
getFields() {
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.get<any[]>(this.link+"/Field/getFields",{headers:headers_object}).pipe(map(param=>{
        let fields=[]
        for( let field of param){
           fields.push(new Field(field.field_id,field.fieldName))
        } return fields
    }))
}
addField(field: Field) {
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
  //  


   return this.httpClient.post(this.link+"/Field/addField",field,{headers:headers_object})
}
getFieldById(id: number) {
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token)
    return this.httpClient.get<any>(this.link+"/Field/getField/"+id, {headers:headers_object}).pipe(map(param=>{ return new Field(param.field_id,param.fieldName)}))
}
deleteField(field:Field){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token)
    return this.httpClient.delete(this.link+"/Field/deleteField",{headers:headers_object,body:field})
}
getTechnologies(){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.get<any[]>(this.link+"/Technologies/getTechnologies",{headers:headers_object}).pipe(map(param=>{
        let Techs=[]
        for(let tech of param){
            Techs.push(new Technologie(tech.id_technologie,tech.name,tech.icon))
        }return Techs
    }))
}
addTechnologie(technologie:Technologie){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.post<number>(this.link+"/Technologies/addTechnologie",technologie,{headers:headers_object})
}
getTechnologieById(id: number) {
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token)
    return this.httpClient.get<any>(this.link+"/Technologies/getTechnologie/"+id, {headers:headers_object}).pipe(map(param=>{ return new Technologie(param.id_technologie,param.name,param.icon)}))
}
deleteTechnologie(technologie:Technologie){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token)
    return this.httpClient.delete<Technologie[]>(this.link+"/Technologies/deleteTechnologie",{headers:headers_object,body:technologie})
}
getEducations():Observable<Education[]>{
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.get<any[]>(this.link+"/Education/getEducations",{headers:headers_object}).pipe(map(param=>{
        let educations:Education[]=[];
        for(let E of param){
            educations.push(new Education(E.education_id,E.degree,E.school,new Date(E.startDate),new Date(E.endDate),E.description));
        }
    return educations;
    }))
}
addEducation(education:Education){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.post<number>(this.link+"/Education/addEducation",education,{headers:headers_object})    
}
getEducationById(id:number){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.get<any>(this.link+"/Education/getEducation/"+id,{headers:headers_object}).pipe(map(param=>{
        
        return   new Education(param.education_id,param.degree,param.school,param.startDate,param.endDate,param.description)
        
    }))
}
deleteEducation(education:Education){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    console.log(education)
    return this.httpClient.delete<Education[]>(this.link+"/Education/deleteEducation",{headers:headers_object,body:education})
}
getExperiences():Observable<Experience[]>{
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.get<any[]>(this.link+"/Experience/getExperiences",{headers:headers_object}).pipe(map(param=>{
        let experiences:Experience[]=[];
        for (let E of param){
            experiences.push(new Experience(E.experience_id,E.role,E.company,new Date(E.startDate),new Date(E.endDate),E.description,E.projects))
        }
        return experiences
    }))
}
addExperience(experience:Experience){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.post<number>(this.link+"/Experience/addExperience",experience,{headers:headers_object})
}
getExperienceById(id:number){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    return this.httpClient.get<any>(this.link+"/Experience/getExperience/"+id,{headers:headers_object}).pipe(map(param=>{
        console.log(param)
        return new Experience(param.experience_id,param.role,param.company,new Date(param.startDate),new Date(param.endDate),param.description,param.projects)
    }))
}
deleteExperience(experience:Experience){
    var headers_object = new HttpHeaders().set('Content-Type', 'application/json')
    .set('Authorization', `Bearer `+this.user.token);
    console.log(experience)
  return  this.httpClient.delete(this.link+"/Experience/deleteExperience",{headers:headers_object,body:experience})
}
}