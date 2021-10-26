import { Component, OnInit } from '@angular/core';
import { HttpClientService, Train } from '../service/http-client.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  trains:Train[] | any;

  /*train: Train[]=new Train("","","","","","","","","","");*/
  message:any;

  constructor(private httpClientService:HttpClientService,private router: Router) { }

 

  ngOnInit(): void {
    this.httpClientService.getTrains().subscribe(
      response => this.handleSuccessfulResponse(response),   );
  }
  handleSuccessfulResponse(response: Train[]) {
    this.trains=response;
  }
  public deleteTrain(id: string){
    let resp= this.httpClientService.deleteTrain(id);
    resp.subscribe((data)=>this.trains=data);
   }

   public addTrain(){
    let resp=this.httpClientService.addTrain(this.trains);
    resp.subscribe((data)=>this.message=data);
      }

     public updateTrain(id: string){
        this.router.navigate(['update', id]);
      }

}
