;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2114)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm2114 0
)

(instance rm2114 of ExitRoom
	(properties
		south 2103 ; farmIntRm2
	)

	(method (init)
		(if (gEgo has: 4) ; invGabeWallet
			(= picture 2144)
		else
			(= picture 2111)
		)
		(super init: &rest)
		(fStuff init:)
		(gGame handsOn:)
	)
)

(instance fStuff of GKFeature
	(properties
		modNum 210
		sceneNum 7
		nextRoomNum 2103 ; farmIntRm2
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 279 0 550 0 588 65 590 277 427 259 276 332 196 331 187 303 226 141
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (gEgo has: 4) ; invGabeWallet
				(gMessager say: 20 62 0 1 0 210) ; "(LOOKING IN DUFFEL BAG)I don't need anythin' else right now."
			else
				(gEgo get: 4 get: 3 get: 1 get: 2) ; invGabeWallet, invRitterDagger, invGraceLetter1, invUbergrauLetter
				(PlayScene 7 0 2103) ; farmIntRm2
			)
		else
			(super doVerb: theVerb)
		)
	)
)

