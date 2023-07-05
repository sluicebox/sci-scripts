;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use soFlashCyberSniff)
(use foEExit)
(use Scaler)
(use ROsc)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	ro260 0
)

(local
	local0
	local1 = 1
)

(instance ro260 of L7Room
	(properties
		picture 26000
	)

	(method (init &tmp temp0)
		(switch gPrevRoomNum
			(262 ; ro262
				(gEgo
					init:
					normalize: 0
					setScaler: Scaler 152 90 420 210
					posn: 169 327
				)
			)
			(261 ; ro261
				(if (OneOf global220 4 5 6)
					(gEgo
						init:
						normalize: global226
						setScaler: Scaler 152 90 420 210
						posn: global224 global225
					)
				else
					(if (> global221 320)
						(= temp0 (Min global221 595))
					else
						(= temp0 (Max global221 45))
					)
					(gEgo
						init:
						normalize:
						setScaler: Scaler 152 90 420 210
						posn: temp0 (- global222 50)
					)
				)
			)
			(else
				(gEgo
					init:
					normalize: 1
					setScaler: Scaler 152 90 420 210
					posn: 485 332
				)
			)
		)
		(super init:)
		(gOAmbience setAmbient: 13001)
		(if
			(or
				(== gPrevRoomNum 261) ; ro261
				(== global219 gCurRoomNum)
				(and (== global219 0) (< (Random 1 100) 50))
				(and (!= global219 gPrevRoomNum) (< (Random 1 100) 50))
			)
			(aoPeggy init:)
			(if (!= gPrevRoomNum 261) ; ro261
				(gOMusic1 stop: setMusic: 26100)
			)
		else
			(= global219 0)
			(= global220 0)
			(gOMusic1 fadeOut:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 3 280 6 389 115 390 131 424 501 425 501 403 633 403 633 278 418 278 404 299 262 299 234 279
						yourself:
					)
			)
		)
		(foWheel init:)
		(foVent init:)
		(foWindow init:)
		(foRail init:)
		(cond
			((and ((ScriptID 64017 0) test: 47) ((ScriptID 64017 0) test: 48)) ; oFlags, oFlags
				(foWheel myPriority: 73)
				(voHoseCabinet
					loop: 2
					y: (+ (voHoseCabinet y:) 100)
					z: (+ (voHoseCabinet z:) 100)
				)
			)
			(((ScriptID 64017 0) test: 47) ; oFlags
				(foWheel myPriority: 73)
				(voHoseCabinet
					loop: 2
					y: (+ (voHoseCabinet y:) 100)
					z: (+ (voHoseCabinet z:) 100)
				)
				(voHose init:)
			)
			(((ScriptID 64017 0) test: 48) ; oFlags
				(voHoseCabinet loop: 1)
			)
			(else
				(voHoseCabinet loop: 0)
			)
		)
		(voHoseCabinet init:)
		(if ((ScriptID 64017 0) test: 207) ; oFlags
			(foFish init:)
		else
			(voBush init:)
		)
		(foGoose init:)
		(foBeaver init:)
		(if (not ((ScriptID 64017 0) test: 226)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 625 410
				setDest: -40 395
				loop: 1
				cel: 9
				setPri: 410
				nMyFlag: 226
				init:
			)
		)
		(foExitWest init:)
		(foExitEast init:)
		(gCurRoom setScript: soCyberSniff)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(oSFXHum stop:)
		(if (OneOf global220 4 5 6)
			(oSFX fadeOut:)
		)
		(if (not (OneOf newRoomNumber 210 220 230 250 260 261 262)) ; ro210, ro220, ro230, ro250, ro260, ro261, ro262
			(gOAmbience stop:)
		)
		(if (not (OneOf newRoomNumber 230 260 261 262)) ; ro230, ro260, ro261, ro262
			(= global219 0)
			(= global220 0)
		)
		(if (!= newRoomNumber 261) ; ro261
			(gOMusic1 fadeOut:)
		)
		(super newRoom: newRoomNumber)
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
				(= ticks 120)
			)
			(2
				(if ((ScriptID 64017 0) test: 202) ; oFlags
					(proc64896_15 1 0)
				else
					(proc64896_15 1)
					((ScriptID 64017 0) set: 202) ; oFlags
				)
				(self dispose:)
			)
		)
	)
)

(instance soTrimBush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 60)
			)
			(2
				(aoPeggy setCycle: End self 12 99)
			)
			(3
				(oSFX playSound: 26105)
			)
			(4
				(oSFX setAmbient: 26106)
				(aoPeggy loop: 1 cel: 0 setCycle: Fwd)
				(= ticks 30)
			)
			(5
				(poBushTrimmings init: setCycle: CT 5 1 self)
			)
			(6
				(poBushTrimmings setCycle: ROsc -1 4 5)
			)
		)
	)
)

(instance soStopTrimming of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (aoPeggy loop:)
					((ScriptID 64017 0) set: 207) ; oFlags
					(if (gCast contains: voBush)
						(voBush dispose:)
					)
					(oSFX playSound: 26107)
					(poBushTrimmings setCycle: End)
					(aoPeggy setCycle: 0 loop: 2 cel: 0 setCycle: End self)
				else
					(oSFX fadeOut:)
					(aoPeggy setCycle: 0 setCycle: Beg)
					(= cycles 1)
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(gCurRoom newRoom: 261) ; ro261
				(self dispose:)
			)
		)
	)
)

(instance soSpotWeld of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 60)
			)
			(2
				(aoPeggy setCycle: End self 15 99)
			)
			(3
				(oSFX setAmbient: 26108)
			)
			(4
				(aoPeggy loop: 1 cel: 0 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance soStopWelding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSFX stop:)
				(aoPeggy setCycle: 0 loop: 2 cel: 0 setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(gCurRoom newRoom: 261) ; ro261
				(self dispose:)
			)
		)
	)
)

(instance soFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 60)
			)
			(2
				(aoPeggy loop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(oSFX playSound: 26103)
				(aoPeggy setCycle: CT 8 1 self)
			)
			(4
				(= ticks (Random 180 360))
			)
			(5
				(oSFX setAmbient: 26104)
				(aoPeggy setCycle: End self)
			)
			(6
				(aoPeggy
					loop: 1
					cel: 0
					setCycle: ForwardCounter (Random 2 6) self
				)
			)
			(7
				(aoPeggy loop: 2 cel: 0 setCycle: End self 11 99)
			)
			(8
				(oSFX stop:)
			)
			(9
				(self changeState: 2)
			)
		)
	)
)

(instance soStopFishing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (and (== (aoPeggy loop:) 0) (== (aoPeggy cel:) 8))
					(aoPeggy setScript: 0 setCycle: 0)
					(gCurRoom newRoom: 261) ; ro261
					(self dispose:)
				else
					(-- state)
					(= cycles 3)
				)
			)
		)
	)
)

(instance soPeggyShouts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if global229
					(proc64031_2 (MulDiv (= register global229) 30 100))
				else
					(= register 0)
				)
				(gMessager say: 1 51 0 1 self 261) ; "You poor little a*s licker. You don't have a clue what to do, do you?"
			)
			(1
				(proc64031_2 register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOpenCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 playSound: 50006 self)
			)
			(1
				(gMessager say: 1 61 1 0 self) ; "No alarm sounds."
			)
			(2
				((ScriptID 64017 0) set: 47) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCloseCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 playSound: 50007 self)
			)
			(1
				(gMessager say: 1 229 2 0 self) ; "You're so polite."
			)
			(2
				((ScriptID 64017 0) clear: 47) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aoPeggy of Actor
	(properties
		noun 7
		view 26000
		approachDist 1000
	)

	(method (init &tmp temp0)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
		(if (!= gPrevRoomNum 261) ; ro261
			(switch global220
				(1
					(cond
						((< (= temp0 (Random 1 100)) 25) 0)
						((< temp0 50)
							(= global220 4)
						)
						((< temp0 75)
							(= global220 5)
						)
						(else
							(= global220 6)
						)
					)
				)
				(2
					(cond
						((< (= temp0 (Random 1 100)) 25) 0)
						((< temp0 50)
							(= global220 4)
						)
						((< temp0 75)
							(= global220 5)
						)
						(else
							(= global220 6)
						)
					)
				)
				(3
					(cond
						((< (= temp0 (Random 1 100)) 25) 0)
						((< temp0 50)
							(= global220 4)
						)
						((< temp0 75)
							(= global220 5)
						)
						(else
							(= global220 6)
						)
					)
				)
				(else
					(= global220 (Random 1 6))
				)
			)
		)
		(= global219 260)
		(switch global220
			(4
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 3 280 6 389 115 390 131 424 501 425 501 403 633 403 633 278 503 279 490 309 186 309 162 280
							yourself:
						)
				)
				(self
					view: 26003
					loop: 0
					cel: 0
					posn: 400 300
					doit:
					setScript: soTrimBush
				)
				(Load 140 26105 26106 26107) ; WAVE
			)
			(5
				(= local0 1)
				(self
					view: 26004
					loop: 0
					cel: 0
					posn: 400 400
					setPri: 600
					doit:
					setScript: soSpotWeld
				)
				(Load 140 26108) ; WAVE
			)
			(6
				(= local0 1)
				(self
					view: 26005
					loop: 0
					cel: 0
					posn: 400 400
					setPri: 600
					doit:
					cycleSpeed: 8
					setScript: soFish
				)
				(Load 140 26103 26104) ; WAVE
			)
			(1
				(= local0 1)
				(self view: 26000 setLoop: 0 1 cel: 0 posn: 13 415)
				(if (== gPrevRoomNum 261) ; ro261
					(self posn: global221 global222)
				)
				(self
					doit:
					setScalePercent: 130
					setSpeed: 9
					setCycle: Walk
					setStep: 13 2
					setMotion: MoveTo 700 415 self
				)
				(if (Random 0 1)
					(oSFXHum playSound: 26111)
				)
			)
			(2
				(= local0 1)
				(self view: 26001 setLoop: 0 1 cel: 0 posn: 584 415)
				(if (== gPrevRoomNum 261) ; ro261
					(self posn: global221 global222)
				)
				(self
					doit:
					setScalePercent: 130
					setSpeed: 9
					setCycle: Walk
					setStep: 13 2
					setMotion: MoveTo -80 415 self
				)
				(if (Random 0 1)
					(oSFXHum playSound: 26111)
				)
			)
			(3
				(= local0 1)
				(= global220 3)
				(self view: 26002 setLoop: 0 1 cel: 0 posn: 13 415)
				(if (== gPrevRoomNum 261) ; ro261
					(self posn: global221 global222)
				)
				(self
					doit:
					setScalePercent: 130
					setSpeed: 11
					setCycle: Walk
					setStep: 15 2
					setMotion: MoveTo 700 415 self
				)
				(if (Random 0 1)
					(oSFXHum playSound: 26111)
				)
			)
		)
		(if local0
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 3 280 3 392 634 392 633 278 418 278 404 299 262 299 234 279
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(= global224 (gEgo x:))
				(= global225 (gEgo y:))
				(= global226 (gEgo cel:))
				(switch global220
					(4
						(gCurRoom setScript: soStopTrimming)
					)
					(5
						(gCurRoom setScript: soStopWelding)
					)
					(6
						(gCurRoom setScript: soStopFishing)
					)
					(else
						(self setMotion: 0)
						(= global221 (self x:))
						(= global222 (self y:))
						(gCurRoom newRoom: 261) ; ro261
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gOMusic1 fadeOut:)
		(oSFXHum fadeOut:)
		(if (> (self x:) 300)
			(= global219 230)
		else
			(= global219 262)
		)
		(self dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== global220 1) (== cel 5) (not (oSFX isPlaying:)))
				(oSFX playSound: 26110)
			)
			((and (== global220 3) (== cel 1) (not (oSFX isPlaying:)))
				(oSFX playSound: 26101)
			)
			((and (== global220 3) (== cel 7) (not (oSFX isPlaying:)))
				(oSFX playSound: 26102)
			)
			((and (== global220 2) (== cel 1) local1)
				(= local1 0)
				(oSFX playSound: 26109)
			)
			((and (== global220 2) (!= cel 1) (not local1))
				(= local1 1)
			)
		)
	)
)

(instance voHoseCabinet of View
	(properties
		noun 1
		priority 90
		x 402
		y 143
		view 26055
		z -100
		approachX 487
		approachY 282
		fixPriority 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(if ((ScriptID 64017 0) test: 47) ; oFlags
					(if (gCast contains: aoPeggy)
						(gMessager say: 2 0 0 3 0 60) ; "Maybe a hintbook would help...."
					else
						(gCurRoom setScript: soPeggyShouts)
					)
				else
					(if ((ScriptID 64017 0) test: 48) ; oFlags
						(= loop 2)
					else
						(= loop 2)
						(voHose init:)
					)
					(+= y 100)
					(+= z 100)
					(foWheel myPriority: 73)
					(gCurRoom setScript: soOpenCabinet)
				)
			)
			(229 ; Close
				(if ((ScriptID 64017 0) test: 47) ; oFlags
					(if ((ScriptID 64017 0) test: 48) ; oFlags
						(= loop 1)
					else
						(= loop 0)
						(voHose dispose:)
					)
					(-= y 100)
					(-= z 100)
					(foWheel myPriority: 173)
					(gCurRoom setScript: soCloseCabinet)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voHose of View
	(properties
		noun 6
		x 448
		y 188
		view 26050
		approachX 487
		approachY 282
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				((ScriptID 64017 0) set: 48) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 12)) ; oInvHandler, ioFirehose
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voBush of View
	(properties
		priority 100
		x 325
		y 250
		view 26007
		fixPriority 1
	)
)

(instance poBushTrimmings of Prop
	(properties
		priority 150
		x 400
		y 300
		view 26006
		fixPriority 1
	)
)

(instance foWheel of Feature
	(properties
		noun 2
		x 588
		y 173
		approachX 572
		approachY 278
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 570 155 588 148 605 152 614 164 613 184 597 198 577 199 567 187 562 171
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 220 addApproachVerb: 220)
	)
)

(instance foVent of Feature
	(properties
		noun 4
		x 513
		y 61
		approachX 485
		approachY 290
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 429 99 424 47 438 56 451 34 453 24 491 24 493 41 504 52 519 40 526 23 553 23 562 42 569 53 577 53 583 42 588 24 603 24 596 99
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foWindow of Feature
	(properties
		noun 3
		x 188
		y 122
		approachX 201
		approachY 292
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 374 46 356 148 336 157 328 136 336 121 326 116 306 139 316 151 328 150 326 159 315 174 302 158 288 161 285 181 264 164 253 168 265 195 259 218 86 220 67 176 67 171 88 170 111 204 121 192 98 162 133 154 135 124 124 126 112 143 95 148 92 125 58 113 46 133 46 159 63 214 48 211 33 192 15 182 4 192 2 53 14 45 18 27 53 27 60 46 70 58 82 46 89 27 125 26 131 45 142 54 151 54 159 26 200 26 200 45 214 54 228 37 228 26 274 25 281 47 293 54 307 37 308 25 347 25 348 43 363 55
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRail of Feature
	(properties
		noun 5
		x 319
		y 417
		approachX 320
		approachY 408
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 357 638 356 639 371 576 371 577 436 637 434 638 477 3 479 3 436 565 434 563 370 429 372 428 433 415 432 415 371 288 370 289 433 276 433 277 372 156 371 155 432 141 433 141 370 24 371 25 435 10 433 10 371
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foFish of Feature
	(properties
		noun 10
		x 324
		y 197
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 167 281 186 291 198 320 195 312 183 340 174 348 177 360 175 391 190 390 196 373 208 384 214 384 218 377 225 372 219 337 227 306 224 292 219 266 227 258 223 269 206 266 192 257 170
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGoose of Feature
	(properties
		noun 8
		x 76
		y 232
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 126 128 137 127 136 138 125 155 96 162 117 184 118 196 111 201 88 170 68 170 73 188 97 242 104 225 120 217 143 236 153 283 145 304 130 271 122 277 110 274 115 301 101 324 71 350 51 353 26 349 0 327 1 297 28 269 2 250 2 195 25 182 49 212 57 261 69 254 70 225 49 155 49 130 63 112 74 112 92 133 96 148 116 141
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBeaver of Feature
	(properties
		noun 9
		x 568
		y 308
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 500 225 507 211 524 212 529 222 537 223 547 211 559 213 563 206 573 224 582 213 601 208 604 225 589 239 596 266 583 277 594 294 593 312 605 321 613 287 637 282 638 353 629 382 614 391 602 388 596 408 538 411 517 376 527 353 541 338 524 319 541 305 549 307 546 289 536 284 498 272 498 260 513 249 515 230
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExitWest of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 40 0 40 480 0 480 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 262 -30 335)
	)
)

(instance foExitEast of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 600 0 640 0 640 370 600 370
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 230 675 335)
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oSFXHum of TPSound
	(properties)
)

