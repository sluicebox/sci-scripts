;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3063)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use RegionSFX)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	london_33 0
)

(instance london_33 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3064 ; london_34
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
		(SoundManager
			addSFXLocs: (sSpider33 owner: self setProx: 3063 127 180 yourself:)
		)
	)

	(method (dispose)
		(SoundManager deleteSFXLoc: sSpider33)
		(super dispose: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3311
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(monitor_180 init:)
		(if (proc1111_24 114)
			(gCurRoom drawPic: 3341)
			(gCurRoom setScript: spiderThreatening)
			(spider_180 init:)
		)
		(attack init: setHotspot: 2)
		(inventory_Medallion init:)
		(monitorSwitch init:)
		(monitorPic init:)
	)

	(method (dispose)
		(if (gCurRoom script:)
			((gCurRoom script:) dispose:)
		)
		(super dispose: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3308
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(crane_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3310
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(eastExitToLondon34 init:)
		(super init:)
		(ramps_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3309
		edgeN 0
		edgeS 0
	)

	(method (init)
		(northExitToLondon32 init:)
		(super init:)
		(displays_0 init:)
	)
)

(instance northExitToLondon32 of ExitFeature
	(properties
		nsLeft 124
		nsTop 65
		nsRight 522
		nsBottom 243
		nextRoom 3062
	)
)

(instance eastExitToLondon34 of ExitFeature
	(properties
		nsLeft 179
		nsTop 74
		nsRight 307
		nsBottom 203
		nextRoom 3064
	)
)

(instance attack of Feature
	(properties
		nsLeft 158
		nsTop 80
		nsRight 304
		nsBottom 176
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gGame autoSave: 1)
				(gCurRoom newRoom: 3071) ; london_Attack
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inventory_Medallion of View
	(properties
		noun 38
		x 154
		y 194
		view 3301
		loop 1
		cel 2
	)

	(method (init)
		(if (== (proc70_9 40) 3063)
			(self setPri: 0)
			(super init: global117)
			(self setHotspot: 144 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (proc1111_24 114)
					(gGame autoSave: 1)
					(gCurRoom newRoom: 3071) ; london_Attack
				else
					(self hide:)
					(proc70_1 40)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monitorSwitch of View
	(properties
		x 217
		y 165
		view 3301
		loop 1
	)

	(method (init)
		(= cel global297)
		(self setPri: 0)
		(super init: global117)
	)
)

(instance monitorPic of View
	(properties
		x 217
		y 135
		view 3301
		loop 1
		cel 3
	)

	(method (init)
		(if global297
			(self setPri: 0)
			(super init: global117)
		)
	)
)

(instance spiderThreatening of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 3333 270 156 global161 0 1 1 self)
			)
			(1
				(= global161 0)
				(self changeState: 0)
			)
		)
	)
)

(instance ramps_90 of Feature
	(properties
		noun 28
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 182 236 125 336 131 335 172 281 168 269 190
					yourself:
				)
		)
	)
)

(instance displays_0 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 7 61 81 143 171 123 264 156 329 154 334 125 382 105 410 140 404 176 182 181 20 212
					yourself:
				)
		)
	)
)

(instance monitor_180 of Feature
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
					init: 213 159 208 100 250 100 246 162
					yourself:
				)
		)
	)
)

(instance spider_180 of Feature
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
					init: 92 288 91 238 125 244 122 211 173 222 237 190 271 179 249 147 252 87 282 71 290 44 307 63 332 97 335 140 328 170 390 205 410 196 423 200 429 222 449 241 523 227 522 289 508 289 505 250 447 272 343 220 317 205 333 232 305 230 283 193 241 230 191 267 129 283 118 292
					yourself:
				)
		)
	)
)

(instance crane_270 of Feature
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
					init: 2 2 432 0 458 187 506 262 463 264 386 280 351 274 340 218 343 123 274 140 138 145 103 142 129 212 83 229 50 234 29 247 7 256
					yourself:
				)
		)
	)
)

(instance sSpider33 of RegionSFX
	(properties
		number 3311
	)

	(method (play)
		(if (proc1111_24 114)
			(super play: &rest)
			(if (== ((gCurRoom picObj:) heading:) 180)
				(self setVol: 0)
			else
				(self setVol: 127)
			)
		)
	)

	(method (pan)
		(if (== ((gCurRoom picObj:) heading:) 180)
			(self setVol: 0)
		else
			(self setVol: 127)
		)
		(super pan: &rest)
	)
)

