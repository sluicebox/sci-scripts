;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm430 0
)

(local
	[braPts 8] = [175 112 246 112 246 120 175 120]
	[braPts2 8] = [212 112 254 112 254 120 212 120]
)

(instance rm430 of LLRoom
	(properties
		lookStr {Although you haven't really thought about, this isn't what you would have pictured an F.B.I. lab to be.}
		picture 430
		east 440
		west 420
	)

	(method (init)
		(braPolygon points: @braPts size: 4)
		(braPolygon2 points: @braPts2 size: 4)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 103 133 103 133 80 89 80 9 131 107 131 111 128 190 128 190 136 283 136 294 147 319 147 319 189 0 189
					yourself:
				)
		)
		(LoadMany rsVIEW 430 430 432 1430)
		(Load rsSOUND 436)
		(Load rsSCRIPT 991)
		(gEgo init: edgeHit: EDGE_NONE normalize:)
		(desmondDoor init:)
		(if (== gPrevRoomNum 440)
			(gEgo x: 300)
			(self style: 11 setScript: sEnter)
			(desmondDoor cue:)
		else
			(LoadMany rsVIEW 438 1431)
			(LoadMany rsSOUND 40 41)
			(gEgo x: 30 y: 105 cycleSpeed: 6 moveSpeed: 6)
			(twit init: posn: 108 104 setCycle: StopWalk -1)
			(HandsOff)
			(self setScript: sRoom)
		)
		(if (not (IsFlag 41)) ; fVibratorMan
			(LoadMany rsSOUND 431 432 433)
			(vibMan init: setScript: sWork)
		)
		(if (not (IsFlag 42)) ; fBraMan
			(LoadMany rsSOUND 434 435)
			(gCurRoom addObstacle: braPolygon)
			(braMan init: stopUpd:)
			(techMan init:)
		)
		(northDoor init: stopUpd:)
		(ladder setCycle: Fwd init:)
		(dartboard init:)
		(monitors init:)
		(plug init:)
		(outlet init:)
		(chair init:)
		(joystick init:)
		(circuitboard init:)
		(northBank init:)
		(southBank init:)
		(super init:)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(twit
					init:
					x: 400
					y: 101
					setCycle: StopWalk -1
					setMotion: MoveTo 280 101 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End)
				(= seconds (Random 2 3))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance sRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(twit setHeading: 270)
				(= cycles 1)
			)
			(1
				(soundFX number: 40 play:)
				(desmondDoor setCycle: End self)
			)
			(2
				(gTheMusic2 number: 436 setLoop: -1 play:)
				(desmondDoor stopUpd:)
				(desmond
					init:
					x: 45
					y: 101
					setCycle: Walk
					setMotion: MoveTo 95 (desmond y:)
				)
				(gEgo setMotion: MoveTo 96 (+ (gEgo y:) 4) self)
			)
			(3
				(= ticks 60)
			)
			(4
				(Say Inspector_Desmond 430 0 #dispose #caller self) ; "Welcome to our Technical Laboratory. This is the head of our Office of Agent Field Equipment, Commander Twit. Commander Twit, meet Passionate Patti."
			)
			(5
				(= seconds 3)
			)
			(6
				(Say Commander_Twit 430 1 #dispose #caller self) ; "Good morning, Patti," says Commander Twit. "It's so very nice to meet you."
			)
			(7
				(= seconds 3)
			)
			(8
				(Say gEgo 430 2 #at -1 185) ; "Likewise, Commander," you reply, thinking that is the first time you've ever said THAT phrase! "What is all this wonderful equipment you have here? I've always been very interested in research--and researchers!"
				(= ticks 60)
			)
			(9
				(Say Commander_Twit 430 3 #dispose #caller self) ; "You have?" Twit asks suspiciously. "Well, allow me to show you about for a moment before we begin your indoctrination."
			)
			(10
				(= ticks 60)
			)
			(11
				(Say gEgo 430 4 #at -1 185) ; ""Oh, I'd just love a tour," you say, flashing your best smile."
				(= ticks 60)
			)
			(12
				(Say Commander_Twit 430 5 #dispose #caller self) ; "Fine," Twit says, obviously charmed. "Feel free to explore the lab a bit, Patti; when you're ready, I'll give you some information you'll need."
			)
			(13
				(= ticks 60)
			)
			(14
				(Say Inspector_Desmond 430 6 #dispose #caller self) ; "Enjoy your indoctrination, Patti," says Desmond, turning to leave, "and especially your physical!"
			)
			(15
				(desmond
					setMotion: MoveTo (- (desmond x:) 75) (desmond y:) self
				)
			)
			(16
				(desmond dispose:)
				(desmondDoor setCycle: Beg desmondDoor)
				(soundFX number: 41 play:)
				(twit setMotion: MoveTo 154 (- (twit y:) 3) self)
			)
			(17
				(Face twit gEgo self)
			)
			(18
				(gEgo
					moveSpeed: (gGame egoMoveSpeed:)
					cycleSpeed: (gGame egoMoveSpeed:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sVibrator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gTheCursor 1 500 500)
				(Face gEgo braMan self)
			)
			(1
				(Say gEgo 430 7) ; "Excuse me, Commander Twit," you say. "I'm particularly interested in this man's research! What is he up to?"
				(= ticks 60)
			)
			(2
				(SetFlag 41) ; fVibratorMan
				(Say Commander_Twit 430 8 #dispose #caller self) ; "I suspected you might be intrigued. Dr. Rolfing is working on refining our new `infrared, heat-seeking, surface-to-air vibrator.' We feel it will be of considerable value as a protective device against certain types of enemy agents."
			)
			(3
				(soundFX number: 431 setLoop: -1 play:)
				(Face gEgo vibMan self)
			)
			(4
				(vibMan setScript: 0 setLoop: 1 cycleSpeed: 24 setCycle: Fwd)
				(= ticks 180)
			)
			(5
				(vibMan setCel: 0 setLoop: 2 cycleSpeed: 18 setCycle: End self)
			)
			(6
				(soundFX number: 432 play:)
				(vibMan setCel: 0 setLoop: 3 setCycle: End self)
			)
			(7
				(soundFX number: 433 play:)
				(vibMan
					x: (- (vibMan x:) 6)
					y: (- (vibMan y:) 12)
					xStep: 8
					yStep: 8
				)
				(= cycles 1)
			)
			(8
				(vibMan
					setLoop: 4
					cycleSpeed: 4
					moveSpeed: 8
					setStep: 1 1
					setCycle: Fwd
					setMotion: JumpTo -30 230 self
				)
			)
			(9
				(soundFX fade:)
				(vibMan dispose:)
				(= ticks 180)
			)
			(10
				(Say Commander_Twit 430 9 #dispose) ; "Of course, it works much better when you remember to turn it on and then RELEASE it!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sBra of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gTheCursor 1 500 500)
				(SetFlag 42) ; fBraMan
				(techMan setScript: sWork)
				(Face gEgo braMan self)
			)
			(1
				(Say gEgo 430 10) ; "Oh, Commander Twit," you say. "What are these two men doing?"
				(= ticks 60)
			)
			(2
				(Say Commander_Twit 430 11 #dispose #caller self) ; "Ah, now this is an experiment that I think should be of great interest to you, Patti. These two technicians are working on one of our latest Title 9-funded developments: the hair-trigger, double-barreled, armor-piercing brassiere cannon."
			)
			(3
				(techMan setScript: 0 setCycle: End self)
			)
			(4
				(techMan setLoop: 6 setCel: 0 setCycle: End self)
				(braMan setLoop: 1 setCel: 0)
			)
			(5
				(soundFX number: 435 setLoop: 1 play:)
				(techMan setLoop: 1 setCel: 0 setCycle: Fwd)
				(braMan setCel: 1)
				(= ticks 120)
			)
			(6
				(Say gEgo 430 12 #at -1 185) ; "How interesting, Commander!" you say. "But how could you ever fire such a device?"
				(= ticks 60)
			)
			(7
				(Face twit gEgo self)
			)
			(8
				(Say Commander_Twit 430 13 #dispose #caller self) ; "Heh, heh, that's the beauty of this baby," he exclaims, his voice rising with pride. "Just touch your elbows together behind your back!"
			)
			(9
				(braMan setLoop: 2 setCel: 0 cycleSpeed: 24 setCycle: End self)
			)
			(10
				(braMan setLoop: 3 setCycle: Fwd)
				(techMan
					setLoop: 2
					setCel: 255
					cycleSpeed: 24
					setCycle: Beg self
				)
			)
			(11
				(TPrint 430 14) ; "The technician mistakenly believes Commander Twit is speaking to him!"
				(braMan setLoop: 4 setCel: 0 setCycle: End self)
			)
			(12
				(techMan
					setLoop: 3
					setMotion:
						MoveTo
						(- (techMan x:) 30)
						(- (techMan y:) 10)
						techMan
				)
				(soundFX number: 434 setLoop: 1 play:)
				(braMan setLoop: 4 setCel: 0 cycleSpeed: 5 setCycle: End self)
			)
			(13
				(soundFX number: 434 setLoop: 1 play:)
				(Face twit braMan self)
			)
			(14
				(braMan setLoop: 5 setCel: 0 cycleSpeed: 18)
				(= ticks 66)
			)
			(15
				(Say Commander_Twit 430 15 #dispose #caller self) ; "You idiot!" Twit shouts at the bra-slinging technician, "I was talking to Patti!"
			)
			(16
				(braMan setCycle: End self)
			)
			(17
				(= ticks 123)
			)
			(18
				(braMan setLoop: 6 setCel: 0 setCycle: End self)
			)
			(19
				(= ticks 123)
			)
			(20
				(braMan setLoop: 5 setCel: 0 setCycle: End)
				(= seconds 3)
			)
			(21
				(Say Commander_Twit 430 16 #dispose) ; "Obviously, our turnover rate is rather high here!"
				(braMan setCycle: Beg self)
				((gCurRoom obstacles:) delete: braPolygon)
				(gCurRoom addObstacle: braPolygon2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance twit of Actor
	(properties
		x 30
		y 104
		description {Commander Twit}
		lookStr {He's the perfect image of a man more interested in science than in his own self-image!}
		view 432
		cel 2
		signal 16384
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (self mover:))
				(not (gCurRoom script:))
				(> (- (gEgo x:) (self x:)) 20)
			)
			(self setMotion: MoveTo (+ x 10) y)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 17) ; "There's nothing you can do to Commander Twit that he hasn't done already."
			)
			(5 ; Talk
				(cond
					((not (IsFlag 41)) ; fVibratorMan
						(HandsOff)
						(gCurRoom setScript: sVibrator)
					)
					((not (IsFlag 42)) ; fBraMan
						(HandsOff)
						(gCurRoom setScript: sBra)
					)
					(else
						(Say Commander_Twit 430 18 #dispose) ; "Whenever you're through exploring this area, we'll set you up with the mission-required information you're going to need."
					)
				)
			)
			(10 ; Zipper
				(TPrint 430 19) ; "Perish the thought!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance desmond of Actor
	(properties
		x 25
		y 104
		view 438
		signal 16384
	)
)

(instance desmondDoor of Prop
	(properties
		x 15
		y 48
		description {Desmond's door}
		lookStr {This door leads to Inspector Desmond's office. It is presently locked.}
		view 430
		loop 1
		priority 14
		signal 16400
	)

	(method (cue)
		(super cue:)
		(self setPri: 7 stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 20) ; "You decide that it wouldn't be a very good idea to try to open your new boss' private office--especially when he's locked the door."
			)
			(5 ; Talk
				(Say gEgo 430 21) ; "Hey, Desmond!" you cry. "Are you in there?"
				(TPrint 430 22 #at -1 185) ; "(There is no response.)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance northDoor of View
	(properties
		x 106
		y 77
		description {the exterior door}
		lookStr {This door leads outside.}
		view 430
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say Commander_Twit 430 23 #dispose) ; "Whenever you are finished with your indoctrination," says Twit, "I'll have a limousine waiting for you outside that door."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance vibMan of Actor
	(properties
		x 137
		y 161
		description {the vibrator technician}
		view 434
		priority 15
		signal 16400
	)

	(method (doVerb)
		(Points 3 99)
		(HandsOff)
		(gCurRoom setScript: sVibrator)
	)
)

(instance braMan of Prop
	(properties
		x 225
		y 114
		description {the bra-slinging technician}
		view 436
		priority 8
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(if (not (IsFlag 42)) ; fBraMan
			(Points 3 98)
			(HandsOff)
			(gCurRoom setScript: sBra)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance techMan of Actor
	(properties
		x 197
		y 116
		description {the bra-tender}
		yStep 5
		view 437
		loop 5
		cel 3
		signal 16384
		cycleSpeed 10
		xStep 15
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 42) ; fBraMan
			(TPrint 430 24) ; "Knowing what excellent medical coverage the government offers key employees like these, you feel certain this man will make a full and complete recovery!"
		else
			(braMan doVerb: theVerb invItem)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== cel 1) (== loop 1) (== (soundFX prevSignal:) -1))
			(soundFX play:)
		)
	)

	(method (cue)
		(super cue:)
		(self
			setLoop: 4
			setCel: 0
			cycleSpeed: 12
			setCycle: End
			setMotion: MoveTo x (+ y 10)
		)
	)
)

(instance ladder of Prop
	(properties
		x 159
		y 193
		description {the Jacob's ladder}
		lookStr {To think: all your life you assumed there was no real purpose for Jacob's ladders!}
		view 430
		loop 2
		priority 15
		signal 16400
		detailLevel 3
	)
)

(instance dartboard of Feature
	(properties
		x 64
		y 91
		z 40
		nsTop 37
		nsLeft 54
		nsBottom 65
		nsRight 75
		description {the dart board}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 430 25) ; "It is easy to see that F.B.I. employees don't always score!"
			)
			(3 ; Do
				(TPrint 430 26) ; "This dart board is here only for the amusement of the full-time, salaried employees."
				(TPrint 430 27 #at -1 185 #width 280) ; "(Besides, you've never played darts in your life, and you don't intend to begin now!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance monitors of Feature
	(properties
		x 190
		y 90
		z 49
		nsTop 24
		nsLeft 164
		nsBottom 59
		nsRight 216
		description {the monitors}
		sightAngle 40
		lookStr {These monitors are presently disconnected. When they were heavily used many years ago, it was only to play "Jawbreaker!"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 28) ; "You try to turn on the monitor, but are unable to do so."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plug of Feature
	(properties
		x 83
		y 118
		z 100
		nsTop 3
		nsLeft 71
		nsBottom 33
		nsRight 96
		description {the giant plug}
		sightAngle 40
		lookStr {You wonder exactly what that giant plug plugs into.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 29) ; "What? And get electrocuted?!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance outlet of Feature
	(properties
		x 147
		y 77
		z 27
		nsTop 43
		nsLeft 142
		nsBottom 57
		nsRight 152
		description {the intercom}
		sightAngle 40
		lookStr {The lab technicians use this intercom to communicate with the front office and Commander Twit.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 30) ; "You attempt to communicate through the intercom, but your clearance is insufficient."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 169
		y 130
		nsTop 117
		nsLeft 152
		nsBottom 144
		nsRight 186
		description {the chair}
		sightAngle 40
		lookStr {This office chair prevents you from accessing the intricate equipment below it.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 31) ; "Don't move it. You don't need anything that's past the chair."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance joystick of Feature
	(properties
		x 121
		y 160
		z 34
		nsTop 126
		nsLeft 108
		nsBottom 145
		nsRight 135
		description {the joystick}
		sightAngle 40
		lookStr {Wow! What a joystick!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 32) ; "You briefly picture yourself playing "Zeliard.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance circuitboard of Feature
	(properties
		x 68
		y 189
		z 9
		nsTop 172
		nsLeft 46
		nsBottom 189
		nsRight 91
		description {the circuit board}
		sightAngle 40
		lookStr {This looks like a giant circuit board.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 33) ; "Be careful. You'll get shocked!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance northBank of Feature
	(properties
		x 234
		y 89
		z 55
		nsTop 1
		nsLeft 155
		nsBottom 77
		nsRight 319
		description {the laboratory tables}
		sightAngle 40
		lookStr {These tables are filled with highly-expensive scientific equipment, all paid for with your tax dollars!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 34) ; "You really shouldn't mess around with the F.B.I.'s equipment."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance southBank of Feature
	(properties
		x 159
		y 125
		nsTop 118
		nsBottom 189
		nsRight 319
		description {the laboratory tables}
		sightAngle 40
		lookStr {These tables are filled with highly-expensive scientific equipment, all paid for with your tax dollars!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 430 34) ; "You really shouldn't mess around with the F.B.I.'s equipment."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		flags 1
	)
)

(instance Commander_Twit of Talker
	(properties
		name {Commander Twit}
		nsTop 15
		nsLeft 20
		view 1430
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust twitBust)
		(= eyes twitEyes)
		(= mouth twitMouth)
		(super init: &rest)
	)
)

(instance twitBust of Prop
	(properties
		view 1430
		loop 1
	)
)

(instance twitEyes of Prop
	(properties
		view 1430
		loop 2
		cycleSpeed 15
	)
)

(instance twitMouth of Prop
	(properties
		nsTop 47
		nsLeft 11
		view 1430
	)
)

(instance Inspector_Desmond of Talker
	(properties
		name {Inspector Desmond}
		nsTop 15
		nsLeft 15
		view 1431
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust desmondBust)
		(= mouth desmondMouth)
		(= eyes desmondEyes)
		(super init: &rest)
	)
)

(instance desmondBust of Prop
	(properties
		view 1431
		loop 1
	)
)

(instance desmondEyes of Prop
	(properties
		nsTop 27
		nsLeft 31
		view 1431
		loop 2
		cycleSpeed 50
	)
)

(instance desmondMouth of Prop
	(properties
		nsTop 36
		nsLeft 22
		view 1431
	)
)

(instance braPolygon of Polygon
	(properties
		type PBarredAccess
	)
)

(instance braPolygon2 of Polygon
	(properties
		type PBarredAccess
	)
)

