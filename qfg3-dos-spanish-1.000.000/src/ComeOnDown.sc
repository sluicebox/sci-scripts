;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	ComeOnDown 0
	laurelTalker 1
	hardyTalker 2
)

(local
	local0
)

(instance ComeOnDown of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable:)
				(= local0 (gGame setCursor: 996 1))
				(SetCursor 0)
				(hardy
					init:
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 7
					setMotion: MoveTo 143 119 self
				)
				(hardyTalker init:)
				(laurelTalker init:)
				(laurel
					init:
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 7
					setMotion: MoveTo 181 125
				)
			)
			(1
				(gMessager say: 1 6 1 0 self 400) ; "Atten-hup! Stanley, stop!"
			)
			(2
				(= cycles 20)
			)
			(3
				(laurel cycleSpeed: 10 loop: 1 cel: 0)
				(= cycles 20)
			)
			(4
				(hardy cycleSpeed: 10 loop: 1 cel: 0)
				(= cycles 20)
			)
			(5
				(hardy setCycle: End self)
			)
			(6
				(= cycles 20)
			)
			(7
				(hardy loop: 2 cel: 0)
				(gMessager say: 1 6 2 0 self 400) ; "Excuse me, sir, but could you tell us the way back to the French Foreign Legion?"
			)
			(8
				(hardy setCycle: End self)
			)
			(9
				(= cycles 20)
			)
			(10
				(hardy loop: 3 cel: 0)
				(gMessager say: 1 6 3 1 self 400) ; "Well, Stanley, this is another fine mess you've gotten us into."
			)
			(11
				(laurel setCycle: End self)
			)
			(12
				(= cycles 20)
			)
			(13
				(gMessager say: 1 6 3 2 self 400) ; "Mmmm, mmmm, I'm sorry, Ollie."
			)
			(14
				(hardy setCycle: End self)
			)
			(15
				(= cycles 20)
			)
			(16
				(gMessager say: 1 6 4 0 self 400) ; "Oh, just go on."
			)
			(17
				(laurel setCycle: Beg self)
			)
			(18
				(hardy
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo -15 123
				)
				(laurel
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo -15 133 self
				)
			)
			(19
				(Face gEgo laurel self)
			)
			(20
				(= cycles 2)
			)
			(21
				(gMessager say: 3 6 25 0 self 400) ; "Didn't those guys look kind of familiar?"
			)
			(22
				(SetCursor 1)
				(gGame setCursor: local0 1)
				(gTheIconBar enable:)
				(laurel dispose:)
				(laurelTalker dispose:)
				(hardy dispose:)
				(hardyTalker dispose:)
				(self dispose:)
			)
		)
	)
)

(instance laurel of Actor
	(properties
		x 352
		y 116
		view 408
		signal 16384
		origStep 1028
	)
)

(instance laurelTalker of GloryTalker
	(properties
		x 1
		y 1
		view 409
		loop 1
		talkWidth 150
		back 57
		textX 137
		textY 5
	)

	(method (init)
		(super init: laurelBrow laurelEyes laurelMouth &rest)
	)
)

(instance laurelEyes of Prop
	(properties
		nsTop 38
		nsLeft 38
		view 409
		loop 2
	)
)

(instance laurelBrow of Prop
	(properties
		nsTop 29
		nsLeft 37
		view 409
		loop 3
	)
)

(instance laurelMouth of Prop
	(properties
		nsTop 54
		nsLeft 38
		view 409
		cel 2
	)
)

(instance hardy of Actor
	(properties
		x 325
		y 106
		view 406
		signal 16384
		origStep 1028
	)
)

(instance hardyTalker of GloryTalker
	(properties
		x 1
		y 1
		view 407
		loop 1
		talkWidth 150
		back 57
		textX 137
		textY 5
	)

	(method (init)
		(super init: hardyBrow hardyEyes hardyMouth &rest)
	)

	(method (show)
		(bust cel: (Random 0 1))
		(super show: &rest)
	)
)

(instance hardyEyes of Prop
	(properties
		nsTop 36
		nsLeft 36
		view 407
		loop 2
		cel 2
	)
)

(instance hardyBrow of Prop
	(properties
		nsTop 28
		nsLeft 31
		view 407
		loop 3
		cel 1
	)
)

(instance hardyMouth of Prop
	(properties
		nsTop 51
		nsLeft 26
		view 407
		cel 8
	)
)

