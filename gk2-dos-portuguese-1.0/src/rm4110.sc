;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4110)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm4110 0
)

(instance rm4110 of ExitRoom ; "Dienerstrasse"
	(properties
		modNum 410
		noun 4
		picture 4110
		south 410 ; dienerRm
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(fPost init:)
		(fSign init:)
		(gGame handsOn:)
	)
)

(instance fPost of GKFeature
	(properties
		modNum 430
	)

	(method (init)
		(self createPoly: 276 48 276 276 424 295 424 33)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 1 62 0 0 0 410) ; "(DIENERSTRASSE, TRY TO ENTER POST OFFICE)What should I mail?"
			)
			(49 ; invGraceLetter1
				(gMessager say: 7 62 0 0 0 410) ; "(CLICK ONE OF THE LETTERS *TO* GABRIEL ON POST OFFICE)No point in mailin' it back to myself."
			)
			(50 ; invGraceLetter2
				(gMessager say: 7 62 0 0 0 410) ; "(CLICK ONE OF THE LETTERS *TO* GABRIEL ON POST OFFICE)No point in mailin' it back to myself."
			)
			(51 ; invGraceLetter3
				(gMessager say: 7 62 0 0 0 410) ; "(CLICK ONE OF THE LETTERS *TO* GABRIEL ON POST OFFICE)No point in mailin' it back to myself."
			)
			(53 ; invGabeEnvelope1
				(gEgo put: 9) ; invGabeEnvelope1
				(gGame changeScore: 843)
				((gUser BAD_SELECTOR:) BAD_SELECTOR:)
				(PlayScene 66 0 410) ; dienerRm
			)
			(54 ; invGabeEnvelope2
				(gGame changeScore: 949)
				(gEgo put: 31) ; invGabeEnvelope2
				((gUser BAD_SELECTOR:) BAD_SELECTOR:)
				(PlayScene 241 0 410) ; dienerRm
			)
			(else
				(gMessager say: 8 62 0 0 0 410) ; "(CLICK ANY NON-LETTER INVENTORY ITEM ON POST OFFICE)No point in mailin' THAT."
			)
		)
	)
)

(instance fSign of Feature
	(properties
		modNum 410
	)

	(method (init)
		(self createPoly: 451 56 552 54 555 132 451 135)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 5 62 0 0 0 410) ; "(LOOK AT POST OFFICE SIGN)It's a post office."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

