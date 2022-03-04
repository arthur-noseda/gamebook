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

<section>
  <div>
    <h2>{entryNumber}</h2>
    <p>{text}</p>
    <div class="actions">
      {#each actions as action}
        <Button action={action} on:action={dispatchAction} />
      {/each}
    </div>
  </div>
</section>
{#if monster != null}
  <MonsterSheet monster={monster} />
{/if}
{#if encounter != null}
  <section>
    <div>
      <h2>Round #{encounter.roundNumber}</h2>
      <p>{encounter.message}</p>
    </div>
  </section>
{/if}
