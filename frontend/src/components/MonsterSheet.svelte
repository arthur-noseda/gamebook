<script lang="ts">
  import Score from "./Score.svelte";

  import type { Monster } from "../types/types";

  export let monster: Monster;
</script>

<div class="sheet">
  <h2>Monster Sheet</h2>
  <div class="sheet-container">
    <div class="item-sm">
      <Score title=Skill score={monster.skill} />
    </div>
    <div class="item-sm">
      <Score title=Stamina score={monster.stamina} />
    </div>
  </div>
</div>
