import { Component } from '@angular/core';
import { faDashboard, faFileAlt, faSignOutAlt, faKeyboard } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-po-side-nav',
  templateUrl: './po-side-nav.component.html',
  styleUrls: ['./po-side-nav.component.css']
})
export class PoSideNavComponent {
  // Icon declarations
  faDashboard = faDashboard;
  faFileAlt = faFileAlt;
  faSignOutAlt = faSignOutAlt;
  faKeyboard = faKeyboard;  // Added faKeyboard for Data Entry

  constructor(private router: Router) {}

  onDataEntryClick(): void {
    Swal.fire({
      icon: 'warning',
      title: 'Access Denied',
      text: 'The PO is not allowed to enter data.',
      confirmButtonText: 'OK'
    });
  }

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
        this.router.navigate(['/login']); // Route to login page
      }
    });
  }
}
