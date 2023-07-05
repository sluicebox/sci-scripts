;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use MoveForward)
(use n128)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm73 0
)

(instance frontDoor of Act
	(properties
		y 138
		x 143
		view 173
		loop 2
		cel 4
		priority 10
		signal 16400
		illegalBits 0
	)
)

(instance frontDoorPassage of Prop
	(properties
		y 138
		x 143
		view 173
		loop 2
		priority 9
		signal 16400
	)
)

(instance Rm73 of Rm
	(properties
		picture 73
	)

	(method (init)
		(super init:)
		(= global112 3)
		(self setRegions: 125) ; Catacombs
		(switch gPrevRoomNum
			(74
				(gEgo posn: 182 210 loop: 3 setMotion: MoveForward 30)
			)
			(else
				(gEgo posn: 300 157 loop: 1 setMotion: MoveForward 30)
				(if (gEgo has: 10) ; lamb | dove
					(SetFlag 180)
				)
			)
		)
		(cond
			((IsFlag 172)
				(Print 73 0) ; "You should not be trapped in 73"
			)
			((IsFlag 318)
				(frontDoor init: stopUpd:)
				(frontDoorPassage init: stopUpd:)
			)
			((and (gEgo has: 10) (not (IsFlag 180))) ; lamb | dove
				(frontDoor init: stopUpd:)
				(frontDoorPassage init: stopUpd:)
			)
		)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((> (gEgo y:) 188)
				(gEgo setMotion: LeaveRoom 74 2 20)
			)
			((IsFlag 172) 0)
			((& (gEgo onControl:) $0010)
				(gEgo setScript: DeathDoor)
			)
			((& (gEgo onControl:) $0040)
				(gEgo setMotion: LeaveRoom 71 0 35)
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
				(not
					(or
						(== (event type:) evMOUSEBUTTON)
						(Said 'look,(are<where)>')
						(Said 'ask[/merlin]/*>')
					)
				)
				(return)
			)
			(
				(or
					(Said 'look[<!*][/room,catacomb]')
					(Said '//room,catacomb')
					(Said 'look<around')
					(Said 'look<at/room,catacomb')
				)
				(Print 73 1) ; "This room is smaller and more barren, except for the mural upon one wall. The opposite wall has partially collapsed. There are no mummies or urns here."
			)
			(
				(or
					(Said '/mosaic')
					(Said '//mosaic')
					(OnButton event 43 43 257 136)
				)
				(SetScore 284 1 1)
				(Print 73 2) ; "It shows the story of Pygmalion, which is written in your Liber ex Doctrina. This version is rather fancifully embellished with doves and piping satyrs."
			)
			((or (Said '/wall') (Said '//wall'))
				(Print 73 3) ; "Except for the one mural, the other walls are bare. Part of the wall opposite the mural has crumbled away."
			)
			((or (Said '/pan,pipe') (Said '//pan,pipe'))
				(Print 73 4) ; "I suppose the satyr figures in the mural represent the nature god, Pan, playing upon his pipes."
			)
			((or (Said '/dove,bird') (Said '//dove,bird'))
				(if (not (gEgo has: 10)) ; lamb | dove
					(Print 73 5) ; "There are doves shown in the mural, representing the power of Aphrodite."
				else
					((gInventory at: 10) showSelf:) ; lamb | dove
					(Print 73 6) ; "The stone dove you now carry is much like the doves painted in the mural."
				)
			)
			((or (Said '/column,jar,jar') (Said '//column,jar,jar'))
				(Print 73 7) ; "It is merely a decorative element in the mural."
			)
			((or (Said '/woman,sculpture') (Said '//woman,sculpture'))
				(Print 73 8) ; "To learn more of this legend, read the Liber ex Doctrina."
			)
			(
				(or
					(Said '/cross,design')
					(Said '//cross,design')
					(OnButton event 287 54 295 66)
				)
				(Print 73 9) ; "There is an inverted cross above one door. The Christians call it St. Peter's Cross, for they believe the apostle Peter was crucified upside-down."
			)
			((or (Said '/design') (Said '//design'))
				(Print 73 10) ; "There are some geometric designs painted in one doorway."
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
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
				)
			)
			(1
				(gEgo posn: 500 500)
				(frontDoor startUpd: setCycle: CT 1 -1 self)
				(frontDoorPassage startUpd:)
			)
			(2
				(frontDoor dispose:)
				(frontDoorPassage dispose:)
				(= seconds 3)
			)
			(3
				(Print 73 11) ; "Nay, you have chosen wrongly! The door has shut behind you, trapping you within a pitch black hole scarcely larger than a coffin."
				(EgoDead 73 12) ; "And a stone coffin it is, for here you shall die all too soon. Farewell, King Arthur."
			)
		)
	)
)

