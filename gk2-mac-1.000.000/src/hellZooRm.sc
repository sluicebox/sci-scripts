;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	hellZooRm 0
)

(local
	local0 = 1
)

(instance hellZooRm of ExitRoom ; "Zoologischer Garten M\81nchen: Kennels"
	(properties
		noun 17
		picture 2301
		south 200 ; MunichMapRm
	)

	(method (init)
		(self setRegions: 2299) ; zooRegion
		(cond
			((and (IsFlag 421) (gEgo has: 13)) ; invKlingmannReceipt
				(fZooOffice init:)
			)
			((IsFlag 103) ; "Doktor Klingmann" in rm2316
				(fWest init:)
			)
		)
		(super init: &rest)
		(gGame handsOn: 0)
		(switch gPrevRoomNum
			(2316
				(gEgo posn: 317 317 heading: 315)
			)
			(2315
				(gEgo posn: 317 317 heading: 315)
			)
			(2341
				(gEgo posn: 374 370 heading: 315)
			)
			(200 ; MunichMapRm
				(gEgo posn: 271 350 heading: 45)
				(gSoundManager play: 0 230 231 232 233)
				(if (not (IsFlag 441))
					(PlayScene 26)
					(SetFlag 441)
				)
			)
			(else
				(gEgo posn: 317 317 heading: 315)
				(gSoundManager play: 0 230 231 232 233)
			)
		)
		(gEgo normalize: setScaler: Scaler 100 54 375 253 init:)
		(fAdmin init:)
		(fSign init:)
		(fToKennel init:)
		(fKennelArea init:)
		(if (IsFlag 40)
			(ClearFlag 443)
		)
		(if
			(and
				(== gChapter 1)
				(IsFlag 430)
				(IsFlag 432)
				(not (IsFlag 443))
				(not (IsFlag 40))
				(not (IsFlag 437))
				(not (== gPrevRoomNum 2316))
			)
			(ThomasEnter setReal: ThomasEnter 3)
		else
			(if (or (IsFlag 443) (== gPrevRoomNum 2316))
				(pThomas init: setScript: sThomasFidget)
				(if (<= ((ScriptID 2299 1) seconds:) 0) ; ThomasLeaveTimer
					((ScriptID 2299 1) setReal: (ScriptID 2299 1) 10) ; ThomasLeaveTimer, ThomasLeaveTimer
				)
			)
			(gGame handsOn: 0)
		)
	)

	(method (newRoom newRoomNumber)
		(ThomasEnter dispose:)
		(StopRobot 0 0)
		(if (OneOf newRoomNumber 200 240) ; MunichMapRm, zooOfficeRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (notify)
		(super notify: &rest)
		(if (and (== 0 (gEgo cel:)) (gCast contains: pThomas))
			(pThomas dispose:)
			(ClearFlag 443)
			(gCurRoom setScript: sThomasLeaves)
		)
		(ThomasEnter setReal: ThomasEnter 30)
	)
)

(instance sThomasEnter of Script
	(properties)

	(method (changeState newState)
		(if (== 0 (gEgo cel:))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(PlayRobot 11027 0 120 self)
				)
				(1
					(SetFlag 443)
					(pThomas init: setScript: sThomasFidget)
					(gGame handsOn: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sThomasLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(PlayRobot 12027 0 106 self)
			)
			(1
				(gGame handsOn: 0)
				(self dispose:)
			)
		)
	)
)

(instance fWest of ExitFeature
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		x 63536
		y 250
		exitDir 6
	)

	(method (doVerb)
		(PlayScene 1042 0 240) ; zooOfficeRm
	)
)

(instance ThomasEnter of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: sThomasEnter)
		((ScriptID 2299 1) setReal: (ScriptID 2299 1) 60) ; ThomasLeaveTimer, ThomasLeaveTimer
	)
)

(instance fSign of GKFeature
	(properties
		x 627
		y 349
		nextRoomNum 2341 ; rm2341
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 616 170 560 170 548 264 616 278)
	)
)

(instance fToKennel of ExitFeature
	(properties
		x 110
		y 187
		nextRoomNum 2317 ; rm2317
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 112 192 114 100 80 91 80 170)
	)
)

(instance fAdmin of GKFeature
	(properties
		noun 22
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 103) ; "Doktor Klingmann" in rm2316
			(= noun 23)
		)
		(if (IsFlag 420)
			(= noun 24)
		)
		(self createPoly: 184 176 274 177 274 199 185 200)
	)

	(method (doVerb theVerb)
		(gGame handsOff:)
		(cond
			((gTimers contains: (ScriptID 2299 1)) ; ThomasLeaveTimer
				(if (< ((ScriptID 2299 1) seconds:) 10) ; ThomasLeaveTimer
					((ScriptID 2299 1) setReal: (ScriptID 2299 1) 15) ; ThomasLeaveTimer, ThomasLeaveTimer
				)
			)
			((and (gTimers contains: ThomasEnter) (< (ThomasEnter seconds:) 10))
				(ThomasEnter setReal: ThomasEnter 15)
			)
		)
		(super doVerb: theVerb)
		(gGame handsOn: 0)
	)
)

(instance fKennelArea of GKFeature
	(properties
		x 627
		y 211
		nextRoomNum 2315 ; rm2315
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 454 144 380 146 390 180 550 204 558 170 608 170 548 146
		)
	)
)

(instance fZooOffice of ExitFeature
	(properties
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 2 50 2 50 328 0 328)
		(= sightAngle 360)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (== gChapter 5)
				(gMessager say: 7 62) ; "(TRY TO GO TO KLINGMANN'S OFFICE CH 5)Klingmann's office is locked. Maybe I'll see him at the huntin' lodge."
			else
				(gMessager say: 1 62) ; "(TRY TO GO TO KLINGMANN'S OFFICE CH 3)Klingmann's office is locked."
			)
		)
	)
)

(instance pThomas of Prop
	(properties
		sightAngle 45
		x 109
		y 289
		view 20027
		cel 6
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 40))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((IsFlag 40)
					(gMessager say: 27 62) ; "(TRY TO TALK TO THOMAS WITH NO DIALOGUE LEFT)I can't think of anything else to ask."
				)
				((IsFlag 418)
					(PlayScene 32 0 2316) ; rm2316
				)
				(else
					(PlayScene 31 0 2316) ; rm2316
					(SetFlag 418)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 12 30))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance sThomasFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 9))
			)
			(1
				(if (== local0 0)
					(pThomas cel: 0 setLoop: (Random 0 1) 1)
				)
				(pThomas setCycle: End self)
				(= local0 0)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

