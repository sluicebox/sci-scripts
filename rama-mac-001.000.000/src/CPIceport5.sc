;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2104)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	CPIceport5 0
)

(instance CPIceport5 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2108 ; bombCloseUp
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2417
		edgeN 0
		edgeS 0
	)

	(method (init)
		(bombCUExit init:)
		(super init: &rest)
		(bombLight init: global117)
		(pillar_0 init:)
		(bomb_0 init:)
		(horns_0 init:)
		(sea_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2418
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(sea_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2419
		heading 180
		edgeN 0
		edgeS 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2420
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2103 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(sea_270 init:)
		(pillar_270 init:)
		(spikes_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance bombCUExit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 167 245 175 223 213 190 268 181 300 184 317 204 317 242 309 267 255 292 174 292
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(SoundManager fadeMusic: 0 15 10 1 0 playMusic: 0 1 1000 1020)
				(gCurRoom newRoom: 2108) ; bombCloseUp
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bombLight of Prop
	(properties
		x 277
		y 197
		view 2417
		cycleSpeed 45
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance sea_90 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 -2 295 -1 290 80 277 77 266 84 256 103 245 111 238 125 212 153 182 195 -2 263
					yourself:
				)
		)
	)
)

(instance pillar_0 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 -1 191 -2 185 45 188 69 197 71 199 113 245 184 213 191 197 204 191 217 183 217 172 227 163 251 183 278 174 290 -3 292
					yourself:
				)
		)
	)
)

(instance bomb_0 of Feature
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
					init: 166 249 169 229 178 218 193 216 194 209 211 191 239 191 241 185 258 185 261 181 298 184 315 203 315 239 308 249 311 262 308 268 252 291 237 289 241 280 226 274 196 287 191 281 181 275 175 264
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 2
		nsLeft 269
		nsTop 36
		nsRight 318
		nsBottom 81
		x 293
		y 58
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_0 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 132 276 145 330 144 388 128 444 95 480 58 506 21 516 -1 591 -1 591 248 558 250 556 195 550 192 530 192 526 199 522 251 447 251 444 198 442 192 419 193 419 201 417 250 331 250 333 192 307 192 298 183 263 179 258 186 246 183 242 172
					yourself:
				)
		)
	)
)

(instance sea_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 283 1 593 1 594 112 577 208 568 206 563 202 552 200 544 205 542 241 522 235 514 197 512 194 505 192 499 198 499 228 484 223 483 193 472 187 467 187 469 183 466 177 449 176 445 179 444 187 440 197 435 186 433 182 430 182 420 135 411 119 398 107 384 99 371 107 355 123 348 137 341 174 324 168 305 145 294 118 288 90 283 55 282 31
					yourself:
				)
		)
	)
)

(instance pillar_270 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 329 188 333 182 338 182 348 137 354 123 371 109 384 99 397 108 411 119 420 135 427 180 423 197 401 194 380 191
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 534 294 554 277 564 276 592 113 592 295
					yourself:
				)
		)
	)
)

(instance spikes_270 of Feature
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
					init: 41 169 43 144 63 156 66 167
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 98 164 102 144 107 125 117 158 118 168 107 167
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 128 165 132 143 136 167 yourself:)
				((Polygon new:) type: PTotalAccess init: 141 166 145 134 148 166 yourself:)
				((Polygon new:) type: PTotalAccess init: 154 167 156 146 160 168 yourself:)
		)
	)
)

