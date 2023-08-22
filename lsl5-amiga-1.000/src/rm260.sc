;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use eRS)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	chargeInOutlet
	whichSlot
)

(instance rm260 of LLRoom
	(properties
		picture 260
		east 270
	)

	(method (init)
		(gEgo init: illegalBits: -32768 normalize:)
		(switch gPrevRoomNum
			(east
				(= style 11)
			)
			(else
				(gEgo posn: 292 134 setHeading: 270 edgeHit: EDGE_NONE)
			)
		)
		(super init:)
		(LoadMany rsVIEW 161 162 263 264 560 265)
		(switch gLarryLoc
			(0
				(ad1 loop: 0 cel: 0 init:)
				(ad2 loop: 0 cel: 1 init:)
				(ad3 loop: 0 cel: 2 init:)
				(ad4 loop: 0 cel: 3 init:)
			)
			(1
				(ad1 loop: 1 cel: 0 init:)
				(ad2 loop: 1 cel: 1 init:)
				(ad3 loop: 1 cel: 2 init:)
				(ad4 loop: 1 cel: 3 init:)
			)
			(2
				(slots init:)
				(slot1 init: approachVerbs: 3) ; Do
				(slot2 init: approachVerbs: 3) ; Do
				(slot3 init: approachVerbs: 3) ; Do
				(slot4 init: approachVerbs: 3) ; Do
				(handle1
					init:
					approachVerbs: 3 ; Do
					approachX: (slot1 approachX:)
					approachY: (slot1 approachY:)
				)
				(handle2
					init:
					approachVerbs: 3 ; Do
					approachX: (slot2 approachX:)
					approachY: (slot2 approachY:)
				)
				(handle3
					init:
					approachVerbs: 3 ; Do
					approachX: (slot3 approachX:)
					approachY: (slot3 approachY:)
				)
				(handle4
					init:
					approachVerbs: 3 ; Do
					approachX: (slot4 approachX:)
					approachY: (slot4 approachY:)
				)
				(ad1 loop: 2 cel: 0 init:)
				(ad2 loop: 2 cel: 1 init:)
				(ad3 loop: 2 cel: 2 init:)
				(ad4 loop: 2 cel: 3 init:)
			)
			(3
				(cigaretteMachine init: approachVerbs: 3) ; Do
				(ad1 loop: 3 cel: 0 init:)
				(ad2 loop: 3 cel: 1 init:)
				(ad3 loop: 3 cel: 2 init:)
				(ad4 loop: 3 cel: 3 init:)
			)
		)
		(gAddToPics doit:)
		(switch gLarryLoc
			(3
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 112 306 112 303 119 280 122 267 120 259 113 55 114 50 119 97 119 103 126 98 131 66 131 51 149 19 149 5 164 5 187 319 187 319 189 0 189
							yourself:
						)
				)
			)
			(2
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 112 306 112 303 119 280 122 267 120 253 113 223 113 223 120 100 123 94 121 85 119 82 114 53 113 4 162 7 187 319 187 319 189 0 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 73 119 81 119 97 123 101 130 54 130 50 125 52 119
							yourself:
						)
				)
			)
			(else
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 112 306 112 303 119 280 122 267 120 259 113 54 113 4 164 4 187 319 187 319 189 0 189
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 95 120 105 122 105 126 89 130 63 130 50 126 51 122 62 120
							yourself:
						)
				)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 108 180 128 154 279 154 301 181
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 107 157 113 160 114 165 107 171 93 171 80 170 75 162 85 157
					yourself:
				)
		)
		(ashtray init:)
		(chairs init:)
		(post init:)
		(plant init:)
		(plantSouth init:)
		(door init:)
		(outlet init: approachVerbs: 4 3) ; Inventory, Do
		(HandsOn)
		(Delay (Random 40 120) 0 self)
	)

	(method (doVerb theVerb &tmp [str 175])
		(switch theVerb
			(2 ; Look
				(Format ; "You are in the west wing of the lavish AeroDork Airline terminal building. It's easy to tell when you're traveling via AeroDork--you're bored!"
					@str
					260
					0
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

	(method (newRoom newRoomNumber)
		(gTheTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(announcement number: (Random 273 275) flags: 1 setLoop: 1 play:)
		(Delay (Random 20 40) 2 self)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(gEgo mover:)
				(== (gEgo view:) 550)
				(< (gEgo loop:) 8)
			)
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
	)
)

(instance cigaretteMachine of PicView
	(properties
		x 39
		y 142
		description {the cigarette machine}
		approachX 64
		approachY 142
		view 265
		priority 9
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 260 1) ; "How quaint! A public cigarette vending machine. You thought those had all been eliminated by anti-smoking activists."
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sGetChange)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chairs of Feature
	(properties
		x 203
		y 152
		nsTop 131
		nsLeft 117
		nsBottom 173
		nsRight 289
		description {the chairs}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 260 2) ; "Evidently AeroDork Airline's automated flight handling is efficient--there's not one person waiting in this waiting room."
			)
			(3 ; Do
				(TPrint 260 3) ; "You're not really interested in sitting in those little puddles of overnight sleeper drool."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance post of Feature
	(properties
		x 75
		y 63
		nsLeft 59
		nsBottom 126
		nsRight 91
		description {the column}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 260 4) ; "Why would such a modern structure require a post so near a corner?"
			)
			(3 ; Do
				(TPrint 260 5) ; "Feeling that familiar sense of "adventure game frustration," you long to bang your head against that post in the corner, but refuse to give up!"
			)
			(5 ; Talk
				(Say gEgo 260 6) ; ""You know, I once had a girl friend that reminds me of talking to you," you say to the post."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 285
		y 90
		nsTop 70
		nsLeft 259
		nsBottom 111
		nsRight 312
		description {the plant}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 260 7) ; "AeroDork has spared no expense to decorate this fabulous gateway."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 227
		y 75
		nsTop 43
		nsLeft 205
		nsBottom 108
		nsRight 249
		description {the door}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 260 8) ; "This door leads to a part of the game that Al never got around to writing."
			)
			(3 ; Do
				(TPrint 260 9) ; "This door not only is locked, it doesn't even have a knob!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sGetChange of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(Load rsVIEW 161)
				(gEgo setHeading: 270 self)
			)
			(1
				(= ticks 20)
			)
			(2
				(gEgo
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo setLoop: 1 normalize:)
				(= cycles 2)
			)
			(6
				(TPrint 260 10 67 -1 28) ; "You feel around in the cigarette vending machine's change slot and find..."
				(if
					(and
						(not (IsFlag 34))
						(not (IsFlag 11))
						(not (gEgo has: 10)) ; Some_Change
					)
					(gEgo get: 10) ; Some_Change
					(Points 5 34)
					(TPrint 260 11 67 -1 28) ; "...a pair of quarters!"
					(= gQuarters 2)
				else
					(TPrint 260 12 67 -1 28) ; "...nothing. Someone must have taken whatever change was left here!"
				)
				(= cycles 2)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance outlet of Feature
	(properties
		x 5
		y 131
		nsTop 118
		nsBottom 143
		nsRight 16
		description {the outlet}
		sightAngle 40
		approachX 32
		approachY 145
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: (ScriptID 22 2) 0 1) ; sGetShocked
			)
			(4 ; Inventory
				(if (== invItem 1) ; Battery_Charger
					(gCurRoom setScript: (ScriptID 22 0)) ; sPlugCharger
				else
					(TPrint 260 13) ; "This outlet would be perfect for plugging in something electrical."
				)
			)
			(2 ; Look
				(if chargeInOutlet
					(TPrint 260 14) ; "Your battery pack is nearly recharged."
				else
					(TPrint 260 15) ; "There is an electrical outlet on the wall."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plantSouth of Feature
	(properties
		x 34
		y 173
		nsTop 158
		nsBottom 189
		nsRight 69
		description {the plant}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 260 7) ; "AeroDork has spared no expense to decorate this fabulous gateway."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance camera of View ; UNUSED
	(properties
		x 27
		y 146
		view 161
		loop 4
		signal 16384
	)
)

(instance ad1 of PicView
	(properties
		x 11
		y 22
		description {the sign}
		view 263
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 260 16) ; "Injured in an Automobile Accident? Hurt in a Work-Related Accident? Been pulled over by the L.A.P.D.? Let our personal injury lawyers work for YOU! We collect only if you win your case. Free consultation. Ambulance Chasers, Inc."
					)
					(1
						(TPrint 260 17) ; "Now in its 1st Straight Season on Broadway! Harold King's "Kiss Me, My Fair Fiddler on the West Side of the Best Little Cabaret in Oklahoma!" Sold out through April, 2003. Vincent Couldbe says, "Even better than last year's `Hello, Annie's Greasy South Pacific Chorus Line!'" Contact TicketMeister."
					)
					(2
						(TPrint 260 18) ; "Welcome to Atlantic City, "Where Dreams Come True." Remember, bet your limit... never limit your bet!"
					)
					(3
						(TPrint 260 19) ; "Welcome to Miami, "America's Friendliest City." Warning: local ordinances forbid carrying lead pipes or tire irons in a concealed manner. Just keep them visible. Have a wonderful stay!"
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
		x 146
		y 9
		description {the sign}
		view 263
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 260 20) ; "For elegant dining in an informal atmosphere, come to Bubba's-On-The-Bay. Exquisite nouvelle cuisine served in the classic Deep South style. Chicken-fried Medallions of Veal, Blackened Carpaccio with Capers and Oleo, Jambalaya Sorbet. Check out our new puzzle placemats!"
					)
					(1
						(TPrint 260 21) ; "Welcome to New York City! Home of the San Francisco Giants, New Jersey Jets, and Los Angeles Dodgers!"
					)
					(2
						(TPrint 260 22) ; "Broke? Down on your luck? Stupidly lost all your money gambling? Looking for some kind person to give you a break? Don't hang out around here and we won't hang out in your cardboard box."
					)
					(3
						(TPrint 260 23) ; "Irv's Pre-Passing Extended Care Home. Finest nursing home arrangements in the country. TV night every other Sunday. Bingo. Guaranteed digestible food. Irv says, "If you're waiting to pass away, stay with us today!""
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
		x 235
		y 10
		description {the sign}
		view 263
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 260 24) ; "Take the Yawniversal Studios Tour! Get bit by the Real Shark from "Maws." Get crushed in the hand of the Giant Robot Ape from "King Dong." Get stabbed in the abdomen at the Gates Hotel from "Psicko." Camera rental and infirmary services FREE."
					)
					(1
						(Points 1 91)
						(TPrint 260 25) ; "From anywhere to anywhere, in New York City there's no limousine service that's precisely, totally, exactly like the fabulous Checker Limo Co. Nearly-instantaneous service from our fleet of radio-dispatched cars. Floors disinfected regularly! Call 552-4668, anytime."
					)
					(2
						(TPrint 260 26) ; "On your next trip, try TWAL, The Women's Airline. All female crew, all male flight attendants. Extra protection down the center of the plane, where women need it most. Remember our slogan: "Fly TWAL... The Darn Thing Has Wings!""
					)
					(3
						(TPrint 260 27) ; "Phil's Pharmaceuticals is open 24-hours for all your drug needs. 53 varieties of addictive over-the-counter chemicals flown in fresh daily. Ask about our Spring Break specials. We do not condone illegal drug use. However, bulk discounts on Valium clones are available this month only!"
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
		x 311
		y 13
		description {the sign}
		view 263
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 260 28) ; "While you're here in Los Angeles, be sure to visit wonderful "Wizneyland." Your children will be terrified when they see their favorite cartoon characters running up to them in enormous grinning overstuffed costumes... horrified when they ride through the bowel-loosening haunted house! Wizneyland! It's a million trips to the bathroom!!"
					)
					(1
						(TPrint 260 29) ; "It's Carefree Living in the Eurasian Style in new Exorbitania Townhouses. Only 1/2 block from Central Park, Broadway, Madison Square Garden, Statue of Liberty, UN Building, World Trade Center, Automat. One-bedrooms start at $10,000,000. Security locks, no pets. And no vacancies to the likes of you, either, buddy!"
					)
					(2
						(TPrint 260 30) ; "Where does the Moral Majority turn to promote censorship and creeping Fascism? "Slant," the Holier-Than-Thou Newsweekly. No liberal pandering, no pinko editorial cartoons, no objective journalism... just good ol' fashioned Fundamentalism. Printed on 100% recycled environmentalists."
					)
					(3
						(TPrint 260 31) ; "RIOT GEAR! Explosives, weapons, armor. Brass knuckles, nunchuks, pipe bombs, switchblades, guns, bazookas, tanks, stealth bombers (24-hours notice, please). Senior citizen discounts."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ashtray of Feature
	(properties
		x 94
		y 149
		nsTop 133
		nsLeft 85
		nsBottom 165
		nsRight 104
		description {the ashtray}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 260 32) ; "You appreciate the historical accuracy of an ashtray simulator in public places."
			)
			(3 ; Do
				(TPrint 260 33) ; "You want to put your butt in the ashtray?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
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

(instance handle1 of PicView
	(properties
		x 122
		y 100
		z 14
		description {the slot machine}
		view 264
		loop 1
		priority 0
		signal 16
	)

	(method (doVerb)
		(= whichSlot 1)
		(slot1 doVerb: &rest)
	)
)

(instance handle2 of Prop
	(properties
		x 151
		y 86
		description {the slot machine}
		view 264
		loop 1
		priority 11
		signal 16384
	)

	(method (doVerb)
		(= whichSlot 2)
		(slot1 doVerb: &rest)
	)
)

(instance handle3 of PicView
	(properties
		x 180
		y 86
		description {the slot machine}
		view 264
		loop 1
		priority 6
		signal 16
	)

	(method (doVerb)
		(= whichSlot 3)
		(slot1 doVerb: &rest)
	)
)

(instance handle4 of PicView
	(properties
		x 207
		y 85
		description {the slot machine}
		view 264
		loop 1
	)

	(method (doVerb)
		(= whichSlot 4)
		(slot1 doVerb: &rest)
	)
)

(instance slots of PicView
	(properties
		x 166
		y 22
		z -100
		description {the slot machine}
		view 264
		priority 4
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance slot1 of Feature
	(properties
		x 112
		y 99
		nsTop 77
		nsLeft 100
		nsBottom 121
		nsRight 124
		description {the slot machine}
		sightAngle 40
		approachX 117
		approachY 120
	)

	(method (doVerb theVerb invItem)
		(if (not whichSlot)
			(= whichSlot 1)
		)
		(switch theVerb
			(2 ; Look
				(TPrint 260 34) ; "Slot machines! You haven't played the slots since "Leisure Suit Larry 1: In the Land of the Lounge Lizards." Now available in an all-new, 256-color version with enhanced graphics, music and sound effects!!"
				(= whichSlot 0)
			)
			(3 ; Do
				(gCurRoom setScript: sSlots)
			)
			(4 ; Inventory
				(if (== invItem 10) ; Some_Change
					(TPrint 260 35) ; "You haven't played the slots since your old "Land of the Lounge Lizards" days! You have no desire to waste your (hard-found) money here."
				else
					(super doVerb: theVerb invItem &rest)
				)
				(= whichSlot 0)
			)
			(else
				(super doVerb: theVerb invItem &rest)
				(= whichSlot 0)
			)
		)
	)
)

(instance slot2 of Feature
	(properties
		x 142
		y 98
		nsTop 77
		nsLeft 128
		nsBottom 120
		nsRight 156
		description {the slot machine}
		sightAngle 40
		approachX 146
		approachY 122
	)

	(method (doVerb)
		(= whichSlot 2)
		(slot1 doVerb: &rest)
	)
)

(instance slot3 of Feature
	(properties
		x 172
		y 99
		nsTop 77
		nsLeft 160
		nsBottom 121
		nsRight 184
		description {the slot machine}
		sightAngle 40
		approachX 176
		approachY 122
	)

	(method (doVerb)
		(= whichSlot 3)
		(slot1 doVerb: &rest)
	)
)

(instance slot4 of Feature
	(properties
		x 199
		y 98
		nsTop 76
		nsLeft 187
		nsBottom 121
		nsRight 211
		description {the slot machine}
		sightAngle 40
		approachX 201
		approachY 122
	)

	(method (doVerb)
		(= whichSlot 4)
		(slot1 doVerb: &rest)
	)
)

(instance sSlots of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= register 0)
				(gEgo setLoop: 3)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 261
					setLoop: 0
					cycleSpeed: 12
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(if (and (not (IsFlag 36)) (== whichSlot 2))
					(handle2 setCel: 255 cycleSpeed: 8 hide:)
					(gEgo setCycle: End self)
				else
					(= ticks 90)
				)
			)
			(3
				(if (and (not (IsFlag 36)) (== whichSlot 2))
					(handle2 show: setCycle: Beg)
					(gTheMusic2 number: 262 loop: 1 play: self)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(cond
					((or (!= whichSlot 2) (IsFlag 36))
						(TPrint 260 36 67 -1 185 108 self) ; "You try to pull the handle of the slot machine but since there's no quarter in it, nothing happens."
					)
					((not (IsFlag 36))
						(gTheMusic number: 263 loop: 1 play: self)
						(= register 1)
					)
					(else
						(= ticks 10)
					)
				)
			)
			(5
				(= ticks 30)
			)
			(6
				(gTheMusic stop:)
				(if (and register (not (IsFlag 36)))
					(Points 5 36)
					(TPrint 260 37) ; "Hey, all right! Someone left a quarter in that machine. Pulling the handle yields only one lonely cherry, but that's enough to pay you a quarter. You reach into the slot machine's coin bin and grab it."
					(gEgo get: 10) ; Some_Change
					(= gQuarters 1)
				)
				(HandsOn)
				(gEgo setLoop: 3 normalize:)
				(= whichSlot 0)
				(self dispose:)
			)
		)
	)
)

