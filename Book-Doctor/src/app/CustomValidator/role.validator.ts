import { AbstractControl } from '@angular/forms';



export function roleNameValidator(control : AbstractControl): {[key : string]: any} | null {
  const role = /Admin/.test(control.value);
  return role ? { 'roleName' : {value : control.value}} : null;
}
