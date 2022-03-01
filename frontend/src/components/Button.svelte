<script lang="ts">
  import { createEventDispatcher } from "svelte";

  import type { Action } from "../types/types";

  export let action: Action = { label: "Turn to 243", hash: 1443595956 };

  const dispatch = createEventDispatcher();

  function dispatchAction() {
    dispatch("action", action);
  }
</script>

<button on:click={dispatchAction}>{action.label}</button>

<style>
  button {
    font-size: 1.3em;
    background-color: #BDDC98;
    text-transform: uppercase;
  }
</style>
