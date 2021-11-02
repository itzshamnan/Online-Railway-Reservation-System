import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { HttpClientService, Train , Tickets} from '../service/http-client.service';
import { Router } from '@angular/router';
import {ModalDismissReasons, NgbModal, NgbDropdown} from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';

import 'jspdf-autotable';
declare var jsPDF: any;
declare var jQuery: any;





@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  head = [['PNR', 'TRAIN NO', 'STARTING STATION', 'DESTINATION','DATE','test','test','test']];
  

  
  ticketvisible:boolean=false;
  tablevisible:boolean=false;
  alert:boolean=false;
  alert2:boolean=false;

  tickets: Tickets = new Tickets('','','','','','','','',''); 
  tickets2:Tickets[] | any; 

   trains:Train[] | any; 
   e:Tickets[] | any; 

   trains2: Train = new Train('','','','','','','','',''); 

 
  /*tickets: Tickets[]=new Tickets("","","","","","","","","");*/
  editForm:FormGroup| any;
  pass_id: any;
  closeResult: any;
  deleteTicket: string | any;
  data: Tickets[] | any; 
  Listtrackigobjct:Tickets[] | any; 




  constructor(private httpClientService:HttpClientService,
    private router: Router,
    private modalService: NgbModal,
    private fb:FormBuilder
    ) { }

  ngOnInit(): void {
  
      this.editForm = this.fb.group({
        train_no: [''],
        starting_station: [''],
        destination: [''],
      } );
  }
  available(){
    this.httpClientService.getTrains().subscribe(
      response => this.handleSuccessfulResponse(response),   );
      this.tablevisible=true;
      this.ticketvisible=false;

  }
  handleSuccessfulResponse(response: Train[]) {
    console.log(response);
    this.trains=response;
    ;

  }
  handleSuccessfulResponse2(response: Train[]) {
    console.log(response);
    JSON.stringify(response) 
    this.trains=[response];
    console.log(response);

    ;

  }
  getTrainByTrainNo(train_no:string) {
    console.log(train_no);
    this.httpClientService.getTrainByTrain_No(train_no).subscribe(
      response => this.handleSuccessfulResponse2(response),   );
 
      this.ticketvisible=false;
      this.tablevisible=true;
      this.modalService.dismissAll(); //dismiss the modal

  }
  getTrainByStart_Dest(starting_station:string,destination:string){
    console.log(starting_station,destination);
    this.httpClientService.getTrainByStart_Dest(starting_station,destination).subscribe(
      response => this.handleSuccessfulResponse(response),   );
 
      this.ticketvisible=false;

      this.tablevisible=true;
      this.modalService.dismissAll(); //dismiss the modal

  }

  findTickets(){
    this.httpClientService.findTickets().subscribe(
      response => this.handleSuccessfulResponse3(response),   );
      this.ticketvisible=true;
      this.tablevisible=false;
  }
  handleSuccessfulResponse3(response: Tickets[]) {
    console.log(response);
    this.tickets2=response;
    ;}

    getTicketsbyEmail(email:string) {
      console.log(email);
      this.httpClientService.getTicketsbyEmail(email).subscribe(
        response => this.handleSuccessfulResponse3(response),   );
   
        this.ticketvisible=false;
        this.tablevisible=false;
        this.modalService.dismissAll(); //dismiss the modal
  
    }

  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  open_search(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-search-title'}).result.then((result) => {
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
    this.httpClientService.bookTickets(f.value)
      .subscribe((result) => {
        this.findTickets(); //reload the table
        alert("Booking Success");
      });
    this.modalService.dismissAll(); //dismiss the modal
    this.alert=true;
    
 
  }

  openDelete(targetModal: any, tickets2: Tickets) {
    this.deleteTicket = tickets2.ticket_sequence;
    this.modalService.open(targetModal, {
      backdrop: 'static',
      size: 'lg'
    });
  }
  onDelete() {
    this.httpClientService.deleteTicket(this.deleteTicket)
      .subscribe((results) => {
        this.findTickets();
        this.modalService.dismissAll();
        alert("Ticket Cancelled successfully");
      });
      this.alert2=true;
      this.httpClientService.findTickets().subscribe(
        response => this.handleSuccessfulResponse3(response),   );

  }

  getTicket(ticket_sequence:any){
    this.httpClientService.findByTicket_no(ticket_sequence).subscribe(
      response =>this.createPdf(response), );

  }

  createPdf(response: Tickets[]) {
    console.log(response);



    var doc = new jsPDF();
    this.head.fill
    
    

    doc.setFontSize(18);
    doc.text('Ticket Detail', 11, 8);
    doc.setFontSize(11);
    doc.setTextColor(100);

    (doc as any).autoTable({
      head: this.head,
      body:response,
      theme: 'plain',
      didDrawCell: (body: { column: { index: any; }; }) => {
        console.log(body.column.index)
      }
    })
    
    // below line for Open PDF document in new tab
    doc.output('dataurlnewwindow')

    // below line for Download PDF document  
    doc.save('ticket.pdf');
  }

  

  
}


 

  

  

/*
function NgbdModalContent(NgbdModalContent: any) {
  throw new Error('Function not implemented.');
}
*/

