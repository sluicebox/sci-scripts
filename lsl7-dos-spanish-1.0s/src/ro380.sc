;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use DialogPlane)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use soFlashCyberSniff)
(use Str)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro380 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp3 (Str with: {}))
	(= temp0 (MakeMessageText 17 0 7 1 380))
	(= temp1 (MakeMessageText 17 0 7 2 380))
	(= temp2 (MakeMessageText 17 0 7 3 380))
	(if (== (= temp3 (proc64033_6 temp0 temp1 temp2 20)) 0)
		(proc64896_7 temp3)
		(return 0)
	)
	(temp3 lower:)
	(if (!= (temp3 size:) 8)
		(proc64896_7 temp3)
		(return 0)
	)
	(= temp4 (MakeMessageText 17 0 7 4 380))
	(if (== (temp4 weigh: temp3) 0)
		(proc64896_7 temp4)
		(proc64896_7 temp3)
		(return 1)
	)
	(proc64896_7 temp4)
	(proc64896_7 temp3)
	(return 0)
)

(instance ro380 of L7Room
	(properties
		picture 38000
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 266) ; oFlags
			(= local1 1)
		else
			(= local1 0)
		)
		(if (== gPrevRoomNum 387) ; ro387
			(gEgo
				init:
				normalize: 4
				setScaler: Scaler 150 100 454 321
				posn: 168 314
			)
			(= local1 1)
		else
			(gEgo
				init:
				normalize: 3
				setScaler: Scaler 150 100 454 321
				posn: 315 433
			)
		)
		(super init:)
		((ScriptID 64017 0) set: 95) ; oFlags
		(gOMusic1 setMusic: 38000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 394 475 448 435 438 269 205 267 15 380 240 474
					yourself:
				)
		)
		(if (not ((ScriptID 64017 0) test: 93)) ; oFlags
			(voJumperWire init:)
		)
		(if (not ((ScriptID 64017 0) test: 94)) ; oFlags
			(voKZJelly init:)
		)
		(foBulletinBoard init:)
		(foCabinets init:)
		(foCenterFold init:)
		(foCoffeePot init:)
		(foDiceBowl init:)
		(foFoosBall init:)
		(foCheesecake init:)
		(if local1
			(foLockerExit init:)
		else
			(foLockerBay init:)
			(foXLocker init:)
		)
		(poLockerBay init:)
		(foMicrowave init:)
		(foRefrigerator init:)
		(foSink init:)
		(foSnackMachine init:)
		(foSodaMachine init:)
		(foLSpeaker init:)
		(foRSpeaker init:)
		(poLSpeaker init:)
		(poRSpeaker init:)
		(foLTable init:)
		(foRTable init:)
		(foWaterCooler init:)
		(if (not ((ScriptID 64017 0) test: 235)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 562 357
				setDest: 650 320
				loop: 1
				setScaleDirect: 102
				setPri: 357
				nMyFlag: 235
				init:
			)
		)
		(foExitS init:)
		(gGame handsOn:)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 92) ; oFlags
	)
)

(instance soTakeJumperWire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 8 0 0 self) ; "Sure you can take the jumper wire, but why would you ever want to PREVENT a jackpot?"
			)
			(1
				(gGame handsOn:)
				((ScriptID 64017 0) set: 93) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 15)) ; oInvHandler, ioJumperWire
				(voJumperWire dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeKZJelly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 18 8 0 0 self) ; "You never know when you might find a..."
			)
			(1
				(gEgo get: ((ScriptID 64037 0) get: 18)) ; oInvHandler, ioKZJelly
				((ScriptID 64017 0) set: 94) ; oFlags
				(voKZJelly dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOpenMicrowave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 16 61 0 0 self) ; "Yuch! Doesn't anybody ever clean that thing?"
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOpenRefrigerator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 61 0 0 self) ; "Wheew! Get of whiff of that!"
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soListenSpeaker of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(gMessager say: 3 221 5 0 self) ; "Yes. You can hear something through the speaker now. So what?"
				else
					(gMessager say: 3 221 4 0 self) ; "Try as you might, you can't hear anything through the speaker because it's silent right now."
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTryLockerBay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(gGame handsOff:)
				(gMessager say: 1 61 3 0 self) ; "That combination doesn't seem to open that locker."
			)
			(1
				((ScriptID 64017 0) set: 288) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTryXLocker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 288) ; oFlags
					((ScriptID 64017 0) set: 309) ; oFlags
				)
				((ScriptID 64017 0) set: 288) ; oFlags
				((ScriptID 64017 0) test: 285) ; oFlags
				(if (localproc_0)
					(if ((ScriptID 64017 0) test: 92) ; oFlags
						(self setScript: soOpenXLocker2X self)
					else
						(self setScript: soOpenXLocker self)
					)
				else
					(gMessager say: 1 61 3 0 self) ; "That combination doesn't seem to open that locker."
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soOpenXLocker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 38501 38501 38602 38601)
				(gEgo walkTo: 151 320 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo hide:)
				(poLarry
					view: 38001
					loop: 0
					cel: 0
					posn: 151 328
					init:
					setCycle: End self 4 999
				)
			)
			(4
				(gOSound1 playSound: 38501)
			)
			(5
				(= ticks 30)
			)
			(6
				(poLarry setCycle: CT 4 -1 self)
				(gOSound1 playSound: 38501)
			)
			(7
				(= ticks 30)
			)
			(8
				(poLarry setCycle: End self)
				(gOSound1 playSound: 38501)
			)
			(9
				(gOSound1 playSound: 38503)
				(= ticks 30)
			)
			(10
				(poLarry dispose:)
				(poLockerBay cel: 1 doit: setCycle: End self 8 12)
				(gOSound1 playSound: 38601)
			)
			(11
				(gOSound1 playSound: 38602)
			)
			(12
				(gOSound1 preload: 38603 12601 20306)
				(poLarry
					view: 38002
					loop: 0
					cel: 0
					posn: 362 277
					init:
					setCycle: End self 25 28 55 999
				)
				(gOSound1 playSound: 38603)
			)
			(13
				(gOSound1 playSound: 12601)
			)
			(14
				(gOSound1 playSound: 20306)
			)
			(15
				(gMessager say: 17 61 3 2 self) ; "(SHAKE OUT YOUR HEAD TO GET IT BACK TO SHAPE) Flubbity, blubbity."
			)
			(16)
			(17
				(= cycles 2)
			)
			(18
				(poLarry dispose:)
				(gEgo posn: 362 280 normalize: 2 1 show:)
				(foLockerBay dispose:)
				(foXLocker dispose:)
				(foLockerExit init:)
				((ScriptID 64017 0) set: 92) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOpenXLocker2X of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 38501 25003 38602 38601)
				(gEgo walkTo: 199 323 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo hide:)
				(poLarry
					view: 38003
					loop: 0
					cel: 0
					posn: 202 324
					init:
					setCycle: End self 4 12 999
				)
			)
			(4
				(gOSound1 playSound: 38501)
			)
			(5
				(gOSound1 playSound: 25003)
			)
			(6
				(= cycles 2)
			)
			(7
				(poLarry dispose:)
				(gEgo posn: 547 336 normalize: 5 1 show:)
				(= ticks 60)
			)
			(8
				(gEgo walkTo: 136 317 self 0 1 0)
			)
			(9
				(gEgo hide:)
				(poLockerBay cel: 1 doit: setCycle: End self 8 12)
				(gOSound1 playSound: 38601)
			)
			(10
				(gOSound1 playSound: 38602)
			)
			(11
				(gOSound1 preload: 38603 12601 20306)
				(poLarry
					view: 38002
					loop: 0
					cel: 0
					posn: 362 277
					init:
					setCycle: End self 25 28 55 999
				)
				(gOSound1 playSound: 38603)
			)
			(12
				(gOSound1 playSound: 12601)
			)
			(13
				(gOSound1 playSound: 20306)
			)
			(14
				(gMessager say: 17 61 3 2 self) ; "(SHAKE OUT YOUR HEAD TO GET IT BACK TO SHAPE) Flubbity, blubbity."
			)
			(15)
			(16
				(= cycles 2)
			)
			(17
				(poLarry dispose:)
				(gEgo posn: 362 280 normalize: 2 1 show:)
				(foLockerBay dispose:)
				(foXLocker dispose:)
				(foLockerExit init:)
				((ScriptID 64017 0) set: 266) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poLockerBay of Prop
	(properties
		priority 10
		x 127
		y 298
		loop 1
		view 38002
		fixPriority 1
	)

	(method (init)
		(if local1
			(= cel 13)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance voJumperWire of View
	(properties
		noun 4
		priority 10
		x 397
		y 133
		loop 1
		view 38050
		approachX 390
		approachY 269
		fixPriority 1
	)

	(method (init)
		(= signal (& $efff signal))
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gCurRoom setScript: soTakeJumperWire)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voKZJelly of View
	(properties
		noun 18
		priority 184
		x 319
		y 194
		loop 4
		view 38050
		approachX 326
		approachY 269
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gCurRoom setScript: soTakeKZJelly)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBulletinBoard of Feature
	(properties
		noun 5
		x 371
		y 9
		approachX 374
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 424 164 427 144 442 140 447 140 455 62 384 64 327 63 288 64 292 160 348 160 358 165 359 161 375 161 379 156 394 156 409 156 414 159 414 165
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 97)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(97 ; Read
				(gMessager say: 5 97 1 global234)
				(if (== global234 6)
					((ScriptID 64017 0) set: 91) ; oFlags
				)
				(if (< global234 7)
					(++ global234)
				else
					((ScriptID 64017 0) set: 90) ; oFlags
					(= global234 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCabinets of Feature
	(properties
		noun 12
		x 352
		y 235
		approachX 374
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 413 258 419 254 423 211 282 211 284 255 290 255 290 260 353 260
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)
)

(instance foCenterFold of Feature
	(properties
		noun 14
		x 238
		y 194
		approachX 249
		approachY 268
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 228 254 218 256 205 250 185 257 165 255 161 253 164 226 167 224 164 220 166 224 170 222 185 226 202 224 224 223 227 240 228
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCheesecake of Feature
	(properties
		noun 19
		x 8
		y 366
		approachX 60
		approachY 382
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 90 28 96 28 281 1 297 yourself:)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foCoffeePot of Feature
	(properties
		noun 13
		x 302
		y 183
		approachX 301
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 309 201 318 195 317 165 290 165 286 168 286 178 290 178 290 188 289 196 287 198 288 201
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 67)
	)
)

(instance foDiceBowl of Feature
	(properties
		noun 6
		x 395
		y 165
		approachX 394
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 395 174 401 174 406 170 412 166 415 161 402 155 385 155 375 159 375 163 380 170 389 175
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foFoosBall of Feature
	(properties
		noun 10
		x 542
		y 270
		approachX 440
		approachY 308
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 638 234 620 225 446 226 448 260 452 263 453 306 448 314 456 316 458 314 456 307 456 265 474 281 474 310 479 310 479 281 498 281 506 288 510 288 513 280 523 283 528 286 530 286 532 281 614 281 612 316 616 316 618 316 618 279 631 280 636 279 638 279
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 79)
	)
)

(instance foLockerBay of Feature
	(properties
		noun 1
		x 141
		y 304
		approachX 152
		approachY 315
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 262 188 80 44 20 43 349
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61 97)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(gCurRoom setScript: soTryLockerBay)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foLockerExit of Feature
	(properties
		x 115
		y 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 262 188 80 44 20 43 349
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soExitLockers)
	)
)

(instance soExitLockers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 120 318 self)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 9 318 self 1 0 0)
			)
			(2
				(gCurRoom newRoom: 387) ; ro387
			)
		)
	)
)

(instance foMicrowave of Feature
	(properties
		noun 16
		x 396
		y 186
		approachX 395
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 418 201 422 177 408 170 399 174 391 174 384 172 380 169 371 170 370 191 379 203 409 203
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(gCurRoom setScript: soOpenMicrowave)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foRefrigerator of Feature
	(properties
		noun 2
		x 243
		y 182
		approachX 249
		approachY 268
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 272 260 284 250 284 210 278 210 278 202 283 200 283 123 273 106 240 105 206 109 204 155 203 198 205 227 205 241 209 241 210 259 241 260
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(gCurRoom setScript: soOpenRefrigerator)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foSink of Feature
	(properties
		noun 15
		x 346
		y 193
		approachX 350
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 377 206 378 206 365 189 361 189 361 185 353 183 345 181 340 184 334 183 334 187 314 204 350 206
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foSnackMachine of Feature
	(properties
		noun 9
		x 579
		y 177
		approachX 438
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 630 220 634 76 586 63 535 91 529 155 527 190 525 227 527 249 579 292 628 289 628 285 629 267
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foSodaMachine of Feature
	(properties
		noun 8
		x 501
		y 161
		approachX 438
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 524 225 528 156 534 102 509 96 484 111 472 118 468 171 468 227
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foRSpeaker of Feature
	(properties
		noun 3
		x 514
		y 56
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 543 64 549 30 530 25 498 43 506 55 491 50 484 50 480 62 482 77 493 86 503 88 506 78 508 69 512 75 519 76 541 68
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 221)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(221 ; Listen
				(if ((ScriptID 64017 0) test: 276) ; oFlags
					(gMessager say: 3 221 5 0) ; "Yes. You can hear something through the speaker now. So what?"
				else
					(gMessager say: 3 221 4 0) ; "Try as you might, you can't hear anything through the speaker because it's silent right now."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foLSpeaker of Feature
	(properties
		noun 3
		x 224
		y 56
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 73 220 69 225 62 231 70 235 80 240 82 250 76 255 64 256 54 251 49 246 49 241 52 231 51 235 45 208 30 192 36 192 64
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 221)
	)

	(method (doVerb theVerb)
		(foRSpeaker doVerb: theVerb)
	)
)

(instance poLSpeaker of Prop
	(properties
		noun 3
		priority 5
		x 219
		y 59
		cycleSpeed 9
		loop 2
		view 38050
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 221)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (not cycler) ((ScriptID 64017 0) test: 276)) ; oFlags
				(self setCycle: RandCycle -1)
			)
			((and cycler (not ((ScriptID 64017 0) test: 276))) ; oFlags
				(self setCycle: 0 cel: 0)
			)
		)
	)

	(method (doVerb theVerb)
		(foRSpeaker doVerb: theVerb)
	)
)

(instance poRSpeaker of Prop
	(properties
		noun 3
		priority 5
		x 514
		y 59
		cycleSpeed 9
		loop 3
		view 38050
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 221)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (not cycler) ((ScriptID 64017 0) test: 276)) ; oFlags
				(self setCycle: RandCycle -1)
			)
			((and cycler (not ((ScriptID 64017 0) test: 276))) ; oFlags
				(self setCycle: 0 cel: 0)
			)
		)
	)

	(method (doVerb theVerb)
		(foRSpeaker doVerb: theVerb)
	)
)

(instance foLTable of Feature
	(properties
		noun 11
		x 118
		y 417
		approachX 211
		approachY 424
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 222 478 234 469 236 458 215 443 174 430 175 402 172 370 163 359 144 357 126 361 114 371 107 388 104 404 96 416 72 413 59 413 55 393 40 384 15 382 0 384 0 478
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 94 8)
	)
)

(instance foRTable of Feature
	(properties
		noun 11
		x 519
		y 387
		approachX 446
		approachY 417
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 639 298 632 299 625 313 617 341 591 339 557 339 551 323 549 303 547 297 531 295 519 301 514 321 512 347 496 351 496 357 496 363 515 371 519 382 523 391 507 391 497 391 487 362 486 332 486 315 481 312 468 311 456 339 450 367 454 392 464 407 472 415 461 443 432 449 407 459 400 468 403 479 639 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 94 8)
	)
)

(instance foXLocker of Feature
	(properties
		noun 17
		x 141
		y 305
		approachX 152
		approachY 315
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 96 263 123 253 123 286 96 302
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61 97)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(gCurRoom setScript: soTryXLocker)
			)
			(253 ; Pick
				(foLockerBay doVerb: 253)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foWaterCooler of Feature
	(properties
		noun 7
		x 443
		y 198
		approachX 438
		approachY 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 458 225 458 216 462 214 465 212 464 180 461 178 462 146 453 140 437 140 426 145 426 187 432 196 423 196 423 200 428 205 429 213 421 213 421 246 432 257 449 257 446 226 459 227 458 225
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 67)
	)
)

(instance foExitS of Feature
	(properties
		x 318
		y 458
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 438 403 439 402 478 234 479
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitS)
	)
)

(instance soExitS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 315 433 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 315 490 self 0 0 0)
				(= ticks 20)
			)
			(2
				(gCurRoom newRoom: 381) ; ro381
			)
		)
	)
)

