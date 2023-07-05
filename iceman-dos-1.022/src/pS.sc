;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 358)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use Avoid)
(use Motion)
(use System)

(public
	pS 0
)

(instance pS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DisposeScript 371)
				(DisposeScript 971)
				(DisposeScript 956)
				(client
					setAvoider: Avoid
					ignoreActors: 1
					view: 211
					setLoop: (if register 3 else 4)
					setCycle: Walk
					setMotion: MoveTo 146 126 self
				)
				(HandsOff)
			)
			(1
				(client setLoop: 3 ignoreActors: 0)
				(gEgo setMotion: MoveTo 183 126 self setAvoider: Avoid)
				(Print 612 (Random 0 1))
			)
			(2
				(Print 612 (Random 2 5))
				(gEgo setLoop: 1 setAvoider: 0)
				(client
					setAvoider: 0
					cycleSpeed: 2
					setLoop: 5
					setAvoider: Avoid
					setCycle: End self
				)
				(DisposeScript 985)
			)
			(3
				((gEgo looper:) dispose:)
				(DisposeScript 977)
				(client setLoop: 6 setCycle: End self)
				(gEgo view: 211 setLoop: 7 setCycle: End self)
			)
			(4 0)
			(5
				(EgoDead 907 0 0 358 0) ; "What a punch! Don't be a wimp, play again!"
				(client posn: 20 110 setScript: 0)
			)
		)
	)
)

