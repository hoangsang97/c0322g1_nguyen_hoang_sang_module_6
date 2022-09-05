import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './security/login/login.component';
import {RegisterComponent} from './security/register/register.component';
import {ResetPasswordComponent} from './security/reset-password/reset-password.component';


const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  }, {
    path: 'register',
    component: RegisterComponent
  }, {
    path: 'reset-password',
    component: ResetPasswordComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
