<script lang="ts">
  import Score from "./Score.svelte";

  import type { Monster } from "../types/types";

  export let monster: Monster;
</script>

<div id="monster-sheet">
  <h2>Monster Sheet</h2>
  <div class="container">
    <div class="item">
      <Score title=Skill score={monster.skill} />
    </div>
    <div class="item">
      <Score title=Stamina score={monster.stamina} />
    </div>
  </div>
</div>

<style>
  #monster-sheet {
    background: #F7EAD9;
    font-family: Roboto;
    padding: .5em;
    text-align: center;
    text-transform: uppercase;
  }

  .container {
    display: flex;
    flex-wrap: wrap;
  }

  .container > * {
    border: 1px solid black;
    margin: .5em;
    padding: 1em;
  }

  .item {
    flex: 1 1 12em;
  }
</style>
