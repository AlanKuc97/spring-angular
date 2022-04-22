import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Customer } from 'src/app/model/api/api';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-dialog-info',
  templateUrl: './dialog-info.component.html',
  styleUrls: ['./dialog-info.component.scss']
})
export class DialogInfoComponent implements OnInit {
  form!: FormGroup;
  selectedCustomer!: Customer;
  @Input() set viewInfo( customer: Customer){
    if(customer?.birthDate != null){
      this.selectedCustomer = {...customer, birthDate: new Date(customer.birthDate as Date)};
    }else{
      this.selectedCustomer = {...customer};
    }
    this.form?.patchValue(this.selectedCustomer); 
  }
  @Input() headerText: string = '';
  @Input() isAddDialog: boolean = false;
  @Input() display: boolean = false;
  @Output() displayChange: EventEmitter<boolean> = new EventEmitter<boolean>();
  
  constructor(private formBuilder: FormBuilder,
              private customerService: CustomerService) { }
  
  ngOnInit(): void {
    this.form = this.formBuilder.group({
      id: new FormControl(null),
      name: new FormControl(null, Validators.compose([Validators.required,Validators.maxLength(30)])),
      surname: new FormControl(null, Validators.compose([Validators.required,Validators.maxLength(30)])),
      birthDate: new FormControl(null,Validators.required),
      telNumber: new FormControl(null,Validators.required),
      email: new FormControl(null, Validators.compose([Validators.required,Validators.email]))
    });
  }

  saveCustomer(){
    if(this.form.invalid){
      alert("Please fill form");
      return;
    }
    this.customerService.setCustomer(this.form.value).subscribe((res)=>{
      console.log(res);
    });
    this.cancel();
  }

  cancel(){
    this.displayChange.emit();
  }
}
