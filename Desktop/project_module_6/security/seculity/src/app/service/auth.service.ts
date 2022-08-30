import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const AUTH_API = 'http://localhost:8080/api/public/';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  httpOptions: any;
  isLoggedIn: boolean;

  constructor(private http: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  login(obj): Observable<any> {
    return this.http.post(AUTH_API + 'login', {
      username: obj.username,
      password: obj.password
    }, this.httpOptions);
  }

  register(obj): Observable<any> {
    console.log(obj);
    return this.http.post(AUTH_API + 'signup', {
      bookId: obj.book_id,
      name: obj.name,
      gender: obj.gender,
      dateOfBirth: obj.dateOfBirth,
      guardian: obj.guardian,
      address: obj.address,
      phone: obj.phone,
      email: obj.email,
      password: obj.password,
    }, this.httpOptions);
  }

  verify(code: string): Observable<any> {
    console.log(code);
    return this.http.post(AUTH_API + 'verify', {
      code
    }, this.httpOptions);
  }

  verifyPassword(code: string): Observable<any> {
    return this.http.post(AUTH_API + 'verify-password', {
      code
    }, this.httpOptions);
  }

  resetPassword(username: string): Observable<any> {
    return this.http.post(AUTH_API + 'reset-password', {
      username,
    }, this.httpOptions);
  }

  doResetPassword(password: string, code: string): Observable<any> {
    return this.http.post(AUTH_API + 'do-reset-password', {
      password,
      code
    }, this.httpOptions);
  }
}
