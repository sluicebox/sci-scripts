;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room44 0
)

(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room44 of Rm
	(properties
		picture 44
	)

	(method (init)
		(= east 41)
		(= south 48)
		(= west 43)
		(= north 54)
		(= horizon 85)
		(= global591 0)
		(= global109 0)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(lightning view: 69 loop: 6 cel: 0 posn: 291 59 setScript: flash init:)
		(NormalEgo)
		(gEgo looper: 0)
		(switch gPrevRoomNum
			(48
				(NormalEgo)
				(= global104 0)
				(gEgo view: 0 posn: (gEgo x:) 188 setStep: 3 2)
			)
			(43
				(gEgo posn: 1 (gEgo y:))
			)
			(41
				(if (< (gEgo y:) (+ horizon 2))
					(gEgo posn: 318 (+ horizon 2))
				else
					(gEgo posn: 318 (gEgo y:))
				)
			)
			(54
				(gEgo view: 0 posn: (gEgo x:) (+ horizon 2) setStep: 3 2)
			)
			(else
				(gEgo view: 0)
			)
		)
		(gEgo init:)
		(self setRegions: 501) ; regDune
		(switch global110
			(1
				(if (== (Random 1 4) 3)
					(= global111 (Act new:))
					(global111 posn: 1000 1000 init:)
					(= global114 (Random 2 12))
				)
			)
			(2
				(= global111 (Act new:))
				(global111 posn: 1000 1000 init:)
				(= global114 3)
			)
		)
		(if (gCast contains: global111)
			(global111
				view: 106
				setCycle: Walk
				observeControl: 2
				posn: 1000 1000
				init:
			)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 130)
				)
				(west
					(global111 posn: -40 130)
				)
				(south
					(global111 posn: 160 249)
				)
				(north
					(global111 posn: 120 (+ horizon 2))
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1) ; regDune
		else
			((ScriptID 501 0) notify: 4) ; regDune
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(gCast contains: global111)
				(< (gEgo distanceTo: global111) 120)
			)
			(= global110 2)
		)
		(if (not gHandsOff)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						(
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(Print 44 0) ; "You see sand, mountains in the distance, and a sign."
						)
						((Said '/sign')
							(Print 44 1) ; "Yes, that's a sign."
						)
					)
				)
				((Said 'read/sign')
					(if (== (gEgo onControl: 1) 8192)
						(if (or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
							(Print 44 2) ; "Just Ahead! Visit the Mog Memorial and the galaxy famous World O' Wonders"
						else
							(Print 44 3) ; "Try facing in the right direction."
						)
					else
						(Print 44 4) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance flash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 8 30))
			)
			(1
				(lightning cel: 255 setCycle: End self)
			)
			(2
				(lightning cel: 0)
				(= seconds (Random 2 5))
			)
			(3
				(thunder priority: 2 number: (Random 31 32) play: self)
			)
			(4
				(= state -1)
			)
		)
	)
)

