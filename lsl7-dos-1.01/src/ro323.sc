;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 323)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	ro323 0
)

(local
	local0
)

(instance ro323 of L7Room
	(properties
		picture 32300
	)

	(method (init)
		(super init:)
		(gOMusic1 setMusic: 38000)
		(switch gPrevRoomNum
			(324 ; ro324
				(gEgo
					normalize: 7
					posn: 291 460
					init:
					setScaler: Scaler 152 78 471 250
					doit:
				)
			)
			(else
				(gEgo
					normalize: 4
					posn: 92 306
					init:
					setScaler: Scaler 152 78 471 250
					doit:
				)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 133 255 17 305 71 354 2 387 2 472 634 474 635 307 568 257 400 256 245 240 192 270
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 116 376 127 313 276 279 581 305 629 354 627 433 566 463 171 458 111 401
					yourself:
				)
		)
		(foAnnetteChair init:)
		(foChair2 init:)
		(foChair3 init:)
		(foChair4 init:)
		(foChair5 init:)
		(foChair6 init:)
		(foChair7 init:)
		(foChair8 init:)
		(foChair9 init:)
		(foBuffet init:)
		(foSneeze init:)
		(foTable init:)
		(foMoose init:)
		(foVent init:)
		(foPalm2 init:)
		(foPalm3 init:)
		(foPalm4 init:)
		(foExitWest init:)
		(gGame handsOn:)
		(gCurRoom setScript: soCyberSniff)
	)

	(method (doit)
		(cond
			((and (< 160 (gEgo x:) 310) (< 430 (gEgo y:) 475))
				(if (and (not (gCurRoom script:)) (not local0))
					(proc64896_15 4 0)
					(= local0 1)
				)
			)
			((and (not (gCurRoom script:)) local0)
				(proc64896_15 9 0)
				(= local0 0)
			)
		)
		(super doit: &rest)
	)
)

(instance soCyberSniff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 30)
			)
			(2
				(if (and (< 160 (gEgo x:) 310) (< 430 (gEgo y:) 475))
					(= local0 1)
					(proc64896_15 4 0)
				else
					(= local0 0)
					(proc64896_15 9)
				)
				(self dispose:)
			)
		)
	)
)

(instance foExitWest of ExitFeature
	(properties
		x 64
		y 162
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 25 292 9 33 120 63 107 184 107 262
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 330 92 306 1)
	)
)

(instance foAnnetteChair of Feature
	(properties
		noun 4
		x 221
		y 426
		approachX 291
		approachY 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 187 281 245 283 246 344 273 351 272 358 255 365 253 387 259 419 277 429 254 439 245 452 231 454 216 438 200 436 185 438 194 411 198 389 203 367 191 365 193 360 207 351 211 341 188 349 194 312
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom newRoom: 324) ; ro324
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foChair2 of Feature
	(properties
		noun 3
		x 426
		y 429
		approachX 358
		approachY 468
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 398 281 462 284 460 374 452 399 472 458 457 456 433 446 411 446 395 455 390 455 392 439 383 425 400 397 400 381 383 350 396 349
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChair3 of Feature
	(properties
		noun 3
		x 524
		y 425
		approachX 492
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 504 286 553 282 546 322 553 347 550 365 540 372 561 443 560 447 533 443 512 452 503 459 498 457 487 434 472 428 490 399 494 375 475 356 499 355
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSneeze of Feature
	(properties
		noun 8
		x 376
		y 141
		approachX 381
		approachY 268
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 239 124 564 135 580 170 575 174 456 164 435 164 319 160 222 153 216 147
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foVent of Feature
	(properties
		noun 7
		x 605
		y 222
		approachX 587
		approachY 272
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 596 23 634 13 622 77 622 137 584 126 593 79
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPalm2 of Feature
	(properties
		noun 2
		x 169
		y 242
		approachX 187
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 142 251 148 233 162 221 162 181 171 155 163 142 164 135 147 146 151 128 166 121 146 116 161 106 182 112 198 95 207 95 219 103 200 116 226 127 211 132 198 127 211 136 212 146 190 133 190 153 173 134 172 157 173 203 178 224 182 223 198 230 206 242 182 252 163 250
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBuffet of Feature
	(properties
		noun 5
		x 376
		y 142
		approachX 381
		approachY 268
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 228 175 344 168 450 175 529 181 569 189 570 196 538 207 426 205 347 201 265 189 236 183
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 71)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Smell
				(super doVerb: theVerb)
				(proc64896_15 9 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foPalm3 of Feature
	(properties
		noun 2
		x 5
		y 346
		approachX 35
		approachY 321
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 364 17 359 29 349 13 319 0 310
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPalm4 of Feature
	(properties
		noun 2
		x 5
		y 346
		approachX 35
		approachY 321
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 119 26 139 26 129 10 104 50 116 40 92 19 79 6 74 34 69 50 59 22 51 8 54 1 57
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChair4 of Feature
	(properties
		noun 3
		x 167
		y 387
		approachX 148
		approachY 437
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 410 148 387 152 356 157 342 143 340 146 335 138 328 139 262 175 255 181 277 179 316 185 324 195 323 190 342 182 343 197 389 193 418 170 410 155 408
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChair5 of Feature
	(properties
		noun 3
		x 233
		y 334
		approachX 223
		approachY 291
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 252 246 246 247 265 194 273
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChair6 of Feature
	(properties
		noun 3
		x 300
		y 347
		approachX 304
		approachY 280
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 273 243 327 242 326 266 271 264
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChair7 of Feature
	(properties
		noun 3
		x 454
		y 358
		approachX 458
		approachY 289
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 417 245 480 248 475 261 475 267 418 264
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChair8 of Feature
	(properties
		noun 3
		x 515
		y 359
		approachX 519
		approachY 293
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 504 252 556 258 551 278 498 269
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChair9 of Feature
	(properties
		noun 3
		x 583
		y 398
		approachX 628
		approachY 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 575 259 619 274 610 280 601 308 612 335 586 330 588 342 599 347 582 348 598 397 584 412 552 419 544 390 558 370 555 349 548 331 568 331 580 341 583 327 569 321 569 293
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTable of Feature
	(properties
		noun 6
		x 365
		y 404
		approachX 363
		approachY 286
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 154 284 243 266 295 263 435 266 513 272 578 286 593 293 592 299 549 316 456 329 346 332 251 325 165 302 153 294
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foMoose of Feature
	(properties
		noun 1
		x 365
		y 405
		approachX 363
		approachY 286
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 268 278 303 272 310 256 330 250 334 240 312 251 297 246 298 225 312 220 311 237 325 236 322 218 330 218 332 233 346 229 343 211 356 214 355 229 373 222 381 229 386 229 385 214 395 219 394 234 401 239 405 223 417 228 410 244 424 248 424 231 439 232 441 254 431 264 410 259 420 273 439 273 449 259 460 264 458 273 459 280 397 281 395 299 378 301 339 287 305 289 297 280 271 284
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 71)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Smell
				(super doVerb: theVerb)
				(proc64896_15 9 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

