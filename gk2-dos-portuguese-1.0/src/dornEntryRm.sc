;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2502)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	dornEntryRm 0
)

(instance dornEntryRm of ExitRoom
	(properties
		modNum 250
		picture 2503
	)

	(method (init)
		(super init: &rest)
		(fixEgo doit:)
		(pDorn init: setScript: sDornFidget)
		(fSouthExit init:)
		(gCurRoom setScript: sDornScript)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 200) ; MunichMapRm
			(Lock 140 250 0) ; WAVE
			(gGk2Music stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		nsTop 309
		nsRight 638
		nsBottom 333
		sightAngle 360
		BAD_SELECTOR 4
	)

	(method (doVerb)
		(PlayScene 585 0 200) ; MunichMapRm
	)
)

(instance pDorn of Prop
	(properties
		modNum 250
		sightAngle 360
		x 295
		y 162
		view 21580
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 586)
				(fixEgo doit:)
			)
			(17 ; invGabeWallet
				(gMessager say: 1 14 0 1 0 250) ; "(USE WALLET ON DORN)I don't have anything LIKE 14,000 D.M. in my wallet."
			)
			(114 ; invDornMoney
				(SetFlag 687)
				(gEgo put: 46) ; invDornMoney
				(Lock 140 250 0) ; WAVE
				(gGk2Music stop:)
				(PlayScene 587 0 260) ; dornIntRm
			)
			(else
				(gMessager say: 2 0 0 1 0 250) ; "(TRY TO GIVE DORN SOMETHING OTHER THAN MONEY)I don't think he'll take a trade."
			)
		)
	)
)

(instance sDornScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds 20)
			)
			(1
				(PlayScene 584 0 200) ; MunichMapRm
			)
		)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 8 16))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sDornFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(pDorn cel: 0 setCycle: End)
				(= seconds (Random 2 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance fixEgo of Code
	(properties)

	(method (doit)
		(gEgo
			setScale: 0
			view: 23580
			setLoop: 0 1
			cel: 0
			posn: 485 231
			init:
			setScript: sFidget
		)
	)
)

