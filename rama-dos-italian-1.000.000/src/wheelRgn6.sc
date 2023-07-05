;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2015)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SaveManager)
(use SoundManager)
(use cplainRegion)
(use n1111)
(use VMDMovie)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	wheelRgn6 0
)

(local
	local0
	local1
)

(instance wheelRgn6 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(self addPicObj: faceN faceS faceN)
		((ScriptID 200 0) addMigrant: 51) ; cplainRegion
		(if local0
			(SoundManager stopSounds:)
		)
		(= local1 0)
	)

	(method (dispose)
		(if local0
			(SetFlag 66)
		)
		(super dispose: &rest)
	)

	(method (serialize param1 &tmp [temp0 6])
		(if (and argc param1)
			(super serialize: param1)
			(= local0 (SaveManager readWord:))
			(= local1 1)
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2217
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			((and local0 (not (IsFlag 66)))
				(= picture 2228)
				(gCurRoom
					setScript:
						(avianWaits next: 0 start: -1 cycles: 1 yourself:)
				)
				(if (OneOf (proc70_9 1) -2 -3)
					(avianWaits next: 1)
				)
			)
			((and (not local0) (IsFlag 66))
				(= picture 2299)
			)
			(
				(and
					(IsFlag 61)
					(not (IsFlag 66))
					(not local0)
					(not (OneOf (proc70_9 1) -2 -3))
				)
				(= picture 2298)
				(gCurRoom setScript: avianStuck)
			)
		)
		(super init: &rest)
		(if (and (== (proc70_9 17) -1) (!= (proc70_9 1) -2))
			(crowBar init: global117)
		)
		(if (== picture 2298)
			(avianBird init:)
		)
		(avianRing init: global117)
		(if (not (IsFlag 62))
			(if (== picture 2217)
				(sparks loop: 1 x: 320 y: 236)
			else
				(sparks loop: 2 x: 318 y: 239)
				(wireFeature_0 init:)
			)
			(sparks init: global117)
		else
			(wireFeature_0 init:)
		)
		(ruinBiot_0 init:)
		(sea_0 init:)
		(if (not (SetFlag 63))
			(gCurRoom setScript: puckSpeaks)
		)
	)

	(method (dispose)
		(gCurRoom setScript: 0)
		(proc1111_6)
		(super dispose:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 135
		picture 2218
		edgeS 0
		edgeN 0
	)

	(method (init)
		(laserExit_135 init:)
		(super init: &rest)
		(still_135 init:)
		(laser_135 init:)
		(matrixB11z init: global117)
	)
)

(instance defaultExit of ExitFeature ; UNUSED
	(properties)
)

(instance crowBar of View
	(properties
		x 55
		y 274
		view 2217
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 17 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sparks of Prop
	(properties
		view 2217
	)

	(method (init)
		(super init: &rest)
		(self setScript: sparksFly)
	)
)

(instance wires of View ; UNUSED
	(properties
		x 21
		y 25
		loop 2
		view 2217
	)

	(method (init)
		(if (not (IsFlag 62))
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
		(if (not cel)
			(self setHotspot: 80)
		)
	)
)

(instance avianBird of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 353 125 353 101 395 86 416 106 424 121 475 130 491 150 477 176 442 178 451 206 425 202 405 205 413 223 422 251 397 257 387 252 375 231 346 177 343 128
					yourself:
				)
			setHotspot: 45 16
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(proc1111_31 12)
			)
			(45
				(if (IsFlag 62)
					(if (== (gCurRoom script:) avianStuck)
						(gGame handsOff:)
						((gCurRoom script:) next: freeAvian)
					else
						(gCurRoom setScript: freeAvian)
					)
					(self dispose:)
				else
					(proc1111_31 12)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianRing of View
	(properties
		x 467
		y 291
		loop 3
		view 2217
	)

	(method (init)
		(if (!= (proc70_9 1) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 1 0)
				(if (== (gCurRoom script:) avianWaits)
					((gCurRoom script:) next: 1)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matrixB11z of MigratingView
	(properties
		x 79
		y 232
		view 2218
		invItemID 51
	)
)

(instance freeAvian of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW (avianRing view:))
				(proc70_10 1 gCurRoomNum)
				(avianRing init: global117 setHotspot: 2)
				(avianBeingFreed play: self)
				(FrameOut)
			)
			(1
				(= local0 1)
				(SoundManager stopSounds:)
				(gGame handsOn:)
				(gCurRoom setScript: avianWaits)
			)
		)
	)
)

(instance avianStuck of Script
	(properties)

	(method (dispose)
		(if gAutoRobot
			(gAutoRobot caller: 0)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not next)
					(= state (Random 0 3))
					(= cycles (Random 20 60))
				else
					(self dispose:)
				)
			)
			(1
				(= state -1)
				(proc1111_7 22171 0 0 0 0 -1 0 self)
			)
			(2
				(= state -1)
				(proc1111_7 22172 0 0 0 0 -1 0 self)
			)
			(3
				(= state -1)
				(proc1111_7 22173 0 0 0 0 -1 0 self)
			)
			(4
				(= state -1)
				(proc1111_7 22174 0 0 0 0 -1 0 self)
			)
		)
	)
)

(instance avianWaits of Script
	(properties)

	(method (dispose)
		(= next 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not next)
					(proc1111_7 22281 417 55 0 0 -1 0 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (not next)
					(= state -1)
					(= cycles (Random 120 300))
				else
					(= local0 0)
					((gCurRoom picObj:) picture: 2299)
					(avianFlyingAway play: self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sparksFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sparks setCycle: CT 1 1 self)
			)
			(1
				(sparksSound play:)
				(sparks setCycle: Osc 1 self)
			)
			(2
				(= state -1)
				(= cycles (Random 30 180))
			)
		)
	)
)

(instance puckSpeaks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(proc1111_31 16 4 144)
				(self dispose:)
			)
		)
	)
)

(instance avianBeingFreed of VMDMovie
	(properties
		movieName 22281
		endPic 2228
	)
)

(instance avianFlyingAway of VMDMovie
	(properties
		movieName 22282
		endPic 2299
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 600)
			(= preLoadPCT 100)
		)
		(super play: &rest)
		(SetFlag 66)
	)
)

(instance sparksSound of Sound
	(properties
		flags 5
	)

	(method (play)
		(switch (Random 0 2)
			(0
				(= number 2217)
			)
			(1
				(= number 2218)
			)
			(2
				(= number 2219)
			)
		)
		(super play: &rest)
	)
)

(instance ruinBiot_0 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 127 191 108 198 85 258 64 262 41 280 15 315 33 339 60 364 65 371 52 382 52 411 99 465 134 470 175 501 192 506 237 427 215 357 225 354 237 291 243 228 219 196 209 198 283 185 285 111 239 119 196 210 191 209 177 150 182 127 178 108 148 126 126 146 116 161 127
					yourself:
				)
		)
	)
)

(instance sea_0 of Feature
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
					init: 142 30 139 -1 258 -1 248 40 226 74 213 47 183 33
					yourself:
				)
		)
	)
)

(instance still_135 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 129 139 428 139 430 148 378 166 343 173 220 175 160 161
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 15)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance laser_135 of Feature
	(properties
		noun 2
		x 424
		y 176
		nsBottom 197
		nsLeft 405
		nsRight 443
		nsTop 155
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance wireFeature_0 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2 80
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 318 189 346 188 344 238 318 240
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2031) ; ruinCU
			)
			(80
				(gCurRoom newRoom: 2031) ; ruinCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance laserExit_135 of ExitFeature
	(properties
		x 317
		y 157
		nsBottom 218
		nsLeft 126
		nsRight 508
		nsTop 97
		nextRoom 2016
	)
)

