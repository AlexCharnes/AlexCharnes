<template>
    <div id="container">
        <img src="https://res.cloudinary.com/drr6cwmiz/image/upload/v1711554775/logo-transparent_mj2yng.png" alt="">
        <!-- <h1 id="siteTitle">{{title}}</h1> -->
        <nav>
            <router-link v-bind:to="{ name: 'home' }">Home</router-link>
            <router-link v-bind:to="{ name: 'about' }">About</router-link>
            <router-link v-bind:to="{ name: 'search' }">Search Players</router-link>
           
        </nav>
    </div>
</template>

<script>
export default {

    data() {
        return {
            title: 'Java BlueBirds Baseball'
        }
    }

}
</script>

<style scoped>
  #siteTitle {
    text-align: center;
  }

  img {
    width: 10%;
    height:auto;
  }

  #container {
    display: flex;
    justify-content: space-around;
    align-items: center;
    width: 100%;
    border-bottom: 10px solid rgb(13, 21, 139);
    background-color: cornflowerblue;
    
  }

  nav a {
    margin: 5px;
    padding: 13px 25px;
    background-color: rgb(13, 21, 139);
    color: white;
    border-radius: 6px;
}

</style>