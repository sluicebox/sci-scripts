;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)

(public
	Rm48 0
)

(local
	local0
)

(instance Rm48 of eRoom
	(properties
		picture 48
	)

	(method (init)
		(self
			style:
				(switch global103
					(0 100)
					(1 15)
					(2 17)
				)
		)
		(super init:)
		(proc0_13 65)
		(gAddToPics doit:)
		(self setRegions: 107) ; Gaza
		(gEgo init:)
		(switch gPrevRoomNum
			(46
				(self enterRoom: -10 140 30 140)
				(if (IsFlag 20)
					(gMuleObj loop: 0)
					(self muleEnterRoom: -10 130 25 130)
				)
			)
			(84
				(self enterRoom: 160 -5 160 60)
				(if (IsFlag 20)
					(gMuleObj loop: 2)
					(self muleEnterRoom: 210 0 210 75)
				)
			)
			(else
				(self enterRoom: 170 235 170 182)
				(if (IsFlag 20)
					(gMuleObj loop: 3)
					(self muleEnterRoom: 200 220 200 188)
				)
			)
		)
		(if (== global189 9)
			((ScriptID 130 0) ; Jabir
				view: 399
				setLoop: 1
				setCel: 5
				setStep: 2 1
				illegalBits: 0
				posn: 325 130
				init:
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((< (gEgo x:) 10)
					(self leaveRoom: 46 -10 (gEgo y:))
				)
				((> (gEgo y:) 185)
					(self leaveRoom: 39 (gEgo x:) 235)
				)
				((< (gEgo y:) 45)
					(self leaveRoom: 84 (gEgo x:) -5)
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
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/desert,gaza,terrain,cliff,mesa')
							(Said '//desert,gaza,terrain,cliff,mesa')
							(OnButton event 0 0 71 81)
							(OnButton event 223 12 296 48)
							(OnButton event 261 48 312 70)
							(OnButton event 292 70 312 104)
							(OnButton event 286 119 312 170)
						)
						(Print 48 0) ; "The cliffs reduce to a few boulders as the desert opens up to a trackless expanse."
					)
					(
						(or
							(OnButton event 45 77 70 85)
							(OnButton event 95 36 109 43)
							(OnButton event 245 84 263 96)
							(OnButton event 246 135 272 148)
						)
						(proc107_2)
					)
				)
			)
		)
	)
)

