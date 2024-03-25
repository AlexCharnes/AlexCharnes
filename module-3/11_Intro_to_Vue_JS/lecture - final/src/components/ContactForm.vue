<template>
    <div class="contact">
        <h1>Contact Form</h1>
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" v-model="personName">
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="text" id="email" v-model="emailAddress">
        </div>
        <div>
            <label for="emailType"></label>
            <select id="emailType" v-model="emailType">
                <option value="HOME">Home</option>
                <option value="WORK">Work</option>
                <option value="OTHER">Other</option>
            </select>
        </div>
        <div>
            <p>Person name: {{ personName }}</p>
            <p>Email Address: {{ emailAddress }}</p>
            <p>Email Type: {{ emailType }}</p>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            personName: "",
            emailAddress: "",
            emailType: 'WORK'
        }
    }
}
</script>

<style>
div.contact { 
    margin-bottom: 100px;
}
div.contact div {
    margin: 20px;
}
div.contact label {
    display: inline-block;
    width: 100px;
}
</style>