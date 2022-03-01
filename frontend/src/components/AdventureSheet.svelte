<script lang="ts">
  import Score from "./Score.svelte";
  import Card from "./Card.svelte";

  import type { Hero } from "../types/types";

  export let hero: Hero;
</script>

<div id="adventure-sheet">
  <h2>Adventure Sheet</h2>
  <div class="container">
    <div class="item-sm">
      <Score title=Skill score={hero.skill} />
    </div>
    <div class="item-sm">
      <Score title=Stamina score={hero.stamina} />
    </div>
    <div class="item-sm">
      <Score title=Luck score={hero.luck} />
    </div>
    <div class="item-lg">
      <Card title=Gold value="{hero.goldPieces}" />
    </div>
    <div class="item-lg">
      <Card title=Provisions value={hero.numberOfMeals.toString()} />
    </div>
  </div>
</div>

<style>
  #adventure-sheet {
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

  .item-sm {
    flex: 1 1 12em;
  }

  .item-lg {
    flex: 2 2 18em;
  }
</style>
