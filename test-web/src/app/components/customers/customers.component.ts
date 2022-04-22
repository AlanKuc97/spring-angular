import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/api/api';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss']
})
export class CustomersComponent implements OnInit {
  displayDialog: boolean = false;
  selectedCustomer!: Customer;
  dialogHeader: 'Add new customer'|'Customer information' = 'Add new customer';
  isAddDialog: boolean = false;
  customers: Customer[] = [];
  constructor(private service: CustomerService) { }

  ngOnInit(): void {
    this.service.getCustomers().subscribe((res)=>{
      console.log(res);
      this.customers = [...res];
    });
  }

  selectCustomer(customer: Customer){
    this.selectedCustomer = customer;
    this.displayDialog = true;
    this.isAddDialog = false;
    this.dialogHeader = 'Customer information';
  }

  showAddDialog(){
    this.selectedCustomer = {
      id:null,
      name:null,
      surname:null,
      birthDate:null,
      telNumber:null,
      email:null
    };
    this.displayDialog = true;
    this.isAddDialog = true;
    this.dialogHeader = 'Add new customer';
  }
}
