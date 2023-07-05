;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6200)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use RegionSFX)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	avianGreatHall1 0
)

(instance avianGreatHall1 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6201 ; avianGreatHall2
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(if (proc1111_24 128)
					(SoundManager
						short_Delay: 0
						long_Delay: 0
						playSounds:
							((RegionSFX new:)
								number: 6219
								setVol: 100
								yourself:
							)
					)
				)
				(self addPicObj: faceN faceS faceN)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(switch global243
					(2
						(= global243 3)
					)
				)
			)
			(66
				(switch global243
					(3
						(= global243 4)
					)
					(4
						(= global243 0)
					)
				)
			)
			(25
				(if (== heading 0)
					(leftFrontMural init: global117)
					(rightFrontMural init: global117)
					(leftBackMural init: global117)
					(rightBackMural init: global117)
				)
			)
			(26
				(if (== heading 0)
					(leftFrontMural dispose:)
					(rightFrontMural dispose:)
					(leftBackMural dispose:)
					(rightBackMural dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6202
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 128)
			(= picture 6202)
			(dHDoorOut_180 init:)
		else
			(= picture 6222)
			(dHDoorOut_180 init:)
			(avianGuard_180 init:)
		)
		(gCurRoom exitN: southExitToTunnel)
		(southExitToTunnel init:)
		(super init:)
		(gourds_180 init:)
		(doorNumbers_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6201
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			((not (IsFlag 127))
				(switch global243
					(0
						(= picture 6226)
					)
					(1
						(= picture 6225)
					)
					(else
						(= picture 6226)
					)
				)
				(avian_0 init:)
			)
			((not (IsFlag 128))
				(gCurRoom setScript: avianWaitingAtElevatorScript)
			)
		)
		(northExit init:)
		(gCurRoom exitN: northExit)
		(super init:)
		(perches_0 init:)
		(muralsGH_0 init:)
		(gourds_0 init:)
	)

	(method (dispose)
		(if (not (IsFlag 128))
			(= global161
				(if gAutoRobot
					(Robot 11) ; FrameNum
				else
					0
				)
			)
			(proc1111_6)
			(avianWaitingAtElevatorScript dispose:)
		)
		(super dispose: &rest)
	)
)

(instance northExit of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 6201
	)
)

(instance southExitToTunnel of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 6003
		exitStyle 13
	)

	(method (doVerb theVerb)
		(SetFlag 130)
		(switch theVerb
			(9
				(if (not (IsFlag 128))
					(avianGuard play:)
				else
					(SoundManager short_Delay: 5 long_Delay: 10 stopSounds: 1)
					(= global161 0)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianGuard of VMDMovie
	(properties
		movieName 6207
	)
)

(instance avianWaitingAtElevatorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 6222 292 114 global161 0 -1 1 self)
			)
			(1
				(= global161 0)
				(= seconds (Random 2 8))
				(= state -1)
			)
		)
	)
)

(instance leftFrontMural of View
	(properties
		x 110
		y 148
		view 6201
	)
)

(instance leftBackMural of View
	(properties
		x 215
		y 181
		cel 1
		view 6201
	)
)

(instance rightFrontMural of View
	(properties
		x 409
		y 146
		cel 3
		view 6201
	)
)

(instance rightBackMural of View
	(properties
		x 357
		y 181
		cel 2
		view 6201
	)
)

(instance perches_0 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 152 2 251 -1 258 16 247 22 262 50 232 70 137 4
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 343 -1 456 2 361 74 331 61 328 46 344 22 333 14
					yourself:
				)
		)
	)
)

(instance muralsGH_0 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 38 180 71 199 147 91 179
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 212 83 237 96 241 135 213 140
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 360 92 378 83 376 139 350 135
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 413 71 488 42 499 173 394 147
					yourself:
				)
		)
	)
)

(instance elevatorGH_0 of Feature ; UNUSED
	(properties
		noun 64
		x 295
		y 56
		nsBottom 113
		nsLeft 290
		nsRight 301
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance dHDoorOut_180 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 255 48 337 52 369 185 338 213 256 218 223 180
					yourself:
				)
		)
	)
)

(instance avianGuard_180 of Feature
	(properties
		noun 17
		x 301
		y 143
		nsBottom 214
		nsLeft 262
		nsRight 340
		nsTop 72
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance gourds_180 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 239 27 238 29 263 4 270
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 202 220 229 219 229 243 205 244
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 392 217 415 219 416 247 391 245
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 441 220 459 221 460 248 434 246
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 516 228 540 230 538 263 509 257
					yourself:
				)
		)
	)
)

(instance avian_0 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 289 116 317 149 352 344 yourself:)
		)
	)
)

(instance gourds_0 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 50 126 75 123 94 188 81 190
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 121 164 93 106 132 67 122 163 132 167 136 175 130 176
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 138 59 171 66 161 137 174 154 174 164 169 159
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 501 188 503 121 546 91 513 188
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 479 180 478 91 499 68 522 82 494 162 483 182
					yourself:
				)
		)
	)
)

(instance doorNumbers_180 of Feature
	(properties
		noun 55
		x 296
		y 26
		nsBottom 40
		nsLeft 252
		nsRight 340
		nsTop 12
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

