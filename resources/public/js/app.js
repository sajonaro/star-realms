var vue = new Vue({
    el: "#app",
    data: {
      username: ""
    },
    methods: {
      login: function () {
        console.log(this.username);
      }
    }
  });