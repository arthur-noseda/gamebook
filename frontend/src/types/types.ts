export type Score = {
  max: number;
  current: number;
}

export type Hero = {
  skill: Score;
  stamina: Score;
  luck: Score;
  goldPieces: string;
  numberOfMeals: number;
}

export type Monster = {
  skill: Score;
  stamina: Score;
}

export type Encounter = {
  roundNumber: number;
  message: string;
}

export type Action = {
  label: string;
  hash: number;
}

export type HalLink = {
  href: string;
}

export type HalLinks = {
   [s: string]: HalLink;
}

export enum Method {
  GET = "GET",
  POST = "POST",
  PUT = "PUT",
  DELETE = "DELETE",
  PATCH = "PATCH"
}

export type Property = {
  name: string;
  required?: boolean;
  type: string;
}

export type Template = {
  method: Method;
  contentType: string;
  properties: [Property];
}

export type Templates = {
  [s: string]: Template;
}

export type Adventure = {
  hero: Hero;
  entryNumber: number;
  text: string;
  monster: Monster;
  encounter: Encounter;
  actions: [Action];
  _links: HalLinks;
  _templates: Templates;
}
