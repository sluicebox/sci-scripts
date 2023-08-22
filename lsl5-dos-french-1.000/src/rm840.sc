;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm840 0
)

(local
	haveSeenBothThings
)

(instance rm840 of LLRoom
	(properties
		picture 840
		east 820
		west 850
	)

	(method (init)
		(LoadMany rsVIEW 840 841 842)
		(LoadMany rsSOUND 841 843 800 801 802)
		(LoadMany rsSCRIPT 969)
		(HandsOn)
		(gEgo init: normalize: (if (IsFlag 27) 842 else 570))
		(if (IsFlag 27)
			(gEgo actions: ActionsKRAP)
		)
		(switch gPrevRoomNum
			(east
				(lobbyDoor setPri: 12)
				(gEgo
					posn: 268 152
					setHeading: 270
					edgeHit: EDGE_NONE
					observeControl: 2 4
				)
				(Points 1 150)
			)
			(west
				(gEgo posn: 35 155 setHeading: 90 edgeHit: EDGE_NONE)
			)
			(else
				(HandsOn)
				(gEgo posn: 160 160 edgeHit: EDGE_NONE)
			)
		)
		(super init:)
		(johnDoor init: approachVerbs: 3 4) ; Do, Inventory
		(copier init: approachVerbs: 3 4 2 stopUpd:) ; Do, Inventory, Look
		(opener init: approachVerbs: 3 stopUpd:) ; Do
		(table init:)
		(sofa init:)
		(chair init:)
		(lobbyDoor init: approachVerbs: 3 4 caller: rm840) ; Do, Inventory
		(telephone init: approachVerbs: 2 3) ; Look, Do
		(computer init: approachVerbs: 2 3) ; Look, Do
		(stuff init:)
		(lamp1 init:)
		(lamp2 init:)
		(lamp3 init:)
		(lamp4 init:)
		(desk init: approachVerbs: 3 2 4) ; Do, Look, Inventory
		(plant init: approachVerbs: 3 4) ; Do, Inventory
		(myWindow init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 142 268 146 267 139 255 122 235 122 226 113 92 113 79 113 96 119 96 133 70 139 49 149 33 147 0 139
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 155 33 155 18 187 316 187 316 180 282 156 319 156 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 101 116 220 116 225 127 108 127
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 71 142 148 129 176 134 176 141 124 154 147 164 147 173 84 184 74 165
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 148 155 160 149 175 149 208 149 218 151 239 158 237 165 228 170 161 168 148 161
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 211 141 245 135 262 144 268 155 238 155 218 148
					yourself:
				)
		)
		(if (== gPrevRoomNum east)
			(TPrint 840 0) ; "Whew! You made it!"
		)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 1) ; "John Krapper's Office is beautifully decorated in the latest high-tech look. Numerous halogen narrow-beam spotlights bathe the otherwise dark room with small brilliantly-white pools of light."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(lobbyDoor ignoreActors:)
		(lobbyDoor caller: 0)
	)

	(method (dispose)
		(LoadMany 0 969)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(ActionsKRAP dispose:)
		(super dispose:)
	)
)

(instance desk of Feature
	(properties
		x 150
		y 115
		nsTop 90
		nsLeft 113
		nsBottom 126
		nsRight 214
		description {the desk}
		sightAngle 40
		approachX 150
		approachY 112
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((not (IsFlag 24))
						(TPrint 840 2) ; "John Krapper's granite and stainless steel desk is spotless. It holds only a computer and a telephone..."
						(if (not (gEgo has: 8)) ; Boarding_Pass
							(TPrint 840 3) ; "...and an imitation gold-plated needle-sharp letter opener."
						else
							(TPrint 840 4) ; "...and a locked file drawer."
						)
					)
					((not (IsFlag 25))
						(SetFlag 25)
						(gEgo setScript: lookDeskScript)
					)
					((not (gEgo has: 10)) ; Some_Change
						(gEgo get: 10) ; Some_Change
						(gEgo setScript: lookPapersScript)
					)
					(else
						(gEgo setScript: sLookDesk2ndTime)
					)
				)
			)
			(3 ; Do
				(cond
					((and (not (gEgo has: 8)) (not (IsFlag 24))) ; Boarding_Pass
						(Points 4 149)
						(TPrint 840 5) ; "Never knowing when you might get some mail, you decide to take Krapper's letter opener from his desk."
						(opener hide:)
						(gEgo get: 8) ; Boarding_Pass
					)
					((not (IsFlag 24))
						(TPrint 840 6) ; "Trying the drawers of Krapper's desk, you find them securely locked."
					)
					((not (IsFlag 25))
						(SetFlag 25)
						(gEgo setScript: openDeskScript)
					)
					((not (gEgo has: 10)) ; Some_Change
						(gEgo get: 10) ; Some_Change
						(gEgo setScript: getPapersScript)
					)
					(else
						(gEgo setScript: sOpenDesk2ndTime)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(8 ; Boarding_Pass
						(if (IsFlag 24)
							(TPrint 840 7) ; "You carefully return the letter opener to the exact same location on Krapper's desk and make sure the drawer is securely locked. He'll never even know you touched it."
							(gEgo put: 8) ; Boarding_Pass
							(opener show: stopUpd:)
							(ClearFlag 24)
						else
							(SetFlag 24)
							(gEgo setScript: pickLockScript)
						)
					)
					(9 ; AeroDork_s_In-Flight_Magazine
						(if (IsFlag 24)
							(ClearFlag 24)
							(gEgo setScript: lockDeskScript)
						else
							(SetFlag 24)
							(gEgo setScript: unlockDeskScript)
						)
					)
					(10 ; Some_Change
						(if (IsFlag 24)
							(gEgo put: 10) ; Some_Change
							(gEgo setScript: putPapersScript)
						else
							(TPrint 840 8) ; "You would return the folder to the drawer, but the desk is locked."
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

(instance plant of Feature
	(properties
		x 248
		y 81
		nsTop 40
		nsLeft 208
		nsBottom 122
		nsRight 290
		description {the potted plant}
		sightAngle 40
		approachX 231
		approachY 120
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((gEgo has: 9) ; AeroDork_s_In-Flight_Magazine
						(TPrint 840 9) ; "Hmm. This tree could use a good watering."
					)
					((IsFlag 23)
						(TPrint 840 10) ; "Look! There's a key almost hidden in the plant's humus."
					)
					(else
						(TPrint 840 11) ; "You see a glint of metal coming from the humus in the pot at the base of the tree."
						(SetFlag 23)
					)
				)
			)
			(3 ; Do
				(if (not (gEgo has: 9)) ; AeroDork_s_In-Flight_Magazine
					(if (IsFlag 23)
						(gEgo setScript: getKeyScript)
					else
						(gEgo setScript: sPawThruPlant)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(4 ; Inventory
				(if (== invItem 9) ; AeroDork_s_In-Flight_Magazine
					(gEgo put: 9) ; AeroDork_s_In-Flight_Magazine
					(gEgo setScript: replaceKeyScript)
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

(instance copier of Prop
	(properties
		x 58
		y 138
		z 20
		description {the copier}
		approachX 69
		approachY 140
		view 840
		loop 3
		priority 10
		signal 16
		cycleSpeed 18
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 12) ; "It's a genuine ZeroZ 9000, the latest in personal copiers."
			)
			(3 ; Do
				(if (gEgo has: 11) ; DayTrotter
					(TPrint 840 13) ; "The copier is now broken! You should know; you broke it!"
				else
					(TPrint 840 14) ; "To use the `Zeroz 9000,' simply insert the pages you wish to copy."
				)
			)
			(2 ; Look
				(if (gEgo has: 11) ; DayTrotter
					(TPrint 840 15) ; "It WAS a genuine ZeroZ 9000; now it's a piece of trash!"
				else
					(TPrint 840 12) ; "It's a genuine ZeroZ 9000, the latest in personal copiers."
				)
			)
			(4 ; Inventory
				(switch invItem
					(10 ; Some_Change
						(if (gEgo has: 11) ; DayTrotter
							(TPrint 840 16) ; "The copier is now broken! You should know; you broke it!"
						else
							(gEgo setScript: runCopierScript)
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

(instance paper of Prop
	(properties
		x 58
		y 112
		description {the copier}
		approachX 68
		approachY 138
		view 840
		loop 5
		priority 10
		signal 16
		cycleSpeed 12
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 17) ; "It's a genuine ZeroZ 9000, the latest in personalcopiers."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance johnDoor of Door
	(properties
		x 11
		y 153
		description {the bathroom door}
		approachX 44
		approachY 152
		view 840
		loop 1
		signal 16384
		entranceTo 850
		moveToY 141
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 18) ; "A sign on the door says "Krapper's Crapper." A smaller sign below it says "John's John"."
			)
			(3 ; Do
				(cond
					((gEgo has: 10) ; Some_Change
						(TPrint 840 19) ; "Mr. Krapper will surely miss his file folder, Patti! You'd better return it."
					)
					((gEgo has: 9) ; AeroDork_s_In-Flight_Magazine
						(TPrint 840 20) ; "Mr. Krapper will surely miss his desk key, Patti! You'd better return it."
					)
					((gEgo has: 8) ; Boarding_Pass
						(TPrint 840 21) ; "Mr. Krapper will surely miss his letter opener, Patti! You'd better return it."
					)
					(else
						(gEgo ignoreControl: 4)
						(self setPri: 15)
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (close)
		(gEgo observeControl: 4 2)
		(super close:)
	)
)

(instance lobbyDoor of Door
	(properties
		x 302
		y 153
		description {the lobby door}
		approachX 269
		approachY 159
		view 840
		loop 2
		signal 16384
		entranceTo 820
		moveToX 280
		moveToY 150
		enterType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 22) ; "This is the door through which you entered. If you walked out it, you would return to the lobby."
			)
			(3 ; Do
				(gEgo setScript: peekScript)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (close)
		(self setPri: -1)
		(super close:)
	)
)

(instance table of Feature
	(properties
		x 192
		y 157
		nsTop 149
		nsLeft 152
		nsBottom 165
		nsRight 232
		description {the table}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 23) ; "Krapper has a beautiful glass coffee table."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 237
		y 139
		nsTop 120
		nsLeft 222
		nsBottom 152
		nsRight 256
		description {the chair}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 24) ; "This is the kind of furniture you would buy if you ever settled down."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sofa of Feature
	(properties
		x 112
		y 153
		nsTop 126
		nsLeft 83
		nsBottom 178
		nsRight 141
		description {the sofa}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 25) ; "What an unusual sofa! You so love modern furniture."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance telephone of Feature
	(properties
		x 194
		y 116
		z 20
		nsTop 96
		nsLeft 187
		nsBottom 106
		nsRight 202
		description {the telephone}
		sightAngle 40
		approachX 200
		approachY 112
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 26) ; "John Krapper's telephone has very few buttons. He must be REALLY important!"
			)
			(3 ; Do
				(TPrint 840 27) ; "You'd better not use this telephone, Patti. You might get caught by the switchboard operator."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance computer of Feature
	(properties
		x 137
		y 116
		z 20
		nsTop 88
		nsLeft 127
		nsBottom 105
		nsRight 148
		description {the desk computer}
		sightAngle 40
		approachX 140
		approachY 112
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 28) ; "Look at the dust on that keyboard! He must never use his computer!"
			)
			(3 ; Do
				(TPrint 840 29) ; "You briefly consider booting up John Krapper's computer in an attempt to contact Inspector Desmond, but realize there's no way his computer would be connected to FBI-Net!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance myWindow of Feature
	(properties
		x 161
		y 73
		nsTop 39
		nsLeft 66
		nsBottom 107
		nsRight 256
		description {the window}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 30) ; "Krapper's office has a giant window looking out over beautiful downtown Philadelphia."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stuff of Feature
	(properties
		x 53
		y 72
		nsTop 43
		nsLeft 33
		nsBottom 102
		nsRight 73
		description {the shelves}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 31) ; "Krapper's bookcase is filled with items, all of them useless to your mission."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lamp1 of Feature
	(properties
		x 59
		y 23
		nsTop 17
		nsLeft 53
		nsBottom 29
		nsRight 65
		description {the lamp}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 32) ; "The small halogen spotlights cast a pure white light."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lamp2 of Feature
	(properties
		x 99
		y 6
		nsLeft 93
		nsBottom 13
		nsRight 106
		description {the lamp}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 32) ; "The small halogen spotlights cast a pure white light."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lamp3 of Feature
	(properties
		x 163
		y 22
		nsTop 18
		nsLeft 158
		nsBottom 26
		nsRight 169
		description {the lamp}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 32) ; "The small halogen spotlights cast a pure white light."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lamp4 of Feature
	(properties
		x 260
		y 24
		nsTop 20
		nsLeft 253
		nsBottom 29
		nsRight 267
		description {the lamp}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 32) ; "The small halogen spotlights cast a pure white light."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance opener of View
	(properties
		x 155
		y 105
		description {the letter opener}
		approachX 187
		approachY 118
		view 840
		priority 9
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 840 33) ; "There's a needle-sharp letter opener lying on Krapper's desk."
			)
			(3 ; Do
				(TPrint 840 34) ; "Never knowing when you might get some mail, you decide to take Krapper's letter opener from his desk."
				(opener hide:)
				(gEgo get: 8) ; Boarding_Pass
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance copyMachineSound of Sound
	(properties
		flags 1
		number 841
		priority 11
	)
)

(instance copyExplodesSound of Sound
	(properties
		flags 1
		number 842
		priority 11
	)
)

(instance pickLockSound of Sound
	(properties
		flags 1
		number 843
		priority 11
	)
)

(instance peekScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(lobbyDoor setCel: 1)
				(gEgo setMotion: MoveTo 272 150 self)
			)
			(1
				(gEgo setLoop: 8 setCel: 0)
				(= seconds 3)
			)
			(2
				(TPrint 840 35) ; "Opening the doorway to carefully peek outside, you notice the receptionist has returned. You decide you cannot exit the room that way!"
				(= seconds 3)
			)
			(3
				(lobbyDoor setCel: 0)
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance getKeyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 7 else 2)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					get: 9 ; AeroDork_s_In-Flight_Magazine
					loop: 0
				)
				(= ticks 30)
			)
			(2
				(Points 10 148)
				(TPrint 840 36 67 -1 28) ; "Bending over at the base of the tree, you dig into the humus and find the metallic object that you saw earlier. It looks like a desk key."
				(HandsOn)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance sPawThruPlant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 7 else 2)
					setCel: 0
					cycleSpeed: 18
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo setCycle: CT 0 -1 self)
			)
			(2
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 0
				)
				(= ticks 30)
			)
			(3
				(TPrint 840 37) ; "Pawing through the humus in the tree's pot, you see a glint of metal."
				(SetFlag 23)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance replaceKeyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 7 else 2)
					setCel: 255
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(1
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 0
				)
				(= ticks 30)
			)
			(2
				(TPrint 840 38 67 -1 28) ; "You carefully return the key to its hiding place in the humus."
				(HandsOn)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance openDeskScript of Script
	(properties)

	(method (changeState newState &tmp [str 250])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(= ticks 123)
			)
			(2
				(gEgo setCel: 255 setCycle: Beg self)
			)
			(3
				(= ticks 123)
			)
			(4
				(Format ; "Peering through John Krapper's personal (formerly-locked) file drawer, you notice a number written on a small blue stickum! Why in the world would he want to remember %u?"
					@str
					840
					39
					(= gRoomBNumber (Random 10000 -536))
					gRoomBNumber
				)
				(Points 4 144)
				(TPrint @str)
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance sOpenDesk2ndTime of Script
	(properties)

	(method (changeState newState &tmp [str 80])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(= ticks 123)
			)
			(2
				(gEgo setCel: 255 setCycle: Beg self)
			)
			(3
				(= ticks 123)
			)
			(4
				(Format @str 840 40 gRoomBNumber gRoomBNumber) ; "Where's that little blue stickum? Oh, here it is! %u"
				(TPrint @str)
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance lookDeskScript of Script
	(properties)

	(method (changeState newState &tmp [str 250])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					cycleSpeed: 18
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 123)
			)
			(2
				(gEgo setCel: 255 setCycle: Beg self)
			)
			(3
				(= ticks 123)
			)
			(4
				(Format ; "Peering through John Krapper's personal (formerly-locked) file drawer, you notice a number written on a small blue stickum! Why in the world would he want to remember %u?"
					@str
					840
					39
					(= gRoomBNumber (Random 10000 -536))
					gRoomBNumber
				)
				(Points 5 144)
				(TPrint @str)
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance sLookDesk2ndTime of Script
	(properties)

	(method (changeState newState &tmp [str 80])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(= ticks 123)
			)
			(2
				(gEgo setCel: 255 setCycle: Beg self)
			)
			(3
				(= ticks 123)
			)
			(4
				(Format @str 840 40 gRoomBNumber gRoomBNumber) ; "Where's that little blue stickum? Oh, here it is! %u"
				(TPrint @str)
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance pickLockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(pickLockSound play:)
				(gEgo setCel: 255 setCycle: Beg self)
			)
			(2
				(Points 5 147)
				(TPrint 840 41) ; "Prying away at the desk's inefficient lock with Krapper's letter opener, you find a weak spot and carefully pry the drawer open."
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance unlockDeskScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(pickLockSound play:)
				(gEgo setCel: 255 setCycle: Beg self)
			)
			(2
				(Points 13 147)
				(TPrint 840 42) ; "Trying the key you found buried in the tree's pot, you insert into the desk and turn it carefully. It opens."
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance lockDeskScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(pickLockSound play:)
				(gEgo setCel: 255 setCycle: Beg self)
			)
			(2
				(TPrint 840 43) ; "You lock the desk."
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance getPapersScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 8 else 1)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(2
				(= ticks 123)
			)
			(3
				(Points 5 145)
				(TPrint 840 44) ; "Searching the desk drawer, you find the folders marked "Personal.""
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance lookPapersScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(TPrint 840 45) ; "Carefully searching through the many drawers of Krapper's desk, you find a folder marked "Personal.""
				(= ticks 60)
			)
			(2
				(TPrint 840 46) ; "For a moment, you wonder if you should take it."
				(= ticks 60)
			)
			(3
				(gEgo
					view: 841
					loop: (if (IsFlag 27) 8 else 1)
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(4
				(Points 5 145)
				(TPrint 840 47) ; "But of course you do!"
				(= ticks 123)
			)
			(5
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance putPapersScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					setLoop: (if (IsFlag 27) 8 else 1)
					setCel: 255
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(gEgo
					loop: (if (IsFlag 27) 6 else 0)
					setCel: 255
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(3
				(= ticks 60)
			)
			(4
				(TPrint 840 48) ; "You return the folder of evidence to Krapper's desk, and close his desk drawer, being careful to leave everything exactly as you found it."
				(gEgo
					normalize: (if (IsFlag 27) 842 else 570)
					observeControl: 2 4
					loop: 2
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance runCopierScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 841
					loop: 3
					cycleSpeed: 18
					x: 69
					y: 140
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 4 setCel: 255 setCycle: Beg self)
			)
			(2
				(Points 12 151)
				(TPrint 840 49) ; "You place John Krapper's personal papers in his copier, and press the "Start" button."
				(= ticks 123)
			)
			(3
				(gEgo loop: 4 setCycle: End self)
			)
			(4
				(copyMachineSound play: setLoop: -1)
				(copier setCel: 0 setCycle: End self setPri: 9)
			)
			(5
				(copier stopUpd:)
				(= cycles 1)
			)
			(6
				(paper
					init:
					setCel: 0
					setPri: 9
					setCycle: ForwardCounter 5 self
				)
			)
			(7
				(copyMachineSound stop:)
				(= ticks 200)
			)
			(8
				(Say gEgo 840 50) ; "Hey, what's the matter with this thing?" you think. "Why did it stop working? What did I do, jam it?"
				(= seconds 3)
			)
			(9
				(gEgo loop: 3 setCel: 255 setCycle: Beg self)
			)
			(10
				(paper dispose:)
				(copier setCel: 0)
				(Say gEgo 840 51) ; ""Oh well, at least I got the most important evidence copied before it jammed," you think, grabbing your copies from the machine."
				(= seconds 3)
			)
			(11
				(gEgo loop: 4 setCel: 0 setCycle: End self)
			)
			(12
				(Say gEgo 840 52) ; ""What does this switch here do?" you wonder, pulling on something that doesn't belong to you."
				(= ticks 123)
			)
			(13
				(TPrint 840 53 67 -1 185) ; "(An experience not wholly unfamiliar to you!)"
				(= ticks 60)
			)
			(14
				(gEgo loop: 4 setCel: 255 setCycle: Beg self)
			)
			(15
				(gEgo normalize: 570 loop: 1)
				(= ticks 60)
			)
			(16
				(copyExplodesSound play:)
				(copier
					view: 840
					startUpd:
					cycleSpeed: 12
					setCel: 0
					setLoop: 4
					setCycle: CT 1 1 self
				)
			)
			(17
				(gEgo normalize: 842 observeControl: 2 4 loop: 1)
				(copier view: 840 setPri: 11 setCel: 2 setCycle: CT 4 1 self)
			)
			(18
				(copier view: 840 setPri: 9 setCycle: End self)
			)
			(19
				(= seconds 3)
			)
			(20
				(Say gEgo 840 54) ; "GREAT!" you think. "Now just look at me! I'm covered with toner from head to toe!"
				(copier stopUpd:)
				(SetFlag 27)
				(gEgo get: 11 actions: ActionsKRAP setScript: 0) ; DayTrotter
				(HandsOn)
			)
		)
	)
)

(instance ActionsKRAP of Actions
	(properties)

	(method (doit)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 842)
					(TPrint 840 55) ; "Oh no," you think, "how am I ever going to get this stuff off?"
					(return 1)
				else
					(TPrint 840 56) ; "You look yourself over. You like what you see. "Although, I could stand to lose a few pounds," you think."
					(return 1)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

