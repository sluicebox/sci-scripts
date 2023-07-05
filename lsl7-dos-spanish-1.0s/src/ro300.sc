;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use TPSound)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Talker)
(use ROsc)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro300 0
)

(local
	local0
	local1
	local2
)

(instance ro300 of L7Room
	(properties
		picture 30000
	)

	(method (init)
		(super init:)
		(gOMusic1 setMusic: 30000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 249 323 221 422 280 425 267 466 497 457 521 404 535 382 526 353 622 348 617 304 532 307 532 333 503 351 454 337 412 305
					yourself:
				)
		)
		(= global330 0)
		(= global336 0)
		(foPool init:)
		(foMagazine init:)
		(foExitEast init:)
		(if ((ScriptID 64017 0) test: 275) ; oFlags
			(voDrewDrink init:)
		)
		(if (not ((ScriptID 64017 0) test: 60)) ; oFlags
			(voEroticBook init:)
		)
		(if (not ((ScriptID 64017 0) test: 172)) ; oFlags
			(poDrew init:)
		)
		(poTuber init: setCycle: Fwd)
		(poMarkAndSteve init: setCycle: Fwd)
		(poVBPlayers init: setCycle: Fwd)
		(poSlider init: setCycle: Fwd)
		(poRobGator init: setCycle: Fwd)
		(poLayne init: setCycle: Osc -1)
		(poPoolJumper init: setCycle: Fwd)
		(aoCodLarry posn: 583 347 normalize: init:)
		(gGame handsOn:)
		(cond
			(((ScriptID 64017 0) test: 56) ; oFlags
				(if ((ScriptID 64017 0) test: 301) ; oFlags
					(gCurRoom setScript: soDrewLeavesEgg)
				else
					(gCurRoom setScript: soDrewLeaves)
				)
			)
			((not ((ScriptID 64017 0) test: 57)) ; oFlags
				(proc64896_15 2)
				(gCurRoom setScript: soDrewGrabsTowel)
			)
			((== gPrevRoomNum 302) ; ro302
				(gCurRoom setScript: soLarryLeaves)
			)
			(else
				(proc64896_15 2 0)
			)
		)
	)

	(method (gimme)
		(if (not (poDrew plane:))
			(poDrew init:)
		)
		(gCurRoom setScript: soDrewLeaves)
	)

	(method (dispose)
		(= global330 0)
		(= global336 0)
		(gOSound1 stop:)
		(if (and (!= gNewRoomNum 302) ((ScriptID 64017 0) test: 274)) ; ro302, oFlags
			((ScriptID 64017 0) set: 275) ; oFlags
		)
		(super dispose: &rest)
	)
)

(instance soDrewGrabsTowel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 30000 30002 30004 30005 30006)
				(aoCodLarry dispose:)
				(poDrew
					setScript: 0
					view: 30003
					loop: 0
					cel: 0
					x: 22
					y: 438
					setPri: 490
					cycleSpeed: 9
					doit:
					setCycle: End self
				)
			)
			(1
				(= local1 0)
				(gMessager say: 2 100 0 3 coEndTalk) ; "(TO SELF) Oh, I got sunscreen in my eyes. (CALLING FOR TOWEL ATTENDANT) Boy! Oh, towel boy! I need a towel here, please. Quick."
				(poDrew
					view: 30004
					loop: 0
					cel: 0
					cycleSpeed: 12
					doit:
					setCycle: End self 9999
				)
			)
			(2
				(voDrewOil init:)
				(= ticks 120)
			)
			(3
				(gOSound1 preload: 30003)
				(poLarry
					view: 30000
					loop: 0
					cel: 0
					x: 231
					y: 409
					cycleSpeed: 12
					init:
					setCycle: End self
				)
				(poDrew
					view: 30005
					loop: 0
					cel: 0
					cycleSpeed: 9
					setCycle: ROsc -1 0 10
				)
			)
			(4
				(if (not local1)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(poLarry
					view: 30002
					loop: 0
					cel: 0
					x: 230
					y: 408
					cycleSpeed: 9
					doit:
					setCycle: End self 5 16 999
				)
				(= local1 0)
				(gMessager say: 2 100 0 1 coEndTalk) ; "(LARGE INHALE AT SEEING TOTALLY NUDE BEAUTY) Oh."
			)
			(6
				(gOSound1 playSound: 30003)
			)
			(7
				(gMessager kill:)
				(= local1 0)
				(gMessager say: 2 100 0 2 coEndTalk) ; "(DROP TOWEL AND IT HANGS THERE) Oops."
			)
			(8
				(poLarry
					view: 30002
					loop: 1
					cel: 0
					x: 230
					y: 408
					doit:
					setCycle: CT 2 1 self
				)
			)
			(9
				(poDrew
					view: 30005
					loop: 0
					cel: 0
					cycleSpeed: 6
					doit:
					setCycle: End self
				)
			)
			(10
				(if (not local1)
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(gMessager say: 2 100 0 4) ; "Uh, boy."
				(poDrew view: 30005 loop: 1 cel: 0 doit: setCycle: End self)
				(gOSound1 playSound: 30002)
				(poLarry setCycle: End coLarryInPlace)
			)
			(12
				(gMessager say: 2 100 0 5 self) ; "(FEELS LARRY'S TOWEL) Oh, thank you! (WIPES EYES)"
			)
			(13
				(poDrew view: 30006 loop: 0 cel: 0 doit: setCycle: CT 9 1 self)
			)
			(14
				(= local1 0)
				(gMessager say: 2 100 0 6 self) ; "(FINALLY SEES ELEPHANT FACE CODPIECE STARING HER IN THE FACE) Well, well. What have we here? (CHUCKLES) Is that your trunk or are you just glad to see me? (GOOD-NATUREDLY, TO LARRY) And what's YOUR name, little Babar?"
			)
			(15
				(gMessager sayRange: 2 100 0 7 10 self) ; "(EMBARRASSED) Larry; Larry Laffer. And you?"
			)
			(16
				((ScriptID 64017 0) set: 57) ; oFlags
				(= global330 0)
				(gCurRoom newRoom: 302) ; ro302
				(self dispose:)
			)
		)
	)
)

(instance coLarryInPlace of CueMe
	(properties)

	(method (cue)
		(poLarry view: 30007 loop: 0 cel: 0 posn: 236 408 doit:)
		(voLarryMouth init:)
		(poLarryEyes init:)
		(= global330 toLarry)
	)
)

(instance soDrewGreets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoCodLarry setMotion: MoveTo 240 412 self)
			)
			(1
				(poDrew setScript: soDrewLooksUp)
				(poLarry view: 30007 loop: 0 cel: 0 posn: 230 410 init:)
				(voLarryMouth init:)
				(poLarryEyes init:)
				(= global330 toLarry)
				(aoCodLarry hide:)
				(switch global233
					(0
						(gMessager say: 2 101 8 0 self) ; "Hi, Drew. It's me, Larry."
					)
					(1
						(gMessager say: 2 101 9 0 self) ; "Hello, Drew. Working hard?"
					)
					(2
						(gMessager say: 2 101 10 0 self) ; "Hello again, Drew."
					)
					(3
						(gMessager say: 2 101 11 0 self) ; "Hey, Drew. I'm back again."
					)
				)
				(if (< global233 3)
					(++ global233)
				)
			)
			(2
				(gCurRoom newRoom: 302) ; ro302
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oLocalWalkFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= nsTop (= nsLeft 0))
		(= nsRight (plane getWidth:))
		(= nsBottom (plane getHeight:))
		(self myPriority: -1)
	)

	(method (dispose)
		(super dispose: &rest)
		(= plane 0)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser canControl:)
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				aoCodLarry
				(aoCodLarry plane:)
				(aoCodLarry isNotHidden:)
				((aoCodLarry plane:) isEnabled:)
			)
			(event localize: (aoCodLarry plane:))
			(event type: $5000) ; evVERB | evMOVE
			(aoCodLarry setScript: 0)
			(proc64896_12 aoCodLarry)
			(aoCodLarry setMotion: PolyPath (event x:) (event y:))
			(event claimed: 0)
		)
		(return 0)
	)
)

(instance soLarryLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoCodLarry
					view: 30001
					loop: 2
					cel: 0
					posn: 250 395
					doit:
					setSpeed: 9
					setCycle: End self
				)
			)
			(1
				(aoCodLarry normalize: posn: 250 395 setHeading: 90 doit:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDrewLeavesEgg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoCodLarry view: 30001 loop: 2 cel: 0 posn: 250 364 doit:)
				(poDrew
					setScript: 0
					view: 30006
					loop: 1
					cel: 0
					posn: 18 432
					cycleSpeed: 9
					doit:
					setCycle: End self 8 999
				)
				(ShowEasterEgg 1)
				(aoCodLarry setSpeed: 9 setCycle: End self)
			)
			(1
				(poDrew cycleSpeed: 15 setPri: 379 doit:)
			)
			(2
				(aoCodLarry
					posn: 250 364
					setStep: 18 9
					setSpeed: 6
					setHeading: 90
					setCycle: Walk
					doit:
				)
			)
			(3
				((ScriptID 64017 0) set: 185) ; oFlags
				((ScriptID 64017 0) set: 172) ; oFlags
				((ScriptID 64017 0) clear: 56) ; oFlags
				((ScriptID 64017 0) set: 275) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
				(self dispose:)
			)
		)
	)
)

(instance soDrewLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoCodLarry dispose:)
				(poDrew
					setScript: 0
					view: 30009
					loop: 1
					cel: 0
					posn: 230 380
					cycleSpeed: 12
					doit:
					setCycle: End self 21 9999
				)
			)
			(1
				(poDrew cycleSpeed: 15)
				(if (proc64896_21 6)
					(oPlayerVoice playSubtitledSound: 6 0 0 5 1 self)
				else
					(gMessager say: 0 0 5 1 self) ; "Hey, Larry! Get outta the way!!"
				)
			)
			(2)
			(3
				((ScriptID 64017 0) set: 185) ; oFlags
				((ScriptID 64017 0) set: 172) ; oFlags
				((ScriptID 64017 0) clear: 56) ; oFlags
				((ScriptID 64017 0) set: 275) ; oFlags
				(gCurRoom newRoom: 550) ; ro550
				(self dispose:)
			)
		)
	)
)

(instance oPlayerVoice of TPSound
	(properties
		type 2
	)
)

(instance soTakeBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoCodLarry setMotion: PolyPath 296 451 self)
			)
			(1
				(aoCodLarry setHeading: 270 self)
			)
			(2
				(if ((ScriptID 64017 0) test: 172) ; oFlags
					(gMessager say: 4 8 4 0 self) ; "Just because Drew's not here, do you think you can just steal her property?"
				else
					(gMessager say: 4 8 3 0 self) ; "Well, Mr. Grabby, not much on manners, are we? Shouldn't we ask the lady's permission to borrow her reading matter, instead of just swiping it?"
				)
			)
			(3
				(if ((ScriptID 64017 0) test: 172) ; oFlags
					(gEgo get: ((ScriptID 64037 0) get: 10)) ; oInvHandler, ioEroticBook
					((ScriptID 64017 0) set: 60) ; oFlags
					(voEroticBook dispose:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soReadBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoCodLarry setMotion: PolyPath 296 451 self)
			)
			(1
				(aoCodLarry setHeading: 270 self)
			)
			(2
				(gMessager say: 4 97 0 0 self) ; "It's so difficult to read, lying there on the table, closed. Of course, if you "took" it...."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDoMag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoCodLarry setMotion: PolyPath 419 363 self)
			)
			(1
				(aoCodLarry setHeading: 90 self)
			)
			(2
				(gMessager say: 3 local2 0 0 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aoCodLarry of Actor
	(properties
		priority 460
		x 273
		y 380
		loop 2
		view 30001
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(oLocalWalkFeature init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 83)
	)

	(method (normalize)
		(self
			view: 30001
			setStep: 18 9
			setSpeed: 7
			setHeading: 270
			setCycle: Walk
		)
	)

	(method (setHeading param1 param2)
		(if (or (< param1 0) (> param1 180))
			(= loop 1)
		else
			(= loop 0)
		)
		(= heading param1)
		(if (and (> argc 1) param2)
			(param2 cue:)
		)
	)

	(method (doit)
		(if (self isStopped:)
			(self stopwalk:)
		)
		(super doit: &rest)
	)

	(method (getName)
		(gEgo getName:)
	)

	(method (stopwalk)
		(cond
			((== (aoCodLarry loop:) 0)
				(aoCodLarry loop: 4 cel: 0)
			)
			((== (aoCodLarry loop:) 1)
				(aoCodLarry loop: 3 cel: 0)
			)
		)
	)

	(method (doVerb)
		(gEgo doVerb: &rest)
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poTuber of Prop
	(properties
		x 473
		y 167
		cycleSpeed 13
		view 30010
	)
)

(instance poMarkAndSteve of Prop
	(properties
		x 320
		y 229
		cycleSpeed 11
		view 30011
	)
)

(instance poVBPlayers of Prop
	(properties
		x 305
		y 139
		cycleSpeed 6
		view 30013
	)
)

(instance poSlider of Prop
	(properties
		x 185
		y 49
		cycleSpeed 9
		view 30014
	)
)

(instance poRobGator of Prop
	(properties
		x 387
		y 114
		cycleSpeed 10
		view 30015
	)
)

(instance poLayne of Prop
	(properties
		x 164
		y 127
		cycleSpeed 11
		view 30016
	)
)

(instance poPoolJumper of Prop
	(properties
		x 413
		y 45
		cycleSpeed 12
		view 30017
	)
)

(instance voDrewOil of Prop
	(properties
		priority 505
		x 22
		y 438
		loop 1
		view 30004
		fixPriority 1
	)
)

(instance voDrewDrink of Prop
	(properties
		noun 6
		priority 500
		x 212
		y 406
		loop 1
		view 30018
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance voEroticBook of View
	(properties
		noun 4
		priority 510
		x 212
		y 405
		view 30018
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
				(gCurRoom setScript: soTakeBook)
			)
			(97 ; Read
				(gCurRoom setScript: soReadBook)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foPool of Feature
	(properties
		noun 1
		x 319
		y 139
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 243 372 241 434 231 472 215 487 206 502 193 514 180 524 166 529 154 531 142 515 113 490 87 473 75 438 58 402 45 367 38 342 35 301 37 256 43 215 54 187 65 161 79 131 103 113 131 108 147 111 166 131 192 148 206 181 225 212 235 279 243
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foMagazine of Feature
	(properties
		noun 3
		x 483
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 476 289 487 283 486 283 504 277 515 274 496 268 485 265 467 270 453 273 451 276 464 281
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(= local2 theVerb)
		(switch theVerb
			(97 ; Read
				(gCurRoom setScript: soDoMag)
			)
			(8 ; Take
				((ScriptID 64017 0) set: 55) ; oFlags
				(gCurRoom setScript: soDoMag)
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
					init: 600 0 640 0 640 480 600 480
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

(instance voLarryMouth of View
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super show: &rest)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= priority (+ (poLarry priority:) 1))
		(voLarryMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryMouth show:)
		(super dispose: &rest)
	)
)

(instance poLarryEyes of Prop
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 2))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 100)
	)

	(method (show)
		(= view (poLarry view:))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super show: &rest)
		(self setCycle: Blink 100)
	)
)

(instance poDrew of Prop
	(properties
		noun 2
		priority 490
		x 22
		y 438
		view 30003
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
		(self setScript: soDrewIdle)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(aoCodLarry setScript: soDrewGreets)
			)
			(else
				(if (proc64037_3 theVerb)
					(gMessager say: 1 161 0 0 0 400) ; "Maybe you should talk to her first."
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance soDrewIdle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poDrew
					view: 30003
					loop: 0
					cel: 0
					posn: 22 438
					cycleSpeed: 9
					doit:
				)
				(self cue:)
			)
			(1
				(poDrew setCycle: CT 32 1 self)
			)
			(2
				(if (Random 0 1)
					(poDrew setCycle: CT 18 -1 self)
				else
					(poDrew setCycle: CT 21 -1 self)
				)
			)
			(3
				(if (Random 0 1)
					(poDrew setCycle: CT 32 1 self)
				else
					(poDrew setCycle: CT 29 1 self)
				)
			)
			(4
				(if (Random 0 5)
					(-= state 3)
				)
				(= cycles 1)
			)
			(5
				(poDrew setCycle: CT 13 -1 self)
				(-= state 5)
			)
		)
	)
)

(instance soDrewLooksUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== (poDrew cel:) 29)
						(self dispose:)
					)
					((> (poDrew cel:) 29)
						(poDrew setCycle: CT 29 -1 self)
					)
					(else
						(poDrew setCycle: CT 29 1 self)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local1 1)
	)
)

(instance oShortSound of TPSound ; UNUSED
	(properties)
)

