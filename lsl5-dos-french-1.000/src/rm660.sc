;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm660 0
)

(local
	takes
	realTakes = 1
	didSession
	didFF
	talkCounter
	champagneTalkCounter
	didZipper
	mouseDownKey
	keyDownKey
	noteCount
	[whiteKeyNums 18] = [0 2 4 5 7 9 11 12 14 16 17 19 21 23 24 26 28 29]
)

(procedure (FindKeyboardKey event)
	(keyboard
		at:
			(switch (event message:)
				(97 30)
				(119 29)
				(115 28)
				(101 27)
				(100 26)
				(102 25)
				(116 24)
				(103 23)
				(121 22)
				(104 21)
				(117 20)
				(106 19)
				(107 18)
				(111 17)
				(108 16)
				(112 15)
				(59 14)
				(39 13)
				(93 12)
				(65 18)
				(87 17)
				(83 16)
				(69 15)
				(68 14)
				(70 13)
				(84 12)
				(71 11)
				(89 10)
				(72 9)
				(85 8)
				(74 7)
				(75 6)
				(79 5)
				(76 4)
				(80 3)
				(58 2)
				(34 1)
				(125 0)
				(else -1)
			)
	)
)

(procedure (FindKey event &tmp keyNum theKey)
	(= keyNum (- 30 [whiteKeyNums (/ (event x:) 18)]))
	(cond
		((> (event y:) 180)
			(return (keyboard at: keyNum))
		)
		(
			(and
				(< keyNum 30)
				(not ((= theKey (keyboard at: (+ keyNum 1))) white:))
				(theKey onMe: event)
			)
			(return theKey)
		)
		(
			(and
				keyNum
				(not ((= theKey (keyboard at: (- keyNum 1))) white:))
				(theKey onMe: event)
			)
			(return theKey)
		)
		((> (event y:) 164)
			(return (keyboard at: keyNum))
		)
		(else
			(return 0)
		)
	)
)

(instance rm660 of LLRoom
	(properties
		picture 660
		south 640
	)

	(method (init)
		(gEgo init: normalize: 570)
		(HandsOn)
		(switch gPrevRoomNum
			(south
				(gEgo posn: 292 250)
				(if (IsFlag 19) ; fBeenIn660
					(gCurRoom setScript: sWalkIn)
				else
					(gCurRoom setScript: sEntersRoom)
				)
			)
			(else
				(gEgo posn: 160 160 edgeHit: EDGE_NONE)
			)
		)
		(LoadMany rsPIC 670 1)
		(LoadMany rsVIEW 670 672 673 681 682 683 1672)
		(LoadMany rsSOUND 660 661 662 663 664 665)
		(super init:)
		(door init:)
		(reverseBiaz init:)
		(synth init: approachVerbs: 3) ; Do
		(musicStands init:)
		(recordingBooth init:)
		(overhangingMike init:)
		(drums init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 301 189 301 187 314 187 314 170 292 155 301 144 290 143 269 144 244 138 237 137 227 117 233 104 248 104 250 99 230 93 196 108 132 93 123 83 81 83 3 154 3 176 30 176 52 166 86 175 190 187 205 187 247 172 274 187 274 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 77 107 103 106 112 112 154 112 154 119 114 122 113 138 65 139
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 154 140 167 131 223 130 233 142 294 165 268 177 218 158 206 161 191 159 180 164 165 156
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 159 116 196 116 188 130 149 130
					yourself:
				)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== curPic 670)
					(if didSession
						(TPrint 660 0) ; "At last you are alone with Reverse Biaz. Now what are you going to do to obtain Desmond's "hard evidence?""
					else
						(TPrint 660 1) ; "You've wanted a chance to play a Farelight 2000 ever since you first heard one. Now's your chance!"
					)
				else
					(TPrint 660 2) ; "des Rever's recording studio contains a myriad of recording equipment. There are microphones, boom stands, road cases, and cables everywhere!"
				)
			)
			(3 ; Do
				(if (and (== curPic 670) (not didSession))
					(TPrint 660 3) ; "You're here as a keyboard player, Patti. So play!"
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(if (not (keyboard isEmpty:))
			(keyboard dispose:)
		)
		(gTheMusic2 fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance sEntersRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 19) ; fBeenIn660
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 292 182 self)
			)
			(2
				(= seconds 2)
			)
			(3
				(TPrint 660 4) ; "des Rever Records' recording studio reminds you of your last studio session, a big two-CD recording of background music for a computer game named "Leisure Suit Larry 4." And of that big contract you signed with a mysterious someone known only as "Julius," who never paid you one red cent for any of your work!"
				(TPrint 660 5) ; "You grimace and silently hope this session goes better."
				(= seconds 2)
			)
			(4
				(Say Reverse_Biaz 660 6 108 139 self) ; "Why, hello there! Patti, I'm Reverse Biaz, Chief Engineer here at des Rever Records. I'm not sure exactly what happened to my regular synthist, but I sure appreciate you jumping in here to help us out like this. I'm sure you'll have no trouble with these tunes."
			)
			(5
				(HandsOn)
				(= seconds 3)
			)
			(6
				(HandsOff)
				(Say Reverse_Biaz 660 7 108 139 self) ; "The synth is programmed, the charts are on the music stand, the levels are checked and I'm ready when you are, baby!"
			)
			(7
				(HandsOn)
				(gEgo setLoop: -1)
				(reverseBiaz setCel: 0 setCycle: End self)
			)
			(8
				(reverseBiaz setCel: 0)
				(gEgo setScript: sReverseReminds)
				(self dispose:)
			)
		)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 292 182 self)
			)
			(2
				(HandsOn)
				(gEgo setScript: sReverseReminds)
				(self dispose:)
			)
		)
	)
)

(instance sReverseReminds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(-= state 2)
				(Say Reverse_Biaz 660 8 108 139 self) ; "Go ahead, Patti. The synthesizer is on that stand. It's all yours."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sUsesSynth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 90)
				(= seconds 2)
			)
			(1
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 670)
				(gTheIconBar disable: 0)
				(reverseBiaz
					view: 672
					setLoop: 0
					setCel: 0
					x: 203
					y: 72
					setPri: 2
					show:
				)
				(reelOne init:)
				(reelTwo init:)
				(reelThree init:)
				(reelFour init:)
				(vuMeter init:)
				(keyboard init:)
				(music init:)
				(synthPanel init:)
				(panelExtender init:)
				(controlPanel init:)
				(controlPanel2 init:)
				(synth dispose:)
				(musicStands dispose:)
				(recordingBooth dispose:)
				(overhangingMike dispose:)
				(drums dispose:)
				(= cycles 2)
			)
			(2
				(gEgo setScript: sSession)
				(self dispose:)
			)
		)
	)
)

(instance sReturnFromSynth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: (gCurRoom picture:))
				(gCast eachElementDo: #show)
				(reverseBiaz hide:)
				(vuMeter dispose:)
				(reelOne dispose:)
				(reelTwo dispose:)
				(reelThree dispose:)
				(reelFour dispose:)
				(keyboard dispose:)
				(music dispose:)
				(synthPanel dispose:)
				(panelExtender dispose:)
				(door show:)
				(gEgo normalize: 570)
				(gCurRoom setScript: sEnterBooth)
				(self dispose:)
			)
		)
	)
)

(instance sSession of Script
	(properties)

	(method (changeState newState &tmp [str 12])
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: 8)
				(SetFFRoom 1000 reverseBiaz)
				(= seconds 2)
			)
			(1
				(switch takes
					(0
						(Say Reverse_Biaz 660 9 108 139 self) ; "Okay, Patti. Just read the chart there on the stand. We'll take it from a few bars before your entrance. Listen for the clicks, then cut in your solo."
					)
					(1
						(if noteCount
							(= noteCount 0)
							(Say Reverse_Biaz 660 10 108 139 self) ; "That's not quite what the boss is looking for, Patti, baby. I'm gonna roll again from the top. Let's have a little more feeling, okay?"
						else
							(-- takes)
							(= noteCount 0)
							(Say Reverse_Biaz 660 11 108 139 self) ; "Well, Patti, I suppose you just wanted to hear it that time, eh? Well, now you've heard it, so this time really let me have your best shot!"
						)
					)
					(else
						(if (< noteCount 10)
							(-- takes)
							(= noteCount 0)
							(Say Reverse_Biaz 660 12 108 139 self) ; "That's a little TOO sparse, Patti-cakes, babydoll. Let's take it at the upper-left corner, okay? And this time, how about a little more intensity, okay, kid?"
						else
							(Say Reverse_Biaz 660 13 108 139 self) ; "Well, that was fairly outside! Let's give it one more shot, babe. Here we go!"
						)
					)
				)
			)
			(2
				(if (and (== realTakes 1) (not (HaveMouse)))
					(TPrint 660 14 67 -1 15 70 280 80 {A Tip from AL}) ; "Play the white synthesizer keys by typing the keys on the A S D F row. Play the black synthesizer keys by typing the corresponding keys on the W E T Y U row. Holding down the Shift key plays higher."
				)
				(if (> realTakes 1)
					(zing number: 661 play: self)
					(reelOne cycleSpeed: 5 setCycle: Rev)
					(reelTwo cycleSpeed: 5 setCycle: Fwd)
					(reelThree cycleSpeed: 5 setCycle: Rev)
					(reelFour cycleSpeed: 5 setCycle: Fwd)
				else
					(self cue:)
				)
			)
			(3
				(if (> realTakes 1)
					(zing number: 662 play: self)
					(reelOne cycleSpeed: 10)
					(reelTwo cycleSpeed: 10)
					(reelThree cycleSpeed: 10)
					(reelFour cycleSpeed: 10)
				else
					(self cue:)
				)
			)
			(4
				(if (> realTakes 1)
					(reelOne setCycle: 0)
					(reelTwo setCycle: 0)
					(reelThree setCycle: 0)
					(reelFour setCycle: 0)
					(= seconds 2)
				else
					(self cue:)
				)
			)
			(5
				(Format @str 660 15 realTakes realTakes) ; "Take %d!"
				(Say Reverse_Biaz @str 108 139 self)
			)
			(6
				(reverseBiaz setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(reverseBiaz setCycle: Beg self)
			)
			(8
				(reverseBiaz setLoop: 0 setCycle: End self)
			)
			(9
				(reverseBiaz setCycle: Beg self)
			)
			(10
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(11
				(reverseBiaz setCycle: Beg self)
			)
			(12
				(reverseBiaz setLoop: 0 setCel: 0)
				(= cycles 1)
			)
			(13
				(reelOne cycleSpeed: 17 setCycle: Fwd)
				(reelTwo cycleSpeed: 15 setCycle: Rev)
				(reelThree cycleSpeed: 17 setCycle: Fwd)
				(reelFour cycleSpeed: 15 setCycle: Rev)
				(vuMeter view: 670 setLoop: 1 setCel: 0 setCycle: Fwd)
				(if (<= takes 1)
					(gMouseDownHandler addToFront: keyboard)
					(gKeyDownHandler addToFront: keyboard)
					(DoSound sndSUSPEND 1)
					(gTheMusic
						number: 660
						flags: 1
						setLoop: 1
						play:
						send: 9 78 1
					)
					(DoSound sndSUSPEND 0)
				else
					(DoSound sndSUSPEND 1)
					(gTheMusic
						number: 660
						flags: 1
						setLoop: 1
						play: sAutoKeys
						send: 8 78 1
						send: 9 78 0
					)
					(DoSound sndSUSPEND 0)
				)
				(reverseBiaz setScript: sMonitorRecording)
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0 3 4 6 7)
				(if (> takes 1)
					(gCurRoom setScript: sAutoKeys)
					(self dispose:)
				)
				(self cue:)
			)
			(14
				(Delay 50 2 self)
			)
			(15
				(HandsOff)
				(if mouseDownKey
					(mouseDownKey release:)
				)
				(= mouseDownKey 0)
				(= keyDownKey 0)
				(gMouseDownHandler delete: keyboard)
				(gKeyDownHandler delete: keyboard)
				(= seconds 3)
			)
			(16
				(HandsOn)
				(gTheIconBar disable: 0)
				(sMonitorRecording dispose:)
			)
			(17
				(self dispose:)
			)
		)
	)
)

(instance sMonitorRecording of Script
	(properties)

	(method (dispose)
		(reelOne setCycle: 0)
		(reelTwo setCycle: 0)
		(reelThree setCycle: 0)
		(reelFour setCycle: 0)
		(vuMeter setCycle: 0 setLoop: 0)
		(gTheMusic stop:)
		(reverseBiaz setLoop: 0 setCycle: Beg self)
		(if (> takes 1)
			(gCurRoom setScript: sEndSession)
		else
			(++ takes)
			(++ realTakes)
			(gEgo setScript: sSession)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(if (Random 0 1)
					(reverseBiaz setLoop: 0 setCel: 0 setCycle: End self)
				else
					(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
				)
			)
			(2
				(reverseBiaz setCycle: Beg self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sAutoKeys of Script
	(properties)

	(method (changeState newState &tmp theKeyNum theCue)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(gTheIconBar disable: 0 1 3 4 6 7)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
			)
			(1
				(if (== (= theCue (gTheMusic prevSignal:)) -1)
					(register release:)
					(= cycles 1)
				else
					(= theKeyNum (- 30 (- theCue 60)))
					(if register
						(register release:)
					)
					(= register (keyboard at: theKeyNum))
					(gGame
						setCursor:
							gTheCursor
							1
							(if (register white:)
								(+ (register x:) 5)
							else
								(register x:)
							)
							(if (register white:)
								(- (register y:) 10)
							else
								(- (register y:) 12)
							)
					)
					(register depress: 0)
					(self changeState: 0)
				)
			)
			(2
				(sMonitorRecording dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sEndSession of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFFRoom 0)
				(= seconds 3)
			)
			(1
				(= didSession 1)
				(if didFF
					(Say Reverse_Biaz 660 16 108 139 self) ; "Why don't you come into the control room now and listen to the playback with me?"
				else
					(zing dispose:)
					(Points 8 126)
					(Say Reverse_Biaz 660 17 108 139 self) ; "Great take, Patti! Why don't you come into the control room now and listen to the playback with me?"
				)
			)
			(2
				(gCurRoom setScript: sReturnFromSynth)
				(self dispose:)
			)
		)
	)
)

(instance sEnterBooth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(User canControl: 0)
				(User canInput: 0)
				(gEgo setPri: 4 setMotion: PolyPath 229 101 self)
			)
			(1
				(gTheMusic number: 40 setVol: 127 setLoop: 1 play:)
				(door ignoreActors: 1 setPri: 3 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 279 74 self)
			)
			(3
				(door dispose:)
				(gCurRoom drawPic: 670)
				(reverseBiaz show:)
				(gEgo view: 681 setLoop: 1 setCel: 0 x: 241 y: 71 show:)
				(reelOne init:)
				(reelTwo init:)
				(reelThree init:)
				(reelFour init:)
				(vuMeter init:)
				(keyboard init:)
				(music init:)
				(synthPanel init:)
				(panelExtender init:)
				(gTheIconBar disable: 0)
				(= seconds 3)
			)
			(4
				(Say Reverse_Biaz 660 18 108 139 self) ; "Here you go, babe. Check this out!"
			)
			(5
				(reverseBiaz setCycle: End self)
			)
			(6
				(reverseBiaz setCycle: Beg self)
			)
			(7
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(8
				(reverseBiaz setCycle: Beg self)
			)
			(9
				(reverseBiaz setLoop: 0)
				(= cycles 1)
			)
			(10
				(reverseBiaz view: 681 setLoop: 0 setCel: 0 x: 203 y: 71)
				(= cycles 1)
			)
			(11
				(reelOne setCycle: Fwd)
				(reelTwo setCycle: Rev)
				(self cue:)
			)
			(12
				(DoSound sndSUSPEND 1)
				(gTheMusic
					number: 660
					flags: 1
					setLoop: 1
					play: sStopMusic
					send: 8 78 1
				)
				(DoSound sndSUSPEND 0)
				(reverseBiaz setScript: sStopMusic)
				(self cue:)
			)
			(13
				(= seconds 10)
			)
			(14
				(gTheMusic fade: 80 15 12 0)
				(Say Reverse_Biaz 660 19 108) ; "Nice playing, Patti," he smiles, "I bet you have wonderful technique!"
				(HandsOn)
				(User canControl: 0)
				(User canInput: 1)
				(gTheIconBar disable: 0)
				(Delay 300 0 self)
			)
			(15
				(HandsOff)
				(Say Reverse_Biaz 660 20 108 139 self) ; "Well, Patti," Reverse says, "I've got another session starting soon. You're going to have to go now; I've got to get to work!"
			)
			(16
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(keyboard dispose:)
				(gCurRoom drawPic: 1 6)
				(= ticks 120)
			)
			(17
				(TPrint 660 21) ; "After failing in your attempt to get evidence from Reverse Biaz, you return to your limo."
				(= ticks 120)
			)
			(18
				(SetFlag 29) ; fBeenInBaltimore
				(gCurRoom newRoom: 200 7)
				(self dispose:)
			)
		)
	)
)

(instance sStopMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if (== (gTheMusic prevSignal:) -1)
					(reelOne setCycle: 0)
					(reelTwo setCycle: 0)
					(= cycles 1)
				else
					(self changeState: 0)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sDrunkReverse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheTimer dispose: delete:)
				(sEnterBooth dispose:)
				(= ticks 123)
			)
			(1
				(Say gEgo 660 22) ; "What would you say if I proposed a toast, Mr. Biaz?"
				(= ticks 60)
			)
			(2
				(Say Reverse_Biaz 660 23 108 139 self) ; "Why, Patti!" he replies with a grin, "I'm always interested in sharing a glass of champagne with a beautiful woman!"
			)
			(3
				(= ticks 60)
			)
			(4
				(Say Reverse_Biaz 660 24 108 139 self) ; "To you, Patti!" he proposes a toast. "And to many more successful sessions together!"
			)
			(5
				(= ticks 60)
			)
			(6
				(gEgo hide:)
				(reverseBiaz
					view: 683
					setLoop: 0
					setCel: 0
					x: 231
					y: 71
					cycleSpeed: 13
					setCycle: CT 1 1 self
				)
			)
			(7
				(= ticks 60)
			)
			(8
				(reverseBiaz setCycle: CT 3 1 self)
			)
			(9
				(= ticks 60)
			)
			(10
				(reverseBiaz setCycle: End self)
			)
			(11
				(glassesClink play:)
				(= ticks 123)
			)
			(12
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(13
				(= ticks 123)
			)
			(14
				(Say Reverse_Biaz 660 25 108 139 self) ; "Ahh! A pleasant vintage," he sighs, "but it's a little warm, isn't it?""
			)
			(15
				(= ticks 60)
			)
			(16
				(Say gEgo 660 26) ; "Well, possibly so," you say in its defense, "but then, you don't know where it's been!"
				(= ticks 123)
			)
			(17
				(Say gEgo 660 27) ; "Here, Mr. Biaz," you say, "have a little more."
				(reverseBiaz setLoop: 0 setCel: 2 setCycle: CT 3 1 self)
			)
			(18
				(= ticks 60)
			)
			(19
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(20
				(= ticks 60)
			)
			(21
				(switch champagneTalkCounter
					(0
						(Say gEgo 660 28) ; ""One more won't hurt, Mr. Biaz," you say, using a technique on him that's worked more than a few times on you."
					)
					(1
						(Say gEgo 660 29) ; "No, but I'd love to hear!"
					)
					(2
						(Say gEgo 660 30) ; "I've shown you my work; will you show me yours?"
					)
					(3
						(Say gEgo 660 31) ; "Oh, really? How could that be, Reverse?"
					)
				)
				(= ticks 90)
			)
			(22
				(reverseBiaz setLoop: 0 setCel: 2 setCycle: CT 3 1 self)
			)
			(23
				(= ticks 60)
			)
			(24
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(25
				(= ticks 60)
			)
			(26
				(switch champagneTalkCounter
					(0
						(Say Reverse_Biaz 660 32 108 139 self) ; "Please, call me Reverse!" slurs Reverse, "So, Patticakes, have I ever told you what an important guy I am?"
					)
					(1
						(Say Reverse_Biaz 660 33 108 139 self) ; "Sshaay, thissh issh tasshty!"
					)
					(2
						(Say Reverse_Biaz 660 34 108 139 self) ; "Why, ssshweetie, my ssshtuff's on more recordsssh than anybody'ssh!"
					)
					(3
						(Say Reverse_Biaz 660 35 108 139 self) ; "Eassshy, ssshugar!" slurs Reverse. "Lemme find you a sshample!"
					)
				)
			)
			(27
				(= ticks 90)
				(if (< (++ champagneTalkCounter) 4)
					(-= state 7)
				)
			)
			(28
				(gEgo show:)
				(zing number: 665 play:)
				(reverseBiaz
					view: 683
					setLoop: 2
					setCel: 0
					x: 241
					y: 71
					setCycle: End self
				)
			)
			(29
				(glassesClink dispose:)
				(zing dispose:)
				(= seconds 3)
			)
			(30
				(giveTape init:)
				(Points 40 130)
				(gEgo get: 6) ; Hard_Disk_Cafe_Napkin
				(= seconds 3)
			)
			(31
				(Points 18 127)
				(Say Reverse_Biaz 660 36 108 139 self) ; "Wait'll ya hear thissh," slobbers Reverse. "Every ssshong hasssh ssshomething ssshublimal!"
			)
			(32
				(= seconds 3)
			)
			(33
				(TPrint 660 37) ; "Good job, Patti! The boys back at the F.B.I. Labs will have a wonderful time extracting those backwards subliminal messages from Biaz's tape!"
				(= cycles 3)
			)
			(34
				(SetFlag 20) ; fChampagneSolution
				(gCurRoom newRoom: 690)
			)
		)
	)
)

(instance sTalkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch talkCounter
					(0
						(Say gEgo 660 38) ; ""So, Mr. Biaz, I understand you're quite a successful recording engineer," you say."
					)
					(1
						(Say gEgo 660 39) ; ""I just love studio work," you say with a knowing smile."
					)
					(2
						(Say gEgo 660 40) ; "Why, thank you, Mr. Biaz," you say, fluttering your lashes, "I think I was especially inspired today--by you!"
					)
					(3
						(Say gEgo 660 41) ; "Oh, that would be wonderful, Mr. Biaz."
					)
					(4
						(Say gEgo 660 42) ; ""And please, call me Patti!" you say, ignoring the fact that he has been calling you Patti."
					)
					(5
						(Say gEgo 660 43) ; "I'll only be in town a short time, Reverse," you say, your voice filled with warmth. "I'd certainly like to have a little something to remember you by."
					)
					(6
						(gTheTimer dispose: delete:)
						(sEnterBooth dispose:)
						(Say gEgo 660 44) ; "Is there a chance I could get some samples of your work?" you ask, with a knowing glance. "In fact, I'd love to `add your work' to my collection."
					)
				)
				(= ticks 60)
			)
			(1
				(switch talkCounter
					(0
						(Say Reverse_Biaz 660 45 108 139 self) ; "Yeah, I can't complain," he replies. "I have several `clients' who keep me quite busy."
					)
					(1
						(Say Reverse_Biaz 660 46 108 139 self) ; "Oh?" answers Reverse. "Well, you did do a nice job on this cut."
					)
					(2
						(Say Reverse_Biaz 660 47 108 139 self) ; "Warming noticeably, he continues, "Well, Patti, I do know a lot of very important people in the recording business. I suppose I could drop your name in a few right places.""
					)
					(3
						(Say Reverse_Biaz 660 48 108 139 self) ; "Please... call me Reverse!"
					)
					(4
						(= cycles 2)
					)
					(5
						(Say Reverse_Biaz 660 49 108 139 self) ; "Why, I think that could be arranged," he says. "What is it you're thinking of?"
					)
					(6
						(Say Reverse_Biaz 660 50 108 139 self) ; "I'd be glad to give you some samples of my work, Patti," he says with a wink, "if I can have a sample of YOURS!"
					)
				)
			)
			(2
				(++ talkCounter)
				(RestoreIB)
				(if (> talkCounter 6)
					(self setScript: sDoSex)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoSex of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(TPrint 660 51) ; "More than willing to "serve your country" (especially with such a hunk), you throw yourself enthusiastically into your mission."
				(gTheMusic fade: 0 15 12 1)
				(= ticks 60)
			)
			(1
				(gTheMusic2 number: 663 setLoop: -1 flags: 1 play:)
				(gEgo hide:)
				(reverseBiaz
					view: 682
					setLoop: 0
					setCel: 0
					x: 222
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(= ticks 180)
			)
			(3
				(reverseBiaz setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(= ticks 240)
			)
			(5
				(reverseBiaz
					setLoop: 2
					setCel: 0
					x: 235
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(6
				(= ticks 120)
			)
			(7
				(reverseBiaz
					setLoop: 3
					setCel: 0
					x: 263
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(8
				(= ticks 120)
			)
			(9
				(reverseBiaz
					setLoop: 2
					setCel: 0
					x: 235
					y: 71
					cycleSpeed: 10
					setCycle: CT 5 1 self
				)
			)
			(10
				(reelThree setCycle: Fwd)
				(reelFour setCycle: Rev)
				(vuMeter view: 670 setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 180)
			)
			(11
				(reverseBiaz
					setLoop: 2
					x: 235
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(12
				(= ticks 120)
			)
			(13
				(reverseBiaz
					setLoop: 4
					setCel: 0
					x: 255
					y: 73
					setCycle: End self
				)
			)
			(14
				(reverseBiaz
					setLoop: 5
					setCel: 0
					x: 213
					y: 72
					setCycle: End self
				)
			)
			(15
				(= ticks 120)
			)
			(16
				(reverseBiaz
					setLoop: 2
					setCel: 0
					x: 235
					y: 71
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(17
				(= ticks 120)
			)
			(18
				(reverseBiaz
					setLoop: 6
					setCel: 0
					x: 230
					y: 72
					setCycle: End self
				)
			)
			(19
				(reverseBiaz
					setLoop: 5
					setCel: 0
					x: 213
					y: 72
					setCycle: End self
				)
			)
			(20
				(= ticks 240)
			)
			(21
				(reverseBiaz
					setLoop: 7
					setCel: 0
					x: 213
					y: 73
					setCycle: End self
				)
			)
			(22
				(= ticks 180)
			)
			(23
				(if didZipper
					(Points 10 128)
				else
					(Points 16 129)
				)
				(keyboard dispose:)
				(gCurRoom drawPic: 1 6)
				(= ticks 120)
			)
			(24
				(TPrint 660 52) ; "Eventually, through one sacrifice after another, you eventually obtain a small cassette tape from Reverse Biaz containing some of his best work. It is exactly the evidence you've been seeking. The boys back at the F.B.I. lab will have a heyday playing with this one."
				(Points 40 130)
				(gEgo get: 6) ; Hard_Disk_Cafe_Napkin
				(self cue:)
			)
			(25
				(= ticks 120)
			)
			(26
				(TPrint 660 53) ; "Unbeknownst to you, when you bumped your leg on the recording console in the excitement of the moment, you made a complete soundtrack of your love-making session."
				(TPrint 660 54) ; "Reverse later added a drum machine and synthesized bass line, and created another hit record."
				(TPrint 660 55) ; "Ironically, you eventually got that Number One record you've always wanted! But, you knew nothing about it. At least once in your life, Patti, you hit the top of the charts!"
				(gCurRoom newRoom: 690)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 249
		y 96
		description {the door}
		view 660
		signal 16385
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 56) ; "This door leads to the control booth--and Reverse Biaz."
			)
			(3 ; Do
				(TPrint 660 57) ; "You would like to see the control room, and talk with Mr. Biaz, but first you want to complete this recording session."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance reverseBiaz of Prop
	(properties
		x 286
		y 64
		description {Reverse Biaz}
		view 662
		priority 5
		signal 16401
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 58) ; "Reverse Biaz is the man the F.B.I. linked to backwards subliminal message recording at this studio. But he does looks cute."
			)
			(3 ; Do
				(if didSession
					(Say Reverse_Biaz 660 59 108) ; "Oooh! Now that feels nice, Patti."
				else
					(TPrint 660 60) ; "You are unable to touch Reverse Biaz through that double-paned soundproof glass."
				)
			)
			(5 ; Talk
				(if didSession
					(gCurRoom setScript: sTalkScript)
				else
					(Say Reverse_Biaz 660 61 108) ; "Patti, I can see your lips moving, but I don't have an open mike out there. Just go ahead and play, and we can talk later, okay?"
				)
			)
			(4 ; Inventory
				(switch invItem
					(4 ; A_Blank_Videotape_c
						(if didSession
							(gEgo put: 4) ; A_Blank_Videotape_c
							(gCurRoom setScript: sDrunkReverse)
						else
							(TPrint 660 62) ; "You don't pour THROUGH glass, Patti, you pour INTO glass!"
						)
					)
					(else
						(Say Reverse_Biaz 660 63 108) ; "I don't know why you're offering me that, Patti. Did you come to play or come to bargain?"
					)
				)
			)
			(10 ; Zipper
				(if didSession
					(= didZipper 1)
					(gCurRoom setScript: sDoSex)
				else
					(TPrint 660 64) ; "You have no way to do that through that window!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(if (and cycler (not (IsObject cycler)))
			(= cycler 0)
		)
		(super doit:)
	)

	(method (cue)
		(= takes 2)
		(= didFF 1)
		(sSession dispose:)
		(sMonitorRecording dispose:)
	)
)

(instance giveTape of View
	(properties
		x 241
		y 73
		view 683
		loop 3
		priority 4
		signal 16
	)
)

(instance panelExtender of View
	(properties
		x 183
		y 83
		description {the control room mixer}
		sightAngle 40
		view 670
		loop 6
		priority 3
		signal 17
	)

	(method (doVerb theVerb invItem)
		(controlPanel doVerb: theVerb invItem)
	)
)

(instance reelOne of Prop
	(properties
		x 214
		y 26
		description {the tape reel}
		sightAngle 40
		view 670
		loop 2
		signal 1
		cycleSpeed 15
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 65) ; "You assumed all modern studios recorded directly to hard disks!"
			)
			(3 ; Do
				(if didSession
					(TPrint 660 66) ; "Reverse would prefer you to leave his reels alone!"
				else
					(TPrint 660 67) ; "Those tapes are inaccessible to you--for now!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance reelTwo of Prop
	(properties
		x 236
		y 26
		description {the tape reel}
		sightAngle 40
		view 670
		loop 3
		signal 1
		cycleSpeed 20
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(reelOne doVerb: theVerb invItem)
	)
)

(instance reelThree of Prop
	(properties
		x 261
		y 27
		description {the tape reel}
		sightAngle 40
		view 670
		loop 4
		signal 1
		cycleSpeed 15
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(reelOne doVerb: theVerb invItem)
	)
)

(instance reelFour of Prop
	(properties
		x 283
		y 27
		description {the tape reel}
		sightAngle 40
		view 670
		loop 5
		signal 1
		cycleSpeed 20
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(reelOne doVerb: theVerb invItem)
	)
)

(instance vuMeter of Prop
	(properties
		x 169
		y 29
		description {the VU meter}
		sightAngle 40
		view 670
		signal 1
		cycleSpeed 10
		detailLevel 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 68) ; "This meter measures dynamic levels in decibels, each of which is about 1/10th of a bel."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(class synthKey of Prop
	(properties
		description {the key}
		view 673
		detailLevel 1
		frequency 0
		white 0
	)

	(method (depress playNote)
		(if keyDownKey
			(keyDownKey release:)
			(= keyDownKey 0)
		)
		(self setCel: 1)
		(if playNote
			(++ noteCount)
			(gTheMusic send: 8 144 frequency 100)
		)
	)

	(method (release)
		(self setCel: 0)
		(gTheMusic send: 8 128 frequency 0)
	)

	(method (doit &tmp evt newKey)
		(super doit:)
		(= evt (User curEvent:))
		(if (and (== mouseDownKey self) (!= self (= newKey (FindKey evt))))
			(self release:)
			(= mouseDownKey newKey)
			(if newKey
				(newKey depress:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 69) ; "Wow! It's a Farelight 2000, the highest-tech high-tech synthesizer keyboard. You've always wanted one of these for its wonderful Boesendorfer patch!"
				(TPrint 660 70) ; "Gurn Blanston plays one with "Rex Famine and the Limestone Bug Legs.""
			)
			(3 ; Do
				(if didSession
					(TPrint 660 71) ; "You can't play the synthesizer keyboard from inside the control room!"
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(self release:)
	)
)

(instance keyboard of EventHandler
	(properties)

	(method (init &tmp keyNum octave theKey keyIsWhite i theX theY theView theLoop theFreq)
		(super init: &rest)
		(for ((= i 0)) (< i 31) ((++ i))
			(= octave (/ (= keyNum i) 12))
			(= keyIsWhite (mod (-= keyNum (* octave 12)) 2))
			(if (< keyNum 5)
				(-- keyIsWhite)
			)
			(= theKey (synthKey new:))
			(= theView (theKey view:))
			(= theLoop
				(if keyIsWhite
					(switch keyNum
						(0 1)
						(2 2)
						(4 3)
						(5 1)
						(7 2)
						(9 2)
						(11 3)
					)
				else
					0
				)
			)
			(if keyIsWhite
				(if (> keyNum 4)
					(++ keyNum)
				)
				(= theX (+ (= theX (* (/ keyNum 2) 18)) (* octave 126)))
				(= theY 189)
			else
				(= theX (+ (= theX (* (/ keyNum 2) 18)) 18 (* octave 126)))
				(= theY 180)
			)
			(= theFreq (+ i 60))
			(theKey
				setLoop: theLoop
				x: theX
				y: theY
				frequency: theFreq
				white: keyIsWhite
				ignoreActors:
				setPri: (if keyIsWhite -1 else 15)
				stopUpd: 1
				init:
			)
			(self addToFront: theKey)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp evt theKey)
		(cond
			(mouseDownKey
				(if (== (event type:) evMOUSERELEASE)
					(mouseDownKey release:)
					(= mouseDownKey 0)
				)
				(event claimed: 1)
			)
			((== (event type:) evMOUSEBUTTON)
				(if
					(and
						(= theKey (FindKey event))
						(!= ((gTheIconBar curIcon:) cursor:) 1)
					)
					(theKey depress: 1)
					(= mouseDownKey theKey)
					(event claimed: 1)
				else
					(super handleEvent: event &rest)
				)
			)
			((== (event type:) evKEYBOARD)
				(if (!= (= theKey (FindKeyboardKey event)) (keyboard at: -1))
					(theKey depress: 1)
					(= keyDownKey theKey)
					((Timer new:) setCycle: theKey 5)
				else
					(super handleEvent: event &rest)
				)
				(event claimed: 1)
			)
		)
	)
)

(instance synth of Feature
	(properties
		x 87
		y 102
		nsTop 88
		nsLeft 77
		nsBottom 115
		nsRight 100
		description {your synthesizer}
		sightAngle 40
		approachX 67
		approachY 131
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 72) ; "This is the synthesizer Reverse Biaz wants you to play."
			)
			(3 ; Do
				(gEgo setScript: sUsesSynth)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance musicStands of Feature
	(properties
		x 55
		y 167
		nsTop 147
		nsLeft 31
		nsBottom 187
		nsRight 80
		description {the music stands}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 73) ; "You see a bunch of music stands. Or is it a flock of music stands? Or is it a bevy of music stands? You always forget."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance recordingBooth of Feature
	(properties
		x 280
		y 52
		nsTop 22
		nsLeft 256
		nsBottom 83
		nsRight 304
		description {the control room}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 74) ; "From his control room, Reverse can see the entire studio. He can speak to you through the soundproof glass via a talkback loudspeaker."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance overhangingMike of Feature
	(properties
		x 100
		y 63
		nsTop 56
		nsLeft 94
		nsBottom 70
		nsRight 107
		description {the overhead mike}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 75) ; "You wonder how many evil recordings were done with this microphone."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drums of Feature
	(properties
		x 178
		y 73
		nsTop 51
		nsLeft 135
		nsBottom 96
		nsRight 222
		description {the drum set}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 76) ; "As in most studios, the drum set is behind glass to enhance the separation of his sound from the other musicians."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance music of Feature
	(properties
		x 96
		y 59
		nsTop 17
		nsLeft 48
		nsBottom 102
		nsRight 144
		description {the music}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if didSession
					(TPrint 660 77) ; "This is the song you recorded for Reverse."
				else
					(TPrint 660 78) ; "This is the song you are supposed to perform. You DO remember how to play keyboards, don't you, Patti?"
				)
			)
			(3 ; Do
				(if didSession
					(TPrint 660 79) ; "You can't reach the music from inside the control room."
				else
					(TPrint 660 80) ; "There's no need for you to turn the page, Patti!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance synthPanel of Feature
	(properties
		x 159
		y 130
		nsTop 111
		nsBottom 149
		nsRight 319
		description {the synthesizer control panel}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 81) ; "des Rever Records spared no expense programming this synthesizer for this session."
			)
			(3 ; Do
				(if didSession
					(TPrint 660 82) ; "You can't reach the synthesizer from inside the booth!"
				else
					(TPrint 660 83) ; "As much as you hate to, you just can't resist tweaking a patch here and there!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance controlPanel of Feature
	(properties
		x 238
		y 76
		nsTop 73
		nsLeft 194
		nsBottom 80
		nsRight 283
		description {the control room mixer}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 84) ; "The control room mixer is covered with a complicated array of sliders, knobs, buttons, patch bays and XLR connectors."
			)
			(3 ; Do
				(TPrint 660 85) ; "You'd love to get your hands on those potentiometers, but assume Reverse is as particular as most engineers!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance controlPanel2 of Feature
	(properties
		x 232
		y 58
		nsTop 50
		nsLeft 168
		nsBottom 67
		nsRight 296
		description {the studio control panel}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 660 86) ; "This panel contains many digital reverb and special effects units, power amplifiers, patch bays and a copy of last month's Playboy."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance glassesClink of Sound
	(properties
		number 664
		priority 15
	)
)

(instance zing of Sound
	(properties)
)

(instance Reverse_Biaz of Talker
	(properties
		name {Reverse Biaz}
		nsTop 15
		nsLeft 30
		view 1672
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust reverseBust)
		(= eyes reverseEyes)
		(= mouth reverseMouth)
		(super init: &rest)
	)
)

(instance reverseBust of Prop
	(properties
		view 1672
		loop 1
	)
)

(instance reverseEyes of Prop
	(properties
		nsTop 31
		nsLeft 22
		view 1672
		loop 2
		cycleSpeed 70
	)
)

(instance reverseMouth of Prop
	(properties
		nsTop 36
		nsLeft 15
		view 1672
		cycleSpeed 5
	)
)

