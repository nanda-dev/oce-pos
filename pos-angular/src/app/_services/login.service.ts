import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class LoginService {
  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post('http://localhost:8080/omniChannel', JSON.stringify({
      payLoad: {
        userName: username,
        passwrd: password
      },
      service: 'Login'
    })).map((response: Response) => {
      // login successful if there's a jwt token in the response
      let user = response.json();
      if (user && user.token) {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
      }

      return user;
    });
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
