;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	gabeRm 0
)

(instance gabeRm of ExitRoom ; "Hunting Lodge: Gabriel's Bedroom"
	(properties
		modNum 540
		noun 1
		picture 5401
		south 5411 ; rm5411
	)

	(method (init)
		(gEgo
			posn: 432 265
			heading: 225
			sel_737:
			setScaler: Scaler 95 75 310 250
			init:
		)
		(super init: &rest)
		(fBed init:)
		(fBathroom init:)
		(fShrank init:)
		(fDoor init:)
		(gGame handsOn:)
	)
)

(instance fWindow of ExitFeature ; UNUSED
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 5411)
		else
			(super doVerb: &rest)
		)
	)
)

(instance fDoor of GKFeature
	(properties
		approachX 547
		approachY 268
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 515 257 515 47 598 35 598 275)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 530) ; hallRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBed of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 0 232 53 261 64 252 95 254 189 243 196 238 204 238 233 231 254 231 263 229 281 230 303 222 346 237 368 230 414 238 459 267 507 288 510 295 554 313 560 306 555 294 566 289 574 295 574 300 570 308 575 313 578 314 0 314
		)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 2 62) ; "(LODGE GABRIEL'S BEDROOM)I'll never be able to sleep in this place. Not without a barricade on the door."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fShrank of GKFeature
	(properties
		approachX 281
		approachY 260
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 234 226 233 30 265 20 364 35 358 41 358 227 302 216)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 628)
			(gCurRoom newRoom: 5440)
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBathroom of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 90 249 90 18 174 32 174 239)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 658)
				(gMessager say: 10 62) ; "(PICK-UP:NEED MORE UPSET/GROSSED OUT, CLICK ON GABRIEL'S BATHROOM AFTER SEEING VON ZELL IN PIT)I'd love to take a bath. I feel like I'm coated with that... that smell. But I have to do somethin' about that cave first."
			else
				(gMessager say: 8 62) ; "(CLICK ON GABRIEL'S BATHROOM)I could use a shower, but I want to look around first."
			)
		else
			(super doVerb: &rest)
		)
	)
)

