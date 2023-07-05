;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use Feature)
(use Actor)

(class Sq4Feature of Feature
	(properties
		lookStr 0
	)

	(method (doVerb theVerb)
		(if (and lookStr (== theVerb 1)) ; Look
			(gNarrator say: lookStr)
		else
			(gDoVerbCode doit: theVerb)
		)
	)
)

(class Sq4View of View
	(properties
		lookStr 0
	)

	(method (doVerb theVerb)
		(if (and lookStr (== theVerb 1)) ; Look
			(gNarrator say: lookStr)
		else
			(gDoVerbCode doit: theVerb)
		)
	)
)

(class Sq4Prop of Prop
	(properties
		lookStr 0
	)

	(method (doVerb theVerb)
		(if (and lookStr (== theVerb 1)) ; Look
			(gNarrator say: lookStr)
		else
			(gDoVerbCode doit: theVerb)
		)
	)
)

(class Sq4Actor of Actor
	(properties
		lookStr 0
	)

	(method (doVerb theVerb)
		(if (and lookStr (== theVerb 1)) ; Look
			(gNarrator say: lookStr)
		else
			(gDoVerbCode doit: theVerb)
		)
	)
)

