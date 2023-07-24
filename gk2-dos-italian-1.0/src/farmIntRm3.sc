;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2145)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	farmIntRm3 0
)

(instance farmIntRm3 of ExitRoom
	(properties
		picture 2145
		south 2103 ; farmIntRm2
	)

	(method (init)
		(super init: &rest)
		(fCross init:)
		(gGame handsOn:)
	)
)

(instance fCross of GKFeature
	(properties
		noun 23
		modNum 210
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 184 15 417 20 421 99 326 128 330 330 278 334 260 121 182 94
		)
	)
)

