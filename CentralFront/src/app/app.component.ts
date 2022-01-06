import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title = 'CentralFront';

  fiboOpened: boolean = false;
  docsOpened: boolean = false;


  fiboClick(): void {
    this.fiboOpened = true;
    this.docsOpened = false;
  }

  docsClick(): void {
    this.fiboOpened = false;
    this.docsOpened = true;
  }
}
