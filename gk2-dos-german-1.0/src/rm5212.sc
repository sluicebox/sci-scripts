;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5212)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Motion)
(use Actor)

(public
	rm5212 0
)

(instance rm5212 of ExitRoom
	(properties
		modNum 520
		picture 5212
		south 520 ; greatRm
	)

	(method (init)
		(super init: &rest)
		(fFireplace init:)
		(if
			(and
				(IsFlag 655)
				(IsFlag 656)
				(gEgo has: 52) ; invGrossbergLetter
				(not (gEgo has: 51)) ; invMatches
				(IsFlag 685)
				(not (IsFlag 658))
				(IsFlag 657)
			)
			(vMatches init:)
		)
		(if (IsFlag 659)
			(pFire init: setCycle: Fwd)
		)
		(gGame handsOn:)
	)
)

(instance pFire of Prop
	(properties
		noun 3
		modNum 520
		x 182
		y 333
		view 20521
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; invMatches
			(gMessager say: 5 21 0 0 0 520) ; "(USE MATCHING ON BURNING FIRE)It's already lit."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vMatches of View
	(properties
		x 427
		y 168
		view 30611
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 611)
			(gEgo get: 51) ; invMatches
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fFireplace of GKFeature
	(properties)

	(method (init)
		(super init:)
		(self
			createPoly: 110 302 106 223 114 184 86 182 82 177 82 165 88 158 126 151 150 0 464 0 484 148 532 156 536 160 536 170 532 180 504 180 504 199 510 213 504 235 506 247 500 252 500 283 510 302
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 659)
					(gMessager say: 3 62 0 1 0 520) ; "(LOOK AT LIT FIRE)That fire feels good."
				else
					(gMessager say: 4 62 0 1 0 520) ; "(LOOK AT FIREPLACE BEFORE FIRE IS LIT)I wish someone would start a fire."
				)
			)
			(21 ; invMatches
				(gMessager say: 5 21 0 1 0 520) ; "(USE MATCHING ON BURNING FIRE)It's already lit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

