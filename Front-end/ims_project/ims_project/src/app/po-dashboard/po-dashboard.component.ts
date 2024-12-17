import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExpenseReportService } from '../expense.service'; // Update path as necessary

@Component({
  selector: 'app-po-dashboard',
  templateUrl: './po-dashboard.component.html',
  styleUrls: ['./po-dashboard.component.css']
})
export class PoDashboardComponent implements OnInit {
  dashboardForm: FormGroup;
  headWiseExpenses: any[] = [];
  schoolWiseExpenses: any[] = [];
  yearWiseSchoolExpenses: any[] = [];
  sumExpensesBySchoolYearwise: any[] = [];
  years: number[] = []; // Array to hold years

  constructor(
    private fb: FormBuilder,
    private expenseReportService: ExpenseReportService
  ) {
    // Initialize the dashboard form with default year as 2024
    this.dashboardForm = this.fb.group({
      year: [2024] // Default value set to 2024
    });
  }

  ngOnInit(): void {
    // Initialize the years array from 2020 to 2024
    this.years = [2020, 2021, 2022, 2023, 2024];

    // Automatically filter by default year (2024)
    this.onSubmit();
  }

  onSubmit(): void {
    const year = this.dashboardForm.get('year')?.value;
    if (year) { // Check if year is provided
      this.getHeadWiseExpenses(year);
      this.getSchoolWiseExpenses(year);
      this.getYearWiseSchoolExpenses(); // Call this method to fetch data
      this.getSumExpensesBySchoolYearwise(year); // Fetch sum expenses by school for the selected year
    }
  }

  getHeadWiseExpenses(year: number): void {
    this.expenseReportService.getHeadWiseExpenses(year).subscribe(
      (data) => {
        this.headWiseExpenses = data;
      },
      (error) => {
        console.error('Error fetching head-wise expenses', error);
      }
    );
  }

  getSchoolWiseExpenses(year: number): void {
    this.expenseReportService.getSchoolWiseExpenses(year).subscribe(
      (data) => {
        this.schoolWiseExpenses = data;
      },
      (error) => {
        console.error('Error fetching school-wise expenses', error);
      }
    );
  }

  getYearWiseSchoolExpenses(): void {
    this.expenseReportService.getYearWiseSchoolExpenses().subscribe(
      (data) => {
        this.yearWiseSchoolExpenses = data;
      },
      (error) => {
        console.error('Error fetching year-wise school expenses', error);
      }
    );
  }

  getSumExpensesBySchoolYearwise(year: number): void {
    this.expenseReportService.getSumExpensesBySchoolYearwise(year).subscribe(
      (data) => {
        this.sumExpensesBySchoolYearwise = data;
      },
      (error) => {
        console.error('Error fetching sum expenses by school year-wise', error);
      }
    );
  }
}
