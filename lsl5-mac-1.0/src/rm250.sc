;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	cardHere
	cueCounter
)

(instance rm250 of LLRoom
	(properties
		picture 250
		north 270
	)

	(method (init)
		(HandsOff)
		(Load rsVIEW 250)
		(gEgo init: normalize: 553 setStep: 2 1)
		(plane init: setLoop: 0 setCel: (Random 4 6) setScript: sPlane)
		(door init: setPri: 4)
		(if (or (IsFlag 38) (IsFlag 1))
			(limo init: posn: 277 115)
		)
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: EDGE_NONE)
				(Delay 5 1 gCurRoom)
			)
			(258
				(gEgo posn: 191 105 illegalBits: -32768)
				(Delay 5 1 gCurRoom)
			)
			(else
				(gEgo posn: 1000 1000 0)
				(if (not (IsFlag 38))
					(if (not (gCast contains: limo))
						(limo init:)
					)
					(limo posn: 400 115)
				)
				(gCurRoom setScript: sLimo)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 257 0 257 104 182 104 182 106 315 106 316 104 263 104 263 0 319 0 319 189 0 189
					yourself:
				)
		)
		(otherDoor init:)
		(driveway init:)
		(car init:)
		(car2 init:)
		(luggage init:)
		(luggage2 init:)
		(bush init:)
		(tower init:)
		(ATM init: approachVerbs: 3 4) ; Do, Inventory
		(trashCan init: approachVerbs: 3) ; Do
		(if
			(and
				(IsFlag 12)
				(== gLarryLoc 3)
				(not (gEgo has: 21)) ; Green_Card
				(not (IsFlag 11))
			)
			(envelope init: approachVerbs: 3) ; Do
			(= cardHere 1)
		)
		(gAddToPics doit:)
		(cloud init: setCel: 8 posn: (Random 90 230) (Random 1 20) -30 stopUpd:)
		(theSign init: setCel: gLarryLoc setPri: 4)
		(gTheMusic number: 251 loop: -1 play:)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 258)
			(gTheMusic stop:)
			(gTheMusic2 stop:)
			(theMusic3 stop:)
		else
			(gTheMusic2 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb invItem &tmp [str 100])
		(switch theVerb
			(2 ; Look
				(if cardHere
					(TPrint 250 0) ; "Look! There's a plain brown envelope lying on top of that trash receptacle near the ATM machine."
				else
					(Format ; "You are outside the %s airport. AeroDork Airlines has installed one of their exclusive ATMs near the entrance."
						@str
						250
						1
						(switch gLarryLoc
							(0 {Los Angeles})
							(1 {New York})
							(2 {Atlantic City})
							(3 {Miami})
						)
					)
					(TPrint @str)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if script
			(script doit:)
		)
	)

	(method (cue)
		(HandsOn)
	)
)

(instance ATM of Feature
	(properties
		y 1
		nsTop 82
		nsLeft 176
		nsBottom 94
		nsRight 190
		description {the ATM}
		sightAngle 40
		approachX 189
		approachY 102
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 2) ; "AeroDork was the first airline to feature ATMs ("Automated Ticket Machines"). These machines have allowed AeroDork to completely eliminate ticket agents."
			)
			(3 ; Do
				(gCurRoom newRoom: 258)
			)
			(5 ; Talk
				(TPrint 250 3) ; "Hello!" you cry, "is this machine voice activated?"
				(TPrint 250 4) ; "The ATM's voice activation circuits may be implemented "Real Soon Now.""
			)
			(4 ; Inventory
				(switch invItem
					(7 ; AeroDork_Gold_Card
						(gEgo put: 7) ; AeroDork_Gold_Card
						(gCurRoom newRoom: 258)
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

(instance limo of Actor
	(properties
		description {your limousine}
		approachX 288
		approachY 107
		view 250
		loop 3
		priority 8
		signal 22544
		illegalBits 0
	)

	(method (cue)
		(super cue:)
		(switch (++ cueCounter)
			(1
				(Delay 3 2 self)
			)
			(2
				(gEgo hide:)
				(Delay 2 2 self)
			)
			(3
				(theMusic3 number: 192 loop: 1 play:)
				(self cue:)
			)
			(4
				(Delay 2 2 self)
			)
			(5
				(gCurRoom newRoom: 200)
			)
		)
	)

	(method (init)
		(self approachVerbs: 3) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 250 5) ; "A small, tasteful bumper sticker on the back of the limo reads, "Honk if you can last more than thirty seconds.""
			)
			(3 ; Do
				(HandsOff)
				(theMusic3 number: 191 loop: 1 play:)
				(self cue:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tower of Feature
	(properties
		y 1
		nsTop 20
		nsLeft 256
		nsBottom 68
		nsRight 295
		description {the control tower}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 6) ; "This tower contains all the many new air traffic controllers recently hired to keep you totally safe during takeoffs and landings."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bush of Feature
	(properties
		y 1
		nsTop 130
		nsLeft 242
		nsBottom 171
		nsRight 319
		description {the bushes}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 7) ; ""Is your name George?" you joke to Mister Bush."
			)
			(3 ; Do
				(TPrint 250 8) ; "There's nothing hidden in the planter."
			)
			(5 ; Talk
				(TPrint 250 9) ; "Do you think talking to these plants will make them grow?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance luggage of Feature
	(properties
		y 1
		nsTop 101
		nsLeft 118
		nsBottom 124
		nsRight 149
		description {the luggage}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 10) ; "That piece of luggage belongs to some other jet setter, Larry."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance luggage2 of Feature
	(properties
		y 1
		nsTop 135
		nsLeft 55
		nsBottom 150
		nsRight 82
		description {the luggage}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 10) ; "That piece of luggage belongs to some other jet setter, Larry."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance car of Feature
	(properties
		y 1
		nsTop 124
		nsLeft 95
		nsBottom 161
		nsRight 160
		description {the car}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 11) ; "This car has been parked here well over the three-minute time limit!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance car2 of Feature
	(properties
		y 1
		nsTop 161
		nsLeft 61
		nsBottom 188
		nsRight 147
		description {the car}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 12) ; "This car has been parked here well over the 3 minute time limit!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance driveway of Feature
	(properties
		y 1
		nsTop 105
		nsLeft 150
		nsBottom 129
		nsRight 319
		description {the driveway}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 13) ; "This is the part of the airport where planes are not supposed to drive!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance otherDoor of Feature
	(properties
		y 1
		nsTop 67
		nsLeft 46
		nsBottom 131
		nsRight 99
		description {the door}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 250 14) ; "That door is for those travelers with enough wisdom and experience to not choose AeroDork Airlines."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theSign of View
	(properties
		x 224
		y 67
		description {the sign}
		view 250
	)

	(method (doVerb theVerb &tmp [str 40])
		(switch theVerb
			(2 ; Look
				(Format ; "The sign says you are presently in %s, Larry!"
					@str
					250
					15
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
)

(instance envelope of Prop
	(properties
		x 206
		y 99
		description {the plain brown envelope}
		approachX 205
		approachY 93
		view 250
		loop 2
		priority 6
	)

	(method (cue)
		(TPrint 250 16) ; "You conveniently "forget" to leave any money. You feel guilty... but only for a few moments."
		(self dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 250 17) ; "There's an envelope here."
			)
			(3 ; Do
				(if (not (gEgo has: 21)) ; Green_Card
					(HandsOff)
					(= cardHere 0)
					(gEgo get: 21) ; Green_Card
					(HandsOn)
					(Points 12)
					(TPrint 250 18) ; "You take the envelope, open it and find your non-personalized, "100% legal," surrogate green card inside."
					(Delay 3 1 self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plane of Actor
	(properties
		description {the airplane}
		view 250
		priority 3
		signal 26640
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 250 19) ; "Da plane, boss, da plane!"
			)
			(3 ; Do
				(TPrint 250 20) ; "You may think you can touch that airplane... but you're wrong!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trashCan of Feature
	(properties
		x 201
		y 94
		nsTop 88
		nsLeft 196
		nsBottom 101
		nsRight 206
		description {the trash can}
		sightAngle 90
		approachX 205
		approachY 93
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if cardHere
					(TPrint 250 21) ; "There's a plain brown envelope resting inconspicuously on the top of the trash can."
				else
					(TPrint 250 22) ; "A small sign on the side of the trash receptacle reads, "Hold it 'til you get to the can!""
				)
			)
			(3 ; Do
				(if cardHere
					(envelope doVerb: 3)
				else
					(TPrint 250 23) ; "There's nothing in the trash can--in THIS Leisure Suit Larry game!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cloud of View
	(properties
		description {the cloud}
		view 250
		priority 1
		signal 30736
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 250 24) ; "A lonely cloud drifts by on V.F.R."
			)
			(3 ; Do
				(TPrint 250 25) ; "You may think you can touch the clouds... but you're wrong!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Door
	(properties
		x 260
		y 101
		description {the door}
		sightAngle 90
		approachX 261
		approachY 104
		lookStr {This door leads to the exclusive AeroDork gates.}
		view 251
		entranceTo 270
		openSnd 293
		closeSnd 0
		moveToX 261
		moveToY 102
		enterType 0
		exitType 0
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sPlane of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= seconds (Random 6 11))
			)
			(1
				(gTheMusic2 number: 254 loop: 1 flags: 1 play: 127)
				(switch (Random 1 4)
					(1
						(plane
							show:
							setCel: 4
							posn: 347 31
							setMotion: MoveTo 120 55 self
						)
					)
					(2
						(plane
							show:
							setCel: 7
							posn: 319 18
							setMotion: MoveTo 108 57 self
						)
					)
					(3
						(plane
							show:
							setCel: 5
							posn: 319 25
							setMotion: MoveTo 124 66 self
						)
					)
					(4
						(plane
							show:
							setCel: 6
							posn: 283 -3
							setMotion: MoveTo 73 48 self
						)
					)
				)
			)
			(2
				(plane hide:)
				(= ticks 30)
			)
			(3
				(gTheMusic2 fade: 0 10 10 1)
				(self init:)
			)
		)
	)
)

(instance sLimo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo hide: posn: 287 110)
				(= cycles 2)
			)
			(1
				(if (IsFlag 38)
					(self changeState: 5)
				else
					(theMusic3 number: 255 loop: 1 play: flags: 1 hold: 10)
					(limo setMotion: MoveTo 340 115 self)
				)
			)
			(2
				(limo xStep: 2 setMotion: MoveTo 295 115 self)
			)
			(3
				(limo xStep: 1 setMotion: MoveTo 277 115 self)
			)
			(4
				(theMusic3 release:)
				(limo stopUpd:)
				(= ticks 90)
			)
			(5
				(theMusic3 number: 191 loop: 1 play:)
				(= ticks 100)
			)
			(6
				(= ticks 10)
			)
			(7
				(gEgo
					show:
					setLoop: 3
					moveSpeed: 15
					cycleSpeed: 8
					setMotion: MoveTo 287 105 self
				)
			)
			(8
				(theMusic3 number: 192 loop: 1 play:)
				(HandsOn)
				(gEgo normalize: 553 setStep: 2 1)
				(SetFlag 38)
				(self dispose:)
			)
		)
	)
)

