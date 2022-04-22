import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/api/api';
import { REST_API_BASE_URL } from 'src/app/constants/rest.constants';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<Customer[]>{
    return this.http.get<Customer[]>(REST_API_BASE_URL + '/customers/get-customers-browse');
  }
  setCustomer(customer: Customer): Observable<Customer>{
    return this.http.post<Customer>(REST_API_BASE_URL + '/customers/post-customer',customer);
  }
}
