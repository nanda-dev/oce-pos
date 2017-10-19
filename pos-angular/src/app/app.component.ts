import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { Title } from '@angular/platform-browser';

import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';

import '../assets/css/styles.css';

@Component({
  selector: 'my-app',
  styleUrls: ['./app.component.css'],
  template: `
    <router-outlet></router-outlet>
  `
})
export class AppComponent {
}
