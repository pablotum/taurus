import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CuentaComponent } from './views/cuenta/cuenta.component';
import { EmpresaComponent } from './views/empresa/empresa.component';
import { BancoComponent } from './views/banco/banco.component';
import { PeriodoComponent } from './views/periodo/periodo.component';
import { MonedaComponent } from './views/moneda/moneda.component';
import { DocumentoComponent } from './views/documento/documento.component';
import { CuentabancariaComponent } from './views/cuentabancaria/cuentabancaria.component';
import { TipodocumentoComponent } from './views/tipodocumento/tipodocumento.component';
import { RubroComponent } from './views/rubro/rubro.component';
import { DonanteComponent } from './views/donante/donante.component';
import { ConvenioComponent } from './views/convenio/convenio.component';
import { ActividadComponent } from './views/actividad/actividad.component';
import { DiarioComponent } from './views/diario/diario.component';
import { ContactoComponent } from './views/contacto/contacto.component';
import { EntidadComponent } from './views/entidad/entidad.component';
import { ProyectoComponent } from './views/proyecto/proyecto.component';
import { PuestoComponent } from './views/puesto/puesto.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'cuenta', component: CuentaComponent },
  { path: 'empresa', component: EmpresaComponent },
  { path: 'moneda', component: MonedaComponent },
  { path: 'periodo', component: PeriodoComponent },
  { path: 'banco', component: BancoComponent },
  { path: 'documento', component: DocumentoComponent },
  { path: 'cuentabancaria', component: CuentabancariaComponent },
  { path: 'tipodocumento', component: TipodocumentoComponent },
  { path: 'rubro', component: RubroComponent},
  { path: 'donante', component: DonanteComponent },
  { path: 'convenio', component: ConvenioComponent },
  { path: 'actividad', component: ActividadComponent },
  { path: 'diario', component: DiarioComponent },
  { path: 'contacto', component: ContactoComponent },
  { path: 'entidad', component: EntidadComponent },
  { path: 'proyecto', component: ProyectoComponent },
  { path: 'puesto', component: PuestoComponent },
  { path: 'home', component: HomeComponent },

  { path: '', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
