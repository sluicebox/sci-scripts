;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 651)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use huntRegion)
(use Scaler)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	hravineRm 0
)

(instance GunTimer of Timer
	(properties)

	(method (cue)
		(Lock 140 602 0) ; WAVE
		(Lock 140 603 0) ; WAVE
		(gGk2Sound client: 0 stop:)
		(PlayScene 694 0 666) ; uDie
	)
)

(instance hravineRm of ExitRoom
	(properties
		modNum 600
		picture 6502
	)

	(method (init)
		(self setRegions: 499) ; huntRegion
		(if (== gPrevRoomNum 666) ; uDie
			(Palette 2 0 255 0) ; PalIntensity
			(= picture -1)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 666) ; uDie
			(proc11_13)
		)
		(if (!= global136 651)
			(gEgo
				posn: 437 253
				heading: 180
				normalize:
				setScaler: Scaler 86 58 282 201
				init:
			)
			(fNorthExit init:)
			(PlayScene 692)
		else
			(PlayScene 693)
			(if (== gPrevRoomNum 666) ; uDie
				(gCurRoom drawPic: 6502 -1 1)
			)
			(pVonGlower init: setScript: FidgetScript)
			((ScriptID 499 3) ; pWolf
				view: 201
				loop: 3
				cel: 0
				posn: 266 265
				setScaler: Scaler 82 79 271 264
				setScript: sWolfFidget
				init:
			)
			(gEgo
				view: 22697
				cel: 4
				loop: 0
				posn: 378 262
				setScale: 0
				setScaler: 0
				setScript: sFidget
				get: 81 ; invGun
				init:
			)
			(gCurInvView select: 81)
			(gGame disableInventory: 1)
			(GunTimer setReal: GunTimer 10)
		)
		(fRavine init:)
		(gGame handsOn:)
	)

	(method (newRoom)
		(GunTimer dispose:)
		(super newRoom: &rest)
	)
)

(instance fRavine of GKFeature
	(properties
		noun 20
		modNum 600
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 101 278 221 297 390 299 499 273 477 332 111 331)
	)
)

(instance fNorthExit of HuntExit
	(properties
		approachX 250
		nextRoomNum 611 ; hwoods3Rm
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 137 198 111 -3 507 -1 448 217)
	)
)

(instance pVonGlower of Prop
	(properties
		sightAngle 360
		x 220
		y 221
		view 20697
	)

	(method (doVerb theVerb)
		(if (== theVerb 135) ; invGun
			(PlayScene 698)
			(gEgo
				view: 22697
				cel: 4
				loop: 0
				posn: 378 262
				setScale: 0
				setScaler: 0
				setScript: sFidget
			)
			(gCurInvView select: 81)
			(gGame disableInventory: 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 3))
			)
			(1
				(gEgo cel: 4 setCycle: CT 8 1 self)
			)
			(2
				(= seconds (Random 2 4))
			)
			(3
				(gEgo cel: 8 setCycle: CT 4 -1 self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sWolfFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 499 3) cel: 0 loop: 3 setCycle: End self) ; pWolf
			)
			(1
				(= seconds (Random 1 2))
			)
			(2
				((ScriptID 499 3) loop: 3 setCycle: Beg self) ; pWolf
			)
			(3
				(= seconds (Random 1 2))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

