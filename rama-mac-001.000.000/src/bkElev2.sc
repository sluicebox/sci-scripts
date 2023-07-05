;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4131)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use Button)
(use n1111)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	bkElev2 0
)

(local
	local0
)

(instance bkElev2 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceElev faceOut faceElev)
		(if (and (== gPrevRoomNum 108) (IsFlag 35)) ; matrixPuzzle
			(ClearFlag 35)
		)
	)
)

(instance faceElev of CameraAngle
	(properties
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(self showBlack: 1)
		(if (IsFlag 37)
			(elevButton init: global117 setHotspot: 2)
			(ELEVBUTN_0 init:)
			(if
				(and
					(!= (proc70_9 41) 4008)
					(!= (proc70_9 42) 4008)
					(!= (proc70_9 43) 4008)
				)
				(= picture 4155)
				(jewel1 init:)
				(jewel2 init:)
				(jewel3 init:)
				(jewels_180 init:)
			else
				(= picture 4051)
			)
		else
			(= picture 4049)
		)
		(exitToMatrix init: setHotspot: 2)
		(super init: &rest)
		(ELEV_0 init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		edgeN 0
		edgeS 0
	)

	(method (init)
		(switch global269
			(2
				(= picture 4153)
			)
			(3
				(if (IsFlag 41)
					(= picture 4215)
				else
					(= picture 4214)
				)
			)
		)
		(self showBlack: 1)
		(super init: &rest)
		(exitOut init:)
		(gCurRoom exitN: exitOut)
	)
)

(instance jewel1 of View
	(properties
		x 283
		y 156
		view 4150
		cel 4
	)

	(method (init)
		(if (IsFlag 42)
			(super init: global117 &rest)
		)
	)
)

(instance jewel2 of View
	(properties
		x 296
		y 156
		view 4150
		cel 5
	)

	(method (init)
		(if (IsFlag 43)
			(super init: global117 &rest)
		)
	)
)

(instance jewel3 of View
	(properties
		x 290
		y 139
		view 4150
		cel 6
	)

	(method (init)
		(if (IsFlag 44)
			(super init: global117 &rest)
		)
	)
)

(instance elevButton of Button
	(properties
		x 337
		y 184
		view 4150
		upLoop 0
		upCel 2
		downLoop 0
		downCel 3
	)

	(method (init)
		(super init: global117 &rest)
		(&= signal $efff)
	)

	(method (handleEvent event)
		(if
			(and
				(gTheCursor isInvCursor:)
				(== 114 (proc70_7 (gTheCursor invItem:)))
			)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (gTheCursor isInvCursor:))
					(super doVerb: theVerb)
				)
			)
			(2
				(switch global269
					(2
						(SoundManager
							fadeMusic: 0 20 10 1 0
							playMusic: 0 -1 7000 7150 7200
						)
						(= global269 3)
						(proc1111_29 gCurRoomNum)
						(gCurRoom setScript: sElevRide)
					)
					(3
						(SoundManager
							fadeMusic: 0 20 10 1 0
							playMusic: 0 -1 6010 6020
						)
						(= global269 2)
						(proc1111_29 gCurRoomNum)
						(gCurRoom setScript: sElevRide)
					)
					(else
						(PrintDebug {bkLevel is incorrect!!})
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sElevRide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(elevLightsLeft init: global117)
				(elevLightsRight init: global117)
				(= global266 -1)
				(= global267 -1)
				(= global268 -1)
				(= global245 0)
				(= global246 0)
				(= global247 0)
				(= global248 0)
				(= global249 0)
				(= global207 0)
				(= local0 5)
				(= cycles 1)
			)
			(1
				(switch global269
					(2
						(elevLightsRight
							setCel: (elevLightsRight lastCel:)
							setCycle: Beg self
						)
						(elevLightsLeft
							setCel: (elevLightsLeft lastCel:)
							setCycle: Beg
						)
					)
					(3
						(elevLightsLeft cel: 0 setCycle: End self)
						(elevLightsRight cel: 0 setCycle: End)
					)
				)
			)
			(2
				(if (-- local0)
					(= state 0)
				)
				(= ticks 1)
			)
			(3
				(elevLightsRight dispose:)
				(elevLightsLeft dispose:)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance exitToMatrix of Feature
	(properties
		nsLeft 269
		nsTop 138
		nsRight 312
		nsBottom 225
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if
					(and
						(IsFlag 37)
						(!= (proc70_9 41) 4008)
						(!= (proc70_9 42) 4008)
						(!= (proc70_9 43) 4008)
					)
					(gCurRoom newRoom: 4132) ; bkJewelsCU
				else
					(gCurRoom newRoom: 108) ; matrixPuzzle
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitOut of ExitFeature
	(properties
		nsLeft 243
		nsTop 125
		nsRight 348
		nsBottom 249
	)

	(method (init)
		(switch global269
			(2
				(= nextRoom 4113)
			)
			(3
				(= nextRoom 4204)
			)
		)
		(super init: &rest)
	)
)

(instance elevLightsLeft of Prop
	(properties
		x 160
		y 211
		view 4150
		loop 1
		cycleSpeed 1
	)
)

(instance elevLightsRight of Prop
	(properties
		x 358
		y 191
		view 4150
		loop 2
		cycleSpeed 1
	)
)

(instance ELEV_0 of Feature
	(properties
		noun 21
		nsLeft 42
		nsTop 5
		nsRight 535
		nsBottom 180
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ELEVBUTN_0 of Feature
	(properties
		noun 59
		nsLeft 334
		nsTop 182
		nsRight 366
		nsBottom 213
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance jewels_180 of Feature
	(properties
		noun 61
		nsLeft 267
		nsTop 135
		nsRight 316
		nsBottom 187
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

