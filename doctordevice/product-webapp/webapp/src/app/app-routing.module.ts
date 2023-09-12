import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ServiceregComponent } from './servicereg/servicereg.component';
const routes: Routes = [{ path: '', component: ServiceregComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
