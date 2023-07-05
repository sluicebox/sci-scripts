;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 394)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	getUpScript 0
)

(instance getUpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 325 loop: 0 setCel: 16 setCycle: Beg self)
			)
			(1
				((ScriptID 25 4) init:) ; controlPanelChair
				(gEgo posn: 187 80 view: 232 cel: 3 heading: 225 loop: 6)
				((gEgo looper:) doit: gEgo 225 self)
			)
			(2
				(gEgo loop: 5 setCycle: Walk setMotion: MoveTo 180 98 self)
			)
			(3
				(self dispose:)
				(HandsOn)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 394)
	)
)

