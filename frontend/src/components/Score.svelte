<script lang="ts">
  import { beforeUpdate } from "svelte";
  import { tweened } from "svelte/motion";
  import { cubicOut } from "svelte/easing";

  import Box from "./Box.svelte";

  import type { Score } from "../types/types";

  export let title: string;
  export let score: Score;

  const progress = tweened(score.max, { duration: 400, easing: cubicOut });

  beforeUpdate(() => {
    progress.set(score.current);
  });
</script>

<Box title={title}>
  <div class="initial">Initial {title} = {score.max}</div>
  <div class="current">{score.current}</div>
  <progress max={score.max} value={$progress}>{$progress}</progress>
</Box>

<style>
  .initial {
  	font-size: .8em;
  }

  .current {
    font-size: 1.3em;
    margin-top: 1em;
  }
</style>
