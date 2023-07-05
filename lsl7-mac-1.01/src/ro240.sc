;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro240 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (localproc_0)
	(if (poPurserCUEyes plane:)
		(poPurserCUEyes setCycle: Beg)
	else
		(poPurserCUEyes cel: 0)
	)
)

(procedure (localproc_1)
	(if (poPurserCUEyes plane:)
		(poPurserCUEyes setCycle: End)
	else
		(poPurserCUEyes cel: 99)
	)
)

(procedure (localproc_2)
	(if (poLarryCUEyes plane:)
		(poLarryCUEyes setCycle: Beg)
	else
		(poLarryCUEyes cel: 0)
	)
)

(procedure (localproc_3)
	(if (poLarryCUEyes plane:)
		(poLarryCUEyes setCycle: End)
	else
		(poLarryCUEyes cel: 99)
	)
)

(instance ro240 of L7Room
	(properties
		picture 24000
	)

	(method (init)
		(super init:)
		(if (or (== gPrevRoomNum 246) (== gPrevRoomNum 245)) ; ro246, ro245
			(gEgo
				normalize: 7
				posn: 472 451
				init:
				setScaler: Scaler 100 43 337 186
			)
		else
			(gEgo
				normalize: 4
				posn: 190 213
				init:
				setScaler: Scaler 100 43 337 186
			)
		)
		(UpdateScreenItem gEgo)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 36 212 47 229 182 222 391 468 492 451 246 220 246 198 323 192 310 182 227 189 222 204 149 213 133 199
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 6 95 9 124 242 121 117 92
					yourself:
				)
		)
		(foExitBack init:)
		(foExitOut init:)
		(gGame handsOn:)
		(if
			(and
				((ScriptID 64017 0) test: 34) ; oFlags
				((ScriptID 64017 0) test: 30) ; oFlags
				((ScriptID 64017 0) test: 32) ; oFlags
				((ScriptID 64017 0) test: 292) ; oFlags
			)
			(gCurRoom setScript: soPlayWilly)
			(return)
		)
		(if
			(and
				((ScriptID 64017 0) test: 41) ; oFlags
				((ScriptID 64017 0) test: 38) ; oFlags
				((ScriptID 64017 0) test: 162) ; oFlags
				(not ((ScriptID 64017 0) test: 34)) ; oFlags
			)
			(gCurRoom setScript: soPlayJuggsMovie)
			(return)
		)
		(if (not ((ScriptID 64017 0) test: 33)) ; oFlags
			(gCurRoom setScript: soPlayTMTMovie)
		else
			(gOMusic1 setMusic: 38000)
		)
		(if
			(and
				((ScriptID 64017 0) test: 34) ; oFlags
				(or
					(not ((ScriptID 64017 0) test: 30)) ; oFlags
					(not ((ScriptID 64017 0) test: 32)) ; oFlags
					(not ((ScriptID 64017 0) test: 292)) ; oFlags
				)
			)
			(if (not ((ScriptID 64017 0) test: 30)) ; oFlags
				(voChaseLightsLS init:)
			)
			(gCurRoom drawPic: 24050)
			(foStairs init:)
		)
		(foStage init:)
		(foChest1 init:)
		(foChest2 init:)
		(foCannon1 init:)
		(foCannon2 init:)
		(foDoors1 init:)
		(foDoors2 init:)
		(foNet1 init:)
		(foNet2 init:)
		(foBackdrop init:)
		(if (not ((ScriptID 64017 0) test: 222)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 265 407
				setDest: 640 494
				loop: 0
				cel: 0
				setPri: 50
				nMyFlag: 222
				init:
			)
		)
	)

	(method (dispose)
		(if
			(and
				((ScriptID 64017 0) test: 41) ; oFlags
				((ScriptID 64017 0) test: 38) ; oFlags
				(not (OneOf gNewRoomNum 240 245 246)) ; ro240, ro245, ro246
			)
			((ScriptID 64017 0) set: 162) ; oFlags
		)
		(if
			(and
				((ScriptID 64017 0) test: 34) ; oFlags
				((ScriptID 64017 0) test: 30) ; oFlags
				((ScriptID 64017 0) test: 32) ; oFlags
				(not (OneOf gNewRoomNum 240 245 246)) ; ro240, ro245, ro246
			)
			((ScriptID 64017 0) set: 292) ; oFlags
		)
		(oDrums stop:)
		(oWillyVoice stop:)
		(oAudience stop:)
		(super dispose: &rest)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 34) ; oFlags
		((ScriptID 64017 0) clear: 30) ; oFlags
		((ScriptID 64017 0) clear: 32) ; oFlags
	)
)

(instance soPlayWilly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poWilly init:)
				(poWillyLeftArm init:)
				(poWillyRightArm init:)
				(voMike init:)
				(gCurRoom drawPic: 24400)
				(oDrums preload: 24405 24406 24407 24408 24409 24410)
				(if (not ((ScriptID 64017 0) test: 219)) ; oFlags
					(self setScript: soPlayWillyIntro self)
				else
					(gOMusic1 setMusic: 0)
					(poWilly setCycle: Fwd)
					(poWillyLeftArm setScript: soCycleLeftArm)
					(poWillyRightArm setScript: soCycleRightArm)
					(= cycles 1)
				)
			)
			(1
				(= cycles 1)
			)
			(2
				(while 1
					(if (== global231 25)
						(= global231 1)
						(if (== global230 5)
							((ScriptID 64017 0) set: 35) ; oFlags
							(= global230 1)
						else
							(++ global230)
						)
					else
						(++ global231)
					)
					(if (Message msgGET 244 1 0 global230 global231)
						(break)
					)
				)
				(poWilly setCycle: Fwd)
				(poWillyLeftArm setScript: soCycleLeftArm)
				(poWillyRightArm setScript: soCycleRightArm)
				(oWillyVoice playMessage: 1 0 global230 global231 self 244 1)
			)
			(3
				(poWilly setCycle: 0)
				(poWillyLeftArm setScript: 0 setCycle: 0 cel: 0)
				(poWillyRightArm setScript: 0 setCycle: 0 cel: 0)
				(switch (Random 0 5)
					(0
						(oDrums playSound: 24405)
					)
					(1
						(oDrums playSound: 24406)
					)
					(2
						(oDrums playSound: 24407)
					)
					(3
						(oDrums playSound: 24408)
					)
					(4
						(oDrums playSound: 24409)
					)
					(5
						(oDrums playSound: 24410)
					)
				)
				(switch (Random 0 2)
					(0
						(oAudience playSound: 24402 self)
					)
					(1
						(oAudience playSound: 24403 self)
					)
					(2
						(oAudience playSound: 24404 self)
					)
				)
				(-= state 2)
			)
		)
	)
)

(instance oDrums of TPSound
	(properties)
)

(instance oAudience of TPSound
	(properties)
)

(instance oWillyVoice of TPSound
	(properties
		type 2
	)
)

(instance soPlayWillyIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOMusic1 playSound: 24400)
				(gEgo walkTo: 277 286 coInPositionWilly)
				(= ticks 60)
			)
			(1
				(gMessager say: 0 0 2 1 self 244) ; "And now: The Proud Lil' Seaman Lounge presents our version of Disney's Mr. Lincoln. Welcome to "Great Moments with Mr. Clinton," starring our little audio-animatronic answer to the deterioration of respect for the office of the President of the United States, WILLY!"
			)
			(2
				(poWilly setCycle: Fwd)
				(poWillyLeftArm setScript: soCycleLeftArm)
				(poWillyRightArm setScript: soCycleRightArm)
				(gMessager say: 0 0 2 2 self 244) ; "Thank you. Thank you. Thank you. And let me just say this: Thank you. I'm your president!"
			)
			(3
				(poWilly setCycle: 0)
				(poWillyLeftArm setScript: 0 setCycle: 0 cel: 0)
				(poWillyRightArm setScript: 0 setCycle: 0 cel: 0)
				(oDrums playSound: 24405)
				(gMessager say: 0 0 2 3 self 244) ; "(laughter)"
			)
			(4
				(poWilly setCycle: Fwd)
				(poWillyLeftArm setScript: soCycleLeftArm)
				(poWillyRightArm setScript: soCycleRightArm)
				(gMessager say: 0 0 2 4 self 244) ; "Hey, wait a minute now. I haven't started the jokes yet!"
			)
			(5
				(gMessager say: 0 0 2 6 self 244) ; "And now, without any further to do, here's the gags!"
			)
			(6
				((ScriptID 64017 0) set: 219) ; oFlags
				(gOMusic1 fadeOut:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPlayTMTMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOMusic1 stop:)
				(gCurRoom drawPic: 24400)
				(= local0 0)
				(poPurser init: setCycle: End coPurserReady)
				(gEgo walkTo: 277 286 coInPosition)
				(= global340 toPurser)
				(gMessager say: 0 0 1 1 self 241) ; "...there's a few chairs there in the back. Oh, never mind. If you're not seated by now, just stand!"
			)
			(1)
			(2)
			(3
				(gCurRoom addRoomPlane: oPurserCUPlane)
				(poPurserCU setScript: soShuffleCards)
				(gMessager say: 0 0 1 2 self 241) ; "(SPEECH FORMALLY BEGINS; KEEP IT MOVING) I'm sure Captain Thygh will be pleased to see such a good turnout this week. As you know, each week she runs a little competition for her male (SOFTLY) (or male-like) (NORMAL) passengers, which she calls "The Thygh's Man Trophy" contest. Of course, there's no actual trophy involved. No, what you win is better than hardware: one of you will spend next week "Cruising on the Captain." (CLEAR THROAT) That is, she'll treat you to a one-week cruise in her cabin where your (A LITTLE DISGUST) every need will be met. (BUSINESS-LIKE AGAIN) By now, each of you has received your personal scorecard, listing a random set of events the computer assigned you. Don't worry; no one has to enter every event -- there are too many. Just find the ones listed on your scorecard, enter and win. The "man" with the highest total score wins. (BEAT) Are there any questions?"
			)
			(4
				(poPurserCU setScript: 0)
				(poPurserCU setCycle: End)
				(localproc_1)
				(gMessager sayRange: 0 0 1 3 4 self 241) ; "Are there any answers?"
			)
			(5
				(gCurRoom deleteRoomPlane: oPurserCUPlane)
				(gMessager say: 0 0 1 5 self 241) ; "Hey. I've got a question."
			)
			(6
				(localproc_1)
				(gCurRoom addRoomPlane: oPurserCUPlane)
				(localproc_0)
				(gMessager say: 0 0 1 6 self 241) ; "Yes? There. In the... interesting clothes."
			)
			(7
				(localproc_2)
				(gCurRoom addRoomPlane: oLarryCUPlane)
				(gMessager say: 0 0 1 7 self 241) ; "What's this item listed here on my scorecard: "Chast-titty?""
				(= ticks 120)
			)
			(8
				(localproc_3)
			)
			(9
				(gCurRoom deleteRoomPlane: oLarryCUPlane)
				(gMessager say: 0 0 1 8 self 241) ; "It's a joke, sweetheart! Say what's wrong with you, anyway? You're not some sort of "government infiltrator," are you?"
			)
			(10
				(gCurRoom addRoomPlane: oLarryCUPlane)
				(gMessager say: 0 0 1 9 self 241) ; "That's ridiculous!"
			)
			(11
				(gCurRoom deleteRoomPlane: oLarryCUPlane)
				(gMessager say: 0 0 1 10 self 241) ; "Oh, yes? I'm gonna keep my eye on you, sweetheart!"
			)
			(12
				(gCurRoom addRoomPlane: oLarryCUPlane)
				(gMessager say: 0 0 1 11 self 241) ; "It's not my fault you can't MAKE a joke!"
			)
			(13
				(gCurRoom deleteRoomPlane: oLarryCUPlane)
				(gMessager say: 0 0 1 12 self 241) ; "Yeah? You'll find out when we're finally in charge. Then you'll be the one singing a "chast-titty" tune!"
			)
			(14
				(gCurRoom addRoomPlane: oLarryCUPlane)
				(gMessager say: 0 0 1 13 self 241) ; "That's it. I'm leaving now. Everyone else has already gone."
			)
			(15
				(gCurRoom deleteRoomPlane: oLarryCUPlane)
				(gCurRoom deleteRoomPlane: oPurserCUPlane)
				(gCurRoom drawPic: 24000)
				(= global340 toPurser)
				(gMessager say: 0 0 1 14 self 241) ; "So they have. Very well. Dismissed!"
			)
			(16
				(gCurRoom addRoomPlane: oLarryCUPlane)
				(localproc_2)
				(gMessager say: 0 0 1 15 self 241) ; "(CONFUSED) He's a strange one!"
			)
			(17
				(= ticks 60)
			)
			(18
				(gCurRoom deleteRoomPlane: oLarryCUPlane)
				(poPurser dispose:)
				(voPurserMouth dispose:)
				(= cycles 2)
			)
			(19
				(gEgo get: ((ScriptID 64037 0) get: 46)) ; oInvHandler, ioScorecard
				((ScriptID 64017 0) set: 33) ; oFlags
				(= global211 0)
				(= global340 0)
				(= global330 0)
				(gOMusic1 setMusic: 38000)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coInPosition of CueMe
	(properties)

	(method (cue)
		(gEgo setHeading: 315 soPlayTMTMovie)
	)
)

(instance coInPositionWilly of CueMe
	(properties)

	(method (cue)
		(gEgo setHeading: 315)
	)
)

(instance coPurserReady of CueMe
	(properties)

	(method (cue)
		(poPurser view: 24101 cel: 0 loop: 0)
		(voPurserMouth init:)
		(= local0 1)
		(if (toPurser mouth:)
			((toPurser mouth:) show:)
		)
		(soPlayTMTMovie cue:)
	)
)

(instance soPlayJuggsMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOMusic1 stop:)
				(gEgo
					setScaler: 0
					setScalePercent: 75
					walkTo: 252 236 coInPositionJuggs
				)
				(Palette 1 242) ; PalLoad
				(gCurRoom drawPic: 24200)
				(poJuggs
					view: 24200
					loop: 0
					cel: 0
					posn: 114 113
					init:
					setCycle: Fwd
				)
				(gOMusic1 playSound: 24200)
				(= cycles 1)
			)
			(1
				(= seconds 17)
			)
			(2
				(gOSound1 playSound: 24203)
				(= seconds 1)
			)
			(3
				(poJuggs view: 24205 loop: 0 cel: 0 setCycle: CT 3 1 self)
				(gMessager sayRange: 0 0 1 3 4 self 242) ; "Thank ya'll."
			)
			(4)
			(5
				(poJuggs setCycle: End)
				(gMessager say: 0 0 1 5 self 242) ; "(DOWN A LITTLE) And now we need a volunteer for the "Unplugged" part of our set. Who wants to play with our jugs?"
			)
			(6
				(gOSound1 preload: 24216)
				(gMessager say: 0 0 1 6 self 242) ; "Wow!"
			)
			(7
				(gEgo dispose:)
				(poLarry
					view: 24210
					loop: 0
					cel: 20
					posn: 135 186
					init:
					setCycle: CT 27 1 coLarryOnStage
				)
				(gOSound1 playSound: 24216)
				(gMessager say: 0 0 1 7 self 242) ; "Why, lookee here, Mama: a volunteer!"
			)
			(8)
			(9
				(gOSound1 preload: 31010)
				(= global339 toNailmiCU)
				(= local1 1)
				(gMessager say: 0 0 1 8 coDoneTalking 242) ; "(SLAP DOWN LARRY'S HANDS ON BUCK) Howdy, BUCK-aroo!"
				(poWydonchaCU setCycle: CycleCueList 3 1 self 3)
			)
			(10
				(poWydonchaCU cycleSpeed: 7 setCycle: End self 8 9 10 99)
				(poLarry
					view: 24220
					loop: 0
					cel: 0
					posn: 305 351
					cycleSpeed: 7
					init:
					setCycle: CT 6 1
				)
			)
			(11)
			(12
				(poLarry hide:)
				(gOSound1 playSound: 31010)
			)
			(13
				(poLarry cel: 6 show: setCycle: End)
			)
			(14
				(= cycles 1)
				(if local1
					(-- state)
				)
			)
			(15
				(poWydonchaCU view: 24225 loop: 0 cel: 0 posn: 557 336)
				(voWydonchaCUMouth init:)
				(= global338 toWydonchaCU)
				(gMessager sayRange: 0 0 1 9 10 self 242) ; "Pardon us, while we whip these out..."
			)
			(16
				(Load rsVIEW 24230)
				(= ticks 60)
			)
			(17
				(voWydonchaCUMouth dispose:)
				(voNailmiCUMouth dispose:)
				(poNailmiCU
					view: 24230
					loop: 1
					cel: 0
					posn: 557 356
					setCycle: End self
				)
				(poWydonchaCU
					view: 24230
					loop: 0
					cel: 0
					posn: 557 356
					setCycle: End self
				)
				(UpdateScreenItem poNailmiCU)
				(UpdateScreenItem poWydonchaCU)
			)
			(18
				(gMessager say: 0 0 1 11 self 242) ; "(EXHALES) Whew!"
				(poNailmiCU
					view: 24235
					loop: 2
					cel: 0
					posn: 95 337
					hide:
					show:
					setCycle: End self
				)
			)
			(19)
			(20
				(poNailmiCU loop: 0 cel: 0)
				(voNailmiCUMouth init:)
				(= global339 toNailmiCU)
				(gMessager say: 0 0 1 12 self 242) ; "Hey, Johnson? How 'bout some special lighting?"
			)
			(21
				(Load rsPIC 24700)
				(= ticks 60)
			)
			(22
				(proc64896_1 1 100 self)
			)
			(23
				(gCurRoom addRoomPlane: oSpotlightPlane)
				(gOSound1 playSound: 24201)
				(proc64896_1 0 3 self)
			)
			(24
				(= ticks 120)
			)
			(25
				(gCurRoom deleteRoomPlane: oSpotlightPlane)
				(PalCycle 0 45 47 1 10) ; Start
				(gOSound1 preload: 24205 24214)
				(gOMusic1 setMusic: 24215)
				(poNailmiCU dispose:)
				(poWydonchaCU dispose:)
				(voWydonchaCUMouth dispose:)
				(voNailmiCUMouth dispose:)
				(poLarry dispose:)
				(poNailmiCU view: 24245 loop: 0 cel: 0 posn: 111 343 init:)
				(voNailmiCUMouth init:)
				(poNailmiArm init:)
				(poWydonchaCU view: 24250 loop: 0 cel: 0 posn: 556 356 init:)
				(voWydonchaCUMouth init:)
				(poWydonchaArm init:)
				(poLarryJugs
					view: 24240
					loop: 0
					cel: 0
					posn: 317 324
					init:
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(26
				(= ticks 620)
			)
			(27
				(poNailmiCU dispose:)
				(voNailmiCUMouth dispose:)
				(poNailmiArm dispose:)
				(poWydonchaCU dispose:)
				(voWydonchaCUMouth dispose:)
				(poWydonchaArm dispose:)
				(gCurRoom addRoomPlane: oNailmiCUPlane)
				(gMessager say: 0 0 1 13 self 242) ; "Whew! Wydoncha, honey, is it hot in here?"
			)
			(28
				(gCurRoom deleteRoomPlane: oNailmiCUPlane)
				(gCurRoom addRoomPlane: oWydonchaCUPlane)
				(gMessager say: 0 0 1 14 self 242) ; "Oh, Mama. I'm ah gettin' that feelin' again!"
			)
			(29
				(gCurRoom deleteRoomPlane: oWydonchaCUPlane)
				(gCurRoom addRoomPlane: oLarryJuggsCUPlane)
				(poLarry setCycle: End self)
			)
			(30
				(= ticks 60)
			)
			(31
				(gCurRoom deleteRoomPlane: oLarryJuggsCUPlane)
				(gCurRoom addRoomPlane: oSpotlightPlane)
				(gOSound1 playSound: 24206)
				(= local5 100)
				(self setScript: soFlickerOn self)
			)
			(32
				(gOSound1 stop:)
				(gCurRoom deleteRoomPlane: oSpotlightPlane)
				(poLarryJugs dispose:)
				(poJuggs view: 24270 loop: 0 cel: 0 posn: 305 322 init:)
				(= cycles 1)
			)
			(33
				(= ticks 10)
			)
			(34
				(= local5 60)
				(oSpotlightSound setRelVol: 50 playSound: 24206)
				(= local1 1)
				(gMessager say: 0 0 1 15 coDoneTalking 242) ; "(BOTH JUGSS TOGETHER) Grab him!"
				(poJuggs setCycle: End self)
				(= cycles 1)
			)
			(35
				(self setScript: soFlickerOff self)
			)
			(36)
			(37
				(gOSound1 playSound: 24213)
				(poJuggs
					view: 24275
					loop: 0
					cel: 0
					posn: 296 211
					setCycle: End self
				)
				(= cycles 1)
			)
			(38
				(self setScript: soFlickerOn self)
			)
			(39)
			(40
				(gMessager kill:)
				(gMessager say: 0 0 1 18 coDoneTalking 242) ; "(MULTIPLE) Yee-haw."
				(poJuggs
					view: 24275
					loop: 1
					cel: 0
					posn: 320 229
					setCycle: End self
				)
				(= local5 40)
				(self setScript: soFlickerOff self)
			)
			(41)
			(42
				(if local1
					(-- state)
				)
				(= cycles 1)
			)
			(43
				(= ticks 180)
			)
			(44
				(poJuggs view: 24280 loop: 0 cel: 0 posn: 327 326 setCycle: Fwd)
				(= ticks 100)
				(= local5 60)
				(oSpotlightSound setRelVol: 50 playSound: 24206)
				(self setScript: soFlickerOn self)
				(gMessager kill:)
				(gMessager say: 0 0 1 19 coDoneTalking 242) ; "(ALTERNATING, AS AT JULY 4TH FIREWORDS SHOW) Ooooh!"
			)
			(45)
			(46
				(self setScript: soFlickerOff self)
				(= ticks 180)
			)
			(47)
			(48
				(poJuggs
					view: 24285
					loop: 0
					cel: 0
					posn: 343 362
					setCycle: End self 8
				)
				(oSpotlightSound playSound: 24206)
				(self setScript: soFlickerOn self)
				(gMessager kill:)
				(gMessager say: 0 0 1 20 coDoneTalking 242) ; "(ALTERNATING, AS AT JULY 4TH FIREWORDS SHOW) Ahhhh!"
			)
			(49)
			(50
				(self setScript: soFlickerOff self)
				(= ticks 180)
			)
			(51)
			(52
				(poJuggs view: 24290 loop: 0 cel: 0 posn: 327 346 setCycle: Fwd)
				(= ticks 120)
				(oSpotlightSound playSound: 24206)
				(self setScript: soFlickerOn self)
				(gMessager kill:)
				(gMessager say: 0 0 1 19 coDoneTalking 242) ; "(ALTERNATING, AS AT JULY 4TH FIREWORDS SHOW) Ooooh!"
			)
			(53)
			(54
				(self setScript: soFlickerOff self)
				(= ticks 180)
			)
			(55)
			(56
				(poJuggs view: 24295 loop: 0 cel: 0 posn: 319 334 setCycle: Fwd)
				(= ticks 120)
				(oSpotlightSound playSound: 24206)
				(self setScript: soFlickerOn self)
				(= local1 1)
				(gMessager kill:)
				(gMessager say: 0 0 1 20 coDoneTalking 242) ; "(ALTERNATING, AS AT JULY 4TH FIREWORDS SHOW) Ahhhh!"
			)
			(57)
			(58
				(self setScript: soFlickerOff self)
			)
			(59
				(if local1
					(-- state)
				)
				(= cycles 1)
			)
			(60
				(gOMusic1 fadeOut: self 10 3)
			)
			(61
				(PalCycle 4) ; Off
				(= global339 0)
				(= global338 0)
				(= global330 0)
				((ScriptID 64017 0) set: 34) ; oFlags
				((ScriptID 64017 0) set: 259) ; oFlags
				((ScriptID 64017 0) set: 175) ; oFlags
				(gCurRoom addRoomPlane: oBlackPlane)
				(FrameOut)
				(proc64896_17 100)
				(CopyWinningWallpaper 4)
				(proc64896_17 0)
				(gCurRoom deleteRoomPlane: oBlackPlane)
				(gCurRoom newRoom: 551) ; ro551
				(self dispose:)
			)
		)
	)
)

(instance oBlackPlane of Plane
	(properties)

	(method (init)
		(super init: 0 0 639 479)
	)
)

(instance soFlickerOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 gGameTime)
				(= local6 0)
				(proc64896_17 0)
				(= cycles 1)
			)
			(1
				(if (== local6 100)
					(= local6 0)
				else
					(= local6 100)
				)
				(if (Random 0 1)
					(FadeTo local6 50 self)
				else
					(proc64896_17 local6)
					(= cycles 1)
				)
			)
			(2
				(if (> (- gGameTime local4) local5)
					(if (!= local6 100)
						(FadeTo 100 50 self)
					else
						(= cycles 1)
					)
				else
					(= ticks (Random 1 10))
					(-= state 2)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soFlickerOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 gGameTime)
				(= local6 100)
				(self cue:)
			)
			(1
				(if (== local6 100)
					(= local6 0)
				else
					(= local6 100)
				)
				(if (Random 0 1)
					(FadeTo local6 50 self)
				else
					(proc64896_17 local6)
					(= cycles 1)
				)
			)
			(2
				(if (> (- gGameTime local4) local5)
					(if (!= local6 0)
						(FadeTo 0 50 self)
					else
						(= cycles 1)
					)
				else
					(= ticks (Random 1 10))
					(-= state 2)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance oSpotlightSound of TPSound
	(properties)
)

(instance coLarryInPlace of CueMe ; UNUSED
	(properties)

	(method (cue)
		(soPlayJuggsMovie cue:)
	)
)

(instance coInPositionJuggs of CueMe
	(properties)

	(method (cue)
		(gEgo setHeading: 315)
	)
)

(instance coLarryOnStage of CueMe
	(properties)

	(method (cue)
		(poLarry setCycle: 0 dispose:)
		(poJuggs dispose:)
		(gCurRoom addRoomPlane: oStagePlane)
		(poNailmiCU view: 24215 loop: 0 cel: 0 posn: 95 343 init:)
		(voNailmiCUMouth init:)
		(poWydonchaCU view: 24216 loop: 0 cel: 0 posn: 556 336 init:)
		(soPlayJuggsMovie cue:)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local1 0)
	)
)

(instance soGoUpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 309 189 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(poLarry
					view: 24051
					loop: 0
					cel: 0
					posn: 306 184
					setPri: 20
					cycleSpeed: 7
					init:
					setCycle: End self
				)
			)
			(3
				(poLarry dispose:)
				(gEgo posn: 271 126 show: walkTo: 221 122 self 0)
			)
			(4
				(= local7 1)
				(foStageExit init:)
				(foStage dispose:)
				(foExitBack dispose:)
				(foExitOut dispose:)
				(foStairs forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGoDownStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 271 126 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 271 126 self 0 0 0)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(gEgo hide:)
				(poLarry
					view: 24051
					loop: 0
					cel: 16
					posn: 306 184
					setPri: 20
					cycleSpeed: 11
					init:
					setCycle: Beg self
				)
			)
			(4
				(poLarry dispose:)
				(gEgo posn: 309 189 show: setHeading: 225 self)
			)
			(5
				(= local7 0)
				(foStageExit dispose:)
				(foStage init:)
				(foExitBack init:)
				(foExitOut init:)
				(foStairs forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poJuggs of Prop
	(properties)
)

(instance poLarry of Prop
	(properties)
)

(instance poLarry2 of Prop ; UNUSED
	(properties)
)

(instance poLarryJugs of Prop
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (!= cel local3)
			(if (or (== cel 14) (== cel 18))
				(gOSound1 playSound: 24205)
			)
			(if (or (== cel 22) (== cel 26))
				(gOSound1 playSound: 24214)
			)
			(= local3 cel)
		)
	)
)

(instance poWilly of Prop
	(properties
		x 118
		y 106
		priority 111
		fixPriority 1
		view 24400
	)
)

(instance poWillyLeftArm of Prop
	(properties
		x 117
		y 111
		priority 110
		fixPriority 1
		view 24400
		loop 1
		cycleSpeed 8
	)
)

(instance poWillyRightArm of Prop
	(properties
		x 117
		y 111
		priority 112
		fixPriority 1
		view 24400
		loop 2
		cycleSpeed 8
	)
)

(instance voMike of View
	(properties
		x 136
		y 121
		view 24450
	)
)

(instance soCycleLeftArm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poWillyLeftArm cel: 0)
				(= ticks (Random 30 240))
			)
			(1
				(if (Random 0 1)
					(poWillyLeftArm loop: 1)
				else
					(poWillyLeftArm loop: 3)
				)
				(poWillyLeftArm cel: 0 setCycle: End self)
				(-= state 2)
			)
		)
	)
)

(instance soCycleRightArm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poWillyRightArm cel: 0)
				(= ticks (Random 30 240))
			)
			(1
				(if (Random 0 1)
					(poWillyRightArm loop: 2)
				else
					(poWillyRightArm loop: 4)
				)
				(poWillyRightArm cel: 0 setCycle: End self)
				(-= state 2)
			)
		)
	)
)

(instance poNailmiCU of Prop
	(properties)
)

(instance voNailmiCUMouth of View
	(properties)

	(method (init)
		(= view (poNailmiCU view:))
		(= loop (poNailmiCU loop:))
		(++ loop)
		(= x (poNailmiCU x:))
		(= y (poNailmiCU y:))
		(= priority (poNailmiCU priority:))
		(++ priority)
		(= fixPriority 1)
		(super init: &rest)
	)
)

(instance toNailmiCU of Talker
	(properties)

	(method (init)
		(= view (poNailmiCU view:))
		(= loop (poNailmiCU loop:))
		(++ loop)
		(= x (poNailmiCU x:))
		(= y (poNailmiCU y:))
		(= priority (poNailmiCU priority:))
		(++ priority)
		(voNailmiCUMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voNailmiCUMouth show:)
		(super dispose: &rest)
	)
)

(instance poNailmiArm of Prop
	(properties
		x 111
		y 343
		priority 344
		fixPriority 1
		view 24245
		loop 2
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poWydonchaCU of Prop
	(properties)
)

(instance voWydonchaCUMouth of View
	(properties)

	(method (init)
		(= view (poWydonchaCU view:))
		(= loop (poWydonchaCU loop:))
		(++ loop)
		(= x (poWydonchaCU x:))
		(= y (poWydonchaCU y:))
		(= priority (poWydonchaCU priority:))
		(++ priority)
		(= fixPriority 1)
		(super init: &rest)
	)
)

(instance toWydonchaCU of Talker
	(properties)

	(method (init)
		(= view (poWydonchaCU view:))
		(= loop (poWydonchaCU loop:))
		(++ loop)
		(= x (poWydonchaCU x:))
		(= y (poWydonchaCU y:))
		(= priority (poWydonchaCU priority:))
		(++ priority)
		(voWydonchaCUMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voWydonchaCUMouth show:)
		(super dispose: &rest)
	)
)

(instance poWydonchaArm of Prop
	(properties
		x 556
		y 356
		priority 357
		fixPriority 1
		view 24250
		loop 2
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poPurser of Prop
	(properties
		x 94
		y 122
		view 24100
		cel 1
	)
)

(instance voPurserMouth of View
	(properties
		x 94
		y 122
		priority 123
		fixPriority 1
		view 24101
		loop 1
	)
)

(instance toPurser of Talker
	(properties
		x 94
		y 122
		view 24101
		loop 1
		priority 123
	)

	(method (init)
		(super init: &rest)
		(if (and local0 (voPurserMouth plane:))
			(voPurserMouth hide:)
		else
			(mouth hide:)
		)
	)

	(method (dispose)
		(voPurserMouth show:)
		(super dispose: &rest)
	)
)

(instance voChaseLightsLS of View
	(properties
		noun 13
		approachX 141
		approachY 98
		x 179
		y 100
		view 24050
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addExceptionVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gEgo setScript: soTakeLights)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soTakeLights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local7)
					(self setScript: soGoUpStairs self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 141 98 self)
			)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gEgo get: ((ScriptID 64037 0) get: 0)) ; oInvHandler, ioChaseLights
				((ScriptID 64017 0) set: 30) ; oFlags
				(voChaseLightsLS dispose:)
				(gMessager say: 13 8 0 0 self) ; "What are you going to do with those?"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voLadders of View ; UNUSED
	(properties
		x 292
		y 190
		view 24050
		loop 1
	)
)

(instance foChest1 of Feature
	(properties
		x 218
		y 340
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 82 240 97 235 99 205 138 207 140 217 186 211 194 277 261 273 263 348 346 343 357 368 342 474 180 476 164 438 167 393 184 388 184 372 135 386 115 341 120 308 134 306 133 292 94 301 80 262
					yourself:
				)
		)
		(super init: &rest)
		(= noun 8)
		(AddDefaultVerbs self)
	)
)

(instance foChest2 of Feature
	(properties
		x 453
		y 318
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 268 224 273 184 296 184 304 187 306 211 311 211 315 194 366 191 369 211 361 244 369 239 410 240 413 273 424 273 425 249 496 248 502 274 495 287 495 309 530 309 545 320 549 359 561 360 561 329 639 324 636 434 551 452 503 421 508 387 481 387 475 333 419 343 384 315 387 296 367 294 359 264 362 250 349 248 309 255 285 237
					yourself:
				)
		)
		(super init: &rest)
		(= noun 8)
		(AddDefaultVerbs self)
	)
)

(instance foCannon1 of Feature
	(properties
		x 31
		y 338
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 416 29 423 52 444 61 443 62 456 53 459 56 477 1 477 2 199 14 206 25 213 18 222 2 232 8 242 26 252 32 258 32 263 25 267 5 283 14 299 2 301 4 313 24 321 37 334 37 341 32 348 23 361 9 365 3 368
					yourself:
				)
		)
		(super init: &rest)
		(= noun 4)
		(AddDefaultVerbs self)
	)
)

(instance foCannon2 of Feature
	(properties
		x 475
		y 237
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 332 164 365 163 366 190 378 203 405 182 439 184 439 232 452 232 477 212 511 205 528 214 526 265 552 273 572 241 602 234 625 242 623 300 596 311 593 296 561 284 555 289 553 276 524 262 507 268 497 245 461 248 461 236 434 227 414 229 412 218 390 211 385 215 382 214 383 204 365 193 360 188 344 190 325 185
					yourself:
				)
		)
		(super init: &rest)
		(= noun 4)
		(AddDefaultVerbs self)
	)
)

(instance foDoors1 of Feature
	(properties
		x 91
		y 163
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 149 134 148 142 153 131 155 128 174 41 179
					yourself:
				)
		)
		(super init: &rest)
		(= noun 3)
		(AddDefaultVerbs self)
	)
)

(instance foDoors2 of Feature
	(properties
		x 235
		y 153
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 196 141 262 139 274 143 278 145 260 147 260 160 193 168
					yourself:
				)
		)
		(super init: &rest)
		(= noun 3)
		(AddDefaultVerbs self)
	)
)

(instance foStage of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 89 124 87 157 95 291 125 1 138
					yourself:
				)
		)
		(super init: &rest)
		(= noun 6)
		(AddDefaultVerbs self)
		(if ((ScriptID 64017 0) test: 34) ; oFlags
			(= case 6)
		else
			(= case 7)
		)
	)
)

(instance foNet1 of Feature
	(properties
		noun 7
		x 200
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 152 56 145 1 232 0 276 80
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foNet2 of Feature
	(properties
		noun 7
		x 500
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 422 2 636 2 639 185 449 144
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBackdrop of Feature
	(properties
		noun 12
		x 60
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 50 35 1 60 1 85 49 96 62 110 51 110 31 126 32 125 65 1 65
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foStageExit of Feature
	(properties)

	(method (init)
		(= y 1)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 90 36 90 36 140 0 140 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soGoBackStage)
	)
)

(instance soGoBackStage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: -30 111 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: -30 111 self 0 0 0)
			)
			(2
				(gCurRoom addRoomPlane: oBackStagePlane)
				(self dispose:)
			)
		)
	)
)

(instance foStairs of Feature
	(properties
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 264 129 299 127 324 191 287 187 278 186 265 156
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(if local7
			(gEgo setScript: soGoDownStairs)
		else
			(gEgo setScript: soGoUpStairs)
		)
	)
)

(instance foExitBack of ExitFeature
	(properties
		x 346
		y 374
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 56 477 635 271 636 478 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitBack)
	)
)

(instance soExitBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 529 489 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 529 489 0 0 0 0)
				(= ticks 20)
			)
			(2
				(gCurRoom newRoom: 246) ; ro246
			)
		)
	)
)

(instance foExitOut of ExitFeature
	(properties
		x 177
		y 170
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 195 137 151 151 132 176 131 191 148 193 187 218 203 152 210
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitOut)
	)
)

(instance soExitOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 190 213 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 171 198 0 0 0 0)
				(= ticks 20)
			)
			(2
				(gCurRoom newRoom: 230) ; ro230
			)
		)
	)
)

(instance oNailmiCUPlane of Plane
	(properties
		picture 24225
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(poNailmiCU view: 24255 loop: 0 posn: 420 479 init:)
		(voNailmiCUMouth init:)
	)
)

(instance oWydonchaCUPlane of Plane
	(properties
		picture 24250
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(poWydonchaCU view: 24260 loop: 0 posn: 420 479 init:)
		(voWydonchaCUMouth init:)
	)
)

(instance oLarryJuggsCUPlane of Plane
	(properties
		picture 24275
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(poLarry view: 24265 loop: 0 cel: 0 posn: 294 426 init:)
		(voBreasts view: 24265 loop: 1 posn: 294 426 init:)
	)
)

(instance voBreasts of View
	(properties)
)

(instance oStagePlane of Plane
	(properties
		picture 24300
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
	)
)

(instance oSpotlightPlane of Plane
	(properties
		picture 24750
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
	)
)

(instance oBackStagePlane of Plane
	(properties
		picture 24600
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(foCUExit init:)
		(if (not ((ScriptID 64017 0) test: 32)) ; oFlags
			(voRemote init:)
		)
		(if (not ((ScriptID 64017 0) test: 30)) ; oFlags
			(voChaseLights init:)
		)
		(foMixer init:)
		(foKaraoke init:)
		(foMicrophone init:)
		(gGame handsOn:)
	)
)

(instance voRemote of View
	(properties
		noun 17
		x 254
		y 419
		view 24650
		loop 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb &rest)
		(if (== theVerb 8) ; Take
			(gEgo get: ((ScriptID 64037 0) get: 37)) ; oInvHandler, ioRemote
			((ScriptID 64017 0) set: 32) ; oFlags
			(self dispose:)
		)
	)
)

(instance voChaseLights of View
	(properties
		noun 13
		x 320
		y 237
		view 24650
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foMixer of Feature
	(properties)

	(method (init)
		(= noun 14)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 416 61 377 55 348 69 338 367 338 375 351 372 379 417 477 1 478
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 62)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Feel
			(if ((ScriptID 64017 0) test: 191) ; oFlags
				(= case 100)
				(super doVerb: theVerb &rest)
				(= case 0)
				(return)
			else
				(gEgo get: ((ScriptID 64037 0) get: 9)) ; oInvHandler, ioEarPlugs
				((ScriptID 64017 0) set: 191) ; oFlags
				((ScriptID 64017 0) set: 300) ; oFlags
				(ShowEasterEgg)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance foMicrophone of Feature
	(properties
		noun 16
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 333 434 339 427 377 409 403 387 415 384 427 395 426 412 410 420 395 420 344 442 333 440
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 62)
	)
)

(instance foKaraoke of Feature
	(properties
		noun 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 398 386 395 307 431 298 440 298 457 294 468 296 484 308 517 311 500 404 461 425 427 413 427 389 412 381
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 62)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oBackStagePlane)
		(gEgo hide: posn: 15 121 normalize: 0 1 show:)
	)
)

(instance oPurserCUPlane of Plane
	(properties
		picture 24100
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(poPurserCU init:)
		(poPurserCUHead init:)
		(poPurserCUEyes init:)
		(voPurserCUMouth init:)
		(= global340 toPurserCU)
	)

	(method (dispose)
		(= global340 0)
		(super dispose: &rest)
	)
)

(instance poPurserCU of Prop
	(properties
		x 309
		y 405
		priority 406
		fixPriority 1
		view 24105
		loop 3
	)
)

(instance poPurserCUHead of Prop
	(properties
		x 309
		y 405
		priority 405
		fixPriority 1
		view 24105
	)
)

(instance poPurserCUEyes of Prop
	(properties
		x 309
		y 405
		priority 406
		fixPriority 1
		view 24105
		loop 2
	)
)

(instance voPurserCUMouth of View
	(properties
		x 309
		y 405
		priority 406
		fixPriority 1
		view 24105
		loop 1
	)
)

(instance toPurserCU of Talker
	(properties
		x 309
		y 405
		view 24105
		loop 1
		priority 406
	)

	(method (init)
		(voPurserCUMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voPurserCUMouth show:)
		(super dispose: &rest)
	)
)

(instance soShuffleCards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= ticks (Random 180 360))
			)
			(1
				(localproc_0)
				(poPurserCU cel: 0 setCycle: End self)
			)
			(2
				(-= state 3)
				(= ticks 60)
			)
		)
	)
)

(instance oLarryCUPlane of Plane
	(properties
		picture 24150
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(poLarryCU init:)
		(poLarryCUEyes init:)
		(voLarryCUMouth init:)
		(= global330 toLarryCU)
	)

	(method (dispose)
		(= global330 0)
		(super dispose: &rest)
	)
)

(instance poLarryCU of Prop
	(properties
		x 527
		y 478
		priority 478
		fixPriority 1
		view 24110
	)
)

(instance poLarryCUEyes of Prop
	(properties
		x 527
		y 478
		priority 480
		fixPriority 1
		view 24110
		loop 2
		cel 999
	)
)

(instance voLarryCUMouth of View
	(properties
		x 527
		y 478
		priority 479
		fixPriority 1
		view 24110
		loop 1
	)
)

(instance toLarryCU of Talker
	(properties
		x 527
		y 478
		view 24110
		loop 1
		priority 479
	)

	(method (init)
		(voLarryCUMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryCUMouth show:)
		(super dispose: &rest)
	)
)

