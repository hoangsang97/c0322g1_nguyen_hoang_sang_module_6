import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SecurityRoutingModule } from './security-routing.module';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ResetPasswordComponent} from './reset-password/reset-password.component';
import {VerificationComponent} from './verification/verification.component';
import {VerifyResetPasswordComponent} from './verify-reset-password/verify-reset-password.component';


@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    ResetPasswordComponent,
    VerificationComponent,
    VerifyResetPasswordComponent
  ],
  imports: [
    CommonModule,
    SecurityRoutingModule
  ]
})
export class SecurityModule { }
