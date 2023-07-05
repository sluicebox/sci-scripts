;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	envisionScript 0
)

(local
	local0
	local1
)

(instance envisionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW global128)
				(Load rsVIEW 153)
				(= cycles 1)
			)
			(1
				(gSfx number: 591 play:)
				(= global131 (proc0_13 30 global131 225))
				(= global132 (proc0_13 30 global132 100))
				((= local0 (Prop new:))
					view: 153
					init:
					setLoop: 0 1
					cel: 0
					posn: global131 global132
					setPri: 254
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(local0 setLoop: 1 1 cycleSpeed: 6 setCycle: Fwd)
				((= local1 (Prop new:))
					view: global128
					init:
					setLoop: 0 1
					cel: 0
					posn: (local0 x:) (+ (local0 y:) 10)
					setPri: 255
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(3
				(Timer setReal: self 5)
			)
			(4
				(local1 setCycle: Beg self)
			)
			(5
				(local0 setLoop: 0 1 cel: (local0 lastCel:) setCycle: Beg self)
			)
			(6
				(local1 dispose:)
				(local0 dispose:)
				(self dispose:)
			)
		)
	)
)

