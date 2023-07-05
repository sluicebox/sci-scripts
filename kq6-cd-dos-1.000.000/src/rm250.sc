;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use walkEgoInScr)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	local0 = -1
	[local1 2]
	local3
	local4
)

(procedure (localproc_0)
	(return (== (beauty script:) roseTendingScr))
)

(procedure (localproc_1)
	(return
		(if (localproc_0)
			(if (IsFlag 37) 10 else 12)
		else
			11
		)
	)
)

(instance rm250 of KQ6Room
	(properties
		noun 3
		picture 250
		horizon 0
		east 240
		south 240
		west 260
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 369 -60 369 169 319 169 65 110 0 110 0 -60
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: -40 125 40 125 201 189 201 229 -40 229
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 161 84 162 103 186 176 186 176 189 0 189
					yourself:
				)
		)
		(gEgo init: setScale: Scaler 100 67 153 109)
		(super init: &rest)
		(if (== gPrevRoomNum 260)
			(proc12_1 8 116)
		else
			(proc12_1 272 187 -50)
		)
		(houseDoor init:)
		(gate init:)
		(genericFeatures init:)
		(houseRoses init:)
		(palmTrees init:)
		(featureToBeIgnored init:)
		((ScriptID 10 4) onMeCheck: 8 init:) ; rocks
		(leaves init:)
		(if (>= (gGame _detailLevel:) 2)
			(leaves setScript: (ScriptID 13 0)) ; windScr
		)
		(cond
			((and (gEgo has: 37) (not (IsFlag 43))) ; ring
				(beauty init: 1)
			)
			(
				(and
					(!= global154 gAct)
					(<= global155 3)
					(not (IsFlag 43))
				)
				(beauty
					init: 0
					setScript:
						(if (OneOf (++ global155) 3 4)
							rmAct3and4Scr
						else
							rmAct1and2Scr
						)
				)
			)
		)
		(gGlobalSound number: 250 loop: -1 play:)
	)

	(method (edgeToRoom param1 &tmp temp0)
		(= temp0 1)
		(switch param1
			(3
				(proc12_0 param1 -50)
				(return 0)
			)
			(2
				(proc12_0 3 -50)
				(return 0)
			)
			(4
				(proc12_0 param1)
				(return 0)
			)
			(else
				(= temp0 0)
				(super edgeToRoom: param1 &rest)
			)
		)
		(return
			(if temp0
				(beauty setScript: 0)
				(gGlobalSound fade:)
			)
		)
	)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 1) ; Look
				(gMessager say: noun theVerb (if (< gAct 5) 26 else 27))
				1
			else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(= global154 gAct)
		(ClearFlag 59)
		(super dispose: &rest)
		(DisposeScript 964)
		(DisposeScript 13)
	)

	(method (scriptCheck param1 &tmp temp0 temp1)
		(= temp0 0)
		(switch param1
			(87
				(if (gCast contains: beauty)
					(gMessager say: 0 0 2 0 0 899) ; "Alexander doesn't know what that potion might do! He doesn't want to frighten the young girl, and there's no one else here who might be impressed with the results!"
				else
					(= temp0 1)
				)
			)
			(85
				(cond
					((and (= temp1 (gCast contains: beauty)) (localproc_0))
						(CueObj state: 0 cycles: 0 client: beauty theVerb: 31)
						(gEgo
							setMotion:
								PolyPath
								(beauty approachX:)
								(beauty approachY:)
								CueObj
						)
					)
					(temp1
						(beauty doVerb: 31 &rest)
					)
					(else
						(= temp0 1)
					)
				)
			)
			(93
				(if (gCast contains: beauty)
					(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
				else
					(= temp0 1)
				)
			)
			(else
				(= temp0 1)
			)
		)
		(return temp0)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance rmAct1and2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 59)
				(client
					view: 253
					loop: 2
					cel: 0
					posn: 213 81
					setCycle: End self
				)
			)
			(1
				(client loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(client cel: 0 posn: 202 88 setCycle: End self)
			)
			(3
				(client cel: 0 posn: 194 94 setCycle: End self)
			)
			(4
				(client loop: 4 cel: 0 posn: 191 96 setCycle: End self)
			)
			(5
				(= seconds (= register (Random 1 9)))
			)
			(6
				(client loop: 5 cel: 0 posn: 174 97 setCycle: End self)
			)
			(7
				(client loop: 6 cel: 0)
				(= seconds (- 10 register))
			)
			(8
				(houseDoor noun: 23 view: 255 loop: 0 cel: 0 setCycle: End self)
				(gGlobalSound4 number: 901 loop: 1 play:)
			)
			(9
				(= ticks 12)
			)
			(10
				(houseDoor loop: 1 cel: 0 setCycle: End self)
			)
			(11
				(= cycles 2)
			)
			(12
				(houseDoor loop: 2 cel: 0)
				(= cycles 2)
			)
			(13
				(if (== global155 1)
					(= register 4)
				else
					(= register 5)
				)
				(gMessager say: 1 0 register 1 self)
			)
			(14
				(gMessager say: 1 0 register 2 self)
			)
			(15
				(if (!= register 4)
					(houseDoor setCycle: End self)
				else
					(++ state)
					(= ticks 1)
				)
			)
			(16
				(= cycles 2)
			)
			(17
				(gMessager say: 1 0 register 3 self)
			)
			(18
				(if (== register 4)
					(houseDoor setCycle: End self)
				else
					(++ state)
					(= ticks 1)
				)
			)
			(19
				(= cycles 2)
			)
			(20
				(gMessager say: 1 0 register 4 self)
			)
			(21
				(if (!= register 4)
					(= cycles 1)
				else
					(gMessager say: 1 0 register 5 self)
				)
			)
			(22
				(client setScript: rmEndofScriptsScr)
			)
		)
	)
)

(instance rmAct3and4Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 59)
				(client view: 253 loop: 4 cel: 7 posn: 191 96)
				(= cycles 1)
			)
			(1
				(= seconds (= register (Random 1 9)))
			)
			(2
				(client loop: 5 cel: 0 posn: 174 97 setCycle: End self)
			)
			(3
				(client loop: 6 cel: 0)
				(= seconds (- 10 register))
			)
			(4
				(houseDoor noun: 23 view: 255 loop: 0 cel: 0 setCycle: End self)
				(gGlobalSound4 number: 901 loop: 1 play:)
			)
			(5
				(= cycles 2)
			)
			(6
				(if (== global155 3)
					(= register 6)
					(houseDoor loop: 1 cel: 0 setCycle: End self)
				else
					(= register 7)
					(+= state 2)
					(= ticks 1)
				)
			)
			(7
				(= cycles 2)
			)
			(8
				(houseDoor loop: 2 cel: 0)
				(= cycles 2)
			)
			(9
				(gMessager say: 1 0 register 0 self)
			)
			(10
				(client setScript: rmEndofScriptsScr)
			)
		)
	)
)

(instance rmGiveRoseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 38 gCurRoomNum) ; rose
				(gGame handsOff:)
				((ScriptID 10 0) setIt: 128) ; rgCrown
				(if (SetFlag 37)
					(= register 20)
				else
					(= register 19)
					(gGame givePoints: 2)
					(ClearFlag 47)
				)
				(beauty setScript: 0)
				(gMessager say: 6 71 register 1 self)
			)
			(1
				(if (== register 19)
					(gMessager say: 6 71 register 2 self) ; "Alexander can see the conflict in the girl's pretty face as she fights between her distrust of him and her desire for the white rose. The rose wins."
				else
					(self cue:)
				)
			)
			(2
				(gEgo
					setSpeed: 6
					view: 251
					loop: 0
					cel: 0
					posn: 250 154
					normal: 0
					setCycle: CT 4 1 self
				)
			)
			(3
				(beauty view: 251 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(beauty setCycle: End self)
				(gEgo cel: 5)
			)
			(5
				(gEgo
					reset: 0
					setSpeed: 6
					posn: (beauty approachX:) (beauty approachY:)
				)
				(= seconds 2)
			)
			(6
				(beauty loop: 2 cel: 0 setCycle: End self)
			)
			(7
				(gMessager
					say: 6 71 register (if (== register 19) 3 else 2) self
					oneOnly: 0
				)
			)
			(8
				(beauty setScript: roseTendingScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roseTendingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 251 loop: 4 cel: 0)
				(= cycles 1)
			)
			(1
				(= seconds (Random 2 5))
			)
			(2
				(client setCycle: End self)
			)
			(3
				(= seconds (Random 2 5))
			)
			(4
				(client setCycle: Beg self)
			)
			(5
				(= state 0)
				(= cycles 1)
			)
		)
	)
)

(instance turnScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(= register 1)
				(gEgo setHeading: register self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rmGiveRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 37) ; ring
				(gGame handsOff:)
				(gGame givePoints: 2)
				(beauty
					setScript: 0
					setPri: 2
					view: 252
					posn: 290 158
					setHeading: 270 self
				)
				(= register 0)
			)
			(1
				(roomConv
					add: -1 6 69 10 1 ; "Alexander has a thought about the serving girl. He decides to bring up the subject of Beast with her."
					add: -1 6 69 10 2 ; "Let me tell you about the place where the white roses grow. The Isle of the Beast is an enchanted place. There's a path running through a deep forest. The path crosses three magic blockades, set to keep all visitors away. At the center lives a tremendous beast."
					add: -1 6 69 10 3 ; "(VERY INTERESTED) Really? Magic blockades? How exciting! What kind of a beast? Is it very terrifying and ferocious?"
					add: -1 6 69 10 4 ; "It is a beast that walks on two legs and dresses like a prince. It speaks with the voice of a man."
					add: -1 6 69 10 5 ; "A beast that talks and wears clothes? How is that possible? Is the beast magic, too?"
					add: -1 6 69 10 6 ; "Not magical--enchanted. Beast was once a prince, but a witch trapped him in the form of a beast and set him on the island. There he lives in a castle in the midst of a maze."
					add: -1 6 69 10 7 ; "How terrible! Imagine how lonely he must be!"
					add: -1 6 69 10 8 ; "It IS a very lonely prospect, isn't it? <sigh> I have met him, you see. He is indeed ferocious, but who would not be?"
					add: -1 6 69 10 9 ; "He really exists? How it breaks my heart! If I could, I would tend to such a beast. Such a beast might find comfort in a kind face--do you not think it so?"
					add: -1 6 69 10 10 ; "(VERY MUCH MOVED BY BEAUTY'S COMPASSION) Oh, I think it so. I very much think it so. You would not be afraid of him?"
					add: -1 6 69 10 11 ; "Afraid? Maybe at first.... But how silly of me to speak so! The roses in this little yard are the only magic I will ever see."
					add: -1 6 69 10 12 ; "I could take you there. In fact, I would owe you my life if you would go--if you truly wish to go."
					add: -1 6 69 10 13 ; "You are serious? I could leave here? I have always dreamt of leaving, but to actually go.... This is the only home I have ever known."
					add: -1 6 69 10 14 ; "(KIND, BUT BLUNT) Home IS a hard place to leave--even if you're unhappy there."
					add: -1 6 69 10 15 ; "(BLUSHING) But I WILL go. If I can help him, I must go!"
					init: self
				)
			)
			(2
				(beauty view: 252 setCycle: Walk setMotion: MoveTo 147 122 self)
				(self setScript: turnScr 0 90)
				(gEgo setMotion: MoveTo 121 154 turnScr)
			)
			(3
				(beauty hide:)
				(gGlobalSound4 number: 906 loop: 1 play:)
				(gate view: 253 loop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(4
				(gate setCycle: End)
				(beauty
					show:
					setPri: -1
					posn: 110 131
					setMotion: MoveTo 159 158 self
				)
			)
			(5
				(if (not (turnScr register:))
					(turnScr caller: self)
				else
					(= cycles 2)
				)
			)
			(6
				(beauty loop: 1)
				(gEgo loop: 0)
				(= cycles 2)
			)
			(7
				(roomConv
					add: -1 6 69 10 16 ; "(DOUBTFUL) Is there nothing you wish to take with you?"
					add: -1 6 69 10 17 ; "(SADLY) There is nothing."
					add: -1 6 69 10 18 ; "Then take this ring. It is his. He will be pleased if you would wear it."
					init: self
				)
			)
			(8
				(gEgo
					normal: 0
					setSpeed: 6
					view: 253
					loop: 10
					posn: 127 157
					setCycle: CT 4 1 self
				)
			)
			(9
				(beauty
					view: 253
					loop: 0
					cel: 0
					posn: 158 157
					setCycle: CT 3 1 self
				)
			)
			(10
				(beauty setCycle: End self)
				(gEgo setCycle: End self)
			)
			(11 0)
			(12
				(gMessager say: 6 69 10 19 self) ; "Why, it's the most beautiful thing I have ever seen! Thank you kindly, sir."
			)
			(13
				(beauty
					view: 252
					setCycle: Walk
					cycleSpeed: 5
					moveSpeed: 5
					setMotion: MoveTo 320 180
				)
				(gEgo
					reset: 0
					posn: 121 154
					setSpeed: 9
					setMotion: MoveTo 300 190 self
				)
				(= ticks 60)
			)
			(14
				(houseDoor view: 255 loop: 2 cel: 0 setCycle: End self)
			)
			(15
				(gMessager say: 6 69 10 20 self) ; "Beauty! Where do you think YOU'RE going?"
			)
			(16
				(= cycles 10)
			)
			(17
				(gMessager say: 6 69 10 21 self) ; "To a place where roses grow--and to someone who truly needs me."
			)
			(18
				(gGlobalSound fade:)
				(gCurRoom newRoom: 540)
			)
		)
	)
)

(instance rmEndofScriptsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(houseDoor
					noun: 19
					view: 255
					loop: 0
					cel: (houseDoor lastCel:)
					setCycle: Beg houseDoor
				)
				(client posn: 174 97 loop: 7 cel: 0 setCycle: End self)
			)
			(1
				(client
					setLoop: 8
					posn: 189 85
					setCycle: Walk
					setMotion: MoveTo 216 66 self
				)
			)
			(2
				(houseDoor setCycle: End self)
				(gGlobalSound4 number: 901 loop: 1 play:)
			)
			(3
				(client setLoop: -1 loop: 9 cel: 0 setCycle: End self)
			)
			(4
				(houseDoor setCycle: Beg self)
			)
			(5
				(gGlobalSound4 number: 902 loop: 1 play:)
				(ClearFlag 59)
				(client dispose:)
			)
		)
	)
)

(instance useFluteOnBeautyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (localproc_1))
				(if (!= register 11)
					(++ state)
				)
				(= cycles 2)
			)
			(1
				(self setScript: (ScriptID 85) self) ; playTheFlute
			)
			(2
				(switch register
					(11
						(gMessager say: 1 31 0 0 self 0) ; "Alexander plays a lovely little tune on the flute."
					)
					(10
						(gMessager say: 6 31 12 1 self) ; "Would you like me to play the flute for you?"
					)
					(else
						(++ state)
						(gMessager say: 6 31 register 0 self)
					)
				)
			)
			(3
				(gMessager
					say: (if (== register 10) 6 else 2) 31 register 0 self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveAllScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (localproc_1))
				(gMessager
					say: 6 0 (if (== register 12) 10 else register) 1 self
				)
			)
			(1
				(if (!= register 11)
					(gMessager
						say: 6 0 register (if (== register 12) 1 else 2) self
					)
				else
					(= cycles 2)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scriptToBeIgnored of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client view: 255 loop: 0 cel: 0)
				(= cycles 2)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= cycles 2)
			)
			(3
				(client view: 257 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(= cycles 2)
			)
			(5
				(client loop: 1 cel: 0 setCycle: Fwd)
				(= ticks 300)
			)
			(6
				(client loop: 0 cel: 10 setCycle: Beg self)
			)
			(7
				(= cycles 2)
			)
			(8
				(client view: 255 loop: 0 cel: 3 setCycle: Beg self)
			)
			(9
				(client view: 250 loop: 1 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance beauty of Actor
	(properties
		x 214
		y 81
		noun 6
		sightAngle 45
		view 252
		signal 20480
	)

	(method (doVerb theVerb)
		(cond
			((and (OneOf theVerb 42 27 28 7 32 12 65 33) (localproc_0)) ; boringBook, riddleBook, spellBook, deadMansCoin, poem, map, note, ribbon
				(gMessager say: noun theVerb 18)
			)
			((and (OneOf theVerb 57 58 59 60 96 43 56) (localproc_0)) ; fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, fakeLamp1, huntersLamp, fakeLamp5
				(gMessager say: noun 43 (if (IsFlag 37) 10 else 12))
			)
			((and (OneOf theVerb 66 70) (localproc_0)) ; pearl, royalRing
				(gMessager say: noun 66 (if (IsFlag 37) 10 else 12))
			)
			((== theVerb 31) ; flute
				(gCurRoom setScript: useFluteOnBeautyScr)
			)
			((and (OneOf theVerb 74 73 55) (localproc_0)) ; ???, ???, ???
				(gMessager say: noun 55 18) ; MISSING MESSAGE
			)
			((and (== theVerb 71) (localproc_0)) ; rose
				(gCurRoom setScript: rmGiveRoseScr)
			)
			((== theVerb 69) ; ring
				(if (IsFlag 37)
					(gCurRoom setScript: rmGiveRingScr)
				else
					(gMessager say: noun theVerb 12) ; "(FRIENDLY) Excuse me, maid, but I have someone I'd like to tell you about...."
				)
			)
			((== theVerb 2) ; Talk
				(gMessager
					say:
						noun
						theVerb
						(if (localproc_0)
							(cond
								((IsFlag 37)
									(+
										22
										(if (< local0 3)
											(++ local0)
										else
											local0
										)
									)
								)
								((IsFlag 47) 14)
								(else 13)
							)
						else
							11
						)
				)
				(SetFlag 47)
			)
			((== theVerb 1) ; Look
				(gMessager
					say:
						noun
						theVerb
						(if (SetFlag 70)
							(if (IsFlag 37) 10 else 9)
						else
							21
						)
				)
			)
			((== theVerb 5) ; Do
				(gMessager say: noun theVerb (if (localproc_0) 18 else 11))
			)
			(else
				(gCurRoom setScript: giveAllScr)
			)
		)
	)

	(method (init param1)
		(super init: &rest)
		(if param1
			(self
				view: 251
				posn: 285 156
				loop: 4
				setPri: 5
				approachX: 247
				approachY: 153
				approachVerbs: 2 71 ; Talk, rose
				setScale: Scaler 100 67 153 109
				setScript: roseTendingScr
			)
		else
			(self setCycle: Walk)
		)
	)
)

(instance gate of Prop
	(properties
		x 118
		y 108
		noun 7
		sightAngle 90
		view 250
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(++ local4)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance houseDoor of Prop
	(properties
		x 221
		y 68
		noun 19
		sightAngle 90
		view 250
		loop 1
		priority 1
		signal 16
	)

	(method (cue)
		(self view: 250 loop: 1 cel: 0)
		(gGlobalSound4 number: 902 loop: 1 play:)
	)

	(method (doVerb theVerb)
		(if (and (== local4 3) (== local3 7) (== theVerb 2)) ; Talk
			(= local4 0)
			(= local3 0)
			(self setScript: scriptToBeIgnored)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance leaves of Prop
	(properties
		x 60
		y 181
		view 256
		priority 15
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance featureToBeIgnored of Feature
	(properties
		x 100
		y 320
		noun 3
		nsLeft 3
		nsBottom 7
		nsRight 9
	)

	(method (doVerb theVerb)
		(if (== local4 3)
			(switch theVerb
				(5 ; Do
					(|= local3 $0001)
				)
				(2 ; Talk
					(|= local3 $0002)
				)
				(1 ; Look
					(|= local3 $0004)
				)
			)
		)
		(super doVerb: theVerb &rest)
	)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)
)

(instance palmTrees of Feature
	(properties
		noun 15
		onMeCheck 4
	)
)

(instance houseRoses of Feature
	(properties
		noun 22
		onMeCheck 4096
	)
)

(instance genericFeatures of Feature
	(properties
		sightAngle 40
	)

	(method (onMe param1 &tmp temp0)
		(return
			(= noun
				(switch (= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
					(2 8)
					(1024 21)
					(16 12)
					(32 11)
					(64 17)
					(128 14)
					(256 13)
					(512 18)
					(else 0)
				)
			)
		)
	)
)

