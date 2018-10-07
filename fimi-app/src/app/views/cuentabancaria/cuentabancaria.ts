import { Banco } from "../banco/banco";
import { Moneda } from "../moneda/moneda";
import { Tipocuenta } from "../tipocuenta/tipocuenta";
import { Cuenta } from "../cuenta/cuenta";

export class Cuentabancaria {
    idCuentaBancaria: number;
    cuentaBancaria: string;
    descripcion: string;
    estado: boolean;
    banco: Banco = new Banco();
    moneda: Moneda = new Moneda;
    tipoCuenta: Tipocuenta = new Tipocuenta();
    cuentaContable: Cuenta = null;
}
