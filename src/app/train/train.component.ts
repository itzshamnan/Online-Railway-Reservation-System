import { Component, OnInit } from '@angular/core';
import { HttpClientService, Train } from '../service/http-client.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-train',
  templateUrl: './train.component.html',
  styleUrls: ['./train.component.css']
})
export class TrainComponent implements OnInit {



  trains:Train[] | any;

  constructor(private httpClientService:HttpClientService,
    private route: ActivatedRoute,
    private router: Router ) {}

  ngOnInit(): void {
   this.httpClientService.getTrains().subscribe(
    response => this.handleSuccessfulResponse(response),   );

  }

  handleSuccessfulResponse(response: Train[]) {
    this.trains=response;
  }

  public getTrainByTrainNo(train_no:string){
    this.router.navigate(['train_no',train_no]);
      }

}
