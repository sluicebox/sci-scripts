;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use ExitFeature)
(use smell)
(use BalloonTalker)
(use ADRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm210 0
	reveler1Talker 2
	reveler2Talker 3
	sentry1Talker 11
	sentry2Talker 12
)

(local
	local0 = 1
	local1
	local2 = 1
	local3
	local4 = 1
	local5
	local6
	local7 = 1
	local8
	local9 = 1
)

(instance rm210 of ADRoom
	(properties
		noun 15
		picture 210
		west 350
	)

	(method (doVerb theVerb)
		(= global215 16)
		(if (== theVerb 999) ; ???
			(= theVerb 88) ; ???
		)
		(super doVerb: theVerb)
	)

	(method (init)
		(if (and (== gPrevRoomNum 100) (FileIO fiEXISTS {g}))
			(SetFlag 132)
			(ClearFlag 219)
			(SetFlag 96)
			(SetFlag 217)
			(= gAct 3)
			(= gPrevRoomNum 230)
		)
		(if (and (== gAct 3) (not (IsFlag 96)) (not (IsFlag 155)))
			(= local7 0)
		)
		(if (== gAct 0)
			(= gAct 1)
			(proc875_0)
		)
		(gGame handsOn:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 100 262 102 177 87 177 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 152 136 109 140 30 160 0 145 0 0 168 0 173 89 262 104 196 116
					yourself:
				)
		)
		(<<= local4 $000b)
		(<<= local0 $0008)
		(<<= local2 $0009)
		(= global114 1)
		(switch gPrevRoomNum
			(230
				(self style: 11)
				(gEgo
					init:
					normalize:
					x: 300
					y: 107
					setScale: 0
					ignoreActors: 0
				)
				(if (IsFlag 96)
					(= local7 0)
					(frisbeeGuy
						x: 230
						ignoreActors: 0
						approachVerbs: 141 70 85 7 6 86 30 89 ; ???, Special_Edition, Talk, Do, Look, Nose, Paw, Teeth
						init:
						stopUpd:
					)
					(self setScript: revelerCartoon)
				)
			)
			(250
				(SetFlag 10)
				(gEgo
					normalize:
					x: 213
					y: 92
					setScale: Scaler 100 81 104 97
					setLoop: 4
					init:
				)
				(= local6 1)
				(self setScript: sEnterFromAlley)
			)
			(601
				(gEgo normalize: x: 253 y: 110 init:)
				(= local6 1)
				(SetFlag 32)
				(self setScript: sEnterFromAlley)
			)
			(240
				(door setCel: 3 stopUpd:)
				(gEgo normalize: setScale: 0 x: 192 y: 123 init:)
				(self setScript: from240)
			)
			(350
				(gEgo normalize: setScale: 0 x: 20 y: 160 init:)
				(self style: 10)
			)
			(291
				(self picture: 0)
				(= global114 0)
				(cond
					((== global195 9)
						(= local1 1)
					)
					((== global195 10)
						(= local3 1)
					)
					(else
						(= local5 1)
					)
				)
				(gEgo normalize: init:)
				(DrawPic 210 100 1)
				(= local6 1)
				(gCurRoom setScript: sFinishConversation)
			)
			(116
				(= global114 0)
				(= picture 0)
				(DrawPic 210 100 1)
				((ScriptID 895 0) init:) ; pepper
			)
			(else
				(self style: 11)
				(gEgo init: normalize: x: 300 y: 107 setScale: 0)
			)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 108))
					(proc875_1 local0 global204)
					(proc875_1 local0 global206)
					(proc875_1 local0 global208)
				)
			)
			(SetFlag 132)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 109))
					(proc875_1 local2 global204)
					(proc875_1 local2 global206)
					(proc875_1 local2 global208)
				)
			)
			(SetFlag 133)
		)
		(super init: &rest)
		(woodThing init: addToPic:)
		(if (and (> gAct 1) (not (IsFlag 217)) (not (IsFlag 219)))
			(frisbeeGuy
				approachVerbs: 141 70 85 7 6 86 30 89 ; ???, Special_Edition, Talk, Do, Look, Nose, Paw, Teeth
				init:
				ignoreActors: 1
				setScript: sFrisbee
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 218 151 283 151 283 159 218 159
						yourself:
					)
			)
		)
		(if (and (not (IsFlag 219)) (not (IsFlag 96)) (IsFlag 217))
			(frisbeeGuy
				view: (if (!= gAct 5) 255 else 253)
				setLoop:
					(if (!= gAct 5)
						0
					else
						(frisbeeGuy loop:)
					)
				cel: 12
				x: 247
				y: 157
				ignoreActors: 1
				approachVerbs: 70 85 7 6 86 30 89 ; Special_Edition, Talk, Do, Look, Nose, Paw, Teeth
				init:
				stopUpd:
			)
			(reveler230
				view: (if (!= gAct 5) 255 else 254)
				setLoop:
					(if (!= gAct 5)
						1
					else
						(reveler230 loop:)
					)
				cel: 11
				x: 285
				y: 146
				approachVerbs: 70 85 7 6 86 30 89 ; Special_Edition, Talk, Do, Look, Nose, Paw, Teeth
				init:
				ignoreActors: 1
				stopUpd:
			)
			(if (!= gAct 5)
				(frisbeeGuy ignoreActors: 1 addToPic:)
				(reveler230 ignoreActors: 1 addToPic:)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 273 135 313 125 286 160 213 156
						yourself:
					)
			)
		)
		(door init: stopUpd:)
		(if (== gAct 4)
			(sentry1 approachVerbs: 7 85 init: stopUpd:) ; Do, Talk
			(sentry2 approachVerbs: 7 85 init: stopUpd:) ; Do, Talk
			(if (not (== gPrevRoomNum 291))
				(gLongSong number: 217 setLoop: 1 play:)
			)
		)
		(alleyEnter init:)
		(barrel init:)
		(bigBuilding init:)
		(crates init: setOnMeCheck: 1 16384)
		(hills init: setOnMeCheck: 1 8192)
		(idiotSign init:)
		(stocks init:)
		(shedDoor init:)
		(shedLock init:)
		(shed init: setOnMeCheck: 1 4096)
		(shedWindow init:)
		(smallBuild init:)
		(eastEFeature init:)
		(westEFeature init:)
		(bucket init:)
		(alley init:)
		(eastRoad init: setOnMeCheck: 1 8)
		(westRoad init: setOnMeCheck: 1 4)
		(if (and (not (IsFlag 96)) (not (IsFlag 155)) (== gAct 3))
			(gCurRoom setScript: clintonsWay)
		)
		(gInventory addAfter: (gInventory at: 44)) ; Wood_Cutting_c
		(if (OneOf gPrevRoomNum 116 291)
			(self curPic: 210 picture: 210)
		)
	)

	(method (doit)
		(cond
			(
				(and
					local7
					(gLongSong handle:)
					(== (gLongSong number:) 300)
					(> ((ScriptID 895 0) distanceTo: sentry1) 75) ; pepper
				)
				(gLongSong fade:)
				(= local7 0)
			)
			(
				(and
					local7
					(gLongSong handle:)
					(not (OneOf (gLongSong number:) 300 217))
					(> ((ScriptID 895 0) distanceTo: frisbeeGuy) 75) ; pepper
				)
				(gLongSong fade:)
				(= local7 0)
			)
		)
		(cond
			(script)
			((& (gEgo onControl: 1) $0002)
				(gCurRoom setScript: sEnterAlley)
			)
			((== (gEgo edgeHit:) 2)
				(gCurRoom setScript: sExitEast)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		((ScriptID 895 1) setHeading: 90) ; lockjaw
	)
)

(instance from240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance clintonsWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 155)
				(gLongSong number: 300 setLoop: -1 play:)
				(frisbeeGuy
					x: 233
					y: 161
					setCycle: 0
					view: 214
					setLoop: 0
					setScript: 0
				)
				(sentry2 view: 214 setLoop: 2 x: 273 y: 157 init:)
				(sentry1 view: 214 setLoop: 3 x: 262 y: 151 setCycle: Fwd init:)
				(reveler1Talker x: 75)
				(sentry2Talker x: 87 y: 105 tailPosn: 1)
				(sentry1Talker x: 110 y: 105 tailPosn: 1)
				(gMessager say: 23 0 84 1 self) ; "Marty Hardy, halt in the name of the king!"
			)
			(1
				(sentry2 setCycle: 0 stopUpd:)
				(gMessager say: 23 0 84 2 3 self) ; "Right, halt!"
			)
			(2
				(sentry2 setCycle: Fwd)
				(gMessager say: 23 0 84 4 self) ; "Yes, you silly twit! We are the King's own tax collectors, and you owe us a fee!"
			)
			(3
				(sentry2 setCycle: 0 stopUpd:)
				(gMessager say: 23 0 84 5 10 self) ; "No, I don't. I owe nothing to no one. My karma is clean."
			)
			(4
				(sentry2 setCycle: Fwd)
				(gMessager say: 23 0 84 11 self) ; "Oh, SHUT UP!!! Both of you! Hardy, hand over your money in the name of the king!"
			)
			(5
				(sentry2 setCycle: 0 stopUpd:)
				(gMessager say: 23 0 84 12 self) ; "I don't have any money, gnarly redcoat rodent."
			)
			(6
				(sentry2 setCycle: Fwd)
				(gMessager say: 23 0 84 14 self) ; "All right, then, hand over that flying disk."
			)
			(7
				(sentry2 setCycle: 0 stopUpd:)
				(gMessager say: 23 0 84 15 self) ; "My DISK? Not my disk! I LOVE my disk. It's my best friend in the world, next to my brother! No! (Sob!) Please! It's MINE! MINE!!! MAMAAAA!!!"
			)
			(8
				(sentry2 setCycle: Fwd)
				(gMessager say: 23 0 84 16 self) ; "All right, all right, do you have anything else?"
			)
			(9
				(sentry2 setCycle: 0 stopUpd:)
				(gMessager say: 23 0 84 17 self) ; "(Sniff.) Yeah, I think so, evil dude. Here."
			)
			(10
				(frisbeeGuy setCycle: End self)
			)
			(11
				(sentry2 setCycle: End self)
			)
			(12
				(sentry1 setCycle: Fwd)
				(gMessager say: 23 0 84 18 self) ; "A yo-yo? Well, I suppose it's better than nothing. Just have something better for us next time, you hear me?"
			)
			(13
				(sentry1 setCycle: 0 stopUpd:)
				(sentry2 setCycle: Beg)
				(gMessager say: 23 0 84 19 self) ; "And no more double negatives, got it? Good!"
			)
			(14
				(frisbeeGuy setCycle: Beg)
				(sentry2
					view: 833
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 350 151 self
				)
			)
			(15
				(sentry2 dispose:)
				(sentry1
					view: 834
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 350 157 self
				)
			)
			(16
				(sentry1 dispose:)
				(gLongSong fade:)
				(= local7 1)
				(gMessager say: 23 0 84 20 self) ; "(Sniff!) They took my yo-yo!"
			)
			(17
				(frisbeeGuy
					view: 826
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 262 157 self
				)
			)
			(18
				(frisbeeGuy
					view: 231
					loop: 0
					ignoreActors: 0
					setScript: sFrisbee
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 345 (gEgo y:) self)
			)
			(1
				(gLongSong fade:)
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance sFinishConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global115 14)
					((ScriptID 2000 3) offY: 15) ; PepperTalker
				)
				(= cycles 1)
			)
			(1
				(cond
					((and global115 (== global116 28))
						(= global215 70)
						(= state 9)
						(gMessager say: global115 85 28 1 self global196)
					)
					((and global115 (== global116 26))
						(= global215 26)
						(= state 19)
						(gMessager say: global115 85 26 1 4 self global196)
					)
					((and global115 global116)
						(switch global116
							(4
								(= global215 57)
							)
							(14
								(= global215 57)
							)
							(51
								(= global215 57)
							)
						)
						(= state 99)
						(gMessager say: global115 85 global116 0 self global196)
					)
					(else
						(= state 99)
						(= cycles 1)
					)
				)
			)
			(10
				(= state 99)
				(gMessager say: global115 85 28 2 3 self global196)
			)
			(20
				(= state 99)
				(gMessager say: global115 85 26 5 self global196)
			)
			(100
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFrisbee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (client loop:)
					(client setLoop: 0 setCel: 0)
				else
					(client setLoop: 1 setCel: 0)
				)
				(= ticks 60)
			)
			(1
				(client setCycle: End self)
				(if (client loop:)
					(gLongSong2 number: 2117 setLoop: 1 play:)
				else
					(gLongSong2 number: 2118 setLoop: 1 play:)
				)
			)
			(2
				(if (client loop:)
					(client cel: 0)
				)
				(= seconds (Random 3 7))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance revelerCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 155)
				(reveler230
					approachVerbs: 85 7 6 86 30 89 ; Talk, Do, Look, Nose, Paw, Teeth
					init:
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 285 146 self
				)
			)
			(1
				(reveler230 setLoop: 5)
				((ScriptID 895 0) setHeading: 180) ; pepper
				(gMessager say: 13 141 102 4 11 self) ; "Wow, that was heavy! Do you think he means us, Marty? I mean, we usually don't go down 'til the sun comes up!"
			)
			(2
				(reveler230 view: 254 cel: 0 setCycle: End self)
				(frisbeeGuy
					view: 826
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 247 157 self
				)
			)
			(3 0)
			(4
				(frisbeeGuy view: 253 x: 247 y: 157 setCycle: End self)
			)
			(5
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 273 135 313 125 286 160 213 156
							yourself:
						)
				)
				(frisbeeGuy ignoreActors: 1 addToPic:)
				(reveler230 ignoreActors: 1 addToPic:)
				(gLongSong number: 232 setLoop: -1 play:)
				(ClearFlag 96)
				(gGame handsOn:)
				(= local7 1)
				(self dispose:)
			)
		)
	)
)

(instance sGiveProverbRevelers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 217 2)
				(= cycles 1)
			)
			(1
				(gLongSong number: 230 setLoop: -1 play:)
				(frisbeeGuy setScript: 0)
				(gEgo put: 22) ; Wood_Cutting_a
				(if (and (not (gEgo has: 43)) (not (gEgo has: 44))) ; Wood_Cutting_b, Wood_Cutting_c
					(SetFlag 88)
				)
				(gMessager say: 13 141 102 1 3 self) ; "Marty, I have something here that might interest you."
			)
			(2
				(reveler230
					approachVerbs: 85 7 6 86 30 89 ; Talk, Do, Look, Nose, Paw, Teeth
					init:
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 285 146 self
				)
			)
			(3
				(gMessager say: 13 141 102 4 11 self) ; "Wow, that was heavy! Do you think he means us, Marty? I mean, we usually don't go down 'til the sun comes up!"
			)
			(4
				(reveler230 view: 254 cel: 0 setCycle: End self)
				(frisbeeGuy view: 253 x: 247 y: 157 setCycle: End self)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 100 262 102 177 87 177 0 319 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 152 136 109 140 30 160 0 145 0 0 168 0 173 89 262 104 196 116
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 273 135 313 125 286 160 213 156
							yourself:
						)
				)
			)
			(5
				(gLongSong number: 232 setLoop: -1 play:)
			)
			(6
				(frisbeeGuy ignoreActors: 1 addToPic:)
				(reveler230 ignoreActors: 1 addToPic:)
				(gLongSong fade:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkR1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(not (OneOf (gLongSong number:) 232 230))
						(not (gLongSong handle:))
					)
					(if (not (IsFlag 217))
						(gLongSong number: 230 setLoop: -1 play:)
					else
						(gLongSong number: 232 setLoop: -1 play:)
					)
				)
				(if
					(and
						(not (IsFlag 108))
						(not (IsFlag 120))
						(proc875_1 local0 global204)
						(proc875_1 local0 global206)
						(proc875_1 local0 global208)
						(proc875_1 local0 global205)
						(proc875_1 local0 global207)
						(proc875_1 local0 global209)
					)
					(SetFlag 132)
				)
				(Face (ScriptID 895 0) frisbeeGuy) ; pepper
				(= cycles 3)
			)
			(1
				(if (and (not (IsFlag 132)) local1)
					(gCurRoom newRoom: 291)
				else
					(self cue:)
				)
			)
			(2
				(if (not (IsFlag 132))
					(switch gAct
						(2
							(gMessager say: 1 85 105 0 self 211) ; "Excuse me, sir, but shouldn't you be chopping wood or growing crops or something?"
						)
						(3
							(if (IsFlag 217)
								(gMessager say: 1 85 111 0 self 211) ; "Hey, short person, I appreciate your help, but I'm totally behind on my reading. I'll talk to you later, okay?"
							else
								(gMessager say: 1 85 36 0 self 211) ; "Hey, Marty, how's life in the fast lane?"
							)
						)
						(4
							(gMessager say: 1 85 209 0 self 211) ; "Hey, Marty, how's it goin?"
						)
						(5
							(gMessager say: 13 85 54 0 self) ; "Hey, Marty, how's the studying coming along?"
						)
						(else
							(= cycles 1)
						)
					)
				else
					(gMessager say: 1 85 61 1 self 211) ; "The reveler is preoccupied, and takes no more notice of Pepper."
				)
			)
			(3
				(if (IsFlag 132)
					(self dispose:)
				else
					(= global195 9)
					(= cycles 1)
				)
			)
			(4
				(gCurRoom newRoom: 291)
				(self dispose:)
			)
		)
	)
)

(instance sTalkR2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(not (IsFlag 109))
						(not (IsFlag 121))
						(proc875_1 local2 global204)
						(proc875_1 local2 global206)
						(proc875_1 local2 global208)
						(proc875_1 local2 global205)
						(proc875_1 local2 global207)
						(proc875_1 local2 global209)
					)
					(SetFlag 133)
				)
				(if
					(or
						(not (== (gLongSong number:) 232))
						(not (gLongSong handle:))
					)
					(gLongSong number: 232 setLoop: -1 play:)
				)
				(Face (ScriptID 895 0) reveler230) ; pepper
				(= cycles 3)
			)
			(1
				(if (not local3)
					(if (not (IsFlag 133))
						(switch gAct
							(3
								(gMessager say: 14 85 111 0 self) ; "Excuse me, little dude, but I have a lot of reading to do. See you later, okay?"
							)
							(4
								(gMessager say: 14 85 35 0 self) ; "Hello, Throcky! Studyin' hard, huh?"
							)
							(5
								(gMessager say: 14 85 57 0 self) ; "Are you learning a lot, Throckmorton?"
							)
							(else
								(= cycles 1)
							)
						)
					else
						(gMessager say: 1 85 61 0 self 211) ; "The reveler is preoccupied, and takes no more notice of Pepper."
					)
				else
					(self cue:)
				)
			)
			(2
				(if (IsFlag 133)
					(self dispose:)
				else
					(= global195 10)
					(= cycles 1)
				)
			)
			(3
				(if (== gAct 3)
					(gGame handsOn:)
					(self dispose:)
				else
					(gCurRoom newRoom: 291)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGiveKingsLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 218 3)
				(gLongSong number: 300 setLoop: -1 play:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setMotion: PolyPath 183 138 self) ; pepper
			)
			(2
				((ScriptID 895 0) setHeading: 315) ; pepper
				(= ticks 10)
			)
			(3
				(gMessager say: 16 64 0 1 5 self) ; "Stand aside! General Pugh has sent me to question the prisoner!"
			)
			(4
				(sentry2
					view: 215
					setLoop: 4
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(5
				(gMessager say: 16 64 0 6 self) ; "Right! He'll be tellin' us he's the King himself before long! Ha ha ha!"
			)
			(6
				(sentry1
					view: 215
					setLoop: 5
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(7
				(gMessager say: 16 64 0 7 self) ; "You fools! I know the password! It's "Blooey"!"
			)
			(8
				(sentry1 setLoop: 1 setCycle: Beg self)
				(sentry2 setLoop: 0 setCycle: Beg self)
			)
			(9)
			(10
				(gMessager say: 16 64 0 8 10 self) ; "Yes sir! Royal Questioner, Sir! Go right in, Sir!"
			)
			(11
				(gLongSong fade:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sEnterFromAlley of Script
	(properties)

	(method (dispose)
		(gGame handsOn:)
		(gEgo normalize: setScale: 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(cond
					((and (!= gPrevRoomNum 601) (== gAct 1)) 0)
					((== gPrevRoomNum 601)
						(self dispose:)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(2
				(gEgo setMotion: MoveTo 234 96 self)
			)
			(3
				(gEgo setMotion: MoveTo 253 110 self)
			)
			(4
				(gEgo setScale: 0 normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterAlley of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: Scaler 100 81 104 97
					setLoop: 7
					setMotion: MoveTo 213 92 self
				)
			)
			(1
				(gLongSong fade:)
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance specialRevelers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 219 2)
				(gLongSong number: 952 setLoop: -1 play:)
				(= ticks 10)
			)
			(1
				(if register
					(gMessager say: 14 70 56 0 self) ; "Throcky, you might find this very interesting!"
				else
					(gMessager say: 13 70 0 1 2 self) ; "Marty, I think I could change your outlook on the whole world!"
				)
			)
			(2
				(if register
					(gMessager say: 13 70 0 1 2 self) ; "Marty, I think I could change your outlook on the whole world!"
				else
					(self cue:)
				)
			)
			(3
				(frisbeeGuy setCycle: Beg self)
				(reveler230 setCycle: Beg self)
			)
			(4)
			(5
				(gMessager say: 13 70 0 3 14 self) ; "Ben goes on to say that we should all stop dressing, acting and talking like ninnies! Hey, Throckmorton, are we ninnies?"
			)
			(6
				(reveler230
					view: 826
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 340 140 self
				)
				(frisbeeGuy
					view: 826
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 340 157 self
				)
			)
			(7)
			(8
				(gLongSong fade:)
				(gTheIconBar advanceCurIcon:)
				(reveler230 dispose:)
				(frisbeeGuy dispose:)
				(proc875_5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterAfterLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 23 0 10 0 self) ; "Go right in, your Questionhood! Take as much time as you need, sir!"
			)
			(1
				(gLongSong fade:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sayDoSentry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global215 81)
				(gMessager say: 17 7 0 1 self) ; "Here now, you little |r||c0|ragamuffin|c||r|, take your paws off me!"
			)
			(1
				(= global215 107)
				(gMessager say: 17 7 0 2 self) ; "Go on, you little |r||c0|wastrel|c||r|, get lost! We're guarding an important prisoner here, we are!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance reveler230 of Actor
	(properties
		x 355
		y 140
		noun 14
		approachX 207
		approachY 129
		view 826
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 6 84) ; Look, Trivia
			(if (IsFlag 217)
				(= temp0 111)
			else
				(= temp0 114)
			)
		)
		(switch theVerb
			(6 ; Look
				(gMessager say: 14 6 temp0)
			)
			(84 ; Trivia
				(= global215 49)
				(gMessager say: 14 84 temp0)
			)
			(85 ; Talk
				(switch gAct
					(4
						(gGame points: 449 1)
					)
					(5
						(gGame points: 450 1)
					)
				)
				(gCurRoom setScript: sTalkR2)
			)
			(141 ; ???
				(gCurRoom setScript: sGiveProverbRevelers)
			)
			(70 ; Special_Edition
				(gCurRoom setScript: specialRevelers)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frisbeeGuy of Actor
	(properties
		x 247
		y 157
		noun 13
		approachX 207
		approachY 129
		view 231
		signal 2048
		illegalBits 0
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 6 84) ; Look, Trivia
			(if (IsFlag 217)
				(= temp0 111)
			else
				(= temp0 114)
			)
		)
		(switch theVerb
			(6 ; Look
				(gMessager say: 13 6 temp0)
			)
			(84 ; Trivia
				(= global215 49)
				(gMessager say: 13 84 temp0)
			)
			(85 ; Talk
				(switch gAct
					(2
						(gGame points: 216 1)
					)
					(3
						(gGame points: 446 1)
					)
					(4
						(gGame points: 447 1)
					)
					(5
						(gGame points: 448 1)
					)
				)
				(gCurRoom setScript: sTalkR1)
			)
			((OneOf theVerb 137 143 135 140 138 139 136) ; ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 13 142 55) ; "Marty, would you mind taking a look at this for me?"
			)
			(141 ; ???
				(gCurRoom setScript: sGiveProverbRevelers)
			)
			(70 ; Special_Edition
				(self setScript: specialRevelers 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 139
		y 50
		noun 18
		view 210
		loop 1
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(7 ; Do
				(if (and (gCast contains: sentry1) (IsFlag 218))
					(gCurRoom setScript: enterAfterLetter)
				else
					(if (gCast contains: sentry1)
						(= temp0 69)
					else
						(= temp0 0)
					)
					(gMessager say: 18 7 temp0)
				)
			)
			(85 ; Talk
				(cond
					((and (gCast contains: sentry1) (IsFlag 218))
						(sentry2 doVerb: theVerb)
					)
					((gCast contains: sentry1)
						(gMessager say: 18 85 69) ; "Hello! Is there anybody in there?"
					)
					(else
						(gMessager say: 21 85) ; "Hello?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sentry2 of Actor
	(properties
		x 129
		y 135
		noun 16
		approachX 183
		approachY 138
		view 215
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; King_s_Letter
				(if (IsFlag 218)
					(gCurRoom setScript: enterAfterLetter)
				else
					(gCurRoom setScript: sGiveKingsLetter)
				)
			)
			(7 ; Do
				(if (IsFlag 218)
					(gCurRoom setScript: enterAfterLetter)
				else
					(= global215 99)
					(super doVerb: theVerb &rest)
				)
			)
			(85 ; Talk
				(if (IsFlag 218)
					(gCurRoom setScript: enterAfterLetter)
				else
					(gGame points: 451 1)
					(gLongSong number: 300 setLoop: -1 play:)
					(= local7 1)
					(sentry1 doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sentry1 of Actor
	(properties
		x 184
		y 114
		noun 17
		view 215
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(if (IsFlag 218)
					(gCurRoom setScript: enterAfterLetter)
				else
					(gGame points: 451 1)
					(gLongSong number: 300 setLoop: -1 play:)
					(= local7 1)
					(if local8
						(gMessager say: 16 85 68) ; "Shoo, little beggar, before I arrest you, too!"
					else
						(= local8 1)
						(gMessager say: 16 85 67) ; "Excuse me, sirs, but--"
					)
				)
			)
			(7 ; Do
				(if (IsFlag 218)
					(gCurRoom setScript: enterAfterLetter)
				else
					(gCurRoom setScript: sayDoSentry)
				)
			)
			(6 ; Look
				(super doVerb: theVerb)
			)
			(else
				(sentry2 doVerb: theVerb)
			)
		)
	)
)

(instance woodThing of View
	(properties
		x 38
		y 96
		view 210
		cel 2
		priority 5
		signal 26641
	)
)

(instance dipper of View ; UNUSED
	(properties
		x 116
		y 94
		noun 6
		approachX 142
		approachY 132
		view 210
		priority 5
		signal 26640
	)
)

(instance sentry2Talker of BalloonTalker
	(properties
		x 140
		y 90
		talkWidth 160
	)
)

(instance sentry1Talker of BalloonTalker
	(properties
		x 10
		y 80
		talkWidth 160
		tailPosn 1
	)
)

(instance reveler1Talker of BalloonTalker
	(properties
		x 90
		y 110
		talkWidth 150
		tailPosn 1
	)
)

(instance reveler2Talker of BalloonTalker
	(properties
		x 115
		y 95
		talkWidth 150
		tailPosn 1
	)
)

(instance alleyEnter of ExitFeature
	(properties
		nsTop 31
		nsLeft 206
		nsBottom 96
		nsRight 248
		cursor 911
		exitDir 4
		noun 1
	)
)

(instance barrel of Feature
	(properties
		x 274
		y 87
		noun 2
		nsTop 79
		nsLeft 266
		nsBottom 96
		nsRight 283
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gMessager say: 2 7 1) ; "That's one seriously huge old barrel."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alley of Feature
	(properties
		x 228
		y 54
		noun 1
		nsTop 33
		nsLeft 219
		nsBottom 76
		nsRight 238
		sightAngle 40
	)
)

(instance bigBuilding of Feature
	(properties
		x 258
		y 43
		noun 3
		nsTop 6
		nsLeft 242
		nsBottom 81
		nsRight 317
		sightAngle 40
	)
)

(instance bucket of Feature
	(properties
		x 122
		y 103
		noun 4
		nsTop 90
		nsLeft 111
		nsBottom 117
		nsRight 134
		sightAngle 40
		approachX 143
		approachY 132
	)
)

(instance crates of Feature
	(properties
		y 65
		noun 5
	)

	(method (doVerb theVerb)
		(= global215 48)
		(super doVerb: theVerb)
	)
)

(instance eastRoad of Feature
	(properties
		y 65
		noun 8
	)
)

(instance westRoad of Feature
	(properties
		y 65
		noun 26
	)
)

(instance hills of Feature
	(properties
		y 65
		noun 10
	)
)

(instance idiotSign of Feature
	(properties
		x 62
		y 65
		noun 11
		nsTop 58
		nsLeft 43
		nsBottom 73
		nsRight 81
		sightAngle 40
	)
)

(instance stocks of Feature
	(properties
		x 65
		y 114
		noun 24
		nsTop 93
		nsLeft 26
		nsBottom 136
		nsRight 105
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 84) ; Trivia
			(gLongSong2 number: 927 setLoop: 1 play:)
		)
		(super doVerb: theVerb)
	)
)

(instance shedDoor of Feature
	(properties
		x 153
		y 93
		noun 27
		nsTop 71
		nsLeft 142
		nsBottom 115
		nsRight 164
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 84) ; Trivia
			(gLongSong2 number: 927 setLoop: 1 play:)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance shedLock of Feature
	(properties
		x 164
		y 91
		noun 19
		nsTop 87
		nsLeft 158
		nsBottom 95
		nsRight 170
		sightAngle 40
	)
)

(instance shed of Feature
	(properties
		noun 20
	)
)

(instance shedWindow of Feature
	(properties
		x 190
		y 83
		noun 21
		nsTop 67
		nsLeft 174
		nsBottom 99
		nsRight 207
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= global215 8)
		(super doVerb: theVerb)
	)
)

(instance smallBuild of Feature
	(properties
		x 12
		y 81
		noun 22
		nsTop 58
		nsBottom 105
		nsRight 24
		sightAngle 40
	)
)

(instance eastEFeature of ExitFeature
	(properties
		nsTop 74
		nsLeft 311
		nsBottom 169
		nsRight 319
		cursor 913
		exitDir 2
		noun 8
	)
)

(instance westEFeature of ExitFeature
	(properties
		nsTop 119
		nsBottom 189
		nsRight 10
		cursor 911
		exitDir 4
		noun 26
	)
)

