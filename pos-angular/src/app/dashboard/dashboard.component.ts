import { Component, OnInit, ViewChild, QueryList, ViewChildren } from '@angular/core';
import { Router } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { NgForm } from '@angular/forms';
import { ModalDirective } from 'ngx-bootstrap/modal';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {
  constructor(private router: Router, private titleService: Title) { }
  @ViewChild('pendingTransactionModal') public pendingTransactionModal: ModalDirective;
  @ViewChild('dashboardForm') public currentForm: NgForm;
  searchTextModel: any = '';
  dashboardForm: NgForm;

  formErrors = {
    'searchText': ''
  };
  validationMessages = {
    'searchText': {
      'required': 'Search Text is required.'
    }
  };

  ngOnInit() {
    this.titleService.setTitle('Dashboard');
  }
  ngAfterViewChecked() {
    this.formChanged();
  }
  formChanged() {
    if (this.currentForm === this.dashboardForm) { return; }
    this.dashboardForm = this.currentForm;
    if (this.dashboardForm) {
      this.dashboardForm.valueChanges
        .subscribe(data => this.onValueChanged(data));
    }
  }
  onValueChanged(data?: any) {
    if (!this.dashboardForm) { return; }
    const form = this.dashboardForm.form;

    for (const field in this.formErrors) {
      // clear previous error message (if any)
      this.formErrors[field] = '';
      const control = form.get(field);

      if (control && control.dirty && !control.valid) {
        const messages = this.validationMessages[field];
        for (const key in control.errors) {
          this.formErrors[field] += messages[key] + ' ';
        }
      }
    }
  }
  search() {
    if (!!this.currentForm.valid) {
      if (this.searchTextModel == 345789123) {
        this.pendingTransactionModal.show();
      } else {
        this.router.navigate(['/dashboard/search']);
      }
    }
  }
  goToPendingTransaction() {
    this.router.navigate(['/dashboard/pendingTransaction']);
  }
  hideModal() {
    this.pendingTransactionModal.hide();
  }
}
