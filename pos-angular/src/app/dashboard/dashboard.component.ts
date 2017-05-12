import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { ModalDirective } from 'ngx-bootstrap/modal';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {
  constructor(private router: Router, private titleService: Title) { }
  @ViewChild('pendingTransactionModal') public pendingTransactionModal: ModalDirective;
  searchText: any = '';
  search() {
    if (this.searchText == 345789123) {
      this.pendingTransactionModal.show();
    } else {
      this.router.navigate(['/dashboard/search']);
    }
  }
  goToPendingTransaction() {
    this.router.navigate(['/dashboard/pendingTransaction']);
  }
  hideModal() {
    this.pendingTransactionModal.hide();
  }
  ngOnInit() {
    this.titleService.setTitle('Dashboard');
  }
}
