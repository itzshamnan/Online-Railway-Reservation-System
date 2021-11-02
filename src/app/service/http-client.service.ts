import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

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
    public  total_distance: string,
  ){}
}
export class Tickets {
  constructor(
    public  ticket_sequence: any,
    public  name: string,
    public  email: string,
    public  address: string,
    public  phone_no: string,
    public  train_no: string,
    public  starting_station: string,
    public  destination: string,
    public  date: string,
  ){}
}

export class Clients {
  constructor(
    public  userId: any,
    public  role: any,
    public  name: any,
    public  email: any,
    public  phone_no: any,
    public  password: any,
  ){}
}

export class Admin {
  constructor(
    public  email: any,
    public  password: any
  ){}
}

export class User {
  constructor(
    public  email: any,
    public  password: any
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(  private httpClient: HttpClient) { }

  getTrains(){
    console.log('Test Call');
    return this.httpClient.get<Train[]>('http://localhost:8100/searching-service/Search/findAllTrain');
  }
  getTrainById(id: string){
    let email='shamnanpt@gmail.com'
    let password='admin123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(email + ':' + password) });
    console.log('Test Call');
    return this.httpClient.get<Train[]>('http://localhost:8085/Admin/findAllTrain/'+id,{headers});
  }

  deleteTrain(id: string){
    let email='shamnanpt@gmail.com'
    let password='admin123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(email + ':' + password) });
    console.log('Test Call');
    return this.httpClient.delete<Train[]>('http://localhost:8085/Admin/delete/'+id,{headers});
  }

  addTrain(train: Train){
    let email='shamnanpt@gmail.com'
    let password='admin123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(email + ':' + password) });
    return this.httpClient.post<Train[]>('http://localhost:8085/Admin/addTrain',train,{headers,responseType:'text' as 'json'});
  }

  updateTrain(id: string, train: Train){
    let email='shamnanpt@gmail.com'
    let password='admin123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(email + ':' + password) });
    return this.httpClient.put<Train[]>('http://localhost:8085/Admin/update/'+id,train,{headers,responseType:'text' as 'json'});
  }

  getTrainByTrain_No(train_no: string){
    console.log('Test Call happnd for train no');
    return this.httpClient.get<Train[]>('http://localhost:8100/searching-service/Search/findAllTrain/'+train_no);
  }

  bookTickets(ticket: Tickets){
    return this.httpClient.post<Tickets[]>('http://localhost:8100/Booking-service/booking/ticket/add',ticket,{responseType:'text' as 'json'});
  }


  getTrainByStart_Dest(starting_station:string,destination:string){
    console.log('Test Call happnd for start and destination');
    return this.httpClient.get<Train[]>('http://localhost:8100/searching-service/Search/findAllTrain/'+starting_station+'/'+destination);

  }

  findTickets(){
    console.log('Test Call');
    return this.httpClient.get<Tickets[]>('http://localhost:8100/Booking-service/booking/findAllTickets');
  
  }

  getTicketsbyEmail(email : string){
    console.log('Test Call');
    return this.httpClient.get<Tickets[]>('http://localhost:8100/Booking-service/booking/findAllTickets/'+email);

  }

  findByTicket_no(ticket_sequence:any){
    console.log(ticket_sequence);
    return this.httpClient.get<Tickets[]>('http://localhost:8100/Booking-service/booking/findTicket/'+ticket_sequence);


  }

  deleteTicket(ticket_sequence : any){
    console.log('Test Call');
    return this.httpClient.delete<Tickets[]>('http://localhost:8100/Booking-service/booking/delete/'+ticket_sequence);

  }

  signUp(client:Clients){
    console.log('Test Call');
    return this.httpClient.post<Clients[]>('http://localhost:8100/Client-service/clients/signup',client,{responseType:'text' as 'json'});

  }

  adminLogin(admin:Admin){
    console.log(admin);
    const headers = new HttpHeaders({ Authorization: 'Basic ' +btoa(admin.email+":"+admin.password) });
    console.log(admin.password);
    console.log(headers);
    return this.httpClient.get("http://localhost:8085/Admin/",{headers,responseType: 'text' as 'json'})
  }

  
  userLogin(user:User){
    console.log(user);
    const headers = new HttpHeaders({ Authorization: 'Basic ' +btoa(user.email+":"+user.password) });
    console.log(user.password);
    console.log(headers);
    return this.httpClient.get("http://localhost:8900/",{headers,responseType: 'text' as 'json'})
  }

}
