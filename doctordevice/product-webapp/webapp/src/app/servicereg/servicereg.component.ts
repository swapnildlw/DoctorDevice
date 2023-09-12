import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ServicecenterComponent } from '../servicecenterservice/servicecenterservice.component';
//import { service, serviceform } from '../model/servicecenter.component';
import { catchError } from 'rxjs/internal/operators/catchError';
import { throwError } from 'rxjs/internal/observable/throwError';
import {MatSnackBar} from '@angular/material/snack-bar';

export class service
{
  name: string = '';
  email: string = '';
  password: string = '';
  zip:string = '';
  address:string = '';
}
@Component({
  selector: 'app-servicereg',
  templateUrl: './servicereg.component.html',
  styleUrls: ['./servicereg.component.css']
})

export class ServiceregComponent implements OnInit{
  
  
  errorMsg: string | undefined;
  created: boolean | undefined;
  snackBar: any;
  currservice: service=new service;


  constructor(
    private servicecentercomponent: ServicecenterComponent,private _snackBar: MatSnackBar
    
  ) { }
  ngOnInit(): void {
    console.log(this.currservice);
  }
  Submit() {
    console.log(this.currservice);
    const formData = new FormData();
     // formData.append('profilePicture', this.currUser.pfp);
      //formData.append('username', this.currUser.username);
      formData.append('name', this.currservice.name);
      formData.append('email', this.currservice.email);
      formData.append('password', this.currservice.password);
      formData.append('zip', this.currservice.zip);
      formData.append('address', this.currservice.address);
      //formData.append('contact', this.currUser.contact!.toString());
     // formData.append('age', this.currUser.age!.toString());
      //formData.append('gender', this.currUser.gender);
      //formData.append('walletBalance', this.currUser.walletBalance.toString());
      //formData.append('userType', this.currUser.userType);
      console.log(formData);



/*createRestaurant(values: serviceform){
  this.servicecentercomponent.post(values)
  .pipe(
    catchError((error: { message: any; }) => {
      console.error(error.message)
      this.errorMsg = 'An error has occurred. Try again later.'

      return throwError(error.message)
    })
  ).subscribe(() => {
      this.created = true
      this.openSnackBar()
    })
  
}


openSnackBar(){
  this.snackBar.open('serviceCenter created successfully!', 'x', {
    duration: 4000
  })
}
closeErrorMsg(){
  this.errorMsg = ""
}*/

}
}