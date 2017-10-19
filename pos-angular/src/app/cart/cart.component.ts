import { Component } from '@angular/core';
import { PopoverConfig } from 'ngx-bootstrap/popover';

export function getPopoverConfig(): PopoverConfig {
  return Object.assign(new PopoverConfig(), { placement: 'bottom' });
}

@Component({
  selector: 'cart-component',
  styleUrls: ['./cart.component.css'],
  templateUrl: './cart.component.html',
  providers: [{ provide: PopoverConfig, useFactory: getPopoverConfig }]
})
export class CartComponent {
  public html: string = `
  <a href=""><span class="glyphicon glyphicon-pencil"></span></a>
  <a href=""><span class="glyphicon glyphicon-remove"></span></a>`;
}
