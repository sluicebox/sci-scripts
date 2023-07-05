;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)
(use Motion)

(public
	Rm46 0
)

(local
	local0
	local1
	local2
)

(instance Rm46 of eRoom
	(properties
		picture 46
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
		(if (IsFlag 20)
			(= local1 1)
		)
		(gEgo init:)
		(switch gPrevRoomNum
			(47
				(gRegMusic play:)
				(self enterRoom: 240 -5 240 60)
				(if (== global206 gCurRoomNum)
					(SetFlag 20)
					(= local1 1)
					(= local2 1)
				)
			)
			(48
				(self enterRoom: 320 135 290 135)
				(if local1
					(self muleEnterRoom: 320 145 285 135)
				)
			)
			(else
				(self enterRoom: 230 235 230 182)
				(if local1
					(self muleEnterRoom: 260 230 260 175)
				)
			)
		)
		(if (== gCurRoomNum global206)
			(= global206 0)
			(self setRegions: 116) ; muleReg
			(gMuleObj loop: 0 posn: 135 90 setScript: (ScriptID 107 1)) ; muleFollow
		)
		(if (== global189 9)
			((ScriptID 130 0) ; Jabir
				view: 399
				setLoop: 0
				setCel: 5
				setStep: 2 1
				illegalBits: 0
				posn: 38 87
				init:
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				(local2
					(= local2 0)
					(if (not (IsFlag 119))
						(SetFlag 119)
						(Print 46 0 #at -1 110) ; "Ah, your mule lacked the energy to run far. She waited for you in the small relief offered by the shadow of the cliffs."
					)
				)
				((> (gEgo x:) 310)
					(self leaveRoom: 48 320 (gEgo y:))
				)
				((> (gEgo y:) 185)
					(self leaveRoom: 38 (gEgo x:) 235)
				)
				((and (< (gEgo y:) 30) (> (gEgo x:) 185))
					(self leaveRoom: 47 (gEgo x:) -5)
					(if local1
						(= global206 gCurRoomNum)
						(if (IsFlag 118)
							(ClearFlag 20)
							(gMuleObj
								setMotion:
									MoveTo
									(gMuleObj x:)
									(+ (gMuleObj y:) 75)
							)
						)
					)
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
							(Said '/desert,gaza,terrain')
							(Said '//desert,gaza,terrain')
						)
						(Print 46 1) ; "Cliffs block your way upon one side and draw close to other cliffs ahead."
					)
					(
						(or
							(Said '/cliff,mesa,pass,canyon')
							(Said '//cliff,mesa,pass,canyon')
							(OnButton event 0 0 117 189)
							(OnButton event 117 0 170 36)
						)
						(Print 46 2) ; "The tall ridge of cliffs continues unbroken toward some kind of pass or valley ahead."
					)
					(
						(or
							(Said '/wall,ruin')
							(Said '//wall,ruin')
							(OnButton event 186 145 202 175)
						)
						(Print 46 3) ; "Aye, there is something sticking out of the ground that looks like the remains of a very ancient wall."
					)
					(
						(or
							(Said '/boulder')
							(Said '//boulder')
							(OnButton event 263 13 307 38)
							(OnButton event 64 48 107 65)
							(OnButton event 105 38 135 55)
							(OnButton event 111 71 134 80)
							(OnButton event 244 113 259 126)
							(OnButton event 279 112 289 122)
						)
						(proc107_2)
					)
					((or (Said '/adder') (Said '//adder'))
						(if (and local1 (IsFlag 118))
							(Print 46 4) ; "Your mule has no intention of getting close to a desert cobra."
						else
							(event claimed: 0)
						)
					)
					((or (Said '/ass') (Said '//ass'))
						(if (and local1 (IsFlag 118))
							(Print 46 5) ; "Your mule is ready to follow you anywhere except into the valley of the cobras."
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

