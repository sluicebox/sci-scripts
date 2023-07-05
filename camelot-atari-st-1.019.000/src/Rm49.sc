;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)
(use System)

(public
	Rm49 0
)

(local
	local0
)

(procedure (localproc_0 param1)
	(Print 49 0 #at -1 param1) ; "As you approach Jerusalem bear in mind that you are one lone foreigner surrounded by dangerous and hostile natives."
)

(instance Rm49 of eRoom
	(properties
		picture 49
	)

	(method (dispose)
		(= global204 0)
		(super dispose:)
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
			(51
				(self enterRoom: 180 65 180 90)
				(if (IsFlag 20)
					(self muleEnterRoom: 150 70 150 100 2)
				)
			)
			(else
				(self enterRoom: 175 235 175 182)
				(if (IsFlag 20)
					(self muleEnterRoom: 205 220 205 175 3)
				)
			)
		)
		(if (== global189 9)
			((ScriptID 130 0) ; Jabir
				view: 399
				setLoop: 0
				setCel: 5
				setStep: 1 1
				illegalBits: 0
				posn: 58 175
				init:
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				(
					(and
						(not (IsFlag 84))
						(not (<= global204 20))
						(== gPrevRoomNum 40)
						(not (IsFlag 106))
					)
					(= global204 20)
				)
				((> (gEgo y:) 185)
					(self leaveRoom: 40 (gEgo x:) 235)
				)
				((< (gEgo y:) 70)
					(if (not (IsFlag 114))
						(SetFlag 114)
						(localproc_0 110)
					)
					(ClearFlag 84)
					(ClearFlag 98)
					(if global124
						(= global124 0)
						(self setScript: putItAway)
					else
						(self leaveRoom: 51 (gEgo x:) 65)
					)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(cond
			((Said 'get,find/water')
				(Print 49 1) ; "You may, if you wish to return to the Pool of Siloam."
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(if (> (gEgo y:) 130)
					(= temp0 20)
				else
					(= temp0 110)
				)
				(localproc_0 temp0)
			)
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
							(Said '/desert,gaza,terrain,pass,mesa,cliff')
							(Said '//desert,gaza,terrain,pass,mesa,cliff')
							(OnButton event 0 0 125 119)
						)
						(cond
							((not (IsFlag 105))
								(SetFlag 105)
								(Print 49 2) ; "At last, after your arduous journey the walls of Jerusalem rise before you. At this corner you can see the golden mosque called the Dome of the Rock."
							)
							((IsFlag 106)
								(Print 49 3) ; "Once more you approach the walls of Jerusalem."
							)
							(else
								(Print 49 4) ; "This pass brings you to the hill where Jerusalem is built."
							)
						)
					)
					(
						(or
							(Said '/dome,mosque')
							(Said '//dome,mosque')
							(OnButton event 190 6 218 19)
						)
						(Print 49 5) ; "The golden Dome of the Rock is one of the holiest mosques in Islam. It houses a rock from which the Muslims believe that Mohammed ascended to Heaven."
					)
					(
						(or
							(Said '/tower,minaret')
							(Said '//tower,minaret')
							(OnButton event 154 5 164 31)
						)
						(Print 49 6) ; "I know nothing about it. Perhaps it is a tower from which the muslims are called to prayer."
					)
					(
						(or
							(Said '/jerusalem,wall')
							(Said '//jerusalem,wall')
							(OnButton event 146 18 265 38)
						)
						(Print 49 7) ; "Since you can see the golden mosque, that must be the southeastern corner of Jerusalem."
					)
					((or (Said '/gate,entrance') (Said '//gate,entrance'))
						(if (or (IsFlag 109) (== gPrevRoomNum 51))
							(Print 49 8) ; "As you know, this pass becomes a road which leads you inevitably to the Zion Gate."
						else
							(Print 49 9) ; "There are a number of gates. It depends on where this pass will lead."
						)
					)
					(
						(or
							(Said
								'/mercenary,guard,gatekeeper,keep,thug,bandit'
							)
							(Said
								'//mercenary,guard,gatekeeper,keep,thug,bandit'
							)
						)
						(if (IsFlag 109)
							(Print 49 10) ; "Let us hope that the mercenaries at the Zion Gate are better disposed toward you this time."
						else
							(Print 49 11) ; "In addition to Saracens and city soldiers, you may encounter some mercenaries acting as guards."
						)
					)
					(
						(or
							(Said '/plant,aloe')
							(Said '//plant,aloe')
							(OnButton event 248 120 274 137)
							(OnButton event 270 134 309 180)
						)
						(Print 49 12) ; "There are some aloe vera plants around."
					)
					(
						(or
							(OnButton event 0 107 108 189)
							(OnButton event 241 75 283 88)
							(OnButton event 223 124 241 130)
							(OnButton event 247 111 262 129)
							(OnButton event 283 119 308 141)
						)
						(proc107_2)
					)
				)
			)
		)
	)
)

(instance putItAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global125 2)
				(= cycles 8)
			)
			(1
				(gCurRoom leaveRoom: 51 (gEgo x:) 65)
			)
		)
	)
)

