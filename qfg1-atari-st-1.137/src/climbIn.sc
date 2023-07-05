;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	climbIn 0
	intro54 1
	rockHitsIt 2
	youMissed 3
)

(instance climbIn of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 235)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 277)
				(gEgo
					setLoop: 2
					setPri: 4
					posn: 130 100
					setMotion: MoveTo 130 87 self
				)
			)
			(1
				(gEgo setLoop: -1 setPri: -1 setMotion: MoveTo 130 100 self)
			)
			(2
				(HandsOn)
				(ClearFlag 277)
				(NormalEgo)
				(client setScript: 0)
			)
		)
	)
)

(instance intro54 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 235)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(HighPrint 235 0) ; "The bright smell of fresh herbs mingles with the aroma of wood smoke as you near a hut by the side of the road."
				(client setScript: 0)
			)
		)
	)
)

(instance rockHitsIt of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 235)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 54 1) ; rock
					setMotion:
						MoveTo
						((ScriptID 54 2) x:) ; nest
						((ScriptID 54 2) y:) ; nest
						self
				)
			)
			(1
				((ScriptID 54 1) ; rock
					setMotion: MoveTo -10 (- ((ScriptID 54 2) y:) 40) self ; nest
				)
				((ScriptID 54 2) setScript: (ScriptID 54 4)) ; nest, nestDown
			)
			(2
				((ScriptID 54 1) dispose:) ; rock
			)
		)
	)
)

(instance youMissed of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 235)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 54 1) ; rock
					setMotion:
						MoveTo
						((ScriptID 54 2) x:) ; nest
						((ScriptID 54 2) y:) ; nest
						self
				)
			)
			(1
				((ScriptID 54 1) ; rock
					setMotion: MoveTo -10 (- ((ScriptID 54 1) y:) 40) self ; rock
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

