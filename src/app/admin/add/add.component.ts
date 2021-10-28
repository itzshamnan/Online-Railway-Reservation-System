import { Component, OnInit } from '@angular/core';
import { HttpClientService, Train } from 'src/app/service/http-client.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  trains = new Train('','','','','','','','','');
  
  constructor(private httpClientService: HttpClientService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }
  addTrain(){
    

    this.httpClientService.addTrain(this.trains).subscribe( data =>{
      console.log(data);
      this.goToTrainList();
      console.log(this.trains);
    },
    error => console.log(error));
  }

  goToTrainList(){
    console.log(this.trains);

    this.router.navigate(['/trains']);
  }
  
  onSubmit(){
    console.log(this.trains);
    this.addTrain();
  }
 
}
