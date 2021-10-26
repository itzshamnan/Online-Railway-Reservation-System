import { Component, OnInit } from '@angular/core';
import { AdminComponent } from '../admin.component';
import { HttpClientService, Train } from 'src/app/service/http-client.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  id: string | any;
  trains:Train[] | any;


  constructor(private httpClientService: HttpClientService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.httpClientService.getTrainByTrain_no(this.id).subscribe(data => {
      this.trains = data;
    }, error => console.log(error)); 
    
  }
  onSubmit(){
    this.httpClientService.updateTrain(this.id, this.trains).subscribe( data =>{
      this.goToTrainList();
    }
    , error => console.log(error));
  }
  goToTrainList() {
    this.router.navigate(['/trains']);
  }
  

}
