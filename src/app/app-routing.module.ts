import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { TrainNoComponent } from './train/train-no/train-no.component';
import { TrainComponent } from './train/train.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'', redirectTo:'/home',pathMatch:'full'},
  {path:'home', component:HomeComponent},
  {path:'aboutus', component:HomeComponent},
  {path:'home/user', component:UserComponent},
  {path:'home/signup', component:RegisterUserComponent},
  {path:'trains', component:TrainComponent},
  {path:'home/trains', component:TrainComponent},
  {path:'train_no/:train_no', component:TrainNoComponent},
  {path:'admin', component:AdminComponent},
  {path:'user', component:UserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
