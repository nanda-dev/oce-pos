import { Directive, ElementRef, Input } from '@angular/core';

@Directive({
  selector: '[validationTooltip]'
})
export class ValidationTooltip {
  @Input() placement: string;
  @Input('validationTooltip') validationTooltip: string;
  constructor(private el: ElementRef) { }
  ngOnChanges() {
    if (!!this.validationTooltip) {
      $(this.el.nativeElement).tooltip({
        title: this.validationTooltip,
        placement: this.placement || 'bottom',
        trigger: 'manual'
      }).tooltip('show');
    } else {
      $(this.el.nativeElement).tooltip('hide');
    }
  }
}
