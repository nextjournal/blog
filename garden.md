# 🌱 Clerk Garden Blossoms
```clojure
(ns nextjournal.blog.garden
  {:nextjournal.clerk/visibility {:code :hide}}
  (:require [nextjournal.clerk :as clerk]))

```
_Published Feburary 28, 2023 written by [Martin Kavalar](https://github.com/mk)_

Today we're launching Clerk Garden – a simple publishing service for Clerk notebooks.

Clerk's static publishing can turn a Clojure Namespace into a webpage. Garden leverages that and combines it with a tiny convention in your `deps.edn` file to enable building and publishing that webpage on clerk.garden.

For the impatient just head over to [clerk.garden](https://clerk.garden) to try it or check out this video.

```clojure
(clerk/html
 [:div.not-prose
  [:video {:loop true :controls true}
   [:source {:src "https://nextjournal.com/data/QmPr3enFNSYkv911j2DgMpATnr2eyiR8efWJTevvstfd7f?content-type=video/mp4&node-id=51e404c0-4c60-4272-a9e1-5744d43914f5&filename=Garden+Build.mp4&node-kind=file"}]]])
```

Clerk and Garden is all about letting us build upon tools we use as Clojure developers. Clerk lets folks continue to use their favorite editors and Garden builds on top of git for source control and `deps.edn` for declaring dependencies.

## 🥱 YAML "programming"

We've grown tired of debugging CI builds by fiddling with YAML files and only seeing the effects on somebody else's computer after demoralizing, minute-long feedback cycles. With Clerk and Garden you don't need to deal with any of this. 

## 🎛 Live Feedback

You can live-program your build at the REPL on your local machine until you get what you expect, it's just a Clojure function call. 

Once this works, you'll add this as `:nextjournal/clerk` alias to your `deps.edn` file and make sure it still works by calling `clj -X:nextjournal.clerk :browse true` and only then should you push the results.

Enter the repo name on [clerk.garden](https://clerk.garden) and we'll build the latest git sha for the default branch for you. You can also trigger builds using a [simple HTTP API](#citation-needed).

## ⚡️Fast By Default

Garden is fast by default. We keep the caches for both Maven and Clerk around, without you needing to configure anything. 

We've got Cloudflare's CDN in front of Garden's web server to keep load times down. Cache headers are handled for you.

## 🧶 Debuggable

Clojure and the JVM already protect us from most *works on my machine* problems so we've found it to be rare that a build fails on Garden after succeeding locally.

But when that happens, we provide you with [garden-env](https://github.com/nextjournal/garden-env), a [Nix](https://nixos.org) environment that allows you to get all the same dependencies environment locally.

Please avoid mutable `SNAPSHOT` or `RELEASE` modifiers so we're able to reproducibly compute the same classpath you've used in your local build.

## 🛖 Upcycling

We're hosting Garden on our own hardware. It's currently running on an eight-year old HP server with 24 cores and 128GB of RAM. It's nice to put this old [Sauspiel](https://nextjournal.com/about) hardware to some good use and while keeping the operating costs down. We'll continue to move more of Nextjournal off Google Cloud onto our own metal in the coming months. Running on a single instance also makes keeping the Maven and Clerk caches around easy.

[Cloud Hypervisor](https://www.cloudhypervisor.org) is the virtualisation layer for Garden, giving us the good isolation of VMs while keeping the overhead at a minimum.

## 🧑‍🌾 Onwards

We're excited about this first step and have lots of plans for the future. Note that [Clerk's website](https://clerk.vision), [Garden's homepage](https://clerk.garden) and this blog are built with Clerk and Garden. You can see some of the upcoming features like Custom Domains and Clerk's server-side rendering and CSS compilation in action today.

Head over to [clerk.garden](https://clerk.garden) to play with it and or join us on #clerk-garden on Clojurians Slack, we'd love to hear from you! 

