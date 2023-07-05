;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8246)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm8246 0
)

(instance rm8246 of ExitRoom
	(properties
		picture 8246
		south 8243 ; rm8243
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
		(SetFlag 623) ; enable "Do you know anything about the 'new Wagner opera'?" in topic810, enable "Ludwig's letter to Conductor" in topic850
		(gGame changeScore: 998)
	)
)

(instance plaque of GKFeature
	(properties
		modNum 820
		nsLeft 168
		nsTop 19
		nsRight 458
		nsBottom 333
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 62) ; Do
			(= temp0
				(if (IsFlag 643)
					1
				else
					(SetFlag 643)
					0
				)
			)
			(gMessager say: 20 theVerb 0 temp0 0 820)
		else
			(super doVerb: theVerb)
		)
	)
)

