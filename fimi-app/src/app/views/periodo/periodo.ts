export class Periodo {
    idPeriodo: number;
    anio: number;
    descripcion: string;
    tasa: number;
    detalle: PeriodoDetalle[] = [];
}

export class PeriodoDetalle {
    idPeriodoDetalle: number;
    correlativo: number;
    descripcion: string;
    inicia: Date;
}
