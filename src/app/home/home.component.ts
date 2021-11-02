import { Component, OnInit } from '@angular/core';
import { HttpClientService, Clients} from '../service/http-client.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';




@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  closeResult = '';
  clients:Clients[] | any;
  clients2: Clients = new Clients('','','','','',''); 

  email:any;
  password:any;
  message: any;



  constructor(private httpClientService:HttpClientService,
    private modalService: NgbModal,
    private fb:FormBuilder,
    private router:Router
    ) { }

  ngOnInit(): void {
  }
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason: any) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  open2(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title2'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  
  open5(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title2'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  onSubmit(f: NgForm) {
    console.log(f.value);
    this.httpClientService.signUp(f.value)
      .subscribe((result) => {
        this.ngOnInit(); //reload the table
      });
    this.modalService.dismissAll(); //dismiss the modal
 
  }

  onSubmit2(ff: NgForm) {
    console.log(ff.value);
    this.httpClientService.adminLogin(ff.value)
      .subscribe((result) => {
        console.log(result);
        this.message = result;
        alert("Welcome Admin");
        this.router.navigate(["/admin"]);
        

      });
    this.modalService.dismissAll(); //dismiss the modal
 
  }

  userpage(){
    alert("Welcome User");
    this.router.navigate(["/user"])
  }
  /*

  doLogin() {
    console.log(this.email,this.password);
    let resp = this.httpClientService.login(this.email, this.password);
    resp.subscribe(data => {
      this.message = data;
     this.router.navigate(["/admin"])
    });
  }
  */
  

}
