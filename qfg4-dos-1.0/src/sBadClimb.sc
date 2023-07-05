;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 805)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	sBadClimb 0
)

(instance sBadClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 7
					posn: 242 144
					setLoop: 1 1
					cycleSpeed: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 0 1)
				(gEgo
					setCel: (gEgo lastCel:)
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(2
				(gMessager say: 5 33 5 0 self) ; "It's pretty slippery up there. You'll need to work on your climbing skill some more before you'll be able to make this kind of climb."
			)
			(3
				((ScriptID 809 2) posn: 230 130) ; pGrapnel
				(= ticks 6)
			)
			(4
				((ScriptID 809 2) posn: 230 138) ; pGrapnel
				(= ticks 6)
			)
			(5
				((ScriptID 809 2) hide: dispose:) ; pGrapnel
				(gEgo
					normalize:
					setPri: 152
					cycleSpeed: register
					setMotion: MoveTo 150 165 self
				)
			)
			(6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

