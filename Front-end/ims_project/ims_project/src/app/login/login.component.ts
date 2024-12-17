import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) {
    // Initialize the login form with form controls and validation
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    // Check if the form is valid
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value; // Destructure form values

      // Call the login method from UserService
      this.userService.login(email, password).subscribe(
        response => {
          if (response && response.role === 'PO') {
            this.router.navigate(['/po-dashboard']); // Redirect to PO dashboard
          } else if (response && response.role === 'clerk') {
            this.router.navigate(['/data-input']); // Redirect to Clerk dashboard
          } else {
            alert('Invalid Credentials: Please check your email or password.');
          }
        },
        error => {
          alert('Login Error: An error occurred during login. Please try again later.');
        }
      );
    }
  }
}
