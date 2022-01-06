import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Fibonacci} from "./model/Fibonacci";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FiboService {

  constructor(private http: HttpClient) { }


  getFibonacciValues(): Observable<Fibonacci[]> {
    return this.http.get<Fibonacci[]>("http://localhost:8080/fibo/getValues");
  }

  calcFiboValue(value: number): Observable<any> {
    return this.http.post<void>("http://localhost:8080/fibo/calc", {value: value});
  }
}
