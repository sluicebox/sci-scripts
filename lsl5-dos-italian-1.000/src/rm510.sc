;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Interface)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	talkCounter
	[unused 3]
	okToMakeTape
	tapeHere
)

(instance rm510 of LLRoom
	(properties
		picture 510
		north 525
		south 500
	)

	(method (init)
		(LoadMany rsVIEW 515 512 513 514 511 510)
		(Load rsSOUND 510)
		(LDoor init: approachVerbs: 3 stopUpd:) ; Do
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: EDGE_NONE init: normalize:)
			)
			(535
				(HandsOn)
				(SetFlag 16) ; fMCloseUp
				((Inv at: 14) state: 4) ; Membership_Tape
				(gEgo
					x: (door approachX:)
					y: (door approachY:)
					init:
					normalize:
					edgeHit: EDGE_NONE
				)
			)
			(530
				(HandsOn)
				(SetFlag 16) ; fMCloseUp
				((Inv at: 14) state: 4) ; Membership_Tape
				(gEgo
					x: (door approachX:)
					y: (door approachY:)
					init:
					normalize:
					edgeHit: EDGE_NONE
				)
			)
			(520
				(gEgo init: normalize: posn: 137 77)
				(if (gEgo has: 14) ; Membership_Tape
					(HandsOff)
					(gCurRoom setScript: sExitNorth)
				else
					(HandsOn)
				)
			)
			(500
				(gEgo init: normalize: posn: 334 219)
				(gTheMusic fade: 127 10 10 0)
				(self setScript: sEnterSouth)
			)
			(else
				(= gLarryLoc 1)
				(if (not gPrevRoomNum)
					(WrapMusic firstSound: 500 lastSound: 502)
					(gTheMusic number: 500 play: WrapMusic flags: 1 setLoop: 1)
				)
				(gEgo init: normalize: posn: 334 219)
				(self setScript: sEnterSouth)
			)
		)
		(door init: stopUpd:)
		(super init:)
		(if (and (!= gPrevRoomNum 535) (not (IsFlag 16))) ; fMCloseUp
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 114 270 99 258 104 245 100 251 90 238 87 218 94 208 82 218 71 215 70 210 75 172 65 169 58 146 59 147 70 106 82 81 96 92 100 98 108 84 114 62 113 50 108 29 108 4 125 6 186 270 187 272 189 0 189
						yourself:
					)
			)
			(woman init: addToPic:)
			(womansMouth init: ignoreActors: 1 setScript: sMouth)
			(phone init: setCel: 1 stopUpd:)
		else
			(if (== gPrevRoomNum 535)
				(WrapMusic firstSound: 500 lastSound: 502)
				(gTheMusic number: 500 play: WrapMusic flags: 1 setLoop: 1)
			)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 114 270 99 258 104 245 100 251 90 238 87 218 94 208 82 218 71 215 70 210 75 172 65 169 58 146 59 147 70 109 83 81 96 92 100 98 108 84 114 62 113 50 108 29 108 4 125 4 187 270 187 272 189 0 189
						yourself:
					)
			)
			(phone init: setCel: 0 approachVerbs: 3 5 stopUpd:) ; Do, Talk
		)
		(if (== ((Inv at: 14) owner:) 510) ; Membership_Tape
			(tape init: setCel: 255)
		)
		(if (== ((Inv at: 14) state:) 0) ; Membership_Tape
			(Load rsSOUND 512 442)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 50 168 44 161 52 156 149 157 157 163 145 169 77 169
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 69 129 80 124 131 124 141 130 130 135 79 135
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 120 110 129 103 173 103 186 109 179 114 173 117 126 117
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 142 147 140 141 148 135 201 135 213 143 204 150 188 152 159 152
					yourself:
				)
		)
		(musicBox init: approachVerbs: 3 4 stopUpd:) ; Do, Inventory
		(maitreD init: approachVerbs: 5 3 4 stopUpd:) ; Talk, Do, Inventory
		(tapeReader init: approachVerbs: 3 4) ; Do, Inventory
		(diskDrive init:)
		(pet init:)
		(appleII init:)
		(cashRegister init:)
		(monitor init:)
		(atari400 init:)
		(tapeDrive init:)
		(cactus1 init:)
		(cactus2 init:)
		(pianoRoll init:)
		(punchCardMachine init:)
		(podium init:)
		(desk init:)
		(bullBoard init:)
		(chair init:)
	)

	(method (notify what)
		(switch what
			(-1
				(TPrint 510 0) ; "You change your mind and hang up the phone."
			)
			(4668
				(if (not (IsFlag 1)) ; fCalledLimo
					(SetFlag 1) ; fCalledLimo
					(Points 2 110)
					(TPrint 510 1) ; "Hello," says the voice on the telephone, "You've reached the `Fabulous Checker Limo Company.' I hope you're having a nice day!"
					(Say gEgo 510 2) ; "Hello! This is Larry; Larry Laffer," you say. "Please send my limo to The Hard Disk Cafe immediately!"
					(TPrint 510 3) ; "Yes sir! It'll be there damn near instantly."
				else
					(TPrint 510 4) ; "That line is busy."
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 5) ; "The lobby of "The Hard Disk Cafe" is filled with a tremendously exciting (to nerds) display of ancient computer memorabilia. Your pulse quickens just looking around the place."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gTheMusic fade: 127 10 10 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (and (gEgo mover:) gModelessDialog)
			(gModelessDialog dispose:)
		)
		(cond
			(script)
			((StepOn gEgo 16)
				(HandsOff)
				(self setScript: sExitSouth)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (door approachX:) (door approachY:) self
				)
			)
			(1
				(door locked: 0 exitType: 0 open:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 293 183 self)
			)
			(1
				(HandsOn)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sBribe of Script
	(properties)

	(method (changeState newState &tmp bribe [str 6])
		(switch (= state newState)
			(0
				(Say gEgo 510 6) ; "Say, good fellow," you say to the maitre d', "would you be willing to accept a little bribe?"
				(= ticks 60)
			)
			(1
				(cond
					((== ((Inv at: 14) state:) 0) ; Membership_Tape
						(Say the_maitre_d 510 7 108 139 self) ; "But, of course, My Sewer," says the maitre d' snootily. "It worked in Larry 3, didn't it?"
					)
					((== ((Inv at: 14) state:) 4) ; Membership_Tape
						(Say the_maitre_d 510 8 108) ; ""I suggest you find transportation to another location, Mr. (heh, heh) Laffer!" he smirks."
						(HandsOn)
						(self dispose:)
					)
					(else
						(Say the_maitre_d 510 9 108) ; "You have your tape, Mr. Laffer. Stop bothering me!"
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(2
				(= ticks 67)
			)
			(3
				(for ((= bribe 0)) (< bribe 1) ((= bribe (ReadNumber @str)))
					(= str 0)
					(proc0_26)
					(GetInput
						@str
						6
						{How much do you wish to bribe the Maitre d'.}
						80
						{Grease That Palm}
					)
					(proc0_27)
				)
				(if (> bribe 99)
					(HandsOff)
					(Points 3 106)
					(gEgo put: 12) ; Money
					(Say the_maitre_d 510 10 108) ; "Please, follow me, sir," says the maitre d', walking to the punch tape reader. "Allow me to prepare you for membership in our exclusive club."
					(= okToMakeTape 1)
					((Inv at: 14) state: 1) ; Membership_Tape
					(gCurRoom setScript: sMD)
				else
					(Say the_maitre_d 510 11 108) ; "Thank you very much, sir," says the maitre d' greedily. "Have a nice day!"
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance sMouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(womansMouth setCycle: Fwd cycleSpeed: (Random 6 12))
				(= cycles (Random 48 90))
			)
			(1
				(womansMouth setCel: 0)
				(= cycles (Random 30 60))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sMusicBox of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(musicBox setCycle: Fwd)
				(musicBoxCloseUp init: setCycle: Fwd)
				(= seconds 3)
			)
			(1
				(Points 12 107)
				(TPrint 510 12 67 100 10) ; "Larry! How brilliant you are! Carefully wrapping your membership tape around the music box's cylinder, you punch a new set of holes in your membership tape, altering it forever. But now, will you be able to enter the cafe?"
				(= seconds 3)
			)
			(2
				(musicBoxCloseUp dispose:)
				(musicBox setCel: 0 stopUpd:)
				(HandsOn)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sPhone of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 511
					posn: (- (gEgo x:) 10) (gEgo y:)
					setLoop: 2
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(phone setCel: 1)
				(gEgo setCycle: End self)
			)
			(2
				(gTheMusic stop:)
				(musicBoxFX dispose:)
				(typingFX dispose:)
				(paperRip dispose:)
				(User canInput: 1)
				((ScriptID 20 0) init: 1 self) ; TTDialer
			)
			(3
				(gEgo setCycle: CT 4 -1 self)
				(gTheIconBar disable: 8)
				(= cycles 1)
			)
			(4
				(DisposeScript 20)
				(gTheMusic setVol: 127)
				(phone setCel: 0 stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 550 posn: (+ (gEgo x:) 10) (gEgo y:))
				(gTheIconBar enable: 8)
				(User canInput: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 40)
						(+ (gEgo y:) 40)
						self
				)
			)
			(1
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sMD of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 270 self)
			)
			(1
				(if okToMakeTape
					(= state 19)
				)
				(= cycles 2)
			)
			(2
				(cond
					((== ((Inv at: 14) state:) 0) ; Membership_Tape
						(switch (++ talkCounter)
							(1
								(Say gEgo 510 13) ; "Hello," you say to the maitre d', "do you have a table for a swinging guy like me?"
							)
							(2
								(Say gEgo 510 14) ; "But sir," you protest, "perhaps you've heard of me... my name is Larry; Larry Laffer."
							)
							(3
								(Say gEgo 510 15) ; "I'd really like to get something to eat," you say to the maitre d'. "May I have a table now?"
							)
							(4
								(Say gEgo 510 16) ; "I'd really like to get something to drink," you say to the maitre d'. "May I please have a table now?"
							)
							(5
								(Say gEgo 510 17) ; "You know, it's amazing that a place like this could even stay in business," you say, beginning to lose your temper. "I've never been to a place where the customer is always WRONG!"
							)
							(6
								(Say gEgo 510 18) ; "Let me into that cafe, you ninny," you shout at the maitre d'. "You better let me in, I think!"
							)
							(7
								(Say gEgo 510 19) ; "So when can I get in, eh?" you whine, "I've got to meet somebody here!"
							)
							(8
								(Say gEgo 510 20) ; "She's really quite lovely," you offer, "in fact, I bet you know her."
							)
							(9
								(Say gEgo 510 21) ; "Say, since I'm just going to stand here anyway, why don't I tell you a little story? A story about how a unassuming, traveling software salesman, born near a log cabin in Gumbo, Missouri, made it into the big time..."
							)
							(else
								(Say gEgo 510 22) ; ""Want to hear a little more about me?" you offer."
							)
						)
					)
					((== ((Inv at: 14) owner:) 510) ; Membership_Tape
						(Say gEgo 510 23) ; "Thanks for making that tape for me. Could you give it to me now?"
					)
					((== ((Inv at: 14) state:) 4) ; Membership_Tape
						(Say gEgo 510 24) ; "Uhh, I seemed to have misplaced my membership tape," you tell the maitre d'. "Could you cut me a new one?"
					)
					((IsFlag 2) ; fSeenMM
						(Say gEgo 510 25) ; "Excuse me," you say to the maitre d', "How do I get into that inner door?"
					)
					((== ((Inv at: 14) state:) 1) ; Membership_Tape
						(Say gEgo 510 26) ; "Thanks for the membership tape!" you say to the maitre d'. "But where do I go?"
					)
				)
				(= cycles 3)
			)
			(3
				(cond
					((== ((Inv at: 14) state:) 0) ; Membership_Tape
						(switch talkCounter
							(1
								(Say the_maitre_d 510 27 108) ; "No."
							)
							(2
								(Say the_maitre_d 510 27 108) ; "No."
							)
							(3
								(Say the_maitre_d 510 27 108) ; "No."
							)
							(4
								(Say the_maitre_d 510 27 108) ; "No."
							)
							(5
								(Say the_maitre_d 510 28 108) ; "No?"
							)
							(6
								(Say the_maitre_d 510 29 108) ; "Know."
							)
							(7
								(Say the_maitre_d 510 30 108) ; "Ho."
							)
							(8
								(Say the_maitre_d 510 31 108) ; "Who?"
							)
							(9
								(Say the_maitre_d 510 32 108 139 self) ; ""OK! STOP!! I'll get you a damned ticket!" he shouts."
								(= okToMakeTape 1)
								((Inv at: 14) state: 1) ; Membership_Tape
							)
							(else
								(Say the_maitre_d 510 33 108) ; "I'm sorry, sir, but my limit is one bore per customer!"
							)
						)
					)
					((== ((Inv at: 14) owner:) 510) ; Membership_Tape
						(Say the_maitre_d 510 34 108) ; "You fool! Eeet's hanging there in plain sight!"
					)
					((== ((Inv at: 14) state:) 4) ; Membership_Tape
						(Say the_maitre_d 510 35 108) ; ""I suggest you find transportation to another location, Mr. (heh, heh) Laffer!" he smirks."
					)
					((IsFlag 2) ; fSeenMM
						(gCurRoom setScript: sDoubleTalk)
					)
					((== ((Inv at: 14) state:) 1) ; Membership_Tape
						(Say the_maitre_d 510 36 108) ; "Just find a place to sit down. You have an assigned table. Find it!"
					)
				)
				(if (not okToMakeTape)
					(HandsOn)
					(self dispose:)
				)
			)
			(4
				(= state 19)
				(= cycles 2)
				(Points 3 106)
				(TPrint 510 37 67 -1 185) ; "(Nice going, Larry!)"
			)
			(20
				(maitreD
					init:
					view: 515
					setCycle: Walk
					setLoop: -1
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 133 86 self
				)
				(gEgo setMotion: MoveTo 153 (gEgo y:))
				(= okToMakeTape 0)
			)
			(21
				(typingFX play:)
				(maitreD view: 512 setLoop: 1 setCycle: Fwd)
				(screen init: setPri: (- (maitreD priority:) 1))
				(gEgo setMotion: 0 setHeading: 315)
				(= seconds 3)
			)
			(22
				(typingFX stop:)
				(maitreD setCel: 0)
				(screen setCycle: Fwd)
				(= seconds 3)
			)
			(23
				(typingFX play:)
				(maitreD setCycle: Fwd)
				(screen setCel: 0)
				(= seconds 3)
			)
			(24
				(typingFX stop:)
				(maitreD setCel: 0)
				(tape init: setCycle: End self)
				(screen dispose:)
			)
			(25
				(Say the_maitre_d 510 38 108 139 self) ; "There you are, Sir!" barks the maitre d'. "Enjoy your visit here at the lovely Hard Disk Cafe!"
			)
			(26
				(maitreD
					view: 515
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 70 90 self
				)
			)
			(27
				(maitreD view: 512 setLoop: 0)
				((Inv at: 14) owner: 510) ; Membership_Tape
				(HandsOn)
				(maitreD stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sDoubleTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say the_maitre_d 510 39 108 139 self) ; "I'm sorry, sir," he replies, "but admittance to the exclusive `Herman Hollerith Room' is limited to only our very finest customers."
			)
			(1
				(Say the_maitre_d 510 40 108) ; ""(...which you are not!)" he concludes under his breath."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetTape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 511
					setCel: 0
					setLoop: 0
					cycleSpeed: 6
					setCycle: CT 6 1 self
					get: 14 ; Membership_Tape
				)
			)
			(1
				(paperRip play:)
				(gEgo setCycle: End self)
				(tape dispose:)
			)
			(2
				(gEgo setLoop: 1 normalize:)
				(Points 4 109)
				(TPrint 510 41) ; "You grab your tape from the tape reader."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance phone of View
	(properties
		x 59
		y 105
		z 20
		nsTop 71
		nsLeft 50
		nsBottom 85
		nsRight 72
		description {the telephone}
		sightAngle 90
		approachX 81
		approachY 96
		view 510
		loop 4
		priority 5
		signal 22544
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 16) ; fMCloseUp
					(TPrint 510 42) ; "A telephone rests near the maitre d's podium--and it's finally available for your use!"
				else
					(TPrint 510 43) ; "That woman has tied up the telephone for as long as you've been here."
				)
			)
			(5 ; Talk
				(self doVerb: 3 &rest)
			)
			(3 ; Do
				(cond
					((IsFlag 1) ; fCalledLimo
						(TPrint 510 44) ; "There's no need to use the telephone again, since you've already contacted the limo company. Shouldn't you walk outside? Your limo may be waiting for you."
					)
					((IsFlag 16) ; fMCloseUp
						(gCurRoom setScript: sPhone)
					)
					(else
						(Say gEgo 510 45) ; "Get off that phone," you shout. "There are others here that want to make a call."
						(TPrint 510 46) ; "She ignores you completely."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 123
		y 46
		nsTop 40
		nsLeft 110
		nsBottom 49
		nsRight 130
		description {the computer terminal}
		sightAngle 90
		view 510
		loop 2
		signal 22528
	)
)

(instance woman of View
	(properties
		x 80
		y 106
		description {Bertha}
		view 513
		priority 7
		signal 22544
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 510 47) ; "A large aggressive woman has been talking on the telephone for as long as you've been here."
			)
			(3 ; Do
				(Say gEgo 510 45) ; "Get off that phone," you shout. "There are others here that want to make a call."
				(TPrint 510 48) ; "Bertha ignores you completely."
			)
			(5 ; Talk
				(Say gEgo 510 49) ; ""Hey, I'd like to make a call someday, myself," you say to the large woman."
				(TPrint 510 48) ; "Bertha ignores you completely."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance womansMouth of Prop
	(properties
		x 74
		y 75
		description {Bertha's head}
		view 513
		loop 1
		priority 7
		signal 22544
	)
)

(instance musicBox of Prop
	(properties
		x 39
		y 189
		nsTop 173
		nsLeft 19
		nsBottom 189
		nsRight 72
		description {the music box}
		approachX 58
		approachY 186
		view 514
		priority 15
		signal 18448
	)

	(method (cue)
		(super cue:)
		(gTheMusic fade: 127 10 10 0)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 50) ; "Music boxes show an early use of the principle that made the punchcard possible. It gave precisely aligned pins meaning as musical pitches."
				(if (gEgo has: 14) ; Membership_Tape
					(TPrint 510 51 67 -1 185) ; "(How interesting: the music box's cylinder appears to be the same width as your membership tape.)"
				else
					(TPrint 510 52) ; "Its cylinder is exactly 35 millimeters wide."
				)
			)
			(3 ; Do
				(musicBoxFX play: self)
				(gTheMusic fade: 80 10 10 0)
				(TPrint 510 53 67 100 10) ; "The music box is either very old and very tired, or some practical joker has altered the pin placement on its cylinder. It sounds terrible!"
			)
			(5 ; Talk
				(TPrint 510 54) ; "It's a music box, not an Edison cylinder recorder."
			)
			(4 ; Inventory
				(switch invItem
					(14 ; Membership_Tape
						(if (not (> ((Inv at: 14) state:) 1)) ; Membership_Tape
							(gTheMusic fade: 80 10 10 0)
							(musicBoxFX play: self)
							((Inv at: 14) state: 3) ; Membership_Tape
							(TPrint 510 55) ; "You wonder if this will ruin your only means of admission to the Cafe!"
							(gCurRoom setScript: sMusicBox)
						else
							(TPrint 510 56) ; "If you punch any more holes in that piece of tape, there will be nothing left!"
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance musicBoxCloseUp of Prop
	(properties
		x 71
		y 174
		view 511
		loop 1
		priority 15
		signal 18448
	)
)

(instance tape of Prop
	(properties
		x 112
		y 59
		description {your membership tape}
		sightAngle 90
		approachX 117
		approachY 82
		view 510
		loop 3
		priority 3
		signal 16400
	)

	(method (init)
		(super init:)
		(self approachVerbs: 3 4) ; Do, Inventory
		(tapeReader approachX: approachX approachY: approachY)
	)

	(method (dispose)
		(super dispose:)
		(tapeReader approachX: 139 approachY: 77)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 57) ; "The membership tape you wanted so badly now hangs limply from the side of the paper tape reader, twisting slowly, slowly, in the wind."
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sGetTape)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance maitreD of Actor
	(properties
		x 70
		y 90
		description {the maitre d}
		approachX 103
		approachY 89
		view 512
		priority 4
		signal 18448
	)

	(method (cue)
		(super cue:)
		(TPrint 510 58 67 -1 185) ; "(You wonder if his French accent could be fake?)"
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 59) ; "You are quite envious of those that can look stupid and snooty at the same time."
			)
			(3 ; Do
				(Say gEgo 510 60) ; "Hello," you say to the maitre d', "do you have a table for a guy like me?"
				(if (gEgo has: 14) ; Membership_Tape
					(Say the_maitre_d 510 61 108) ; ""Just use the membership tape I created for you," he replies."
				else
					(Say the_maitre_d 510 62 108) ; "Please keep your hands off me," says the maitre d'. "I'm for the use of members only!"
				)
			)
			(5 ; Talk
				(gCurRoom setScript: sMD)
			)
			(4 ; Inventory
				(if (== ((Inv at: 14) owner:) 510) ; Membership_Tape
					(Say the_maitre_d 510 63 108) ; "Why don't you get your tape out of the machine?"
				else
					(switch invItem
						(12 ; Money
							(HandsOff)
							(gCurRoom setScript: sBribe)
						)
						(13 ; Credit_Cards
							(if (== ((Inv at: 14) state:) 1) ; Membership_Tape
								(Say gEgo 510 64) ; "You know, I'd really love to be rid of all these troublesome credit cards," you tell the maitre d'. "Would you be willing to trade them for a table inside?"
								(Say the_maitre_d 510 65 108) ; "But, of course, Sir!" he replies, snapping to attention. "I always have a soft spot for a fine fellow like you!"
								(Points 5 108)
								((Inv at: 14) state: 2) ; Membership_Tape
								(gEgo put: 13) ; Credit_Cards
								(= okToMakeTape 1)
								(gCurRoom setScript: sMD)
							else
								(Say the_maitre_d 510 66 108) ; "You might want to save these, Sir," he replies. "You may need them later."
							)
						)
						(6 ; Hard_Disk_Cafe_Napkin
							(Say gEgo 510 67) ; "Would you mind throwing this away for me," you say, "Now that I know how to get here I don't need it any more."
							(Say the_maitre_d 510 68 108 139 self) ; ""Wee, wee, moisture!" he replies."
							(gEgo put: 6 gCurRoomNum) ; Hard_Disk_Cafe_Napkin
							(gTheIconBar disable: 6 curIcon: (gTheIconBar at: 0))
							(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
						)
						(11 ; DayTrotter
							(Say gEgo 510 69) ; ""Would you like to see my appointment calendar for the next year?" you ask the maitre d'."
							(Say the_maitre_d 510 70 108) ; ""Hardly," he sniffs."
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance LDoor of Prop
	(properties
		x 139
		y 63
		z -3
		description {the swinging doors}
		approachX 165
		approachY 70
		view 510
		priority 2
		signal 2064
	)

	(method (doVerb theVerb invItem)
		(door doVerb: theVerb invItem)
	)
)

(instance door of Door
	(properties
		x 179
		y 63
		heading 180
		nsTop 8
		nsLeft 141
		nsBottom 63
		nsRight 177
		description {the swinging doors}
		approachX 165
		approachY 70
		view 510
		loop 1
		priority 2
		signal 16
		entranceTo 525
		locked 1
		moveToX 156
		moveToY 60
		enterType 0
		exitType 0
	)

	(method (init)
		(= doubleDoor LDoor)
		(super init:)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 71) ; "You presume these doors lead to the cafe proper."
			)
			(3 ; Do
				(TPrint 510 72) ; "These doors operate by means of a Membership Tape inserted and read by that machine to their left."
			)
			(4 ; Inventory
				(switch invItem
					(14 ; Membership_Tape
						(TPrint 510 73) ; "Insert your tape into the machine just to the left of these doors."
					)
					(7 ; AeroDork_Gold_Card
						(TPrint 510 74) ; "You might try using that on the maitre d'."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance the_maitre_d of Talker
	(properties
		name {the maitre d}
		nsTop 33
		nsLeft 22
		view 1512
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust talkerBust)
		(= eyes talkerEyes)
		(= mouth talkerMouth)
		(super init: &rest)
	)
)

(instance talkerBust of View
	(properties
		view 1512
		loop 1
	)
)

(instance talkerEyes of Prop
	(properties
		nsTop 11
		nsLeft 26
		view 1512
		loop 2
		cycleSpeed 30
	)
)

(instance talkerMouth of Prop
	(properties
		nsTop 24
		nsLeft 12
		view 1512
	)
)

(instance tapeReader of Feature
	(properties
		x 112
		y 65
		nsTop 38
		nsLeft 101
		nsBottom 73
		nsRight 139
		description {the paper tape machine}
		sightAngle 180
		approachX 139
		approachY 77
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 75) ; "An ancient mainframe computer's paper tape reader sits against the far wall near the door."
				(if (== ((Inv at: 14) owner:) 510) ; Membership_Tape
					(TPrint 510 76) ; "Your membership tape is still hanging from the side of the machine."
				)
			)
			(3 ; Do
				(if (== ((Inv at: 14) owner:) 510) ; Membership_Tape
					(tape doVerb: 3)
				else
					(gCurRoom newRoom: 520)
				)
			)
			(5 ; Talk
				(TPrint 510 77) ; "This paper tape reader grants access to the "Hard Disk Cafe" proper, which is located behind those closed doors. To enter, just insert your membership tape in the slot."
			)
			(4 ; Inventory
				(switch invItem
					(14 ; Membership_Tape
						(SetFlag 14) ; fUsedTape
						(gCurRoom newRoom: 520)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance diskDrive of Feature
	(properties
		x 301
		y 82
		nsTop 56
		nsLeft 283
		nsBottom 108
		nsRight 319
		description {the antique disk drive}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 78) ; "This early disk drive was the size of a washing machine and held an enormous amount of data--over one megabyte."
			)
			(else
				(if (!= theVerb 2) ; Look
					(TPrint 510 79) ; "This disk drive is for display purposes only."
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance pet of Feature
	(properties
		x 108
		y 102
		nsTop 92
		nsLeft 89
		nsBottom 113
		nsRight 128
		description {the Pet Computer}
		sightAngle 90
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 80) ; "You haven't seen a Pet Computer since the early days of "InfoWorld!""
			)
			(else
				(if (!= theVerb 2) ; Look
					(TPrint 510 81) ; "This computer is for display purposes only."
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance appleII of Feature
	(properties
		x 173
		y 112
		nsTop 101
		nsLeft 154
		nsBottom 124
		nsRight 192
		description {the Apple II computer}
		sightAngle 90
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 82) ; "You cut your first computer teeth on an old integer BASIC Apple II. It wasn't even a Plus!"
			)
			(else
				(if (!= theVerb 2) ; Look
					(TPrint 510 81) ; "This computer is for display purposes only."
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance cashRegister of Feature
	(properties
		x 148
		y 89
		nsTop 78
		nsLeft 128
		nsBottom 100
		nsRight 169
		description {the cash register}
		sightAngle 90
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 83) ; "This NCR baby was one of the first microprocessor-controlled point-of-sale cash registers."
			)
			(else
				(if (!= theVerb 2) ; Look
					(TPrint 510 81) ; "This computer is for display purposes only."
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance monitor of Feature
	(properties
		x 124
		y 135
		nsTop 126
		nsLeft 111
		nsBottom 144
		nsRight 138
		description {the green screen monitor}
		sightAngle 90
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 84) ; "This ancient device could display text in any color you wanted, as long as it was green on black."
			)
			(else
				(if (!= theVerb 2) ; Look
					(TPrint 510 81) ; "This computer is for display purposes only."
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance atari400 of Feature
	(properties
		x 78
		y 144
		nsTop 137
		nsLeft 58
		nsBottom 152
		nsRight 99
		description {the Atari 400 computer}
		sightAngle 90
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 85) ; "Boy, does that Atari 400 bring back fond memories of your misspent youth, playing "Frogger" when your classmates were dating!"
			)
			(else
				(if (!= theVerb 2) ; Look
					(TPrint 510 86) ; "This computer is for display purposes only."
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance tapeDrive of Feature
	(properties
		x 16
		y 71
		nsTop 40
		nsBottom 103
		nsRight 32
		description {the antique tape drive}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 87) ; "This is one of the world's first tape drives, revolutionary in its day, it seems incredibly quaint today. Why it couldn't even hold "Space Quest" let alone a "King's Quest!""
			)
			(4 ; Inventory
				(switch invItem
					(14 ; Membership_Tape
						(TPrint 510 88) ; "This machine once used magnetic tape, not paper tape."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pianoRoll of Feature
	(properties
		x 243
		y 17
		nsTop 9
		nsLeft 220
		nsBottom 26
		nsRight 266
		description {the piano roll}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 510 89) ; "The player piano was an early use of punched holes to control a mechanical device. A vacuum was applied to 88 holes in a metal bar, with each hole indicating a different musical pitch. Where holes occurred in the moving paper, the corresponding notes were played."
			)
			(else
				(TPrint 510 90) ; "The historic old piano roll is hermetically sealed in that glass case."
			)
		)
	)
)

(instance punchCardMachine of Feature
	(properties
		x 253
		y 61
		nsTop 34
		nsLeft 222
		nsBottom 88
		nsRight 284
		description {the punch card machine}
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 510 91) ; "This punch card reader dates from the 1890 U. S. Census. It could handle up to 80 characters or columns of data, a number which remains to this day as the width of most computer video display devices."
			)
			(else
				(TPrint 510 92) ; "A sign on the punch card reader requests that you keep your hands off."
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 39
		y 84
		nsTop 65
		nsLeft 28
		nsBottom 103
		nsRight 51
		description {the chair}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 93) ; "This chair is for the exclusive use of the maitre d'."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bullBoard of Feature
	(properties
		x 25
		y 31
		nsTop 6
		nsBottom 56
		nsRight 51
		description {the bulletin board}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 94) ; "The bulletin board is filled with photographs of famous nerds who frequent this place!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance podium of Feature
	(properties
		x 78
		y 95
		nsTop 50
		nsLeft 55
		nsBottom 95
		nsRight 102
		description {the maitre d's podium}
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 95) ; "The maitre d's podium is just the right size for him to hide behind when the crowds here start throwing things!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 61
		y 99
		nsTop 79
		nsLeft 46
		nsBottom 106
		nsRight 76
		description {the desk}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 96) ; "You wish you had such a nice desk in your crummy office."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cactus1 of Feature
	(properties
		x 203
		y 40
		nsTop 16
		nsLeft 190
		nsBottom 65
		nsRight 217
		description {the cactus}
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 510 97) ; "The cactus is covered with needle-sharp needles. (Hence, the name "Needlenose Cacti.")"
			)
			(3 ; Do
				(Say gEgo 510 98) ; "OUCH!"
			)
			(5 ; Talk
				(TPrint 510 99) ; "Who do you think you are, Snoopy's Uncle Spike?"
			)
			(4 ; Inventory
				(switch invItem
					(14 ; Membership_Tape
						(TPrint 510 100) ; "Punch holes in your membership tape? A good idea, but this is not the way to do it."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cactus2 of Feature
	(properties
		x 116
		y 157
		nsTop 125
		nsLeft 79
		nsBottom 189
		nsRight 154
		description {the cactus}
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb)
		(cactus1 doVerb: &rest)
	)
)

(instance musicBoxFX of Sound
	(properties
		flags 1
		number 510
	)
)

(instance typingFX of Sound
	(properties
		flags 1
		number 442
		loop -1
	)
)

(instance paperRip of Sound
	(properties
		flags 1
		number 512
	)
)

