import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-contact',
  templateUrl: 'contact.html',
})
export class ContactPage {
  doughnutChartLabels:string[];
  doughnutChartData:number[];
  doughnutChartType:string = 'doughnut';

  constructor(public navCtrl: NavController) {

  }

  calc(tipo){
    if (tipo === 'Vaciar') {
        this.calcDoughnut1();
    } else {
        this.calcDoughnut();
  }
}
   calcDoughnut1(){
    this.doughnutChartLabels = [];
    this.doughnutChartData = [];
  }
   calcDoughnut(){
    requestDB();
    this.doughnutChartLabels = Object.keys(diccionarioEdad1);
    this.doughnutChartData = Object.values(diccionarioEdad1);
  };
  public btnClicked(){
    edad = this.userInput;
    requestDB();

  }

}
