import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Train {
  constructor(
    public  id: string,
    public  train_no: string,
    public  arrival_time: string,
    public  departure_time: string,
    public  starting_station: string,
    public  destination: string,
    public  fare: string,
    public  journey_time: string,
    public  journey_route: string,
    public  total_distance: string,
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(  private httpClient: HttpClient) { }

  getTrains(){
    console.log('Test Call');
    return this.httpClient.get<Train[]>('http://localhost:8088/Search/findAllTrain');
  }
  getTrainByTrain_no(id: string){
    console.log('Test Call');
    return this.httpClient.get<Train[]>('http://localhost:8085/Admin/findAllTrain/'+id);
  }

  deleteTrain(id: string){
    console.log('Test Call');
    return this.httpClient.delete<Train[]>('http://localhost:8085/Admin/delete/'+id);
  }

  addTrain(Train: any){
    return this.httpClient.post<Train[]>('http://localhost:8085/Admin/addTrain',Train,{responseType:'text' as 'json'});
  }

  updateTrain(id: string, train: Train){
    return this.httpClient.put<Train[]>('http://localhost:8085/Admin/update/'+id,train,{responseType:'text' as 'json'});
  }
}
