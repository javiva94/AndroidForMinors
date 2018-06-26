import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-about',
  templateUrl: 'about.html'
})
export class AboutPage {

    doughnutChartLabels:string[];
    doughnutChartData:number[];
    doughnutChartType:string = 'doughnut';

    constructor(public navCtrl: NavController) {

    }

    calc(tipo){
      if (tipo === 'Mujer') {
          this.calcBar();
      } else {
          this.calcDoughnut();
      }
    }

    calcBar(){
      requestDB();
      this.doughnutChartLabels = Object.keys(diccionarioMujer1);
      this.doughnutChartData = Object.values(diccionarioMujer1);
    }

    calcDoughnut(){
      requestDB();
      this.doughnutChartLabels = Object.keys(diccionarioHombre1);
      this.doughnutChartData = Object.values(diccionarioHombre1);
    };
  }
