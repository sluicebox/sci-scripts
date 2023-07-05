;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6405)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Compass)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	avianBackStage2 0
)

(instance avianBackStage2 of Location
	(properties)

	(method (init)
		(Load rsAUDIO 603)
		(Load rsAUDIO 602)
		(super init:)
		(if (not (IsFlag 132))
			(avianFlying open:)
		)
		(faceE up: faceUpE)
		(faceUpE down: faceE)
		(self addPicObj: faceE faceS faceW faceN faceE)
	)

	(method (dispose)
		(if (not (IsFlag 132))
			(avianFlying close:)
		)
		(SetFlag 133)
		(super dispose: &rest)
	)

	(method (yaw param1)
		(switch param1
			(-1
				(if (and (== heading 0) (not (IsFlag 132)))
					(SetFlag 132)
					(avianFlying play:)
				)
			)
			(1
				(if (and (== heading 180) (not (IsFlag 132)))
					(SetFlag 132)
					(avianFlying play:)
				)
			)
		)
		(super yaw: param1)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6424
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(octospiderKey init:)
		(costMyrm_180 init:)
		(costumeRacks_180 init:)
		(gourds_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6426
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6425
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(eastExitToBackStage1 init:)
		(gCurRoom exitN: eastExitToBackStage1)
		(doorBkStgOut_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6422
		heading 90
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 132))
			(gCurRoom setScript: squakScript)
		)
	)
)

(instance faceUpE of CameraAngle
	(properties
		picture 6423
		heading 90
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(if (and (IsFlag 132) (not (IsFlag 133)))
			(Compass update:)
			(SetFlag 133)
			(avianWalkOut play:)
		)
		(super init: &rest)
		(doorAbove_90_up init:)
	)
)

(instance avianFlying of VMDMovie
	(properties
		movieName 6425
		endPic 6422
		cacheSize 500
	)

	(method (play)
		(Compass update:)
		(super play: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(octospiderKey dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianWalkOut of VMDMovie
	(properties
		movieName 6423
		frameRate 15
		endPic 6423
	)
)

(instance squak of Sound
	(properties
		number 603
	)
)

(instance squakScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(squak play: self)
			)
			(1
				(squak number: 602 play: self)
			)
			(2
				(squak dispose:)
			)
		)
	)
)

(instance eastExitToBackStage1 of ExitFeature
	(properties
		nsLeft 253
		nsTop 114
		nsRight 336
		nsBottom 199
		nextRoom 6404
	)
)

(instance octospiderKey of View
	(properties
		x 362
		y 173
		view 6401
		cel 1
	)

	(method (init)
		(if (== (proc70_9 91) 6405)
			(super init: global117)
			(self setHotspot: 2)
			(costumeOct_180 init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 91)
				(costumeOct_180 dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance costumeOct_180 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 328 122 351 113 376 123 370 180 338 179
					yourself:
				)
		)
	)
)

(instance costMyrm_180 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 421 113 438 77 474 77 493 111 469 172 447 169
					yourself:
				)
		)
	)
)

(instance costumeRacks_180 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 75 145 63 177 93 159 184 116 187
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 210 115 244 92 271 124 256 174 228 176
					yourself:
				)
		)
	)
)

(instance doorBkStgOut_270 of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 282 122 310 124 328 179 313 193 279 191 265 178
					yourself:
				)
		)
	)
)

(instance doorAbove_90_up of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 284 7 355 11 397 107 379 113 271 117 244 108
					yourself:
				)
		)
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
					init: 300 166 312 167 312 180 299 179
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 385 170 425 168 422 184 384 184
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 483 183 516 176 549 182 546 205 485 202
					yourself:
				)
		)
	)
)

