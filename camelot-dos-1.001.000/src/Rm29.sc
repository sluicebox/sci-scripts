;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	Rm29 0
)

(instance door of Prop
	(properties
		y 103
		x 158
		view 124
		cycleSpeed 1
	)
)

(instance Rm29 of eRoom
	(properties
		picture 29
		style 0
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 917)
	)

	(method (init)
		(Load rsVIEW 124)
		(Load rsSOUND 52)
		(Load rsSOUND 54)
		(super init:)
		(SetScore 262 0 10)
		(ClearFlag 312)
		(= global118 0)
		(self setRegions: 106) ; otMoor
		(door setCel: (if (== gPrevRoomNum 30) 255 else 0) init: stopUpd:)
		(switch gPrevRoomNum
			(30
				(self enterRoom: 120 112 120 135)
				(door setScript: CloseDoor)
			)
			(else
				(self enterRoom: 160 235 160 182)
			)
		)
		(proc0_13 33)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (ScriptID 106 1) (& (gEgo onControl:) $0002)) ; footSnow
				((ScriptID 106 1) dispose:) ; footSnow
			)
			(
				(and
					(not (gCast contains: (ScriptID 106 1))) ; footSnow
					(not (& (gEgo onControl:) $0002))
				)
				((ScriptID 106 1) setLoop: 1 ignoreActors: init:) ; footSnow
			)
		)
		(cond
			((or (self goingOut:) (self comingIn:)) 0)
			(
				(and
					(not (door script:))
					(not (IsFlag 65))
					(gEgo inRect: 95 115 150 125)
				)
				(door setScript: OpenDoor)
			)
			((> (gEgo y:) 185)
				(self leaveRoom: 23 (gEgo x:) 235)
			)
			((> (gEgo x:) 300)
				(self leaveRoom: 23 330 (gEgo y:))
			)
			((< (gEgo x:) 20)
				(self leaveRoom: 23 -10 (gEgo y:))
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
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
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/lake,moor,ot')
							(Said '//lake,moor,ot')
						)
						(Print 29 0) ; "Having reached the towering palace of ice, I must caution you. In this cold manifestation, the Lady of the Lake may not be the benefactress you have known in the past."
					)
					(
						(or
							(Said '/handle,cone')
							(Said '//handle,cone')
							(OnButton event 78 85 97 99)
							(OnButton event 108 84 126 99)
						)
						(Print 29 1) ; "I would guess that the triangular objects on the doors are door handles, though being made of ice do not seem very useful."
					)
					(
						(or
							(Said '/door')
							(Said '//door')
							(MouseClaimed door event)
							(OnButton event 51 59 102 114)
						)
						(Print 29 2) ; "The doors are made of solid ice, the same as the rest of the palace."
					)
					(
						(or
							(Said '/head,crest,design')
							(Said '/head,crest,design')
							(OnButton event 69 7 135 56)
						)
						(Print 29 3) ; "I cannot say what meaning this symbol has. Perhaps it is a warning, perhaps mere decoration."
					)
					(
						(or
							(Said '/stair')
							(Said '//stair')
							(OnButton event 11 113 191 139)
						)
						(Print 29 4) ; "The stairs are made of ice. Tread carefully."
					)
					(
						(or
							(Said '/mountain,hill,cotswold')
							(Said '//mountain,hill,cotswold')
							(OnButton event 282 73 310 105)
						)
						(Print 29 5) ; "In the far distance, you glimpse part of the Cotswold Hills."
					)
					(
						(or
							(Said '/castle')
							(Said '//castle')
							(OnButton event 9 8 281 126)
						)
						(Print 29 6) ; "The Ice Palace is even more beautiful and impressive up close than at a distance."
					)
					(
						(or
							(Said '/cone')
							(Said '//cone')
							(OnButton event 17 66 39 107)
							(OnButton event 155 67 184 104)
						)
						(Print 29 7) ; "I would say the two small pyramids of ice are purely decorative."
					)
				)
			)
			((Said 'open/door')
				(cond
					((gEgo inRect: 45 115 115 125)
						(Print 29 8) ; "This door cannot be opened."
					)
					((not (gEgo inRect: 95 115 150 125))
						(NotClose) ; "Perhaps you should move closer."
					)
					((IsFlag 65)
						(Print 29 9) ; "It does not open. Indeed, there was no reason for you to have returned at all."
					)
					(else
						(door setScript: OpenDoor)
					)
				)
			)
			((Said 'knock[/door]')
				(cond
					((gEgo inRect: 45 115 115 125)
						(Print 29 10) ; "Try the other door."
					)
					((not (gEgo inRect: 95 115 150 125))
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(Print 29 11) ; "Your arms do not reach that far."
					)
				)
			)
			((Said 'close/door')
				(Print 29 12) ; "It is already closed."
			)
		)
	)
)

(instance OpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gRegMusic stop:)
				(gSFX stop: number: (proc0_20 52) loop: 1 play:)
				(= cycles 3)
			)
			(1
				(door cycleSpeed: 3 setCycle: End self)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 120 117
				)
			)
			(2
				(gSFX stop:)
				(gEgo setMotion: MoveTo 120 114 self)
			)
			(3
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance CloseDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX stop: number: (proc0_20 52) loop: 1 play:)
				(door cycleSpeed: 2 setCel: 2 setCycle: Beg self)
			)
			(1
				(door setScript: 0 stopUpd:)
				(gSFX number: (proc0_20 54) loop: 1 play:)
			)
		)
	)
)

