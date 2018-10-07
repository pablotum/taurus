import { Cuentabancaria } from "../cuentabancaria/cuentabancaria";
import { Cuenta } from "../cuenta/cuenta";

export class Tipodocumento {
    idTipoDocumento: number;
    tipoDocumento: string;
    descripcion: string;
    estado: Boolean;
    abreviatura: string;
    cuentaBancaria: Cuentabancaria;
    operacion: number;
    cuentaContable: Cuenta;
    contraPartida: Cuenta;
}
