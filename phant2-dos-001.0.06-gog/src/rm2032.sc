;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42032)
(include sci.sh)
(use Main)
(use nExit)
(use invItems)
(use n63002)
(use P2Feature)
(use Rectangle)
(use BorderWindow)
(use Cycle)
(use Jump)

(public
	rm2032 0
)

(local
	local0
	local1
)

(instance rm2032 of P2Room
	(properties
		picture 2032
		north 42030
		east 42030
		west 42030
	)

	(method (init)
		((ScriptID 0 6) dispose: 1) ; thunderTimer
		(InvPlane recalc: 0)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 1001)
		(wires4 init: 430 217 527 327)
		(wires3 init: 440 129 534 218)
		(if 1
			(pA init:)
			(pB init:)
			(pD init:)
			(pE init:)
			(pF init: hide:)
			(pH init:)
			(pJ init: setPri: 400)
			(pK init: hide:)
			(pN init:)
			(pQ1 init:)
			(pQ2 init:)
			(pQ3 init:)
			(pS1 init:)
			(pS2 init:)
			(pS3 init:)
			(pS4 init:)
			(pT1 init:)
			(pT2 init:)
			(pT3 init:)
			(pX init: setPri: 400)
			(pY init:)
			(pZ init: setPri: 10)
			(s1 init: 442 256 462 272)
			(s2 init: 455 249 473 261)
			(s3 init: 463 240 484 253)
			(s4 init: 470 228 488 241)
			(t1 init: 456 142 475 149)
			(t2 init: 462 154 481 160)
			(t3 init: 469 165 489 172)
		)
		((gUser mousers:) add: self)
		(gGame handsOn: 1)
		(gTheCursor set: 2590 0 0)
	)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(event localize: gThePlane)
		(if
			(and
				local1
				(not (& (event type:) evVERB))
				(not ((local1 rect:) onMe: event))
			)
			(self notify:)
		)
	)

	(method (notify)
		(if local1
			(local1 cel: 4 show:)
			(local1 initF:)
			(= local1 0)
			(gTheCursor set: 2590 0 0)
		)
	)

	(method (newRoom newRoomNumber)
		(InvPlane recalc: 1)
		(if (== newRoomNumber 9401) ; humanThresholdRm2
			(= global211 1)
			(= global212 0)
		)
		((gUser mousers:) delete: self)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance wires4 of Rectangle
	(properties)
)

(instance wires3 of Rectangle
	(properties)
)

(class CueProp of Prop
	(properties)

	(method (cue))
)

(instance pA of CueProp
	(properties
		x 165
		y 48
		view 2401
	)

	(method (init)
		(super init: &rest)
		(pAF init: 140 20 182 68)
	)

	(method (cue)
		(self cel: 0)
		(pQ1 setScript: flashyScript)
		(switch (pB cel:)
			(0
				(if (not (pN cycler:))
					(gP2SongPlyr start: 1002)
				)
				(pD setCycle: Fwd)
				(if (== (pE cel:) 2)
					(pC init: view: 2420 loop: 0 init: setCycle: Fwd)
				)
			)
			(1
				(if
					(and
						(not (pN cycler:))
						(not (pK cycler:))
						(not (pD cycler:))
					)
					(gP2SongPlyr start: 1006)
				)
				(pK show: setCycle: Fwd)
			)
		)
		(self setPri: 1)
	)
)

(instance pAF of P2Feature
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSERELEASE)
			(event claimed: 1)
			(pA
				view:
					(switch (pB cel:)
						(0 2401)
						(1 2402)
						(2 2403)
					)
				setPri: 1000
				cel: 0
				setCycle: End pA
			)
			(switch (pB cel:)
				(0
					(gP2SoundFX play: 3001)
				)
				(1
					(gP2SoundFX play: 3004)
				)
				(else
					(gP2SoundFX play: 4000)
				)
			)
		else
			(return 0)
		)
	)
)

(instance flashyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pX setCycle: Fwd)
				(pZ setCycle: Fwd)
				(= ticks 5)
			)
			(1
				(pQ1 cel: 1)
				(= ticks 18)
			)
			(2
				(pQ1 cel: 0)
				(pQ3 cel: 1)
				(= ticks 18)
			)
			(3
				(pQ3 cel: 0)
				(pQ2 cel: 1)
				(= ticks 18)
			)
			(4
				(pQ2 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance pB of Prop
	(properties
		x 137
		y 123
		view 2400
		loop 4
		cel 2
	)

	(method (init)
		(super init: &rest)
		(pBF init: 145 127 190 182)
	)
)

(instance pBF of P2Feature
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSERELEASE)
			(event claimed: 1)
			(gP2SoundFX play: 2001)
			(pB
				cel:
					(if (> (pB cel:) 1)
						0
					else
						(+ (pB cel:) 1)
					)
			)
		else
			(return 0)
		)
	)
)

(instance pC of CueProp
	(properties
		x 254
		y 117
		view 2400
		loop 6
	)

	(method (init)
		(super init: &rest)
		(pCF init: 240 106 268 133)
	)

	(method (cue)
		(pF cel: 0 loop: (pH cel:) show:)
		(pH hide:)
		(pF setCycle: End pJ)
		(self view: 2420 loop: 6 setCycle: Fwd)
	)
)

(instance pCF of P2Feature
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSERELEASE)
			(event claimed: 1)
			(if (== (pC view:) 2420)
				(gP2SoundFX play: 3003)
				(pC view: 2421 cel: 0 setCycle: End pC)
			)
		else
			(return 0)
		)
	)
)

(instance pD of Prop
	(properties
		x 277
		y 69
		view 2430
	)
)

(instance pE of CueProp
	(properties
		x 381
		y 60
		view 2400
		loop 5
	)

	(method (init)
		(super init: &rest)
		(pEF init: 360 43 404 79)
	)

	(method (cue)
		(pE view: 2400 loop: 5 cel: 0)
	)
)

(instance pEF of P2Feature
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (& (event type:) evMOUSERELEASE)
			(event claimed: 1)
			(if (>= (= temp0 (+ (pE cel:) 1)) 3)
				(= temp0 0)
			)
			(pE cel: temp0)
			(switch temp0
				(2
					(if (pZ cycler:)
						(pE view: 2631 loop: 0 cel: 0 setCycle: End pE)
						(if (pD cycler:)
							(gP2SoundFX play: 3002)
							(if
								(and
									(not (pN cycler:))
									(not (pK cycler:))
									(not (pD cycler:))
								)
								(gP2SongPlyr start: 1004)
							)
							(pC init: view: 2420 loop: 0 setCycle: Fwd)
						else
							(gP2SoundFX play: 2004)
						)
					)
				)
				(1
					(gP2SoundFX play: 2004)
					(if (pC cycler:)
						(pC view: 2400 loop: 6 cel: 0 setCycle: 0)
					)
					(if (!= (pX view:) 2611)
						(pE view: 2632 loop: 0 cel: 0 setCycle: End pX)
					else
						(pE view: 2400 loop: 5 cel: 1)
						(if
							(and
								(== (pS1 cel:) 0)
								(== (pS2 cel:) 2)
								(== (pS3 cel:) 1)
								(== (pS4 cel:) 3)
								(== (pT1 cel:) 2)
								(== (pT2 cel:) 1)
								(== (pT3 cel:) 0)
								(pY cycler:)
							)
							(pN hide:)
							(gP2SoundFX play: 4001)
							(pY
								setPri: 4000
								view: 2621
								loop: 0
								cel: 0
								setCycle: End pY
							)
						)
					)
				)
				(else
					(return 0)
				)
			)
		)
	)
)

(instance pF of Prop
	(properties
		x 233
		y 189
		view 2451
	)
)

(instance pH of Prop
	(properties
		x 187
		y 228
		view 2400
		loop 3
		cel 1
	)

	(method (init)
		(super init: &rest)
		(pHF init: 156 197 218 255)
	)
)

(instance pHF of P2Feature
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSERELEASE)
			(event claimed: 1)
			(gP2SoundFX play: 2002)
			(pC cel: 0)
			(pH
				cel:
					(if (> (pH cel:) 1)
						0
					else
						(+ (pH cel:) 1)
					)
			)
		else
			(return 0)
		)
	)
)

(instance pJ of CueProp
	(properties
		x 141
		y 281
		view 2480
	)

	(method (cue)
		(pH show:)
		(cond
			((pH cel:))
			((pK cycler:)
				(self show:)
				(self setCycle: End pK)
			)
			(else
				(if
					(and
						(not (pN cycler:))
						(not (pK cycler:))
						(not (pD cycler:))
					)
					(gP2SongPlyr start: 1005)
				)
				(self show:)
				(self setCycle: Fwd)
			)
		)
		(pF cel: 0 hide:)
	)
)

(instance pK of CueProp
	(properties
		x 117
		y 261
		view 2410
	)

	(method (cue)
		(gP2SoundFX play: 3005)
		(pJ show: setCycle: Fwd)
		(self setPri: 2000 view: 2491 cel: 0 posn: 164 283 setCycle: End pN)
	)
)

(instance pN of CueProp
	(properties
		x 280
		y 253
		view 2520
	)

	(method (cue)
		(if (!= (pK view:) 2410)
			(pK show: view: 2410 loop: 0 posn: 117 261 setCycle: Fwd)
			(gP2SongPlyr start: 1007)
		)
		(if (== local0 2)
			(cond
				(
					(and
						(== (pS1 cel:) 0)
						(== (pS2 cel:) 2)
						(== (pS3 cel:) 1)
						(== (pS4 cel:) 3)
						(== (pT1 cel:) 2)
						(== (pT2 cel:) 1)
						(== (pT3 cel:) 0)
						(== (pX view:) 2611)
						(!= view 2530)
					)
					(pN view: 2530 cel: 0 setCycle: End pN)
				)
				(
					(and
						(== (pS1 cel:) 0)
						(== (pS2 cel:) 2)
						(== (pS3 cel:) 1)
						(== (pS4 cel:) 3)
						(== (pT1 cel:) 2)
						(== (pT2 cel:) 1)
						(== (pT3 cel:) 0)
						(== (pN view:) 2530)
						(== (pX view:) 2611)
					)
					(pN hide:)
					(gP2SoundFX play: 4001)
					(pY setPri: 400 view: 2621 loop: 0 cel: 0 setCycle: End pY)
				)
				(
					(and
						(== (pS1 cel:) 0)
						(== (pS2 cel:) 2)
						(== (pS3 cel:) 1)
						(== (pS4 cel:) 3)
						(== (pT1 cel:) 2)
						(== (pT2 cel:) 1)
						(== (pT3 cel:) 0)
					)
					(gP2SongPlyr start: 1009)
					(pN hide:)
					(gP2SoundFX play: 3005)
					(pY setPri: 400 view: 2620 loop: 0 setCycle: Fwd)
				)
				(else
					(pN view: 2530 setCycle: Fwd)
				)
			)
		else
			(self view: 2520 setCycle: Fwd)
		)
	)
)

(instance pQ1 of CueProp
	(properties
		x 316
		y 237
		view 2400
	)

	(method (init)
		(super init: &rest)
		(pQ1F init: 315 270 335 283)
	)
)

(instance pQ1F of P2Feature
	(properties)

	(method (handleEvent event)
		(event claimed: 1)
		(cond
			((& (event type:) evMOUSERELEASE)
				(= local0 1)
				(pQ1 cel: 0)
				(gP2SoundFX play: 2003)
			)
			((& (event type:) evMOUSEBUTTON)
				(pQ1 cel: 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance pQ2 of CueProp
	(properties
		x 316
		y 237
		view 2400
		loop 1
	)

	(method (init)
		(super init: &rest)
		(pQ2F init: 335 260 352 273)
	)
)

(instance pQ2F of P2Feature
	(properties)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOUSERELEASE)
				(event claimed: 1)
				(gP2SoundFX play: 2003)
				(pQ2 cel: 0)
				(if (== local0 3)
					(= local0 2)
					(if (pN cycler:)
						(gP2SongPlyr start: 1008)
						(pN view: 2530 cel: 0 setCycle: End pE)
					)
				)
			)
			((& (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(pQ2 cel: 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance pQ3 of CueProp
	(properties
		x 316
		y 237
		view 2400
		loop 2
	)

	(method (init)
		(super init: &rest)
		(pQ3F init: 347 251 363 264)
	)

	(method (cue))
)

(instance pQ3F of P2Feature
	(properties)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOUSERELEASE)
				(event claimed: 1)
				(gP2SoundFX play: 2003)
				(if (== local0 1)
					(= local0 3)
				)
				(pQ3 cel: 0)
			)
			((& (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(pQ3 cel: 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(class TermFeature of P2Feature
	(properties
		wireCel 0
		connectWire 0
	)

	(method (init)
		(super init: &rest)
		(self addVerb: 42)
		(self delVerb: 4)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (& (event type:) evMOUSERELEASE)
			(event claimed: 1)
			(= temp0 connectWire)
			(= temp1 local1)
			(if local1
				(local1 cel: wireCel show:)
				(= connectWire local1)
				(= local1 0)
				(gTheCursor set: 2590 0 0)
				(gP2SoundFX play: 2005)
				(cond
					(
						(not
							(and
								(== (pS1 cel:) 0)
								(== (pS2 cel:) 2)
								(== (pS3 cel:) 1)
								(== (pS4 cel:) 3)
								(== (pT1 cel:) 2)
								(== (pT2 cel:) 1)
								(== (pT3 cel:) 0)
							)
						))
					(
						(and
							(== (pS1 cel:) 0)
							(== (pS2 cel:) 2)
							(== (pS3 cel:) 1)
							(== (pS4 cel:) 3)
							(== (pT1 cel:) 2)
							(== (pT2 cel:) 1)
							(== (pT3 cel:) 0)
							(== (pN view:) 2530)
							(== (pX view:) 2611)
						)
						(pN hide:)
						(gP2SoundFX play: 4001)
						(pY
							setPri: 400
							view: 2621
							loop: 0
							cel: 0
							setCycle: End pY
						)
					)
					((== (pN view:) 2530)
						(gP2SongPlyr start: 1009)
						(pN hide:)
						(gP2SoundFX play: 3005)
						(pY setPri: 400 view: 2620 loop: 0 setCycle: Fwd)
					)
				)
			)
			(if temp0
				(temp0 cel: 4 initF:)
				(if (not temp1)
					(= connectWire 0)
				)
			)
		)
	)
)

(instance s1 of TermFeature
	(properties)
)

(instance s2 of TermFeature
	(properties
		wireCel 1
	)
)

(instance s3 of TermFeature
	(properties
		wireCel 2
	)
)

(instance s4 of TermFeature
	(properties
		wireCel 3
	)
)

(class WireProp of CueProp
	(properties
		view 2580
		cel 4
		rect -1
		cursorLoop 0
		myF -1
	)

	(method (initF)
		(myF init: self)
	)

	(method (cue))
)

(class WireFeature of P2Feature
	(properties
		myWire -1
	)

	(method (init param1)
		(super init: &rest)
		(= myWire param1)
		(self addVerb: 42)
		(self delVerb: 4)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(event claimed: 1)
			(if local1
				(local1 cel: 4 show: initF:)
			)
			(= local1 myWire)
			(myWire hide:)
			(gTheCursor set: 2590 (myWire cursorLoop:) 0)
			(self dispose:)
		else
			(return 0)
		)
	)
)

(instance pS1 of WireProp
	(properties
		x 433
		y 214
		cursorLoop 1
	)

	(method (init)
		(super init: &rest)
		(= myF pS1F)
		(= rect wires4)
		(pS1F init: self)
	)
)

(instance pS1F of WireFeature
	(properties)

	(method (init param1)
		(super init: param1 481 296 497 330)
	)
)

(instance pS2 of WireProp
	(properties
		x 433
		y 214
		loop 1
		cursorLoop 2
	)

	(method (init)
		(super init: &rest)
		(= rect wires4)
		(pS2F init: self)
		(= myF pS2F)
	)
)

(instance pS2F of WireFeature
	(properties)

	(method (init param1)
		(super init: param1 465 287 475 311)
	)
)

(instance pS3 of WireProp
	(properties
		x 433
		y 214
		loop 2
		cursorLoop 3
	)

	(method (init)
		(super init: &rest)
		(pS3F init: self)
		(= rect wires4)
		(= myF pS3F)
	)
)

(instance pS3F of WireFeature
	(properties)

	(method (init param1)
		(super init: param1 457 292 477 315)
	)
)

(instance pS4 of WireProp
	(properties
		x 433
		y 214
		loop 3
		cursorLoop 4
	)

	(method (init)
		(super init: &rest)
		(pS4F init: self)
		(= rect wires4)
		(= myF pS4F)
	)
)

(instance pS4F of WireFeature
	(properties)

	(method (init param1)
		(super init: param1 453 277 465 288)
	)
)

(instance t1 of TermFeature
	(properties
		wireCel 2
	)
)

(instance t2 of TermFeature
	(properties
		wireCel 1
	)
)

(instance t3 of TermFeature
	(properties)
)

(instance pT1 of WireProp
	(properties
		x 444
		y 130
		loop 4
		cursorLoop 5
	)

	(method (init)
		(super init: &rest)
		(pT1F init: self)
		(= rect wires3)
		(= myF pT1F)
	)
)

(instance pT1F of WireFeature
	(properties)

	(method (init param1)
		(super init: param1 491 188 496 201)
	)
)

(instance pT2 of WireProp
	(properties
		x 444
		y 130
		loop 5
		cursorLoop 6
	)

	(method (init)
		(super init: &rest)
		(pT2F init: self)
		(= rect wires3)
		(= myF pT2F)
	)
)

(instance pT2F of WireFeature
	(properties)

	(method (init param1)
		(super init: param1 482 183 490 203)
	)
)

(instance pT3 of WireProp
	(properties
		x 444
		y 130
		loop 6
		cursorLoop 7
	)

	(method (init)
		(super init: &rest)
		(pT3F init: self)
		(= rect wires3)
		(= myF pT3F)
	)
)

(instance pT3F of WireFeature
	(properties)

	(method (init param1)
		(super init: param1 495 192 505 206)
	)
)

(instance pX of CueProp
	(properties
		x 428
		y 105
		view 2610
	)

	(method (cue)
		(pE view: 2400 loop: 5 cel: 1)
		(self view: 2611 cel: 0 setCycle: Fwd)
		(if
			(and
				(== (pS1 cel:) 0)
				(== (pS2 cel:) 2)
				(== (pS3 cel:) 1)
				(== (pS4 cel:) 3)
				(== (pT1 cel:) 2)
				(== (pT2 cel:) 1)
				(== (pT3 cel:) 0)
				(== (pN view:) 2530)
				(== (pX view:) 2611)
			)
			(pN hide:)
			(gP2SoundFX play: 4001)
			(pY setPri: 400 view: 2621 cel: 0 setCycle: End pY)
		)
	)
)

(instance pY of CueProp
	(properties
		x 405
		y 123
		view 2620
	)

	(method (cue)
		(gP2SoundFX play: 4002)
		(self cel: 0 setCycle: End pZ)
	)
)

(instance pZ of CueProp
	(properties
		x 363
		view 2630
		cycleSpeed 3
	)

	(method (cue)
		(SetFlag 715)
		(= global209 10310)
		(gCurRoom newRoom: 9401) ; humanThresholdRm2
	)
)

