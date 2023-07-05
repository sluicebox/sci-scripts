;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use MoveForward)
(use runningRats)
(use n128)
(use bitingRat)
(use trappedByDoors)
(use RatBlink)
(use Interface)
(use CPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm69 0
)

(local
	[local0 15] = [80 190 93 180 95 175 144 160 191 175 257 173 293 187 -32768]
	[local15 9] = [95 128 120 128 122 140 11 145 -32768]
	[local24 15] = [11 148 53 151 90 157 131 153 147 175 198 180 228 189 -32768]
)

(instance leftDoor of Act
	(properties
		y 7
		x 30
		yStep 9
		view 169
		loop 1
		signal 16384
		illegalBits 0
	)
)

(instance frontDoor of Act
	(properties
		y 80
		x 136
		yStep 7
		view 169
		loop 2
		signal 16384
		illegalBits 0
	)
)

(instance rightDoor of Prop
	(properties
		y 157
		x 263
		view 169
		loop 3
		cel 1
		priority 12
		signal 16400
	)
)

(instance rightDoorPassage of View
	(properties
		y 157
		x 263
		view 169
		loop 3
		priority 11
		signal 16
	)
)

(instance entranceDoor of Prop
	(properties
		y 142
		x 224
		view 169
		cel 1
		priority 9
		signal 16384
	)
)

(instance entranceDoorPassage of View
	(properties
		y 142
		x 224
		view 169
		priority 8
		signal 16
	)
)

(instance bone1 of View
	(properties
		y 144
		x 92
		view 267
	)
)

(instance bone2 of View
	(properties
		y 176
		x 243
		view 267
		cel 2
	)
)

(instance fragments of PV
	(properties
		y 170
		x 250
		view 267
		cel 3
		signal 16384
	)
)

(instance aMummy of PV
	(properties
		y 124
		x 178
		view 169
		loop 4
		priority 9
		signal 16400
	)
)

(instance bottomBlock of Blk
	(properties
		top 195
		left -10
		bottom 210
		right 330
	)
)

(instance leftBlock of Blk
	(properties
		top 160
		left -10
		bottom 210
		right -5
	)
)

(instance rightDoorBlock of Blk
	(properties
		top 154
		left 232
		bottom 160
		right 265
	)
)

(instance rat1Path of CPath
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance rat2Path of CPath
	(properties)

	(method (at param1)
		(return [local15 param1])
	)
)

(instance rat3Path of CPath
	(properties)

	(method (at param1)
		(return [local24 param1])
	)
)

(instance Rm69 of Rm
	(properties
		picture 69
	)

	(method (init)
		(super init:)
		(= global112 3)
		(runningRats rPath1: rat1Path rPath2: rat2Path rPath3: rat3Path)
		(self setRegions: 125 127 174) ; Catacombs, runningRats, RatBlink
		(gEgo observeBlocks: bottomBlock leftBlock)
		(switch gPrevRoomNum
			(66
				(if (IsFlag 72)
					(gEgo get: 2) ; lodestone
				)
				(if (IsFlag 73)
					(gEgo get: 5) ; sleeve | elixir
				)
				(if (IsFlag 74)
					(gEgo get: 4) ; rose | apple | green_apple
				)
				(gEgo setScript: enterCatacombs)
			)
			(67
				(gEgo setScript: comeOutOfInvisibleDoor)
			)
			(68
				(gEgo posn: 133 120 loop: 2 setMotion: MoveForward 20)
			)
			(72
				(gEgo posn: 19 150 loop: 0 setMotion: MoveForward 35)
			)
			(else
				(gEgo posn: 150 150)
			)
		)
		(if (IsFlag 187)
			(bone1 init: stopUpd:)
		)
		(if (IsFlag 188)
			(bone2 init: stopUpd:)
		)
		(cond
			((IsFlag 171)
				(ClearFlag 171)
				(gCurRoom setScript: closeDoors)
			)
			((gEgo has: 10) ; lamb | dove
				(rightDoor init: setCel: 255 stopUpd:)
				(rightDoorPassage init: setCel: 0)
			)
		)
		(RatBlink addEyes: 167 123 9 addEyes: 82 126 9)
		(gAddToPics add: fragments aMummy doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			((or global80 (IsFlag 172)) 0)
			((& (gEgo onControl:) $0020)
				(gEgo setMotion: LeaveRoom 72 1 35)
			)
			((& (gEgo onControl:) $0010)
				(gEgo setMotion: LeaveRoom 68 3 5)
			)
			((& (gEgo onControl:) $0040)
				(gEgo setScript: DeathDoor)
			)
		)
		(if (IsFlag 179)
			(RatBite gotoX1: 131 gotoY1: 128 gotoX2: 105 gotoY2: 118)
			(cond
				((< (gEgo x:) 78)
					(RatBite
						midPointX: 0
						offControlsX: 92
						offControlsY: 149
						optCel: 4
					)
					((ScriptID 172 0) posn: 26 110 init:) ; bitingRat
				)
				((< (gEgo x:) 134)
					(RatBite midPointX: 94 spread: 6)
					((ScriptID 172 0) y: 116 init:) ; bitingRat
				)
				(else
					(RatBite midPointX: 176)
					((ScriptID 172 0) y: 110 init:) ; bitingRat
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<!*][/room,catacomb]')
							(Said '//room,catacomb')
							(Said 'look<around')
							(Said 'look<at/room,catacomb')
						)
						(if (gEgo has: 10) ; lamb | dove
							(Print 69 0) ; "This room now has three doors from which to choose."
						else
							(Print 69 1) ; "Now that the secret entrance is shut, there remain two doorways to choose from. The entire wall through which you entered is covered with a mural."
							(Print 69 2) ; "The air is stale and musty. Everything around you is covered with the dust of centuries. The mummies in their niches are ancient, untouched for ages."
							(Print 69 3) ; "Would that Galahad had left some sign to guide us. He may be trapped in this foul place. Let us pray he is still alive."
							(Print 69 4) ; "But you must be extremely careful. I hear the skittering of the poisonous rats everywhere within the walls. Their evil eyes glint from behind and around the mummies. Avoid them at all costs!"
						)
					)
					(
						(or
							(Said 'ask//north,south,east,west')
							(Said
								'(<are<what<direction),show/north,south,east,west'
							)
						)
						(Print 69 5) ; "I can tell you this much, when you came down the stairs from the bazaar, you were facing north. Therefore the wall with the mural is facing south."
					)
					(
						(or
							(Said '[<at,!*]/pot,jar,pot')
							(Said '//pot,jar,pot')
							(OnButton event 47 158 138 178)
							(OnButton event 170 151 203 167)
						)
						(Print 69 6) ; "The funereal urns within these sepulchers are designed to hold the ashes of the deceased, or their mummified organs."
					)
					(
						(or
							(Said '[<at,!*]/body')
							(Said '//body')
							(OnButton event 56 100 69 128)
							(OnButton event 80 94 114 135)
							(OnButton event 160 101 196 123)
						)
						(Print 69 7) ; "Most of these mummies must be quite old, for they look dry and brittle, and smell of dust and decay."
					)
					(
						(or
							(and (not (gEgo has: 9)) (Said '/bone')) ; herbs | bone
							(Said '//bone')
							(and
								(gCast contains: bone1)
								(MouseClaimed bone1 event)
							)
							(and
								(gCast contains: bone2)
								(MouseClaimed bone2 event)
							)
						)
						(Print 69 8) ; "There are a great many bones around, as might be expected in catacombs."
					)
					((or (Said '/door,door') (Said '//door,door'))
						(if (not (gCast contains: rightDoor))
							(Print 69 9) ; "There are two doorways from this room."
						else
							(Print 69 10) ; "There are now three doorways to choose from in this room. But the third one is not the same as the one through which you first entered."
						)
					)
					(
						(or
							(Said '/entrance,exit,stair,opening')
							(Said '//entrance,exit,stair,opening')
						)
						(if (not (gEgo has: 10)) ; lamb | dove
							(Print 69 11) ; "The secret entrance closed behind you. Your task, it would seem, is to discover a way out of here."
							(Print 69 12) ; "Let us hope you will also discover some sign of Galahad."
						else
							(Print 69 13) ; "The tunnel and door which led you here are now irrevocably closed. Your choices are before you."
						)
					)
					(
						(or
							(Said '/mosaic')
							(Said '//mosaic')
							(OnButton event 206 59 257 155)
							(OnButton event 253 46 310 167)
						)
						(SetScore 281 1 1)
						(Print 69 14) ; "It shows the death of Adonis, one of Aphrodite's lovers. The legend is written in the Liber ex Doctrina."
						(Print 69 15) ; "Interestingly, there is also a tree filled with golden apples in this mural."
					)
					((or (Said '/boar,boy,man') (Said '//boar,boy,man'))
						(Print 69 16) ; "To learn more about the legend of Adonis, as shown in this mural, consult your Liber ex Doctrina."
					)
					(
						(or
							(Said '/tree')
							(Said '//tree')
							(Said '/apple')
							(Said '//apple')
						)
						(Print 69 17) ; "The tree in the mural bears golden apples, a reminder of Aphrodite."
					)
					((or (Said '/design') (Said '//design'))
						(Print 69 18) ; "There are colourful, but meaningless patterns painted upon one of the doorways."
					)
					((Said '//galahad')
						(Print 69 19) ; "He also would have entered here. Indeed, the dust on the floor looked a bit disturbed, but not enough to show which way he went."
					)
				)
			)
			((and (not (IsFlag 178)) (Said 'open,find,find/door'))
				(Print 69 20) ; "That door closed securely behind you, leaving no trace that it was ever there."
			)
			((Said 'get,(pick<up)/bone')
				(cond
					((gEgo has: 9) ; herbs | bone
						(event claimed: 0)
					)
					(
						(and
							(gCast contains: bone1)
							(< (gEgo distanceTo: bone1) 40)
						)
						(proc173_4 bone1 187)
					)
					(
						(and
							(gCast contains: bone2)
							(< (gEgo distanceTo: bone2) 40)
						)
						(proc173_4 bone2 188)
					)
					(
						(and
							(not (gCast contains: bone1))
							(not (gCast contains: bone2))
						)
						(event claimed: 0)
					)
					(else
						(NotClose) ; "Perhaps you should move closer."
					)
				)
			)
			((Said 'open/entrance,exit,stair,opening')
				(Print 69 21) ; "You cannot. A more powerful will than yours commands these doors."
			)
		)
	)
)

(instance closeDoors of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not global80))
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo illegalBits: -2)
				(leftDoor
					setLoop: 1
					setPri: 0
					init:
					setMotion: MoveTo (leftDoor x:) 78
				)
				(frontDoor
					setLoop: 2
					setPri: 0
					init:
					setMotion: MoveTo (frontDoor x:) 132 self
				)
				(gSFX number: (proc0_20 84) loop: 1 play:)
			)
			(2
				(gSFX stop: number: (proc0_20 87) loop: 1 play:)
				(client setScript: 0)
			)
		)
	)
)

(instance enterCatacombs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					posn: 270 116
					setPri: 9
					setMotion: MoveTo 225 158 self
				)
				(entranceDoor
					setLoop: 0
					setCel: 1
					setCycle: End
					setPri: 9
					init:
				)
				(entranceDoorPassage init:)
			)
			(1
				(gEgo setPri: 10)
				(entranceDoor setPri: -1 setCycle: CT 3 -1 self)
			)
			(2
				(gEgo loop: 0)
				(entranceDoor setCycle: CT 1 -1 self)
			)
			(3
				(entranceDoor dispose:)
				(entranceDoorPassage dispose:)
				(gEgo loop: 1 illegalBits: -16384 ignoreActors: 0 setPri: -1)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance comeOutOfInvisibleDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreBlocks: bottomBlock
					illegalBits: 0
					posn: 150 230
					setMotion: MoveTo 150 188 self
				)
			)
			(1
				(Print 69 22) ; "As before, the hidden door shuts as though it had never been there."
				(gEgo observeBlocks: bottomBlock illegalBits: -32768)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance DeathDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 11
					illegalBits: 0
					ignoreActors: 1
					ignoreBlocks: rightDoorBlock
					setMotion: MoveTo 295 158 self
				)
			)
			(1
				(rightDoor setPri: 13 setCycle: CT 1 -1 self)
			)
			(2
				(rightDoor dispose:)
				(rightDoorPassage dispose:)
				(gEgo setPri: 1)
				(= seconds 3)
			)
			(3
				(Print 69 23) ; "Nay, you have chosen wrongly! The door has shut behind you, trapping you within a pitch black hole scarcely larger than a coffin."
				(EgoDead 69 24) ; "And a stone coffin it is, for here you shall die all too soon. Farewell, King Arthur."
			)
		)
	)
)

