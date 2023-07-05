;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6606)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)

(public
	avianSchool07 0
)

(local
	local0
)

(instance avianSchool07 of Location
	(properties)

	(method (init)
		(super init:)
		(faceN down: faceDownN)
		(faceDownN up: faceN)
		(switch gPrevRoomNum
			(6511 ; mirmicatHall2
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(6510 ; mirmicatHall1
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(6611 ; avianMirmicatDesk
				(switch global164
					(270
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(90
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
					(else
						(self addPicObj: faceS faceW faceN faceE faceS)
					)
				)
			)
			(6612 ; avianSchoolElevator
				(switch global164
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(270
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
					(else
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
				)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
		(if (not (IsFlag 126))
			(Load rsAUDIO 6611)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(if local0
					(projectorSound number: 6611 loop: 1 play:)
				)
				(switch picObj
					(faceS
						(rightSouthMural init: global117)
						(leftSouthMural init: global117)
					)
					(faceW
						(westMural init: global117)
					)
				)
			)
			(26
				(if local0
					(projectorSound number: 6900 loop: 1 play:)
					(proc1111_31 39 12)
					(= local0 0)
				)
				(switch picObj
					(faceS
						(rightSouthMural dispose:)
						(leftSouthMural dispose:)
					)
					(faceW
						(westMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 315
		picture 6623
		edgeS 0
		edgeN 0
	)

	(method (init)
		(rampExit init:)
		(gCurRoom exitN: rampExit)
		(super init:)
		(ramp_315 init:)
		(desks_315 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 45
		picture 6624
		edgeS 0
		edgeN 0
	)

	(method (init)
		(projectorBtn init:)
		(super init:)
		(murals_45 init:)
		(desks_45 init:)
		(podium_45 init:)
	)

	(method (dispose)
		(projectorBtn dispose:)
		(super dispose:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 90
		picture 6625
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(mural_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 225
		picture 6622
		edgeS 180
		edgeN 0
	)

	(method (init)
		(super init:)
		(SoundManager playMusic: 0 -1 6020)
		(elevHandle init:)
		(shaft_225 init:)
	)
)

(instance faceDownN of CameraAngle
	(properties
		heading 225
		picture 6622
		edgeW 0
		edgeE 0
		edgeS 0
		showBlack 1
	)

	(method (init)
		(if (IsFlag 125)
			(= picture 6561)
		else
			(= picture 6560)
		)
		(super init:)
		(ropeDown init:)
	)
)

(instance rope of View
	(properties
		noun 45
		x 122
		y 204
		view 6600
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance elevHandle of Feature
	(properties
		nsBottom 204
		nsLeft 137
		nsRight 223
		nsTop 62
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 125)
			(rope init: global117)
			(self setHotspot: 2)
		else
			(Load rsAUDIO 6606)
			(self setHotspot: 24)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 13)
				(gCurRoom newRoom: 6510) ; mirmicatHall1
			)
			(24
				(installRope play:)
				(rope init: global117)
				(proc70_3 2)
				(self setHotspot: 2)
				(SetFlag 125)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance projectorBtn of Feature
	(properties
		nsBottom 88
		nsLeft 347
		nsRight 375
		nsTop 65
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
		(if (not (IsFlag 126))
			(Load rsVIEW 6626)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (not (IsFlag 126))
					(= local0 1)
					(gCurRoom setScript: (ScriptID 100 0)) ; eatMelonScr
					(SetFlag 126)
				else
					(projectorClick play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightSouthMural of View
	(properties
		x 379
		y 132
		loop 2
		cel 8
		view 6626
	)
)

(instance leftSouthMural of View
	(properties
		x 134
		y 139
		loop 2
		cel 7
		view 6626
	)
)

(instance westMural of View
	(properties
		x 72
		y 232
		loop 1
		cel 9
		view 6626
	)
)

(instance rampExit of ExitFeature
	(properties
		nsBottom 234
		nsLeft 243
		nsRight 383
		nsTop 104
		nextRoom 6610
	)
)

(instance projectorSound of Sound
	(properties
		number 6611
		flags 5
	)
)

(instance projectorClick of Sound
	(properties
		number 6900
		flags 5
	)
)

(instance ropeDown of Feature
	(properties
		nsBottom 265
		nsLeft 120
		nsRight 296
		nsTop 113
	)

	(method (init)
		(if (IsFlag 125)
			(super init:)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 13)
				(gCurRoom newRoom: 6510) ; mirmicatHall1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance installRope of Sound
	(properties
		number 6606
		flags 5
	)
)

(instance podium_45 of Feature
	(properties
		noun 42
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 171 152 204 73 244 74 240 84 344 84 344 74 383 71 421 158 380 237 226 249 199 183 170 186 166 152 204 76
					yourself:
				)
		)
	)
)

(instance murals_45 of Feature
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
					init: 124 68 128 63 208 60 214 74 205 76 194 100 132 106 125 101
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 373 76 373 66 376 59 455 61 462 69 460 99 441 102 394 97 385 77 374 75
					yourself:
				)
		)
	)
)

(instance ramp_315 of Feature
	(properties
		noun 44
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 261 173 320 172 335 182 347 223 423 293 176 293 245 231 245 176 263 172
					yourself:
				)
		)
	)
)

(instance desks_315 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 425 123 395 106 412 93 442 80 463 71 487 69 493 78 513 83 514 80 533 65 565 64 573 81 549 97 567 100 589 100 588 136 542 136 503 110 484 97 465 107 457 123 411 122 398 107
					yourself:
				)
		)
	)
)

(instance shaft_225 of Feature
	(properties
		noun 43
		x 278
		y 109
		nsBottom 218
		nsLeft 112
		nsRight 445
		nsTop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mural_90 of Feature
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
					init: 59 174 62 163 175 164 189 173 200 220 195 235 85 227 76 219
					yourself:
				)
		)
	)
)

(instance desks_45 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 14 186 88 162 114 157 164 145 165 164 148 179 115 190 57 202 29 207 9 197
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 428 147 463 153 514 166 570 180 568 207 529 201 476 196 422 164
					yourself:
				)
		)
	)
)

