;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4031)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use Button)
(use n1111)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	bkElev1 0
)

(local
	local0
)

(instance bkElev1 of Location
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
		picture 4049
		edgeN 0
		edgeS 0
		showBlack 1
	)

	(method (init)
		(self showBlack: 1)
		(if (IsFlag 36)
			(elevButton init: global117 setHotspot: 2)
			(= picture 4051)
			(ELEVBUTN_0 init:)
		else
			(= picture 4049)
		)
		(exitToMatrix init: setHotspot: 2)
		(matrixPzl_0 init:)
		(super init: &rest)
		(ELEV_0 init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		heading 180
		edgeN 0
		edgeS 0
		showBlack 1
	)

	(method (init)
		(self showBlack: 1)
		(switch global269
			(1
				(= picture 4053)
			)
			(2
				(if (IsFlag 40)
					(= picture 4101)
				else
					(door2Mus_180 init:)
					(= picture 4114)
				)
			)
		)
		(super init: &rest)
		(exitOut init:)
		(gCurRoom exitN: exitOut)
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
					(1
						(elevLightsRight
							setCel: (elevLightsRight lastCel:)
							setCycle: Beg self
						)
						(elevLightsLeft
							setCel: (elevLightsLeft lastCel:)
							setCycle: Beg
						)
					)
					(2
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
					(1
						(= global269 2)
						(proc1111_29 gCurRoomNum)
						(SoundManager
							fadeMusic: 0 20 10 1 0
							playMusic: 0 -1 6010 6020
						)
						(gCurRoom setScript: sElevRide)
					)
					(2
						(SoundManager
							fadeMusic: 0 20 10 1 0
							playMusic: 0 -1 8001 8000
						)
						(= global269 1)
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

(instance exitToMatrix of Feature
	(properties
		nsLeft 270
		nsTop 150
		nsRight 318
		nsBottom 236
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 108) ; matrixPuzzle
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
		exitStyle 256
	)

	(method (init)
		(switch global269
			(1
				(= nextRoom 4013)
			)
			(2
				(= nextRoom 4104)
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

(instance matrixPzl_0 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 263 122 295 132 327 120 325 181 313 184 312 230 278 232 278 178 262 181
					yourself:
				)
		)
	)
)

(instance door2Mus_180 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 255 169 262 101 261 83 289 88 291 72 302 71 303 88 328 86 327 98 334 116 335 173
					yourself:
				)
		)
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

