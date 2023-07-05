;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use MoveForward)
(use runningRats)
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
	Rm72 0
)

(local
	[local0 15] = [251 189 206 170 249 153 203 134 217 121 184 111 153 108 -32768]
	[local15 11] = [294 135 219 149 180 171 81 172 43 189 -32768]
)

(instance leftDoor of Prop
	(properties
		y 136
		x 62
		view 172
		loop 3
		cel 1
		priority 10
		signal 16400
	)
)

(instance leftDoorPassage of Prop
	(properties
		y 136
		x 62
		view 172
		loop 3
		priority 9
		signal 16400
	)
)

(instance frontDoor of Act
	(properties
		y 61
		x 185
		yStep 8
		view 172
		loop 1
		signal 16384
		illegalBits 0
	)
)

(instance rightDoor of Act
	(properties
		x 277
		yStep 8
		view 172
		signal 16384
		illegalBits 0
	)
)

(instance bone1 of Prop
	(properties
		y 174
		x 266
		view 267
		cel 1
	)
)

(instance bone2 of View
	(properties
		y 161
		x 40
		view 267
		cel 2
	)
)

(instance fragments of PV
	(properties
		y 173
		x 38
		view 267
		cel 4
		signal 16384
	)
)

(instance fragments2 of PV
	(properties
		y 170
		x 26
		view 267
		cel 3
		signal 16384
	)
)

(instance fragments3 of PV
	(properties
		y 129
		x 123
		view 267
		cel 3
		signal 16384
	)
)

(instance urn1 of PV
	(properties
		y 179
		x 62
		view 172
		loop 2
	)
)

(instance urn2 of PV
	(properties
		y 174
		x 288
		view 172
		loop 2
		cel 2
	)
)

(instance urn3 of PV
	(properties
		y 168
		x 268
		view 172
		loop 2
		cel 3
	)
)

(instance urn4 of PV
	(properties
		y 171
		x 309
		view 172
		loop 2
		cel 3
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

(instance bottomBlock of Blk
	(properties
		top 195
		left -10
		bottom 210
		right 330
	)
)

(instance rightBlock of Blk
	(properties
		left 325
		bottom 210
		right 330
	)
)

(instance leftDoorBlock of Blk
	(properties
		top 134
		left 80
		bottom 138
		right 95
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

(instance Rm72 of Rm
	(properties
		picture 72
	)

	(method (init)
		(super init:)
		(= global112 3)
		(runningRats rPath1: rat1Path rPath2: rat2Path)
		(self setRegions: 125 127 174) ; Catacombs, runningRats, RatBlink
		(gEgo observeBlocks: leftBlock bottomBlock rightBlock)
		(switch gPrevRoomNum
			(71
				(gEgo posn: 184 115 loop: 2 setMotion: MoveForward 5)
			)
			(74
				(gEgo setScript: comeOutOfInvisibleDoor)
			)
			(else
				(gEgo posn: 289 134 loop: 1 setMotion: MoveForward 35)
			)
		)
		(if (IsFlag 190)
			(bone1 init: stopUpd:)
		)
		(if (IsFlag 191)
			(bone2 init: stopUpd:)
		)
		(if (IsFlag 174)
			(leftDoor setCel: 255 setPri: 10)
			(gEgo observeBlocks: leftDoorBlock)
			(skeleton init: setCel: 255 stopUpd:)
			(skull setLoop: 1 setCel: 2 posn: 152 158 init: stopUpd:)
		)
		(cond
			((and (gEgo has: 10) (== gPrevRoomNum 69)) ; lamb | dove
				(gEgo setScript: openTempleDoor)
			)
			((IsFlag 171)
				(ClearFlag 171)
				(gCurRoom setScript: closeDoors)
			)
		)
		(RatBlink
			addEyes: 139 87 9
			addEyes: 119 113 9
			addEyes: 305 93 9
			addEyes: 239 107 9
		)
		(gAddToPics
			add: fragments fragments2 fragments3 urn1 urn2 urn3 urn4
			doit:
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((or global80 (IsFlag 172)) 0)
			((& (gEgo onControl:) $0010)
				(gEgo setMotion: LeaveRoom 71 3 5)
			)
			((& (gEgo onControl:) $0040)
				(gEgo setMotion: LeaveRoom 69 0 25)
			)
			((& (gEgo onControl:) $0002)
				(gEgo setScript: gotoTemple)
			)
		)
		(if (IsFlag 179)
			(RatBite gotoX1: 240 gotoY1: 135 gotoX2: 291 gotoY2: 131)
			(cond
				((and (> (gEgo x:) 184) (> (gEgo y:) 134))
					(RatBite
						midPointX: 0
						offControlsX: (- (gEgo x:) 30)
						offControlsY: (gEgo y:)
					)
					((ScriptID 172 0) posn: 360 108 init:) ; bitingRat
				)
				((and (> (gEgo x:) 184) (< (gEgo y:) 134))
					(RatBite midPointX: 245 spread: 0)
					((ScriptID 172 0) y: 104 init:) ; bitingRat
				)
				(else
					(RatBite midPointX: 135 spread: 10)
					((ScriptID 172 0) y: 102 init:) ; bitingRat
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
					((Said 'look<in/entrance,exit,stair')
						(if (IsFlag 174)
							(Print 72 0) ; "The stairs lead upward."
						else
							(Print 72 1) ; "There are two doorways to this room."
						)
					)
					(
						(or
							(Said 'look[<!*][/room,catacomb]')
							(Said '//room,catacomb')
							(Said 'look<around')
							(Said 'look<at/room,catacomb')
						)
						(Print 72 2) ; "A mural covers one entire wall. There are two doorways, mummies and painted designs, including many spirals."
					)
					(
						(or
							(Said '/spiral')
							(Said '//spiral')
							(OnButton event 208 65 225 114)
						)
						(Print 72 3) ; "There are lunar and solar spirals here. A solar spiral goes in the sunwise direction. Sunwise is the direction that the shadow of the sun moves around a sundial."
						(Print 72 4) ; "A lunar spiral moves to the left, in the opposite or counter-sunwise direction."
						(Print 72 5) ; "Solar spirals are signs of a God, while lunar spirals are signs of a Goddess."
						(SetScore 304 1 1)
					)
					(
						(or
							(Said '/mosaic')
							(Said '//mosaic')
							(OnButton event 9 31 64 135)
							(OnButton event 60 46 111 118)
						)
						(SetScore 283 1 1)
						(Print 72 6) ; "This mural shows the death of Hippolytus, as brought about by Aphrodite. The full story is told in your Liber ex Doctrina."
					)
					((or (Said '/skeleton') (Said '//skeleton'))
						(if (IsFlag 174)
							(Print 72 7) ; "This poor warrior had his head split in two.  He must have lain there for centuries. We shall never know his story."
						else
							(Print 72 8) ; "The skeletons of the mummies remain well wrapped."
						)
					)
					((or (Said '/skull') (Said '//skull'))
						(if (IsFlag 174)
							(Print 72 9) ; "It was split in half by some powerful blow from a large sword. A helmet would have saved him."
						else
							(Print 72 10) ; "All the skulls in this room are well-wrapped... which is sometimes more than I can say for yours."
						)
					)
					(
						(or
							(Said '/bull,chariot,charioteer,charger,legend')
							(Said '//bull,chariot,charioteer,charger,legend')
						)
						(Print 72 11) ; "To learn more about what the mural shows, read the Liber ex Doctrina."
					)
					((or (Said '/armor') (Said '//armor'))
						(if (IsFlag 174)
							(Print 72 12) ; "It is quite old, but intact, though not as good as what you have."
						else
							(Print 72 13) ; "The only armour here is upon your person."
						)
					)
					((or (Said '/wall') (Said '//wall'))
						(if (IsFlag 174)
							(Print 72 14) ; "A secret exit has opened in the mural. This is now the only way out."
						else
							(Print 72 15) ; "One wall is covered with the mural, with four spirals in the corners. There are more spirals upon another wall, and some geometric designs on the other doorway."
						)
					)
					((or (Said '/design') (Said '//design'))
						(Print 72 16) ; "Other than the spirals and mural, the other decorations are simply painted geometric designs."
					)
					((and (IsFlag 174) (Said '//grail'))
						(Print 72 17) ; "The way is open. Surely the end of your mission draws nigh."
					)
					(
						(or
							(Said '[<at,!*]/body')
							(Said '//body')
							(OnButton event 118 65 161 113)
							(OnButton event 234 94 247 115)
							(OnButton event 291 94 311 135)
						)
						(Print 72 18) ; "Most of these mummies must be quite old, for they look dry and brittle, and smell of dust and decay."
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
						(Print 72 19) ; "There are a great many bones around, as might be expected in catacombs."
					)
					(
						(or
							(Said '[<at,!*]/pot,jar,pot')
							(Said '//pot,jar,pot')
							(OnButton event 260 157 300 172)
							(OnButton event 300 163 310 169)
							(OnButton event 54 167 70 180)
						)
						(Print 72 20) ; "The funereal urns within these sepulchers are designed to hold the ashes of the deceased, or their mummified organs."
					)
				)
			)
			((and (IsFlag 174) (Said 'get/skull,skeleton,bone,armor'))
				(Print 72 21) ; "Nay, let it lie undisturbed any further. The way is open. Press onward."
			)
			((Said 'get,(pick<up)/bone')
				(cond
					((gEgo has: 9) ; herbs | bone
						(event claimed: 0)
					)
					(
						(and
							(gCast contains: bone1)
							(< (gEgo distanceTo: bone1) 35)
						)
						(proc173_4 bone1 190)
					)
					(
						(and
							(gCast contains: bone2)
							(< (gEgo distanceTo: bone2) 35)
						)
						(proc173_4 bone2 191)
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
			((and (IsFlag 178) (== gPrevRoomNum 69) (Said 'get/shield'))
				(Print 72 22) ; "It is old and far inferior to your own."
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
				(Print 72 23) ; "The tunnel has brought you to this room. In the wall behind you, the hidden door seals. You cannot even see where it was."
				(gEgo observeBlocks: bottomBlock illegalBits: -16384)
				(HandsOn)
				(client setScript: 0)
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
				(frontDoor
					init:
					setLoop: 1
					setPri: 0
					setMotion: MoveTo (frontDoor x:) 117
				)
				(rightDoor
					init:
					setLoop: 0
					setPri: 0
					setMotion: MoveTo (rightDoor x:) 67 self
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

(instance skeleton of Prop
	(properties
		y 142
		x 45
		view 172
		loop 4
		signal 16384
	)
)

(instance skull of Act
	(properties
		y 143
		x 113
		view 172
		loop 5
	)
)

(instance openTempleDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 245 (gEgo y:) self)
			)
			(1
				(frontDoor
					init:
					setLoop: 1
					setPri: 0
					setMotion: MoveTo (frontDoor x:) 117
				)
				(rightDoor
					init:
					setLoop: 0
					setPri: 0
					setMotion: MoveTo (rightDoor x:) 67 self
				)
				(gSFX number: (proc0_20 84) loop: 1 play:)
			)
			(2
				(gSFX stop: number: (proc0_20 87) loop: 1 play:)
				(frontDoor stopUpd:)
				(rightDoor stopUpd:)
				(= seconds 2)
			)
			(3
				(Print 72 24) ; "Heavy stone doors have sealed the room! Has the Goddess trapped you or---nay. Look!"
				(leftDoor init: setPri: 10 cycleSpeed: 1 setCycle: CT 5 1 self)
				(leftDoorPassage init: stopUpd:)
				(skeleton setLoop: 1 setCel: 1 init: setPri: 9)
			)
			(4
				(leftDoor setCycle: End)
				(skeleton setLoop: 4 setCel: 0 setPri: 10 setCycle: CT 4 1 self)
			)
			(5
				(skeleton setCel: 5)
				(skull init: setCycle: End self)
			)
			(6
				(Print 72 25) ; "Secret stairs leading upward have been revealed....along with the skeleton of a warrior."
				(SetScore 0 0 5)
				(skeleton stopUpd: ignoreActors:)
				(skull setLoop: 1 setCel: 2 posn: 152 158 stopUpd:)
				(gEgo observeBlocks: leftDoorBlock illegalBits: -32684)
				(ClearFlag 172)
				(SetFlag 174)
				(PutItem 7) ; crystal_heart | charcoal | helm
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance gotoTemple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: (+ (leftDoorPassage priority:) 1)
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 40 141 self
				)
			)
			(1
				(gEgo
					setPri: (leftDoorPassage priority:)
					setMotion: MoveTo 15 118 self
				)
			)
			(2
				(= seconds 1)
			)
			(3
				(if (IsFlag 173)
					(SetScore 2 -50)
				)
				(gCurRoom newRoom: 76)
			)
		)
	)
)

