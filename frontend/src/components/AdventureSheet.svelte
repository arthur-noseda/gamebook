<script lang="ts">
  import Score from "./Score.svelte";
  import Card from "./Card.svelte";

  import type { Hero } from "../types/types";

  export let hero: Hero;
</script>

<div class="sheet">
  <h2>Adventure Sheet</h2>
  <div class="sheet-container">
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
