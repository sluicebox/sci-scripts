;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use Osc)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm215 0
)

(instance rm215 of Rm
	(properties
		picture 93
		style 10
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(super init: &rest)
		(gSq5Music1 number: 29 loop: -1 play:)
		(self setScript: sPukeOut)
	)
)

(instance sPukeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lights93 init:)
				(discLight93 init:)
				(greenLLight93 init:)
				(sitter93 init:)
				(crew293 init:)
				(crew393 init:)
				(crew493 init:)
				(greenOutline93 init:)
				(= seconds 2)
			)
			(1
				(= cycles 1)
			)
			(2
				(crew293 setCycle: End self)
			)
			(3
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 90 11)
				(crew90 init:)
				(= seconds 3)
				(redLight90 init:)
				(beatEA90 init:)
				(topGreen90 init: cel: 0 cycleSpeed: 18)
				(secondGreen90 init: cel: 1 cycleSpeed: 8)
				(thirdGreen90 init: cel: 2 cycleSpeed: 6)
				(fourthGreen90 init: cel: 3 cycleSpeed: 1)
				(blueLight90 init:)
			)
			(4
				(puikoid
					init:
					setLoop: 0
					setCel: 0
					setStep: 10 10
					setMotion: MoveTo 85 53 self
				)
				(gSq5Music1 number: 47 loop: -1 play:)
			)
			(5
				(crew90 cel: 0 setCycle: End self)
				(eye init:)
				(slime init:)
				(bubble1 init: cycleSpeed: 2)
				(bubble2 init:)
				(bubble3 init:)
			)
			(6
				(crew90 cel: (crew90 lastCel:) setCycle: CT 11 -1 self)
				(= seconds 1)
			)
			(7
				(gCurRoom newRoom: 201)
				(gSq5Music1 fade:)
				(self dispose:)
			)
		)
	)
)

(instance beatEA90 of Prop
	(properties
		x 223
		y 49
		view 550
		loop 3
	)

	(method (init)
		(self cel: 0 cycleSpeed: 2 setCycle: End self)
		(super init: &rest)
	)

	(method (cue)
		(switch loop
			(3
				(self setLoop: 11 cel: 0 setCycle: End self)
			)
			(11
				(self setLoop: 12 cel: 0 setCycle: End self)
			)
			(12
				(self setLoop: 3 cel: 0 setCycle: End self)
			)
		)
	)
)

(instance redLight90 of Prop
	(properties
		x 282
		y 95
		view 550
		loop 4
		cel 1
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance topGreen90 of Prop
	(properties
		x 218
		y 70
		view 550
		loop 5
		cel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance secondGreen90 of Prop
	(properties
		x 218
		y 78
		view 550
		loop 5
		cel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance thirdGreen90 of Prop
	(properties
		x 219
		y 86
		view 550
		loop 5
		cel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance fourthGreen90 of Prop
	(properties
		x 219
		y 96
		view 550
		loop 5
		cel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance blueLight90 of Prop
	(properties
		x 166
		y 107
		view 550
		loop 6
		cel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance greenOutline93 of Prop
	(properties
		x 217
		y 72
		view 550
		loop 7
		cel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance lights93 of Prop
	(properties
		x 185
		y 70
		view 550
		loop 8
	)

	(method (init)
		(self cel: 0 cycleSpeed: 1 setCycle: End self)
		(super init: &rest)
	)

	(method (cue)
		(if (>= y 106)
			(self y: 70)
		else
			(self y: (+ (self y:) 18))
		)
		(self cel: 0 setCycle: End self)
	)
)

(instance discLight93 of Prop
	(properties
		x 30
		y 106
		view 550
		loop 9
		cel 7
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance greenLLight93 of Prop
	(properties
		x 27
		y 109
		view 550
		loop 10
		cel 5
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance sitter93 of View
	(properties
		x 137
		y 75
		view 551
		loop 7
	)
)

(instance crew293 of Prop
	(properties
		x 69
		y 141
		view 550
		loop 1
	)
)

(instance crew393 of View
	(properties
		x 290
		y 152
		view 550
		loop 2
	)
)

(instance crew493 of View
	(properties
		x 218
		y 154
		view 550
		loop 2
		cel 1
	)
)

(instance puikoid of Actor
	(properties
		x 85
		y 153
		view 551
	)
)

(instance eye of Prop
	(properties
		x 61
		y 97
		view 551
		loop 1
		signal 16384
	)

	(method (init)
		(self cycleSpeed: 1 setCycle: Osc)
		(super init:)
	)
)

(instance bubble1 of Prop
	(properties
		x 63
		y 75
		view 551
		loop 2
		cel 2
		signal 16384
	)

	(method (init)
		(self cycleSpeed: 1 setCycle: Fwd)
		(super init:)
	)
)

(instance bubble2 of Prop
	(properties
		x 90
		y 84
		view 551
		loop 3
		cel 1
	)

	(method (init)
		(self cycleSpeed: 1 setCycle: Fwd)
		(super init:)
	)
)

(instance bubble3 of Prop
	(properties
		x 44
		y 131
		view 551
		loop 4
		cel 1
	)

	(method (init)
		(self cycleSpeed: 1 setCycle: Fwd)
		(super init:)
	)
)

(instance slime of Prop
	(properties
		x 90
		y 110
		view 551
		loop 5
		signal 16384
	)

	(method (init)
		(self cycleSpeed: 1 setCycle: End self)
		(super init:)
	)

	(method (cue)
		(self setLoop: 6 cycleSpeed: 1 setCycle: Fwd)
	)
)

(instance crew90 of Prop
	(properties
		x 204
		y 132
		view 550
	)
)

