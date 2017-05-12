import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'search',
  styleUrls: ['./search.component.css'],
  templateUrl: './search.component.html'
})
export class SearchComponent implements OnInit {
  constructor(private router: Router, private titleService: Title) { }
  ngOnInit() {
    this.titleService.setTitle('Search Results');
  }
}
