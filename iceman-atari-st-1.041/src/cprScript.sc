;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 354)
(include sci.sh)
(use Main)
(use volleyRm)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	cprScript 0
)

(procedure (localproc_0)
	(gGame changeScore: 1)
)

(instance Doctor of Act ; UNUSED
	(properties
		y 124
		x 330
		view 303
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/doc,man]>')
				(cond
					((Said 'look[<at]')
						(proc3_7 354 0) ; "The doctor looks very professional."
					)
					((Said 'talk')
						(proc3_7 354 1) ; "He's too busy to chat."
					)
					((Said 'thank')
						(proc3_7 354 2) ; "He replies, "You're welcome.""
					)
				)
			)
		)
	)
)

(instance egoRescueViewer of Code
	(properties)

	(method (doit)
		(gEgo
			view: 403
			setLoop: -1
			loop:
				(switch (gEgo onControl: 1)
					(512 8)
					(1024 7)
					(2048 6)
					(4096 5)
					(else
						(if (>= (gEgo y:) 200) 8 else 4)
					)
				)
		)
	)
)

(instance cprScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 354)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc3_7 354 3) ; "You reach the drowning girl and find her unconscious."
				((gEgo looper:) dispose:)
				(gEgo
					setAvoider: 0
					posn: 239 240
					view: 403
					viewer: 0
					setLoop: 8
					setCycle: Fwd
					setMotion: MoveTo 239 170 self
				)
				(proc3_7 354 4) ; "Grabbing her, you swim back to the beach."
			)
			(1
				(gEgo
					setCycle: Walk
					setMotion: MoveTo 239 122 self
					viewer: (egoRescueViewer doit: yourself:)
				)
			)
			(2
				(gEgo
					viewer: 0
					view: 403
					setLoop: 3
					heading: 180
					setMotion: 0
				)
				((ScriptID 3 1) heading: 270 loop: 1 cel: 0) ; Man
				((ScriptID 3 6) heading: 270 loop: 0 cel: 5) ; Girl2
				(= cycles 2)
			)
			(3
				(proc3_7 354 5) ; "You quickly position the woman flat on her back with her head slightly below her heart."
				(gEgo setLoop: 2 setCel: 0 setCycle: Beg)
				(User canInput: 1)
			)
			(4
				(User canInput: 0)
				(proc3_7 354 6) ; "After gently shaking the victim, you try getting a response by saying, "Are you ok?""
				(gEgo setLoop: 9 setCel: 0 setCycle: Fwd)
				(localproc_0)
				(= seconds 2)
			)
			(5
				(gEgo setCycle: Beg)
				(User canInput: 1)
			)
			(6
				(User canInput: 0)
				(proc3_7 354 7) ; "Turning to the others, you shout... "Please! Someone go for emergency medical aid!""
				((ScriptID 3 1) ; Man
					view: 603
					xStep: 6
					setCycle: Walk
					setMotion: MoveTo 340 100
				)
				(proc3_7 354 8) ; "Excitedly the man says, "I'll take care of that right now!""
				(localproc_0)
				(User canInput: 1)
			)
			(7
				(proc3_7 354 9) ; "Quickly you tilt her head back and open her mouth."
				(proc3_7 354 10) ; "Sweeping the open mouth with your finger, you make sure nothing is blocking her airway."
				(localproc_0)
			)
			(8
				(proc3_7 354 11) ; "You place your ear close to the victim's mouth and try to listen and feel for a breath. At the same time you look to see if the chest is moving."
				(localproc_0)
			)
			(9
				(gEgo setLoop: 0 setCel: 2 setCycle: End self)
				(proc3_7 354 12) ; "You pinch the nostrils closed, open your mouth wide and take a deep breath. You make a tight seal over the victim's mouth and breathe into her mouth."
			)
			(10
				(gEgo setCycle: Beg)
				(proc3_7 354 13) ; "You take another deep breath and breathe into her mouth again, watching her chest rise."
				(localproc_0)
			)
			(11
				(User canInput: 0)
				(gEgo setLoop: 0 setCel: 0 setCycle: CT 3 1)
				(= seconds 2)
			)
			(12
				(proc3_7 354 14) ; "After giving the victim two ventilations, you look, listen and feel again. However, you still can't get a response."
				(gEgo setCycle: Beg)
				(localproc_0)
				(User canInput: 1)
			)
			(13
				(User canInput: 0)
				(gEgo setLoop: 0 setCel: 0 setCycle: CT 2 1)
				(= seconds 3)
			)
			(14
				(proc3_7 354 15) ; "You check the carotid artery for five to ten seconds trying to find a pulse. Unfortunately, you don't!"
				(gEgo setCycle: Beg)
				(localproc_0)
				(User canInput: 1)
			)
			(15
				(User canInput: 0)
				(= cycles 10)
			)
			(16
				(localproc_0)
				((ScriptID 3 1) dispose:) ; Man
				(gCurRoom notify: 2)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(cond
			((super handleEvent: event))
			(
				(switch state
					(3
						(or
							(and (Said 'shake>') (Said 'yell'))
							(Said 'shake//yell')
							(Said 'shake<yell')
						)
					)
					(5
						(Said 'call[/help][/help]')
					)
					(6
						(Said 'open,clear,establish/airway,neck')
					)
					(7
						(if
							(or
								(and
									(Said 'look>')
									(Said 'listen>')
									(Said 'feel>')
								)
								(Said 'look//feel<listen>')
							)
							(Said '[/breath,victim,woman]')
						)
					)
					(8
						(or (Said 'give/breath<2') (Said 'give/breath<good/2'))
					)
					(10
						(Said 'look,listen,feel[/breath,victim,woman]')
					)
					(12
						(Said 'check[/pulse][/pulse]')
					)
					(14
						(or (Said 'start/compression') (Said 'start/cpr'))
					)
					(else
						(= temp0 1)
					)
				)
				(if (not temp0)
					(self cue:)
				)
			)
			(else
				(proc3_7 354 16) ; "You will find the correct rescue procedure listed in the game documentation."
				(event claimed: 1)
			)
		)
	)
)

