;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
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
				(DoAudio audPLAY 591)
				((= local0 (Prop new:))
					init:
					view: 153
					setLoop: 0
					setCel: 0
					posn: global131 global132
					setPri: 15
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(local0 setLoop: 1 cycleSpeed: 6 setCycle: Fwd)
				((= local1 (Prop new:))
					init:
					view: global128
					setLoop: 0
					setCel: 0
					posn: (local0 x:) (+ (local0 y:) 10)
					setPri: 15
					cycleSpeed: 0
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
				(local0 setLoop: 0 setCel: (local0 lastCel:) setCycle: Beg self)
			)
			(6
				(local1 dispose:)
				(local0 dispose:)
				(self dispose:)
			)
		)
	)
)

