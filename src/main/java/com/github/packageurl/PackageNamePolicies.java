package com.github.packageurl;

final class PackageNamePolicies {
    static final PackageNamePolicy PRESERVE = v -> v;

    static final PackageNamePolicy LOWERCASE = v -> v.toLowerCase();

    static final PackageNamePolicy PUB = v ->
        v.toLowerCase().replaceAll("[^a-z0-9_]", "_");

    static final PackageNamePolicy PYPI = v ->
        v.toLowerCase().replace("_", "-");

    private PackageNamePolicies() {}

    static PackageNamePolicy forType(String type) {
    switch (type) {
        case "pub":
            return PUB;
        case "pypi":
            return PYPI;
        case "rpm":
            return PRESERVE;
        default:
            return LOWERCASE;
    }
}
}
