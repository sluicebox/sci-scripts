;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6204)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use SoundManager)
(use RegionSFX)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	avianGreatHall5 0
)

(local
	local0
	local1
)

(instance avianGreatHall5 of Location
	(properties)

	(method (init)
		(SoundManager
			playSounds: ((RegionSFX new:) number: 6219 setVol: 127 yourself:)
		)
		(super init:)
		(= plane global116)
		(self addPicObj: faceN faceS faceN)
	)

	(method (serialize param1)
		(if (and argc param1)
			(super serialize: param1 0)
			(= local0 (SaveManager readWord:))
			(= local1 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
			(SaveManager writeWord: local1)
		)
	)

	(method (dispose)
		(SoundManager
			playSounds: ((RegionSFX new:) number: 6219 setVol: 100 yourself:)
		)
		(super dispose: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6211
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if local1
			(= local1 0)
			(aviansBowing play:)
		)
		(super init: &rest)
		(aLotofAvians_180 init:)
		(doorGHOut_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (not (IsFlag 128))
			(if (not local0)
				(gCurRoom setScript: sOfferSquawkBox)
			)
			(if local0
				(gCurRoom drawPic: 6213)
				(self picture: 6213)
				(squawkBox init:)
			else
				(gCurRoom drawPic: 6215)
				(self picture: 6215)
			)
		else
			(gCurRoom drawPic: 6214)
			(self picture: 6214)
			(if (not local1)
				(gCurRoom setScript: sTimeToGo)
			)
		)
		(super init: &rest)
		(avians_0 init:)
		(avianKing_0 init:)
		(BANNER_N_0 init:)
	)
)

(instance elevatorDown of VMDMovie
	(properties
		movieName 6201
		frameRate 10
		options 256
		endPic 6209
	)
)

(instance offerSquawkBox of VMDMovie
	(properties
		movieName 6210
		endPic 6213
	)
)

(instance avianLowerLeg of VMDMovie
	(properties
		movieName 6211
		endPic 6214
	)
)

(instance aviansBowing of VMDMovie
	(properties
		movieName 6223
		endPic 6211
	)
)

(instance aviansSquawkingElev of VMDMovie
	(properties
		movieName 6224
		endPic 6214
	)
)

(instance squawkBox of Feature
	(properties
		nsBottom 264
		nsLeft 377
		nsRight 479
		nsTop 219
	)

	(method (init)
		(super init: &rest)
		(= local0 1)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 3)
				(SetFlag 128)
				(gCurRoom setScript: sTakeABow)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sOfferSquawkBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(= seconds 2)
			)
			(1
				(offerSquawkBox play:)
				(squawkBox init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTakeABow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SoundManager fadeMusic: 0 20 10 1 self)
				(gGame handsOff:)
				(= local0 0)
				(avianLowerLeg play:)
				(= local1 1)
			)
			(1
				(SoundManager playMusic: 0 -1 6030)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTimeToGo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 0)
				(aviansSquawkingElev play:)
				(= cycles 1)
			)
			(1
				(elevatorDown play:)
				(gCurRoom newRoom: 6203) ; avianGreatHall4
				(gGame handsOn:)
			)
		)
	)
)

(instance sqwaukSound of Sound ; UNUSED
	(properties
		number 6106
		flags 5
	)
)

(instance avians_0 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 78 93 11 91 69 126 7 143 13 149 63 165 71 212 14 224 102 182 200 165 185 156 274 94 270
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 396 12 441 66 443 19 479 13 479 18 478 58 498 70 494 13 592 101 590 161 534 217 422 209
					yourself:
				)
		)
	)
)

(instance avianKing_0 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 19 276 46 286 41 286 20 295 2 302 22 302 43 310 52 327 16 341 65 323 95 317 126 271 123
					yourself:
				)
		)
	)
)

(instance BANNER_N_0 of Feature
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
					init: 264 122 295 125 329 123 314 239 278 238
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 3 259 39 271 84 264 78 288 -2 287
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 522 262 555 269 585 262 590 289 524 290
					yourself:
				)
		)
	)
)

(instance aLotofAvians_180 of Feature
	(properties
		noun 19
		x 293
		y 143
		nsBottom 287
		nsLeft 2
		nsRight 584
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance doorGHOut_180 of Feature
	(properties
		noun 15
		x 296
		y 264
		nsBottom 280
		nsLeft 286
		nsRight 306
		nsTop 248
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

