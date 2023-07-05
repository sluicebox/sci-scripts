;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2014)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	wheelRgn5 0
)

(instance wheelRgn5 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2000 ; cplains
				(self addPicObj: faceW faceE faceW)
			)
			(else
				(self addPicObj: faceE faceW faceE)
				(if (== gPrevRoomNum 2013) ; wheelRgn4
					(self setScript: lowerTheBiot)
				)
			)
		)
		((ScriptID 200 0) addMigrantIfEqualTo: 2013 49 51 54 60) ; cplainRegion
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 2000) ; cplains
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2215
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(plainsExit_45 init:)
		(super init: &rest)
		(spikes_45 init:)
		(sea_45 init:)
		(newyork_45 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2216
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(trashExit_225 init:)
		(gCurRoom setScript: 0)
		(if (not (OneOf (proc70_9 31) -2 -3 55 2005))
			(= showBlack 1)
			(= picture 61)
			(gCurRoom setScript: showFran)
		)
		(super init: &rest)
		(wheel_225 init:)
		(trashBiot_225 init:)
		(lights_225 init:)
	)
)

(instance showFran of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(franCoughsUpCard play: self)
				(faceW picture: 2216)
				(proc70_1 31 0)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance franCoughsUpCard of VMDMovie
	(properties
		movieName 38041
		endPic 38049
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 1000)
			(= preLoadPCT 100)
		)
		(super play: &rest)
	)
)

(instance spikes_45 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 134 196 144 80 148 115 157 20 177 213 183 135 197 102 206 177 196 216 179 219
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 216 222 226 76 236 220 yourself:)
				((Polygon new:) type: PTotalAccess init: 299 210 316 54 332 203 yourself:)
				((Polygon new:) type: PTotalAccess init: 349 205 358 87 365 204 yourself:)
		)
	)
)

(instance sea_45 of Feature
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
					init: 114 91 129 75 139 54 143 27 140 0 258 0 253 27 241 54 223 79 196 100 171 112 151 98 136 93
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 53 125 68 119 61 130 yourself:)
		)
	)
)

(instance newyork_45 of Feature
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
					init: 163 68 170 45 174 20 174 -1 210 0 207 27 196 49 181 70 164 82
					yourself:
				)
		)
	)
)

(instance wheel_225 of Feature
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
					init: 329 149 390 148 396 116 404 104 414 110 421 128 422 148 462 147 465 143 493 142 500 148 547 148 576 151 577 164 527 165 361 165
					yourself:
				)
		)
	)
)

(instance trashBiot_225 of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 181 192 185 181 198 171 215 169 233 171 245 181 249 188 282 189 283 193
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 316 192 316 182 367 182 369 193
					yourself:
				)
		)
	)
)

(instance lights_225 of Feature
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
					init: 200 99 591 40 591 56 205 107
					yourself:
				)
		)
	)
)

(instance plainsExit_45 of ExitFeature
	(properties
		nsLeft 61
		nsTop 82
		nsRight 421
		nsBottom 238
		x 241
		y 160
		nextRoom 2000
	)
)

(instance trashExit_225 of ExitFeature
	(properties
		nsLeft 122
		nsTop 128
		nsRight 445
		nsBottom 233
		x 283
		y 180
		nextRoom 2013
	)
)

(instance biotLowering of Sound
	(properties
		flags 5
		number 2229
	)
)

(instance lowerTheBiot of Script
	(properties)

	(method (dispose)
		(biotLowering number: 2231 loop: 1 play:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 64)
				(biotLowering number: 2229 loop: 1 play: self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

