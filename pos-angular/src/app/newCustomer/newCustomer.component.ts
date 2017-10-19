import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'new-customer',
  styleUrls: ['./newCustomer.component.css'],
  templateUrl: './newCustomer.component.html'
})
export class NewCustomerComponent implements OnInit {
  constructor(private router: Router, private titleService: Title) { }
  ngOnInit() {
    this.titleService.setTitle('New Customer');
  }
}
