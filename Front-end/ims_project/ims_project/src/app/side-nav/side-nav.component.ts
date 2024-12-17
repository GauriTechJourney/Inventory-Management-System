import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { faDashboard, faFileAlt, faSignOutAlt, faKeyboard } from '@fortawesome/free-solid-svg-icons';  // Added faKeyboard
import Swal from 'sweetalert2';  // Import SweetAlert2

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent {
  faDashboard = faDashboard;
  faFileAlt = faFileAlt;
  faSignOutAlt = faSignOutAlt;
  faKeyboard = faKeyboard;  // Added faKeyboard for Data Entry

  constructor(private router: Router) {}

  onLogout(): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'Do you really want to log out?',
      icon: 'question',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, log out',
      cancelButtonText: 'Cancel'
    }).then((result) => {
      if (result.isConfirmed) {
        // Perform any logout logic here (e.g., clearing session data)
        this.router.navigate(['/login']);  // Route to login page
      }
    });
  }
}
