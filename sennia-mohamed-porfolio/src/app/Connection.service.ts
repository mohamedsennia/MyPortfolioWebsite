import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, map } from "rxjs";
import { User } from "./User/User.model";
import { Injectable } from "@angular/core";
import { Field } from "./Field/Field.model";
@Injectable({providedIn:"root"})
export class ConnectionService{


    private link="http://localhost:8090/api";
    private user:User;
    private logedIn:boolean;
constructor(private httpClient:HttpClient) {this.logedIn=false; this.user=new User("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2hhbWVkc2VubmlhQGdtYWlsLmNvbSIsImlhdCI6MTcwOTY1ODc3NywiZXhwIjoxNzEwMzgwMjE3fQ.VJwarsF_zNyKK7UBJKVza_yJzGU3WFwJELpO9pYGnz4","Admin")
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
}