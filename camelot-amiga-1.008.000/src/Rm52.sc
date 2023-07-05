;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)

(public
	Rm52 0
)

(instance Rm52 of eRoom
	(properties
		picture 52
		style 0
	)

	(method (init)
		(super init:)
		(gEgo view: 0 init:)
		(self setRegions: 123) ; wallRegion
		(switch gPrevRoomNum
			(53
				(self enterRoom: 55 120 55 135)
				(if (IsFlag 20)
					(gMuleObj loop: 2)
					(self muleEnterRoom: 85 115 85 133)
				)
			)
			(else
				(self enterRoom: 320 170 285 170)
				(if (IsFlag 20)
					(gMuleObj loop: 1)
					(self muleEnterRoom: 320 160 290 160)
				)
			)
		)
		(if (== gCurRoomNum global206)
			(SetFlag 20)
			(= global206 0)
			(gMuleObj loop: 0 posn: 160 150)
		)
		(proc0_13 81)
		(gAddToPics doit:)
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((> (gEgo x:) 310)
					(self leaveRoom: 51 325 (gEgo y:))
				)
				((< (gEgo y:) 125)
					(self leaveRoom: 53 (gEgo x:) 121)
				)
			)
		)
		(super doit:)
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
			((OnButton event 6 6 127 144)
				(Print 52 0) ; "The walls of Jerusalem continue on as far as you can see."
			)
			(
				(or
					(OnButton event 192 131 262 149)
					(OnButton event 29 147 220 182)
				)
				(Print 52 1) ; "These spiny plants are Aloe Vera."
			)
			(
				(or
					(Said 'look<down')
					(and
						(or
							(OnButton event 6 145 54 189)
							(OnButton event 192 131 262 149)
						)
						(not (OnButton event 192 131 262 149))
					)
				)
				(Print 52 2) ; "It is a long way to the bottom of the hill."
			)
			((OnButton event 128 133 310 150)
				(Print 52 3) ; "Aye, they are rocks. There is a lot of rock in this country."
			)
			(
				(and
					(OnButton event 128 7 310 132)
					(not (OnButton event 250 34 272 55))
				)
				(Print 52 4) ; "The walls of Jerusalem are made of huge blocks of a buff-colored stone."
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
					(Said 'get/clue>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
						)
						(if (and (< (gEgo x:) 145) (not global202))
							(Print 52 5) ; "You have reached one corner of the walls of Jerusalem. The mercenaries back at the Zion Gate watch you warily."
						else
							(Print 52 6) ; "Another stretch of ancient wall awaits you."
						)
					)
					(
						(or
							(OnButton event 250 34 272 55)
							(Said '/disc,circle,bump')
							(Said '//disc,circle,bump')
						)
						(Print 52 7) ; "The discs seem to be a part of the walls, but I cannot say what their purpose may be."
					)
				)
			)
		)
	)
)

