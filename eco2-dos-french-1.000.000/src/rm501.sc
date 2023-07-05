;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use Cibola)
(use RandCycle)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm501 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
)

(instance rm501 of Rm
	(properties
		noun 6
		picture 500
		style 10
		west 500
	)

	(method (init)
		(LoadMany rsVIEW 30 40 50 502 1009 500 515)
		(if (OneOf gPrevRoomNum 530 560 440 0 10) ; speedRoom
			(gEgo init: normalize: 510)
		else
			(gEgo init: normalize: 0)
		)
		(if (not (== (gGameSound1 number:) 522))
			(gGameSound1 fade:)
		)
		(gGameSound2 fade:)
		(super init:)
		(if (OneOf gPrevRoomNum 530 560 440 0 10) ; speedRoom
			(gEgo
				view: (if (OneOf gPrevRoomNum 0 10 440) 502 else 510) ; speedRoom
				loop: (if (OneOf gPrevRoomNum 0 10 440) 1 else 4) ; speedRoom
				cel: 0
				posn: 158 137
				setScale: 0
				scaleX: 128
				scaleY: 128
				scaleSignal: 0
			)
		else
			(gEgo
				posn: 59 118
				setScale: 0
				scaleX: 128
				scaleY: 128
				scaleSignal: 0
			)
		)
		(if (== gPrevRoomNum 500)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 83 127 67 140 67 144 105 160 159 161 159 150 193 150 204 155 264 156 260 140 237 139 197 124 182 128 168 126 148 116 120 122 88 117
						yourself:
					)
			)
		else
			(self
				addObstacle:
					(changePoly
						init: 83 127 67 140 67 144 105 160 160 161 264 156 260 140 237 139 197 124 182 128 168 126 148 116 120 122 88 117
						yourself:
					)
			)
		)
		(batCage init:)
		(door init:)
		(twoCrates addToPic:)
		(oneCrate addToPic:)
		(drums addToPic:)
		(sacks addToPic:)
		(table addToPic:)
		(theNextRoom addToPic:)
		(ceiling init: setOnMeCheck: 1 8)
		(floor init: setOnMeCheck: 1 16)
		(doorExit init: setOnMeCheck: 1 2)
		(wall init: setOnMeCheck: 1 4)
		(gKeyDownHandler addToFront: doorExit)
		(gMouseDownHandler addToFront: doorExit)
		(gKeyDownHandler addToFront: door)
		(gMouseDownHandler addToFront: door)
		(gKeyDownHandler addToFront: theNextRoom)
		(gMouseDownHandler addToFront: theNextRoom)
		((ScriptID 1059) setupTalker: 6) ; Paquita
		(switch gPrevRoomNum
			((OneOf gPrevRoomNum 530 560)
				(= local3 1)
				(Cibola timesCaptured: (+ (Cibola timesCaptured:) 1))
				(gGameSound1 number: 523 loop: -1 play: 127)
				(self setScript: sAdamCaught)
			)
			(440
				(carrot init:)
				(gGameSound1 number: 521 loop: -1 play: 127)
				(self setScript: sOpenSeq)
			)
			(500
				(if (not (== (gGameSound1 number:) 522))
					(gGameSound1 number: 522 loop: -1 play: 127)
				)
				(self setScript: sFromShackBedroom)
			)
			(else
				(carrot init:)
				(gGameSound1 number: 521 loop: -1 play: 127)
				(self setScript: sOpenSeq)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (gEgo view:) 510)
				(gEgo mover:)
				(== (gEgo cel:) 4)
			)
			(sLocalSound number: 500 loop: 1 play: 127)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: doorExit)
		(gMouseDownHandler delete: doorExit)
		(gKeyDownHandler delete: door)
		(gMouseDownHandler delete: door)
		(gKeyDownHandler delete: theNextRoom)
		(gMouseDownHandler delete: theNextRoom)
		(DisposeScript 956)
		(DisposeScript 505)
		((ScriptID 1009) setupTalker: 0) ; EgoTalker
		((ScriptID 1059) setupTalker: 0) ; Paquita
		(sLocalSound dispose:)
		(super dispose:)
	)
)

(instance sOpenSeq of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(batCage loop: 3 cel: 1)
				(cageMid init:)
				((ScriptID 1009) setupTalker: 6) ; EgoTalker
				((ScriptID 1059) setupTalker: 4) ; Paquita
				((ScriptID 1049) setupTalker: 8) ; Gonzales
				((ScriptID 1039) setupTalker: 2) ; Slaughter
				(= cycles 3)
			)
			(1
				(gEgo put: 0 put: 1 put: 2 put: 3 put: 4 put: 5) ; buckazoid, passport, E-corder, amulet
				(= ticks 120)
			)
			(2
				(door cel: 4)
				(slaughter
					init:
					posn: 67 116
					setCycle: Walk
					setLoop: Grooper
					setMotion: MoveTo 85 113 self
				)
			)
			(3
				(door setCycle: CT 5 1 self)
			)
			(4
				(doorTwo init: setCycle: CT 2 1 self)
				(door setCycle: CT 7 1 self)
			)
			(5)
			(6
				(door setPri: -1)
				(slaughter setMotion: MoveTo 105 120 self)
			)
			(7
				(door setCycle: CT 5 -1 self)
				(doorTwo setCycle: CT 0 -1 self)
			)
			(8)
			(9
				(doorTwo dispose:)
				(door setCycle: CT 2 -1 self)
				(slaughter setMotion: DPath 145 127 181 129 180 140 self)
			)
			(10
				(door setCycle: CT 4 1)
			)
			(11
				(gEgo setCel: 1)
				(door setPri: 8)
				(slaughter setHeading: 270 self)
			)
			(12
				(slaughter view: 509 loop: 0 cel: 0)
				(= cycles 1)
			)
			(13
				(gonzales
					init:
					setLoop: Grooper
					posn: 67 116
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 85 113 self
				)
			)
			(14
				(door setCycle: CT 5 1 self)
			)
			(15
				(doorTwo init: setCycle: CT 2 1 self)
				(door setCycle: CT 7 1 self)
			)
			(16)
			(17
				(door setPri: -1)
				(gonzales setMotion: MoveTo 105 120 self)
			)
			(18
				(door setCycle: CT 5 -1 self)
				(doorTwo setCycle: CT 0 -1 self)
			)
			(19)
			(20
				(doorTwo dispose:)
				(door setCycle: CT 2 -1 self)
				(gonzales setMotion: MoveTo 133 135 self)
			)
			(21
				(door setCycle: CT 4 1)
			)
			(22
				(gEgo setCycle: CT 0 -1)
				(gonzales setHeading: 90 self)
			)
			(23
				(gonzales view: 509 loop: 1 cel: 0)
				(= cycles 1)
			)
			(24
				(= seconds 3)
			)
			(25
				(gMessager say: 6 0 6 1 2 self) ; "I see you're awake. Good, that means we can have a little chat."
			)
			(26
				(slaughter view: 514 loop: 0 cel: 0 setCycle: End self)
			)
			(27
				(gMessager say: 6 0 6 3 4 self) ; "Don't get all tied up in knots, sonny -"
			)
			(28
				(slaughter setCycle: RandCycle)
				(= cycles 1)
			)
			(29
				(= seconds 2)
			)
			(30
				(gMessager say: 6 0 6 5 self) ; "Shut up, clown. The kid's about to tell me about the gold."
			)
			(31
				(slaughter setCycle: 0 view: 509 loop: 0 cel: 0)
				(gEgo setCycle: End self)
			)
			(32
				(= seconds 3)
			)
			(33
				(gMessager say: 6 0 7 1 2 self) ; "If you talk, maybe I'll cut you in."
			)
			(34
				(slaughter view: 514 loop: 0 setCycle: RandCycle)
				(= cycles 1)
			)
			(35
				(= seconds 2)
			)
			(36
				(gMessager say: 6 0 7 3 self) ; "I understand plenty! I'm not impressed."
			)
			(37
				(slaughter setCycle: 0 view: 509 loop: 0 cel: 0)
				(= cycles 1)
			)
			(38
				(gMessager say: 6 0 7 4 self) ; "He ain't impressed."
			)
			(39
				(slaughter view: 514 loop: 0 setCycle: RandCycle)
				(= cycles 1)
			)
			(40
				(= seconds 2)
			)
			(41
				(gMessager say: 6 0 7 5 self) ; "Shut up, you! Now talk, kid, if you know what's good for you."
			)
			(42
				(= seconds 2)
			)
			(43
				(slaughter setCycle: 0 view: 509 loop: 0 cel: 0)
				(= cycles 1)
			)
			(44
				(= seconds 3)
			)
			(45
				(gMessager say: 6 0 8 1 self) ; "We'll see what a day tied up in this sweat box will do for your tongue."
			)
			(46
				(slaughter view: 514 loop: 1 setSpeed: 4 setCycle: RandCycle)
				(= cycles 1)
			)
			(47
				(= seconds 3)
			)
			(48
				(slaughter setSpeed: 6 setCycle: 0 view: 509 loop: 0 cel: 0)
				(= cycles 1)
			)
			(49
				(gMessager say: 6 0 8 2 self) ; "I'm getting out of here and I'll be back tonight."
			)
			(50
				(= seconds 2)
			)
			(51
				(slaughter
					view: 30
					loop: 1
					setPri: -1
					setCycle: Walk
					setMotion: DPath 181 129 152 129 self
				)
			)
			(52
				(slaughter setHeading: 225 self)
				(gonzales view: 40 loop: 8 cel: 0 setHeading: 45 self)
			)
			(53)
			(54
				(slaughter view: 509 loop: 0 cel: 1)
				(gonzales view: 509 loop: 1 cel: 1)
				(= cycles 2)
			)
			(55
				(= seconds 2)
			)
			(56
				(gMessager say: 6 0 18 0 self) ; "Get that shipment of birds ready. They're worth big bucks from the pet stores."
			)
			(57
				(gonzales view: 40 loop: 6 cel: 0 heading: 45)
				(= cycles 1)
			)
			(58
				(gonzales setHeading: 135 self)
			)
			(59
				(gonzales view: 509 loop: 1 cel: 3)
				(= cycles 1)
			)
			(60
				(slaughter
					view: 30
					loop: 8
					cel: 5
					setMotion: DPath 145 127 85 117 self
				)
			)
			(61
				(door cel: 0 setCycle: CT 2 1)
				(slaughter setMotion: MoveTo 59 116 self)
			)
			(62
				(= cycles 1)
			)
			(63
				(door setCycle: CT 5 1 self)
			)
			(64
				(slaughter dispose:)
				(doorTwo init: setCycle: End self)
				(door setCycle: CT 7 1 self)
			)
			(65)
			(66
				(doorTwo setCycle: CT 0 -1)
				(door setCycle: CT 5 -1 self)
			)
			(67
				(doorTwo dispose:)
				(door setCycle: CT 4 -1 self)
			)
			(68
				(gGameSound1 fade: 30 1 2 1 self)
			)
			(69
				(gGameSound1 number: 523 loop: -1 play: 127)
				(gonzales view: 40 loop: 8 cel: 4 setLoop: Grooper)
				(gEgo setCel: 1)
				(= cycles 2)
			)
			(70
				(= ticks 6)
			)
			(71
				(door stopUpd:)
				(= seconds 2)
			)
			(72
				(gMessager say: 6 0 9 1 2 self) ; "Hey, how would you like a nice reward? Just untie me and my dad will take care of it."
			)
			(73
				(gonzales setMotion: DPath 133 148 164 175 self)
			)
			(74
				(gonzales setHeading: 135 self)
			)
			(75
				(gonzales setCycle: StopWalk -1)
				(= cycles 1)
			)
			(76
				(= cycles 1)
			)
			(77
				(= seconds 2)
			)
			(78
				(= cycles 2)
			)
			(79
				(gonzales
					view: 515
					loop: 0
					cel: 0
					setCycle: ForwardCounter 2 self
				)
			)
			(80
				(gMessager say: 6 0 9 3 self) ; "Nice little bat here. I've got a swell recipe for "Bat Stir-Fry." Yeah, that's sounding good to me."
			)
			(81
				(sLocalSound number: 503 loop: 1 play: 127)
				(gMessager say: 6 0 9 4 5 self) ; "Squeak!"
			)
			(82
				(gonzales view: 40 loop: 4 setHeading: 0 self)
			)
			(83
				(= cycles 1)
			)
			(84
				(= seconds 2)
			)
			(85
				(gMessager say: 6 0 9 6 self) ; "Get you! It's just a crummy bat. And what're you gonna do to stop me? Beat me up? HAHAHAHA! Man, that's a good one."
			)
			(86
				(gonzales
					setLoop: Grooper
					setCycle: Walk
					setMotion: DPath 138 154 110 133 self
				)
			)
			(87
				(gMessager say: 6 0 9 7 self) ; "You're a real humorist."
			)
			(88
				(gonzales setHeading: 135 self)
			)
			(89
				(gonzales view: 515 loop: 2 cel: 0 setCycle: RandCycle)
				(= cycles 1)
			)
			(90
				(= seconds 3)
			)
			(91
				(gonzales cel: 0 setCycle: CT 3 1 self)
			)
			(92
				(gonzales setCycle: End self)
			)
			(93
				(= ticks 20)
			)
			(94
				(gMessager say: 6 0 9 8 9 self) ; "Watch your smart mouth, runt. Or I'll do what Mr. Slaughter said and shove a gag in it."
			)
			(95
				(gonzales
					view: 40
					loop: 4
					setLoop: Grooper
					setCycle: Walk
					setMotion: MoveTo 90 120 self
				)
			)
			(96
				(door cel: 0 setCycle: CT 2 1)
				(gonzales setMotion: MoveTo 59 116 self)
			)
			(97
				(door setCycle: CT 5 1 self)
			)
			(98
				(gonzales dispose:)
				(doorTwo init: setCycle: End self)
				(door setCycle: CT 7 1 self)
			)
			(99)
			(100
				(doorTwo setCycle: CT 0 -1)
				(door setCycle: CT 5 -1 self)
			)
			(101
				(doorTwo dispose:)
				(door setCycle: CT 4 -1 self)
			)
			(102
				(gGameSound1 fade: 30 1 2 1 self)
			)
			(103
				(gGameSound1 number: 522 loop: -1 play: 127)
				(= seconds 2)
			)
			(104
				((ScriptID 1009) setupTalker: 6) ; EgoTalker
				((ScriptID 1059) setupTalker: 4) ; Paquita
				(gMessager say: 6 0 17 1 self) ; "Adam! Help me or that big oaf will throw me in his wok."
			)
			(105
				((ScriptID 1049) setupTalker: 0) ; Gonzales
				((ScriptID 1039) setupTalker: 0) ; Slaughter
				(gEgo normalize: 510 loop: 8 cel: 4 setCycle: StopWalk -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAdamPaquitaFreed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 510 setMotion: MoveTo 183 179 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(sLocalSound number: 716 loop: -1 play: 127)
				(gEgo
					view: 502
					loop: 0
					cel: 0
					setCycle: ForwardCounter 3 self
				)
			)
			(3
				(sLocalSound stop:)
				(gGame points: 5)
				(batCage view: 508 setLoop: 1 cel: 0 setCycle: CT 1 1 self)
				(gEgo setCel: 0)
			)
			(4
				(gEgo
					normalize:
					view: 510
					setLoop: 4
					setCycle: StopWalk -1
					setMotion: MoveTo 160 160 self
				)
			)
			(5
				(gEgo setLoop: -1 normalize: setHeading: 225 self)
			)
			(6
				(batCage setCycle: End self)
				(carrot dispose:)
				(cageMid dispose:)
			)
			(7
				(batCage view: 501 setLoop: 2)
				(paquita
					view: 50
					loop: 0
					cel: 0
					posn: 184 142
					init:
					setCycle: Fwd
					setMotion: MoveTo 138 123 self
				)
			)
			(8
				(proc0_5 paquita gEgo self)
			)
			(9
				(gCurRoom setScript: sPaquitaFreesAdam)
				(self dispose:)
			)
		)
	)
)

(instance sPaquitaFreesAdam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(changePoly dispose:)
				(paquita
					setPri: -1
					setMotion:
						DPath
						138
						123
						(+ (gEgo x:) 13)
						(- (gEgo y:) 21)
						self
				)
			)
			(1
				(= cycles 10)
			)
			(2
				(paquita setCycle: Fwd setHeading: 225 self)
			)
			(3
				(= cycles 1)
			)
			(4
				(= seconds 2)
			)
			(5
				(if local3
					(switch (Cibola timesCaptured:)
						(1
							(gMessager say: 6 0 21 0 self) ; "I do not think you should stay out in the open like that!"
						)
						(2
							(gMessager say: 6 0 22 0 self) ; "You know that Mean One, he spoke of making much money."
						)
						(4
							(if (gEgo has: 19)
								(self cue:)
							else
								(gMessager say: 6 0 24 0 self) ; "I have a plan, me! I believe you must let the birds go! But you must quiet them with food first. They sound hungry!"
							)
						)
						(5
							(if (gEgo has: 19)
								(self cue:)
							else
								(gMessager say: 6 0 25 0 self) ; "I saw one of those, you know, man things, on the platform. I believe you could get the seed with that!"
							)
						)
						(6
							(gMessager say: 6 0 26 0 self) ; "When you have the grain, you must sneak over oh so quietly! Perhaps you should wait till the Big One reads his book. Then you can feed the small birds and unlock the cage. Ha!"
						)
						(else
							(self cue:)
						)
					)
				else
					(gMessager say: 6 0 12 0 self) ; "What are you going to do?"
				)
			)
			(6
				(= seconds 5)
			)
			(7
				(= local2 1)
				(gEgo view: 0 normalize:)
				(chair posn: 170 135 init:)
				(gCurRoom
					addObstacle:
						(changePoly
							type: PContainedAccess
							init: 83 127 67 140 67 144 105 160 159 161 159 150 193 150 204 155 264 156 260 140 237 139 197 124 182 128 168 126 148 116 120 122 88 117
							yourself:
						)
				)
				(= ticks 6)
			)
			(8
				(= cycles 1)
			)
			(9
				(paquita
					ignoreActors: 1
					setPri: 15
					setMotion: MoveTo 201 33 self
				)
			)
			(10
				(paquita
					posn: 201 45
					view: 52
					loop: 0
					cel: 0
					setPri: -1
					setCycle: End self
				)
				(= local1 1)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterShackBedroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 1009) setupTalker: 6) ; EgoTalker
				((ScriptID 1059) setupTalker: 4) ; Paquita
				(gEgo setMotion: MoveTo 86 121 self)
			)
			(1
				(if (OneOf gPrevRoomNum 440 0 10) ; speedRoom
					(gMessager say: 6 0 16 1 self) ; "Wait for me! It is too creepy in here!"
				else
					(self cue:)
				)
			)
			(2
				(if (gCast contains: paquita)
					(paquita setScript: sFollowAdam)
				)
				(= cycles 10)
			)
			(3
				(door cel: 0 setCycle: CT 2 1)
				(gEgo setMotion: MoveTo 59 116 self)
			)
			(4
				(= cycles 1)
			)
			(5
				(door setCycle: CT 5 1 self)
			)
			(6
				(doorTwo init: setCycle: End self)
				(door setCycle: CT 7 1 self)
			)
			(7)
			(8
				(doorTwo setCycle: CT 0 -1)
				(door setCycle: CT 5 -1 self)
			)
			(9
				(doorTwo dispose:)
				(door setCycle: CT 4 -1 self)
			)
			(10
				(gCurRoom newRoom: 500)
				(self dispose:)
			)
		)
	)
)

(instance sFollowAdam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local1
					(paquita setCycle: Beg self)
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				(paquita posn: 201 33 view: 50)
				(= local1 0)
				(= cycles 2)
			)
			(2
				(paquita setCycle: Fwd setMotion: DPath 91 74 61 66)
			)
		)
	)
)

(instance sBumpDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize: 510
					setCycle: Walk
					setMotion: MoveTo 98 121 self
				)
			)
			(1
				(gMessager say: 7 4 4 0 self) ; "Ouch!"
			)
			(2
				(gEgo setLoop: setMotion: MoveTo 108 124 self)
			)
			(3
				(gEgo normalize: 510)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAdamCaught of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 1049) setupTalker: 8) ; Gonzales
				((ScriptID 1009) setupTalker: 6) ; EgoTalker
				((ScriptID 1059) setupTalker: 4) ; Paquita
				(batCage loop: 3 cel: 0)
				(cageMid init:)
				(gonzales
					posn: 144 134
					view: 515
					loop: 1
					cel: 0
					init:
					setCycle: ForwardCounter 5 self
				)
			)
			(1
				(gonzales loop: 2 cel: 0 setCycle: RandCycle)
				(= cycles 2)
			)
			(2
				(= seconds 2)
			)
			(3
				(gonzales setCycle: End self)
			)
			(4
				(gMessager say: 6 0 14 1 self) ; "Stay put, kid. Or you'll find out why they call him "Maximum" Slaughter. Heh-heh."
			)
			(5
				(door setPri: -1)
				(gonzales
					view: 40
					setLoop: Grooper
					setCycle: Walk
					setMotion: DPath 110 133 90 120 self
				)
			)
			(6
				(door cel: 0 setCycle: CT 2 1)
				(gonzales setMotion: MoveTo 59 116 self)
			)
			(7
				(= cycles 1)
			)
			(8
				(door setCycle: CT 5 1 self)
			)
			(9
				(gonzales dispose:)
				(doorTwo init: setCycle: End self)
				(door setCycle: CT 7 1 self)
			)
			(10)
			(11
				(doorTwo setCycle: CT 0 -1)
				(door setCycle: CT 5 -1 self)
			)
			(12
				(doorTwo dispose:)
				(door setCycle: Beg self)
			)
			(13
				(gGameSound1 fade: 30 1 2 1 self)
			)
			(14
				(gGameSound1 number: 522 loop: -1 play: 127)
				(= seconds 2)
			)
			(15
				(if (gCurrentRegionFlags test: 0)
					(self cue:)
				else
					(gCurrentRegionFlags set: 0)
					(gMessager say: 6 0 14 2 self) ; "Psst! Adam, he's gone."
				)
			)
			(16
				(gEgo setMotion: MoveTo 160 160 self)
			)
			(17
				(= local0 1)
				(batCage view: 508 setLoop: 0 setCel: 1 setCycle: End self)
				(cageMid dispose:)
			)
			(18
				(batCage view: 501 setLoop: 2)
				(paquita
					view: 50
					loop: 0
					cel: 0
					posn: 184 142
					init:
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(19
				(if (== (Cibola timesCaptured:) 1)
					(gMessager say: 6 0 11 0 self) ; "Ha! That big one did not even notice the latch was open. Now I shall free you and you can try again!"
				else
					(self cue:)
				)
			)
			(20
				(paquita setMotion: MoveTo 78 123 self)
			)
			(21
				(gEgo setHeading: 225 self)
				(proc0_5 paquita gEgo self)
			)
			(22)
			(23
				(gCurRoom setScript: sPaquitaFreesAdam)
				(self dispose:)
			)
		)
	)
)

(instance sFromShackBedroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 1009) setupTalker: 6) ; EgoTalker
				((ScriptID 1059) setupTalker: 4) ; Paquita
				(= local2 1)
				(= local0 1)
				(chair init:)
				(gEgo setMotion: MoveTo 85 113 self)
			)
			(1
				(door cel: 4 setCycle: CT 5 1 self)
			)
			(2
				(doorTwo init: setCycle: CT 2 1 self)
				(door setCycle: CT 7 1 self)
			)
			(3)
			(4
				(door setPri: -1)
				(gEgo setMotion: MoveTo 105 120 self)
			)
			(5
				(door setCycle: CT 5 -1 self)
				(doorTwo setCycle: CT 0 -1 self)
			)
			(6)
			(7
				(doorTwo dispose:)
				(door setCycle: CT 2 -1 self)
				(gEgo setMotion: MoveTo 125 145 self)
			)
			(8)
			(9
				(door setCycle: CT 4 1 self)
			)
			(10
				(if (gCurrentRegionFlags test: 14)
					(++ state)
					(self cue:)
				else
					(paquita
						view: 50
						posn: 61 66
						init:
						setCycle: Walk
						setPri: 7
						setSpeed: 2
						setMotion: DPath 91 74 201 33 self
					)
				)
			)
			(11
				(paquita
					posn: 201 45
					view: 52
					loop: 0
					cel: 0
					setCycle: End self
				)
				(= local1 1)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slaughter of Actor
	(properties
		x 67
		y 116
		view 30
		loop 4
		signal 16384
	)
)

(instance gonzales of Actor
	(properties
		x 96
		y 130
		view 40
		loop 2
		cel 2
		signal 16384
	)
)

(instance paquita of Actor
	(properties
		x 204
		y 144
		noun 8
		yStep 4
		view 52
		cel 7
		priority 14
		signal 16400
		scaleSignal 5
		scaleX 93
		scaleY 93
		cycleSpeed 2
		xStep 6
		moveSpeed 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 36))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 36))
			(if (== theVerb 2) ; Talk
				(if local0
					(gMessager say: 8 2 15 1) ; "Hurry, Adam! Time is passing and the boss one will come back!"
				else
					(switch local4
						(1
							(gMessager say: 8 2 10 1) ; "I'm so scared, Adam! You've got to get us out of here, or that big ape is going to turn me into Today's Special."
							(++ local4)
						)
						(2
							(gMessager say: 8 2 10 2) ; "I can't think straight. Bats aren't too awake in the daytime. You'll have to think of something. But hurry!"
							(++ local4)
						)
						(else
							(gMessager say: 8 2 10 3) ; "Please get me out of here before that big guy comes back!"
						)
					)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance batCage of Prop
	(properties
		x 236
		y 162
		noun 3
		view 501
		loop 2
		priority 15
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 188 134 191 136 203 126 205 126 204 123 205 122 208 123 208 125 208 128 224 136 226 133 231 136 225 140 225 156 237 163 209 163 170 163 170 159 188 154 188 145 189 140 184 135
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local0
					(gMessager say: 3 4 3 1) ; "Paquita has been set free. There's no need to fiddle with the cage."
				else
					(= local0 1)
					(gCurRoom setScript: sAdamPaquitaFreed)
				)
			)
			(1 ; Look
				(if local0
					(gMessager say: 3 1 3 1) ; "Paquita's prison is empty."
				else
					(gMessager say: 3 1 1 1) ; "Paquita hangs droopily inside the bird cage."
				)
			)
			(2 ; Talk
				(if (not local0)
					(paquita doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cageMid of View
	(properties
		x 257
		y 161
		noun 3
		view 501
		loop 6
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(batCage doVerb: theVerb)
	)
)

(instance door of Prop
	(properties
		x 86
		y 51
		noun 7
		view 501
		loop 1
		priority 8
		signal 16400
	)

	(method (handleEvent event)
		(if
			(and
				(OneOf ((ScriptID 0 9) cel:) 0 2) ; eco2Cursor
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(not (& (event modifiers:) emSHIFT))
						(not (& (event modifiers:) emCTRL))
					)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(if (door onMe: event)
				(if (and local2 (not (gCurRoom script:)))
					(event claimed: 1)
					(gCurRoom setScript: sEnterShackBedroom)
				else
					(gCurRoom setScript: sBumpDoor)
					(event claimed: 1)
				)
				(super handleEvent: event)
			else
				0
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance doorTwo of Prop
	(properties
		x 69
		y 65
		noun 7
		view 501
		loop 5
		priority 14
		signal 16400
	)
)

(instance twoCrates of View
	(properties
		x 56
		y 130
		noun 1
		view 507
		loop 2
		priority 15
		signal 20497
	)
)

(instance oneCrate of View
	(properties
		x 231
		y 162
		noun 1
		view 507
		cel 2
		priority 13
		signal 20497
	)
)

(instance drums of View
	(properties
		x 267
		y 162
		noun 15
		view 507
		cel 1
		priority 15
		signal 20497
	)
)

(instance chair of View
	(properties
		x 170
		y 135
		noun 4
		view 501
		priority 12
		signal 20497
	)
)

(instance sacks of View
	(properties
		x 149
		y 116
		noun 5
		view 507
		priority 1
		signal 20497
	)
)

(instance table of View
	(properties
		x 214
		y 126
		noun 2
		view 507
		loop 1
		priority 5
		signal 20497
	)
)

(instance theNextRoom of View
	(properties
		x 107
		y 106
		noun 7
		view 507
		loop 3
		cel 1
		signal 16401
	)

	(method (handleEvent event)
		(if
			(and
				(OneOf ((ScriptID 0 9) cel:) 0 2) ; eco2Cursor
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(not (& (event modifiers:) emSHIFT))
						(not (& (event modifiers:) emCTRL))
					)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(if (theNextRoom onMe: event)
				(if (and local2 (not (gCurRoom script:)))
					(event claimed: 1)
					(gCurRoom setScript: sEnterShackBedroom)
				else
					(gCurRoom setScript: sBumpDoor)
					(event claimed: 1)
				)
				(super handleEvent: event)
			else
				0
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance ceiling of Feature
	(properties
		x 197
		y 46
		noun 13
		onMeCheck 8
	)
)

(instance floor of Feature
	(properties
		x 157
		y 120
		noun 11
		onMeCheck 16
	)
)

(instance doorExit of Feature
	(properties
		x 88
		y 97
		noun 7
		onMeCheck 2
	)

	(method (handleEvent event)
		(if
			(and
				(OneOf ((ScriptID 0 9) cel:) 0 2) ; eco2Cursor
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(not (& (event modifiers:) emSHIFT))
						(not (& (event modifiers:) emCTRL))
					)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(if (doorExit onMe: event)
				(if (and local2 (not (gCurRoom script:)))
					(event claimed: 1)
					(gCurRoom setScript: sEnterShackBedroom)
				else
					(gCurRoom setScript: sBumpDoor)
					(event claimed: 1)
				)
				(super handleEvent: event)
			else
				0
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance wall of Feature
	(properties
		x 202
		y 44
		noun 12
		onMeCheck 4
	)
)

(instance carrot of Feature
	(properties
		x 100
		y 163
		noun 18
		nsTop 147
		nsLeft 179
		nsBottom 156
		nsRight 202
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local0 1)
			(gCurRoom setScript: sAdamPaquitaFreed)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance changePoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance sLocalSound of Sound
	(properties)
)

