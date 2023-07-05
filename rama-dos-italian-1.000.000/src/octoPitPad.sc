;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7701)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SaveManager)
(use newYorkRegion)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	octoPitPad 0
)

(local
	[local0 5] = [0 7711 7705 7710 7712]
	local5
)

(instance octoPitPad of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(if (== local5 0)
			(if (== global259 global260)
				(= local5 1)
			else
				(= local5 2)
			)
		)
		(facePit down: faceDown)
		(faceDown up: facePit)
		(switch gPrevRoomNum
			(7700 ; octoPitRoom
				(self addPicObj: facePit faceRoom facePit)
				(if (< local5 3)
					(self setScript: sPadDown)
				)
			)
			(7900 ; octoSubPad
				(= local5 4)
				(self addPicObj: facePit faceRoom facePit)
			)
			(else
				(self addPicObj: faceRoom facePit faceRoom)
			)
		)
	)

	(method (serialize param1 &tmp temp0)
		(if param1
			(super serialize: param1 0)
			(= local5 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local5)
		)
	)

	(method (dispose)
		(= local5 0)
		(super dispose: &rest)
	)
)

(instance faceDown of CameraAngle
	(properties
		edgeW 0
		edgeE 0
		edgeS 0
	)

	(method (init)
		(if (== local5 4)
			(self picture: 7707)
			(exitToPit init:)
			(gCurRoom exitN: exitToPit)
		else
			(self picture: 7709)
		)
		(super init: &rest)
		(SPIKES_180 init:)
	)
)

(instance facePit of CameraAngle
	(properties
		edgeN 0
	)

	(method (init)
		(self picture: [local0 local5])
		(super init: &rest)
		(PIT_0 init:)
		(pad_0 init:)
	)
)

(instance faceRoom of CameraAngle
	(properties
		heading 180
		picture 7706
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(exitToRoom init:)
		(gCurRoom exitN: exitToRoom)
		(eenieTunnel_180 init:)
		(meenieTunnel_180 init:)
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsBottom 253
		nsLeft 180
		nsRight 414
		nsTop 35
		nextRoom 7900
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(proc201_1 18)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance exitToRoom of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7700
	)
)

(instance sPadDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== local5 1)
					(= local5 4)
				else
					(= local5 3)
				)
				(= seconds 3)
			)
			(1
				(gCurRoom drawPic: [local0 local5])
				(facePit picture: [local0 local5])
				(spikeSound init: play: self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance PIT_0 of Feature
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
					init: 80 213 187 184 290 177 411 190 501 226 446 268 285 283 116 265 77 215
					yourself:
				)
		)
	)
)

(instance SPIKES_180 of Feature
	(properties
		noun 9
		nsBottom 268
		nsLeft 47
		nsRight 547
		nsTop 13
	)

	(method (init)
		(super init: &rest)
		(if (== global259 global260)
			(= case 8)
		else
			(= case 7)
		)
		(self setHotspot: 144)
	)
)

(instance pad_0 of Feature
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
					init: 238 290 -2 290 1 209 228 173 228 181 86 207 70 245 140 275 255 290
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 282 171 282 179 434 192 501 217 502 250 460 271 388 284 311 288 589 290 589 218 479 183 374 173 292 171 291 178
					yourself:
				)
		)
	)
)

(instance meenieTunnel_180 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 137 203 140 220 176 124 176 147 138
					yourself:
				)
		)
	)
)

(instance eenieTunnel_180 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 346 170 361 140 420 140 436 180 347 173
					yourself:
				)
		)
	)
)

(instance spikeSound of Sound
	(properties
		number 7700
		flags 5
	)
)

