import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap/modal';
import { PopoverModule } from 'ngx-bootstrap/popover';
import { TooltipModule } from 'ngx-bootstrap/tooltip';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoggedInComponent } from './login/loggedIn.component';
import { HeaderComponent } from './header/header.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SearchComponent } from './search/search.component';
import { NewCustomerComponent } from './newCustomer/newCustomer.component';
import { ServiceDeviceComponent } from './serviceDevice/serviceDevice.component';
import { PendingTransactionComponent } from './pendingTransaction/pendingTransaction.component';
import { CartComponent } from './cart/cart.component';
import { PaymentComponent } from './payment/payment.component';

import { LoginService } from './_services/index';

import { ValidationTooltip } from './_directives/validationTooltip.directive';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/font-awesome/css/font-awesome.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.js';

const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'dashboard',
    component: LoggedInComponent,
    children: [
      { path: '', component: DashboardComponent },
      { path: 'search', component: SearchComponent },
      { path: 'newCustomer', component: NewCustomerComponent },
      { path: 'serviceDevice', component: ServiceDeviceComponent },
      { path: 'pendingTransaction', component: PendingTransactionComponent },
      { path: 'cart', component: CartComponent },
      { path: 'payment', component: PaymentComponent }
    ]
  }
];

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ModalModule.forRoot(),
    PopoverModule.forRoot(),
    TooltipModule.forRoot(),
    RouterModule.forRoot(appRoutes, { useHash: true })
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    DashboardComponent,
    LoggedInComponent,
    SearchComponent,
    NewCustomerComponent,
    ServiceDeviceComponent,
    PendingTransactionComponent,
    CartComponent,
    PaymentComponent,
    ValidationTooltip
  ],
  providers: [
    Title,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
