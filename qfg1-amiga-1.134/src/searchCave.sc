;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Main)
(use rm15)
(use Avoid)
(use Motion)

(public
	searchCave 0
)

(instance searchCave of KScript
	(properties)

	(method (dispose)
		(gEgo setAvoider: 0 setMotion: 0)
		(proc15_1 1)
		(super dispose:)
		(DisposeScript 985)
		(DisposeScript 982)
		(DisposeScript 112)
	)

	(method (doit)
		(if (IsFlag 153)
			(self dispose:)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid)
				(if (< (gEgo x:) 160)
					(= register 0)
					(gEgo setMotion: MoveTo 37 128 self)
				else
					(= register 1)
					(gEgo setMotion: MoveTo 302 158 self)
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(if register
					(gEgo setMotion: MoveTo 37 128 self)
				else
					(gEgo setMotion: MoveTo 302 158 self)
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(gEgo setMotion: MoveTo 132 163 self)
			)
			(5
				(= seconds 2)
			)
			(6
				(proc15_1 1)
				(self dispose:)
			)
		)
	)
)

