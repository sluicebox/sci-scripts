;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 262)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use soFlashCyberSniff)
(use foEExit)
(use Talker)
(use Scaler)
(use ROsc)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro262 0
)

(local
	local0
	local1
	local2
)

(instance ro262 of L7Room
	(properties
		picture 26200
	)

	(method (init)
		(switch gPrevRoomNum
			(230 ; ro230
				(gEgo
					init:
					normalize: 5
					setScaler: Scaler 180 56 402 222
					posn: 356 228
				)
			)
			(261 ; ro261
				(gEgo
					init:
					normalize:
					setScaler: Scaler 180 56 402 222
					posn: (Min global221 595) (- global222 50)
				)
			)
			(else
				(gEgo
					init:
					normalize: 1
					setScaler: Scaler 180 56 402 222
					posn: 610 335
				)
			)
		)
		(super init:)
		(gOAmbience setAmbient: 13001)
		(if
			(and
				(or
					(== gPrevRoomNum 261) ; ro261
					(== global219 gCurRoomNum)
					(and (== global219 0) (< (Random 1 100) 50))
					(and (!= global219 gPrevRoomNum) (< (Random 1 100) 50))
				)
				(!= global219 230)
			)
			(aoPeggy init:)
			(gOMusic1 stop: setMusic: 26100)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 385 229 442 205 438 192 371 219 338 211 266 234 179 266 134 300 140 336 332 364 338 383 370 395 635 396 635 293 511 293 385 260
						yourself:
					)
			)
		else
			(= global352 toRod)
			(poBalloonGuy init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 385 229 442 205 438 192 371 219 338 211 266 234 179 266 134 300 140 336 332 364 341 422 393 429 513 430 635 430 636 285 509 323 325 293
						yourself:
					)
			)
			(= global219 0)
			(= global220 0)
			(gOMusic1 fadeOut:)
		)
		(if (not ((ScriptID 64017 0) test: 49)) ; oFlags
			(voKumquat init:)
		)
		(foKumquatTree init:)
		(foRailing init:)
		(foRoom init:)
		(foWindows init:)
		(foScrew init:)
		(if (not ((ScriptID 64017 0) test: 227)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 128 414
				setDest: 680 414
				loop: 0
				cel: 0
				setPri: 414
				xStep: 12
				nMyFlag: 227
				init:
			)
		)
		(foExitEast1 init:)
		(foExitEast2 init:)
		(gCurRoom setScript: soCyberSniff)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (and (>= global223 3) (not ((ScriptID 64017 0) test: 218))) ; oFlags
			((ScriptID 64017 0) set: 218) ; oFlags
			(gGame handsOff:)
			(self setScript: soRodTrick)
			(return)
		)
		(oSFXHum stop:)
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

	(method (dispose)
		(= global352 0)
		(super dispose:)
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

(instance soBalloonGags of Script ; UNUSED
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
				(if (< (Random 1 100) 51)
					(self setScript: soSingleAnimal self)
				else
					(self setScript: soDoubleAnimal self)
				)
			)
			(3
				(= ticks (Random 120 300))
			)
			(4
				(self changeState: 2)
			)
		)
	)
)

(instance soSingleAnimal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 26206 26201 26202 26204) ; WAVE
				(poBalloonGuy
					view: 26200
					loop: 0
					cel: 0
					setCycle: End self 12 31 43 45 59 999
				)
			)
			(1
				(oSFX playSound: 26206)
			)
			(2
				(oSFX playSound: 26201)
			)
			(3
				(oSFX stop:)
			)
			(4
				(oSFX playSound: 26202)
			)
			(5
				(oSFX stop:)
			)
			(6
				(= ticks 30)
			)
			(7
				(if (< global223 15)
					(= register (- 15 global223))
				else
					(= register (- 28 global223))
					(if (== global223 27)
						(= global223 14)
					)
				)
				(if (OneOf register 2 5 6 8 9 11 12 13)
					(= local0 0)
				else
					(= local0 1)
				)
				(if local2
					(= local0 0)
				)
				(if (== local0 0)
					(poBalloonGuy
						view: 26204
						loop: 0
						cel: 0
						setCycle: CT 10 1 self
					)
				else
					(poBalloonGuy
						view: 26203
						loop: 0
						cel: 0
						setCycle: CT 5 1 self
					)
				)
			)
			(8
				(voRodMustache init:)
				(= global352 toRod2)
				(if local2
					(gMessager say: 1 80 0 0 self) ; "It's my penis!"
				else
					(gMessager say: 1 4 3 register self)
				)
				(if (== local0 0)
					(poBalloonGuy setCycle: RangeRandCycle -1 11 15)
				else
					(poBalloonGuy setCycle: ROsc -1 6 17)
				)
			)
			(9
				(cond
					(local2
						(= cycles 1)
					)
					((mod global223 2)
						(gMessager sayRange: 1 4 10 1 2 self) ; "But that doesn't look like that."
					)
					(else
						(gMessager sayRange: 1 4 4 1 2 self) ; "But that doesn't look anything like that!"
					)
				)
			)
			(10
				(cond
					(local2
						(= local2 0)
						(= cycles 1)
					)
					((and (mod global223 2) (< global223 4))
						(gMessager say: 1 4 10 3 self) ; "Ugh. You can keep it, okay?"
					)
					((< global223 4)
						(gMessager say: 1 4 10 3 self) ; "Ugh. You can keep it, okay?"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(11
				(if (== local0 0)
					(poBalloonGuy setCycle: End self 16 999)
				else
					(poBalloonGuy setCycle: End self 18 999)
				)
			)
			(12
				(voRodMustache dispose:)
			)
			(13
				(poBalloonGuy view: 26207 loop: 0 cel: 0 setCycle: End self)
				(oSFX playSound: 26204)
			)
			(14
				(= global352 toRod)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDoubleAnimal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 26206 26201 26203 26202 26205) ; WAVE
				(poBalloonGuy
					view: 26200
					loop: 0
					cel: 0
					setCycle: End self 12 31 43 45 59 999
				)
			)
			(1
				(oSFX playSound: 26206)
			)
			(2
				(oSFX playSound: 26201)
			)
			(3
				(oSFX stop:)
			)
			(4
				(oSFX playSound: 26203)
			)
			(5
				(oSFX stop:)
			)
			(6
				(= ticks 30)
			)
			(7
				(poBalloonGuy view: 26201 loop: 0 cel: 0 setCycle: End self)
			)
			(8
				(poBalloonGuy view: 26200 loop: 0 cel: 0)
				((= register (Prop new:))
					view: 26202
					loop: 0
					cel: 0
					posn: (+ (poBalloonGuy x:) 2) (- (poBalloonGuy y:) 56)
					setPri: (+ (poBalloonGuy priority:) 5)
					init:
					setCycle: Fwd
				)
				(= ticks 20)
			)
			(9
				(poBalloonGuy setCycle: End self 12 31 43 45 59 999)
			)
			(10
				(oSFX playSound: 26206)
			)
			(11
				(oSFX playSound: 26201)
			)
			(12
				(oSFX stop:)
			)
			(13
				(oSFX playSound: 26202)
			)
			(14
				(oSFX stop:)
			)
			(15
				(Load rsVIEW 26205 26206)
				(= ticks 30)
			)
			(16
				(poBalloonGuy
					view: 26205
					loop: 0
					cel: 0
					doit:
					setCycle: CT 6 1 self
				)
				(register dispose:)
			)
			(17
				(voRodMustache init: doit:)
				(poBalloonGuy cel: 7 doit:)
				(= global352 toRod2)
				(= register (Random 1 4))
				(switch register
					(1
						(gMessager say: 1 4 3 1 self) ; "Look! It's Godzilla!"
					)
					(2
						(gMessager say: 1 4 3 3 self) ; "Look! It's Tyrannosaurus Rex!"
					)
					(3
						(gMessager say: 1 4 3 4 self) ; "Look! It's Manimal!"
					)
					(4
						(gMessager say: 1 4 3 9 self) ; "Look! It's an attacking bird!"
					)
				)
			)
			(18
				(poBalloonGuy cel: 8)
				(switch register
					(1
						(gMessager say: 1 4 3 2 self) ; "Look! It's Mothra!"
					)
					(2
						(gMessager say: 1 4 3 11 self) ; "Look! It's a pterodactyl!"
					)
					(3
						(gMessager say: 1 4 3 7 self) ; "Look! It's Reptilla!"
					)
					(4
						(gMessager say: 1 4 3 10 self) ; "Look! It's a bunny rabbit!"
					)
				)
			)
			(19
				(gMessager say: 1 4 11 1 self) ; "Look! They're fighting!"
			)
			(20
				(= global352 0)
				(poBalloonGuy setCycle: End self 9 12 36 999)
			)
			(21
				(voRodMustache dispose:)
			)
			(22
				(gMessager say: 1 4 11 (Random 2 4))
			)
			(23
				(gMessager kill:)
				(oSFX playSound: 26205)
			)
			(24
				(= global352 toRod)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soRodTrick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 4 6 1 self) ; "Wait! I learned something new!"
			)
			(1
				(if (> (gEgo x:) 640)
					(gEgo
						walkTo: (- (gEgo x:) 60) (gEgo y:) self 1 0 0
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					walkTo:
						(poBalloonGuy approachX:)
						(poBalloonGuy approachY:)
						self
						0
						1
						1
				)
			)
			(3
				(Face gEgo poBalloonGuy self)
			)
			(4
				(= cycles 3)
			)
			(5
				(gMessager say: 1 4 6 2 self) ; "Not again!"
			)
			(6
				(poBalloonGuy cue:)
				(self dispose:)
			)
		)
	)
)

(instance soExitBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 442 205 self)
			)
			(1
				(gGame handsOff:)
				(if
					(or
						((ScriptID 64017 0) test: 310) ; oFlags
						(and
							(>= global223 3)
							(not ((ScriptID 64017 0) test: 218)) ; oFlags
						)
					)
					(= cycles 1)
				else
					((ScriptID 64017 0) set: 310) ; oFlags
					(gMessager say: 0 0 9 0 self) ; "Whoa! Look at all the cool stuff back here. Oh, well."
				)
			)
			(2
				(gCurRoom newRoom: 230) ; ro230
				(self dispose:)
			)
		)
	)
)

(instance soLookRailing of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 3 1 0 1 2 self) ; "If you look over this railing, you can see the nude sunbathers down by the pool."
			)
			(1
				(gEgo walkTo: 339 407 self)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(= cycles 3)
			)
			(4
				(gMessager say: 3 1 0 3 self) ; "By golly, you can! Look at that! (BEAT) And that! (BEAT) And THAT!! Wow."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLookOverRailing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 1 0 1 self) ; "If you look over this railing, you can see the nude sunbathers down by the pool."
				(gEgo walkTo: 139 297 self)
			)
			(1
				(= register 0)
				(if (not (gTalkers isEmpty:))
					(= register 1)
					(gEgo setHeading: 270 self)
				)
			)
			(2
				(if register
					0
				else
					(gEgo setHeading: 270 self)
				)
			)
			(3
				(= cycles 3)
			)
			(4
				(gMessager sayRange: 3 230 0 2 3 self) ; "Oh my God. Nude Volleyball, Nude Roller Derby, Nude Lawn Darts, Nude Curling, Nude Caber Tossing, Nude Ferret Legging, even Nude Gerbil Colonics. I can't take any more!"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aoPeggy of Actor
	(properties
		noun 4
		x 336
		y 425
		view 26000
		approachDist 1000
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
		(if
			(or
				(and (!= gPrevRoomNum 261) (!= global219 gCurRoomNum)) ; ro261
				(== global220 2)
			)
			(if (< (Random 1 100) 51)
				(= global220 1)
			else
				(= global220 3)
			)
		)
		(= global219 262)
		(switch global220
			(1
				(self view: 26000 setLoop: 0 1 cel: 0)
				(if (== gPrevRoomNum 261) ; ro261
					(self posn: global221 global222)
				)
				(self
					setScalePercent: 150
					setSpeed: 9
					setCycle: Walk
					setStep: 13 2
					setMotion: MoveTo 700 425 self
				)
				(Load 140 26110) ; WAVE
			)
			(3
				(= global220 3)
				(self view: 26002 setLoop: 0 1 cel: 0)
				(if (== gPrevRoomNum 261) ; ro261
					(self posn: global221 global222)
				)
				(self
					setScalePercent: 150
					setSpeed: 11
					setCycle: Walk
					setStep: 15 2
					setMotion: MoveTo 700 425 self
				)
				(Load 140 26101 26102) ; WAVE
			)
		)
		(if (Random 0 1)
			(oSFXHum playSound: 26111)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1 0 0 0 260) ; "Peggy is the ship's surly foul-mouthed deckhand. Heavily affected by a childhood spent watching too many pirate movies, she thinks she's a swashbuckler. She even had her peg leg rigged to accept multiple interchangeable janitorial attachments."
			)
			(4 ; Talk
				(self setMotion: 0)
				(= global224 (gEgo x:))
				(= global225 (gEgo y:))
				(= global226 (gEgo cel:))
				(= global221 (self x:))
				(= global222 (self y:))
				(gCurRoom newRoom: 261) ; ro261
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gOMusic1 fadeOut:)
		(oSFXHum fadeOut:)
		(= global219 260)
		(self dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== global220 1) (== cel 5) (not (oSFX2 isPlaying:)))
				(oSFX2 playSound: 26110)
			)
			((and (== global220 3) (== cel 1) (not (oSFX2 isPlaying:)))
				(oSFX2 playSound: 26101)
			)
			((and (== global220 3) (== cel 7) (not (oSFX2 isPlaying:)))
				(oSFX2 playSound: 26102)
			)
		)
	)
)

(instance poBalloonGuy of Prop
	(properties
		noun 1
		x 447
		y 283
		view 26200
		approachX 539
		approachY 328
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; Grope
				(gGame handsOff:)
				(= local2 1)
				(gCurRoom setScript: soSingleAnimal)
			)
			(4 ; Talk
				(switch (++ global223)
					(1
						(gMessager say: 1 4 1) ; "What are you doing?"
					)
					(2
						(gGame handsOff:)
						(= local1 0)
						(gMessager say: 1 4 2 0 self) ; "So exactly what is it you do?"
					)
					(3
						(gGame handsOff:)
						(= local1 0)
						(gMessager say: 1 4 5 0 self) ; "Uh..."
					)
					(4
						(gGame handsOff:)
						(= local1 1)
						(gMessager say: 1 4 8 0 self) ; "Hey, I recognize you!"
					)
					(5
						(gMessager say: 1 4 7) ; "I just figured out why you're here."
					)
					(else
						(gGame handsOff:)
						(if local1
							(= local1 0)
						else
							(= local1 1)
						)
						(gMessager say: 1 4 5 0 self) ; "Uh..."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if local1
			(gCurRoom setScript: soDoubleAnimal)
		else
			(gCurRoom setScript: soSingleAnimal)
		)
	)
)

(instance voRodMustache of View
	(properties
		loop 1
		view 26206
	)

	(method (init)
		(= x (poBalloonGuy x:))
		(= y (poBalloonGuy y:))
		(self setPri: (+ (poBalloonGuy priority:) 5))
		(super init:)
	)
)

(instance voKumquat of View
	(properties
		noun 6
		x 236
		y 249
		view 26250
		approachX 314
		approachY 358
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(foKumquatTree doVerb: theVerb)
	)
)

(instance foKumquatTree of Feature
	(properties
		noun 6
		x 150
		y 201
		approachX 314
		approachY 358
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 16 123 39 124 56 101 86 94 111 94 123 110 169 86 226 94 246 114 251 94 273 87 285 108 271 131 281 141 273 154 273 199 255 223 207 249 194 316 165 317 165 280 153 248 116 235 95 214 93 230 89 238 68 243 45 222 49 202 32 163 36 143
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(if (not ((ScriptID 64017 0) test: 49)) ; oFlags
			(self addHotspotVerb: 8)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				((ScriptID 64017 0) set: 49) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 17)) ; oInvHandler, ioKumquat
				(gOSound1 playSound: 26004)
				(self deleteHotspotVerb: 8)
				(voKumquat dispose:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foRailing of Feature
	(properties
		noun 3
		y 460
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 67 301 86 272 98 264 99 249 112 233 121 239 110 258 116 276 149 307 188 329 271 352 404 355 636 355 636 371 607 371 607 433 635 432 635 451 357 450 279 443 165 407 100 360 74 319 83 313 115 351 155 380 230 411 358 432 516 434 593 434 595 370 457 371 456 429 444 429 444 372 321 370 315 422 301 420 308 367 258 362 221 352 207 400 195 394 214 350 168 333 152 376 142 369 160 328 136 315 121 353 113 345 128 310 115 300 102 333 94 326 110 293 103 281 88 316 81 310 99 276 96 276 84 292 81 310 76 315
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 230 addApproachVerb: 230)
		(foRailing2 init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 0 0 0 230) ; "This railing runs around the entire ship and yet it never gets tired. Ugh."
			)
			(230 ; Look over
				(gCurRoom setScript: soLookOverRailing)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foRailing2 of Feature
	(properties
		noun 3
		y 460
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 180 355 170 355 175 344 176 344 186 356 185 356 196 269 214 275 198 340 187 340 177 320 180 320 189 315 189 314 180 293 183 294 193 290 193 287 185 275 188
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 230 addApproachVerb: 230)
	)

	(method (doVerb theVerb)
		(foRailing doVerb: theVerb)
	)
)

(instance foRoom of Feature
	(properties
		noun 5
		x 318
		y 392
		approachX 420
		approachY 338
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 426 68 306 82 344 132 393 228 432 362 454 636 452 636 479 0 479 0 427
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foWindows of Feature
	(properties
		noun 2
		x 461
		y 118
		approachX 554
		approachY 310
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 451 29 479 26 479 44 491 56 500 56 506 41 509 25 516 24 494 212 407 196
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(foWindow2 init:)
	)
)

(instance foWindow2 of Feature
	(properties
		noun 2
		x 580
		y 120
		approachX 554
		approachY 310
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 523 219 533 24 551 23 552 40 561 49 561 54 572 54 571 47 581 39 581 22 619 21 619 39 631 47 631 54 637 54 638 219
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foScrew of Feature
	(properties
		noun 7
		x 382
		y 155
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 367 200 367 191 372 187 365 174 379 101 388 101 399 176 392 187 400 193 400 202 388 209 371 209 365 201
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExitEast1 of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 600 0 640 0 640 480 600 480
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 260 682 335)
	)
)

(instance foExitEast2 of ExitFeature
	(properties
		x 378
		y 135
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 395 239 357 239 358 31 452 29
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitBack)
	)
)

(instance toRod of Talker
	(properties)

	(method (init)
		(super init: poRodMouth voRodBody)
		(poBalloonGuy hide:)
	)

	(method (dispose)
		(poBalloonGuy show:)
		(super dispose:)
	)
)

(instance poRodMouth of Prop
	(properties
		loop 1
		view 26206
	)

	(method (init)
		(= x (+ (poBalloonGuy x:) 1))
		(= y (poBalloonGuy y:))
		(self setPri: (+ (poBalloonGuy priority:) 5))
		(super init:)
	)
)

(instance voRodBody of View
	(properties
		view 26206
	)

	(method (init)
		(= x (+ (poBalloonGuy x:) 1))
		(= y (poBalloonGuy y:))
		(self setPri: (poBalloonGuy priority:))
		(super init:)
	)
)

(instance toRod2 of Talker
	(properties)

	(method (init)
		(super init: poRodMouth)
		(voRodMustache hide:)
	)

	(method (dispose)
		(voRodMustache show:)
		(super dispose:)
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oSFX2 of TPSound
	(properties)
)

(instance oSFXHum of TPSound
	(properties)
)

