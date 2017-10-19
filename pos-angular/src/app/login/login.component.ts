import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../_services/index';

@Component({
  selector: 'login',
  styleUrls: ['./login.component.css'],
  templateUrl: './login.component.html'
})
export class LoginComponent {
  model: any = {};
  loading = false;

  constructor(
    private router: Router,
    private loginService: LoginService) { }

  login() {
    this.loading = true;
    this.loginService.login(this.model.username, this.model.password)
      .subscribe(
      data => {
        this.router.navigate(['/dashboard']);
      },
      error => {
        console.log(error);
        this.loading = false;
      });
  }
}
