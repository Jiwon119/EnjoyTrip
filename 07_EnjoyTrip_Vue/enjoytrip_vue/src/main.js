// import "./assets/main.css";

import { createApp } from "vue";
// import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";

import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";

// /* import the fontawesome core */
// import { library } from "@fortawesome/fontawesome-svg-core";

// /* import font awesome icon component */
// import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

// /* import specific icons */
// import { faUserSecret } from "@fortawesome/free-solid-svg-icons";
// import { faCampground } from "@fortawesome/free-solid-svg-icons";

// /* add icons to the library */
// library.add(faCampground);

const app = createApp(App);

// app.use(createPinia());
app.use(router);

// app.component("font-awesome-icon", FontAwesomeIcon).mount("#app");
app.mount("#app");
