;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2101)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Osc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	CPIceport2 0
)

(instance CPIceport2 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2100 ; CPIceport1
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2102 ; CPIceport3
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance showBrownNicoleVideo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if ((ScriptID 200 0) script:) ; cplainRegion
					((ScriptID 200 0) setScript: 0) ; cplainRegion
				)
				(brownExplains play: self)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance brownNicoleTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(tryingToLeaveIceport play: self)
			)
			(2
				(gGame handsOn:)
				(= start state)
				(nicoleFidget init: global117 setCycle: Beg)
				(brownFidget init: global117 setCycle: Beg self)
			)
			(3
				(nicoleFidget setCycle: Osc -1)
				(brownFidget setCycle: Osc -1)
			)
		)
	)
)

(instance brownStandsGuardAlone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(brownStopsUserAlone play: self)
			)
			(2
				(gCurRoom setPicObj: faceN)
				(gGame handsOn:)
				(= start state)
				(self dispose:)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2405
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2102 init:)
		(if (not (SetFlag 74))
			(gCurRoom setScript: showBrownNicoleVideo)
			(= showBlack 1)
		)
		(super init: &rest)
		(sea_0 init:)
		(horns_0 init:)
		(pillar_0 init:)
		(port_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2406
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(= showBlack 1)
		(cond
			((not (IsFlag 74))
				(defaultExit nextRoom: 2100 init:)
			)
			((IsFlag 74)
				(cond
					(
						(and
							(not (IsFlag 72))
							(!= (brownNicoleTalk start:) 0)
						)
						(= picture 37039)
					)
					((and (IsFlag 72) (IsFlag 77))
						(= picture 2406)
						(= showBlack 0)
						(defaultExit nextRoom: 2100 init:)
					)
				)
			)
		)
		(super init: &rest)
		(if (IsFlag 74)
			(cond
				((not (IsFlag 72))
					(gCurRoom setScript: brownNicoleTalk)
				)
				((not (SetFlag 77))
					(gCurRoom setScript: brownStandsGuardAlone)
				)
			)
		)
		(sea_90 init:)
		(lights_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2407
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2408
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(sea_270 init:)
		(lights_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)

	(method (doVerb theVerb)
		(if (and (== theVerb 9) (IsFlag 77) (== nextRoom 2100))
			(gGame autoSave: 1)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance brownExplains of VMDMovie
	(properties
		movieName 37011
		endPic 37019
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 1500)
			(= preLoadPCT 90)
		)
		(super play: &rest)
		(proc70_1 20 0)
	)
)

(instance tryingToLeaveIceport of VMDMovie
	(properties
		movieName 37031
		endPic 37039
	)
)

(instance brownStopsUserAlone of VMDMovie
	(properties
		movieName 38451
		endPic 38459
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 1200)
			(= preLoadPCT 100)
		)
		(super play: &rest)
	)
)

(instance nicoleFidget of Prop
	(properties
		x 82
		y 290
		view 37039
		cel 15
	)
)

(instance brownFidget of Prop
	(properties
		x 166
		y 291
		view 37039
		loop 1
		cel 15
	)
)

(instance sea_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 461 -1 591 -1 591 37 538 29 530 20 505 6 482 10 462 3
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 18 218 22 192 30 169 28
					yourself:
				)
		)
	)
)

(instance sea_90 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 74 -2 132 -2 114 28 104 24
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 5
		nsLeft 120
		nsTop 20
		nsRight 470
		nsBottom 33
		x 295
		y 26
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_0 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 74 -2 98 41 134 83 175 113 223 134 271 143 322 144 384 129 434 103 467 76 494 45 509 21 520 -2 592 -1 593 20 545 38 517 43 487 69 464 99 427 126 408 125 404 151 395 169 169 169 154 159 119 147 107 134 84 119 54 106 35 97 15 106 0 101 -5 -1
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 2
		nsLeft 266
		nsTop 32
		nsRight 322
		nsBottom 87
		x 294
		y 59
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pillar_0 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 217 173 218 162 228 150 228 126 247 126 250 148 259 163 259 173
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 396 169 395 163 404 151 407 127 428 125
					yourself:
				)
		)
	)
)

(instance port_0 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 171 172 159 164 403 163 371 182 179 180
					yourself:
				)
		)
	)
)

