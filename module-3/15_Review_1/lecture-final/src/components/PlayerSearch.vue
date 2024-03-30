<template>
    <div>
  
        <div id="searchPlayer">
            <label for="">Search Player</label>
            <input type="text" name="playerName" v-model="nameFilter" />
        </div>

        <div class="divTable paleBlueRows">
            <div class="divTableHeading">
                <div class="divTableRow">
                    <div class="divTableHead">Picture</div>
                    <div class="divTableHead">Jersey Number</div>
                    <div class="divTableHead">Full Name</div>
                    <div class="divTableHead">Position</div>
                    <div class="divTableHead">Salary</div>
                    <div class="divTableHead">Stats</div>
                </div>
            </div>
            <div class="divTableBody">
                <div class="divTableRow" v-for="player in filteredPlayers" v-bind:key="player.playerId">
                    <div class="divTableCell">
                        <img id="thumbnail" :src="player.imageURL" alt="">
                    </div>
                    <div class="divTableCell">{{ player.jerseyNumber }}</div>
                    <div class="divTableCell">{{ player.fullName }}</div>
                    <div class="divTableCell">{{ player.positions[0] }}</div>
                    <div class="divTableCell">{{ player.salary }}</div>
                    <div class="divTableCell">coming soon</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {

    data() {
        return {
            nameFilter: ""
        }
    },
    computed: {
        filteredPlayers() {
           const players = this.$store.state.players;

           return players.filter( player => {
               return this.nameFilter == '' ? true : player.fullName.includes(this.nameFilter);
           })
       }
    }

}
</script>

<style scoped>

input[type=text] {
    margin: 10px;
    width: 20%;
    padding: 8px 16px;
    border: 2px solid green;
    border-radius: 5px;
}


#thumbnail {
    width: 100px;
    height: auto;
}

div.paleBlueRows {
    font-family: Tahoma, Geneva, sans-serif;
    border: 1px solid #FFFFFF;
    background-color: #4BC5EE;
    text-align: left;
    width: 100%
}

.divTable.paleBlueRows .divTableCell,
.divTable.paleBlueRows .divTableHead {
    border: 1px solid #FFFFFF;
    padding: 2px 2px;
}

.divTable.paleBlueRows .divTableBody .divTableCell {
    font-size: 13px;
}

.divTable.paleBlueRows .divTableRow:nth-child(even) {
    background: #D0E4F5;
}

.divTable.paleBlueRows .divTableHeading {
    background: #0B6FA4;
    border-bottom: 5px solid #FFFFFF;
}

.divTable.paleBlueRows .divTableHeading .divTableHead {
    font-size: 17px;
    font-weight: bold;
    color: #FFFFFF;
    text-align: center;
    border-left: 2px solid #FFFFFF;
}

.divTable.paleBlueRows .divTableHeading .divTableHead:first-child {
    border-left: none;
}

.paleBlueRows .tableFootStyle {
    font-size: 14px;
}

/* DivTable.com */
.divTable {
    display: table;
}

.divTableRow {
    display: table-row;
}

.divTableHeading {
    display: table-header-group;
}

.divTableCell,
.divTableHead {
    display: table-cell;
}

.divTableHeading {
    display: table-header-group;
}

.divTableFoot {
    display: table-footer-group;
}

.divTableBody {
    display: table-row-group;
}
</style>