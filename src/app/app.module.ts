import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrainComponent } from './train/train.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RegisterUserComponent } from './register-user/register-user.component'; 
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

/*** Angular Material */
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card'; 
import {MatTabsModule} from '@angular/material/tabs'; 
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';  
import {MatCheckboxModule} from '@angular/material/checkbox'; 
import {MatIconModule} from '@angular/material/icon';
import { AdminComponent } from './admin/admin.component'; 
import { HttpClientService } from './service/http-client.service';
import { TrainNoComponent } from './train/train-no/train-no.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UserComponent } from './user/user.component';
import { GoogleLoginProvider, SocialAuthServiceConfig, SocialLoginModule } from 'angularx-social-login';
import { MatListModule } from '@angular/material/list';


@NgModule({
  declarations: [
    AppComponent,
    TrainComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    RegisterUserComponent,
    AdminComponent,
    TrainNoComponent,
    UserComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,

    /*** Angular Material */
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatTabsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatIconModule,
    MatListModule,
    NgbModule,
    ReactiveFormsModule,
    SocialLoginModule
    
    




    
  ],
  providers: [HttpClientService,
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '787847535272-9ftg2ar4cv6qcgetlsg1a38u181duv2v.apps.googleusercontent.com' // add web app client id
            )
          }
        ]
      } as SocialAuthServiceConfig
    }

              ],
  bootstrap: [AppComponent]
})
export class AppModule { }
