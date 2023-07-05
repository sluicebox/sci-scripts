;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
(include sci.sh)
(use Main)
(use n013)
(use TheDungeon)
(use verseScript)
(use FootstepWalk)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm570 0
)

(local
	local0
	local1
	[local2 15]
	local17
	[local18 4] = [1570 0 1 0]
	[local22 5] = [1570 1 1 2 0]
	[local27 5] = [1570 3 2 1 0]
	[local32 5] = [1570 5 2 1 0]
	[local37 5] = [1570 7 1 2 0]
	[local42 4] = [1570 9 2 0]
	[local46 5] = [1570 10 2 1 0]
	[local51 5] = [1570 12 2 1 0]
	[local56 5] = [1570 14 1 1 0]
	[local61 4] = [1570 16 1 0]
	[local65 4] = [1570 17 1 0]
	[local69 4] = [1570 52 1 0]
	[local73 4] = [1410 0 1 0]
	[local77 4] = [1410 4 1 0]
	[local81 4] = [1410 6 1 0]
	[local85 4] = [1410 8 1 0]
	[local89 9] = [255 0 1 4 6 23 38 7 12]
	[local98 9] = [255 0 1 4 6 23 38 7 11]
	[local107 9] = [255 0 1 4 6 23 38 7 13]
)

(instance rm570 of Rm
	(properties
		picture 570
		east 561
	)

	(method (init)
		(HandsOn)
		(= local0 1)
		(Load rsSCRIPT 956)
		(super init:)
		(if (not (TheDungeon coinsDoneBeenTook:))
			(for
				((= local1 1))
				(and (<= local1 (TheDungeon numberCoins:)) (< local1 15))
				((++ local1))
				
				((= [local2 local1] (coins new:))
					setPri: 11
					init:
					posn: (Random 135 150) (Random 121 130)
				)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 229 0 229 154 207 132 200 133 188 130 174 129 84 129 77 130 71 133 57 137 47 153 6 148 5 152 45 157 32 187 242 187 231 158 231 0 319 0 318 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 181 137 180 146 160 155 94 155 97 137
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 154 165 159 180 101 180 108 165
					yourself:
				)
		)
		(theTorch setCycle: Fwd init:)
		(trapdoor init:)
		(AddToFeatures
			trapDoor
			table
			chair
			stool
			hiddenDoor
			doorway
			tunnel
			floor
			walls
		)
		(gRgnMusic number: 561 loop: -1 play:)
		(switch gPrevRoomNum
			(561 ; tunnel2
				(gAddToPics add: openDoor eachElementDo: #init doit:)
				(if (and (not (TheDungeon guardsGone:)) (!= gDay 10))
					(gEgo setScript: instantDeath1)
				else
					(gEgo setScript: enterRoom)
				)
			)
			(390
				(gAddToPics add: closedDoor eachElementDo: #init doit:)
				(gEgo posn: 22 151 init:)
				(HandsOff)
				(gEgo setScript: blessing)
			)
			(else
				(gEgo posn: 130 127 loop: 2 init:)
			)
		)
		(NormalEgo)
	)

	(method (doit)
		(cond
			((& (gEgo onControl: 1) $0004)
				(if local0
					(gEgo setCycle: FootstepWalk)
					(= local0 0)
				)
			)
			((and (not (gEgo script:)) (not local0))
				(NormalEgo)
				(= local0 1)
			)
		)
		(if
			(and
				(== global164 4)
				(== (TheDungeon trapDoorOpen:) 1)
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: trembling)
		)
		(cond
			((and (not (gEgo script:)) (< (gEgo x:) 27))
				(if (== gDay 10)
					(SetMessageColor 19)
					(Say 1570 18 80 {Giles} 67 21 165) ; "Roger! It's an outlaw!"
					(Say 1570 19 80 {Roger} 67 21 21) ; "Seize him! It's ROBIN HOOD!"
					(SetMessageColor 0)
					(= gDeathNum 31)
					(gCurRoom newRoom: 170) ; robinDeath
				else
					(gEgo setScript: comeBackHere)
				)
			)
			(
				(and
					(& (gEgo onControl: 1) $0002)
					(not (gEgo script:))
					(not local17)
				)
				(= local17 1)
				(gCurRoom newRoom: 561) ; tunnel2
			)
			(
				(and
					(TheDungeon timeToDie:)
					(!= (gEgo script:) instantDeath2)
					(!= (gEgo script:) instantDeath1)
					(not local17)
				)
				(= local17 1)
				(gEgo setScript: instantDeath2)
			)
			(
				(and
					(== (TheDungeon script:) (ScriptID 564 3)) ; warningTimer
					(TheDungeon neverBefore:)
				)
				(SetMessageColor 19)
				(Say 1570 20 80 {Giles} 67 21 165) ; "Hurry up, Roger."
				(Say 1570 21 80 {Roger} 67 21 21) ; "I'm coming. I'm coming."
				(SetMessageColor 0)
				(TheDungeon neverBefore: 0)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 956)
		(super dispose:)
	)
)

(instance hob of Actor
	(properties
		x 84
		y 185
		view 254
		loop 1
		signal 1
	)
)

(instance dicken of Actor
	(properties
		x 188
		y 180
		view 412
		loop 3
		signal 1
	)
)

(instance hal of Actor
	(properties
		x 126
		y 177
		view 411
		loop 4
		signal 1
	)
)

(instance roger of Actor
	(properties
		x 23
		y 153
		view 753
		signal 1
	)
)

(instance giles of Actor
	(properties
		x 13
		y 153
		view 753
		signal 1
	)
)

(instance jack of Actor
	(properties
		x 46
		y 154
		view 753
		signal 1
	)
)

(instance trapDoor of Feature
	(properties
		lookStr 41 ; "'Tis a trapdoor set in the wooden floor."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PBarredAccess
			init: 144 166 148 177 114 177 117 166
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(5 ; Talk
				(if (not (== gDay 10))
					(if (TheDungeon trapDoorOpen:)
						(Converse @local18 @local89 0) ; "Please help us!"
					else
						(Say 1570 23) ; "I dare not risk shouting through the wooden floor."
					)
				)
			)
			(4 ; Inventory
				(if (TheDungeon trapDoorOpen:)
					(switch invItem
						(13 ; robes
							(gEgo setScript: saveBoys)
						)
						(else
							(Say 1570 24) ; "The only thing they need now is a means of escape!"
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table of Feature
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(2 ; Look
				(Say 1570 25) ; "The guards have a simple table"
			)
			(3 ; Do
				(Say 1570 26) ; "I'm hardly going to take that with me."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(gEgo setScript: putCoins)
					)
					(else
						(if (== gDay 10)
							(SetMessageColor 19)
							(Say 1570 18 80 {Giles} 67 21 65) ; "Roger! It's an outlaw!"
							(Say 1570 19 80 {Roger} 67 21 21) ; "Seize him! It's ROBIN HOOD!"
							(SetMessageColor 0)
							(= gDeathNum 31)
							(gCurRoom newRoom: 170) ; robinDeath
						else
							(gEgo setScript: instantDeath2)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 154 119 154 132 153 156 148 149 145 135 115 135 115 145 106 154 102 132 110 119
			yourself:
		)
		(super init:)
	)
)

(instance chair of Feature
	(properties
		nsTop 115
		nsLeft 122
		nsBottom 144
		nsRight 139
		description {the chair}
		lookStr 27 ; "'Tis the guard's chair."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(3 ; Do
				(Say 1570 28) ; "This is no time to sit down."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(gEgo setScript: putCoins)
						(Say 1570 29) ; "I'll leave the money on the table to ensure they see it."
					)
					(else
						(gEgo setScript: instantDeath2)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stool of Feature
	(properties
		nsTop 132
		nsLeft 161
		nsBottom 144
		nsRight 171
		description {the stool}
		lookStr 30 ; "'Tis a small stool."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(3 ; Do
				(Say 1570 31) ; "I've no need for a stool."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(gEgo setScript: putCoins)
						(Say 1570 29) ; "I'll leave the money on the table to ensure they see it."
					)
					(else
						(gEgo setScript: instantDeath2)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hiddenDoor of Feature
	(properties
		nsTop 100
		nsLeft 230
		nsBottom 155
		nsRight 241
		description {the hidden door}
		lookStr 32 ; "That's the hidden door by which I entered."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(3 ; Do
				(Say 1570 33) ; "Better to leave it open for a quick retreat."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorway of Feature
	(properties
		nsTop 78
		nsLeft 28
		nsBottom 160
		nsRight 38
		description {the doorway}
		lookStr 34 ; "The open door will lead up into the main body of the castle."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(3 ; Do
				(Say 1570 35) ; "It has no door to close."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(2 ; Look
				(Say 1570 36) ; "A partial wooden floor has been set into the stone floor"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 190 130 214 183 47 183 76 132
			yourself:
		)
		(super init:)
	)
)

(instance walls of Feature
	(properties
		nsBottom 189
		nsRight 319
		description {the walls}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(2 ; Look
				(Say 1570 37) ; "They've lined the sandstone walls with more solid walls of stone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tunnel of Feature
	(properties
		nsTop 2
		nsLeft 284
		nsBottom 188
		nsRight 318
		description {the tunnel}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(2 ; Look
				(Say 1570 38) ; "There lies the tunnel up which I came."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dickenWithRope of Prop
	(properties
		x 171
		y 146
		view 412
		loop 4
	)
)

(instance rope of Prop
	(properties
		x 171
		y 7
		view 412
	)
)

(instance theTorch of Prop
	(properties
		x 133
		y 103
		description {the torch}
		lookStr 39 ; "'Tis a torch."
		view 570
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(3 ; Do
				(Say 1570 40) ; "Even these guards would notice a missing torch."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trapdoor of Prop
	(properties
		x 147
		y 177
		description {the trapdoor}
		lookStr 41 ; "'Tis a trapdoor set in the wooden floor."
		view 570
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(3 ; Do
				(cond
					((== gDay 10)
						(Say 1570 42) ; "I've seen enough of that evil pit."
					)
					((not ((ScriptID 564 2) seconds:)) ; longTimer
						(gEgo setScript: instantDeath3)
					)
					((not (IsFlag 188))
						(gEgo setScript: firstTimeOpen)
					)
					((not (TheDungeon doneTalking:))
						(gEgo setScript: backAgain)
					)
					((== (TheDungeon trapDoorOpen:) 0)
						(gEgo setScript: openIt)
					)
					(else
						(Say 1570 43) ; "The trap door is open."
					)
				)
			)
			(5 ; Talk
				(if (not (== gDay 10))
					(if (TheDungeon trapDoorOpen:)
						(Converse @local18 @local89 0 self) ; "Please help us!"
					else
						(Say 1570 23) ; "I dare not risk shouting through the wooden floor."
					)
				)
			)
			(4 ; Inventory
				(if (TheDungeon trapDoorOpen:)
					(switch invItem
						(13 ; robes
							(gEgo setScript: saveBoys)
						)
						(else
							(Say 1570 24) ; "The only thing they need now is a means of escape!"
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance robes of View
	(properties
		x 164
		y 177
		view 570
		loop 4
		cel 1
	)
)

(instance coins of View
	(properties
		x 143
		y 129
		description {the coins}
		lookStr 44 ; "That is the money I left."
		view 570
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1570 22) ; "My bow is always ready, but if I run into trouble here, I'll be vastly outnumbered."
			)
			(3 ; Do
				(gEgo setScript: getCoins)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closedDoor of PicView
	(properties
		x 240
		y 163
		description {the door}
		view 570
		loop 1
	)
)

(instance openDoor of PicView
	(properties
		x 239
		y 166
		description {the door}
		view 570
		loop 1
		cel 1
		priority 11
		signal 16384
	)
)

(instance instantDeath1 of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 564 1) seconds: 2000) ; shortTimer
				((ScriptID 564 2) seconds: 2000) ; longTimer
				((ScriptID 564 3) seconds: 2000) ; warningTimer
				(HandsOff)
				(giles posn: 155 140 setCycle: Walk init:)
				(roger posn: 211 179 setCycle: Walk init:)
				(gEgo posn: 240 155 init:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 225 (gEgo y:) self)
			)
			(2
				(SetMessageColor 19)
				(Say 1570 45 self 80 {Roger}) ; "You, Monk! Hold fast! Where'd that door come from?"
			)
			(3
				(SayModeless 1570 46 self 80 {Giles}) ; "Seize him!"
			)
			(4
				(roger setMotion: MoveTo 211 155)
				(giles setMotion: MoveTo 170 140 self)
			)
			(5
				(SetMessageColor 0)
				(= gDeathNum 32)
				(HandsOn)
				(gCurRoom newRoom: 170) ; robinDeath
				(self dispose:)
			)
		)
	)
)

(instance instantDeath2 of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 564 1) seconds: 2000) ; shortTimer
				((ScriptID 564 2) seconds: 2000) ; longTimer
				((ScriptID 564 3) seconds: 2000) ; warningTimer
				(HandsOff)
				(NormalEgo)
				(= local0 1)
				(gEgo setMotion: PolyPath 215 155)
				(giles setCycle: Walk init: setMotion: MoveTo 70 153 self)
			)
			(1
				(roger setCycle: Walk init: setMotion: MoveTo 40 153 self)
			)
			(2
				(SetMessageColor 19)
				(Say 1570 47 self 80 {Roger}) ; "Look! A Monk and a secret door!"
			)
			(3
				(SayModeless 1570 48 self 80 {Giles}) ; "Sound the alarm!"
			)
			(4
				(Say 1570 49 self 80 {Roger}) ; "After him!"
			)
			(5
				(= gDeathNum 32)
				(HandsOn)
				(gCurRoom newRoom: 170) ; robinDeath
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance instantDeath3 of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 564 1) seconds: 2000) ; shortTimer
				((ScriptID 564 2) seconds: 2000) ; longTimer
				((ScriptID 564 3) seconds: 2000) ; warningTimer
				(self setScript: openIt self)
			)
			(1
				(HandsOff)
				(giles setCycle: Walk init: setMotion: MoveTo 70 153 self)
			)
			(2
				(roger setCycle: Walk init: setMotion: MoveTo 40 153 self)
			)
			(3
				(SetMessageColor 19)
				(Say 1570 18 self 80 {Giles} 67 21 165) ; "Roger! It's an outlaw!"
			)
			(4
				(Say 1570 19 self 80 {Roger} 67 21 21) ; "Seize him! It's ROBIN HOOD!"
			)
			(5
				(HandsOn)
				(= gDeathNum 32)
				(gCurRoom newRoom: 170) ; robinDeath
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance blessing of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable:)
				(giles posn: 203 140 setCycle: Walk init:)
				(roger posn: 239 177 setCycle: Walk init:)
				(Face roger jack)
				(Face giles jack)
				(jack setCycle: Walk init: setMotion: MoveTo 65 138 self)
			)
			(1
				(Face jack giles)
				(gEgo setMotion: PolyPath 64 156 self)
			)
			(2
				(SetMessageColor 19)
				(Say 1570 50 self 80 {Jack}) ; "This monk is here to give the outlaws their final blessing."
			)
			(3
				(SayModeless 1570 51 self 80 {Giles}) ; "You'll have to do it through the trapdoor."
			)
			(4
				(SetMessageColor 0)
				(Converse @local69 999 0 self) ; "At least allow me to hear their sins alone. You can wait for me upstairs."
			)
			(5
				(SetMessageColor 19)
				(Say 1570 53 self 80 {Jack}) ; "Sorry, can't leave you alone in here. Get on with it."
			)
			(6
				(SetMessageColor 0)
				(gEgo setMotion: MoveTo 84 165 self)
			)
			(7
				(self setScript: blessBoys self)
			)
			(8
				(= cycles 1)
			)
			(9
				(= notKilled 1)
				(SetMessageColor 19)
				(Say 1570 54 self 80 {Jack}) ; "Come with me before the Sheriff comes along and has our hides for lettin' you in at all."
			)
			(10
				(gEgo
					view: 411
					loop: 0
					cel: 5
					cycleSpeed: 24
					setCycle: CT 2 -1 self
				)
				(trapdoor cycleSpeed: 24 setCycle: Beg self)
			)
			(11
				(trapDoorSound number: 563 play:)
				(gEgo cycleSpeed: 24 setCycle: Beg self)
			)
			(12
				(NormalEgo 2)
				(= local0 1)
				(TheDungeon trapDoorOpen: 0)
				(gGame setSpeed: global141)
				(= cycles 2)
			)
			(13
				(gEgo setMotion: MoveTo 75 160 self)
			)
			(14
				(gCurRoom newRoom: 390)
				(HandsOn)
				(gTheIconBar enable:)
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 230 158 init:)
				(= ticks 12)
			)
			(1
				(gEgo setMotion: MoveTo 205 158 self)
			)
			(2
				(NormalEgo)
				(= local0 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance firstTimeOpen of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: openIt self)
			)
			(1
				(HandsOff)
				(Converse @local22 9 @local107 self) ; "Hssst...lads! It's me, Robin!"
			)
			(2
				(Converse @local27 9 @local98 self) ; "Shhh! Not so loudly. Lower the ladder, Robin!"
			)
			(3
				(Converse @local32 9 @local89 self) ; "Then...we're still trapped in this pit?"
			)
			(4
				(NormalEgo 2)
				(= local0 1)
				(= global164 0)
				(TheDungeon doneTalking: 1)
				(HandsOn)
				(TheDungeon trapDoorOpen: 1)
				(SetFlag 188)
				(self dispose:)
			)
		)
	)
)

(instance backAgain of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: openIt self)
			)
			(1
				(HandsOff)
				(Converse @local37 9 @local98 self) ; "Hssst...lads, I'm back."
			)
			(2
				(Converse @local42 9 @local107 self) ; "And I almost cried out your name!"
			)
			(3
				(Converse @local46 9 @local98 self) ; "Lower the ladder!"
			)
			(4
				(Converse @local51 9 @local89 self) ; "Then we're still trapped in this pit?"
			)
			(5
				(NormalEgo)
				(= local0 1)
				(= global164 0)
				(TheDungeon doneTalking: 1)
				(HandsOn)
				(TheDungeon trapDoorOpen: 1)
				(SetFlag 188)
				(self dispose:)
			)
		)
	)
)

(instance putCoins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 139 156 self)
			)
			(1
				(Face gEgo table)
				(if (> (gMoney doit:) 0)
					(SetScore 75 165)
					(TheDungeon coinsLeft: 1)
				)
				(TheDungeon
					numberCoins:
						(+
							(gPennies taken:)
							(gHapennies taken:)
							(gFarthings taken:)
						)
				)
				(TheDungeon valueCoins: (gMoney get: taken:))
				(= cycles 2)
			)
			(2
				(for
					((= local1 1))
					(and (<= local1 (TheDungeon numberCoins:)) (< local1 15))
					((++ local1))
					
					((= [local2 local1] (coins new:))
						setPri: 11
						init:
						posn: (Random 135 150) (Random 121 130)
					)
				)
				(NormalEgo)
				(TheDungeon coinsDoneBeenTook: 0)
				(= local0 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getCoins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 139 156 self)
			)
			(1
				(Face gEgo table)
				(gEgo get: 0) ; bucks
				(= cycles 2)
			)
			(2
				(for
					((= local1 1))
					(and (<= local1 (TheDungeon numberCoins:)) (< local1 15))
					((++ local1))
					
					([local2 local1] dispose:)
				)
				(gMoney put:)
				(TheDungeon numberCoins: 0)
				(TheDungeon valueCoins: 0)
				(TheDungeon coinsLeft: 0)
				(NormalEgo)
				(= local0 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance saveBoys of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global164 5)
				(gCurRoom setScript: 0)
				(ClearFlag 212)
				(if (and (!= (gEgo x:) 131) (!= (gEgo y:) 165))
					(gEgo setMotion: PolyPath 131 165 self)
				else
					(= ticks 2)
				)
			)
			(1
				(gEgo view: 23 loop: 2 cel: 4)
				(= cycles 3)
			)
			(2
				(TheDungeon setScript: 0)
				(TheDungeon longTimerGone: 1)
				(Converse @local56 9 0 self) ; "The monks' robes would be a great help once I get the lads out of this pit, but---the belts!"
			)
			(3
				(gEgo
					view: 411
					loop: 1
					cel: 0
					cycleSpeed: 3
					setCycle: ForwardCounter 3 self
				)
			)
			(4
				(= ticks 60)
			)
			(5
				(gEgo loop: 2 setCycle: End self)
			)
			(6
				(gEgo setCel: (- (gEgo cel:) 1))
				(= ticks 12)
			)
			(7
				(gEgo setCel: (+ (gEgo cel:) 1))
				(= ticks 12)
			)
			(8
				(gEgo setCel: (- (gEgo cel:) 1))
				(= ticks 12)
			)
			(9
				(gEgo setCel: (+ (gEgo cel:) 1))
				(= ticks 12)
			)
			(10
				(gEgo setCel: (- (gEgo cel:) 1))
				(= ticks 12)
			)
			(11
				(gEgo setCycle: End self)
				(= seconds 2)
			)
			(12)
			(13
				(hal x: 126 y: 177 signal: 1 view: 411 loop: 4 init:)
				(gEgo setCycle: Beg)
				(hal setCycle: End self)
			)
			(14
				(Converse @local61 9 0 self) ; "Dicken, you next!"
			)
			(15
				(gEgo loop: 2 setCycle: End self)
			)
			(16
				(gEgo setCel: (- (gEgo cel:) 1))
				(= ticks 12)
			)
			(17
				(gEgo setCel: (+ (gEgo cel:) 1))
				(= ticks 12)
			)
			(18
				(gEgo setCel: (- (gEgo cel:) 1))
				(= ticks 12)
			)
			(19
				(gEgo setCel: (+ (gEgo cel:) 1))
				(= ticks 12)
			)
			(20
				(gEgo setCel: (- (gEgo cel:) 1))
				(= ticks 12)
			)
			(21
				(gEgo setCycle: End self)
				(= seconds 2)
			)
			(22)
			(23
				(robes init:)
				(gEgo put: 13) ; robes
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 410 10)
				(hob x: 84 y: 185 signal: 1 view: 254 loop: 1 init:)
				(dicken x: 188 y: 180 signal: 1 view: 412 loop: 3 init:)
				(rope init:)
				(= ticks 12)
			)
			(24
				(rope setCycle: End self)
			)
			(25
				(SetMessageColor 13)
				(Say 1410 9 self 80 {Dicken}) ; "You go next, Hob."
			)
			(26
				(SetMessageColor 12)
				(Say 1410 10 self 80 {Hob}) ; "You'll get up that rope right now or I'll box your ears 'til they bleed!"
			)
			(27
				(SetMessageColor 0)
				(dicken setCycle: End self)
			)
			(28
				(rope dispose:)
				(dicken dispose:)
				(dickenWithRope init:)
				(= ticks 12)
			)
			(29
				(dickenWithRope cycleSpeed: 6 setCycle: End self)
			)
			(30
				(dickenWithRope dispose: delete:)
				(hob dispose: delete:)
				(= ticks 12)
			)
			(31
				(gCurRoom drawPic: 570 10)
				(dicken view: 412 loop: 2 cel: 6 posn: 202 170 init:)
				(gCast eachElementDo: #show)
				(hal x: 94 y: 179 view: 254 loop: 2)
				(= ticks 12)
			)
			(32
				(Converse @local65 9 0 self) ; "Quickly, while Hob climbs, take those robes into the tunnels and put them on."
			)
			(33
				(HandsOn)
				(SetFlag 125)
				(TheDungeon boysRescued: 1)
				(SetScore 150 56)
				(gCurRoom newRoom: 561) ; tunnel2
				(self dispose:)
			)
		)
	)
)

(instance comeBackHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: PolyPath 40 (gEgo y:) self)
			)
			(2
				(Say 1570 55) ; "The guards are gone for now, but could return at any second."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance blessBoys of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: openIt self)
			)
			(1
				(HandsOff)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 410 10)
				(hal view: 254 loop: 2 posn: 72 183 init:)
				(hob view: 254 loop: 1 posn: 109 179 init:)
				(dicken view: 412 loop: 2 posn: 266 184 init:)
				(= cycles 3)
			)
			(2
				(= notKilled 1)
				(Converse @local73 9 0 self) ; "My sons, I have come to pray for your wicked souls. Lift up thine eyes and attend unto me."
			)
			(3
				(hal setCycle: End)
				(dicken setCycle: End self)
			)
			(4
				(SetMessageColor 12)
				(Say 1410 1 self 80 {Hob}) ; "A pox on you, Monk."
			)
			(5
				(SetMessageColor 13)
				(Say 1410 2 self 80 {Dicken}) ; "But that's--"
			)
			(6
				(SetMessageColor 11)
				(Say 1410 3 self 80 {Hal}) ; "A Hooded Man! Aye, we see you now, 'Brother' and with glad eyes. What would you say to us?"
			)
			(7
				(SetMessageColor 0)
				(Converse @local77 9 0 self) ; "That salvation may yet be yours if you will follow my path."
			)
			(8
				(hal setCycle: Beg self)
			)
			(9
				(SetMessageColor 11)
				(Say 1410 5 self 80 {Hal}) ; "Wherever you lead us, 'Brother', we will follow, if God wills."
			)
			(10
				(SetMessageColor 0)
				(Converse @local81 9 0 self) ; "Aye, if God wills, for it is my duty to lead you from the darkness into the light, and I shall not fail in my duty even should the devil himself block my path."
			)
			(11
				(SetMessageColor 19)
				(Say 1410 7 self 80 {Jack}) ; "That's enough. Shrive their souls and be done with it."
			)
			(12
				(SetMessageColor 0)
				(Converse @local85 9 0 self) ; "Have faith, my sons. Domine dirige nos."
			)
			(13
				(SetFlag 188)
				(hal hide: dispose: delete:)
				(hob hide: dispose: delete:)
				(dicken hide: dispose: delete:)
				(gCurRoom drawPic: 570 10)
				(gCast eachElementDo: #show)
				(gAddToPics add: closedDoor doit:)
				(self dispose:)
			)
		)
	)
)

(instance trembling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(TheDungeon trapDoorOpen: 0)
				(trapdoor x: (- (trapdoor x:) 1))
				(= cycles 2)
			)
			(1
				(trapdoor x: (+ (trapdoor x:) 1))
				(= cycles 2)
			)
			(2
				(trapdoor x: (- (trapdoor x:) 1))
				(= cycles 2)
			)
			(3
				(trapdoor x: (+ (trapdoor x:) 1))
				(= cycles 2)
			)
			(4
				(trapdoor x: (- (trapdoor x:) 1))
				(= cycles 2)
			)
			(5
				(trapdoor x: (+ (trapdoor x:) 1))
				(= cycles 2)
			)
			(6
				(trapdoor cycleSpeed: 6 setCycle: Beg self)
			)
			(7
				(trapDoorSound number: 562 play:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openIt of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 131 165 self)
			)
			(1
				(gEgo view: 23 loop: 2 cel: 4)
				(= cycles 3)
			)
			(2
				(gEgo
					view: 411
					loop: 0
					cel: 0
					cycleSpeed: 24
					setCycle: CT 2 1 self
				)
			)
			(3
				(gEgo view: 411 cycleSpeed: 24 setCycle: End)
				(trapdoor cycleSpeed: 24 setCycle: End self)
			)
			(4
				(trapDoorSound number: 563 play:)
				(HandsOn)
				(NormalEgo 2)
				(= local0 1)
				(= global164 0)
				(TheDungeon trapDoorOpen: 1)
				(self dispose:)
			)
		)
	)
)

(instance trapDoorSound of Sound
	(properties
		flags 1
	)
)

