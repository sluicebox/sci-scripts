;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3340)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm3340 0
)

(instance rm3340 of ExitRoom ; "Von Glower's House"
	(properties
		modNum 330
		noun 3
		picture 3340
		south 330 ; vgHouseRm
	)

	(method (init)
		(super init: &rest)
		(fMask init:)
	)
)

(instance fMask of GKFeature
	(properties
		modNum 330
	)

	(method (init)
		(self
			createPoly: 234 4 186 28 152 105 190 194 238 225 378 225 430 172 464 120 460 60 378 0
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (not (IsFlag 511))
				(SetFlag 511)
				(gGame changeScore: 956)
				(gMessager say: 6 62 0 0 0 330) ; "(PICUP, LOOK AT MASK VON GLOWER'S HOUSE, TO VON GLOWER)Interestin'. Is it African?"
			else
				(gMessager say: 2 62 0 0 0 330) ; "(PICKUP, VON GLOWER'S HOUSE. LOOKING AT MASK SECOND TIME)Von Glower says it's Indian."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

