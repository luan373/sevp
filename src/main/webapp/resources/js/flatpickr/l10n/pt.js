/* Portuguese locals for flatpickr */
var Flatpickr = Flatpickr || {
	l10ns : {}
};
Flatpickr.l10ns.pt = {};

Flatpickr.l10ns.pt.weekdays = {
	shorthand : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb' ],
	longhand : [ 'Domingo', 'Segunda-feira', 'TerÃ§a-feira', 'Quarta-feira',
			'Quinta-feira', 'Sexta-feira', 'SÃ¡bado' ]
};

Flatpickr.l10ns.pt.months = {
	shorthand : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago',
			'Set', 'Out', 'Nov', 'Dez' ],
	longhand : [ 'Janeiro', 'Fevereiro', 'MarÃ§o', 'Abril', 'Maio', 'Junho',
			'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ]
};
if (typeof module !== "undefined") {
	module.exports = Flatpickr.l10ns;
}
