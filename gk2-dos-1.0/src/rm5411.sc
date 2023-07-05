;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5411)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	rm5411 0
)

(instance rm5411 of ExitRoom
	(properties
		modNum 540
		picture 5411
		south 540 ; gabeRm
	)

	(method (init)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 5441 5442)
			(Lock 140 250 0) ; WAVE
			(gSoundManager play: 521 522 523 524)
		)
		(fWindow init:)
		(gGame handsOn:)
	)
)

(instance fWindow of GKFeature
	(properties
		modNum 540
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 125 -1 534 0 530 293 124 294)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 629 0 5441) ; rm5441
		else
			(super doVerb: &rest)
		)
	)
)

