;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use oAnnounceTimer)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro210 0
)

(local
	local0
)

(instance ro210 of L7Room
	(properties
		picture 21000
	)

	(method (init)
		(switch gPrevRoomNum
			(200 ; ro200
				(gGame handsOff:)
				(if ((ScriptID 64017 0) test: 267) ; oFlags
					(proc80_1 0)
					(gEgo init: view: 21000 loop: 0 cel: 0 posn: 293 419)
				else
					(gEgo
						init:
						normalize: 2
						view: 21000
						loop: 3
						cel: 99
						posn: 293 419
					)
				)
			)
			(211 ; ro211
				(gEgo
					init:
					normalize: 2
					setScaler: Scaler 130 100 441 402
					posn: 336 418
				)
			)
			(else
				(gEgo
					init:
					normalize: 7
					setScaler: Scaler 130 100 441 402
					posn: 599 474
				)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 287 391 162 401 346 475 632 475 632 456
					yourself:
				)
		)
		(gOMusic1 setMusic: 0)
		(gOAmbience setAmbient: 13001)
		(poSpeaker init:)
		(cond
			(((ScriptID 64017 0) test: 27) ; oFlags
				(voOpenFuseBox loop: 2 init:)
			)
			(((ScriptID 64017 0) test: 25) ; oFlags
				(voOpenFuseBox init:)
			)
			(else
				(foFuseBox init:)
			)
		)
		(foDoorHandle init:)
		(foLifePreserver init:)
		(foPorthole init:)
		(foUpperDeck init:)
		(foUpperLadder init:)
		(foBridgeInt init:)
		(foExitEast init:)
		(foLowerLadder init:)
		(cond
			(((ScriptID 64017 0) test: 267) ; oFlags
				((ScriptID 64017 0) clear: 267) ; oFlags
				(gCurRoom setScript: soDazed)
			)
			((== gPrevRoomNum 200) ; ro200
				(gCurRoom setScript: soClimbDown)
			)
			(else
				(gCurRoom setScript: soCyberSniff)
				(gGame handsOn:)
			)
		)
	)

	(method (cue)
		((ScriptID 64017 0) clear: 276) ; oFlags
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 39) ((ScriptID 64037 0) get: 15)) ; oInvHandler, ioScrewdriver, oInvHandler, ioJumperWire
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 210 220 230 250 260 262)) ; ro210, ro220, ro230, ro250, ro260, ro262
			(gOAmbience stop:)
		)
		(if
			(and
				((ScriptID 64017 0) test: 24) ; oFlags
				((ScriptID 64017 0) test: 27) ; oFlags
				(!= newRoomNumber 210) ; ro210
			)
			((ScriptID 64017 0) clear: 27) ; oFlags
		)
		((ScriptID 64017 0) clear: 276) ; oFlags
		(proc80_1 1)
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
				(if ((ScriptID 64017 0) test: 290) ; oFlags
					(proc64896_15 1 0)
				else
					(proc64896_15 1)
					((ScriptID 64017 0) set: 290) ; oFlags
				)
				(self dispose:)
			)
		)
	)
)

(instance soDazed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: soStars)
				(= cycles 3)
			)
			(1
				(= ticks (Random 120 180))
			)
			(2
				(= register (gEgo cycleSpeed:))
				(gEgo loop: 1 cycleSpeed: 6 setCycle: End self 10 999)
			)
			(3
				(oSFX stop:)
				(gEgo setScript: 0)
				(poStars setCycle: End poStars)
			)
			(4
				(gEgo
					normalize: 4
					setScaler: Scaler 130 100 441 402
					cycleSpeed: register
					posn: 359 446
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soStars of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oSFX setAmbient: 20307)
				(poStars init: setLoop: 2 1 setCycle: CT 5 1 self)
			)
			(1
				(poStars cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(self changeState: (- state 1))
			)
		)
	)
)

(instance soClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 500 443 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64017 0) set: 26) ; oFlags
				(gEgo
					setScale: 0
					view: 21000
					loop: 3
					cel: 9
					posn: 293 419
					setCycle: End self
				)
			)
			(2
				(gCurRoom newRoom: 200) ; ro200
				(self dispose:)
			)
		)
	)
)

(instance soClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 9 -1 self)
			)
			(1
				(gEgo
					posn: 500 443
					normalize: 6
					setScaler: Scaler 130 100 441 402
				)
				(if ((ScriptID 64017 0) test: 290) ; oFlags
					(proc64896_15 1 0)
				else
					(proc64896_15 1)
					((ScriptID 64017 0) set: 290) ; oFlags
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poStars of Prop
	(properties
		priority 500
		x 293
		y 419
		loop 2
		view 21000
		fixPriority 1
	)

	(method (cue &tmp temp0)
		((ScriptID 64017 0) set: 276) ; oFlags
		((ScriptID 64017 0) clear: 291) ; oFlags
		(oSFX2
			playSubtitledSound:
				(= temp0 (Random 6200 6225))
				0
				0
				(+ 10 (- temp0 6200))
				0
				gCurRoom
				80
		)
		(self dispose:)
	)
)

(instance poSpeaker of Prop
	(properties
		noun 7
		x 234
		y 218
		cycleSpeed 9
		view 21050
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (not cycler) ((ScriptID 64017 0) test: 276)) ; oFlags
				(if ((ScriptID 64017 0) test: 27) ; oFlags
					(oSailSFX setAmbient: 21200)
				)
				(self setCycle: RandCycle -1)
			)
			((and cycler (not ((ScriptID 64017 0) test: 276))) ; oFlags
				(self setCycle: 0 cel: 0)
				(if ((ScriptID 64017 0) test: 27) ; oFlags
					(oSailSFX stop:)
				)
			)
		)
	)
)

(instance voOpenFuseBox of View
	(properties
		noun 13
		x 432
		y 351
		loop 1
		view 21050
		approachX 427
		approachY 433
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom addRoomPlane: oFuseBoxCUPlane)
			)
			(51 ; Jumper Wire
				(gCurRoom addRoomPlane: oFuseBoxCUPlane)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addApproachVerb: 1)
	)
)

(instance foFuseBox of Feature
	(properties
		noun 12
		x 440
		y 329
		approachX 427
		approachY 433
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 400 298 426 293 480 298 479 356 463 365 405 352
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50 ; Screwdriver
				(gMessager say: noun theVerb 0 0 oGoCloseup) ; "Good idea. Let's see what's in there."
				((ScriptID 64017 0) set: 25) ; oFlags
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDoorHandle of Feature
	(properties
		noun 6
		x 328
		y 297
		approachX 279
		approachY 390
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 311 282 323 265 341 279 349 301 342 319 326 329 311 315 307 297
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLifePreserver of Feature
	(properties
		noun 3
		x 443
		y 300
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 430 148 447 153 470 198 482 232 467 273 435 281 404 243 406 199
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPorthole of Feature
	(properties
		noun 2
		x 330
		y 300
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 309 200 325 187 343 196 353 221 346 252 331 260 312 244 307 219
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foUpperDeck of Feature
	(properties
		noun 8
		x 336
		y 105
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 510 96 364 105 231 129 124 167 57 211 34 162 115 112 218 73 356 46 484 35 498 52 500 84 511 91 512 77 520 76 521 1 594 0 595 71 616 71 616 24 638 12 638 91 613 92 607 75 577 76 575 93 548 93 543 77
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; Climb
				(foLowerLadder doVerb:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foUpperLadder of Feature
	(properties
		noun 5
		x 561
		y 165
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 512 254 513 79 541 80 542 96 575 95 579 78 607 77 610 94 586 97 589 254
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 81)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; Climb
				(foLowerLadder doVerb:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBridgeInt of ExitFeature
	(properties
		x 331
		y 278
		approachX 279
		approachY 390
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 273 175 378 159 389 398 286 377
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 211 279 390 1)
	)
)

(instance foLowerLadder of ExitFeature
	(properties
		x 550
		y 326
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 512 194 586 194 587 399 515 388
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soClimb)
	)
)

(instance foExitEast of ExitFeature
	(properties
		x 545
		y 431
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 458 384 639 407 639 478 452 478
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 220 680 500)
	)
)

(instance oGoCloseup of CueMe
	(properties)

	(method (cue)
		(if local0
			(voOpenFuseBox init:)
			(foFuseBox dispose:)
			(gCurRoom addRoomPlane: oFuseBoxCUPlane)
		else
			(= local0 1)
			(oSFX playSound: 21001 self)
		)
	)
)

(instance oFuseBoxCUPlane of Plane
	(properties
		picture 21200
	)

	(method (init)
		(gThePlane drawPic: -1)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(if ((ScriptID 64017 0) test: 27) ; oFlags
			(voWire init:)
		)
		(foFuseArea init:)
		(foSailFuse init:)
		(foSpeakerFuse init:)
		(foExit init:)
	)

	(method (dispose)
		(gThePlane drawPic: 21000)
		(if ((ScriptID 64017 0) test: 27) ; oFlags
			(voOpenFuseBox loop: 2)
		)
		(super dispose: &rest)
	)
)

(instance voWire of View
	(properties
		x 312
		y 286
		view 21250
	)
)

(instance foFuseArea of Feature
	(properties
		noun 13
		x 311
		y 230
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 86 164 69 334 51 524 55 556 65 564 91 507 378 487 409 297 396 167 393 134 381 59 112
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; Jumper Wire
				(voWire init:)
				((ScriptID 64017 0) set: 27) ; oFlags
				(gEgo put: ((ScriptID 64037 0) get: 15)) ; oInvHandler, ioJumperWire
				(gMessager say: noun theVerb) ; "What if I just connected these two circuits together? That shouldn't cause any problems, should it? Heh, heh, heh."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foSailFuse of Feature
	(properties
		noun 11
		x 311
		y 250
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 134 161 130 145 150 141 158 112 181 99 176 85 202 76 208 89 232 81 236 86 294 76 394 78 399 71 438 84 444 68 473 74 466 95 485 106 492 134 477 161 447 162 445 181 415 177 414 160 374 148 320 142 248 151 247 161 228 163 230 182 203 186 194 170 172 175 152 156 143 163
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; Jumper Wire
				(foFuseArea doVerb: theVerb)
			)
			(50 ; Screwdriver
				(foFuseArea doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foSpeakerFuse of Feature
	(properties
		noun 10
		x 323
		y 318
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 319 205 292 221 289 218 270 246 262 252 280 329 274 375 278 390 275 393 263 424 271 420 284 439 293 450 321 462 323 463 336 455 339 446 336 431 355 402 355 397 375 371 371 374 352 360 342 309 339 263 349 267 371 239 374 239 358 207 357 190 351
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; Jumper Wire
				(foFuseArea doVerb: theVerb)
			)
			(50 ; Screwdriver
				(foFuseArea doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oFuseBoxCUPlane)
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oSFX2 of TPSound
	(properties)
)

(instance oSailSFX of TPSound
	(properties)
)

