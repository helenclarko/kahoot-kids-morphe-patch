package app.kahoot.patches.kahootkids.premium

import app.morphe.patcher.Fingerprint

// Kahoot! Kids AccountManager methods that determine premium entitlement
// These are the exact methods identified in the security review that control premium access

// The hasFeature(Feature) method that gates ~140+ premium features
object AccountManagerHasFeatureFingerprint : Fingerprint(
    definingClass = "Lno/mobitroll/kahoot/android/account/AccountManager;",
    name = "hasFeature",
    returnType = "Z",
    parameters = listOf("Lno/mobitroll/kahoot/android/account/Feature;"),
)

// The hasFeature(String) method that gates premium features
object AccountManagerHasFeatureStringFingerprint : Fingerprint(
    definingClass = "Lno/mobitroll/kahoot/android/account/AccountManager;",
    name = "hasFeature",
    returnType = "Z",
    parameters = listOf("Ljava/lang/String;"),
)

// The hasActiveStandardSubscription method that drives paywall/trial-CTA display
object AccountManagerHasActiveSubscriptionFingerprint : Fingerprint(
    definingClass = "Lno/mobitroll/kahoot/android/account/AccountManager;",
    name = "hasActiveStandardSubscription",
    returnType = "Z",
    parameters = listOf(),
)

// The hasActiveStandardSubscriptionMatchingAppAndDeviceAppStore method that filters by store
object AccountManagerHasActiveSubscriptionMatchingAppStoreFingerprint : Fingerprint(
    definingClass = "Lno/mobitroll/kahoot/android/account/AccountManager;",
    name = "hasActiveStandardSubscriptionMatchingAppAndDeviceAppStore",
    returnType = "Z",
    parameters = listOf(),
)

// The getProductFromMostPremiumStandardSubscription method that returns effective plan
object AccountManagerGetProductFingerprint : Fingerprint(
    definingClass = "Lno/mobitroll/kahoot/android/account/AccountManager;",
    name = "getProductFromMostPremiumStandardSubscription",
    returnType = "Lno/mobitroll/kahoot/android/account/Product;",
    parameters = listOf(),
)

// The getPlanLogoType method that controls UI plan badge
object AccountManagerGetPlanLogoTypeFingerprint : Fingerprint(
    definingClass = "Lno/mobitroll/kahoot/android/account/AccountManager;",
    name = "getPlanLogoType",
    returnType = "I",
    parameters = listOf(),
)
