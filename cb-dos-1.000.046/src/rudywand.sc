;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 281)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rudywand 0
)

(synonyms
	(rudolph person man)
)

(local
	[local0 18] = [65 129 242 187 197 172 233 134 189 138 80 138 100 143 136 177 135 163]
	[local18 18] = [0 0 340 187 340 170 304 97 159 113 -20 138 -20 143 66 240 118 240]
	[local36 18] = [-20 62 -20 187 104 240 156 240 340 139 340 130 193 143 340 173 340 140]
	[local54 9] = [22 21 27 26 25 13 9 3 10]
	local63
	local64
	local65
	[local66 5]
)

(instance rudywand of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (and (== gAct 3) (not (& gMustDos $0001)))
			(Load rsFONT 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
			(Load rsVIEW 642)
		)
		(if (== gAct 3)
			(LoadMany rsMESSAGE 243 296)
			(= [global377 8] 296)
			(Load rsVIEW 908)
			(if (== [gCycleTimers 1] 0)
				(= [gCycleTimers 1] 800)
				(= global114 0)
			)
		else
			(if (< [gCycleTimers 1] 2)
				(= [gCycleTimers 1] 800)
				(= global114 0)
			)
			(= [local54 0] 14)
			(= [local36 14] 41)
			(= [local36 15] 113)
		)
		(Rudy view: 380 loop: 1 illegalBits: -32768 ignoreHorizon: 1)
		(if
			(and
				(== [local54 (- 8 global114)] gCurRoomNum)
				(>= [gCycleTimers 1] (* (- 8 global114) 100))
			)
			(= global180 gCurRoomNum)
			(|= global208 $0100)
			(= [gCycleTimers 1] (- 899 (* global114 100)))
			(= local63 1)
			(Rudy
				setCycle: Walk
				setAvoider: ((Avoid new:) offScreenOK: 1)
				posn: [local0 (* global114 2)] [local0 (+ (* global114 2) 1)]
				init:
			)
			(if (== gCurRoomNum 27)
				(Rudy setMotion: MoveTo 193 143 self)
			else
				(Rudy
					setMotion:
						MoveTo
						[local36 (* global114 2)]
						[local36 (+ (* global114 2) 1)]
				)
			)
			(self setScript: rudyActions)
		)
	)

	(method (doit)
		(if
			(and
				(== (mod [gCycleTimers 1] 100) 0)
				(== [local54 (/ [gCycleTimers 1] 100)] gCurRoomNum)
				(not local63)
			)
			(if (User controls:)
				(|= global208 $0100)
				(= global114 (- 8 (/ [gCycleTimers 1] 100)))
				(= global180 gCurRoomNum)
				(= local63 1)
				(Rudy
					setCycle: Walk
					setAvoider: ((Avoid new:) offScreenOK: 1)
					posn:
						[local18 (* global114 2)]
						[local18 (+ (* global114 2) 1)]
					init:
				)
				(if (== gCurRoomNum 27)
					(Rudy setMotion: MoveTo 193 143 self)
				else
					(Rudy
						setMotion:
							MoveTo
							[local36 (* global114 2)]
							[local36 (+ (* global114 2) 1)]
					)
				)
				(self setScript: rudyActions)
			else
				(+= [gCycleTimers 0] 10)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if local63
			(= [gCycleTimers 1] (- 720 (* global114 100)))
		)
		(= global180 0)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if
			(and
				global208
				(Said 'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>')
			)
			(Rudy setScript: (ScriptID 243 0)) ; atsgl
			((Rudy script:) handleEvent: event)
			(if (event claimed:)
				(return)
			)
		)
	)
)

(instance rudyActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== gPrevRoomNum 31)
						(or (!= (gEgo x:) 118) (!= (gEgo y:) 144))
					)
					(= state -1)
				)
				(= cycles 1)
			)
			(1
				(cond
					((not global216)
						(= state 0)
					)
					((and (== gAct 3) (not (& gMustDos $0001)))
						(if (and (== gMinute 3) (== gCurRoomNum 10))
							(global373 startUpd:)
						)
						(|= gMustDos $0001)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state 0)
					)
					((self script:)
						(= state 0)
					)
				)
				(= cycles 1)
			)
			(2
				(if (== gCurRoomNum 10)
					(global373 stopUpd:)
				)
				(if
					(and
						(== (Rudy x:) [local36 (* global114 2)])
						(== (Rudy y:) [local36 (+ (* global114 2) 1)])
					)
					(if (== gCurRoomNum 27)
						(= state 3)
					)
				else
					(= state 1)
				)
				(= cycles 1)
			)
			(3
				(++ global114)
				(= [gCycleTimers 1] (- 899 (* global114 100)))
				(if (and (== gAct 6) (< [gCycleTimers 1] 2))
					(= [gCycleTimers 1] 900)
					(= global114 0)
				)
				(if (and (== gCurRoomNum 21) (== gAct 3))
					(Rudy dispose:)
				else
					(Rudy setAvoider: 0 hide:)
				)
				(= global180 0)
				(DisposeScript 985)
				(&= global208 $feff)
				(= [global377 8] 0)
				(= local63 0)
				(client setScript: 0)
			)
			(4
				(= state 2)
				(Rudy setMotion: MoveTo 110 110 self)
			)
		)
	)
)

(instance Rudy of Act
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if local63
			(if (== gAct 6)
				(cond
					((Said 'ask,tell')
						(= global213 9)
						(if (not local65)
							(= global213 9)
							(++ local65)
							(Say 1 281 0) ; "I'm not in the mood to gab!"
						else
							(Say 1 281 1) ; "Get out of here!"
						)
					)
					((Said 'give,show')
						(Print 281 2) ; "Rudy doesn't even acknowledge it. He's got too many other things on his mind."
					)
				)
			)
			(cond
				((and (not (& global207 $0100)) (MousedOn self event 3))
					(event claimed: 1)
					(DoLook {rudy})
				)
				(
					(and
						(& global207 $0100)
						(or (MousedOn self event 3) (Said 'look/rudolph'))
					)
					(event claimed: 1)
					(Print 281 3) ; "You see Rudy walking distractedly around the estate. He seems very agitated."
				)
				((Said 'talk/rudolph>')
					(= global213 9)
					(switch local64
						(0
							(Say 1 281 4) ; "Somethin's wrong; I can feel it. I don't understand what's goin' on around here. Where is everybody?!"
							(= global213 12)
							(Say 1 281 5) ; "You try to warn him but he doesn't seem to be paying any attention to you."
						)
						(1
							(Say 1 281 6) ; "Go on. Leave me alone. I've got some searchin' to do."
						)
						(2
							(Say 1 281 7) ; "Get out of here...NOW!"
						)
						(else
							(Print 281 8) ; "Rudy refuses to talk to you anymore. He's too preoccupied by other thoughts."
						)
					)
					(++ local64)
					(event claimed: 1)
				)
			)
		)
	)
)

