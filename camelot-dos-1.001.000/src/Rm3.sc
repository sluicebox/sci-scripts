;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Game)
(use User)
(use System)

(public
	Rm3 0
)

(local
	local0
	[local1 18] = [216 202 180 159 195 146 137 185 185 144 132 124 134 69 58 97 93 0]
	[local19 27] = [61 44 27 37 92 47 46 66 80 83 75 83 94 88 104 112 127 0 0 45 90 135 180 225 270 315 360]
)

(procedure (localproc_0 param1 param2 &tmp [temp0 4] temp4 temp5 temp6 temp7)
	(-= param2 1)
	(TextSize @[temp0 0] param1 4 290)
	(= temp6 (- [temp0 3] [temp0 1]))
	(= temp7 (- [temp0 2] [temp0 0]))
	(= temp4 (- [local1 param2] temp6))
	(if (< (= temp5 (- [local19 param2] (+ temp7 10))) 10)
		(= temp5 (+ [local19 param2] 10))
	)
	(Print param1 #at 11 temp5 #font 4 #width 290)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp2 -1)
	(= temp1 10000)
	(if (> (+= param1 (* param3 25)) 360)
		(= param1 360)
	)
	(if (< (-= param2 (* param3 25)) 0)
		(= param2 0)
	)
	(= temp3 (+ 50 (* param3 10)))
	(for ((= temp0 0)) (< temp0 17) ((++ temp0))
		(if (!= temp0 local0)
			(= temp5
				(GetAngle
					[local1 local0]
					[local19 local0]
					[local1 temp0]
					[local19 temp0]
				)
			)
			(= temp6
				(GetDistance
					[local1 local0]
					[local19 local0]
					[local1 temp0]
					[local19 temp0]
				)
			)
			(= temp4 (+ 1 (/ (Abs (- (- param1 44) temp5)) 22)))
			(if
				(and
					(< temp6 temp3)
					(<= temp5 param1)
					(or
						(and (>= param2 0) (>= temp5 param2))
						(and
							(<= param2 0)
							(or (>= temp5 (+ 360 param2)) (>= temp5 0))
						)
					)
					(< (* temp4 temp6) temp1)
				)
				(= temp1 (* temp4 temp6))
				(= temp2 temp0)
			)
		)
	)
	(return temp2)
)

(instance Rm3 of Rm
	(properties
		picture 3
	)

	(method (init)
		(super init:)
		(HandsOff)
		(User canControl: 1)
		(= local0 9)
		(gEgo
			view: 101
			setLoop: 2
			setCel: 0
			posn: [local1 9] [local19 9]
			init:
		)
		(proc0_13 258)
		(gAddToPics doit:)
		(Display 3 0 dsCOORD 50 174 dsFONT 4 dsWIDTH 80 dsCOLOR 12 dsBACKGROUND 14) ; "PRESS F6 TO EXIT"
		(Print 3 1 #at 28 9 #window SysWindow #dispose #font 4) ; "Use arrows to move, or select with mouse."
		(self setScript: showInfo)
	)

	(method (doit)
		(if (GameIsRestarting)
			(Display 3 0 dsCOORD 50 174 dsFONT 4 dsWIDTH 80 dsCOLOR 12 dsBACKGROUND 14) ; "PRESS F6 TO EXIT"
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(switch (event type:)
			(evMOUSEBUTTON
				(event claimed: 1)
				(if (and (<= 51 (event x:) 131) (<= 174 (event y:) 180))
					(User canControl: 1)
					(gCurRoom newRoom: 2)
				)
				(clr)
				(= temp0 (event x:))
				(= temp1 (event y:))
				(for ((= temp2 0)) (< temp2 17) ((++ temp2))
					(if
						(and
							(>= temp0 [local1 temp2])
							(<= temp0 (+ [local1 temp2] 4))
							(>= temp1 [local19 temp2])
							(<= temp1 (+ [local19 temp2] 3))
						)
						(= local0 temp2)
						(if
							(and
								(== (gEgo x:) [local1 local0])
								(== (gEgo y:) [local19 local0])
							)
						else
							(gEgo posn: [local1 local0] [local19 local0])
							(RedrawCast)
							(showInfo changeState: (+ local0 1))
						)
						(break)
					)
				)
			)
			(evKEYBOARD
				(if (== (event message:) KEY_RETURN)
					(event claimed: 1)
					(if gModelessDialog
						(clr)
					else
						(showInfo changeState: (+ local0 1))
					)
				)
				(if (== (event message:) KEY_F6)
					(event claimed: 1)
					(User canControl: 1)
					(gCurRoom newRoom: 2)
				)
			)
			($0040 ; direction
				(event claimed: 1)
				(clr)
				(switch (event message:)
					(JOY_UP
						(= temp3 -45)
						(= temp4 45)
					)
					(JOY_UPRIGHT
						(= temp3 0)
						(= temp4 90)
					)
					(JOY_RIGHT
						(= temp3 45)
						(= temp4 135)
					)
					(JOY_DOWNRIGHT
						(= temp3 90)
						(= temp4 180)
					)
					(JOY_DOWN
						(= temp3 135)
						(= temp4 225)
					)
					(JOY_DOWNLEFT
						(= temp3 180)
						(= temp4 270)
					)
					(JOY_LEFT
						(= temp3 225)
						(= temp4 315)
					)
					(JOY_UPLEFT
						(= temp3 270)
						(= temp4 360)
					)
				)
				(= temp6 0)
				(while (< temp6 2)
					(if (>= (= temp5 (localproc_1 temp4 temp3 temp6)) 0)
						(clr)
						(= local0 temp5)
						(gEgo posn: [local1 local0] [local19 local0])
						(RedrawCast)
						(showInfo changeState: (+ local0 1))
						(break)
					else
						(++ temp6)
					)
				)
			)
			(evSAID
				(cond
					((Said 'look[/room,chart]')
						(Print 3 2) ; "You see the Summer Lands, as your kingdom is often known, with Cornwall to the west and river Thames coming from the east."
						(Print 3 3) ; "Take careful note of the locations that may be of import to your search. This will prevent you from wasting much time later."
					)
					((or (Said 'look<away') (Said 'exit,exit'))
						(gCurRoom newRoom: 2)
					)
				)
			)
		)
	)
)

(instance showInfo of Script
	(properties)

	(method (init)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(localproc_0
					{ST. LEONARD'S FOREST\nIt is said that here the holy hermit, St. Leonard, did slay a most fearsome dragon. Where the saint's blood fell upon the ground, lillies-of-the-valley sprouted and flourished in his honor.}
					state
				)
			)
			(2
				(localproc_0
					{WINDSOR\nThese fertile hunting grounds have long been protected by Cernunnos, Celtic god of the underworld. He has large stag's antlers upon his head and wears a golden torc about his neck.}
					state
				)
			)
			(3
				(localproc_0
					{OT MOOR\nThough the waters of the moor are not deep, they are reputed to have healing powers. This is where the Lady of the Lake currently dwells. Her wisdom and power rivals my own.}
					state
				)
			)
			(4
				(localproc_0
					{AVEBURY\nOn this site stands the largest of the stone circles, the remains of an ancient place of worship. It is surrounded by a bank and ditch with a diameter of 1400 ft. The circle is formed of almost 100 megaliths, some weighing up to 60 tons.}
					state
				)
			)
			(5
				(localproc_0
					{MOTTISTONE\nUpon the Isle of Wight, Druid priests are reputed to have sacrificed white bulls. In this place are two great stones: an upright stone representing their God and a horizontal stone representing their Goddess. Mottistone means "the speaker's stone".}
					state
				)
			)
			(6
				(localproc_0
					{BATH\nOver 800 years before the birth of Christ, Prince Bladud, son of a king, contracted the dread disease of leprosy. Unable to remain in human company, he turned to tending swine, but they, too, caught the disease. One day the swine ran wild and plunged into the dark, foul-smelling waters of a bog. When Bladud pulled them out, he discovered that the waters had healed both the animals and himself. The healing waters of Bath are famous to this day.}
					state
				)
			)
			(7
				(localproc_0
					{KEYNSHAM\nA 6th century prince of Wales named Braglan had a daughter named Keyne. She came to a town wherein the lord gave her a piece of land that she might preach Christianity, but the land was heavily infested with large, venomous snakes. She at once turned the snakes into stone. She is remembered as St. Keyne and the town is named after her.}
					state
				)
			)
			(8
				(localproc_0
					{WINCHESTER\nI have heard tell that St. Swithun, the bishop of Winchester, is a performer of miracles. One story has come to my ears that he saw a poor woman on her way to a market with a basket of eggs. She bumped into a monk and all her eggs were broken. St. Swithun took pity upon her and made the eggs whole again. Or so they say.}
					state
				)
			)
			(9
				(localproc_0
					{SOUTHAMPTON\nThe legend goes that Sir Bevis, a hero of long ago, killed the evil giant Ascapart here. This is also the port from which one would take ship to sail to all parts of the known world.}
					state
				)
			)
			(10
				(localproc_0
					{CAMELOT\nYou are here, m'lord, as you surely know.}
					state
				)
			)
			(11
				(localproc_0
					{GLASTONBURY TOR\nThis hill has been revered for countless centuries. To the Celts, it was Ynys-Witrin, the Island of Glass, so-called because the lands around it were often flooded. It is also said that Joseph of Arimathea, who supervised the burial of Jesus, brought the Grail here and that where he stuck his staff into the ground, a Holy Thorn tree grew. Many religious orders have since come and gone and left their ruins behind. To reach the tor now, one must travel through the Forest Perilous.}
					state
				)
			)
			(12
				(localproc_0
					{SHAPWICK\nSt. Indractus, along with his sister, Drusa and other pilgrims, were passing through here on their way back to Ireland from Rome. They were carrying bags of seed corn to give to the poor. Saxon outlaws murdered them, thinking their bags were filled with gold. The crime was discovered when a beam of light shone for 3 days and 3 nights upon the burial pit. Confronted with their deed, the Saxons went mad and destroyed one another.}
					state
				)
			)
			(13
				(localproc_0
					{HALSTOCK\nA pious woman, St. Juthware, would open her house to pilgrims on their way to a nearby shrine. This so enraged her brother that he took up his sword and cut off her head. The story says that Juthware picked up her own head and carried it to the local altar before she finally died.}
					state
				)
			)
			(14
				(localproc_0
					{BRAUNTON\nMany miracles dealing with animals are connected to St. Brannoc, who reportedly sailed from Wales in a stone coffin. A sow and piglets showed him where to establish his chapel. He used wild deer to pull his plough and taught the natives how to till soil. He brought back to life a cow which had been stolen from him, killed and dismembered, but at his call it reassembled itself and returned to give him milk for the rest of its life.}
					state
				)
			)
			(15
				(localproc_0
					{HARTLAND POINT\nThe original name of this place was the Headland of Hercules, from a legend that Hercules did battle there with British giants. Another legend says that St. Nectan, a Welsh hermit, had his head cut off by robbers, but he carried his head to his well and dropped it in. Foxgloves grew wherever his blood fell.}
					state
				)
			)
			(16
				(localproc_0
					{EXETER\nJust outside this city is a well and a chapel dedicated to St. Sidwell. Sidwell was a girl who had inherited some land that her stepmother wanted. The stepmother hired two men to kill the girl as she prayed in a field. They cut off her head with scythes. The spring gushes forth from the place where her head fell.}
					state
				)
			)
			(17
				(localproc_0
					{TOTNES\nLong ago a Trojan warrior named Brutus arrived and named this place Totnes. The story goes that he said: 'Here I am and here I rest, and this town shall be called Totnes.' He subdued two giants, Gog and Magog, and made them stand guard at his palace. Brutus is considered the legendary founder of London.}
					state
				)
			)
		)
	)
)

