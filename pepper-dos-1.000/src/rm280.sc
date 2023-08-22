;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use ExitFeature)
(use smell)
(use OccasionalCycle)
(use BalloonTalker)
(use ADRoom)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm280 0
	postal2Talker 3
	postal1Talker 8
)

(local
	[local0 2]
	local2 = 1
	local3 = 1
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
)

(instance rm280 of ADRoom
	(properties
		noun 18
		picture 280
		horizon 75
		vanishingY -60
		autoLoad 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 84) ; Trivia
			(gLongSong2 number: 927 setLoop: 1 play:)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(if (== gAct 0)
			(= gAct 2)
			(proc875_0)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 92 140 63 181 182 185 183 189 0 189 0 0 319 0 319 189 312 189 310 182 285 182 259 158 219 147 215 131 219 120 209 127 130 127 125 138
					yourself:
				)
		)
		(<<= local2 $0006)
		(<<= local3 $0007)
		(gEgo init: setScale: 0 normalize:)
		(if (IsFlag 170)
			(= local4 1)
		)
		(if (IsFlag 171)
			(= local5 1)
		)
		(switch gPrevRoomNum
			(291
				(gGame handsOff:)
				(= global114 0)
				(= picture 0)
				(if (== global195 7)
					(= local4 1)
				else
					(= local5 1)
				)
				(DrawPic 280 100 1)
				(gCurRoom setScript: sFinishConversation)
			)
			(116
				(= global114 0)
				(= picture 0)
				(DrawPic 280 100 1)
			)
			(else
				(= global114 1)
				(self setScript: sEnter)
			)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 106))
					(proc875_1 local2 global204)
					(proc875_1 local2 global206)
					(proc875_1 local2 global208)
				)
			)
			(SetFlag 130)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 107))
					(proc875_1 local3 global204)
					(proc875_1 local3 global206)
					(proc875_1 local3 global208)
				)
			)
			(SetFlag 131)
		)
		(super init: &rest)
		(if (or (> gAct 3) (IsFlag 283))
			(worker1 view: 286 setLoop: 0 x: 128 y: 127 setCycle: Fwd init:)
			(worker2
				view: 286
				setLoop: 1
				x: 164
				y: 91
				approachVerbs: 70 143 ; Special_Edition, ???
				setCycle: Fwd
				init:
			)
			(if (not (== gPrevRoomNum 291))
				(gLongSong number: 281 setLoop: -1 play:)
			)
		else
			(worker1 init: setCycle: OccasionalCycle self 1 10 200)
			(worker2 init: setCycle: OccasionalCycle self 1 10 200)
			(if (not (== gPrevRoomNum 291))
				(gLongSong number: 280 setLoop: -1 play:)
			)
		)
		(if (and (== gAct 2) (not (IsFlag 285)))
			(bensPackage approachVerbs: 7 init:) ; Do
		else
			(chalkBoard init: addToPic:)
		)
		(counterTop init: setOnMeCheck: 1 16384)
		(lamps init: setOnMeCheck: 1 8192)
		(mailSacks init: setOnMeCheck: 1 4096)
		(notice1 init:)
		(notice2 init:)
		(notice3 init:)
		(notice4 init:)
		(bigFrontBox init: setOnMeCheck: 1 2)
		(package2 init: setOnMeCheck: 1 2048)
		(mailSlots init:)
		(plaques init:)
		(portrait init:)
		(stackOMail init:)
		(leWindow init: setOnMeCheck: 1 4)
		(southEFeature init:)
		(if (OneOf gPrevRoomNum 116 291)
			(self curPic: 280 picture: 280)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gCurRoom setScript: sExit)
			)
		)
	)

	(method (dispose)
		(if (not (== gNewRoomNum 291))
			(ClearFlag 170)
			(ClearFlag 171)
		)
		(super dispose:)
	)
)

(instance mailQuiz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local9 0)
				(if (IsFlag 280)
					(gMessager say: 1 7 52 0 self) ; "C'mon, guys, let me try again! Give me a break, I'm stressed out over losing my dog."
				else
					(gMessager say: 1 7 13 0 self) ; "Hmm, a package for Ben Franklin!"
				)
			)
			(1
				(gGame points: 280 1)
				(if (== local7 1)
					(= local11 local6)
				else
					(= local12 local6)
				)
				(= cycles 1)
			)
			(2
				(= local6 (Random 1 9))
				(if (or (== local11 local6) (== local12 local6))
					(-- state)
					(self cue:)
				else
					(switch local6
						(1
							(= local10 22)
							(gMessager say: 19 0 22 0 self) ; "Was Ben born on Milk Street in Boston?"
						)
						(2
							(= local10 23)
							(gMessager say: 19 0 23 0 self) ; "Answer true or false, kid: Was Ben the oldest child in his family?"
						)
						(3
							(= local10 132)
							(gMessager say: 19 0 132 0 self) ; "Ben really loved the soap-making business, right, kid?"
						)
						(4
							(= local10 32)
							(gMessager say: 19 0 32 0 self) ; "Silence Dogood is Ben's cousin. True or false, kiddo?"
						)
						(5
							(= local10 33)
							(gMessager say: 19 0 33 0 self) ; "Ben ran away to Philadelphia when he was seventeen, right?"
						)
						(6
							(= local10 34)
							(gMessager say: 19 0 34 0 self) ; "The Leather Apron Club was a bunch of guys who worked with leather, right, kiddo?"
						)
						(7
							(= local10 35)
							(gMessager say: 19 0 35 0 self) ; "Answer true or false, lad: The King of France once sent Ben a letter of congratulations for his electricity experiments."
						)
						(8
							(= local10 48)
							(gMessager say: 19 0 48 0 self) ; "Is Ben planning on going to England this year, kid?"
						)
						(9
							(= local10 49)
							(gMessager say: 19 0 49 0 self) ; "Ben met Deborah when he was just a boy in Boston. True or false, lad?"
						)
					)
				)
			)
			(3
				(gGame setCursor: 999 1)
				(trueFalseCode doit:)
			)
			(4
				(gGame setCursor: gWaitCursor 1)
				(switch local6
					(1
						(if (not (== local8 1))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
					(2
						(if (not (== local8 0))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
					(3
						(if (not (== local8 0))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
					(4
						(if (not (== local8 0))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
					(5
						(if (not (== local8 1))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
					(6
						(if (not (== local8 0))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
					(7
						(if (not (== local8 1))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
					(8
						(if (not (== local8 1))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
					(9
						(if (not (== local8 0))
							(= local9 1)
							(= cycles 1)
						else
							(self cue:)
						)
					)
				)
			)
			(5
				(cond
					(local9
						(= local7 0)
						(gMessager say: 19 0 50 0 self) ; "Hey, you don't know a THING about Ben! You can't have this package! Now excuse me. I have to catch up on my sleep."
					)
					((== local7 2)
						(self cue:)
					)
					(else
						(++ local7)
						(= state 0)
						(self cue:)
					)
				)
			)
			(6
				(if local9
					(gGame handsOn:)
					(self dispose:)
				else
					(gMessager say: 19 0 51 0 self) ; "Hmm, I guess you are a friend of Ben's after all."
				)
			)
			(7
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
			)
			(8
				(gGame points: 485 1)
				(bensPackage dispose:)
				(chalkBoard init: addToPic:)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(9
				(gEgo normalize: get: 9) ; Package
				(gGame points: 285 1 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 237 y: 247 setMotion: MoveTo 221 183 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 240 257 self)
			)
			(1
				(gLongSong fade:)
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sFinishConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(worker1 setCycle: 0 stopUpd:)
				(worker2 setCycle: 0 stopUpd:)
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(2
				(switch global116
					(39
						(= global215 52)
					)
					(16
						(= global215 57)
					)
				)
				(if (and global115 global116)
					(gMessager say: global115 85 global116 0 self global196)
				else
					(= cycles 1)
				)
			)
			(3
				(gGame handsOn:)
				(if (IsFlag 283)
					(worker1 setCycle: Fwd)
					(worker2 setCycle: Fwd)
				else
					(worker2 setCycle: OccasionalCycle self 1 10 200)
					(worker1 setCycle: OccasionalCycle self 1 10 200)
				)
				(self dispose:)
			)
		)
	)
)

(instance sGivePostalProverb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 283 2)
				((ScriptID 895 0) setMotion: PolyPath 187 127 self) ; pepper
			)
			(1
				(gEgo put: 44) ; Wood_Cutting_c
				(if (and (not (gEgo has: 22)) (not (gEgo has: 43))) ; Wood_Cutting_a, Wood_Cutting_b
					(SetFlag 87)
				)
				(= global215 106)
				(gMessager say: 16 143 0 1 5 self) ; "Hey, Billy, I've got something for you."
			)
			(2
				(= global215 57)
				(gMessager say: 16 143 0 6 8 self) ; "Now what does that mean? I'm not slothful, am I? I'm... Yikes. Oh, man, I really have been a sluggard. I'm so ashamed of myself!"
			)
			(3
				(gMessager say: 16 143 0 9 13 self) ; "Yeah, clean it up!"
			)
			(4
				(worker1 view: 286 setLoop: 0 x: 128 y: 127 setCycle: Fwd)
				(worker2 view: 286 setLoop: 1 x: 164 y: 91 setCycle: Fwd)
				(gLongSong number: 281 setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkBillyIdle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(and
						(not (IsFlag 106))
						(not (IsFlag 118))
						(proc875_1 local2 global204)
						(proc875_1 local2 global206)
						(proc875_1 local2 global208)
						(proc875_1 local2 global205)
						(proc875_1 local2 global207)
						(proc875_1 local2 global209)
					)
					(SetFlag 130)
				)
				(switch gAct
					(2
						(gGame points: 278 1)
					)
					(3
						(gGame points: 479 1)
					)
					(4
						(gGame points: 480 1)
					)
					(5
						(gGame points: 481 1)
					)
				)
				(worker1 setCycle: 0 stopUpd:)
				(worker2 setCycle: 0 stopUpd:)
				(= cycles 2)
			)
			(1
				(if (IsFlag 130)
					(switch gAct
						(2
							(= temp0 43)
						)
						(3
							(if (IsFlag 283)
								(= temp0 1)
							else
								(= temp0 44)
							)
						)
						(4
							(= temp0 45)
						)
						(5
							(if (IsFlag 284)
								(= temp0 47)
							else
								(= temp0 46)
							)
						)
					)
					(gMessager say: 16 85 temp0 0 self)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((IsFlag 130)
						(self dispose:)
					)
					((not local4)
						(switch gAct
							(2
								(= temp0 38)
							)
							(3
								(= temp0 39)
							)
							(4
								(= temp0 40)
							)
							(5
								(= temp0 41)
							)
						)
						(gMessager say: 16 85 temp0 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(= global195 7)
				(SetFlag 170)
				(gCurRoom newRoom: 291)
				(self dispose:)
			)
		)
	)
)

(instance sayT1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global215 52)
				(gMessager say: 17 85 39 1 self) ; "It's Hidel, my favorite |r||c0|inanimate|c||r| object! Just kidding, bud."
			)
			(1
				(gMessager say: 17 85 39 2 6 self) ; "Hmmph!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sTalkHidelIdle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(and
						(not (IsFlag 107))
						(not (IsFlag 119))
						(proc875_1 local3 global204)
						(proc875_1 local3 global206)
						(proc875_1 local3 global208)
						(proc875_1 local3 global205)
						(proc875_1 local3 global207)
						(proc875_1 local3 global209)
					)
					(SetFlag 131)
				)
				(switch gAct
					(2
						(gGame points: 279 1)
					)
					(3
						(gGame points: 482 1)
					)
					(4
						(gGame points: 483 1)
					)
					(5
						(gGame points: 484 1)
					)
				)
				(worker1 setCycle: 0 stopUpd:)
				(worker2 setCycle: 0 stopUpd:)
				(= cycles 2)
			)
			(1
				(if (IsFlag 131)
					(switch gAct
						(2
							(= temp0 43)
						)
						(3
							(if (IsFlag 283)
								(= temp0 1)
							else
								(= temp0 44)
							)
						)
						(4
							(= temp0 46)
						)
						(5
							(if (IsFlag 284)
								(= temp0 47)
							else
								(= temp0 46)
							)
						)
					)
					(gMessager say: 17 85 temp0 0 self)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((IsFlag 131)
						(self dispose:)
					)
					((not local5)
						(switch gAct
							(2
								(= temp0 38)
							)
							(3
								(= global215 52)
								(self setScript: sayT1 self)
							)
							(4
								(= temp0 40)
							)
							(5
								(= temp0 41)
							)
						)
						(if (not (== gAct 3))
							(gMessager say: 17 85 temp0 0 self)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(= global195 8)
				(SetFlag 171)
				(gCurRoom newRoom: 291)
				(self dispose:)
			)
		)
	)
)

(instance giveSped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 952 setLoop: -1 play:)
				((ScriptID 895 0) setMotion: PolyPath 187 127 self) ; pepper
			)
			(1
				(gMessager say: 16 70 0 0 self) ; "Here, Billy, you might find this interesting. Ben wrote it himself!"
			)
			(2
				(gGame points: 284 2)
				(gLongSong fade:)
				(proc875_5)
				(gCurRoom setScript: sExit)
			)
		)
	)
)

(instance worker2 of Prop
	(properties
		x 170
		y 88
		noun 16
		approachX 165
		approachY 137
		view 283
		loop 3
		signal 18448
	)

	(method (cue)
		(super cue: &rest)
		(if (IsFlag 283)
			(worker1 setCycle: Fwd)
			(worker2 setCycle: Fwd)
		else
			(worker2 setCycle: OccasionalCycle self 1 10 200)
			(worker1 setCycle: OccasionalCycle self 1 10 200)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 283)
					(gMessager say: 16 7 1 0 self) ; "Don't slow me down, little dude! I've gotta zoom, gotta zoom!"
				else
					(gMessager say: 16 7 42 0 self) ; "Do you mind? I'm trying to take a nap!"
				)
			)
			(6 ; Look
				(if (IsFlag 283)
					(gMessager say: 16 6 1 0 self) ; "Billy has more energy than a nuclear power plant!"
				else
					(gMessager say: 16 6 42 0 self) ; "Oh, man, for a second I thought that guy was dead or something!"
				)
			)
			(85 ; Talk
				(if (and (< gAct 4) (IsFlag 283))
					(gMessager say: 16 85 1 0 self) ; "You know, Billy--"
				else
					(gCurRoom setScript: sTalkBillyIdle)
				)
			)
			((OneOf theVerb 137 135 141 140 138 139 136) ; ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 16 127 0 0 self) ; "Here, Billy, check this out!"
			)
			(143 ; ???
				(gCurRoom setScript: sGivePostalProverb)
			)
			(70 ; Special_Edition
				(gCurRoom setScript: giveSped)
			)
			(84 ; Trivia
				(gMessager say: 16 84) ; "TRUE. There were postal clerks in colonial America. There were also postal carriers, but their job was a lot harder then than it is now. They had to deliver all the mail on foot or on horseback!"
			)
			((OneOf theVerb 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
				(super doVerb: theVerb)
			)
			(else
				(if (IsFlag 283)
					(gMessager say: 16 88 1) ; "No thanks, kid! That won't help me sort the mail any faster!"
				else
					(gMessager say: 16 88 42) ; "<Yawn.> No thanks, kid."
				)
			)
		)
	)
)

(instance worker1 of Prop
	(properties
		x 106
		y 86
		noun 17
		approachX 129
		approachY 130
		view 283
		loop 4
		cel 5
		signal 18448
	)

	(method (cue)
		(super cue: &rest)
		(if (IsFlag 283)
			(worker1 setCycle: Fwd)
			(worker2 setCycle: Fwd)
		else
			(worker2 setCycle: OccasionalCycle self 1 10 200)
			(worker1 setCycle: OccasionalCycle self 1 10 200)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 283)
					(gMessager say: 17 7 1 0 self) ; "Leggo, dude!"
				else
					(gMessager say: 17 7 42 0 self) ; "...Leggo...<zzzz>"
				)
			)
			(6 ; Look
				(if (IsFlag 283)
					(gMessager say: 17 6 1 0 self) ; "Hidel's moving fast! WAY fast!"
				else
					(gMessager say: 17 6 42 0 self) ; "Is that a carrot, or a man?"
				)
			)
			(85 ; Talk
				(if (and (< gAct 4) (IsFlag 283))
					(gMessager say: 17 85 1 0 self) ; "Go 'way!"
				else
					(gCurRoom setScript: sTalkHidelIdle)
				)
			)
			(84 ; Trivia
				(gMessager say: 16 84) ; "TRUE. There were postal clerks in colonial America. There were also postal carriers, but their job was a lot harder then than it is now. They had to deliver all the mail on foot or on horseback!"
			)
			((OneOf theVerb 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
				(super doVerb: theVerb)
			)
			(else
				(if (IsFlag 283)
					(gMessager say: 17 88 1) ; "No thanks!"
				else
					(gMessager say: 17 88 42) ; "...<zzzzzz>..."
				)
			)
		)
	)
)

(instance chalkBoard of View
	(properties
		x 50
		y 96
		view 280
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bensPackage of View
	(properties
		x 51
		y 97
		noun 1
		approachX 102
		approachY 140
		view 280
		signal 26624
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: mailQuiz)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance counterTop of Feature
	(properties
		y 70
		noun 2
	)
)

(instance lamps of Feature
	(properties
		y 10
		noun 4
	)
)

(instance mailSacks of Feature
	(properties
		y 150
		noun 5
	)
)

(instance notice1 of Feature
	(properties
		x 51
		y 48
		noun 6
		nsTop 36
		nsLeft 40
		nsBottom 60
		nsRight 63
		sightAngle 40
	)
)

(instance notice2 of Feature
	(properties
		x 92
		y 48
		noun 7
		nsTop 39
		nsLeft 83
		nsBottom 57
		nsRight 102
		sightAngle 40
	)
)

(instance notice3 of Feature
	(properties
		x 203
		y 54
		noun 8
		nsTop 46
		nsLeft 194
		nsBottom 62
		nsRight 212
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= global215 36)
		(super doVerb: theVerb)
	)
)

(instance notice4 of Feature
	(properties
		x 217
		y 70
		noun 9
		nsTop 64
		nsLeft 211
		nsBottom 77
		nsRight 223
		sightAngle 40
	)
)

(instance bigFrontBox of Feature
	(properties
		x 134
		y 158
		noun 10
		nsTop 128
		nsLeft 89
		nsBottom 189
		nsRight 180
	)
)

(instance package2 of Feature
	(properties
		y 180
		noun 12
	)

	(method (doVerb theVerb)
		(= global215 20)
		(super doVerb: theVerb)
	)
)

(instance mailSlots of Feature
	(properties
		x 147
		y 55
		noun 13
		nsTop 33
		nsLeft 105
		nsBottom 78
		nsRight 190
	)
)

(instance plaques of Feature
	(properties
		x 203
		y 70
		noun 14
		nsTop 63
		nsLeft 196
		nsBottom 77
		nsRight 211
		sightAngle 40
	)
)

(instance portrait of Feature
	(properties
		x 12
		y 51
		noun 15
		nsTop 28
		nsBottom 74
		nsRight 25
		sightAngle 40
	)
)

(instance stackOMail of Feature
	(properties
		x 34
		y 73
		noun 20
		nsTop 43
		nsLeft 25
		nsBottom 103
		nsRight 47
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leWindow of Feature
	(properties
		x 286
		y 62
		noun 21
		nsTop 23
		nsLeft 254
		nsBottom 102
		nsRight 319
	)
)

(instance southEFeature of ExitFeature
	(properties
		nsTop 179
		nsLeft 177
		nsBottom 189
		nsRight 319
		cursor 910
		exitDir 3
		noun 22
	)
)

(instance postal1Talker of BalloonTalker
	(properties
		x 158
		y 78
		talkWidth 130
		tailPosn 3
	)

	(method (say)
		(worker1 setCycle: 0 stopUpd:)
		(worker2 setCycle: 0 stopUpd:)
		(gEgo stopUpd:)
		(super say: &rest)
	)
)

(instance postal2Talker of BalloonTalker
	(properties
		x 122
		y 60
		talkWidth 130
	)

	(method (say)
		(worker1 setCycle: 0 stopUpd:)
		(worker2 setCycle: 0 stopUpd:)
		(gEgo stopUpd:)
		(super say: &rest)
	)
)

(instance trueFalseCode of Code
	(properties)

	(method (doit)
		(= local8
			(Print
				posn: 70 70
				font: 4
				addText: 19 0 local10 1 0 0
				addButton: 1 19 0 53 0 0 50 ; "TRUE"
				addButton: 0 19 0 54 0 70 50 ; "FALSE"
				init:
			)
		)
		(mailQuiz cue:)
	)
)

