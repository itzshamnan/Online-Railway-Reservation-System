import { Component, OnInit } from '@angular/core';
import { HttpClientService, Train } from 'src/app/service/http-client.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-train-no',
  templateUrl: './train-no.component.html',
  styleUrls: ['./train-no.component.css']
})
export class TrainNoComponent implements OnInit {

  train_no: string | any;
  trains:Train[] | any;

  constructor(private httpClientService: HttpClientService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    console.log('test call');
    this.train_no = this.route.snapshot.params['train_no'];

    this.httpClientService.getTrainByTrain_No(this.train_no).subscribe(data => {
      this.trains = data;
    }, error => console.log(error));
  }

}
