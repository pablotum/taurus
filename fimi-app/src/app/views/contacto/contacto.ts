import { Pais } from "../pais/pais";
import { Estadocivil } from "./estadocivil";
import { Sexo } from "./sexo";
import { Contactotelefono } from "./contactotelefono";
import { Contactocorreo } from "./contactocorreo";

export class Contacto {
    idContacto: number;
    codigo: string;
    nombre: string;
    apellido: string;
    casada: string;
    fechaNacimiento: Date;
    direccion: string;
    ciudad: string;
    pais: Pais;
    estado: Boolean;
    sexo: Sexo;
    estadoCivil: Estadocivil
    telefonos: Contactotelefono[] = null;
    correos: Contactocorreo[] = null;
}
