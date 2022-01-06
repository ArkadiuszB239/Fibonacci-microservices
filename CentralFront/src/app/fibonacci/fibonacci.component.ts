import { Component, OnInit } from '@angular/core';
import {FiboService} from "../services/fibo-service.service";
import {Fibonacci} from "../services/model/Fibonacci";
import {first, Observable, interval, mergeMap} from "rxjs";

@Component({
  selector: 'app-fibonacci',
  templateUrl: './fibonacci.component.html',
  styleUrls: ['./fibonacci.component.less']
})
export class FibonacciComponent implements OnInit {

  constructor(private fiboService: FiboService) { }

  fiboTable: Fibonacci[] = [];
  numberToAdd: number = 0;

  success: boolean = false;
  failure: boolean = false;

  ngOnInit(): void {
    interval(3000)
      .pipe(mergeMap(() => this.fiboService.getFibonacciValues()))
      .subscribe({
        next: (data: Fibonacci[]) => this.fiboTable = data,
        error: () => console.log('Error while getting fib values!')
      })
  }


  calculateFiboValue(): void {
    if (this.numberToAdd > 0) {
      this.fiboService.calcFiboValue(this.numberToAdd)
        .pipe(first())
        .subscribe({
          next: () => {
            this.numberToAdd = 0;
            this.success = true;
            this.failure = false;
          },
          error: err => {
            this.failure = true;
            this.success = false;
            console.log(err)
          }
        })
    } else {
      this.failure = true;
      this.success = false;
    }
  }

}
