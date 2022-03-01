<script lang="ts">
  import { createEventDispatcher } from "svelte";

  import MonsterSheet from "./MonsterSheet.svelte";
  import Button from "./Button.svelte";

  import type { Monster, Encounter, Action } from "../types/types";

  export let entryNumber: number = 103;
  export let text: string = "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet.";
  export let monster: Monster;
  export let encounter: Encounter;
  export let actions: [Action];

  const dispatch = createEventDispatcher();

  function dispatchAction(event: CustomEvent<Action>) {
    const action: Action = { ...event.detail };
		dispatch("action", action);
	}
</script>

<div id="entry">
  <h2>{entryNumber}</h2>
  <p>{text}</p>
  {#if monster != null}
    <MonsterSheet monster={monster} />
  {/if}
  {#if encounter != null}
    <p>Round #{encounter.roundNumber}</p>
    <p>{encounter.message}</p>
  {/if}
  <div class="actions">
    {#each actions as action}
      <Button action={action} on:action={dispatchAction} />
    {/each}
  </div>
</div>

<style>
  #entry {
    margin: 1em;
    text-align: center;
  }

  #entry p {
    margin: 1em 0;
    text-align: justify;
  }
</style>
