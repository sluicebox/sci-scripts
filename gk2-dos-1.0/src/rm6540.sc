;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6540)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm6540 0
)

(instance rm6540 of ExitRoom
	(properties
		picture 6540
		south 650 ; ravineRm
	)

	(method (init)
		(super init: &rest)
		(fRavine init:)
		(gGame handsOn:)
	)
)

(instance fRavine of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 91 0 61 96 142 172 295 168 314 128 406 136 470 175 548 131 595 69 526 0
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 2 62 0 1 0 650) ; "The ravine's pretty deep. I don't think I can cross it."
		else
			(super doVerb: &rest)
		)
	)
)

