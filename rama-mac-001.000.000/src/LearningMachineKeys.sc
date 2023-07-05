;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4035)
(include sci.sh)
(use Main)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	LearningMachineKeys 0
)

(local
	local0
	[local1 35] = [0 4003 4004 4005 4006 4007 4008 4009 4010 4011 4012 4103 4104 4105 4106 4107 4108 4109 4110 4111 4112 4113 4114 4115 4116 4117 4118 4203 4204 4205 4206 4207 4208 4209 4210]
	[local36 69] = [0 328 104 373 104 419 104 464 104 508 104 327 149 372 149 417 150 462 149 507 150 322 110 349 110 378 110 406 110 435 110 463 110 493 110 522 110 322 158 348 158 378 158 405 158 436 158 464 158 492 158 521 158 322 154 352 155 381 155 409 154 438 155 466 155 497 154 524 155]
	local105
)

(procedure (localproc_0 param1)
	(switch local0
		(0
			(cond
				((InRect 328 67 544 102 param1)
					(cond
						((InRect 328 67 360 102 param1)
							(return 0)
						)
						((InRect 374 67 406 102 param1)
							(return 1)
						)
						((InRect 420 67 452 102 param1)
							(return 2)
						)
						((InRect 466 67 498 102 param1)
							(return 3)
						)
						((InRect 512 67 544 102 param1)
							(return 4)
						)
						(else
							(return -1)
						)
					)
				)
				((InRect 329 113 543 149 param1)
					(cond
						((InRect 329 113 361 149 param1)
							(return 5)
						)
						((InRect 375 113 407 149 param1)
							(return 6)
						)
						((InRect 421 113 453 149 param1)
							(return 7)
						)
						((InRect 465 113 497 149 param1)
							(return 8)
						)
						((InRect 511 113 543 149 param1)
							(return 9)
						)
						(else
							(return -1)
						)
					)
				)
				(else
					(return -1)
				)
			)
		)
		(1
			(cond
				((InRect 318 72 560 102 param1)
					(cond
						((InRect 318 72 345 102 param1)
							(return 0)
						)
						((InRect 346 72 374 102 param1)
							(return 1)
						)
						((InRect 375 72 406 102 param1)
							(return 2)
						)
						((InRect 407 72 436 102 param1)
							(return 3)
						)
						((InRect 437 72 463 102 param1)
							(return 4)
						)
						((InRect 464 72 494 102 param1)
							(return 5)
						)
						((InRect 495 72 527 102 param1)
							(return 6)
						)
						((InRect 528 72 560 102 param1)
							(return 7)
						)
						(else
							(return -1)
						)
					)
				)
				((InRect 318 119 564 150 param1)
					(cond
						((InRect 318 119 345 150 param1)
							(return 8)
						)
						((InRect 346 119 375 150 param1)
							(return 9)
						)
						((InRect 376 119 405 150 param1)
							(return 10)
						)
						((InRect 406 119 435 150 param1)
							(return 11)
						)
						((InRect 436 119 465 150 param1)
							(return 12)
						)
						((InRect 466 119 495 150 param1)
							(return 13)
						)
						((InRect 496 119 527 150 param1)
							(return 14)
						)
						((InRect 528 119 564 150 param1)
							(return 15)
						)
						(else
							(return -1)
						)
					)
				)
				(else
					(return -1)
				)
			)
		)
		(2
			(cond
				((InRect 323 67 431 147 param1)
					(cond
						((InRect 323 67 343 147 param1)
							(return 0)
						)
						((InRect 354 67 373 147 param1)
							(return 1)
						)
						((InRect 384 67 402 147 param1)
							(return 2)
						)
						((InRect 412 67 431 147 param1)
							(return 3)
						)
						(else
							(return -1)
						)
					)
				)
				((InRect 441 67 547 147 param1)
					(cond
						((InRect 441 67 459 147 param1)
							(return 4)
						)
						((InRect 469 67 489 147 param1)
							(return 5)
						)
						((InRect 498 67 519 147 param1)
							(return 6)
						)
						((InRect 526 67 547 147 param1)
							(return 7)
						)
						(else
							(return -1)
						)
					)
				)
				(else
					(return -1)
				)
			)
		)
		(else
			(return -1)
		)
	)
)

(class LearningMachineKeys of Feature
	(properties
		nsLeft 319
		nsTop 52
		nsRight 550
		nsBottom 164
		currentKey -1
		active 0
	)

	(method (init)
		(= plane global116)
		(super init: &rest)
		(switch global269
			(1
				(= local0 0)
				(= local105 1)
			)
			(2
				(= local0 1)
				(= local105 21)
			)
			(3
				(= local0 2)
				(= local105 53)
			)
		)
		(keyPressed init: global117 hide:)
		(= currentKey -1)
		(gExtMouseHandler addToFront: self)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(keyPressed dispose:)
		(super dispose: &rest)
	)

	(method (showKeyUp)
		(keyPressed hide:)
	)

	(method (showKeyDown param1)
		(keyPressed show: param1)
		(gCurRoom notify: param1)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (or (not active) (event claimed:))
			(return)
		)
		(event localize: global116)
		(if
			(and
				(not (event type:))
				(self onMe: event)
				(!= (= temp1 (localproc_0 event)) -1)
			)
			(self doVerb: 1)
			(event claimed: 1)
			(return)
		)
		(if
			(and
				active
				(& (event type:) evMOUSEBUTTON)
				(!= (= temp1 (localproc_0 event)) -1)
			)
			(event claimed: 1)
			(= currentKey temp1)
			(gCurRoom notify: currentKey)
			(self doVerb: 2)
		else
			(event globalize:)
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb &tmp [temp0 2])
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (!= currentKey -1)
					(keyPressed show: currentKey)
					(self trace:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (setActive param1)
		(= active param1)
	)

	(method (trace &tmp temp0 temp1 temp2)
		(= temp2 1)
		(while (and (!= ((= temp1 (Event new:)) type:) evMOUSERELEASE) temp2)
			(temp1 localize: global116)
			(if (== (localproc_0 temp1) currentKey)
				(= temp2 1)
			else
				(= temp2 0)
			)
			(temp1 dispose:)
		)
		(keyPressed hide:)
		(temp1 dispose:)
	)
)

(instance keyPressed of View
	(properties)

	(method (init)
		(switch global269
			(1
				(= view 4000)
			)
			(2
				(= view 4100)
			)
			(3
				(= view 4200)
			)
		)
		(= cel 16)
		(super init: &rest)
	)

	(method (show param1 &tmp temp0 temp1 temp2 temp3)
		(if (!= param1 -1)
			(= temp3 (+ (/ local105 2) 1))
			(keySound number: [local1 (+ param1 temp3)] play:)
			(= temp0 [local36 (= temp2 (+ (* param1 2) local105))])
			(= temp1 [local36 (+ temp2 1)])
			(self cel: param1 posn: temp0 temp1)
			(super show: &rest)
			(FrameOut)
		)
	)
)

(instance keySound of Sound
	(properties
		flags 5
	)
)

