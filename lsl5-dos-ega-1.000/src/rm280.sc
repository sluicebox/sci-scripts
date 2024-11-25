;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use eRS)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm280 0
)

(local
	scaredBlonde
	scaredRed
	numberDialed
	validNumber
	onPhone
	fighting
	[string 500]
)

(instance rm280 of LLRoom
	(properties
		lookStr {This end of the lobby is distinguished only by a bank of pay telephones against the far wall.}
		picture 280
		west 270
	)

	(method (init)
		(gEgo init: normalize:)
		(switch gPrevRoomNum
			(west
				(if (and (> gBlondeX 330) (> gRedHeadX 330))
					(blonde
						init:
						view: 276
						setLoop: 2
						posn: 38 84
						setCycle: Fwd
						cycleSpeed: 6
						moveSpeed: 10
						setScript: sFight
					)
					(redHead init: hide:)
				else
					(blonde
						init:
						posn: (- gBlondeX 319) 82
						setLoop: gBlondeLoop
						setScript: sBlonde
					)
					(redHead
						init:
						posn: (- gRedHeadX 319) 82
						setLoop: gRedHeadLoop
						setScript: sRedHead
					)
				)
				(= style 12)
			)
			(else
				(blonde
					init:
					x: (Random 8 22)
					y: 82
					setLoop: 4
					setScript: sBlonde
				)
				(redHead
					init:
					x: (Random 45 68)
					y: 82
					setLoop: 4
					setScript: sRedHead
				)
				(gEgo posn: 16 160 edgeHit: EDGE_NONE)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 0 189 0 187 316 187 315 161 264 112 124 112 120 117 83 117 68 112 0 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 216 127 218 122 230 119 255 119 263 119 268 124 267 132 225 132
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 9 175 27 147 181 147 198 158 230 158 236 161 234 166 214 166 208 175
					yourself:
				)
		)
		(lostDesk init:)
		(largePlant init:)
		(smallPlant init:)
		(post init:)
		(ashtray init:)
		(theCounter init:)
		(sofa init:)
		(phones init: approachVerbs: 2 3 4) ; Look, Do, Inventory
		(phoneBook1 init: approachVerbs: 2 3 4) ; Look, Do, Inventory
		(phoneBook2 init: approachVerbs: 2 3 4) ; Look, Do, Inventory
		(Load rsSCRIPT 20)
		(switch gLarryLoc
			(0
				(blonde description: {Buffi})
				(redHead description: {Muffi})
				(p1 init:)
				(p2 init:)
				(p3 init:)
				(p4 init:)
				(ph1 init:)
				(ph2 init:)
				(ph3 init:)
				(ph4 init:)
				(ad1 loop: 8 cel: 0 init:)
				(ad2 loop: 8 cel: 1 init:)
				(ad3 loop: 8 cel: 2 init:)
				(ad4 loop: 8 cel: 3 init:)
			)
			(1
				(blonde description: {Tracie})
				(redHead description: {Stacie})
				(thePhone
					init:
					x: 155
					y: 80
					heading: 0
					nsLeft: 147
					nsTop: 70
					nsBottom: 91
					nsRight: 163
					approachX: 138
					approachY: 113
				)
				(phoneHandle init: posn: 152 85)
				(p2 init:)
				(p3 init:)
				(p4 init:)
				(ph2 init:)
				(ph3 init:)
				(ph4 init:)
				(ad1 loop: 9 cel: 0 init:)
				(ad2 loop: 9 cel: 1 init:)
				(ad3 loop: 9 cel: 2 init:)
				(ad4 loop: 9 cel: 3 init:)
			)
			(2
				(blonde description: {Cherri})
				(redHead description: {Barri})
				(thePhone
					init:
					x: 176
					y: 80
					heading: 0
					nsLeft: 169
					nsTop: 70
					nsBottom: 91
					nsRight: 183
					approachX: 160
					approachY: 113
				)
				(phoneHandle init: posn: 173 85)
				(p1 init:)
				(p3 init:)
				(p4 init:)
				(ph1 init:)
				(ph3 init:)
				(ph4 init:)
				(ad1 loop: 10 cel: 0 init:)
				(ad2 loop: 10 cel: 1 init:)
				(ad3 loop: 10 cel: 2 init:)
				(ad4 loop: 10 cel: 3 init:)
			)
			(3
				(blonde description: {Dixie})
				(redHead description: {Trixie})
				(thePhone
					init:
					x: 200
					y: 80
					heading: 0
					nsLeft: 192
					nsTop: 70
					nsBottom: 91
					nsRight: 206
					approachX: 183
					approachY: 113
				)
				(phoneHandle init: posn: 196 85)
				(p1 init:)
				(p2 init:)
				(p4 init:)
				(ph1 init:)
				(ph2 init:)
				(ph4 init:)
				(ad1 loop: 11 cel: 0 init:)
				(ad2 loop: 11 cel: 1 init:)
				(ad3 loop: 11 cel: 2 init:)
				(ad4 loop: 11 cel: 3 init:)
			)
		)
		(gAddToPics doit:)
		(HandsOn)
		(Delay (Random 40 120) 0 self)
	)

	(method (newRoom newRoomNumber)
		(blonde dispose:)
		(redHead dispose:)
		(gTheTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb &tmp [str 100])
		(switch theVerb
			(2 ; Look
				(Format ; "This end of the %s AeroDork Terminal lobby is distinguished only by a bank of pay telephones against the far wall. You feel AeroDork carries this "identical terminals" bit a little too far!"
					@str
					280
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

	(method (cue)
		(if (not onPhone)
			(announcement number: (Random 273 275) setLoop: 1 flags: 1 play:)
		)
		(Delay (Random 20 40) 2 self)
	)

	(method (notify what)
		(= numberDialed what)
		(switch what
			(4668
				(cond
					((!= gLarryLoc 1)
						(gCurRoom setScript: sPhone 0 50)
					)
					((not (IsFlag 1)) ; fCalledLimo
						(= validNumber 1)
						(gCurRoom setScript: sPhone 0 10)
					)
					(else
						(TPrint 280 1) ; "Darn. Their line is busy."
						(gCurRoom setScript: sPhone 0 60)
					)
				)
			)
			(4468
				(cond
					((!= gLarryLoc 2)
						(gCurRoom setScript: sPhone 0 50)
					)
					((not (IsFlag 1)) ; fCalledLimo
						(= validNumber 1)
						(gCurRoom setScript: sPhone 0 30)
					)
					(else
						(TPrint 280 1) ; "Darn. Their line is busy."
						(gCurRoom setScript: sPhone 0 60)
					)
				)
			)
			(8544
				(cond
					((!= gLarryLoc 3)
						(gCurRoom setScript: sPhone 0 50)
					)
					((and (not (IsFlag 8)) (not (IsFlag 1))) ; fBeenToTown, fCalledLimo
						(= validNumber 1)
						(gCurRoom setScript: sPhone 0 20)
					)
					(else
						(TPrint 280 1) ; "Darn. Their line is busy."
						(gCurRoom setScript: sPhone 0 60)
					)
				)
			)
			(1272
				(cond
					((!= gLarryLoc 3)
						(gCurRoom setScript: sPhone 0 50)
					)
					((not (IsFlag 12)) ; fCalledGreenCard
						(= validNumber 1)
						(gCurRoom setScript: sPhone 0 40)
					)
					(else
						(TPrint 280 1) ; "Darn. Their line is busy."
						(gCurRoom setScript: sPhone 0 60)
					)
				)
			)
			(3627
				(if (== gLarryLoc 3)
					(TPrint 280 1) ; "Darn. Their line is busy."
					(gCurRoom setScript: sPhone 0 60)
				else
					(TPrint 280 2) ; "You presume you must have dialed a wrong number."
					(gCurRoom setScript: sPhone 0 60)
				)
			)
			(-1
				(TPrint 280 3) ; "You change your mind and hang up the phone."
				(gCurRoom setScript: sPhone 0 60)
			)
			(else
				(TPrint 280 2) ; "You presume you must have dialed a wrong number."
				(gCurRoom setScript: sPhone 0 60)
			)
		)
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
		(cond
			(script)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(= gRedHeadX (redHead x:))
				(= gRedHeadLoop (redHead loop:))
				(= gBlondeX (blonde x:))
				(= gBlondeLoop (blonde loop:))
			)
			((gEgo inRect: -3 105 86 124)
				(if (and (not fighting) (not scaredBlonde))
					(= scaredBlonde 1)
					(blonde setScript: sBlonde 0 -100)
				)
				(if (and (not fighting) (not scaredRed))
					(= scaredRed 1)
					(redHead setScript: sRedHead 0 -100)
				)
			)
		)
	)
)

(instance lostDesk of Feature
	(properties
		x 300
		y 91
		nsTop 55
		nsLeft 282
		nsBottom 128
		nsRight 319
		description {the lost and found department}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 280 4) ; "This was once AeroDork's proud department of lost luggage mishandling. Since those big cutbacks, it's never been the same!"
			)
			(3 ; Do
				(TPrint 280 5) ; "You have no lost luggage to claim. Of course, if you did it wouldn't matter anyway, as there are no workers here to help you."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance largePlant of Feature
	(properties
		y 1
		nsTop 72
		nsLeft 76
		nsBottom 113
		nsRight 123
		description {the plant}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 280 6) ; "AeroDork has spared no expense to decorate this fabulous gateway."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance smallPlant of Feature
	(properties
		y 1
		nsTop 167
		nsLeft 256
		nsBottom 189
		nsRight 319
		description {the plant}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 280 6) ; "AeroDork has spared no expense to decorate this fabulous gateway."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance post of Feature
	(properties
		y 1
		nsLeft 225
		nsBottom 129
		nsRight 258
		description {the post}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 280 7) ; "Why would such a modern structure require a post so near a corner?"
			)
			(3 ; Do
				(TPrint 280 8) ; "Feeling that familiar sense of "adventure game frustration," you long to bang your head against that post in the corner, but refuse to give up!"
			)
			(5 ; Talk
				(TPrint 280 9) ; ""You know, I once had a girl friend that reminds me of talking to you," you say to the post."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ashtray of Feature
	(properties
		x 216
		y 150
		nsTop 136
		nsLeft 207
		nsBottom 164
		nsRight 226
		description {the ashtray}
		sightAngle 90
	)

	(method (doVerb theVerb invItem &tmp [str 30])
		(switch theVerb
			(2 ; Look
				(TPrint 280 10) ; "You appreciate the historical accuracy of an ashtray simulator in public places."
			)
			(3 ; Do
				(if (not (Random 0 1))
					(TPrint 280 11) ; "What did you expect? A disco admission card?"
				else
					(TPrint 280 12) ; "You want to put your butt in the ashtray?"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theCounter of Feature
	(properties
		x 43
		y 65
		nsTop 41
		nsBottom 89
		nsRight 87
		description {the counter}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Format ; "Once upon a time this ticket counter sold tickets. Now it provides a resting place for the last remaining AeroDork employees, %s and %s."
					@string
					280
					13
					(blonde description:)
					(redHead description:)
				)
				(TPrint @string)
			)
			(3 ; Do
				(Format ; "A few days ago, you could have bought a ticket here. But now %s and %s have nothing to do but stand around."
					@string
					280
					14
					(blonde description:)
					(redHead description:)
				)
				(TPrint @string)
				(TPrint 280 15 #at -1 185) ; "(So really, not that much has changed!)"
			)
			(5 ; Talk
				(TPrint 280 16) ; "You must have just missed them. Perhaps you should click on one of the girls, instead of on the ticket counter!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sofa of Feature
	(properties
		x 113
		y 153
		nsTop 127
		nsLeft 25
		nsBottom 180
		nsRight 202
		description {the sofa}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 280 17) ; "Evidently AeroDork Airline's automated flight handling is efficient--there's not one person waiting in this waiting room."
			)
			(3 ; Do
				(TPrint 280 18) ; "You're not really interested in sitting in those little puddles of overnight sleeper drool."
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
		signal 16384
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Format @string 280 19 (blonde description:)) ; "It's %s, AeroDork's blonde bombshell. Once she was a highly motivated employee. Once she was a highly trained professional. Once she never forgot to ask, "Didya wan'sum fries wit' dat?""
				(TPrint @string)
			)
			(3 ; Do
				(Format @string 280 20 (blonde description:)) ; "%s was once a ticket agent here. Now her only responsibility is to the few remaining employees: she fires them!"
				(TPrint @string)
			)
			(5 ; Talk
				(TPrint 280 21) ; "Excuse me, Miss. Could you help me?"
				(TPrint 280 22) ; ""Buddy, I don't think ANYONE could help you!" she replies sarcastically."
			)
			(4 ; Inventory
				(Format @string 280 23 (blonde description:)) ; "Get that away from me, dork!" shouts %s. "Anything YOU have, I don't want!"
				(TPrint @string)
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
		signal 16384
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Format @string 280 24 (redHead description:)) ; "It's %s. Once she was AeroDork's red-headed, red-blooded, red-hot, temptress of the flight path."
				(TPrint @string)
				(TPrint 280 25) ; "Now she's lucky if she even sees a pilot."
			)
			(3 ; Do
				(TPrint 280 26) ; "Excuse me, Clerk," you cry, "Could I buy a ticket here?"
				(TPrint 280 27) ; "Nope," she retorts with a snap of her gum, "we're all out. Try our ATM outside, ok?"
			)
			(5 ; Talk
				(TPrint 280 21) ; "Excuse me, Miss. Could you help me?"
				(TPrint 280 28) ; "Fella, I ain't interested in anyone that can't support me in the style to which I've grown accustomed to," she says, interrupting your clever inquiry. "And nobody I know is accustomed to a style like yours!"
			)
			(4 ; Inventory
				(Format @string 280 23 (redHead description:)) ; "Get that away from me, dork!" shouts %s. "Anything YOU have, I don't want!"
				(TPrint @string)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sRedHead of Script
	(properties)

	(method (changeState newState &tmp newX oldX)
		(switch (= state newState)
			(0
				(= oldX (redHead x:))
				(if register
					(= newX register)
				else
					(switch (Random 1 2)
						(1
							(= newX (Random 8 65))
						)
						(2
							(= newX (Random -100 -12))
						)
					)
				)
				(if
					(and
						(not register)
						(or
							(< newX (blonde x:) oldX)
							(< oldX (blonde x:) newX)
						)
					)
					(= cycles 1)
				else
					(redHead
						setLoop: -1
						setCycle: Fwd
						setMotion: MoveTo newX 82 self
					)
				)
			)
			(1
				(redHead setLoop: 4 setCycle: 0 setMotion: 0)
				(= seconds (Random 3 7))
			)
			(2
				(= scaredRed (= register 0))
				(self init:)
			)
		)
	)
)

(instance sBlonde of Script
	(properties)

	(method (changeState newState &tmp newX oldX)
		(switch (= state newState)
			(0
				(= oldX (blonde x:))
				(if register
					(= newX register)
				else
					(switch (Random 1 2)
						(1
							(= newX (Random 8 65))
						)
						(2
							(= newX (Random -100 -12))
						)
					)
				)
				(if
					(and
						(not register)
						(or
							(< newX (redHead x:) oldX)
							(< oldX (redHead x:) newX)
						)
					)
					(= cycles 1)
				else
					(blonde
						setLoop: -1
						setCycle: Fwd
						setMotion: MoveTo newX 82 self
					)
				)
			)
			(1
				(blonde setLoop: 3 setCycle: 0 setMotion: 0)
				(= seconds (Random 3 7))
			)
			(2
				(= scaredBlonde (= register 0))
				(self init:)
			)
		)
	)
)

(instance thePhone of Feature
	(properties
		description {the pay phone}
		sightAngle 40
	)

	(method (init)
		(self approachVerbs: 4 3 5 2) ; Inventory, Do, Talk, Look
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 280 29) ; "Finally, a working telephone!"
			)
			(3 ; Do
				(if (gEgo has: 10) ; Some_Change
					(TPrint 280 30) ; "You insert a quarter into the only working pay telephone."
					(gCurRoom setScript: sPhone)
				else
					(TPrint 280 31) ; "These telephones require a quarter. If you had a quarter, you could just stick it in the telephone and it would work."
				)
			)
			(4 ; Inventory
				(if (== invItem 10) ; Some_Change
					(gCurRoom setScript: sPhone)
				else
					(TPrint 280 32) ; "These telephones only accept quarters."
				)
			)
			(5 ; Talk
				(TPrint 280 31) ; "These telephones require a quarter. If you had a quarter, you could just stick it in the telephone and it would work."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance phoneHandle of View
	(properties
		description {the pay phone}
		view 280
		cel 1
		priority 4
		signal 16400
	)

	(method (init)
		(self
			approachVerbs: 4 3 5 2 ; Inventory, Do, Talk, Look
			approachX: (thePhone approachX:)
			approachY: (thePhone approachY:)
		)
		(super init:)
	)

	(method (doVerb)
		(thePhone doVerb: &rest)
	)
)

(instance p1 of Feature
	(properties
		x 153
		y 80
		nsTop 70
		nsLeft 145
		nsBottom 90
		nsRight 162
		description {the phone}
		sightAngle 40
	)

	(method (init)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
		(super init:)
	)

	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance p2 of Feature
	(properties
		x 175
		y 80
		nsTop 70
		nsLeft 167
		nsBottom 90
		nsRight 183
		description {the phone}
		sightAngle 40
	)

	(method (init)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
		(super init:)
	)

	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance p3 of Feature
	(properties
		x 199
		y 80
		nsTop 70
		nsLeft 193
		nsBottom 91
		nsRight 206
		description {the phone}
		sightAngle 40
	)

	(method (init)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
		(super init:)
	)

	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance p4 of Feature
	(properties
		x 221
		y 80
		nsTop 70
		nsLeft 214
		nsBottom 91
		nsRight 228
		description {the phone}
		sightAngle 40
	)

	(method (init)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 280 33) ; "This pay phone is broken."
			)
			(3 ; Do
				(TPrint 280 34) ; "You can't dial this telephone. It's broken."
			)
			(4 ; Inventory
				(if (== invItem 10) ; Some_Change
					(TPrint 280 35) ; "Save your quarter. This pay phone is broken."
				else
					(TPrint 280 32) ; "These telephones only accept quarters."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ph1 of PicView
	(properties
		x 152
		y 85
		view 280
		cel 1
	)

	(method (init)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
		(super init:)
	)

	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance ph2 of PicView
	(properties
		x 173
		y 85
		view 280
		cel 1
	)

	(method (init)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
		(super init:)
	)

	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance ph3 of PicView
	(properties
		x 196
		y 85
		view 280
		cel 1
	)

	(method (init)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
		(super init:)
	)

	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance ph4 of PicView
	(properties
		x 218
		y 85
		view 280
		cel 1
	)

	(method (init)
		(self approachVerbs: 2 3 4) ; Look, Do, Inventory
		(super init:)
	)

	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance ad1 of PicView
	(properties
		x 21
		y 9
		nsBottom 14
		nsRight 47
		description {the sign}
		sightAngle 90
		view 263
		priority 4
		signal 30736
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 280 36) ; "How do busy executives stay on top of world finance? "Businessmen's Financial Hourly," of course. All the financial news you need, delivered to your home or office every hour on the hour, all day, all night. Latest markets. Millions of pages a year of the information YOU need every minute to keep your business from sinking like a rock."
					)
					(1
						(TPrint 280 37) ; "The NYC Ballet Company's 2015th production of "Sleeping Beauty" opens August 15th. The NYC Times called it, "A classic... never gets all that boring, even though you've seen it several hundred times." Opening September 20: the 2016th production of "Sleeping Beauty." Call The Ticketster for details."
					)
					(2
						(TPrint 280 38) ; "Gambleholic's Anonymous. Kick the gambling habit! We'll lay you 2 to 1 we can clean up even the worst gambling problem. Meetings held on best 2 out of 3 Thursdays each month. Ex-major league baseball players admitted FREE!"
					)
					(3
						(Points 1 93)
						(TPrint 280 39) ; "Misplace" something? "Lose" something important? "Can't find" that important documentation? Let us help. We're "Just Green Cards" and we're here to help any alien who has "lost" their card! Just call me, Carlos, at 554-1272! You'll get your "replacement" immediately. And remember: "We deliver!!"
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
		x 98
		y 9
		nsLeft 62
		nsBottom 15
		nsRight 134
		description {the sign}
		sightAngle 90
		view 263
		priority 4
		signal 30736
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 280 40) ; "Suffering from copy machine breakdown? Tired of messy toner bottles? Sick of paper cartridges and service calls? Ready to rip the guts out of your piece-of-crap, document-mangling Shmearox copier? Call us. We're ACME Carbon Paper."
					)
					(1
						(TPrint 280 41 #mode 1) ; "We want your old jewelry. Rings, chains, earrings, brooches. No Money Paid. "Stick 'em Up Pawn Shop" 1525 Park Avenue West"
					)
					(2
						(TPrint 280 42) ; "Calling all married men! Entertain women discreetly and privately in our new "Stayfree Bachelor Pads." Exclusive panel slides into place whenever your wife knocks on the front door. Vibrating beds, imitation leopard-skin rugs, fake fireplaces. Contact Escobar Enterprises Estates today!"
					)
					(3
						(Points 1 96)
						(TPrint 280 43) ; "Welcome to Miami. Rent a limo for your stay. North Beach Limousine Rentals. Cheap. No client too old! 554-8544"
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
		x 183
		y 11
		nsLeft 148
		nsBottom 16
		nsRight 221
		description {the sign}
		sightAngle 90
		view 263
		priority 4
		signal 30736
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 280 44) ; "When the sharpest image counts, count on Canonan camcorders. The official camcorder of the Amateur Cinematographer's Committee on Los Angeles Police Conduct. "I love it! I'm gonna get one when I get these bandages off!" says a Mr. R. King of Los Angeles, California."
					)
					(1
						(TPrint 280 45) ; "Dr. Seymour Weiners of the Weiners Clinic says, "Chronic fatigue? Prostate problems? Hemorrhoids? Kidney stones? Liver spots? Osteoporosis? Arthritis? Psoriasis? Cataracts? Incontinence? Allergies? Hernia? Yecch! Go somewhere else, okay?""
					)
					(2
						(TPrint 280 46) ; "New Jersey Associated Faux Health Clubs. Slim down the fast, easy way. No weight equipment, no exercycles, no treadmills. One aging anorexic celebrity says, "Dieting doesn't give you a great body. But having your fat sucked out with a teeny little vacuum cleaner sure does!" Come by today."
					)
					(3
						(TPrint 280 47) ; "This man is hanging in midair... by his gums! Is he crazy? Yes, crazy about "Krazy Dentu-Poxy." Guaranteed to keep dentures from wiggling, slipping or falling out for the rest of your life. Bonds denture material to flesh permanently in seconds. Eat corn-on-the-cob, apples, rock candy, and furnace clinkers just like you used to."
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
		x 314
		y 23
		nsLeft 295
		nsBottom 31
		nsRight 319
		description {the sign}
		sightAngle 90
		view 263
		priority 4
		signal 30736
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gLarryLoc
					(0
						(TPrint 280 48) ; "BIG-R'S CREDIT Need credit? Need a loan? Or just want to talk to someone who really understands what "deep in debt" really means? Call Roger H at Big R's Credit Carnival! Applications accepted over the phone. $10.00 non-refundable service charge might even be tax deductible!"
					)
					(1
						(TPrint 280 49) ; "The Mayor's Office is pleased to announce the 25th Annual "Why I Love New York Even Though You Take Your Life In Your Hands Every Time You Open Your Front Door and Who Can Afford To Live Here Anymore Anyway?" Songwriting Contest. Forms available at City Hall."
					)
					(2
						(TPrint 280 50) ; "Now through December at the Conventional Center: "An Evening With Bobby Vinton." New Jersey Herald says, "Bobby sings all his hits, including `Blue Velvet,' `Red Roses For A Blue Lady,' `Blue Roses For A Red Lady,' `You Only Look Blue When You're Standing Next To All Those Red Roses,' and `Blue Ladies Plus Red Roses Equals Purple Velvet.' A must see!" Call TicketMonster for details."
					)
					(3
						(TPrint 280 51) ; "Jiffy-Pace Lube-and-Battery service. We'll have your pacemaker in and out within 15 minutes or your money back! Free valve check. (We use only Catatonic State Motor Oil.)"
					)
				)
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

(instance phoneBook1 of Feature
	(properties
		x 169
		y 91
		nsTop 86
		nsLeft 160
		nsBottom 97
		nsRight 176
		description {the telephone directory}
		sightAngle 40
		onMeCheck 2
		approachX 169
		approachY 112
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 280 52) ; "There are two local telephone directories hanging from the pay telephones."
			)
			(3 ; Do
				(TPrint 280 53) ; "Opening the plastic telephone directory covers, you notice someone has thoughtfully ripped out all the pages to prevent needless alphabetical confusion on your part!"
				(TPrint 280 54) ; "Now how will you dial the right number?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance phoneBook2 of Feature
	(properties
		x 207
		y 91
		nsTop 87
		nsLeft 200
		nsBottom 96
		nsRight 214
		description {the telephone directory}
		sightAngle 40
		onMeCheck 2
		approachX 207
		approachY 112
	)

	(method (doVerb theVerb invItem)
		(phoneBook1 doVerb: theVerb &rest)
	)
)

(instance sFight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= fighting 1)
				(= cycles 2)
			)
			(1
				(HandsOff)
				(blonde setMotion: MoveTo -40 84 self)
			)
			(2
				(blonde
					view: 277
					posn: -40 82
					setScript: sBlonde
					ignoreActors: 1
					setLoop: 0
				)
				(redHead
					view: 276
					posn: -70 82
					setLoop: 0
					setScript: sRedHead
					ignoreActors: 1
					show:
				)
				(HandsOn)
				(= fighting 0)
				(self dispose:)
			)
		)
	)
)

(instance sPhone of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] [temp2 80])
		(switch (= state newState)
			(0
				(HandsOff)
				(= onPhone 1)
				(if (not register)
					(gEgo
						view: 281
						setLoop: 0
						setCel: 0
						cycleSpeed: 10
						setCycle: CT 4 1 self
					)
				else
					(self changeState: register)
				)
			)
			(1
				(gTheMusic2 number: 36 loop: 1 play:)
				(phoneHandle hide:)
				(gEgo setCycle: End self)
			)
			(2
				(User canInput: 1)
				((ScriptID 20 0) init: 1) ; TTDialer
			)
			(10
				(Points 3 1)
				(SetFlag 38) ; fLimoParked
				(TPrint 280 55 #at -1 28) ; "Hello, Checker Limo. Wearya? Weardjawannago?"
				(= ticks 30)
			)
			(11
				(TPrint 280 56) ; "Uh, my name is Larry; Larry Laffer," you say, "What was the question again?"
				(= ticks 30)
			)
			(12
				(TPrint 280 57 #at -1 28) ; "Waddaya deff? Wearya? Weardjawannago?"
				(= ticks 30)
			)
			(13
				(TPrint 280 58) ; "Oh, I'm at the airport. At the AeroDork Terminal."
				(= ticks 30)
			)
			(14
				(TPrint 280 59 #at -1 28) ; "Weardjawannago?"
				(= ticks 30)
			)
			(15
				(TPrint 280 60) ; "Oh, I guess I'd like to go downtown."
				(= ticks 30)
			)
			(16
				(TPrint 280 61 #at -1 28) ; "Gotcha. Mee'cha ou'side."
				(= ticks 30)
			)
			(17
				(TPrint 280 62 #at -1 185) ; "(And he hangs up the phone.)"
				(self changeState: 60)
			)
			(20
				(Points 3 1)
				(SetFlag 38) ; fLimoParked
				(TPrint 280 63 #at -1 28) ; "Good afternoon, and welcome to lovely Miami," a pleasant voice answers the telephone. "How may North Beach Limousine Service assist you today?"
				(= ticks 30)
			)
			(21
				(TPrint 280 64) ; "Hello. My name is Larry; Larry Laffer," you say, "I'm at the AeroDork Terminal at the airport."
				(= ticks 30)
			)
			(22
				(TPrint 280 65 #at -1 28) ; "Very well, Sir. And how will you be paying today?"
				(= ticks 30)
			)
			(23
				(TPrint 280 66) ; ""Uh, would you take an AeroDork Gold Card?" you say."
				(= ticks 30)
			)
			(24
				(TPrint 280 67 #at -1 28) ; "Ahhh, but of course, sir! Your limousine will be outside in a few seconds!"
				(TPrint 280 68 #at -1 28) ; "He concludes, "And thank you for thinking of us!""
				(= ticks 30)
			)
			(25
				(TPrint 280 62 #at -1 185) ; "(And he hangs up the phone.)"
				(self changeState: 60)
			)
			(30
				(Points 3 1)
				(SetFlag 38) ; fLimoParked
				(TPrint 280 69 #at -1 28) ; "Good day. Tramp Limousine at your service."
				(= ticks 30)
			)
			(31
				(TPrint 280 70) ; "Good day, Mr. Tramp," you presume, mistakenly. "I'm at the airport, and require transportation to the city."
				(= ticks 30)
			)
			(32
				(TPrint 280 71 #at -1 28) ; "Yes sir!" he replies, "I'll send one of my best girls right over!"
				(= ticks 30)
			)
			(33
				(TPrint 280 62 #at -1 185) ; "(And he hangs up the phone.)"
				(self changeState: 60)
			)
			(40
				(Points 7 12)
				(TPrint 280 72) ; "`JesGreeenCars.' Si habla Espanol y Eeengleesh. Haf ju `lost jour carrrd?'"
				(= ticks 30)
			)
			(41
				(TPrint 280 73) ; "Hello, I'm looking for a limousine to take me from the airport into town, I guess."
				(= ticks 30)
			)
			(42
				(TPrint 280 74) ; "Ho-kay. Aeropuerto? Ho-kay. Wee deeleefer jur carrrd! On dee trash can. Outside de aeropuerto. Ju leeef a-ten-dousand pesos outside de aeropuerto. On dee trash can. No problemo!"
				(= ticks 30)
			)
			(43
				(TPrint 280 62 #at -1 185) ; "(And he hangs up the phone.)"
				(self changeState: 60)
			)
			(50
				(TPrint 280 75) ; "Please deposit seventy-five cents for the next three minutes."
				(= ticks 30)
			)
			(51
				(Format ; "Since you don't have three quarters, you decide not to call %s."
					@temp2
					280
					76
					(switch numberDialed
						(3627 {Miami})
						(4668 {New York City})
						(4468 {Atlantic City})
						(8544 {Miami})
						(1272 {Miami})
					)
				)
				(TPrint @temp2 #at -1 185)
				(= ticks 30)
			)
			(52
				(self changeState: 60)
			)
			(60
				(= ticks 10)
			)
			(61
				(gEgo setCycle: CT 4 -1 self)
			)
			(62
				(phoneHandle show:)
				(gEgo setCycle: Beg self)
			)
			(63
				(gTheMusic2 number: 37 loop: 1 play:)
				(if (and validNumber (not (-- gQuarters)))
					(= gQuarters -1)
					(gEgo put: 10) ; Some_Change
				)
				(gEgo setLoop: 3 normalize:)
				(= validNumber 0)
				(= onPhone (= register 0))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance phones of PicView
	(properties
		x 185
		y 1
		z -100
		description {the pay phones}
		approachX 180
		approachY 112
		view 280
		priority 0
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

