;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use ego_64007)
(use TPSound)
(use DialogPlane)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Str)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro550 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1)
	(GetDistance (gEgo x:) (gEgo y:) (param1 x:) (param1 y:))
)

(procedure (localproc_1 param1 param2)
	(soPeeAnywhere nPeeX: param1 nPeeY: param2)
	(gEgo setScript: soPeeAnywhere)
)

(instance ro550 of L7Room
	(properties
		picture 55000
	)

	(method (init)
		(gEgo normalize: 0 posn: 131 306 init:)
		(super init:)
		(gOMusic1 fadeOut:)
		(if
			(and
				((ScriptID 64017 0) test: 186) ; oFlags
				(not ((ScriptID 64017 0) test: 179)) ; oFlags
			)
			(gOAmbience setRelVol: 50)
		else
			(gOAmbience setRelVol: 100)
		)
		(gOAmbience setAmbient: 55001)
		(if ((ScriptID 64017 0) test: 264) ; oFlags
			(proc64896_17 0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 172 253 136 281 96 326 87 338 96 376 123 408 124 423 137 441 629 445 627 410 583 416 497 406 484 365 466 331 516 329 511 306 468 305 393 278 407 263 363 252 327 249 321 248 300 250 288 249
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 268 334 455 331 474 364 487 407 301 405 239 406 235 425 187 431 154 432 140 406 130 396 133 363 181 310 190 306 189 294 268 289
					yourself:
				)
		)
		(foExit init:)
		(foCot init:)
		(foToilet init:)
		(foPipes init:)
		(foBarrels init:)
		(foTanks init:)
		(foShower init:)
		(foBuckets init:)
		(foWaterPipe init:)
		(foLight init:)
		(voFlushHandle init:)
		(poLSDrippingPipe init:)
		(poCeilingDrip init:)
		(foDrainpipe init:)
		(if (not ((ScriptID 64017 0) test: 156)) ; oFlags
			(voToiletPaper init:)
		)
		(if
			(and
				((ScriptID 64017 0) test: 150) ; oFlags
				(not ((ScriptID 64017 0) test: 153)) ; oFlags
			)
			(voHanky init:)
		)
		(if (not ((ScriptID 64017 0) test: 154)) ; oFlags
			(voLube init:)
		)
		(cond
			(((ScriptID 64017 0) test: 186) ; oFlags
				(poDrewInShower init:)
				(poSteam cel: 24 init:)
				(poShowerWater cel: 0 init: setCycle: Fwd)
				((ScriptID 64017 0) set: 187) ; oFlags
				(if (not ((ScriptID 64017 0) test: 179)) ; oFlags
					(oShowerSound setAmbient: 55003)
					(gOMusic1 setMusic: 55000)
				)
				(voClothes cel: 3 init:)
			)
			(((ScriptID 64017 0) test: 188) ; oFlags
				(voClosedCurtain init:)
			)
			(else
				(voOpenCurtain init:)
			)
		)
		(if
			(and
				((ScriptID 64017 0) test: 187) ; oFlags
				(not ((ScriptID 64017 0) test: 155)) ; oFlags
			)
			(voMold init:)
		)
		(if ((ScriptID 64017 0) test: 151) ; oFlags
			(voFirehose cel: 5 init:)
		)
		(gGame handsOn:)
		(if ((ScriptID 64017 0) test: 179) ; oFlags
			(gCurRoom setScript: soPlayAnnetteMovie)
		)
		(if ((ScriptID 64017 0) test: 185) ; oFlags
			(gCurRoom setScript: soPlayDrewMovie)
		)
		(if
			(and
				(not ((ScriptID 64017 0) test: 179)) ; oFlags
				(not ((ScriptID 64017 0) test: 185)) ; oFlags
			)
			(if ((ScriptID 64017 0) test: 297) ; oFlags
				(proc64896_15 6 0)
			else
				(proc64896_15 6 1)
				((ScriptID 64017 0) set: 297) ; oFlags
			)
		)
		(cond
			((not ((ScriptID 64017 0) test: 241)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 215 346
					setDest: -24 217
					loop: 1
					cel: 0
					setScaleDirect: 95
					setPri: 325
					nMyFlag: 241
					oAltScript: soDildo1
					init:
				)
			)
			((not ((ScriptID 64017 0) test: 255)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 558 371
					setDest: -24 217
					loop: 1
					cel: 0
					setScaleDirect: 95
					setPri: 371
					nMyFlag: 255
					oAltScript: soDildo2
					init:
					setSpeed: 5
				)
			)
			((not ((ScriptID 64017 0) test: 256)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 68 462
					setDest: 680 462
					loop: 0
					cel: 0
					setScaleDirect: 95
					setPri: 462
					nMyFlag: 256
					init:
					setSpeed: 4
				)
			)
		)
		(if ((ScriptID 64017 0) test: 264) ; oFlags
			(gCurRoom setScript: soLarryPutsOnCoat)
		)
		(gEgo addVerbHandler: o550VerbHandler)
	)

	(method (dispose)
		(gOAmbience setRelVol: 100)
		(gOAmbience stop:)
		(= global330 0)
		(super dispose: &rest)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 185) ; oFlags
		(gEgo get: ((ScriptID 64037 0) get: 12)) ; oInvHandler, ioFirehose
		(gCurRoom setScript: soPlayDrewMovie)
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(if (and (gUser canControl:) global235 global236)
			(= temp0 (MakeMessageText 0 0 71 1 14))
			(= temp1 (Str format: temp0 {wallpapr.bmp} (global236 data:)))
			(TextDialog temp1 (Str with: global288))
			(temp0 dispose:)
			(global236 dispose:)
			(= global236 0)
			(= global235 0)
		)
	)
)

(instance soPlayAnnetteMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(proc64896_15 4 1)
				(poLarry
					view: 55000
					loop: 1
					cel: 0
					posn: 350 317
					init:
					setCycle: End self 10 99
				)
				(poAnnette
					view: 55000
					loop: 0
					cel: 0
					posn: 340 319
					setPri: 400
					init:
				)
			)
			(1
				(= global334 0)
				(= global330 0)
				(gMessager say: 0 0 1 1 self 552) ; "(DRIPPING WITH MYSTERY AND SEX) Larry. So nice you could... drop by. (HE'S NAKED) And dressed for the occasion."
				(poAnnette setCycle: End self)
			)
			(2)
			(3)
			(4
				(gMessager say: 0 0 1 2 self 552) ; "Whoa! Who's this? Gotta play it cool."
			)
			(5
				(poLarry dispose:)
				(poAnnette dispose:)
				(gCurRoom addRoomPlane: oBJPlane)
				(poPiston init:)
				(poWhistle cel: 0 init:)
				(poLarry view: 55205 loop: 0 cel: 0 posn: 258 268 init:)
				(voLarryMouth init:)
				(= global330 toLarry)
				(poAnnette
					view: 55200
					loop: 0
					cel: 0
					posn: 303 271
					setPri: -1
					init:
				)
				(gMessager sayRange: 0 0 1 3 5 self 552) ; "(START SUAVE, LOSE IT) Um... yes, I always like to be...dressed...in things."
			)
			(6
				(gCurRoom addRoomPlane: oAnnetteCUPlane)
				(gMessager say: 0 0 1 6 self 552) ; "I've got a problem, Larry. The old man."
			)
			(7
				(gCurRoom deleteRoomPlane: oAnnetteCUPlane)
				(gMessager sayRange: 0 0 1 7 8 self 552) ; "Oh, that old guy in the wheelchair?"
			)
			(8
				(gCurRoom addRoomPlane: oAnnetteCUPlane)
				(gMessager sayRange: 0 0 1 9 11 self 552) ; "Yes, exactly. I'm tired, Larry. I got into this for a reason."
			)
			(9
				(gCurRoom deleteRoomPlane: oAnnetteCUPlane)
				(gMessager sayRange: 0 0 1 12 13 self 552) ; "(SLOWLY, THEN ACCELERATE AS YOU FIGURE IT OUT) She loves nursing, but she doesn't have enough time for sex!"
			)
			(10
				(gCurRoom addRoomPlane: oAnnetteCUPlane)
				(gMessager sayRange: 0 0 1 14 16 self 552) ; "I thought it would be easy. He looks like he's ready to keel over any second. But he saves up his strength 'til we're back in the cabin. And then he wears me out."
			)
			(11
				(gCurRoom deleteRoomPlane: oAnnetteCUPlane)
				(gMessager sayRange: 0 0 1 17 18 self 552) ; "Oh! A physical therapist too! (NOW INTROSPECTIVE) I wonder if it's true what they say about physical therapists?"
			)
			(12
				(gCurRoom addRoomPlane: oAnnetteCUPlane)
				(gMessager sayRange: 0 0 1 19 19 self 552) ; "This is easier than I thought."
			)
			(13
				(voAnnetteCUEyes loop: 3)
				(gOMusic1 playSound: 55200)
				(gOAmbience stop:)
				(gMessager sayRange: 0 0 1 20 20 self 552) ; "So you're willing to "do the dirty deed?""
			)
			(14
				(gCurRoom deleteRoomPlane: oAnnetteCUPlane)
				(gMessager sayRange: 0 0 1 21 23 self 552) ; "This is easier than I thought."
			)
			(15
				(gOSound1 preload: 55202 55201)
				(poAnnette setCycle: End)
				(gMessager say: 0 0 1 24 self 552) ; "Yes, (THAT'S WHAT I NEED) help. I'll make it worth your while. How 'bout a little sample? Right now...."
				(Load rsVIEW 55210)
				(Load rsVIEW 55215)
				(Load rsVIEW 55220)
				(Load rsVIEW 55221)
			)
			(16
				(poPiston cycleSpeed: 12 setCycle: Fwd)
				(= ticks 60)
			)
			(17
				(poAnnette
					view: 55210
					loop: 0
					cel: 0
					posn: 251 479
					doit:
					cycleSpeed: 8
					setCycle: End self 4
				)
				(= ticks 10)
			)
			(18
				(gMessager say: 0 0 1 25 0 552) ; "Sample? More like a "taste of things to come!!""
			)
			(19
				(voLarryMouth dispose:)
				(poLarry
					view: 55215
					loop: 0
					cel: 0
					posn: 214 268
					doit:
					setCycle: End self 48 999
				)
				(self setScript: soPickUpSpeed)
			)
			(20
				(poPiston setCycle: 0)
				(gOSound1 playSound: 55202)
				(poWhistle setCycle: End self)
			)
			(21)
			(22
				(= global330 0)
				(poLarry loop: 1 cel: 0 doit: setCycle: End)
				(poAnnette
					view: 55220
					loop: 0
					cel: 0
					posn: 295 275
					cycleSpeed: 6
					setCycle: End self
				)
				(UpdateScreenItem poAnnette)
				(gMessager say: 0 0 1 26 self 552) ; "(ORGASM FUNNY AND QUICKLY) Oooooohhhh!!"
			)
			(23)
			(24
				(poAnnette
					view: 55221
					loop: 0
					cel: 0
					posn: 246 486
					setCycle: End self 40 999
				)
				(UpdateScreenItem poAnnette)
			)
			(25
				(poHanky
					view: 55221
					loop: 1
					cel: 0
					posn: 246 486
					setPri: 400
					init:
					setCycle: End self
				)
			)
			(26)
			(27
				(poHanky dispose:)
				(= ticks 60)
			)
			(28
				(poLarry dispose:)
				(gCurRoom addRoomPlane: oLarryLiesPlane)
				(poLarry view: 55230 loop: 0 cel: 0 posn: 0 479 init:)
				(voLarryMouth init:)
				(= global334 0)
				(gMessager say: 0 0 1 27 self 552) ; "Come by my cabin late tonight and we'll work out the kinks."
			)
			(29
				(= cycles 2)
			)
			(30
				(gCurRoom deleteRoomPlane: oLarryLiesPlane)
				(gMessager say: 0 0 1 28 self 552) ; "I'll lay out my plan. He'll do the killing. I'll get off scot-free."
			)
			(31
				(gCurRoom addRoomPlane: oLarryLiesPlane)
				(poLarry view: 55230 loop: 0 cel: 0 posn: 0 479 init:)
				(poLarryHead
					view: 55235
					loop: 0
					cel: 0
					posn: 394 170
					setPri: 483
					init:
				)
				(voLarryMouth
					init:
					view: 55235
					loop: 1
					posn: 394 170
					setPri: 481
				)
				(UpdateScreenItem voLarryMouth)
				(= global330 toLarry)
				(gMessager say: 0 0 1 29 self 552) ; "Sounds great! When can you "fit me in?""
			)
			(32
				(= ticks 120)
			)
			(33
				(poLarryHead setCycle: End self)
				(gMessager say: 0 0 1 30 self 552) ; "Wait! What cabin?"
			)
			(34)
			(35
				(gCurRoom deleteRoomPlane: oLarryLiesPlane)
				(gCurRoom addRoomPlane: oLarryOverheadPlane)
				(= global330 0)
				(gMessager say: 0 0 1 31 self 552) ; "What's your name?"
			)
			(36
				(= ticks 30)
			)
			(37
				(gOMusic1 playSound: 32204)
				(= ticks 90)
			)
			(38
				(gMessager say: 0 0 1 32 self 552) ; "Oh."
				(proc64896_1 1 3 self)
			)
			(39)
			(40
				(= cycles 2)
			)
			(41
				(gCurRoom deleteRoomPlane: oLarryOverheadPlane)
				(gCurRoom deleteRoomPlane: oBJPlane)
				(voHanky init:)
				(= cycles 2)
			)
			(42
				(self setScript: soLarryPutsOnCoat self)
			)
			(43
				(gGame handsOff:)
				(if (gOMusic1 isPlaying:)
					(-- state)
				)
				(= cycles 1)
			)
			(44
				(= global334 0)
				(= global330 0)
				(if ((ScriptID 64017 0) test: 186) ; oFlags
					(oShowerSound setAmbient: 55003)
					(gOMusic1 setMusic: 55000)
					(gOAmbience setRelVol: 50)
				else
					(gOAmbience setRelVol: 100)
				)
				(gOAmbience setAmbient: 55001)
				((ScriptID 64017 0) clear: 179) ; oFlags
				((ScriptID 64017 0) set: 150) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPickUpSpeed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 50)
			)
			(1
				(poPiston cycleSpeed: 10)
				(= ticks 50)
			)
			(2
				(poPiston cycleSpeed: 8)
				(= ticks 50)
			)
			(3
				(poPiston cycleSpeed: 6)
				(= ticks 50)
			)
			(4
				(poPiston cycleSpeed: 4)
				(= ticks 60)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance soLarryPutsOnCoat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poLarryCoat view: 55015 cel: 0 posn: 324 334 init:)
				(gEgo hide:)
				(proc64896_1 0 12 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(poLarryCoat setCycle: End self)
			)
			(3
				(poLarryCoat dispose:)
				(gEgo posn: 321 339 normalize: 2 show:)
				(gGame handsOn:)
				((ScriptID 64017 0) clear: 264) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPlayDrewMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOAmbience setRelVol: 50)
				(proc64896_15 2 1)
				(gEgo posn: 117 358 normalize: 6 doit:)
				(poDrew
					view: 56005
					loop: 0
					cel: 0
					posn: 131 325
					cycleSpeed: 7
					init:
				)
				(gOMusic1 setMusic: 55000)
				(gMessager say: 0 0 10 1 self) ; "Well, here we are, Drew. It's not much, but it is roomy."
			)
			(1
				(poDrew setCycle: End self 23 25 26 42 44 999)
				(= local1 1)
				(gMessager say: 0 0 10 2 coDoneTalking) ; "Okay, Larry. Just give me a minute to hop in your shower and rinse off this sunscreen."
			)
			(2
				(voClothes cel: 0 init:)
			)
			(3
				(voClothes cel: 1)
				(UpdateScreenItem voClothes)
			)
			(4
				(poDrew cycleSpeed: 9)
			)
			(5
				(voClothes cel: 3)
				(UpdateScreenItem voClothes)
			)
			(6
				(poDrew setPri: 198)
			)
			(7
				(voOpenCurtain dispose:)
				(poDrew
					view: 56010
					loop: 0
					cel: 0
					posn: 308 221
					init:
					setCycle: End self
				)
				(UpdateScreenItem poDrew)
			)
			(8
				(poDrew loop: 1 cel: 0 setCycle: End self)
				(UpdateScreenItem poDrew)
			)
			(9
				(oShowerSound setAmbient: 55003)
				(self setScript: soShowerWaterBegins)
				(poDrew
					view: 56015
					loop: 0
					cel: 0
					posn: 308 221
					setCycle: End self
				)
				(UpdateScreenItem poDrew)
			)
			(10
				(poDrew dispose:)
				(poDrewInShower init:)
				(poSteam init:)
				(= ticks 120)
			)
			(11
				(if local1
					(-- state)
				)
				(= cycles 2)
			)
			(12
				(gMessager say: 0 0 10 3 self) ; "Hmm. Steam's not the only thing rising!"
			)
			(13
				((ScriptID 64017 0) set: 186) ; oFlags
				((ScriptID 64017 0) clear: 185) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local1 0)
	)
)

(instance soShowerWaterBegins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poShowerWater
					view: 56017
					loop: 0
					posn: 314 48
					setPri: 4
					init:
					setCycle: End self
				)
			)
			(1
				(poShowerWater loop: 1 cel: 0 doit: setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance soLieOnCot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 293 407 self)
			)
			(1
				(gGame handsOff:)
				(gOSound1 preload: 10113 55002)
				(gEgo setHeading: 180 self)
			)
			(2
				(gMessager say: 5 95 0 1 self) ; "(YAWN WHILE SPEAKING) Time for a little shut-eye."
			)
			(3
				(gEgo hide:)
				(poLarry
					view: 55095
					loop: 0
					cel: 0
					posn: 290 402
					setPri: 400
					init:
					setCycle: CT 12 1 self
				)
			)
			(4
				(= ticks 30)
			)
			(5
				(gOSound1 playSound: 10113)
				(poCeilingDrip hide: setScript: 0)
				(gCurRoom addRoomPlane: oBlackPlane)
				(= ticks 120)
			)
			(6
				(gMessager say: 5 95 0 3 self) ; "Well... calm seas!"
			)
			(7
				(= ticks 60)
			)
			(8
				(gMessager say: 5 95 0 2 self) ; "(WATER DRIPS RIGHT ON YOUR FACE) Doh!"
			)
			(9
				(gOSound1 playSound: 10113)
				(gCurRoom deleteRoomPlane: oBlackPlane)
				(poLarry cel: 13 doit:)
				(= ticks 30)
			)
			(10
				(poCeilingDrip
					posn: 234 -19
					setPri: 500
					cel: 0
					show:
					setCycle: End self 3 4 99
				)
			)
			(11
				(gOSound1 playSound: 55002)
			)
			(12
				(poLarry cel: 14 doit:)
			)
			(13
				(= ticks 60)
			)
			(14
				(poCeilingDrip
					posn: 234 -19
					cel: 0
					show:
					setCycle: End self 3 99
				)
			)
			(15
				(gOSound1 playSound: 55002)
			)
			(16
				(= cycles 1)
			)
			(17
				(poLarry setCycle: Beg self)
			)
			(18
				(poCeilingDrip setPri: 400 setScript: soDripBuckets)
				(poLarry dispose:)
				(gEgo show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oBlackPlane of Plane
	(properties)

	(method (init)
		(= picture -1)
		(super init: 0 0 639 479 &rest)
	)
)

(instance soFlushAndNada of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soJumpUpOnToilet self)
			)
			(1
				(poLarry
					view: 56025
					loop: 0
					cel: 0
					posn: 527 359
					setCycle: End self
				)
				(UpdateScreenItem poLarry)
				(voFlushHandle hide:)
			)
			(2
				(voFlushHandle show:)
				(poLarry
					view: 56027
					loop: 1
					cel: 0
					cycleSpeed: 7
					setPri: 390
					posn: 471 357
				)
				(UpdateScreenItem poLarry)
				(= ticks 60)
			)
			(3
				(self setScript: soJumpOffToilet self)
			)
			(4
				(gEgo face: foToilet self)
			)
			(5
				(gMessager say: 7 206 12 0 self) ; "Now the toilet drains freely."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soFlushToilet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soJumpUpOnToilet self)
			)
			(1
				(poLarry
					view: 56025
					loop: 0
					cel: 0
					posn: 527 359
					doit:
					setCycle: End self
				)
				(voFlushHandle hide:)
			)
			(2
				(gOSound1 preload: 55004)
				(voFlushHandle show:)
				(poLarry
					view: 56027
					loop: 1
					cel: 0
					cycleSpeed: 7
					setPri: 390
					posn: 471 357
				)
				(UpdateScreenItem poLarry)
				(self setScript: soWaterBulge self)
			)
			(3
				(gOSound1 playSound: 55004)
				(switch global213
					(0
						(poFloater view: 55009 posn: 583 403)
						(self setScript: soFloater self)
					)
					(1
						(poFloater view: 55007 posn: 590 413)
						(self setScript: soFloater self)
					)
					(2
						(poFloater view: 55006 posn: 586 400)
						(self setScript: soFloater self)
					)
					(3
						(poFloater view: 55005 posn: 584 404)
						(self setScript: soFloater self)
					)
					(4
						(poFloater view: 55008 posn: 578 400)
						(self setScript: soFloater self)
					)
					(5
						(poFloater view: 55010 posn: 578 397)
						(self setScript: soFloater self)
					)
					(6
						(self setScript: soToiletSpurt self)
					)
				)
				(if (== global213 6)
					(= global213 0)
				else
					(++ global213)
				)
			)
			(4
				(self setScript: soJumpOffToilet self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJumpUpOnToilet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 475 374 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo hide:)
				(poLarry
					view: 56027
					loop: 0
					cel: 0
					setPri: 390
					posn: 525 357
					init:
					setCycle: End self
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soTakeLube of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(voLube dispose:)
				(gEgo get: ((ScriptID 64037 0) get: 41)) ; oInvHandler, ioLubricant
				((ScriptID 64017 0) set: 154) ; oFlags
				(= ticks 60)
			)
			(1
				(poFloater
					view: 55004
					posn: 580 404
					cel: 0
					init:
					setCycle: End self
				)
			)
			(2
				(poFloater dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJumpOffToilet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (poLarry plane:)
					(poLarry dispose:)
				)
				(poLarry
					view: 56027
					loop: 1
					cel: 0
					cycleSpeed: 7
					setPri: 390
					posn: 471 357
					init:
					setCycle: End self
				)
			)
			(1
				(poLarry setPri: -1 dispose:)
				(gEgo posn: 478 374 normalize: 7 show:)
				(self dispose:)
			)
		)
	)
)

(instance soToiletSpurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 240)
			)
			(1
				(gOSound1 preload: 55011 55010)
				(poLarry
					view: 56030
					loop: 0
					cel: 0
					posn: 524 356
					setCycle: End self 4 7 26 42 999
				)
				(UpdateScreenItem poLarry)
			)
			(2
				(gOSound1 playSound: 55010)
			)
			(3
				(poLarry setPri: 383)
				(UpdateScreenItem poLarry)
			)
			(4
				(gOSound1 stop:)
				(poLarry setPri: 390)
				(UpdateScreenItem poLarry)
			)
			(5
				(gOSound1 playSound: 55011)
			)
			(6
				(= cycles 2)
			)
			(7
				(poLarry view: 56027 loop: 1 cel: 0 posn: 475 374)
				(UpdateScreenItem poLarry)
				(self dispose:)
			)
		)
	)
)

(instance soFloater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(poFloater cel: 0 init: setCycle: End self)
			)
			(2
				(poFloater dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soWaterBulge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOSound1 preload: 55010)
				(voFirehose hide:)
				(poFirehose
					view: 56035
					loop: 1
					cel: 0
					posn: 70 158
					setPri: 2
					init:
					setCycle: End self
				)
				(gOSound1 playSound: 55010)
			)
			(1
				(gOSound1 stop:)
				(poFirehose dispose:)
				(voFirehose show:)
				(self dispose:)
			)
		)
	)
)

(instance soFlushToiletWDrew of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soJumpUpOnToilet self)
			)
			(1
				(gMessager say: 7 206 11 1 self) ; "This ought to get her out of there."
			)
			(2
				(poLarry
					view: 56025
					loop: 0
					cel: 0
					posn: 527 359
					setCycle: End self
				)
				(UpdateScreenItem poLarry)
				(voFlushHandle hide:)
			)
			(3
				(gOSound1 preload: 55004)
				(voFlushHandle show:)
				(poLarry
					view: 56027
					loop: 1
					cel: 0
					cycleSpeed: 7
					setPri: 390
					posn: 471 357
				)
				(UpdateScreenItem poLarry)
				(self setScript: soWaterBulge self)
			)
			(4
				(gOSound1 preload: 55007)
				(oFlushSound playSound: 55004)
				(poDrewInShower dispose:)
				(poDrew
					view: 56045
					loop: 0
					cel: 0
					setPri: 200
					cycleSpeed: 5
					init:
					setCycle: End coDrewOutOfShower
				)
				(oShowerSound stop:)
				(gOMusic1 stop:)
				(gOAmbience setRelVol: 100)
				(poShowerWater dispose:)
				(gMessager say: 7 206 11 2 self) ; "(SCALDED) Yeow!"
			)
			(5
				(gOSound1 playSound: 55007)
				(= ticks 20)
			)
			(6
				(poLarry
					view: 56050
					loop: 0
					cel: 0
					setPri: 390
					posn: 563 299
					setCycle: CT 11 1 self
				)
				(UpdateScreenItem poLarry)
			)
			(7
				(gOSound1 preload: 55008)
				(= local1 1)
				(gMessager say: 7 206 11 3 coDoneTalking) ; "Oops."
				(= ticks 30)
			)
			(8
				(poLarry setCycle: End self 18 999)
			)
			(9
				(gOSound1 playSound: 55008)
			)
			(10
				(if (not ((ScriptID 64017 0) test: 187)) ; oFlags
					((ScriptID 64017 0) set: 187) ; oFlags
				)
				(poDrew
					view: 56065
					loop: 0
					cel: 0
					posn: 563 299
					setCycle: CycleCueList 28 1 self 15
				)
				(poLarry
					view: 56060
					loop: 0
					cel: 0
					posn: 563 299
					setCycle: End self 29 999
				)
			)
			(11
				(voClothes dispose:)
			)
			(12
				(gOSound1 playSound: 55011)
			)
			(13
				(= cycles 1)
			)
			(14
				(poLarry dispose:)
				(gEgo posn: 382 298 normalize: 2 show: setHeading: 270)
				(= cycles 1)
			)
			(15
				(if local1
					(-- state)
				)
				(= cycles 1)
			)
			(16
				(poDrew setCycle: End)
				(gMessager say: 7 206 11 4 self) ; "You bastard! That's it. I'm not staying here. And don't try coming around the pool, either!"
			)
			(17
				(gOSound1 playSound: 31103)
				(gMessager sayRange: 7 206 11 5 6 self) ; "Drew! Wait!"
			)
			(18
				(poSteam setScript: soSteamDissipates)
				((ScriptID 64017 0) clear: 186) ; oFlags
				((ScriptID 64017 0) set: 152) ; oFlags
				((ScriptID 64017 0) set: 188) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oFlushSound of TPSound
	(properties)
)

(instance coDrewOutOfShower of CueMe
	(properties)

	(method (cue)
		(voClosedCurtain init:)
	)
)

(instance soAttachHose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 118 308 self)
			)
			(1
				(gGame handsOff:)
				(gOSound1 preload: 38603)
				(gOSound1 preload: 55012)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(poLarry
					view: 56020
					loop: 0
					setPri: -1
					cel: 0
					posn: 127 307
					init:
					setCycle: End self 27 999
				)
			)
			(3
				(gOSound1 playSound: 55012)
			)
			(4
				(voFirehose cel: 4 init:)
				(poLarry view: 56021 posn: 50 245 cel: 0 setCycle: End self)
				(UpdateScreenItem poLarry)
			)
			(5
				(voFirehose cel: 2 setPri: 360)
				(UpdateScreenItem voFirehose)
				(poLarry
					view: 56022
					posn: 163 281
					cel: 0
					setCycle: End self 32 51 999
				)
				(UpdateScreenItem poLarry)
				(gOSound1 playSound: 38603)
			)
			(6
				(poLarry setPri: 450)
			)
			(7
				(gOSound1 playSound: 55012)
			)
			(8
				(= ticks 6)
			)
			(9
				(voFirehose cel: 5 setPri: 2)
				(UpdateScreenItem voFirehose)
				(self setScript: soJumpOffToilet self)
			)
			(10
				(gEgo face: foToilet self)
			)
			(11
				(gMessager say: 7 30 0 0 self) ; "Now that toilet will have plenty of water!"
			)
			(12
				((ScriptID 64017 0) set: 151) ; oFlags
				(gEgo put: ((ScriptID 64037 0) get: 12)) ; oInvHandler, ioFirehose
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soSitOnThrone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soJumpUpOnToilet self)
			)
			(1
				(poLarry
					view: 55090
					loop: 0
					cel: 0
					posn: 524 351
					doit:
					setCycle: End self
				)
			)
			(2
				(poLarry dispose:)
				(poLarryOnCan init:)
				(voLarryOnCanMouth init:)
				(= global330 toLarryOnCan)
				(foToilet addHotspotVerb: 77 207 214)
				(= local2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGetOffThrone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 37 14 0 self) ; "(IT'S SANDPAPER!) YEOW! That's rough!"
			)
			(1
				(poLarryOnCan dispose:)
				(voLarryOnCanMouth dispose:)
				(= global330 0)
				(poLarry
					view: 55090
					loop: 1
					cel: 0
					posn: 524 351
					init:
					setCycle: End self
				)
			)
			(2
				(self setScript: soJumpOffToilet self)
			)
			(3
				(foToilet deleteHotspotVerb: 77 207)
				(= local2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPlop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(switch (Random 0 2)
					(0
						(oPlopSound playSound: 55013 self)
					)
					(1
						(oPlopSound playSound: 55014 self)
					)
					(2
						(oPlopSound playSound: 55015 self)
					)
				)
				(-= state 2)
			)
		)
	)
)

(instance oPlopSound of TPSound
	(properties)
)

(instance poLarryOnCan of Prop
	(properties
		priority 390
		x 524
		y 351
		view 55092
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 77 207 214)
		(self setScript: soPlop)
	)

	(method (doVerb theVerb)
		(if (not (o550VerbHandler doVerb: theVerb &rest))
			(gEgo doVerb: theVerb &rest)
		)
	)

	(method (getName)
		(gEgo getName:)
	)
)

(instance voLarryOnCanMouth of View
	(properties
		priority 391
		x 524
		y 351
		loop 1
		view 55092
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 77 207 214)
	)

	(method (doVerb theVerb)
		(if (not (o550VerbHandler doVerb: theVerb &rest))
			(gEgo doVerb: theVerb &rest)
		)
	)

	(method (getName)
		(gEgo getName:)
	)
)

(instance toLarryOnCan of Talker
	(properties
		priority 391
		x 524
		y 351
		loop 1
		view 55092
	)

	(method (init)
		(voLarryOnCanMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryOnCanMouth show:)
		(super dispose: &rest)
	)
)

(instance soPissInCan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 108)
				(self setScript: soJumpUpOnToilet self)
			)
			(1
				(poLarry
					view: 55020
					loop: 0
					cel: 0
					posn: 527 363
					doit:
					setCycle: End self 8 15 999
				)
			)
			(2
				(gOSound1 playSound: 108)
			)
			(3
				(gOSound1 stop:)
			)
			(4
				(= cycles 1)
			)
			(5
				(self setScript: soJumpOffToilet self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPissWhileOnCan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 77 14 0 self) ; "Good idea. Get everything done at once!"
			)
			(1
				(gOSound1 playSound: 108 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDildo1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 50 0) setCycle: Walk setMotion: MoveTo 65 277 self) ; oDildo
			)
			(1
				((ScriptID 50 0) setPri: -1 setMotion: MoveTo -10 235 self) ; oDildo
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soDildo2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 50 0) setCycle: Walk setMotion: MoveTo 441 320 self) ; oDildo
			)
			(1
				((ScriptID 50 0) setMotion: MoveTo 133 320 self) ; oDildo
			)
			(2
				((ScriptID 50 0) setMotion: MoveTo 65 277 self) ; oDildo
			)
			(3
				((ScriptID 50 0) setPri: -1 setMotion: MoveTo -10 235 self) ; oDildo
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poAnnette of Prop
	(properties)
)

(instance poHanky of Prop
	(properties)
)

(instance poLarryCoat of Prop
	(properties)
)

(instance poShowerWater of Prop
	(properties
		priority 4
		x 314
		y 48
		loop 1
		view 56017
		fixPriority 1
	)
)

(instance poPiston of Prop
	(properties
		x 457
		y 103
		view 55238
	)

	(method (doit)
		(if (and (== cel 1) (== local0 0))
			(oPistonSound playSound: 55201)
		)
		(= local0 cel)
		(super doit:)
	)
)

(instance oPistonSound of TPSound
	(properties)
)

(instance poWhistle of Prop
	(properties
		x 525
		y 250
		view 55237
	)
)

(instance voLarryMouth of View
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= cel 0)
		(= priority (+ (poLarry priority:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= fixPriority 1)
		(super init: &rest)
	)
)

(instance poLarryHead of Prop
	(properties)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(= view (voLarryMouth view:))
		(= loop (voLarryMouth loop:))
		(= x (voLarryMouth x:))
		(= y (voLarryMouth y:))
		(= priority (voLarryMouth priority:))
		(voLarryMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryMouth show:)
		(super dispose: &rest)
	)
)

(instance voAnnetteCU of View
	(properties
		x 392
		y 220
		view 55300
	)
)

(instance voAnnetteCUMouth of View
	(properties
		priority 221
		x 392
		y 220
		loop 1
		view 55300
		fixPriority 1
	)
)

(instance voAnnetteCUEyes of View
	(properties
		priority 221
		x 392
		y 220
		loop 2
		view 55300
		fixPriority 1
	)
)

(instance poMSDrippingPipe of Prop
	(properties
		priority 1
		x 46
		y 115
		view 55236
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: (soDrip new:))
	)
)

(instance poLSDrippingPipe of Prop
	(properties
		priority 1
		x 81
		y 59
		view 55002
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: (soDrip new:))
	)
)

(instance poCeilingDrip of Prop
	(properties
		priority 400
		x 187
		y 57
		view 55003
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(oDripSound preload: 55002)
		(self setScript: soDripBuckets)
	)
)

(instance oDripSound of TPSound
	(properties)
)

(instance soDrip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End self)
			)
			(1
				(-= state 2)
				(= ticks (Random 90 180))
			)
		)
	)
)

(instance soDripBuckets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poCeilingDrip cel: 0 posn: 187 57 setCycle: End self 3 999)
			)
			(1
				(oDripSound playSound: 55002)
			)
			(2
				(= ticks (Random 180 240))
			)
			(3
				(poCeilingDrip cel: 0 posn: 231 -24 setCycle: End self 3 999)
			)
			(4
				(oDripSound playSound: 55002)
			)
			(5
				(= state -1)
				(= ticks (Random 180 240))
			)
		)
	)
)

(instance toAnnetteCU of Talker
	(properties
		priority 221
		x 392
		y 220
		loop 1
		view 55300
	)

	(method (init)
		(voAnnetteCUMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voAnnetteCUMouth show:)
		(super dispose: &rest)
	)
)

(instance oLarryLiesPlane of Plane
	(properties)

	(method (init)
		(= picture 55400)
		(super init: 0 0 639 479 &rest)
	)
)

(instance oLarryOverheadPlane of Plane
	(properties)

	(method (init)
		(= picture 55021)
		(super init: 0 0 639 479 &rest)
	)
)

(instance oBJPlane of Plane
	(properties)

	(method (init)
		(= picture 55200)
		(super init: 0 0 639 479 &rest)
		(poMSDrippingPipe init:)
	)
)

(instance oAnnetteCUPlane of Plane
	(properties)

	(method (init)
		(= picture 55300)
		(super init: 0 0 639 479 &rest)
		(voAnnetteCU init:)
		(voAnnetteCUMouth init:)
		(voAnnetteCUEyes init:)
		(= global334 toAnnetteCU)
	)

	(method (dispose)
		(= global334 0)
		(super dispose: &rest)
	)
)

(instance voToiletPaper of View
	(properties
		noun 15
		priority 1
		x 498
		y 332
		loop 1
		view 55050
		approachX 467
		approachY 323
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
				(gEgo get: ((ScriptID 64037 0) get: 47)) ; oInvHandler, ioToiletPaper
				((ScriptID 64017 0) set: 156) ; oFlags
				(self dispose:)
			)
			(1 ; Look
				((ScriptID 64017 0) set: 146) ; oFlags
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voFlushHandle of View
	(properties
		priority 390
		x 581
		y 256
		view 55050
		fixPriority 1
	)
)

(instance voMold of View
	(properties
		noun 12
		priority 190
		x 313
		y 232
		loop 3
		view 55050
		approachX 312
		approachY 259
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
				(if ((ScriptID 64017 0) test: 186) ; oFlags
					(gMessager say: 12 8 0 0) ; "Larry, I like to be alone when I shower. No offense."
				else
					(gEgo get: ((ScriptID 64037 0) get: 25)) ; oInvHandler, ioMold
					((ScriptID 64017 0) set: 155) ; oFlags
					(gOSound1 playSound: 55005)
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voFirehose of View
	(properties
		priority 2
		x 68
		y 162
		cel 5
		view 56023
		fixPriority 1
	)
)

(instance poFirehose of Prop
	(properties)
)

(instance poFloater of Prop
	(properties
		priority 2
		cycleSpeed 10
		fixPriority 1
	)
)

(instance voLube of View
	(properties
		noun 9
		priority 401
		x 587
		y 420
		loop 2
		view 55050
		approachX 551
		approachY 417
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
				(gCurRoom setScript: soTakeLube)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foDrainpipe of Feature
	(properties
		noun 8
		x 587
		y 400
		approachX 551
		approachY 417
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 549 373 565 372 588 393 590 401 581 409 572 408 549 384
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 64017 0) test: 154) ; oFlags
					(gMessager say: 8 1 2 0) ; "The drain pipe is now unclogged, but it's tough to call it an improvement."
				else
					(gMessager say: 8 1 1 0) ; "The toilet's drain pipe appears to be clogged with something."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voHanky of View
	(properties
		noun 13
		priority 1
		x 356
		y 285
		loop 4
		view 55050
		approachX 328
		approachY 302
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
				(gEgo get: ((ScriptID 64037 0) get: 53)) ; oInvHandler, ioHanky
				((ScriptID 64017 0) set: 153) ; oFlags
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foToilet of Feature
	(properties
		noun 7
		x 567
		y 363
		approachX 516
		approachY 329
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 601 219 605 208 617 208 626 230 622 242 635 254 632 262 630 263 623 296 616 296 606 319 591 319 576 329 575 345 592 352 590 358 548 360 533 348 536 339 548 340 553 327 535 318 525 294 528 287 555 283 586 288 586 282 579 276 579 245 574 241 576 236 601 235 612 241 611 229
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 206)
		(self addExceptionVerb: 30 206 77 93)
		(cond
			(((ScriptID 64017 0) test: 154) ; oFlags
				(if ((ScriptID 64017 0) test: 151) ; oFlags
					(= case 3)
				else
					(= case 2)
				)
			)
			(((ScriptID 64017 0) test: 151) ; oFlags
				(= case 9)
			)
			(else
				(= case 1)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			(((ScriptID 64017 0) test: 154) ; oFlags
				(if ((ScriptID 64017 0) test: 151) ; oFlags
					(= case 3)
				else
					(= case 2)
				)
			)
			(((ScriptID 64017 0) test: 151) ; oFlags
				(= case 9)
			)
			(else
				(= case 1)
			)
		)
		(switch theVerb
			(71 ; Smell
				(gMessager say: 7 71 0 0) ; "Let's put it this way: it hasn't been sanitized for your protection. Capisce (KA-PEESH)?"
			)
			(7 ; Lick
				(gMessager say: 7 7 0 0) ; "(REALLY GROSSED OUT) Yeeccchh. Maybe this interface wasn't such a great idea?!"
			)
			(206 ; Flush
				(if local2
					(gMessager say: 7 207 14 0) ; "What? Not without wiping!"
					(return)
				)
				(cond
					((== case 3)
						((ScriptID 64017 0) set: 147) ; oFlags
						(if ((ScriptID 64017 0) test: 186) ; oFlags
							(gEgo setScript: soFlushToiletWDrew)
						else
							(gEgo setScript: soFlushToilet)
						)
					)
					((== case 2)
						(gEgo face: foToilet 0)
						(gMessager say: 7 206 12 0) ; "Now the toilet drains freely."
					)
					(else
						(gEgo face: foToilet 0)
						(gMessager say: 7 206 9 0) ; "The toilet worked perfectly when this cabin's last occupant checked in."
					)
				)
			)
			(30 ; Fire Hose
				(gEgo setScript: soAttachHose)
			)
			(93 ; Shit
				(cond
					((!= case 3)
						(if (== case 2)
							(gEgo face: foToilet 0)
							(gMessager say: 7 77 2 0) ; "You could, but then you couldn't flush it. And surely it smells badly enough in here even for you!"
						else
							(gEgo face: foToilet 0)
							(gMessager say: 7 77 1 0) ; "Perhaps you should look at the toilet first."
						)
					)
					(((ScriptID 64017 0) test: 186) ; oFlags
						(if (not local2)
							(gEgo face: foShower 0)
						)
						(gMessager say: 7 77 11 0) ; "Now there's an impressive way to start your "first date!""
					)
					((not local2)
						((ScriptID 64017 0) set: 149) ; oFlags
						(gCurRoom setScript: soSitOnThrone)
					)
				)
			)
			(207 ; Get up
				(if local2
					(gMessager say: 7 207 14 0) ; "What? Not without wiping!"
				)
			)
			(77 ; Whiz
				(cond
					((!= case 3)
						(if (== case 2)
							(gEgo face: foToilet 0)
							(gMessager say: 7 77 2 0) ; "You could, but then you couldn't flush it. And surely it smells badly enough in here even for you!"
						else
							(gEgo face: foToilet 0)
							(gMessager say: 7 77 1 0) ; "Perhaps you should look at the toilet first."
						)
					)
					(((ScriptID 64017 0) test: 186) ; oFlags
						(if (not local2)
							(gEgo face: foShower 0)
						)
						(gMessager say: 7 77 11 0) ; "Now there's an impressive way to start your "first date!""
					)
					(else
						((ScriptID 64017 0) set: 148) ; oFlags
						(if local2
							(gCurRoom setScript: soPissWhileOnCan)
						else
							(gCurRoom setScript: soPissInCan)
						)
					)
				)
			)
			(214 ; Wipe
				(if local2
					(gMessager say: 7 214 14 0) ; "What are you going to use, your leisure suit?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(37 ; Toilet Paper
				(if local2
					(gCurRoom setScript: soGetOffThrone)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poLarryPees of Prop
	(properties)
)

(class soPeeAnywhere of Script
	(properties
		nPeeX 0
		nPeeY 0
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (MulDiv 2 (gEgo scaleX:) 128))
				(= temp1 (MulDiv 8 (gEgo scaleX:) 128))
				(gEgo walkTo: (+ nPeeX temp0) (- nPeeY temp1) self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poLarryPees
					view: 55020
					loop: 0
					cel: 0
					posn: nPeeX nPeeY
					setScaleDirect: (gEgo scaleX:)
					init:
					setCycle: End self 8 15 999
				)
			)
			(3
				(gOSound1 playSound: 108)
			)
			(4
				(gOSound1 stop:)
			)
			(5
				(= cycles 1)
			)
			(6
				(poLarryPees dispose:)
				(gEgo show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance o550VerbHandler of VerbHandler
	(properties)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(switch theVerb
			(95 ; Lie
				(foCot doVerb: theVerb &rest)
				(return 1)
			)
			(93 ; Shit
				(foToilet doVerb: theVerb &rest)
				(return 1)
			)
			(207 ; Get up
				(if local2
					(foToilet doVerb: theVerb &rest)
					(return 1)
				)
			)
			(77 ; Whiz
				(= temp0 (localproc_0 foToilet))
				(= temp1 (localproc_0 foBuckets))
				(if
					(and
						(<
							(= temp2
								(GetDistance (gEgo x:) (gEgo y:) 310 220)
							)
							temp1
						)
						(< temp2 temp0)
					)
					(return (foShower doVerb: 77))
				)
				(if (and (< temp1 temp2) (< temp1 temp0))
					(return (foBuckets doVerb: 77))
				)
				(foToilet doVerb: theVerb &rest)
				(return 1)
			)
			(214 ; Wipe
				(if local2
					(foToilet doVerb: theVerb &rest)
					(return 1)
				)
			)
			(37 ; Toilet Paper
				(if local2
					(foToilet doVerb: theVerb &rest)
					(return 1)
				)
			)
		)
		(return 0)
	)
)

(instance foWaterPipe of Feature
	(properties
		noun 1
		x 82
		y 266
		approachX 136
		approachY 281
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 59 150 77 143 72 130 72 119 81 114 80 87 97 87 98 136 102 136 100 146 111 155 111 168 104 177 92 175 84 165 68 174 60 168 58 158
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addExceptionVerb: 30)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Fire Hose
				(gEgo setScript: soAttachHose)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foPipes of Feature
	(properties
		noun 11
		x 53
		y 460
		approachX 96
		approachY 376
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 16 291 27 293 27 301 50 300 69 321 73 356 85 359 84 367 71 373 72 378 108 391 117 434 127 437 128 442 71 446 35 445 36 415 6 415 7 375 38 377 38 374 29 368 28 360 38 353 28 338 23 347 14 347 9 338
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foShower of Feature
	(properties
		x 310
		y 189
		approachX 319
		approachY 262
	)

	(method (init)
		(= noun 2)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 263 154 263 62 354 63 351 251 263 248 263 222 254 230 242 229 235 220 238 169 249 160
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(77 ; Whiz
				(cond
					(((ScriptID 64017 0) test: 186) ; oFlags
						(if (not local2)
							(gEgo face: foShower 0)
						)
						(gMessager say: 7 77 11 0) ; "Now there's an impressive way to start your "first date!""
					)
					((not local2)
						(localproc_1 269 290)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(146 ; Operate
				(gEgo doVerb: 83)
			)
			(62 ; Turn on
				(gEgo doVerb: 83)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foLight of Feature
	(properties
		x 478
		y 350
		approachDist 1000
		approachX 478
		approachY 350
	)

	(method (init)
		(= noun 4)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 478 0 482 0 482 60 488 69 492 72 492 114 479 124 465 111 466 73 478 59
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTanks of Feature
	(properties
		x 118
		y 213
		approachX 136
		approachY 281
	)

	(method (init)
		(= noun 10)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 101 44 91 52 82 173 85 174 112 201 107 214 150 196 210 171 205 156 235 99 255 43 237 24 217 7 281
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBarrels of Feature
	(properties
		x 465
		y 223
		approachX 407
		approachY 263
	)

	(method (init)
		(= noun 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 425 251 455 225 455 218 438 205 412 210 389 217 353 199 353 167 369 160 398 168 395 140 409 138 437 147 456 142 491 145 492 218 458 223 458 232 511 236 526 272 510 292 486 293 432 275
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCot of Feature
	(properties
		x 303
		y 360
		approachX 143
		approachY 351
	)

	(method (init)
		(= noun 5)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 312 429 314 461 369 450 406 425 372 309 370 308 401 297 401 297 369 157 369 164 393 151 398 147 365
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 95)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(95 ; Lie
				(if (not local2)
					(gCurRoom setScript: soLieOnCot)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foBuckets of Feature
	(properties
		x 201
		y 350
		approachX 143
		approachY 351
	)

	(method (init)
		(= noun 6)
		(self
			setPolygon:
				((Set new:)
					add:
						((Polygon new:)
							type: PTotalAccess
							init: 209 309 208 296 231 291 253 295 249 312
							yourself:
						)
						((Polygon new:)
							type: PTotalAccess
							init: 162 378 176 371 203 374 215 378 205 423 188 428 171 423
							yourself:
						)
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(77 ; Whiz
				(if (not local2)
					(localproc_1 146 450)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voClothes of View
	(properties
		priority 1
		x 238
		y 287
		view 56007
		fixPriority 1
	)
)

(instance voOpenCurtain of View
	(properties
		priority 200
		x 308
		y 83
		loop 1
		view 56007
		fixPriority 1
	)
)

(instance voClosedCurtain of View
	(properties
		priority 200
		x 308
		y 83
		loop 2
		view 56007
		fixPriority 1
	)
)

(instance oShowerSound of TPSound
	(properties)
)

(instance poDrew of Prop
	(properties)
)

(instance poDrewInShower of Prop
	(properties
		noun 14
		priority 200
		x 308
		y 221
		cycleSpeed 10
		loop 1
		view 56015
		approachX 319
		approachY 262
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(switch global240
					(0
						(gMessager say: 14 4 4 0) ; "Drew, are you coming out soon?"
					)
					(1
						(gMessager say: 14 4 5 0) ; "Drew, isn't that lotion off by now?"
					)
					(2
						(gMessager say: 14 4 6 0) ; "Would you like a little company? I could scrub your back."
					)
					(3
						(gMessager say: 14 4 7 0) ; "Drew, you must be turning into a big pink raisin in there."
					)
					(4
						(gMessager say: 14 4 8 0) ; "Drew, do you mind if I go run some errands around the ship for a few minutes?"
					)
				)
				(if (== (++ global240) 5)
					(= global240 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poSteam of Prop
	(properties
		priority 5
		x 305
		y 220
		cycleSpeed 12
		view 56040
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soSteam)
	)
)

(instance soSteam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poSteam setCycle: End self)
			)
			(1
				(poSteam setCycle: CT 25 -1 self)
			)
			(2
				(-= state 2)
				(poSteam setCycle: End self)
			)
		)
	)
)

(instance soSteamDissipates of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poSteam cycleSpeed: 5 setCycle: Beg self)
			)
			(1
				(poSteam dispose:)
			)
		)
	)
)

(instance foExit of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 331 111 332 111 200 4 200
					yourself:
				)
		)
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

