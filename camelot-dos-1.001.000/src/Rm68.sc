;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
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
	Rm68 0
)

(local
	[local0 9] = [104 66 175 179 213 144 298 139 -32768]
	[local9 11] = [236 126 167 158 132 140 31 164 -18 156 -32768]
	[local20 13] = [296 141 192 160 123 132 71 145 34 136 9 136 -32768]
)

(instance doorSymbol of PV
	(properties
		y 62
		x 148
		view 168
		loop 1
		cel 2
		priority 10
		signal 16
	)
)

(instance leftDoor of Act
	(properties
		y -3
		x 35
		yStep 9
		view 168
		priority 6
		signal 16400
		illegalBits 0
	)
)

(instance frontDoor of Act
	(properties
		y 68
		x 148
		yStep 7
		view 168
		loop 1
		priority 6
		signal 16400
		illegalBits 0
	)
)

(instance rightDoor of Act
	(properties
		y 4
		x 268
		yStep 9
		view 168
		loop 2
		priority 6
		signal 16400
		illegalBits 0
	)
)

(instance bone of View
	(properties
		y 124
		x 83
		view 267
		cel 1
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

(instance rightBlock of Blk
	(properties
		left 325
		bottom 210
		right 330
	)
)

(instance fragments of PV
	(properties
		y 177
		x 267
		view 267
		cel 3
		signal 16384
	)
)

(instance fragments2 of PV
	(properties
		y 179
		x 119
		view 267
		cel 4
		signal 16384
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
		(return [local9 param1])
	)
)

(instance rat3Path of CPath
	(properties)

	(method (at param1)
		(return [local20 param1])
	)
)

(instance Rm68 of Rm
	(properties
		picture 68
	)

	(method (init)
		(super init:)
		(= global112 0)
		(runningRats rPath1: rat1Path rPath2: rat2Path rPath3: rat3Path)
		(self setRegions: 125 127 174) ; Catacombs, runningRats, RatBlink
		(gEgo observeBlocks: bottomBlock leftBlock rightBlock)
		(switch gPrevRoomNum
			(69
				(gEgo posn: 10 137 loop: 0 setMotion: MoveForward 35)
			)
			(71
				(gEgo posn: 148 102 loop: 2 setMotion: MoveForward 20)
			)
			(else
				(gEgo posn: 289 145 loop: 1 setMotion: MoveForward 38)
			)
		)
		(if (IsFlag 186)
			(bone init: stopUpd:)
		)
		(if (IsFlag 171)
			(ClearFlag 171)
			(gCurRoom setScript: closeDoors)
		)
		(RatBlink addEyes: 184 102 8 addEyes: 93 112 8 addEyes: 225 169 8)
		(gAddToPics add: doorSymbol fragments fragments2)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			((or global80 (IsFlag 172)) 0)
			((& (gEgo onControl:) $0020)
				(gEgo setMotion: LeaveRoom 69 1 30)
			)
			((& (gEgo onControl:) $0010)
				(gEgo setMotion: LeaveRoom 71 3 5)
			)
			((& (gEgo onControl:) $0040)
				(gEgo setMotion: LeaveRoom 67 0 30)
			)
		)
		(if (IsFlag 179)
			(RatBite gotoX1: 59 gotoY1: 128 gotoX2: 0 gotoY2: 132)
			(cond
				((and (< (gEgo x:) 147) (< (gEgo y:) 133))
					(RatBite midPointX: 98 optCel: 3)
					((ScriptID 172 0) y: 102 init:) ; bitingRat
				)
				((and (> (gEgo x:) 147) (< (gEgo y:) 133))
					(RatBite midPointX: 195)
					((ScriptID 172 0) y: 96 init:) ; bitingRat
				)
				(else
					(RatBite
						midPointX: 0
						offControlsX: (- (gEgo x:) 27)
						offControlsY: (gEgo y:)
					)
					((ScriptID 172 0) ; bitingRat
						posn: (+ 353 (- (gEgo x:) 290)) 133
						init:
					)
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
			((or (== (event type:) evMOUSEBUTTON) (Said 'look,ask,(are<where)>'))
				(cond
					(
						(or
							(Said 'look[<!*][/room,catacomb]')
							(Said '//room,catacomb')
							(Said 'look<around')
							(Said 'look<at/room,catacomb')
						)
						(Print 68 0) ; "There are three doorways, mummies, urns and some symbols."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 68 1) ; "Two walls contain niches of mummies and the two painted symbols. The other two walls are barren."
					)
					((or (Said '/design') (Said '//design'))
						(Print 68 2) ; "Over one doorway is a small mushroom. Over the other doorway is the Gnostic symbol of the eight rayed sun."
					)
					(
						(or
							(Said '/amanita')
							(Said '//amanita')
							(OnButton event 262 54 270 62)
						)
						(Print 68 3) ; "It is simply a small mushroom painted over one doorway. There are many mushroom cults in the Far East."
					)
					(
						(or
							(Said '/star,sun,rayed,design')
							(Said '//star,sun,rayed,design')
							(OnButton event 137 40 162 62)
						)
						(Print 68 4) ; "To the Gnostics, the eight rayed sun represents the universe with the dome of heaven in the center."
					)
					(
						(or
							(Said '[<at,!*]/body')
							(Said '//body')
							(OnButton event 77 73 122 93)
							(OnButton event 76 94 124 112)
							(OnButton event 174 77 217 103)
							(OnButton event 299 115 310 141)
						)
						(Print 68 5) ; "Most of these mummies must be quite old, for they look dry and brittle, and smell of dust and decay."
					)
					(
						(or
							(and (not (gEgo has: 9)) (Said '/bone')) ; herbs | bone
							(Said '//bone')
							(and
								(gCast contains: bone)
								(MouseClaimed bone event)
							)
						)
						(Print 68 6) ; "There are a great many bones around, as might be expected in catacombs."
					)
					(
						(or
							(Said '[<at,!*]/pot,jar,pot')
							(Said '//pot,jar,pot')
							(OnButton event 79 145 123 172)
							(OnButton event 191 151 254 175)
							(OnButton event 211 104 235 123)
							(OnButton event 233 119 250 132)
						)
						(Print 68 7) ; "The funereal urns within these sepulchers are designed to hold the ashes of the deceased, or their mummified organs."
					)
				)
			)
			((Said 'get,(pick<up)/bone')
				(cond
					((gEgo has: 9) ; herbs | bone
						(event claimed: 0)
					)
					((gCast contains: bone)
						(if (< (gEgo distanceTo: bone) 40)
							(proc173_4 bone 186)
						else
							(NotClose) ; "Perhaps you should move closer."
						)
					)
				)
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
				(gEgo illegalBits: $fffe)
				(leftDoor setLoop: 0 init: setMotion: MoveTo (leftDoor x:) 67)
				(frontDoor
					setLoop: 1
					setPri: 0
					init:
					setMotion: MoveTo (frontDoor x:) 116 self
				)
				(rightDoor setLoop: 2 init: setMotion: MoveTo (rightDoor x:) 72)
				(gSFX number: (proc0_20 84) loop: 1 play:)
			)
			(2
				(gSFX stop: number: (proc0_20 87) loop: 1 play:)
				(client setScript: 0)
			)
		)
	)
)

