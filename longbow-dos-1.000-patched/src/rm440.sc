;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use StdRoom)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	[local0 5] = [1440 0 1 2 0]
	[local5 5] = [1440 2 1 2 0]
	[local10 6] = [1440 4 1 2 1 0]
	[local16 4] = [1440 8 1 0]
	[local20 6] = [1440 12 1 2 1 0]
	[local26 4] = [1440 15 1 0]
	[local30 8] = [1440 38 2 1 2 1 2 0]
	[local38 9] = [1440 44 1 2 1 2 1 1 0]
	[local47 8] = [1440 50 1 2 1 2 1 0]
	[local55 5] = [1440 55 1 1 0]
)

(instance rm440 of StdRoom
	(properties
		picture 440
		style 100
		east 260
		south 260
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(= script arrived)
		(arrived client: self)
		(= temp1 0)
		(switch gDisguiseNum
			(0 ; outlaw
				(= temp0 67)
			)
			(1 ; beggar
				(= temp0 69)
			)
			(2 ; jewler (no rouge)
				(= temp0 74)
			)
			(3 ; jewler (rouge)
				(= temp0 74)
			)
			(4 ; yeoman
				(= temp0 68)
			)
			(5 ; abbey monk
				(= temp0 50)
				(= temp1 51)
			)
			(6 ; fens monk
				(= temp0 48)
				(= temp1 49)
			)
		)
		(NormalEgo 0 temp0 temp1)
		(if (not temp1)
			(gEgo setCycle: Walk)
		)
		(gEgo actions: noBig setStep: 2 1)
		(super init: 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 102 189 0 189 0 0 319 0 319 108 295 103 277 102 269 107 272 115 253 114 243 119 258 125 258 128 231 131 218 126 212 128 195 122 173 129 181 138 204 145 184 157 172 152 143 167 134 165 117 177 91 185
					yourself:
				)
		)
		(if (or (== gPrevRoomNum 450) (== gPrevRoomNum 460))
			(gEgo posn: 175 121 setMotion: MoveTo 218 138 arrived)
		else
			(gEgo
				setScript: changeMusic
				posn: 325 164
				setMotion: MoveTo 309 160 arrived
			)
		)
		(gSFX number: 905 loop: -1 play:)
		(facade init:)
		(fDoor init: approachVerbs: 3) ; Do
		(entrance init:)
		(maryTop init:)
		(maryB init:)
		(privies init:)
		(build init:)
		(maze init:)
		(trees init:)
		(town init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 ((User alterEgo:) edgeHit:))
				(self setScript: walkOut)
			)
		)
	)

	(method (dispose)
		(gSFX stop:)
		(super dispose: &rest)
		(gEgo script: 0)
	)
)

(instance arrived of Script
	(properties
		state 0
	)

	(method (cue)
		(if (or (!= gPrevRoomNum 460) (!= gDisguiseNum 6) state) ; fens monk
			(HandsOn)
			(if (== gDay 10)
				(gTheIconBar disable: 5)
				(= gDeathNum 14)
				(gCurRoom south: 170 east: 170)
			)
			(self dispose:)
		else
			(Say 1440 7 self) ; "It may not have been a useful visit, but it was certainly a satisfying one."
			(= state 1)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					setMotion:
						MoveTo
						(+ (gEgo x:) 18)
						(+ (gEgo y:) 16)
						self
				)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance monkLeaves of Script
	(properties)

	(method (doit)
		(if (& (gEgo onControl: 1) $0002)
			(self dispose:)
			(changeMusic next: 0)
			(gCurRoom setScript: monkAtDoor)
		)
	)
)

(instance monkAtDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 94)
				(SetScore 10)
				(gEgo setMotion: MoveTo 190 129 self)
				(doorMonk init: setCycle: Walk setMotion: MoveTo 183 126 self)
			)
			(2
				(Converse @local0 10 999 self) ; "Good day, Brother. Remember to bar the door once you're inside."
			)
			(3
				(doorMonk setMotion: MoveTo 325 164)
				(gEgo setMotion: MoveTo 175 121 self)
			)
			(4
				(gCurRoom newRoom: 450)
			)
		)
	)
)

(instance doKnock of Script
	(properties
		register 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 183 126 self)
			)
			(1
				(knockSound play: self)
			)
			(2
				(gEgo setMotion: MoveTo 190 129 self)
			)
			(3
				(Face gEgo fDoor)
				(= seconds 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance atDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: doKnock self)
				(if (or (== register 8) (== register 2))
					(++ state)
				)
			)
			(1
				(doorMonk init: setCycle: Walk setMotion: MoveTo 183 126 self)
			)
			(2
				(switch register
					(0
						(Converse @local20 10 999 self) ; "Good day, merchant. Have you business here?"
					)
					(1
						(Converse @local5 999 10 self) ; "'ave ye charity for a poor, old beggar? A dry crust of bread? A bowl of soup?"
						(doorMonk setMotion: MoveTo 175 121)
						(+= state 2)
					)
					(2
						(Say 1440 58 self) ; "The cold-hearted Monk refuses to open the door to me again."
						(+= state 3)
					)
					(3
						(Converse @local0 10 999 self) ; "Good day, Brother. Remember to bar the door once you're inside."
					)
					(4
						(Converse @local10 10 999 self) ; "Have you business here, Brother?"
					)
					(5
						(Converse @local16 10 0 self) ; "What? You again? You've displeased the Abbot enough. Be on your way."
						(doorMonk setMotion: MoveTo 175 121)
						(+= state 2)
					)
					(6
						(Converse @local26 10 0 self) ; "Back again? The Abbot has nothing further to say to you and is much too busy to see you again. Good day."
						(doorMonk setMotion: MoveTo 175 121)
						(+= state 2)
					)
					(7
						(Converse @local38 10 999 self) ; "Oh, it's you again. Wait on. Your beard's changed colour!"
						(doorMonk setMotion: MoveTo 175 121)
						(+= state 2)
					)
					(8
						(Converse @local30 999 10 self) ; "Go away, Yeoman."
						(+= state 3)
					)
				)
			)
			(3
				(doorMonk setMotion: MoveTo 175 121)
				(gEgo
					moveSpeed: (doorMonk moveSpeed:)
					cycleSpeed: (doorMonk moveSpeed:)
					setMotion: MoveTo 175 121 self
				)
			)
			(4
				(gCurRoom
					newRoom:
						(if
							(or
								(== gDisguiseNum 2) ; jewler (no rouge)
								(== gDisguiseNum 3) ; jewler (rouge)
								(== gDisguiseNum 6) ; fens monk
							)
							460
						else
							450
						)
				)
			)
			(5
				(doorMonk setMotion: MoveTo 175 121 self)
			)
			(6
				(HandsOn)
				(if (and (!= register 8) (!= register 2))
					(doorMonk dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance noAnswer of TScript
	(properties)

	(method (init param1 param2 param3 param4)
		(= start 0)
		(super init: param1 param2 param3)
		(= start param4)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: doKnock self)
			)
			(1
				(if (<= (++ register) start)
					(-- state)
				)
				(Say 1440 (- register 1) self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getTheo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: doKnock self)
			)
			(1
				(doorMonk init: setCycle: Walk setMotion: MoveTo 183 126 self)
			)
			(2
				(Converse @local47 10 999 self) ; "State your business."
			)
			(3
				(doorMonk setMotion: MoveTo 175 121 self)
			)
			(4
				(doorMonk script: self)
				(client script: 0)
				(= client doorMonk)
				(HandsOn)
				(= seconds 15)
			)
			(5
				(HandsOff)
				(gEgo setMotion: 0)
				(doorMonk setMotion: PolyPath (gEgo x:) (gEgo y:))
				(= ticks (- (* (gEgo distanceTo: doorMonk) 4) 60))
				(if (> ticks 200)
					(= ticks 200)
				)
			)
			(6
				(doorMonk setMotion: 0)
				(Converse @local55 10 0 self) ; "Aye? So you're the man claiming to be one of us!"
			)
			(7
				(= gDeathNum 13)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance doorMonk of Actor
	(properties
		x 176
		y 123
		yStep 1
		view 50
		signal 24576
		illegalBits 0
		xStep 2
	)
)

(instance facade of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(gCurRoom setScript: series 0 1440 17 19)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance fDoor of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 4
		approachX 191
		approachY 128
		lookStr 20 ; "The Abbot has installed most impressive and heavy doors to the entrance of the Abbey."
	)

	(method (doVerb theVerb invItem)
		(if (!= theVerb 3) ; Do
			(super doVerb: theVerb invItem)
		else
			(switch gDisguiseNum
				(0 ; outlaw
					(monkAtDoor state: 3 client: gCurRoom)
					(gCurRoom script: monkAtDoor)
					(gEgo setMotion: MoveTo 175 121 monkAtDoor)
				)
				(1 ; beggar
					(gCurRoom
						setScript: atDoor 0 (if (atDoor register:) 2 else 1)
					)
				)
				(4 ; yeoman
					(cond
						((== gDay 8)
							(if (not (IsFlag 89))
								(SetFlag 89)
								(gCurRoom setScript: noAnswer 0 9 9)
							)
						)
						((IsFlag 90)
							(gCurRoom setScript: noAnswer 0 43 43)
						)
						(1
							(SetFlag 90)
							(gCurRoom setScript: atDoor 0 8)
						)
					)
				)
				(5 ; abbey monk
					(cond
						((== gDay 8)
							(gCurRoom setScript: noAnswer 0 10 11)
						)
						((== (doorMonk script:) getTheo)
							(Say 1440 57 1) ; "The door is bolted from the inside."
						)
						(
							(not
								(or
									(== gDay 5)
									(and (== gDay 6) (not (IsFlag 25)))
								)
							)
							(gCurRoom setScript: getTheo)
						)
						((IsFlag 94)
							(monkAtDoor state: 3 client: gCurRoom)
							(gCurRoom script: monkAtDoor)
							(gEgo setMotion: MoveTo 175 121 monkAtDoor)
						)
						(1
							(monkLeaves dispose:)
							(changeMusic next: 0)
							(gCurRoom setScript: monkAtDoor)
						)
					)
				)
				(6 ; fens monk
					(if (IsFlag 93)
						(gCurRoom setScript: atDoor 0 5)
					else
						(SetFlag 93)
						(gCurRoom setScript: atDoor 0 4)
					)
				)
				(else
					(cond
						(
							(or
								(and (IsFlag 91) (== gDisguiseNum 3)) ; jewler (rouge)
								(and (IsFlag 92) (== gDisguiseNum 2)) ; jewler (no rouge)
							)
							(if (== gDisguiseNum 3) ; jewler (rouge)
								(SetFlag 92)
								(ClearFlag 91)
							else
								(SetFlag 91)
								(ClearFlag 92)
							)
							(gCurRoom setScript: atDoor 0 7)
						)
						((or (IsFlag 91) (IsFlag 92))
							(gCurRoom setScript: atDoor 0 6)
						)
						(1
							(if (== gDisguiseNum 3) ; jewler (rouge)
								(SetFlag 92)
							else
								(SetFlag 91)
							)
							(gCurRoom setScript: atDoor 0 0)
						)
					)
				)
			)
		)
	)
)

(instance entrance of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 8
		lookStr 21 ; "The Abbot has installed a large stained glass roundele and many carved scenes from the life of St. Mary."
	)
)

(instance maryTop of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 32
		lookStr 22 ; "The Blessed Virgin looks down from on high."
	)
)

(instance maryB of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 64
		lookStr 23 ; "It's a statue of St. Mary holding the infant Jesus."
	)
)

(instance privies of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 128
		lookStr 24 ; "The scent of the pines cannot mask the malodorous vapors of the privies. As the saying goes, 'Even the Abbot must lift his robes and squat like a peasant.'"
	)
)

(instance build of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 256
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(gCurRoom setScript: series 0 1440 26 27)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance maze of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 512
		lookStr 29 ; "I can barely glimpse a stone wall running along the back of the Abbey grounds."
	)
)

(instance trees of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 1024
		lookStr 31 ; "If I guess rightly, these thick pines are meant to keep out the unwelcome visitors and to hide from casual view the unfinished condition of the rest of the Abbey."
	)
)

(instance town of Feature
	(properties
		x 125
		y 110
		sightAngle 45
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(gCurRoom setScript: series 0 1440 32 33)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance series of Script
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(HandsOff)
		(= start param4)
		(super init: param1 param2 param3)
		(= start param5)
	)

	(method (changeState newState)
		(if (<= (= state newState) start)
			(Say register state self)
		else
			(HandsOn)
			(self dispose:)
		)
	)

	(method (cue param1)
		(if (not param1)
			(= start state)
		)
		(super cue:)
	)
)

(instance noBig of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(cond
				((and (== theVerb 4) (== invItem 8)) ; Inventory, rouge
					(if (== gDisguiseNum 2) ; jewler (no rouge)
						(= gDisguiseNum 3) ; jewler (rouge)
						(Say 1804 22) ; "There, a bit of rouge rubbed into my beard and onto my eyebrows will complete my disguise."
					else
						(gDoVerbCode doit: theVerb invItem)
					)
					1
				)
				((and (== theVerb 4) (== invItem 1)) ; Inventory, horn
					(Say 1005 3 1) ; "I dare not wind my horn here."
					1
				)
			)
		)
	)
)

(instance changeMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== gDisguiseNum 5) ; abbey monk
						(or
							(== gDay 5)
							(and (== gDay 6) (not (IsFlag 25)))
						)
						(not (IsFlag 94))
					)
					(self setScript: monkLeaves)
					(= next monkLeaves)
				)
				(gRgnMusic number: 461 loop: 1 play: self)
			)
			(1
				(= ticks 60)
			)
			(2
				(gRgnMusic number: 455 loop: -1 play:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance knockSound of Sound
	(properties
		flags 1
		number 933
	)
)

