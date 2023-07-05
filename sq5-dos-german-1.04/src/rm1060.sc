;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1060)
(include sci.sh)
(use Main)
(use ScaleTo)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1060 0
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 1)) (< temp0 30) ((++ temp0))
		((star new:) init:)
	)
	(star init:)
)

(instance rm1060 of Rm
	(properties
		picture 130
		style 10
	)

	(method (init)
		(localproc_0)
		(gGame handsOff:)
		(gSq5Music2 number: 101 loop: -1 play:)
		(ship init:)
		(super init:)
	)
)

(instance sSoundStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 203 setLoop: 1 play: self)
			)
			(1
				(gSq5Music1 number: 44 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sEurekaExplodes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 128)
				(self setScript: sSoundStuff)
				(ship dispose:)
				(= cycles 1)
			)
			(1
				(Palette palANIMATE 128 255 -1)
				(if (-- register)
					(-- state)
				)
				(= ticks 1)
			)
			(2
				(= seconds 5)
			)
			(3
				(gCurRoom newRoom: 1041)
				(self dispose:)
			)
		)
	)
)

(instance ship of Prop
	(properties
		x 138
		y 58
		view 717
	)

	(method (init)
		(self setScale: ScaleTo 15 10 self)
		(super init:)
	)

	(method (cue)
		(gSq5Music1 fade:)
		(gCurRoom setScript: sEurekaExplodes)
	)
)

(instance star of Actor
	(properties
		view 217
		priority 1
		signal 24592
		moveSpeed 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= temp0 (Random 100 250))
		(= temp1 (Random 0 359))
		(= temp2 (+ 140 (CosMult temp1 temp0)))
		(= temp3 (+ 58 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			x: temp2
			y: temp3
			setLoop: 1
			setCel: (Random 0 3)
			moveSpeed: 0
			setStep: 10 10
			setCycle: 0
			setPri: 4
			setMotion: MoveTo 140 58
		)
		(super init: &rest)
	)

	(method (doit)
		(if (self inRect: 120 38 160 78)
			(self setMotion: 0)
			(self init:)
		)
		(super doit: &rest)
	)
)

