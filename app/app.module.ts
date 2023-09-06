import { NO_ERRORS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSoftwareComponent } from './create-software/create-software.component';
import { SoftwareDetailsComponent } from './software-details/software-details.component';
import { SoftwareListComponent } from './software-list/software-list.component';
import { UpdateSoftwareComponent } from './update-software/update-software.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
// import { LoginComponent } from './login/login.component';
// import { LogoutComponent } from './logout/logout.component';
import { FeedbackComponent } from './feedback/feedback.component';

import { CarouselModule } from 'ngx-bootstrap/carousel';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { BuyNowComponent } from './buy-now/buy-now.component';
import { CreateDeveloperComponent } from './create-developer/create-developer.component';
import { DeveloperListComponent } from './developer-list/developer-list.component';
import { DeveloperDetailsComponent } from './developer-details/developer-details.component';
import { UpdateDeveloperComponent } from './update-developer/update-developer.component';
import { ViewSoftwareComponent } from './view-software/view-software.component';
import { GetSoftwareComponent } from './get-software/get-software.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
// import { SignupComponent } from './signup/signup.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateSoftwareComponent,
    SoftwareDetailsComponent,
    SoftwareListComponent,
    UpdateSoftwareComponent,
    HomeComponent,
    AboutUsComponent,
    ContactUsComponent,

    FeedbackComponent,
    ViewCustomerComponent,
    BuyNowComponent,
    CreateDeveloperComponent,
    DeveloperListComponent,
    DeveloperDetailsComponent,
    UpdateDeveloperComponent,
    ViewSoftwareComponent,
    GetSoftwareComponent,
    SignupComponent,
    LoginComponent,
    LogoutComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }