;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5209)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	humanPlazaRm9 0
)

(instance humanPlazaRm9 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5208 ; humanPlazaRm8
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5215 ; NY_Human_Plaza_15
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5250
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 156)
			(= picture 5264)
		else
			(= picture 5250)
		)
		(walls_0 init:)
		(moat_0 init:)
		(lairDoor_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5248
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 156)
			(= picture 5263)
		else
			(= picture 5248)
		)
		(walls_180 init:)
		(lairDoor_180 init:)
		(moat_180 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5247
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 156)
			(= picture 5256)
			(exitToHumanLair init:)
		else
			(= picture 5247)
		)
		(exitToKeyPadCU init:)
		(humanKey init:)
		(humanTalisman init:)
		(lairDoor_270 init:)
		(keypad_270 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 157)
			(= picture 61)
			(gCurRoom setScript: theFinale)
		else
			(= picture 5249)
			(exitToHumanPlaza8 init:)
		)
		(walls_90 init:)
		(moat_90 init:)
		(bridge_90 init:)
		(super init: &rest)
	)
)

(instance exitToHumanPlaza8 of ExitFeature
	(properties
		nsBottom 291
		nsLeft 199
		nsRight 432
		nsTop 16
		nextRoom 5208
	)
)

(instance exitToHumanLair of ExitFeature
	(properties
		nextRoom 8000
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 4 343 4 394 128 418 129 424 147 503 205 503 236 434 276 155 277 92 238 91 202 203 132
					yourself:
				)
		)
	)
)

(instance exitToKeyPadCU of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 124 129 124 145 141 131 164 108 164 94 146
					yourself:
				)
			setHotspot: 2 19 59
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5215) ; NY_Human_Plaza_15
			)
			(19
				(gCurRoom newRoom: 5215) ; NY_Human_Plaza_15
			)
			(59
				(gCurRoom newRoom: 5215) ; NY_Human_Plaza_15
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance humanKey of View
	(properties
		x 102
		y 150
		loop 1
		view 5256
	)

	(method (init)
		(if (== (proc70_9 36) 5215)
			(super init: global117 &rest)
		)
	)
)

(instance humanTalisman of View
	(properties
		x 121
		y 149
		loop 1
		cel 1
		view 5256
	)

	(method (init)
		(if (== (proc70_9 37) 5215)
			(super init: global117 &rest)
		)
	)
)

(instance theFinale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(congrats play: self)
				(gGame handsOff:)
			)
			(1
				(end_It_All play:)
				(gGame handsOff:)
				(SoundManager fadeMusic: 0 20 10 1)
				(= ticks 120)
			)
			(2
				(arthurCongrats play: self)
				(gGame handsOff:)
			)
			(3
				(gGame handsOn:)
				(gCurRoom newRoom: 1300) ; creditRoom
				(self dispose:)
			)
		)
	)
)

(instance end_It_All of VMDMovie
	(properties
		movieName 5209
		endPic 61
		cacheSize 1000
	)
)

(instance congrats of VMDMovie
	(properties
		movieName 39021
		endPic 61
		cacheSize 1000
	)
)

(instance arthurCongrats of VMDMovie
	(properties
		movieName 39711
		endPic 61
		cacheSize 1000
	)
)

(instance walls_0 of Feature
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
					init: 0 2 591 1 590 192 480 190 203 214 190 238 185 241 182 290 -1 290
					yourself:
				)
		)
	)
)

(instance moat_0 of Feature
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
					init: 191 241 484 238 591 275 590 289 146 291 146 241
					yourself:
				)
		)
	)
)

(instance lairDoor_0 of Feature
	(properties
		noun 10
	)

	(method (init)
		(if (IsFlag 156)
			(= case 7)
		else
			(= case 6)
		)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 1 93 -1 137 28 149 109 106 138 109 173 125 175 124 193 152 235 151 252 155 251 157 277 160 288 0 290
					yourself:
				)
		)
	)
)

(instance walls_90 of Feature
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
					init: 1 -1 591 0 591 170 308 170 307 174 -1 192
					yourself:
				)
		)
	)
)

(instance moat_90 of Feature
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
					init: -1 264 589 261 591 291 -1 291
					yourself:
				)
		)
	)
)

(instance bridge_90 of Feature
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
					init: 219 263 393 264 411 291 200 290
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
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
					init: 0 1 591 0 592 291 346 289 345 253 340 251 340 234 305 217 34 196 33 182 26 179 -1 180
					yourself:
				)
		)
	)
)

(instance lairDoor_180 of Feature
	(properties
		noun 10
	)

	(method (init)
		(if (IsFlag 156)
			(= case 7)
		else
			(= case 6)
		)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 506 0 591 0 591 291 413 290 406 282 407 257 412 256 410 239 446 201 444 180 454 172 438 152 407 126 424 55 476 26 495 48
					yourself:
				)
		)
	)
)

(instance moat_180 of Feature
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
					init: -1 267 346 253 413 291 -1 289
					yourself:
				)
		)
	)
)

(instance lairDoor_270 of Feature
	(properties
		noun 10
	)

	(method (init)
		(if (IsFlag 156)
			(= case 7)
		else
			(= case 6)
		)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 4 343 4 394 128 418 129 424 147 503 205 503 236 434 276 155 277 92 238 91 202 203 132
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 87 0 167 0 214 70 193 104 89 97 80 65 86 53 79 53 83 44 68 36 74 22 68 17 69 7 77 3 83 6
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 422 0 509 0 511 4 515 3 521 5 524 11 525 20 520 24 525 37 512 43 516 51 510 53 514 67 505 99 401 105 378 69
					yourself:
				)
		)
	)
)

(instance keypad_270 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 106 123 128 125 140 143 130 163 106 164 93 141
					yourself:
				)
		)
	)
)

