import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MatGridListModule, MatButtonModule, MatCheckboxModule, MatCardModule, MatFormFieldModule, MatIconModule, MatInputModule, MatToolbarModule, MatSidenavModule, MatChipsModule, MatDialogModule, MatMenuModule, MatSlideToggleModule, MatOptionModule, MatSelectModule, MatTableModule, MatTooltipModule, MatAutocompleteModule, MatRadioModule, MatDatepickerModule, MatNativeDateModule, MatTabsModule, MatPaginatorModule } from '@angular/material';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CuentaComponent, saveCuenta } from './views/cuenta/cuenta.component';
import { EmpresaComponent } from './views/empresa/empresa.component';
import { BancoComponent, saveBanco } from './views/banco/banco.component';
import { PeriodoComponent } from './views/periodo/periodo.component';
import { MonedaComponent, EliminarMoneda } from './views/moneda/moneda.component';
import { ClasificacionComponent } from './views/clasificacion/clasificacion.component';
import { DocumentoComponent } from './views/documento/documento.component';
import { PaisComponent } from './views/pais/pais.component';
import { TipoempresaComponent } from './views/tipoempresa/tipoempresa.component';
import { MonedaDialogComponent } from './views/moneda/moneda-dialog/moneda-dialog.component';
import { AmChartsModule } from "@amcharts/amcharts3-angular";
import { UsocuentaComponent } from './views/usocuenta/usocuenta.component';
import { ClasificacioncuentaComponent } from './views/clasificacioncuenta/clasificacioncuenta.component';
import { FlujocuentaComponent } from './views/flujocuenta/flujocuenta.component';
import { CuentabancariaComponent, NuevaCuenta } from './views/cuentabancaria/cuentabancaria.component';
import { TipocuentaComponent } from './views/tipocuenta/tipocuenta.component';
import { TipodocumentoComponent, NuevoTipoDocumento } from './views/tipodocumento/tipodocumento.component';
import { RubroComponent, saveRubro } from './views/rubro/rubro.component';
import { DonanteComponent, saveDonante } from './views/donante/donante.component';
import { ConvenioComponent, saveConvenio, actividadConvenio, archivoConvenio, rubroConvenio, desembolsoConvenio } from './views/convenio/convenio.component';
import { ActividadComponent } from './views/actividad/actividad.component';
import { DiarioComponent, saveDiario } from './views/diario/diario.component';
import { ContactoComponent, saveContacto, telefonoContacto, correoContacto } from './views/contacto/contacto.component';
import { EntidadComponent, saveEntidad } from './views/entidad/entidad.component';
import { ProyectoComponent, saveProyecto, actividadProyecto, archivoProyecto, rubroProyecto, desembolsoProyecto } from './views/proyecto/proyecto.component';
import { PuestoComponent, savePuesto } from './views/puesto/puesto.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CuentaComponent,
    EmpresaComponent,
    BancoComponent,
    PeriodoComponent,
    MonedaComponent,
    ClasificacionComponent,
    DocumentoComponent,
    PaisComponent,
    TipoempresaComponent,
    MonedaDialogComponent,
    EliminarMoneda,
    saveBanco,
    saveCuenta,
    UsocuentaComponent,
    ClasificacioncuentaComponent,
    FlujocuentaComponent,
    CuentabancariaComponent,
    TipocuentaComponent,
    NuevaCuenta,
    TipodocumentoComponent,
    NuevoTipoDocumento,
    RubroComponent, saveRubro,
    DonanteComponent, saveDonante,
    ConvenioComponent, saveConvenio, actividadConvenio, ActividadComponent, archivoConvenio, rubroConvenio, desembolsoConvenio, 
    DiarioComponent, saveDiario, 
    ContactoComponent, saveContacto, telefonoContacto, correoContacto, 
    EntidadComponent, saveEntidad, 
    ProyectoComponent, saveProyecto, actividadProyecto, archivoProyecto, rubroProyecto, desembolsoProyecto, 
    PuestoComponent, savePuesto
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule, MatCheckboxModule, MatGridListModule, MatCardModule, MatFormFieldModule, MatIconModule, MatInputModule, MatToolbarModule, MatSidenavModule, MatChipsModule, MatDialogModule, MatMenuModule, MatSlideToggleModule, MatOptionModule, MatSelectModule, MatTableModule, MatTooltipModule, MatAutocompleteModule, MatRadioModule, MatDatepickerModule, MatNativeDateModule, MatTabsModule, MatPaginatorModule,
    FormsModule,
    HttpClientModule,
    AmChartsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [MonedaDialogComponent, EliminarMoneda, saveBanco, saveCuenta, NuevaCuenta, NuevoTipoDocumento,
    saveRubro, saveDonante, saveConvenio, actividadConvenio, archivoConvenio, rubroConvenio, desembolsoConvenio,
    saveDiario, saveContacto, telefonoContacto, correoContacto, saveEntidad,
    saveProyecto, actividadProyecto, archivoProyecto, rubroProyecto, desembolsoProyecto, savePuesto]
})
export class AppModule { }
