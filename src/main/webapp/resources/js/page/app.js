/* ##### JQUERY START ##### */
$(document).ready(function () {
    setTimeout(function () {
        $(".button-collapse").sideNav();
        $('body').addClass('loaded');
    }, 200);
});

/* ##### MENSAGENS TOAST ##### */
function MessagemSucessoToastDefault() {
    MessagemSucessoToast('Salvo com sucesso!');
}

function MessagemSucessoToast(texto) {
    Materialize.toast('<i class="material-icons">done</i>&nbsp;&nbsp;' + texto, 2000, 'green accent-4');
}

function MessagemErroToastDefault() {
    MessagemErroToast('Ocorreu um erro!');

}

function MessagemErroToast(texto) {
    Materialize.toast('<i class="material-icons">error_outline</i>&nbsp;&nbsp;' + texto, 2000, 'red darken-4');
}

function MessagemAvisoToastDefault() {
    MessagemAvisoToast('Atenção!');
}

function MessagemAvisoToast(texto) {
    Materialize.toast('<i class="material-icons">report_problem</i>&nbsp;&nbsp;' + texto, 2000, 'black-text yellow accent-2')
}