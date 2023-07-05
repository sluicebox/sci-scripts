;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2012)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	wheelRgn3 0
)

(instance wheelRgn3 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2011 ; wheelRgn2
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(2013 ; wheelRgn4
				(self setScript: lowerTheBiot)
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2016 ; wheelRgn7
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 315
		picture 2207
		edgeS 0
		edgeN 0
	)

	(method (init)
		(twoExit_315 init:)
		(super init: &rest)
		(london_315 init:)
		(lights_315 init:)
		(sea_315 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 45
		picture 2210
		edgeS 0
		edgeN 0
	)

	(method (init)
		(fiveExit_45 init:)
		(super init: &rest)
		(sea_45 init:)
		(newyork_45 init:)
		(spikes_45 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 135
		picture 2209
		edgeS 0
		edgeN 0
	)

	(method (init)
		(fourExit_135 init:)
		(gCurRoom setScript: 0)
		(super init: &rest)
		(trashBiot_135 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 225
		picture 2208
		edgeS 0
		edgeN 0
	)

	(method (init)
		(stillExit_225 init:)
		(laserExit_225 init:)
		(super init: &rest)
		(still_225 init:)
		(wheel_225 init:)
		(lights_225 init:)
		(london_225 init:)
		(laser_225 init:)
	)
)

(instance london_315 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 147 19 167 22 178 44 155 40
					yourself:
				)
		)
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
				((Polygon new:) type: PTotalAccess init: 1 10 364 78 379 91 1 32 yourself:)
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
					init: 305 1 435 1 442 40 408 56 380 90 347 68 320 34
					yourself:
				)
		)
	)
)

(instance still_225 of Feature
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
					init: 52 115 170 125 182 149 219 150 228 167 224 178 210 180 158 181 139 178 127 167 100 163 61 148
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
					init: 334 147 365 145 372 113 384 99 397 125 398 145 433 140 469 139 556 149 556 165 504 169 429 166 347 166
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
					init: 205 98 590 42 590 59 193 109
					yourself:
				)
		)
	)
)

(instance london_225 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 455 45 476 40 490 57 463 60
					yourself:
				)
		)
	)
)

(instance laser_225 of Feature
	(properties
		noun 2
		x 573
		y 166
		nsBottom 183
		nsLeft 555
		nsRight 591
		nsTop 150
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance trashBiot_135 of Feature
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
					init: 24 206 42 198 148 197 147 174 181 180 188 194 194 206 114 210 109 223 23 224
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
					init: 119 86 135 62 142 36 139 0 257 0 251 31 236 61 208 89 156 85
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
					init: 157 82 165 56 171 -1 208 -1 202 35 180 68
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
					init: 328 149 331 131 340 112 350 154 351 169
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 361 174 363 119 398 133 400 170
					yourself:
				)
		)
	)
)

(instance twoExit_315 of ExitFeature
	(properties
		x 264
		y 169
		nsBottom 233
		nsLeft 121
		nsRight 408
		nsTop 105
		nextRoom 2011
	)
)

(instance stillExit_225 of ExitFeature
	(properties
		x 193
		y 153
		nsBottom 198
		nsLeft 84
		nsRight 302
		nsTop 109
		nextRoom 2017
	)
)

(instance laserExit_225 of ExitFeature
	(properties
		x 563
		y 166
		nsBottom 198
		nsLeft 417
		nsRight 592
		nsTop 103
		nextRoom 2016
	)
)

(instance fourExit_135 of ExitFeature
	(properties
		x 138
		y 178
		nsBottom 249
		nsLeft 25
		nsRight 264
		nsTop 108
		nextRoom 2013
	)
)

(instance fiveExit_45 of ExitFeature
	(properties
		x 373
		y 150
		nsBottom 212
		nsLeft 262
		nsRight 484
		nsTop 88
		nextRoom 2014
	)
)

(instance biotLowering of Sound
	(properties
		number 2229
		flags 5
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

