;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2103)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Osc)
(use Feature)
(use Cursor)
(use Actor)
(use System)

(public
	farmIntRm2 0
)

(instance farmIntRm2 of ExitRoom ; "Huber Farm Interior"
	(properties
		modNum 210
		noun 14
		picture 2103
		south 210 ; farmIntRm
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2145 ; farmIntRm3
				(gEgo posn: 262 313 heading: 135)
			)
			(2114
				(gEgo posn: 262 313 heading: 135)
			)
			(210 ; farmIntRm
				(gEgo posn: 262 313 heading: 45)
			)
			(else
				(gEgo posn: 72 349 heading: 135)
				(Lock 140 210 1) ; WAVE
				(gGk2Music setLoop: -1 number: 210 play:)
			)
		)
		(gEgo sel_737: setScaler: Scaler 95 54 362 272 init:)
		(vBlanket init:)
		(pClock init: setCycle: Osc cycleSpeed: 12)
		(fCrucifix init:)
		(fBag init:)
		(fDoor init:)
		(fChina init:)
		(gGame handsOn:)
		(gUser canControl: 0)
	)
)

(instance fDoor of GKFeature
	(properties
		noun 24
		modNum 210
		sightAngle 180
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 75 113 160 122 160 278 74 303)
	)
)

(instance fChina of GKFeature
	(properties
		noun 25
		modNum 210
		sightAngle 180
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 367 261 366 281 350 279 356 132 448 127 454 283 437 292 433 264
		)
	)
)

(instance fCrucifix of GKFeature
	(properties
		modNum 210
		x 227
		y 274
		BAD_SELECTOR 2145
	)

	(method (init)
		(super init:)
		(self createPoly: 192 130 210 123 227 138 213 180 201 185)
	)
)

(instance fBag of GKFeature
	(properties
		modNum 210
		x 370
		y 313
	)

	(method (init)
		(super init: &rest)
		(if (gEgo has: 4) ; invGabeWallet
			(= sightAngle 360)
		)
		(self createPoly: 364 290 374 266 397 265 430 270 433 290 415 302)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(1
					(PlayScene 6 0 2114) ; rm2114
				)
				(else
					(gMessager say: 20 62 0 1 0 210) ; "(LOOKING IN DUFFEL BAG)I don't need anythin' else right now."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vBlanket of View
	(properties
		y 333
		view 30004
	)

	(method (init)
		(super init: &rest)
		(GKHotCursor delete: self)
	)
)

(instance pClock of Prop
	(properties
		sightAngle 360
		x 32
		y 123
		view 30004
		loop 1
	)

	(method (init)
		(super init:)
		((gUser sel_715:) delete: self)
	)
)

(instance sTickTock of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1)
		)
	)
)

