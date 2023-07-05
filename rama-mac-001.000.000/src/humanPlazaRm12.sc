;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5212)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	humanPlazaRm12 0
)

(instance humanPlazaRm12 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5206 ; humanPlazaRm6
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5213 ; NY_Human_Plaza_13
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5231
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRm6 init:)
		(walls_0 init:)
		(plaza_0 init:)
		(exit_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5233
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5232
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(tetraGR init:)
		(walls_270 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5234
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(mazePiston init:)
		(mazeCard init:)
		(mazeLights init:)
		(exitToController init:)
		(walls_90 init:)
		(mazeMap_90 init:)
		(mazeCtrl_90 init:)
		(super init: &rest)
	)
)

(instance exitToRm6 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5206
	)
)

(instance exitToController of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5213
	)
)

(instance mazeCard of View
	(properties
		x 290
		y 185
		view 5220
		loop 2
	)

	(method (init)
		(if (== (proc70_9 47) 5214)
			(super init: global117 &rest)
		)
	)
)

(instance mazePiston of View
	(properties
		x 279
		y 180
		view 5220
	)

	(method (init)
		(= cel global256)
		(super init: global117 &rest)
	)
)

(instance mazeLights of View
	(properties
		view 5220
		loop 1
	)

	(method (init)
		(if (== (proc70_9 47) 5214)
			(switch (= cel global256)
				(0
					(self posn: 279 177)
				)
				(1
					(self posn: 285 177)
				)
				(2
					(self posn: 289 177)
				)
				(3
					(self posn: 293 177)
				)
				(4
					(self posn: 296 177)
				)
			)
			(super init: global117 &rest)
		)
	)
)

(instance tetraGR of View
	(properties
		noun 16
		x 153
		y 258
		view 5205
		cel 4
	)

	(method (init)
		(if (== (proc70_9 97) 5212)
			(&= signal $efff)
			(super init: global117 &rest)
			(self setHotspot: 2 144)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 97)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
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
					init: 1 2 591 -1 590 240 353 189 262 191 -1 270
					yourself:
				)
		)
	)
)

(instance plaza_0 of Feature
	(properties
		noun 32
		nsLeft 262
		nsRight 353
		nsBottom 189
		x 307
		y 94
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance exit_0 of Feature
	(properties
		noun 28
		nsLeft 301
		nsTop 1
		nsRight 329
		nsBottom 180
		x 315
		y 90
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 0 0 590 -1 591 291 434 292 327 210 258 207 200 262 -1 261
					yourself:
				)
		)
	)
)

(instance mazeMap_90 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 143 302 142 306 146 311 148 317 154 312 159 305 159 301 163 281 163 276 157 269 157 266 153 269 147 276 147
					yourself:
				)
		)
	)
)

(instance mazeCtrl_90 of Feature
	(properties
		noun 3
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 282 170 290 169 303 168 313 182 312 191 307 195 303 211 281 210 278 200 278 194 273 194 270 181 277 179 279 173
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 32
		nsTop -1
		nsRight 590
		nsBottom 269
		x 295
		y 134
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_270 of Feature
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
					init: -1 0 589 0 589 263 170 265 132 292 -1 291
					yourself:
				)
		)
	)
)

