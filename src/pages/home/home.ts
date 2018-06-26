import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  doughnutChartLabels:string[];
  doughnutChartData:number[];
  doughnutChartType:string = 'doughnut';

  constructor(public navCtrl: NavController) {

  }

  calc(tipo){
    this.calcDoughnut();

  }

  calcDoughnut(){
    requestDB();
    this.doughnutChartLabels = Object.keys(diccionario1);
    this.doughnutChartData = Object.values(diccionario1);
  };
}
