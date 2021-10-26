import { Component, OnInit } from '@angular/core';
import { HttpClientService, Train } from '../service/http-client.service';

@Component({
  selector: 'app-train',
  templateUrl: './train.component.html',
  styleUrls: ['./train.component.css']
})
export class TrainComponent implements OnInit {

  trains:Train[] | any;

  constructor(private httpClientService:HttpClientService ) {}

  ngOnInit(): void {
   this.httpClientService.getTrains().subscribe(
    response => this.handleSuccessfulResponse(response),   );

  }

  handleSuccessfulResponse(response: Train[]) {
    this.trains=response;
  }

}
