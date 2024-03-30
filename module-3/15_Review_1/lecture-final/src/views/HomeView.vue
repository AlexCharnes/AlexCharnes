<template>
  <div class="big-image">
    <div class="overlay">
        <h1>Java Bluebirds Baseball</h1>
        <p>Beating .NET is like taking candy from a baby!</p>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

   h1 {
    font-size: 3em;
   }
  .big-image {
    height: 100vh;
    width: 100vw;
    position: relative;
    background-size: cover;
    background-position: 50% 50%;
    background-image: url('https://res.cloudinary.com/drr6cwmiz/image/upload/v1711552221/java-bluebirds-main_xabqpf.png');
  }

  .overlay {
    position: absolute;
    height: 100%;
    width: 100%;
    top: 0;
    left: 0;
    background: rgb(0,0,0,0.65);
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
  }
</style>