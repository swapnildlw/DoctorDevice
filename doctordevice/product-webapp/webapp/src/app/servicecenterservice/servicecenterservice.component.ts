import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
//import { serviceform } from '../model/servicecenter.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicecenterComponent implements OnInit{
  //constructor() { }
  private url:string='';
  constructor(private httpClient: HttpClient) { this.url ='http://localhost:3000/servicereg'}
  ngOnInit(): void {
    
  }
  
  getData(id:number):Observable<any>{
    return this.httpClient.get<Array<any>>(this.url+"servicecenters/"+id);
  }
  //getOne(id: string){
    //return this.httpClient.get(`http://localhost:3000/servicereg/${id}`)
  //}

  //patch(data: serviceform, id: string){
    //return this.httpClient.patch(`http://localhost:3000/servicereg/${id}`, data)
  //}

  //post(data: serviceform){
    //return this.httpClient.post('http://localhost:3000/servicereg', data)
  //}
  registerservice(name:any){
    return this.httpClient.post(this.url+"register",name,{responseType:'text'});
  }

  //delete(id: string){
    //return this.httpClient.delete(`http://localhost:3000/servicereg/${id}`)
  //}
}

