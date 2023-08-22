;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Language)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
)

(local
	aCueCounter
	scaredRed
	scaredBlonde
	newRedX
	newBlondeX
	cueCounter
	lookCounter
)

(instance rm270 of LLRoom
	(properties
		picture 270
		north 290
		east 280
		south 250
		west 260
	)

	(method (init)
		(gEgo init: normalize:)
		(blonde
			x: (Random 178 235)
			y: 82
			ignoreActors: 1
			setLoop: gBlondeLoop
			init:
		)
		(redHead
			x: (Random 260 305)
			y: 82
			ignoreActors: 1
			setLoop: gRedHeadLoop
			init:
		)
		(= newBlondeX (blonde x:))
		(= newRedX (redHead x:))
		(if (!= gPrevRoomNum (gCurRoom east:))
			(blonde setLoop: 3)
			(redHead setLoop: 4)
		)
		(door init: setPri: 4)
		(camera init:)
		(switch gPrevRoomNum
			(south
				(camera setCel: 5)
				(if (IsFlag 8)
					(ClearFlag 38)
				)
			)
			(north
				(gEgo edgeHit: EDGE_NONE)
			)
			(east
				(blonde init: posn: (+ gBlondeX 319) 82)
				(redHead init: posn: (+ gRedHeadX 319) 82)
				(HandsOn)
				(camera setCel: 255)
				(= style 11)
			)
			(west
				(HandsOn)
				(= style 12)
			)
			(else
				(HandsOn)
				(gEgo posn: 253 185 edgeHit: EDGE_NONE setHeading: 360)
				(camera setCel: 5)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 113 96 113 84 102 76 102 68 113 0 113
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 64 174 27 170 16 157 7 157 10 154 17 154 35 141 87 141 234 141 241 151 258 151 268 155 269 162 253 168 250 174
					yourself:
				)
		)
		(plant init:)
		(chairs init:)
		(ashtray init:)
		(vipSign init:)
		(theCounter init:)
		(if (== gLarryLoc 1)
			(cannister init: approachVerbs: 2 3) ; Look, Do
		)
		(switch gLarryLoc
			(0
				(blonde description: {Buffi})
				(redHead description: {Muffi})
				(ad1 loop: 4 cel: 0 init:)
				(ad2 loop: 4 cel: 1 init:)
				(ad3 loop: 4 cel: 2 init:)
				(ad4 loop: 4 cel: 3 init:)
			)
			(1
				(blonde description: {Tracie})
				(redHead description: {Stacie})
				(ad1 loop: 5 cel: 0 init:)
				(ad2 loop: 5 cel: 1 init:)
				(ad3 loop: 5 cel: 2 init:)
				(ad4 loop: 5 cel: 3 init:)
			)
			(2
				(blonde description: {Cherri})
				(redHead description: {Barri})
				(ad1 loop: 6 cel: 0 init:)
				(ad2 loop: 6 cel: 1 init:)
				(ad3 loop: 6 cel: 2 init:)
				(ad4 loop: 6 cel: 3 init:)
			)
			(3
				(blonde description: {Dixie})
				(redHead description: {Trixie})
				(ad1 loop: 7 cel: 0 init:)
				(ad2 loop: 7 cel: 1 init:)
				(ad3 loop: 7 cel: 2 init:)
				(ad4 loop: 7 cel: 3 init:)
			)
		)
		(gAddToPics doit:)
		(blonde setScript: sBlonde)
		(redHead setScript: sRedHead)
		(DoSound sndGLOBAL_REVERB 10)
		(Delay (Random 40 150) 0 self)
	)

	(method (doVerb theVerb &tmp [str 340])
		(switch theVerb
			(2 ; Look
				(Format ; "You are inside the %s AeroDork Terminal's waiting room (and former ticket counter). A security camera peers at you from the far wall. AeroDork is famous for building exactly the same terminal in every city they serve (except Muncie, Indiana--that's where they hide your lost luggage!)."
					@str
					270
					0
					(switch gLarryLoc
						(0 {Los Angeles})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
					(switch gLarryLoc
						(0 {Los Angeles})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
				)
				(TPrint @str)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(announcement number: (Random 273 275) setLoop: 1 flags: 1 play:)
		(Delay (Random 20 40) 2 self)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 260 280))
			(DoSound sndGLOBAL_REVERB 0)
		)
		(gTheTimer dispose: delete:)
		(blonde dispose:)
		(redHead dispose:)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (gEgo mover:)
			(switch (gEgo cel:)
				(1
					(if (!= (stepSound number:) 260)
						(stepSound number: 260 play:)
					)
				)
				(4
					(if (!= (stepSound number:) 261)
						(stepSound number: 261 play:)
					)
				)
			)
		)
		(cond
			(script)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(redHead setScript: 0)
				(blonde setScript: 0)
				(= gRedHeadX (redHead x:))
				(= gRedHeadLoop (redHead loop:))
				(= gBlondeX (blonde x:))
				(= gBlondeLoop (blonde loop:))
			)
			((gEgo inRect: 167 105 325 124)
				(if (not scaredBlonde)
					(= scaredBlonde 1)
					(blonde setScript: sBlonde 0 365)
				)
				(if (not scaredRed)
					(= scaredRed 1)
					(redHead setScript: sRedHead 0 375)
				)
			)
		)
	)
)

(instance cannister of PicView
	(properties
		x 142
		y 111
		description {the charity collection canister}
		sightAngle 90
		approachX 139
		approachY 114
		view 273
		priority 4
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (and (not (gEgo has: 10)) (not (IsFlag 13))) ; Some_Change
					(Load rsVIEW 291)
					(gCurRoom setScript: sStealChange)
				else
					(TPrint 270 1) ; "You already took the quarter you need; leave the small change for those poor little kids!"
					(TPrint 270 2 67 -1 185) ; "(You big bully!)"
				)
			)
			(2 ; Look
				(if (and (not (gEgo has: 10)) (not (IsFlag 13))) ; Some_Change
					(TPrint 270 3) ; "Directly beneath the security camera is a charity cannister containing many pennies, nickels and dimes, but only one quarter."
				else
					(TPrint 270 4) ; "Directly beneath the security camera is a charity cannister containing many pennies, nickels and dimes, but no more quarters."
				)
			)
			(4 ; Inventory
				(if (== invItem 10) ; Some_Change
					(++ lookCounter)
					(TPrint 270 5) ; "You are much too frugal to ever part with a hard-found quarter!"
					(if (and (> lookCounter 3) (not (Random 0 10)))
						(TPrint 270 6 67 -1 185) ; "(TIGHT-ASS!)"
						(= lookCounter 0)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 46
		y 140
		nsTop 117
		nsLeft 28
		nsBottom 164
		nsRight 64
		description {the plant}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 270 7) ; "AeroDork has spared no expense to decorate this fabulous gateway."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chairs of Feature
	(properties
		x 156
		y 146
		nsTop 126
		nsLeft 72
		nsBottom 167
		nsRight 240
		description {the chairs}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 270 8) ; "Evidently AeroDork Airline's automated flight handling is efficient--there's not one person waiting in this waiting room."
			)
			(3 ; Do
				(TPrint 270 9) ; "You're not really interested in sitting in those little puddles of overnight sleeper drool."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ashtray of Feature
	(properties
		x 249
		y 148
		nsTop 134
		nsLeft 240
		nsBottom 162
		nsRight 258
		description {the ashtray}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 270 10) ; "You appreciate the historical accuracy of an ashtray simulator in public places."
			)
			(3 ; Do
				(if (Random 0 1)
					(TPrint 270 11) ; "What are you expecting? A disco admission card?"
				else
					(TPrint 270 12) ; "You want to put your butt in the ashtray?"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance vipSign of Feature
	(properties
		x 82
		y 31
		nsTop 19
		nsLeft 51
		nsBottom 44
		nsRight 114
		description {the sign}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 270 13) ; "The sign over the door reads, "Chartreuse Carpet V.I.P. Lounge.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theCounter of Feature
	(properties
		y 1
		nsTop 44
		nsLeft 162
		nsBottom 88
		nsRight 317
		description {the ticket counter}
		sightAngle 40
	)

	(method (doVerb theVerb invItem &tmp [temp0 250])
		(switch theVerb
			(2 ; Look
				(TPrint 270 14) ; "This counter was once staffed by highly trained, courteous young men and women."
				(TPrint 270 15 67 -1 185) ; "(Of course, that was when this area was part of the frozen yogurt concession!)"
			)
			(3 ; Do
				(if 1
					(= global200 (Memory memALLOC_CRIT (StrLen (blonde description:))))
					(= global203 (Memory memALLOC_CRIT (StrLen (redHead description:))))
					(= global201 (Memory memALLOC_CRIT (StrLen (blonde description:))))
					(= global204 (Memory memALLOC_CRIT (StrLen (redHead description:))))
					(StrSplitInTwo global200 global203 (blonde description:))
					(StrSplitInTwo global201 global204 (redHead description:))
					(Format ; "A few days ago, you could have bought a ticket here. But now %s and %s, AeroDork's last remaining employees, have nothing to do but stand around and gossip."
						@temp0
						270
						16
						global201
						global200
						global204
						global203
					)
					(Memory memFREE global200)
					(Memory memFREE global201)
					(Memory memFREE global203)
					(Memory memFREE global204)
				)
				(TPrint @temp0)
				(TPrint 270 17 67 -1 185) ; "(So, in essence, not that much has changed!)"
			)
			(5 ; Talk
				(TPrint 270 18) ; "You must have just missed them. Perhaps you should talk to one of the girls, instead of to the ticket counter!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance blonde of Actor
	(properties
		sightAngle 40
		view 277
		detailLevel 3
		illegalBits 0
	)

	(method (checkDetail param1)
		(super checkDetail: &rest)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)

	(method (doVerb theVerb invItem &tmp [temp0 280])
		(switch theVerb
			(2 ; Look
				(if 1
					(= global200 (Memory memALLOC_CRIT (StrLen (blonde description:))))
					(= global203 (Memory memALLOC_CRIT (StrLen (blonde description:))))
					(StrSplitInTwo global200 global203 (blonde description:))
					(Format @temp0 270 19 global200 global203) ; "It's %s, AeroDork's blonde bombshell. Once she was a highly motivated employee. Once she was a highly trained professional. Once she never forgot to ask, "Didya wan'sum fries wit' dat?""
					(Memory memFREE global200)
					(Memory memFREE global203)
				)
				(TPrint @temp0)
			)
			(3 ; Do
				(if 1
					(= global200 (Memory memALLOC_CRIT (StrLen (blonde description:))))
					(= global203 (Memory memALLOC_CRIT (StrLen (blonde description:))))
					(StrSplitInTwo global200 global203 (blonde description:))
					(Format @temp0 270 20 global200 global203) ; "%s was once a ticket agent here. Now her only responsibility is to the few remaining employees: she fires them!"
					(Memory memFREE global200)
					(Memory memFREE global203)
				)
				(TPrint @temp0)
			)
			(5 ; Talk
				(TPrint 270 21) ; "Excuse me, Miss. Could you help me?"
				(TPrint 270 22) ; ""Buddy, I don't think ANYONE could help you!" she replies sarcastically."
			)
			(4 ; Inventory
				(if 1
					(= global200 (Memory memALLOC_CRIT (StrLen (blonde description:))))
					(= global203 (Memory memALLOC_CRIT (StrLen (blonde description:))))
					(StrSplitInTwo global200 global203 (blonde description:))
					(Format @temp0 270 23 global200 global203) ; "Get that away from me, dork!" shouts %s. "Anything YOU have, I don't want!"
					(Memory memFREE global200)
					(Memory memFREE global203)
				)
				(TPrint @temp0)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance redHead of Actor
	(properties
		sightAngle 90
		view 276
		detailLevel 3
		illegalBits 0
	)

	(method (checkDetail param1)
		(super checkDetail: &rest)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)

	(method (doVerb theVerb invItem &tmp [temp0 160])
		(switch theVerb
			(2 ; Look
				(if 1
					(= global200 (Memory memALLOC_CRIT (StrLen (redHead description:))))
					(= global203 (Memory memALLOC_CRIT (StrLen (redHead description:))))
					(StrSplitInTwo global200 global203 (redHead description:))
					(Format @temp0 270 24 global200 global203) ; "It's %s. Once she was AeroDork's red-headed, red-blooded, red-hot, temptress of the flight path."
					(Memory memFREE global200)
					(Memory memFREE global203)
				)
				(TPrint @temp0)
				(TPrint 270 25) ; "Now she's lucky if she even sees a pilot."
			)
			(3 ; Do
				(TPrint 270 26) ; "Excuse me, Clerk," you cry, "Could I buy a ticket here?"
				(TPrint 270 27) ; "Nope," she retorts with a snap of her gum, "we're all out. Try our ATM outside, ok?"
			)
			(5 ; Talk
				(TPrint 270 21) ; "Excuse me, Miss. Could you help me?"
				(TPrint 270 28) ; "Fella, I ain't interested in anyone that can't support me in the style to which I've grown accustomed to," she says, interrupting your clever inquiry. "And nobody I know is accustomed to a style like yours!"
			)
			(4 ; Inventory
				(if 1
					(= global200 (Memory memALLOC_CRIT (StrLen (redHead description:))))
					(= global203 (Memory memALLOC_CRIT (StrLen (redHead description:))))
					(StrSplitInTwo global200 global203 (redHead description:))
					(Format @temp0 270 23 global200 global203) ; "Get that away from me, dork!" shouts %s. "Anything YOU have, I don't want!"
					(Memory memFREE global200)
					(Memory memFREE global203)
				)
				(TPrint @temp0)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sStealChange of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 291
					ignoreActors: 1
					illegalBits: 0
					setLoop: 3
					cycleSpeed: 6
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(TPrint 270 29) ; "There goes your chance for a "Larry's Kids" telethon!"
				(gEgo get: 10) ; Some_Change
				(= gQuarters 1)
				(gEgo normalize:)
				(Points 5 13)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sBlonde of Script
	(properties)

	(method (changeState newState &tmp oldX)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= oldX (blonde x:))
				(if register
					(= newBlondeX register)
				else
					(switch (Random 1 2)
						(1
							(= newBlondeX (Random 178 307))
						)
						(2
							(= newBlondeX (Random 332 375))
						)
					)
				)
				(if
					(and
						(not register)
						(or
							(< newBlondeX (redHead x:) oldX)
							(< oldX (redHead x:) newBlondeX)
						)
					)
					(self init:)
				else
					(blonde
						setLoop: -1
						setCycle: Walk
						setMotion: MoveTo newBlondeX 82 self
					)
				)
			)
			(2
				(if (== (blonde x:) newBlondeX)
					(blonde setLoop: 3)
				)
				(= seconds (Random 2 5))
			)
			(3
				(= scaredBlonde (= register 0))
				(self init:)
			)
		)
	)
)

(instance sRedHead of Script
	(properties)

	(method (changeState newState &tmp oldX)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= oldX (redHead x:))
				(if register
					(= newRedX register)
				else
					(switch (Random 1 2)
						(1
							(= newRedX (Random 178 307))
						)
						(2
							(= newRedX (Random 332 375))
						)
					)
				)
				(if
					(and
						(not register)
						(or
							(< newRedX (blonde x:) oldX)
							(< oldX (blonde x:) newRedX)
						)
					)
					(self init:)
				else
					(redHead
						setLoop: -1
						setCycle: Walk
						setMotion: MoveTo newRedX 82 self
					)
				)
			)
			(2
				(if (== (redHead x:) newRedX)
					(redHead setLoop: 4)
				)
				(= seconds (Random 2 5))
			)
			(3
				(= scaredRed (= register 0))
				(self init:)
			)
		)
	)
)

(instance door of Door
	(properties
		x 98
		y 106
		description {the door}
		sightAngle 90
		approachX 81
		approachY 111
		view 270
		entranceTo 290
		locked 1
		moveToX 81
		moveToY 105
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 270 30) ; "This door leads to the exclusive AeroDork Airline V.I.P. Chartreuse Carpet Lounge."
			)
			(3 ; Do
				(TPrint 270 31) ; "You can't open this door. It's secured from within. If only you had some form of identification to prove you really belong inside."
			)
			(5 ; Talk
				(TPrint 270 32) ; "Hello!" you shout. "Is there anyone inside?"
				(TPrint 270 33 67 -1 185) ; "(You hear no response.)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ad1 of PicView
	(properties
		x 11
		y 11
		description {the sign}
		sightAngle 90
		view 263
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 270 34) ; "While you're here in Los Angeles, be sure to visit wonderful "Wizneyland." Your children will be terrified when they see their favorite cartoon characters running up to them in enormous grinning overstuffed costumes... horrified when they ride through the bowel-loosening haunted house! Wizneyland! It's a million trips to the bathroom!!"
					)
					(1
						(TPrint 270 35) ; "It's Carefree Living in the Eurasian Style in new Exorbitania Townhouses. Only 1/2 block from Central Park, Broadway, Madison Square Garden, Statue of Liberty, UN Building, World Trade Center, Automat. One-bedrooms start at $10,000,000. Security locks, no pets. And no vacancies to the likes of you, either, buddy!"
					)
					(2
						(TPrint 270 36) ; "Where does the Moral Majority turn to promote censorship and creeping Fascism? "Slant," the Holier-Than-Thou Newsweekly. No liberal pandering, no pinko editorial cartoons, no objective journalism... just good ol' fashioned Fundamentalism. Printed on 100% recycled environmentalists."
					)
					(3
						(TPrint 270 37) ; "RIOT GEAR! Explosives, weapons, armor. Brass knuckles, nunchuks, pipe bombs, switchblades, guns, bazookas, tanks, stealth bombers (24-hours notice, please). Senior citizen discounts."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ad2 of PicView
	(properties
		x 163
		y 11
		description {the sign}
		sightAngle 90
		view 263
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 270 38) ; "The Los Angeles Chamber of Commerce welcomes YOU to Los Angeles! See Movie Stars' homes! See the Beverly Hills Wax Museum! See your favorite TV shows actually being taped for future broadcast! Some culture also available; call for details."
					)
					(1
						(TPrint 270 39) ; "Gay? Lesbian? Divorced? Single? Widowed? Depressed? Sorry, but the `Blecchnaven Center' offers weekly seminars for happy, straight couples only."
					)
					(2
						(Points 1 94)
						(TPrint 270 40) ; "For the biggest ride you've ever had, give us a call right now. Let us expose your blatant consumerist backside. "Tramp Limo Service, 553-4468""
					)
					(3
						(TPrint 270 41) ; "Luxury Accommodations are merely a brick's throw away at the Miami Fountainblooey Hotel. 28-story shatterproof glass atrium, fire-resistant deluxe suites. Every Thursday night is Singles Night at "The Castro Room." Valet parking, coat check, firearms rack."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ad3 of PicView
	(properties
		x 249
		y 11
		description {the sign}
		sightAngle 90
		view 263
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 270 42) ; "It's the second-most fun you've had getting wet! Visit MARINELAND, U. S. A.! See authentic U. S. Marines swimming, playing, doing tricks. Watch Porca, `The Killer Marine,' leap out of the water at feeding time for fishsticks!"
					)
					(1
						(TPrint 270 43) ; "Now through September 31st at Madison's Glare Garden! Monster Trucks! Funny Cars! Stupid Motorcycles! Mutant Mopeds! We've turned the floor of the coliseum into a giant mud bog! See audience members with necks twice as thick as their heads! Call Ticket-O-Rama for details."
					)
					(2
						(TPrint 270 44) ; "`Honest' Noah's Check-Cashing Service. The fastest way to get money when you've gambled away all your cash. Sorry, no second-party checks, third-party checks, bank checks, personal checks, out-of-state Czechs, wheat checks, rice checks. Plenty of corn checks!"
					)
					(3
						(TPrint 270 45) ; ""Wet 'n Watery Wild Whooshing World!" Home of the "PsychoKiller Two-mile Waterslide." Speed downhill at 75 miles an hour with nothing to protect you but a thin slice of cheap foam rubber and your bathing suit (assuming it stays on). You must be under 90 to ride. "It was soooooooo scary! Luckily, at 75 miles an hour, who can tell you're peeing?" says Barry Smith, of East Miami."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ad4 of PicView
	(properties
		x 317
		y 8
		description {the sign}
		sightAngle 90
		view 263
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 270 46) ; "How do busy executives stay on top of world finance? "Businessmen's Financial Hourly," of course. All the financial news you need, delivered to your home or office every hour on the hour, all day, all night. Latest markets. Millions of pages a year of the information YOU need every minute to keep your business from sinking like a rock."
					)
					(1
						(TPrint 270 47) ; "The NYC Ballet Company's 2015th production of "Sleeping Beauty" opens August 15th. The NYC Times called it, "A classic... never gets all that boring, even though you've seen it several hundred times." Opening September 20: the 2016th production of "Sleeping Beauty." Call The Ticketster for details."
					)
					(2
						(TPrint 270 48) ; "Gambleholic's Anonymous. Kick the gambling habit! We'll lay you 2 to 1 we can clean up even the worst gambling problem. Meetings held on best 2 out of 3 Thursdays each month. Ex-major league baseball players admitted FREE!"
					)
					(3
						(Points 1 93)
						(TPrint 270 49) ; "Misplace" something? "Lose" something important? "Can't find" that important documentation? Let us help. We're "Just Green Cards" and we're here to help any alien who has "lost" their card! Just call me, Carlos, at 554-1272! You'll get your "replacement" immediately. And remember: "We deliver!!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance camera of Prop
	(properties
		x 126
		y 58
		nsTop 46
		nsLeft 112
		nsBottom 63
		nsRight 130
		description {the security camera}
		sightAngle 90
		approachX 92
		approachY 113
		view 270
		loop 1
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 3 2) ; Inventory, Do, Look
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(super doit:)
		(if (not (gCurRoom script:))
			(= temp2 cel)
			(= temp3 loop)
			(= temp1 (/ (- (GetAngle x y (gEgo x:) (gEgo y:)) 110) 14))
			(self
				setLoop: (if (> (gEgo y:) 159) 1 else 5)
				setCel: (- 9 temp1)
			)
			(if (or (!= temp3 loop) (!= temp2 cel))
				(gTheMusic2 number: 271 loop: 1 play:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 270 50) ; "Hey! You're smudging the lens!"
			)
			(2 ; Look
				(TPrint 270 51) ; "You have the distinct feeling that someone is watching you."
			)
			(4 ; Inventory
				(switch invItem
					(7 ; AeroDork_Gold_Card
						(gCurRoom setScript: sShowCard)
					)
					(8 ; Boarding_Pass
						(TPrint 270 52) ; "While the boarding pass proves you have a flight on this airline, it doesn't prove you have enough class to be admitted to the exclusive AeroDork Chartreuse Carpet V.I.P. lounge."
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

(instance sShowCard of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: 8)
				(= register 5)
				(Points 9 92)
				(gEgo
					view: 271
					setLoop: 1
					cycleSpeed: 4
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(= start state)
				(= cycles 6)
			)
			(2
				(gTheMusic2 number: 272 setLoop: 1 play: self)
			)
			(3
				(if (not (-- register))
					(= cycles 1)
				else
					(if (not (camera cel:))
						(camera setCel: 1 setLoop: 3)
					else
						(camera setCel: 0 setLoop: 3)
					)
					(self init:)
				)
			)
			(4
				(camera setCel: 0)
				(gEgo normalize:)
				(door locked: 0 open:)
				(self dispose:)
			)
		)
	)
)

(instance stepSound of Sound
	(properties)
)

(instance announcement of Sound
	(properties)
)

