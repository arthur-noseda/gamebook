<script lang="ts">
  import { onMount } from "svelte";

  import axios from "axios";

  import AdventureSheet from "./components/AdventureSheet.svelte";
  import Entry from "./components/Entry.svelte";

  import { Action, Adventure, Method } from "./types/types";

  const url: string = "http://localhost:8081/adventures";
  let adventure: Adventure;

  onMount(async () => {
    const res = await axios.get<Adventure>(url,
      {
        headers: {
          'Accept': 'application/prs.hal-forms+json',
        }
      });
    adventure = res.data;
  });

  async function update(event: CustomEvent<Action>) {
    const self = Object.entries(adventure._links)
      .filter(([rel, _]) => rel === "self")
      .map(([_, link]) => link)[0].href;
    const defaultTemplate = Object.entries(adventure._templates)
      .filter(([name, _]) => name === "default")
      .map(([_, template]) => template)[0];
    if (defaultTemplate.method === Method.POST) {
      const res = await axios.post<Adventure>(self,
        { ...event.detail },
        {
          headers: {
            'Content-Type': defaultTemplate.contentType,
            'Accept': 'application/prs.hal-forms+json',
          }
        });
      adventure = res.data;
    }
  }
</script>

<main>
  {#if adventure}
    <AdventureSheet hero={adventure.hero} />
    <Entry
      entryNumber={adventure.entryNumber}
      text={adventure.text}
      monster={adventure.monster}
      encounter={adventure.encounter}
      actions={adventure.actions}
      on:action={update} />
  {/if}
</main>

<style>
  main {
    max-width: 240px;
    margin: 0 auto;
  }

  @media (min-width: 640px) {
    main {
      max-width: none;
    }
  }
</style>
