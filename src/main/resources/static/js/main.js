var vueInstance = new Vue({
    el : '#main-container',
    data : {
        content: 'Human <3',
        rawHtml: 'ab',
        isListView : true
    },
    methods : {
        say : function(text){
            return 'Alien love ' + text
        },
        addNewEvent : function () {
            this.isListView = !this.isListView
        }
    },
    computed : {
        objClass(){
            return {
                a : true,
                b : true
            }
        }
    }
})