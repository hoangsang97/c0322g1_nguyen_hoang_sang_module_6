import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../service/auth.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  formGroup: FormGroup;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  isSubmited = false;
  formValid = false;

  constructor(private formBuild: FormBuilder,
              private authService: AuthService,
              private toastr: ToastrService,
              private router: Router) {
  }

  validationMessages = {
    password: [
      {type: 'required', message: 'Trường này không được để trống!'},
      {type: 'minlength', message: 'Mật khẩu nhiều hơn 8 ký tự'},
      {type: 'maxlength', message: 'Mật khẩu ít hơn 32 ký tự'},
    ],
    email: [
      {type: 'required', message: 'Trường này không được để trống!'},
      {type: 'pattern', message: 'Email sai định dạng'}
    ],
    gender: [{}]
  };

  ngOnInit(): void {
    //  declare form group by Linh
    this.formGroup = this.formBuild.group({
        password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(32)]],
        email: ['', [Validators.required, Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]],
        username: [''],
        gender: ['', [Validators.required]],
      }
    );

  }

  onSubmit() {
    if (this.formGroup.invalid) {
      this.toastr.warning('Form phải được điền đúng định dạng', 'Warning:', {
        positionClass: 'toast-bottom-right',
        timeOut: 1500,
        extendedTimeOut: 1500
      });
    } else {
      this.isSubmited = true;
      this.authService.register(this.formGroup.value).subscribe(
        data => {
          this.isSuccessful = true;
          this.isSignUpFailed = false;
          this.toastr.success(data.message, 'Hoàn tất: ', {
            positionClass: 'toast-bottom-right',
            timeOut: 2500,
            extendedTimeOut: 1500
          });
          this.router.navigateByUrl('/verification');

        },
        err => {
          this.toastr.error(err.error.message, 'Lỗi: ', {
            positionClass: 'toast-bottom-right',
            timeOut: 1500,
            extendedTimeOut: 1500
          });
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
          this.isSubmited = false;
        }
      );
    }
  }
}
