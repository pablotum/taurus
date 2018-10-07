import { Cuenta } from "../cuenta/cuenta";

export class Diariodetalle {
    asiento: number;
    idDiarioDetalle: number;
    cuentaContable: Cuenta;
    debe: number;
    haber: number;
}
