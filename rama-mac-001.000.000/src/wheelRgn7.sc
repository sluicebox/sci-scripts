;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2016)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use cplainRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	wheelRgn7 0
)

(instance wheelRgn7 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2011 ; wheelRgn2
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2012 ; wheelRgn3
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2015 ; wheelRgn6
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(2017 ; wheelRgn8
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2018 ; wheelRgn9
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
		((ScriptID 200 0) addMigrant: 54) ; cplainRegion
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2219
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(sixExit_315 init:)
		(super init: &rest)
		(lights_315 init:)
		(london_315 init:)
		(ruinBiot_315 init:)
		(sea_315 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2222
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(twoExit_45 init:)
		(threeExit_45 init:)
		(super init: &rest)
		(sea_45 init:)
		(newyork_45 init:)
		(spikes_45 init:)
		(lights_45 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2221
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(stillExit_135 init:)
		(super init: &rest)
		(if (and (== gPrevRoomNum 2015) (not (SetFlag 61))) ; wheelRgn6
			(gGame handsOff:)
			(gCurRoom setScript: watchAvianFly)
		)
		(still_135 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2220
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc9Exit init:)
		(wheelExit_225 init:)
		(super init: &rest)
		(matrixB21z init: global117)
		(laser_225 init:)
		(wheel_225 init:)
		(lights_225 init:)
		(london_225 init:)
	)
)

(instance loc9Exit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 73 148 95 142 261 136 261 168 226 166 226 178 234 201 259 201 243 239 257 245 258 254 230 262 199 262 169 257 175 242 190 236 172 203 198 203 201 181 209 174 207 166 71 157
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2018) ; wheelRgn9
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matrixB21z of MigratingView
	(properties
		x 262
		y 244
		view 2220
		invItemID 54
	)
)

(instance watchAvianFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(avianFlyBy play: self)
			)
			(2
				(proc1111_31 16 5 144)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance avianFlyBy of VMDMovie
	(properties
		movieName 2222
		frameRate 10
	)
)

(instance laser_225 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 70 147 174 136 264 135 264 167 228 166 232 184 255 202 257 251 230 259 197 260 170 255 174 205 202 170 68 157
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
					init: 260 147 338 147 346 122 358 99 371 125 373 140 391 142 581 149 582 169 481 176 383 183 363 182 269 174 257 166
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
					init: 201 98 590 40 591 60 195 106
					yourself:
				)
		)
	)
)

(instance london_225 of Feature
	(properties
		noun 16
		nsLeft 455
		nsTop 43
		nsRight 488
		nsBottom 59
		x 471
		y 51
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lights_315 of Feature
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
					init: -1 9 360 77 382 92 -1 30
					yourself:
				)
		)
	)
)

(instance london_315 of Feature
	(properties
		noun 16
		nsLeft 147
		nsTop 20
		nsRight 176
		nsBottom 45
		x 161
		y 32
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ruinBiot_315 of Feature
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
					init: 262 178 291 161 328 118 366 126 305 179 263 191
					yourself:
				)
		)
	)
)

(instance sea_315 of Feature
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
					init: 305 1 435 1 441 40 464 75 442 81 402 104 359 78 323 37
					yourself:
				)
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
					init: 115 89 134 62 142 31 138 -1 259 -1 251 30 234 63 218 83 193 79 161 81 145 75 133 79 123 90
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: -2 135 16 131 12 140 -2 140
					yourself:
				)
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
					init: 155 79 169 38 172 -2 208 -1 202 32 188 60 164 81
					yourself:
				)
		)
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
					init: 394 135 419 133 440 143 440 163 417 155
					yourself:
				)
		)
	)
)

(instance lights_45 of Feature
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
					init: 64 55 137 24 134 46 63 72
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
					init: -1 128 591 129 589 147 551 157 491 178 417 173 370 190 223 197 181 195 141 191 137 178 63 162 -2 164
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

(instance wheelExit_225 of ExitFeature
	(properties
		nsLeft 278
		nsTop 99
		nsRight 523
		nsBottom 204
		x 400
		y 151
		nextRoom 2020
	)
)

(instance stillExit_135 of ExitFeature
	(properties
		nsLeft 54
		nsTop 97
		nsRight 491
		nsBottom 221
		x 272
		y 159
		nextRoom 2017
	)
)

(instance twoExit_45 of ExitFeature
	(properties
		nsLeft 30
		nsTop 92
		nsRight 295
		nsBottom 241
		x 159
		y 166
		nextRoom 2011
	)
)

(instance sixExit_315 of ExitFeature
	(properties
		nsLeft 209
		nsTop 99
		nsRight 400
		nsBottom 216
		x 304
		y 157
		nextRoom 2015
	)
)

(instance threeExit_45 of ExitFeature
	(properties
		nsLeft 279
		nsTop 89
		nsRight 553
		nsBottom 228
		x 416
		y 158
		nextRoom 2012
	)
)

