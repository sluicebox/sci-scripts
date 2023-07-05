;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6202)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	avianGreatHall3 0
)

(instance avianGreatHall3 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceN faceS faceN)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(if (== heading 180)
					(leftMural init: global117)
					(rightMural init: global117)
				)
			)
			(26
				(if (== heading 180)
					(leftMural dispose:)
					(rightMural dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6208
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (not (IsFlag 128))
			(= picture 6224)
		)
		(defaultExit nextRoom: 6201 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(perches_180 init:)
		(murals_180 init:)
		(gourds_180 init:)
		(AviansAll_180 init:)
		(dispensor_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6212
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 6203 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(if (not (IsFlag 128))
			(gCurRoom setScript: avianWaitingAtElevatorScript)
		)
		(gourds_0 init:)
	)

	(method (dispose)
		(proc1111_6)
		(avianWaitingAtElevatorScript dispose:)
		(super dispose: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance avianWaitingAtElevatorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 6220 291 79 global161 0 -1 1 self)
			)
			(1
				(= global161 0)
				(= seconds (Random 2 8))
				(= state -1)
			)
		)
	)
)

(instance leftMural of View
	(properties
		x 157
		y 185
		loop 4
		view 6201
	)
)

(instance rightMural of View
	(properties
		x 389
		y 185
		loop 4
		cel 1
		view 6201
	)
)

(instance elevator_0 of Feature ; UNUSED
	(properties
		noun 64
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 255 0 338 0 349 252 245 249
					yourself:
				)
		)
	)
)

(instance perches_180 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 0 437 1 467 27 386 98 345 108 238 106 220 101 127 29
					yourself:
				)
		)
	)
)

(instance dispensor_180 of Feature
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
					init: 271 193 301 190 305 169 317 169 325 213 291 213 299 198 269 201
					yourself:
				)
		)
	)
)

(instance murals_180 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: -2 42 61 224 0 248 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 153 105 202 123 216 191 141 204
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 388 124 436 103 443 203 375 185
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 589 36 588 251 526 223 yourself:)
		)
	)
)

(instance gourds_180 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 28 230 39 228 41 243 25 250
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 3 36 86 200 116 153 126 120 150 182 159 109 168 108 183 174 186 113 179 76 59 4 4 3 33 132 52 123
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 92 212 106 210 108 221 94 226
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 238 143 261 177 271 178 278 167 284 142 306 142 311 166 320 167 329 168 337 169 342 168 343 154 342 142 335 130 329 124 305 119 284 123 282 133 274 134 271 124 261 124 259 138 244 142 249 168 264 155
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 424 110 431 182 437 162 448 175 469 122
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 500 63 494 123 520 191 552 113 511 53
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 495 215 516 218 517 233 493 229
					yourself:
				)
		)
	)
)

(instance AviansAll_180 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 264 0 312 54 336 1 yourself:)
		)
	)
)

(instance gourds_0 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 15 206 32 204 32 217 13 225
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 79 200 100 198 100 215 72 215
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 163 196 183 195 181 206 173 209
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 205 193 221 194 217 203 204 206
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 513 198 533 199 526 221 507 221
					yourself:
				)
		)
	)
)

