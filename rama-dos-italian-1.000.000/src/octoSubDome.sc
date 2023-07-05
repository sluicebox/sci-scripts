;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7904)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SaveManager)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoSubDome 0
)

(local
	local0
	[local1 2] = [7920 7921]
	[local3 2] = [7917 7918]
	local5
	local6 = -1
)

(procedure (localproc_0 &tmp temp0)
	(while (== (= temp0 (Random 1 32)) global259)
	)
	(= global259 temp0)
)

(instance octoSubDome of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(faceStation up: faceUpN)
		(faceMap up: faceUpN)
		(facePit up: faceUpN)
		(faceE up: faceUpN)
		(switch gPrevRoomNum
			(7903 ; octoSubDoor
				(self addPicObj: faceStation faceMap facePit faceE faceStation)
			)
			(7905 ; octoSubMapCU
				(self addPicObj: faceMap facePit faceE faceStation faceMap)
				(= local5 1)
			)
			(7906 ; octoSubStation
				(self addPicObj: facePit faceE faceStation faceMap facePit)
			)
			(else
				(self addPicObj: faceStation faceMap facePit faceE faceStation)
			)
		)
		(if (== local5 0)
			(proc201_1 20)
			(gCurRoom setScript: sPadDown)
		)
	)

	(method (pitch param1)
		(switch param1
			(1
				(self setPicObj: local0)
			)
			(-1
				(self setPicObj: faceUpN)
			)
		)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
			(= local5 (SaveManager readWord:))
			(switch (= local6 (SaveManager readWord:))
				(180
					(= local0 faceStation)
				)
				(90
					(= local0 faceE)
				)
				(270
					(= local0 faceMap)
				)
				(0
					(= local0 facePit)
				)
				(else
					(= local0 0)
				)
			)
		else
			(super serialize: param1)
			(SaveManager writeWord: local5)
			(SaveManager writeWord: (local0 heading:))
		)
	)

	(method (dispose)
		(= local5 0)
		(= local0 0)
		(= local6 -1)
		(super dispose: &rest)
	)
)

(instance faceUpN of CameraAngle
	(properties
		heading 90
		picture 7924
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(= down local0)
		(outerWheel init: global117)
		(innerWheel init: global117)
		(super init: &rest)
		(COLORWHEEL_90 init:)
	)
)

(instance faceStation of CameraAngle
	(properties
		heading 180
		edgeS 0
	)

	(method (init)
		(= picture [local1 local5])
		(= local0 self)
		(exitToStation init:)
		(gCurRoom exitN: exitToStation)
		(super init:)
		(PAD_180 init:)
	)
)

(instance facePit of CameraAngle
	(properties
		edgeS 0
	)

	(method (init)
		(= picture [local3 local5])
		(= local0 self)
		(exitToPit init:)
		(gCurRoom exitN: exitToPit)
		(super init: &rest)
		(PAD_180 init:)
		(pitPad_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 7919
		edgeS 0
	)

	(method (init)
		(= local0 self)
		(super init: &rest)
		(PAD_180 init:)
	)
)

(instance faceMap of CameraAngle
	(properties
		heading 270
		picture 7922
		edgeS 0
	)

	(method (init)
		(= local0 self)
		(if (IsFlag 195)
			(light init: global117 setCycle: Fwd cycleSpeed: 15)
		)
		(super init: &rest)
		(MAP_270 init:)
		(PAD_180 init:)
		(exitToMap init:)
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsBottom 251
		nsLeft 209
		nsRight 401
		nsTop 111
		nextRoom 7903
	)
)

(instance exitToStation of ExitFeature
	(properties
		nsBottom 253
		nsLeft 213
		nsRight 406
		nsTop 110
		nextRoom 7906
	)
)

(instance exitToMap of Feature
	(properties
		nsBottom 234
		nsLeft 222
		nsRight 376
		nsTop 138
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7905) ; octoSubMapCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sPadDown of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local5 1)
				(localproc_0)
				(= seconds 1)
			)
			(1
				(= temp0 (gCurRoom picObj:))
				(temp0 init:)
				(padDownSnd init: play: self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance light of Prop
	(properties
		x 285
		y 142
		loop 1
		view 7915
	)
)

(instance outerWheel of View
	(properties
		x 179
		y 268
		loop 1
		view 7900
	)

	(method (init)
		(= cel (mod global259 8))
		(super init: &rest)
	)
)

(instance innerWheel of View
	(properties
		x 219
		y 228
		view 7900
	)

	(method (init)
		(= cel (/ global259 8))
		(super init: &rest)
	)
)

(instance COLORWHEEL_90 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 142 216 55 298 20 391 63 423 147 386 230 306 266 216 236 178 143
					yourself:
				)
		)
	)
)

(instance PAD_180 of Feature
	(properties
		noun 25
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 48 288 298 256 565 288 39 289
					yourself:
				)
		)
	)
)

(instance MAP_270 of Feature
	(properties
		noun 62
		nsBottom 207
		nsLeft 224
		nsRight 377
		nsTop 115
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pitPad_0 of Feature
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
					init: 215 175 298 170 384 177 309 192 212 182
					yourself:
				)
		)
	)
)

(instance padDownSnd of Sound
	(properties
		number 7100
		flags 5
	)
)

