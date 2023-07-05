;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use PolyPath)
(use Feature)

(class NewFeature of Feature
	(properties
		normal 1
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(not normal)
				(& (event type:) evVERB)
				(self onMe: event)
				(& _approachVerbs (gKq6ApproachCode doit: (event message:)))
			)
			(CueObj state: 0 cycles: 0 client: self theVerb: (event message:))
			(self doSpecial: (CueObj theVerb:))
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (doSpecial)
		(self cue:)
	)

	(method (cue)
		(gEgo setMotion: PolyPath approachX approachY CueObj)
	)
)

