import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'serviceDevice',
  styleUrls: ['./serviceDevice.component.css'],
  templateUrl: './serviceDevice.component.html'
})
export class ServiceDeviceComponent implements OnInit {
  constructor(private router: Router, private titleService: Title) { }
  ngOnInit() {
    this.titleService.setTitle('Dashboard');
  }
}
