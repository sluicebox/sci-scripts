;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Motion)

(public
	Rm24 0
)

(local
	local0
	local1
	local2
	local3
)

(instance Rm24 of eRoom
	(properties
		picture 24
		style 8
	)

	(method (init)
		(super init:)
		(= local1 (if (< (gEgo y:) 110) 90 else 140))
		(= local0 (if (< (gEgo y:) 110) 100 else 130))
		(self setRegions: 106) ; otMoor
		(if (or (== global116 1) (and (== global116 2) (== global115 gCurRoomNum)))
			(self setRegions: 113) ; horseReg
		)
		(HandsOn)
		(switch gPrevRoomNum
			(25
				(gEgo loop: 1)
				(self enterRoom: 320 local0 260 local0)
				(if (IsFlag 20)
					(gMuleObj loop: 1)
					(self muleEnterRoom: 320 local1 310 local1)
				)
			)
			(else
				(gEgo loop: 0)
				(self enterRoom: -10 125 30 125)
				(if (IsFlag 20)
					(gMuleObj loop: 0)
					(self muleEnterRoom: -15 135 10 135)
				)
			)
		)
		(proc0_13 33)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((& (gEgo onControl:) $4000)
				(if (and (== global116 1) (not local2))
					(= local2 1)
					(Print 24 0) ; "Your horse does not want to go in that direction. It must not trust what lies beneath the snow."
				)
				(if (and (not (== global116 1)) (not local3))
					(= local3 1)
					(Print 24 1) ; "The snow is too deep to go that way."
				)
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 6))
			)
			((> (gEgo x:) 310)
				(self leaveRoom: 25 320 (gEgo y:))
			)
			((< (gEgo x:) 10)
				(if
					(and
						(== global116 2)
						(or (== global115 24) (== global115 25))
					)
					(Print 24 2) ; "You will find the trip even longer and more tiring without your horse, Arthur."
					(gEgo posn: 10 (gEgo y:) setMotion: 0)
				else
					(self leaveRoom: 103 -20 (gEgo y:))
				)
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
			((or (Said 'look<across/lake,moor') (OnButton event 112 7 172 38))
				(Print 24 3 #icon 502 0 0) ; "It is a glittering palace of ice, rising from the center of the lake."
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(if
					(or
						(Said 'look[<at,around][/!*][/!*]')
						(Said 'look/room[/!*]')
						(Said '<around')
						(Said '/moor,ot,lake')
						(Said '//moor,ot,lake')
					)
					(if (not (IsFlag 65))
						(Print 24 4) ; "You have nearly reached the edge of the lake called Ot Moor. Through a gap in the bushes, you can catch a glimpse of a palace in the middle of the lake."
					else
						(Print 24 5) ; "Already, there is a touch of warmth returning to this area, but it will take some time for the ice and snow to melt."
					)
				)
			)
			((Said 'climb/mesa,ice')
				(Print 24 6) ; "That would not be safe in all your heavy gear."
			)
		)
	)
)

