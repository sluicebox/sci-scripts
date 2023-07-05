;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)

(public
	Rm53 0
)

(instance Rm53 of eRoom
	(properties
		picture 53
		style 0
	)

	(method (init)
		(super init:)
		(gEgo view: 0 init:)
		(self setRegions: 123) ; wallRegion
		(= global112 3)
		(switch gPrevRoomNum
			(54
				(self enterRoom: -10 155 35 155)
				(if (IsFlag 20)
					(gMuleObj loop: 0)
					(self muleEnterRoom: -15 145 34 145)
				)
			)
			(else
				(self enterRoom: 320 155 285 155)
				(if (IsFlag 20)
					(gMuleObj loop: 1)
					(self muleEnterRoom: 320 145 290 145)
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
				((< (gEgo x:) 10)
					(self leaveRoom: 54 -10 (gEgo y:))
				)
				((> (gEgo x:) 310)
					(self leaveRoom: 52 320 (gEgo y:))
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
			(
				(or
					(OnButton event 8 107 58 138)
					(OnButton event 59 118 310 138)
				)
				(Print 53 0) ; "Aye, they are rocks. There is a lot of rock in this country."
			)
			((OnButton event 6 6 310 116)
				(Print 53 1) ; "The walls of Jerusalem are made of huge blocks of a buff-colored stone."
			)
			((OnButton event 227 142 299 183)
				(Print 53 2) ; "These spiny plants are Aloe Vera."
			)
			(
				(or
					(Said 'look<down')
					(and
						(OnButton event 8 162 310 183)
						(not (OnButton event 45 126 118 183))
					)
				)
				(Print 53 3) ; "It is a long way to the bottom of the hill!"
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
							(Said '/north,jaffa')
							(Said '//north,jaffa')
						)
						(if global202
							(Print 53 4) ; "To the north is the Jaffa Gate."
						else
							(Print 53 5) ; "There is something ahead that may be the Jaffa Gate."
						)
					)
					((or (Said '/south') (Said '//south'))
						(Print 53 6) ; "To the south is the southwest corner of the walls of Jerusalem."
					)
					(
						(or
							(Said '/bush,tree')
							(Said '//bush,tree')
							(OnButton event 45 126 118 183)
						)
						(Print 53 7) ; "Aye, 'tis a scrubby tree of no great interest."
					)
				)
			)
		)
	)
)

