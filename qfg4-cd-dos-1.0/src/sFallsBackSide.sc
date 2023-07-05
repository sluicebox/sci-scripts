;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 803)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use System)

(public
	sFallsBackSide 0
	sFallsStomach 1
	sSlippery 2
	sWalksDown 3
)

(local
	local0
	local1
)

(instance sFallsBackSide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local0 (gEgo cycleSpeed:))
				(gEgo setStep: 1 1 setMotion: PolyPath 73 80 self)
			)
			(1
				(gEgo
					view: 805
					setLoop: 0 1
					setCel: 0
					posn: 86 91
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(2
				(gEgo
					setLoop: 2 1
					setCel: 0
					posn: 107 106
					setCycle: 0
					setStep: 10 10
					setMotion: MoveTo 70 124 self
				)
			)
			(3
				(gEgo setLoop: 1 1 setCel: 1 posn: 45 (gEgo y:))
				(= ticks 6)
			)
			(4
				(gEgo
					setCel: 0
					posn: 55 130
					ignoreActors: 1
					setMotion: MoveTo 85 170 self
				)
			)
			(5
				(gEgo
					view: 40
					setLoop: 0 1
					setCel: 5
					posn: 102 165
					setCycle: Beg self
				)
			)
			(6
				(gEgo cycleSpeed: local0 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFallsStomach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local0 (gEgo cycleSpeed:))
				(gEgo setStep: 3 2 normalize:)
				(= ticks 6)
			)
			(1
				(gEgo
					view: 805
					setLoop: 3 1
					setCel: 0
					posn: 105 180
					setCycle: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gEgo cycleSpeed: local0 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSlippery of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: 0 setStep: 1 1)
				(self cue:)
			)
			(1
				(if local1
					(self cue:)
				else
					(gMessager say: 15 6 5 0 self) ; "The path is incredibly slippery; you can scarcely move on it without falling."
				)
			)
			(2
				(= local1 1)
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 15) self
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalksDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setStep: 3 2)
				(self cue:)
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

