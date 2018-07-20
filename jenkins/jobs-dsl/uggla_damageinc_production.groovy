
multibranchPipelineJob('uggla-damageinc-production') {
  description('Folder for Project uggla-damageinc-production generated and maintained by Forjj. To update it use forjj update')
  branchSources {
      github {
          repoOwner('uggla-damageinc')
          repository('uggla-damageinc-production')
      }
  }
  orphanedItemStrategy {
      discardOldItems {
          numToKeep(20)
      }
  }
}
