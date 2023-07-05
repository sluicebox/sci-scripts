;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use IconBar)
(use Feature)
(use Game)
(use Actor)

(class EcoFeature of Feature
	(properties
		lookStr 0
	)

	(method (doVerb theVerb)
		(if (and lookStr (== theVerb 1)) ; Look
			(gDoVerbCode doit: theVerb (CueObj client:) &rest)
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(class EcoView of View
	(properties
		lookStr 0
	)

	(method (doVerb theVerb)
		(if (and lookStr (== theVerb 1)) ; Look
			(gDoVerbCode doit: theVerb (CueObj client:) &rest)
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(class EcoProp of Prop
	(properties
		lookStr 0
	)

	(method (doVerb theVerb)
		(if (and lookStr (== theVerb 1)) ; Look
			(gDoVerbCode doit: theVerb (CueObj client:) &rest)
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(class EcoActor of Actor
	(properties
		lookStr 0
	)

	(method (doVerb theVerb)
		(if (and lookStr (== theVerb 1)) ; Look
			(gDoVerbCode doit: theVerb (CueObj client:) &rest)
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(class ERoom of Rm
	(properties
		lookStr 0
	)
)

(class EcoIconItem of IconI
	(properties
		helpStr 0
	)
)

