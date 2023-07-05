;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56511)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	vzNightStand 0
)

(instance vzNightStand of ExitRoom
	(properties
		modNum 546
		picture 56511
		south 56501 ; vzRm
	)

	(method (init)
		(super init: &rest)
		(fApptBook init:)
	)
)

(instance fApptBook of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 96 220 93 200 128 174 185 198 187 216 152 242)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (gEgo has: 52) ; invGrossbergLetter
				(gMessager say: 8 62 0 1 0 546) ; "(TRY TO PICK UP VON ZELL'S BOOK AFTER GETTING GROSSBERG'S LETTER, CH 5 LODGE, DRY)I don't think there's much else of interest in von Zell's little black book."
			else
				(PlayScene 667 0 56513) ; vzApptBook
			)
		)
		(super doVerb: theVerb)
	)
)

