import { Component, OnInit } from '@angular/core';
import { HttpClientService, Train } from '../service/http-client.service';
import { Router } from '@angular/router';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';



@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  trains:Train[] | any;

  /*train: Train[]=new Train("","","","","","","","","","");*/
  message:any;
  closeResult: any;
  editForm:FormGroup| any;
  pass_id: string | any;
  deleteId:string | any;
  

  constructor(private httpClientService:HttpClientService,
    private router: Router,
    private modalService: NgbModal,
    private fb:FormBuilder
    ) { }

 

  ngOnInit(): void {
    this.httpClientService.getTrains().subscribe(
      response => this.handleSuccessfulResponse(response),   );
      this.editForm = this.fb.group({
        train_no: [''],
        arrival_time: [''],
        departure_time: [''],
        starting_station: [''],
        destination: [''],
        fare: ['']
      } );
  }
  handleSuccessfulResponse(response: Train[]) {
    this.trains=response;
  }
  public deleteTrain(id: string){
    let resp= this.httpClientService.deleteTrain(id);
    resp.subscribe((data)=>this.trains=data);
   }

      open(content: any) {
        this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
          this.closeResult = `Closed with: ${result}`;
        }, (reason) => {
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
      onSubmit(f: NgForm) {
        this.httpClientService.addTrain(f.value)
          .subscribe((result) => {
            this.ngOnInit(); //reload the table
            alert("Train Added successfully");
          });
        this.modalService.dismissAll(); //dismiss the modal
      }

      openEdit(targetModal: any, trains: Train,id:any) {
        this.modalService.open(targetModal, {
          backdrop: 'static',
          size: 'lg'
        });
        this.editForm.patchValue( {
          train_no: trains.train_no, 
          arrival_time: trains.arrival_time,
          departure_time: trains.departure_time,
          starting_station: trains.starting_station,
          destination: trains.destination,
          fare: trains.fare
        });
        this.pass_id=id;
      }

      onSave() {
        console.log(this.editForm.value);
        this.httpClientService.updateTrain(this.pass_id,this.editForm.value)
          .subscribe((results) => {
            this.ngOnInit();
            this.modalService.dismissAll();
          });
          alert("Train Edited successfully");
      }

      openDelete(targetModal: any, trains: Train) {
        this.deleteId = trains.id;
        this.modalService.open(targetModal, {
          backdrop: 'static',
          size: 'lg'
        });
      }
      onDelete() {
        this.httpClientService.deleteTrain(this.deleteId)
          .subscribe((results) => {
            this.ngOnInit();
            this.modalService.dismissAll();
            alert("Train Deleted successfully");
          });
      }

      

      onLogOut(){
        this.router.navigate(["/home"])
        this.modalService.dismissAll();
        alert("Logged Out successfully");


      }
      

}
function deleteID(deleteID: any) {
  throw new Error('Function not implemented.');
}

