import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { UpdateComponent } from './admin/update/update.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { TrainComponent } from './train/train.component';

const routes: Routes = [
  {path:'aboutus', component:HomeComponent},
  {path:'signup', component:RegisterUserComponent},
  {path:'trains', component:TrainComponent},
  {path:'admin', component:AdminComponent},
  {path:'update/:id',component:UpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
