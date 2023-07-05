;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm130 0
)

(local
	graffitiCount
	[unused 2]
	lookedSink
)

(instance rm130 of LLRoom
	(properties
		picture 130
	)

	(method (init &tmp foo)
		(= foo ForwardCounter)
		(LoadMany rsSOUND 130 132 133 134 135 102 801 802 136)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(LoadMany rsVIEW 130 131 132)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 125 113 95 120 117 165 190 148 190 143 182 143 182 137 223 137 224 109 194 108 184 114 160 114 155 110 130 111 130 0 319 0 319 189 0 189 0 0 125 0
					yourself:
				)
		)
		(gEgo posn: 138 113 observeControl: -32768 init: actions: egoActions)
		(gEHead actions: egoActions)
		(if (ObjInRoom 4)
			(theSparkle cycleSpeed: global101 init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		)
		(toilet init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(sink init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(graffiti init:)
		(super init:)
		(gTheMusic2 number: 136 loop: 1 vol: 127 flags: 1)
		(door init: setCel: 6 setScript: sCloseDoor approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(theHandle init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(faucet init: setScript: sDoDrips)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== (gEgo view:) 131)
				(or (== (gEgo loop:) 0) (== (gEgo loop:) 1))
				(gEgo mover:)
			)
			(gCurRoom setScript: 0)
			(Print 130 0 #at -1 20) ; "Carefully finishing your duties, you wipe and toss the newspaper behind the toilet for the next user."
			(SetFlag 40)
			(NormalEgo 2)
			(if (!= (CueObj client:) toilet)
				(gEgo
					setMotion:
						PolyPath
						((CueObj client:) approachX:)
						(+ (gEgo z:) ((CueObj client:) approachY:))
						CueObj
				)
			else
				(gEgo
					setMotion:
						PolyPath
						((User curEvent:) x:)
						((User curEvent:) y:)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 130 1) ; "You are in Lefty's one and only restroom. The stench is overpowering, there is graffiti on the walls, and you doubt that the sink was clean even when it was installed. Even roaches can't survive in this place!"
				(if (ObjInRoom 4)
					(Print 130 2) ; "Water drips merrily down the drain in Lefty's lovely sink."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gTheMusic2 fade:)
		(super newRoom: newRoomNumber)
	)
)

(class egoActions of Code
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Zipper
				(toilet doVerb: 10)
			)
		)
	)
)

(instance sTakeCrap of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if register
			(-- register)
		else
			(= register (Random 30 50))
			(gEgo setCel: 0 setCycle: ForwardCounter (Random 1 3))
		)
		(if (== (gEgo cel:) 1)
			(gTheMusic3 number: 132 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: view: 131 normal: 0 setLoop: 0 setCel: 2)
				(= register 5)
				(= cycles 3)
			)
			(1
				(Print 130 3 #at -1 20) ; "You grab an ancient copy of the "Ball Street Journal," and settle in to "sit and think!""
				(gEgo setCycle: End)
				(= register (Random 20 40))
				(Points 84 1)
				(= seconds 8)
			)
			(2
				(Print 130 4 #at -1 20) ; "You feel a great relief!"
				(= seconds 5)
			)
			(3
				(fartNoise play:)
				(= seconds 4)
			)
			(4
				(Print 130 5 #at -1 20) ; "What's that aroma?"
			)
		)
	)
)

(instance sTakePiss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed:
					view: 131
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 4 setCel: 0 setCycle: Fwd)
				(= cycles 8)
			)
			(2
				(gTheMusic3 number: 102 setLoop: 1 play: self)
				(Print 130 6 #at -1 20 #dispose) ; "Ahhhhhhh."
			)
			(3
				(= seconds 3)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(5
				(NormalEgo 3)
				(HandsOn)
				(if
					(>
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(toilet approachX:)
							(toilet approachY:)
						)
						5
					)
					(Print 130 7 #at -1 20) ; "Hey, you missed the toilet!"
				)
				(self dispose:)
			)
		)
	)
)

(instance sFlood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic3 number: 134 loop: 1 play:)
				(= cycles 20)
			)
			(1
				(Print 130 8 #at -1 20) ; "Realizing your mistake, you quickly jiggle the handle, attempting to stem the onrushing tide of water."
				(Print 130 9 #at -1 20) ; "It doesn't work."
				(gTheMusic3 number: 135 loop: -1 play:)
				(overflow init: cycleSpeed: (+ 3 global101) setCycle: End self)
				(gEgo egoSpeed: setHeading: 180)
			)
			(2
				(overflow setLoop: 2 setCycle: Fwd)
				(flood init:)
				(= cycles 2)
			)
			(3
				(++ register)
				((flood new:)
					init:
					cel: register
					y: (- (flood y:) (* 7 register))
					stopUpd:
				)
				(if (< register 8)
					(-- state)
				)
				(= cycles 5)
			)
			(4
				(overflow dispose:)
				(Print 130 10) ; "Your life passes before your eyes."
				(Print 130 11 #at -1 140) ; "(You doze briefly.)"
				(gEgo
					view: 131
					loop: 5
					x: (+ (gEgo x:) 10)
					y: (- (gEgo y:) 20)
					cycleSpeed: 4
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(5
				(++ register)
				((flood new:)
					init:
					cel: register
					y: (- (flood y:) (* 7 register))
					stopUpd:
				)
				(if (< register 16)
					(-- state)
				)
				(= cycles 5)
			)
			(6
				(= seconds 3)
			)
			(7
				(Death 131 7)
				(Format @gYourPart 130 12) ; "You feel flushed!"
				(GameOver 130 13)
			)
		)
	)
)

(instance sGetRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed:
					view: 131
					setLoop: 1
					setCel: 0
					z: 10
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(Points 77 3)
				(gEgo get: 4 setCel: 255 setLoop: 1 setCycle: Beg self) ; ring
			)
			(3
				(Print 130 14 #at -1 20) ; "Got it! You briefly consider an attempt to find the ring's owner, but return to your normal self and pocket it instead."
				(gEgo z: 0)
				(NormalEgo 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sSparkle of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End)
				(= seconds (Random 5 20))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance sCloseDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setCycle: CT 5 -1 self)
			)
			(1
				(gTheMusic3 number: 802 play:)
				(door setCycle: Beg self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sDoDrips of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(faucet setCycle: Beg self)
			)
			(2
				(gTheMusic2 play:)
				(self init:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 114
		y 112
		description {the door}
		approachX 141
		approachY 112
		view 130
		signal 16400
	)

	(method (cue)
		(super cue:)
		(gCurRoom newRoom: 120)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gTheMusic3 number: 801 play:)
				(self setCycle: End self)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance theSparkle of Prop
	(properties
		x 206
		y 127
		description {the ring}
		approachX 190
		approachY 144
		view 131
		loop 6
		priority 12
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(sink doVerb: theVerb invItem)
	)
)

(instance overflow of Prop
	(properties
		x 171
		y 97
		view 130
		loop 1
		signal 16384
	)
)

(instance flood of View
	(properties
		x 170
		y 146
		view 132
		priority 1
		signal 16400
	)
)

(instance faucet of Prop
	(properties
		x 209
		y 129
		description {the sink}
		sightAngle 40
		view 130
		loop 3
		priority 10
		signal 16400
	)

	(method (cue)
		(super cue:)
		(if (ObjInRoom 4)
			(= lookedSink 1)
			(Print 130 15 #at -1 20) ; "Why, look! Some woman removed her diamond ring to wash her hands, and forgot to take it with her."
			(theSparkle setCycle: Beg)
		else
			(Print 130 16 #at -1 20) ; "A small, neatly lettered sign reminds you: "Since we can't clean up after every customer, please rinse out this sink when you are finished.""
			(Print 130 17 #at -1 140) ; "(Evidently, you are the first customer who can read.)"
		)
	)
)

(instance toilet of Feature
	(properties
		x 182
		y 91
		nsTop 76
		nsLeft 164
		nsBottom 107
		nsRight 200
		description {the toilet}
		sightAngle 40
		approachX 171
		approachY 111
		lookStr {It's not a pretty sight!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if
					(not
						(and
							(== (gEgo view:) 131)
							(or (== (gEgo loop:) 0) (== (gEgo loop:) 1))
						)
					)
					(gCurRoom setScript: sTakeCrap)
				else
					(Print 130 18 #at -1 20) ; "NOW??"
				)
			)
			(5 ; Talk
				(Print 130 19) ; "You briefly consider yodeling in the stagnant water."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; breathSpray
						(Print 130 20) ; "It would help, but not much."
					)
					(0 ; wallet
						(Print 130 21) ; "You dip your wallet into the slimy bowl just for the feeling you get when you slide it back in your pocket!"
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Zipper
				(HandsOff)
				(gCurRoom setScript: sTakePiss)
			)
			(11 ; Taste/Smell
				(Print 130 22) ; "My, my. Aren't we the little sick-o!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sink of Feature
	(properties
		x 202
		y 146
		z 20
		nsTop 119
		nsLeft 185
		nsBottom 137
		nsRight 220
		description {the sink}
		sightAngle 40
		approachX 190
		approachY 144
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if
					(not
						(and
							(== (gEgo view:) 131)
							(or (== (gEgo loop:) 0) (== (gEgo loop:) 1))
						)
					)
					(gEgo
						setHeading:
							(GetAngle
								(gEgo x:)
								(gEgo y:)
								(self x:)
								(self y:)
							)
							faucet
					)
				else
					(faucet cue:)
				)
			)
			(3 ; Do
				(cond
					(
						(and
							(== (gEgo view:) 131)
							(or (== (gEgo loop:) 0) (== (gEgo loop:) 1))
						)
						(Print 130 18) ; "NOW??"
					)
					((or (not (ObjInRoom 4)) (and (ObjInRoom 4) (not lookedSink)))
						(Print 130 23 #at -1 20) ; "You quickly wash your hands, then realize there are no paper towels."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sGetRing)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance graffiti of Feature
	(properties
		x 193
		y 58
		nsTop 27
		nsLeft 146
		nsBottom 90
		nsRight 240
		description {the walls}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 130 24 #at -1 20) ; "You quickly memorize some of the graffiti."
			)
			(2 ; Look
				(switch graffitiCount
					(0
						(Print 130 25 #at -1 140) ; "Lefty's restroom wall is filled with clever reading material; enough for you to read for a long, long time."
					)
					(1
						(Print 130 26 #at -1 140) ; "Scott me up, Beamie!"
					)
					(2
						(Print 130 27 #at -1 140) ; "Attention arcade game players: please don't eat the urinal cakes!"
					)
					(3
						(Print 130 28 #at -1 140) ; "It takes leather balls to play rugby!"
					)
					(else
						(Points 82 2)
						(Print 130 29 #at -1 140) ; "Say, here's an interesting one: "The password is: `Ken sent me.'""
						(if (ObjInRoom 17)
							(Print 130 30) ; "You decide to write it down and take it with you wherever you go. A guy never knows when a good password will come in handy!"
							(gEgo get: 17) ; graffiti
						)
					)
				)
				(++ graffitiCount)
			)
			(11 ; Taste/Smell
				(Print 130 31 #at -1 20) ; "Lefty must be running low on air freshener."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theHandle of Feature
	(properties
		x 193
		y 109
		z 28
		nsTop 78
		nsLeft 185
		nsBottom 85
		nsRight 201
		description {the flusher}
		sightAngle 40
		approachX 187
		approachY 113
		lookStr {This toilet has been provided with a handle for those customers of Lefty's sophisticated enough to understand its operation.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sFlood)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fartNoise of Sound
	(properties
		flags 1
		number 133
	)
)

