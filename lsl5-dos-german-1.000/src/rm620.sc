;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm620 0
)

(local
	guardStatus
	datamanSolution
	faxSolution
	wrongDataman
	wrongFax
)

(instance rm620 of LLRoom
	(properties
		picture 620
		north 640
		south 600
	)

	(method (init)
		(switch gPrevRoomNum
			(south
				(gEgo init: normalize: 570 x: 92)
				(gTheMusic number: 620 flags: 1 setLoop: -1 play:)
			)
			(north
				(gEgo init: normalize: 570 setPri: 8 posn: 57 141)
				(SetFlag 29)
				(gCurRoom setScript: sExitElevator)
			)
			(else
				(gEgo init: normalize: 570 posn: 160 160 edgeHit: 0)
				(gTheMusic number: 620 flags: 1 setLoop: -1 play:)
			)
		)
		(LoadMany rsPIC 630)
		(LoadMany rsSOUND 621 622)
		(super init:)
		(board init: approachVerbs: 2 3 4) ; Look, Do, Inventory
		(guard init: approachVerbs: 5 4 3) ; Talk, Inventory, Do
		(elevator init: approachVerbs: 3 4) ; Do, Inventory
		(elevatorLeft init: approachVerbs: 3 4) ; Do, Inventory
		(plant init:)
		(mural init:)
		(fStairs init:)
		(fLamp1 init:)
		(fLamp2 init:)
		(fAshtray init: approachVerbs: 2 3) ; Look, Do
		(sconceA init:)
		(sconceB init:)
		(clock init:)
		(breasts init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 123 189 123 187 313 187 313 159 224 159 203 155 198 145 197 137 209 130 313 130 313 116 136 116 132 119 122 120 114 120 61 150 61 151 62 158 58 163 51 164 16 189 0 189
					yourself:
				)
		)
		(HandsOn)
	)

	(method (doit)
		(if (and (gEgo edgeHit:) (== guardStatus 1))
			(= guardStatus 0)
			(guard setLoop: 0 setCel: 0 cycleSpeed: 30 setCycle: End self)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(1 ; Walk
					(if (== curPic 630)
						(gCurRoom setScript: sReturnsFromBoard)
						1
					)
				)
				(2 ; Look
					(if (== curPic 630)
						(TPrint 620 0) ; "You are staring at the Shill Building's lobby directory. Evidently, the building's management ran short of those little push-in letters."
					else
						(TPrint 620 1) ; "The lobby of the Shill Building is very elegant. A wonderful mural covers the vast rear wall. A sleepy guard "works" at a security counter."
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (not (== newRoomNumber 640))
			(gTheMusic fade: 0 15 12 1)
		)
	)
)

(instance sExitElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(elevatorDing play:)
				(= cycles 10)
			)
			(2
				(elevatorDoor play:)
				(elevatorLeft setCycle: End)
				(elevator setCycle: End self)
			)
			(3
				(elevatorDoor stop:)
				(gEgo setMotion: MoveTo 89 150 self)
			)
			(4
				(= seconds 2)
			)
			(5
				(gEgo setPri: -1)
				(elevatorDoor play:)
				(elevatorLeft setCycle: Beg)
				(elevator setCycle: Beg self)
			)
			(6
				(elevatorDoor stop:)
				(elevator stopUpd: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGuardWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard
					setLoop: 0
					setCel: (guard lastCel:)
					cycleSpeed: 12
					setCycle: Beg self
				)
			)
			(1
				(= guardStatus 1)
				(Say The_Guard_GDer_W_chter 620 2 108) ; "Yes?" mumbles the sleepy guard, "You need somethin'?"
				(HandsOn)
				(Delay 6 2 self)
			)
			(2
				(HandsOff)
				(guard setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(HandsOn)
				(guard setScript: sSleeping)
				(= guardStatus 0)
				(self dispose:)
			)
		)
	)
)

(instance sGuardSleeps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= guardStatus 0)
				(TPrint 620 3) ; "As you begin to speak, you realize you don't know the room number of Reverse Biaz's office."
				(Say gEgo 620 4) ; "Nice outfit you're wearing, Mister!"
				(self cue:)
			)
			(1
				(Say The_Guard_GDer_W_chter 620 5 108) ; "Honey, if you don't know where you're going, how am I supposed to know?"
				(guard setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(guard setScript: sSleeping)
				(= guardStatus 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGuardApproves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					(datamanSolution
						(Say gEgo 620 6) ; "Excuse me," you say to the sleepy guard, "Would you please direct me to the offices shown on this LCD readout?"
					)
					(faxSolution
						(Say gEgo 620 7) ; "Excuse me, Sir," you say to the nappy guard, "I can see you're quite busy, but could you help me find the office shown on the fax?"
					)
					(wrongDataman
						(Say gEgo 620 8) ; "Excuse me," you say to the narcoleptic guard, "Would you please direct me to the office shown on this LCD readout?"
					)
					(wrongFax
						(Say gEgo 620 9) ; "Excuse me, Sir," you say to the worn-out guard, "I can see you're quite busy, but could you help me find the office shown on this fax?"
					)
					(else
						(Say gEgo 620 10) ; "Excuse me," you say to the well-rested guard. "I'm here to see Mr. Biaz in Room 900."
					)
				)
				(self cue:)
			)
			(1
				(cond
					((IsFlag 45)
						(Say The_Guard_GDer_W_chter 620 11 108) ; "Lady, I already told you: Reverse Biaz says, `you blew the gig when you split'--whatever that means!"
						(HandsOn)
						(guard setScript: sBackToSleep)
						(self dispose:)
					)
					(datamanSolution
						(Say The_Guard_GDer_W_chter 620 12 108) ; "Hey, pretty cool! I was thinkin' about gettin' one of these for the little missus! Now, let's see... `Biaz?' `Suite 900?' Sure, no problem. I'll summon the elevator for you right now!"
						(= datamanSolution 0)
						(Points 6 118)
					)
					(wrongDataman
						(Say The_Guard_GDer_W_chter 620 13 108) ; "Hey, pretty cool! I was thinkin' about gettin' one of these for the little missus! Now, let's see... `P. C. Hammer?' I'm sorry, but there's nobody by that name in this building."
						(= wrongDataman 0)
						(HandsOn)
						(guard setScript: sBackToSleep)
						(self dispose:)
					)
					(faxSolution
						(Say The_Guard_GDer_W_chter 620 14 108) ; "Kinda flimsy paper, ain't it? Well, let's see here... You know, it's hard to read this stuff; the text is all fuzzy-looking. Oh, here it is... `Biaz?' Why, he's in Suite 900. Sure, no problem. I'll summon the elevator for you right now!"
						(= faxSolution 0)
						(Points 6 119)
					)
					(wrongFax
						(Say The_Guard_GDer_W_chter 620 15 108) ; "Kinda flimsy paper, ain't it? Well, let's see here... You know, it's hard to read this stuff; the text is all fuzzy-looking. Hmm... `P. C. Hammer?' Nah, they only let us use screwdrivers and pliers on the computers here!"
						(= wrongFax 0)
						(HandsOn)
						(guard setScript: sBackToSleep)
						(self dispose:)
					)
					(else
						(Say The_Guard_GDer_W_chter 620 16 108) ; ""Huh? Oh, right. Give me just a second while I make sure he's in," sighs the overworked guard."
						(SetFlag 48)
					)
				)
				(self cue:)
			)
			(2
				(guard cycleSpeed: 12 setLoop: 5 setCel: 0 setCycle: End self)
			)
			(3
				(guard setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(guard setLoop: 4 setCel: 0 setCycle: ForwardCounter 2 self)
			)
			(5
				(= seconds 2)
			)
			(6
				(guard setLoop: 3 setCel: (guard lastCel:) setCycle: Beg self)
			)
			(7
				(guard setLoop: 5 setCycle: End self)
			)
			(8
				(if (IsFlag 21)
					(Say The_Guard_GDer_W_chter 620 17 108) ; "I'm sorry, but he says he's found someone else. Take a hike!"
					(SetFlag 45)
					(HandsOn)
					(guard setScript: sBackToSleep)
					(self dispose:)
				else
					(Say The_Guard_GDer_W_chter 620 18 108) ; "Okay, honey. He's waiting for you upstairs. I'm calling for the elevator for you right now."
					(guard
						cycleSpeed: 18
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				)
			)
			(9
				(guard setScript: sSleeping)
				(= seconds 3)
			)
			(10
				(elevatorDing play:)
				(= cycles 10)
			)
			(11
				(elevator setCycle: End self)
				(elevatorLeft setCycle: End)
				(elevatorDoor play:)
			)
			(12
				(elevatorDoor stop:)
				(gEgo setMotion: MoveTo 96 146 self)
			)
			(13
				(gEgo setPri: 9 setMotion: MoveTo 58 136 self)
			)
			(14
				(gEgo setHeading: 180 self)
			)
			(15
				(elevatorDoor play:)
				(elevator setCycle: Beg self)
				(elevatorLeft setCycle: Beg)
			)
			(16
				(elevatorDoor stop:)
				(gCurRoom newRoom: 640)
				(self dispose:)
			)
		)
	)
)

(instance sUsesBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gTheIconBar disable: 8)
				(gCast eachElementDo: #hide)
				(plant dispose:)
				(mural dispose:)
				(fStairs dispose:)
				(fLamp1 dispose:)
				(fLamp2 dispose:)
				(fAshtray dispose:)
				(sconceA dispose:)
				(sconceB dispose:)
				(clock dispose:)
				(breasts dispose:)
				(businessOne init:)
				(businessTwo init:)
				(businessThree init:)
				(businessFour init:)
				(businessFive init:)
				(businessSix init:)
				(businessSeven init:)
				(businessEight init:)
				(gCurRoom drawPic: 630)
				(SetupExit 1)
				(Display 620 19 dsCOORD 86 67 dsCOLOR gColWhite dsFONT gSmallFont) ; "allowe   Supplies    827"
				(Display 620 20 dsCOORD 88 79 dsCOLOR gColWhite dsFONT gSmallFont) ; "Hell  Industries      301"
				(Display 620 21 dsCOORD 88 91 dsCOLOR gColWhite dsFONT gSmallFont) ; "uck You          702"
				(Display 620 22 dsCOORD 89 103 dsCOLOR gColWhite dsFONT gSmallFont) ; "des Rever Records     900"
				(Display 620 23 dsCOORD 90 115 dsCOLOR gColWhite dsFONT gSmallFont) ; "Shi  Heads        400"
				(Display 620 24 dsCOORD 90 127 dsCOLOR gColWhite dsFONT gSmallFont) ; "AeroDork Corp.       501"
				(Display 620 25 dsCOORD 92 139 dsCOLOR gColWhite dsFONT gSmallFont) ; "Big Butt  s Inc.     251"
				(Display 620 26 dsCOORD 93 151 dsCOLOR gColWhite dsFONT gSmallFont) ; "Hard Di k Service    601"
				(board dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sReturnsFromBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar enable: 8)
				(gCurRoom drawPic: (gCurRoom picture:))
				(gCast eachElementDo: #show)
				(businessOne dispose:)
				(businessTwo dispose:)
				(businessThree dispose:)
				(businessFour dispose:)
				(businessFive dispose:)
				(businessSix dispose:)
				(businessSeven dispose:)
				(businessEight dispose:)
				(plant init:)
				(mural init:)
				(fStairs init:)
				(fLamp1 init:)
				(fLamp2 init:)
				(fAshtray init:)
				(sconceA init:)
				(sconceB init:)
				(clock init:)
				(breasts init:)
				(board init: approachVerbs: 2 3 4) ; Look, Do, Inventory
				(SetupExit 0)
			)
		)
	)
)

(instance sBackToSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= guardStatus 0)
				(guard setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(guard setScript: sSleeping)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sSleeping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard setLoop: 1 setCel: 0 cycleSpeed: 30 setCycle: End self)
			)
			(1
				(= cycles 20)
			)
			(2
				(guard setCycle: Beg self)
			)
			(3
				(= cycles 20)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance guard of Prop
	(properties
		x 274
		y 124
		description {the guard}
		sightAngle 40
		approachX 244
		approachY 166
		view 622
		loop 1
		priority 11
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(if (== guardStatus 0)
					(guard setScript: sGuardWakes)
				else
					(ll5Timer dispose: delete:)
					(if (IsFlag 17)
						(gCurRoom setScript: sGuardApproves)
					else
						(guard setScript: sGuardSleeps)
					)
				)
			)
			(4 ; Inventory
				(if (== guardStatus 1)
					(ll5Timer dispose: delete:)
					(switch invItem
						(0 ; Camcorder
							(cond
								((== ((Inv at: 0) state:) 1) ; Camcorder
									(= datamanSolution 1)
									(gCurRoom setScript: sGuardApproves)
								)
								((== ((Inv at: 0) state:) 2) ; Camcorder
									(= wrongDataman 1)
									(gCurRoom setScript: sGuardApproves)
								)
								(else
									(Say The_Guard_GDer_W_chter 620 27 108) ; "I'm sorry, lady, but that don't mean nothing to me."
									(guard setScript: sBackToSleep)
								)
							)
						)
						(3 ; A_Blank_Videotape_b
							(= faxSolution 1)
							(gCurRoom setScript: sGuardApproves)
						)
						(7 ; AeroDork_Gold_Card
							(= wrongFax 1)
							(gCurRoom setScript: sGuardApproves)
						)
						(else
							(super doVerb: theVerb invItem &rest)
							(guard setScript: sBackToSleep)
						)
					)
				else
					(TPrint 620 28) ; "Aren't guards just so precious when they're asleep?"
				)
			)
			(2 ; Look
				(if (== guardStatus 0)
					(TPrint 620 29) ; "The guard is sleeping on the job."
				else
					(TPrint 620 30) ; "The guard would prefer to be sleeping on the job."
				)
			)
			(3 ; Do
				(if (== guardStatus 1)
					(Say The_Guard_GDer_W_chter 620 31 108) ; "Oh, Ma'am," sighs the guard, "that feels good!"
				else
					(TPrint 620 32) ; "The guard grumbles under his breath and goes back to sleep."
				)
			)
			(10 ; Zipper
				(TPrint 620 33) ; "Geez, Patti! Try to trim back that attitude, okay?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(self setScript: sSleeping)
	)
)

(instance elevator of Prop
	(properties
		x 61
		y 148
		description {the elevator}
		sightAngle 40
		view 620
		priority 4
		signal 16401
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 34) ; "An elevator awaits you. But how do you access it? There are no buttons on the wall."
			)
			(3 ; Do
				(TPrint 620 35) ; "You push your hand against the elevator door, but it does no good. And there are no buttons nearby to push."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance elevatorLeft of Prop
	(properties
		x 45
		y 152
		description {the elevator}
		sightAngle 40
		view 620
		loop 1
		priority 9
		signal 16401
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(elevator doVerb: theVerb invItem &rest)
	)
)

(instance elevatorDing of Sound
	(properties
		number 621
	)
)

(instance elevatorDoor of Sound
	(properties
		number 622
	)
)

(instance board of Feature
	(properties
		x 10
		y 131
		nsTop 98
		nsLeft 9
		nsBottom 165
		nsRight 38
		description {the Shill Building's directory}
		sightAngle 40
		approachX 61
		approachY 178
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: sUsesBoard)
			)
			(3 ; Do
				(gCurRoom setScript: sUsesBoard)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance businessOne of Feature
	(properties
		x 157
		y 71
		nsTop 66
		nsLeft 93
		nsBottom 76
		nsRight 221
		description {the directory}
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(TPrint 620 36 67 -1 28) ; "Halloween Supplies is Baltimore's largest local supplier of Halloween goods and party supplies."
				)
				(1 ; Walk
					(gCurRoom setScript: sReturnsFromBoard)
					1
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance businessTwo of Feature
	(properties
		x 156
		y 82
		nsTop 78
		nsLeft 92
		nsBottom 86
		nsRight 221
		description {the directory}
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(TPrint 620 37 67 -1 28) ; "Hello Industries is one of the world's leading producers of greeting cards."
				)
				(1 ; Walk
					(gCurRoom setScript: sReturnsFromBoard)
					1
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance businessThree of Feature
	(properties
		x 154
		y 94
		nsTop 90
		nsLeft 86
		nsBottom 99
		nsRight 223
		description {the directory}
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(TPrint 620 38 67 -1 28) ; "Duck Youth is a wonderful public service organization that specializes in familiarizing inner-city youngsters with all varieties of barnyard and aquatic fowl."
				)
				(1 ; Walk
					(gCurRoom setScript: sReturnsFromBoard)
					1
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance businessFour of Feature
	(properties
		x 153
		y 106
		nsTop 102
		nsLeft 85
		nsBottom 111
		nsRight 222
		description {the directory}
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(SetFlag 17)
					(Points 3 120)
					(TPrint 620 39 67 -1 28) ; "That's it, Patti! "des Rever Records" is located in Room 900."
				)
				(3 ; Do
					(SetFlag 17)
					(Points 3 120)
					(TPrint 620 39 67 -1 28) ; "That's it, Patti! "des Rever Records" is located in Room 900."
				)
				(1 ; Walk
					(gCurRoom setScript: sReturnsFromBoard)
					1
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance businessFive of Feature
	(properties
		x 155
		y 118
		nsTop 114
		nsLeft 88
		nsBottom 123
		nsRight 222
		description {the directory}
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(TPrint 620 40 67 -1 28) ; "Ship Heads, Inc. provides the finest commodes available for ocean-going vessels."
				)
				(1 ; Walk
					(gCurRoom setScript: sReturnsFromBoard)
					1
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance businessSix of Feature
	(properties
		x 155
		y 130
		nsTop 126
		nsLeft 87
		nsBottom 135
		nsRight 224
		description {the directory}
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(TPrint 620 41 67 -1 28) ; "AeroDork is a very high-class airline. So high-class their offices are forbidden to the public."
				)
				(1 ; Walk
					(gCurRoom setScript: sReturnsFromBoard)
					1
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance businessSeven of Feature
	(properties
		x 156
		y 142
		nsTop 138
		nsLeft 89
		nsBottom 147
		nsRight 224
		description {the directory}
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(TPrint 620 42) ; "Big Buttons, Inc. supplies buttons of all sizes for every occasion: political campaigns, birthday parties, fund raisers, software company identification, etc."
				)
				(1 ; Walk
					(gCurRoom setScript: sReturnsFromBoard)
					1
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance businessEight of Feature
	(properties
		x 156
		y 154
		nsTop 150
		nsLeft 89
		nsBottom 159
		nsRight 223
		description {the directory}
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(TPrint 620 43 67 -1 28) ; "Hard Disk Services can handle all of your computer hardware needs--from correcting corrupted database files to undeleting sensitive information, to recovering formatted hard drives."
				)
				(1 ; Walk
					(gCurRoom setScript: sReturnsFromBoard)
					1
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 120
		y 95
		nsTop 36
		nsLeft 104
		nsBottom 114
		nsRight 137
		description {the plant}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 44) ; "This plant is obviously well-maintained, but superfluous to your mission."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mural of Feature
	(properties
		x 230
		y 47
		nsLeft 142
		nsBottom 95
		nsRight 319
		description {the mural}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 45) ; "It is quite an interesting mural."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fStairs of Feature
	(properties
		x 229
		y 164
		nsTop 139
		nsLeft 139
		nsBottom 189
		nsRight 319
		description {the staircase}
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 46) ; "A staircase winds its way upwards, but a velvet rope across the bottom indicates it's not to be used under penalty of law. It looks like the elevator is your only hope, Patti."
			)
			(3 ; Do
				(TPrint 620 47) ; "Since the staircase is presently being renovated, you are unable to use it. Besides, you know how much you hate climbing stairs in heels!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fLamp1 of Feature
	(properties
		x 131
		y 163
		nsTop 139
		nsLeft 124
		nsBottom 188
		nsRight 138
		description {the lamp}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 48) ; "A lovely Art Deco lamp rises above the staircase."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fLamp2 of Feature
	(properties
		x 294
		y 118
		nsTop 98
		nsLeft 287
		nsBottom 138
		nsRight 302
		description {the lamp}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 48) ; "A lovely Art Deco lamp rises above the staircase."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fAshtray of Feature
	(properties
		x 51
		y 150
		nsTop 141
		nsLeft 46
		nsBottom 160
		nsRight 56
		description {the ashtray}
		sightAngle 40
		approachX 70
		approachY 160
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 49) ; "Carefully examining the ashtray for a disco pass, for a brief moment you think you're playing "Leisure Suit Larry 1: In the Land of the Lounge Lizards." Of course, you're not."
			)
			(3 ; Do
				(TPrint 620 49) ; "Carefully examining the ashtray for a disco pass, for a brief moment you think you're playing "Leisure Suit Larry 1: In the Land of the Lounge Lizards." Of course, you're not."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sconceA of Feature
	(properties
		x 21
		y 81
		nsTop 77
		nsLeft 5
		nsBottom 86
		nsRight 37
		description {the sconce}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 50) ; "My, the Shill Building has tasteful sconces."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sconceB of Feature
	(properties
		x 94
		y 71
		nsTop 69
		nsLeft 85
		nsBottom 74
		nsRight 103
		description {the sconce}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 50) ; "My, the Shill Building has tasteful sconces."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance clock of Feature
	(properties
		x 230
		y 112
		nsTop 107
		nsLeft 215
		nsBottom 125
		nsRight 245
		description {the clock}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 51) ; "A lovely Deco time clock is built into the end of the Security Guard's counter for those employees still paid by the hour."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance breasts of Feature
	(properties
		x 191
		y 199
		z 80
		nsTop 34
		nsLeft 182
		nsBottom 44
		nsRight 201
		description {the mural}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 620 52) ; "What? Patti! When did you develop an interest in other women?"
			)
			(3 ; Do
				(TPrint 620 53) ; "You would, but you have no ladder!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance The_Guard_GDer_W_chter of Talker
	(properties
		name {The Guard}
		nsTop 15
		nsLeft 35
		view 1622
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust guardBust)
		(= eyes guardEyes)
		(= mouth guardMouth)
		(super init: &rest)
	)
)

(instance guardBust of Prop
	(properties
		view 1622
		loop 1
	)
)

(instance guardEyes of Prop
	(properties
		nsTop 32
		nsLeft 21
		view 1622
		loop 2
		cycleSpeed 70
	)
)

(instance guardMouth of Prop
	(properties
		nsTop 36
		nsLeft 15
		view 1622
		cycleSpeed 5
	)
)

