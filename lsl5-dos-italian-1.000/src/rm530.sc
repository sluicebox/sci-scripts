;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	michelleCount
	talkedToTable1
	talkedToTable2
	talkedToTable3
	cueCounter
	cueCounter0
	cueCounter2
)

(instance rm530 of LLRoom
	(properties
		picture 530
		south 525
	)

	(method (init)
		(LoadMany rsVIEW 531 1530)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 239 189 255 148 208 123 183 120 166 106 92 106 53 138 55 159 128 170 129 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 175 141 203 137 226 141 249 154 236 163 220 166
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 202 160 187 168 161 163 150 153 187 153
					yourself:
				)
		)
		(drape1 init: stopUpd:)
		(drape2 init: stopUpd:)
		(drape3 init: stopUpd:)
		(cactus init:)
		(cart init:)
		(light init:)
		(theTable init:)
		(chair init:)
		(iceCream init:)
		(if (!= gPrevRoomNum 535)
			(table1 init:)
			(table2 init:)
			(table3 init:)
			(extra1 init:)
			(extra2 init:)
			(extra3 init:)
			(extra4 init:)
			(extra5 init:)
			(gEgo init: normalize: posn: 151 234 edgeHit: 0)
			(michelle init: setScript: sMichelleEating)
			(drape4 init: stopUpd:)
			(self setScript: sEnter)
		else
			(michelle init:)
			(gEgo
				init:
				view: 531
				setLoop: 1
				posn: 260 143
				setCel: 255
				setCycle: 0
			)
			(if (not (IsFlag 16))
				(SetFlag 16)
				(drape4 init: setCel: 0 stopUpd:)
				(self setScript: sCloseCurtain)
			else
				(drape4 init: setCel: 255 stopUpd:)
				(self setScript: sOpenCurtain)
			)
		)
		(gAddToPics doit:)
		(if (!= (gTheMusic number:) 535)
			(gTheMusic number: 535 setLoop: -1 flags: 1 play:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 530 0) ; "Now you understand why this is such an exclusive room. It's quiet, lovely and private."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(Say ; ""Nearly as many times as I'm here," she responds."
							Michelle_Milken_IMichelle_Milken
							530
							1
							108
							139
							self
						)
					)
					(1
						(Say ; "That may be, but I look even better out of it!"
							Michelle_Milken_IMichelle_Milken
							530
							2
							108
							139
							self
						)
					)
					(2
						(Say ; "Well, you may sit down, but it may be for dessert!"
							Michelle_Milken_IMichelle_Milken
							530
							3
							108
							139
							self
						)
					)
				)
			)
			(1
				(switch register
					(0
						(TPrint 530 4 67 -1 185) ; "(Now what did THAT mean?)"
						(self dispose:)
					)
					(1
						(TPrint 530 5 67 -1 185) ; "(Say, this may turn out all right yet!)"
						(self dispose:)
					)
					(2
						(TPrint 530 6 67 -1 185) ; "(A better offer you've never had, Larry! Go for it!!)"
						(gCurRoom setScript: sDoMichelle)
					)
				)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 199 155 self)
			)
			(1
				(gEgo
					view: 531
					x: 193
					y: 151
					setLoop: 0
					setCel: 0
					setCycle: 0
				)
				(= cycles 1)
			)
			(2
				(gEgo setLoop: 0 setCel: 1 setPri: 14)
				(= cycles 1)
			)
			(3
				(gEgo setLoop: 0 setCycle: End self)
			)
			(4
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sCloseCurtain of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (gTheMusic number:) 535) (== (gTheMusic prevSignal:) 10))
			(gTheMusic number: 538 play:)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(drape4 setCycle: End self)
			)
			(2
				(= seconds 4)
			)
			(3
				(gCurRoom newRoom: 535)
			)
		)
	)
)

(instance sDoMichelle of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					normalize:
					posn: 197 154
					setPri: 14
					setMotion: PolyPath 260 143 self
				)
			)
			(2
				(gEgo
					setPri: -1
					view: 531
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo setCel: (gEgo cel:) setMotion: MoveTo 263 142 self)
			)
			(4
				(= seconds 5)
			)
			(5
				(gCurRoom newRoom: 535)
			)
		)
	)
)

(instance sMichelleEating of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch (Random 1 4)
					(1
						(= cycles (= state 1))
					)
					(2
						(= seconds 4)
					)
					(else
						(= state 6)
						(= cycles 1)
					)
				)
			)
			(1
				(self init:)
			)
			(2
				(michelle setLoop: 4 setCel: 0 setCycle: End self)
			)
			(3
				(= seconds (Random 2 4))
			)
			(4
				(michelle setCycle: Beg self)
			)
			(5
				(= seconds 2)
			)
			(6
				(self init:)
			)
			(7
				(michelle setLoop: 5 setCel: 0 setCycle: End self)
			)
			(8
				(= seconds 2)
			)
			(9
				(self init:)
			)
		)
	)
)

(instance sOpenCurtain of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(Say Michelle_Milken_IMichelle_Milken 530 7 108) ; ""Allow me to make our booth just a little more private," says Michelle, standing up."
				(drape4 setCycle: Beg self)
			)
			(2
				(HandsOn)
				(gEgo normalize:)
			)
		)
	)
)

(instance michelle of Prop
	(properties
		x 237
		y 143
		z 40
		description {her}
		view 530
		loop 5
		priority 1
		signal 2064
	)

	(method (doVerb theVerb invItem)
		(theTable doVerb: theVerb invItem)
	)
)

(instance drape1 of Prop
	(properties
		x 89
		y 36
		description {the curtain}
		view 530
		loop 1
		priority 7
		signal 16400
	)

	(method (cue)
		(switch (++ cueCounter0)
			(1
				(super cue:)
				(self setCycle: End self)
				(table1 dispose:)
				(extra1 dispose:)
				(extra2 dispose:)
				(= talkedToTable1 1)
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
			)
			(2
				(self stopUpd:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 530 8) ; "Every booth has curtains to assure your total privacy while dining."
			)
			(3 ; Do
				(TPrint 530 9) ; "There's nothing you can do with the curtains."
			)
			(5 ; Talk
				(if talkedToTable1
					(switch (Random 1 3)
						(1
							(TPrint 530 10) ; "They don't want to talk to you, Larry!"
						)
						(2
							(TPrint 530 11) ; "Just leave them alone!"
						)
						(3
							(TPrint 530 12) ; "Don't you get the hint? They don't want to talk to you!"
						)
					)
				else
					(table1 doVerb: 5)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drape2 of Prop
	(properties
		x 134
		y 101
		description {the curtain}
		view 530
		loop 3
		signal 16384
	)

	(method (cue)
		(super cue:)
		(switch (++ cueCounter)
			(1
				(TPrint 530 13 108 self) ; "DEAR!" interrupts his wife, "that's not necessary! This is a family restaurant!"
			)
			(2
				(self setCycle: End self)
				(table2 dispose:)
				(extra4 dispose:)
				(extra5 dispose:)
				(= talkedToTable2 1)
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
			)
			(3
				(self stopUpd:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 530 9) ; "There's nothing you can do with the curtains."
			)
			(2 ; Look
				(TPrint 530 8) ; "Every booth has curtains to assure your total privacy while dining."
			)
			(5 ; Talk
				(if talkedToTable2
					(drape1 doVerb: 5)
				else
					(table2 doVerb: 5)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drape3 of Prop
	(properties
		x 211
		y 35
		description {the curtain}
		view 530
		loop 2
		priority 7
		signal 16400
	)

	(method (cue)
		(switch (++ cueCounter2)
			(1
				(super cue:)
				(TPrint 530 14) ; ""Why doesn't that come as a surprise?" the woman replies snootily."
				(self setCycle: End self)
				(table3 dispose:)
				(extra3 dispose:)
				(= talkedToTable3 1)
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
			)
			(2
				(self stopUpd:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 530 9) ; "There's nothing you can do with the curtains."
			)
			(2 ; Look
				(TPrint 530 8) ; "Every booth has curtains to assure your total privacy while dining."
			)
			(5 ; Talk
				(if talkedToTable3
					(drape1 doVerb: 5)
				else
					(table3 doVerb: 5)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drape4 of Prop
	(properties
		x 279
		y 55
		description {the curtain}
		view 530
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(theTable doVerb: theVerb invItem)
	)
)

(instance iceCream of PicView
	(properties
		x 244
		y 109
		description {her ice cream}
		sightAngle 90
		view 530
		loop 6
		cel 5
		signal 6144
	)
)

(instance extra1 of PicView
	(properties
		x 63
		y 89
		description {the couple}
		sightAngle 90
		view 530
		loop 6
		cel 1
		priority 5
		signal 6160
	)
)

(instance extra2 of PicView
	(properties
		x 80
		y 88
		description {the couple}
		sightAngle 90
		view 530
		loop 6
		cel 2
		priority 5
		signal 6160
	)
)

(instance extra3 of PicView
	(properties
		x 184
		y 88
		description {the couple}
		sightAngle 90
		view 530
		loop 6
		priority 4
		signal 6160
	)
)

(instance extra4 of PicView
	(properties
		x 119
		y 78
		description {the couple}
		sightAngle 90
		view 530
		loop 6
		cel 3
		priority 4
		signal 6160
	)
)

(instance extra5 of PicView
	(properties
		x 140
		y 77
		description {the couple}
		sightAngle 90
		view 530
		loop 6
		cel 4
		priority 5
		signal 6160
	)
)

(instance chair of Feature
	(properties
		x 179
		y 144
		nsTop 126
		nsLeft 162
		nsBottom 163
		nsRight 196
		description {your chair}
		sightAngle 40
		lookStr {It's the only place you've got to sit. And you like it!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 530 15) ; "You can't stand up; you have nowhere else to go."
			)
			(1 ; Walk
				(TPrint 530 16) ; "Why not talk to that beautiful woman instead. Go on, Larry; strike up a conversation."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cactus of Feature
	(properties
		x 91
		y 143
		nsTop 107
		nsLeft 43
		nsBottom 180
		nsRight 140
		description {the cactus}
		sightAngle 40
		onMeCheck 4
		lookStr {Isn't it funny how this cactus blooms when none of the others do.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say gEgo 530 17) ; "OUCH!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance table1 of Feature
	(properties
		x 67
		y 95
		nsTop 73
		nsLeft 45
		nsBottom 107
		nsRight 90
		description {the table}
		sightAngle 40
		lookStr {Here's another couple having a wonderful evening while you wander around all alone again!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 530 18) ; "You can't sit with a strange couple!"
			)
			(5 ; Talk
				(if (not talkedToTable1)
					(HandsOff)
					(Say gEgo 530 19 67 -1 185) ; ""Excuse me, may I join you?" you ask the couple at the left table."
					(TPrint 530 20 108 drape1) ; "No. I'm sorry, but we're eating." replies the wit at the table. "And I don't want to lose my appetite."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance table2 of Feature
	(properties
		x 132
		y 195
		nsTop 60
		nsLeft 109
		nsBottom 92
		nsRight 155
		description {the table}
		sightAngle 40
		lookStr {Here's another couple having a wonderful evening while you wander around New York City all alone!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 530 18) ; "You can't sit with a strange couple!"
			)
			(5 ; Talk
				(if (not talkedToTable2)
					(HandsOff)
					(Say gEgo 530 21 67 -1 185) ; "Excuse me," you shout to that far table, "but can you explain why I don't talk to that lovely woman sitting all alone at that table in the corner?"
					(TPrint 530 22 108 drape2) ; "Could your head be up your..."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance table3 of Feature
	(properties
		x 187
		y 95
		nsTop 67
		nsLeft 173
		nsBottom 104
		nsRight 201
		description {the table}
		sightAngle 40
		lookStr {Here's another couple having a wonderful evening while you wander around all alone again!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 530 18) ; "You can't sit with a strange couple!"
			)
			(5 ; Talk
				(if (not talkedToTable3)
					(HandsOff)
					(Say gEgo 530 23 67 -1 185 108 drape3) ; ""Hi, folks; I'm from out of town!" you yell to the diners at the table across the room."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theTable of Feature
	(properties
		x 246
		y 140
		nsTop 75
		nsLeft 214
		nsBottom 132
		nsRight 279
		description {the table}
		sightAngle 40
		lookStr {A breathtakingly beautiful black woman sits alone at a booth, playing slowly and sensually with her dessert. It's Michelle Milken. You've found her, Larry!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 530 24) ; "You know what you want to do, Larry. Your problem is figuring out how to do it!"
			)
			(4 ; Inventory
				(TPrint 530 25) ; "Perhaps you should sit down with her first."
			)
			(10 ; Zipper
				(TPrint 530 26) ; "A little premature, aren't you, Larry? Maybe first a little dinner, then a show, perhaps a little dancing...."
			)
			(5 ; Talk
				(switch (++ michelleCount)
					(1
						(Say gEgo 530 27 67 -1 185) ; "Hello, Lovely Lonely Lady," you say to the gorgeous babe sitting all alone in the booth near you. "Allow me to introduce myself. My name is Larry; Larry Laffer."
						(TPrint 530 28) ; "You hope she doesn't just ignore you."
						(Say Michelle_Milken_IMichelle_Milken 530 29 108) ; "Hi, Larry," she says with a friendly smile, "new in town?"
					)
					(2
						(Say gEgo 530 30 67 -1 185) ; "Remembering your boss' warning not to reveal your identity, you decide to begin with a casual opener, "Do you come here often?" you ask."
						(gCurRoom setScript: sTalk 0 0)
					)
					(3
						(Say gEgo 530 31 67 -1 185) ; "Perhaps I could mention her "power clothes," you think to yourself. A compliment on her apparel might be appropriate..."
						(Say gEgo 530 32 67 -1 185) ; "What a lovely dress you're almost wearing," you tell her. "And you certainly look good in it!"
						(gCurRoom setScript: sTalk 0 1)
					)
					(4
						(Say gEgo 530 33 67 -1 185) ; ""I notice you're dining alone," you try again."
						(Say Michelle_Milken_IMichelle_Milken 530 34 108) ; ""Yes, and dining isn't the only thing I don't enjoy doing alone!" she responds with a smile."
					)
					(else
						(Say gEgo 530 35 67 -1 185) ; ""I was wondering: may I join you for dinner?" you ask."
						(gCurRoom setScript: sTalk 0 2)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cart of Feature
	(properties
		x 206
		y 139
		nsTop 125
		nsLeft 188
		nsBottom 154
		nsRight 225
		description {the serving cart}
		sightAngle 40
		lookStr {It looks like this cart is the only table available.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 530 36) ; "You can't move the cart. Then you'd have no table!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 144
		y 140
		z 86
		nsTop 40
		nsLeft 121
		nsBottom 65
		nsRight 167
		description {the lamp}
		sightAngle 40
		onMeCheck 2
		lookStr {It casts an even illumination.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Michelle_Milken_IMichelle_Milken of Talker
	(properties
		name {Michelle Milken}
		nsTop 15
		nsLeft 30
		view 1530
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust talkerBust)
		(= eyes talkerEyes)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerBust of View
	(properties
		view 1530
		loop 1
	)
)

(instance talkerEyes of Prop
	(properties
		nsTop 27
		nsLeft 20
		view 1530
		loop 2
		cycleSpeed 30
	)
)

(instance talkerMouth of Prop
	(properties
		nsTop 37
		nsLeft 26
		view 1530
	)
)

