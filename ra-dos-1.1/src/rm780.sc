;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm780 0
)

(local
	local0
	local1
	local2
	[local3 9]
	local12
)

(procedure (localproc_0)
	(= local2 0)
	(for ((= local1 0)) (< local1 (creditTitle lastCel:)) ((++ local1))
		(= [local3 local1] (creditName view: 791 new:))
		([local3 local1] setLoop: local0 setCel: (+ local1 1))
		(++ local2)
	)
)

(procedure (localproc_1)
	(= local2 0)
	(for ((= local1 0)) (< local1 (creditTitle lastCel:)) ((++ local1))
		(= [local3 local1] (creditName view: 8000 new:))
		([local3 local1] setLoop: local0 setCel: (+ local1 1))
		(++ local2)
	)
)

(instance rm780 of LBRoom
	(properties
		picture 780
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 792 791)
		(LoadMany rsSOUND 795)
		(super init:)
		(wrapMusic init: 1 795 1312 (if (== global106 32) 310 else 314) 311)
		(gGame handsOff:)
		(gTheIconBar disable:)
		(gGame setCursor: 996 1)
		(if (== (gGame printLang:) 1)
			(self setScript: runCredits)
		else
			(self setScript: runCreditsFor)
		)
	)
)

(instance runCredits of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(creditTitle view: 791 setLoop: local0 init: addToPic:)
				(localproc_0)
				(creditProp init: show: cel: 0 setCycle: 0)
				(switch local0
					(0
						(creditProp setLoop: 0 x: 57 y: 146)
					)
					(1
						(creditProp setLoop: 1 x: 42 y: 109)
					)
					(2
						(creditProp setLoop: 2 x: -20 y: 189 stopUpd:)
					)
					(3
						(creditProp setLoop: 2 x: -20 y: 189 stopUpd:)
					)
					(4
						(creditProp setLoop: 9 x: 20 y: 160)
					)
					(5
						(creditProp setLoop: 6 x: 270 y: 170)
					)
					(6
						(creditProp setLoop: 3 x: -20 y: 189)
					)
					(7
						(creditProp setLoop: 4 x: 339 y: 189)
					)
					(8
						(creditProp setLoop: 5 x: 339 y: 189)
					)
					(9
						(creditProp setLoop: 7 x: 46 y: 175)
					)
					(10
						(creditProp setLoop: 7 x: 46 y: 175)
					)
					(11
						(creditProp setLoop: 10 x: 46 y: 175)
					)
					(12
						(creditProp setLoop: 11 x: 46 y: 175)
					)
				)
				(if (== (creditProp loop:) 7)
					(volleyBall init: x: 43 y: 124 hide:)
					(sunnyTwo init: show:)
				else
					(volleyBall dispose:)
					(sunnyTwo dispose:)
				)
				(= cycles 1)
			)
			(1
				(= local12 (if (OneOf local0 5 6 7 8 9 11 12) 90 else 40))
				(= local1 0)
				([local3 0] init:)
				(= cycles 1)
			)
			(2
				([local3 local1] setMotion: MoveTo 86 local12 self)
				(if (< (+ local1 1) local2)
					([local3 (+ local1 1)] init:)
				)
				(= cycles 1)
			)
			(3
				(if (>= (+ local1 1) local2)
					(= state 4)
				else
					0
				)
			)
			(4
				([local3 local1] addToPic:)
				(++ local1)
				(if (== local0 6)
					(+= local12 40)
				else
					(= local12
						(switch local0
							(12 150)
							(11 150)
							(else
								(+ (/ 164 local2) local12)
							)
						)
					)
				)
				(= state 1)
				(self cue:)
			)
			(5
				(switch local0
					(0
						(creditProp setCycle: End)
						(= ticks 300)
					)
					(1
						(creditProp setCycle: End)
						(= ticks 300)
					)
					(2
						(= ticks 300)
					)
					(3
						(creditProp setCycle: End)
						(= ticks 300)
					)
					(4
						(creditProp setCycle: End)
						(= ticks 300)
					)
					(5
						(creditProp setCycle: End)
						(= ticks 300)
					)
					(6
						(creditProp setCycle: Fwd setMotion: MoveTo 75 189 self)
					)
					(7
						(creditProp
							setCycle: Fwd
							setMotion: MoveTo 235 189 self
						)
					)
					(8
						(creditProp
							setCycle: Fwd
							setMotion: MoveTo 235 189 self
						)
					)
					(9
						(creditProp setScript: sPlay self)
					)
					(10
						(creditProp setScript: sPlay self)
					)
					(11
						(creditProp setCycle: End)
						(= ticks 300)
					)
					(12
						(creditProp setCycle: End)
						(= ticks 300)
					)
				)
			)
			(6
				(creditProp dispose:)
				(gCurRoom drawPic: 780)
				(gCast eachElementDo: #dispose)
				(if (< local0 12)
					(++ local0)
					(self changeState: -1)
					(= cycles 1)
				else
					(= seconds 4)
				)
			)
			(7
				(gCurRoom setInset: daggerInset self)
			)
			(8
				(creditSound fade: 0 30 12 1)
				(= seconds 3)
			)
			(9
				(= gQuit 1)
			)
		)
	)
)

(instance runCreditsFor of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(gGame setCursor: 996 1)
				(creditTitle view: 8000 setLoop: local0 init: addToPic:)
				(localproc_1)
				(= cycles 1)
			)
			(1
				(= local12 85)
				(= local1 0)
				([local3 0] init:)
				(= cycles 1)
			)
			(2
				([local3 local1] setMotion: MoveTo 86 local12 self)
				(if (< (+ local1 1) local2)
					([local3 (+ local1 1)] init:)
				)
				(= cycles 1)
			)
			(3
				(if (>= (+ local1 1) local2)
					(= state 4)
				else
					0
				)
			)
			(4
				([local3 local1] addToPic:)
				(++ local1)
				(+= local12 30)
				(= state 1)
				(self cue:)
			)
			(5
				(= seconds 5)
			)
			(6
				(gCurRoom drawPic: 780)
				(gCast eachElementDo: #dispose)
				(if (< local0 3)
					(++ local0)
					(self changeState: -1)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(7
				(= local0 0)
				(gGame setCursor: 996 1)
				(self setScript: runCredits)
			)
		)
	)
)

(instance sPlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(volleyBall show: setCycle: Fwd)
				(creditProp setCycle: End self)
				(volleyBall setMotion: JumpTo 283 125 self)
			)
			(1 0)
			(2
				(sunnyTwo setCycle: End self)
				(volleyBall setMotion: JumpTo 43 124 self)
			)
			(3 0)
			(4
				(creditProp setCycle: End self)
				(volleyBall setMotion: JumpTo 283 125 self)
			)
			(5 0)
			(6
				(sunnyTwo setCycle: End self)
				(volleyBall dispose:)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance creditTitle of Actor
	(properties
		x 9
		y 20
	)
)

(instance creditName of Actor
	(properties
		x 86
		y 220
		cel 1
		signal 16384
		moveSpeed 0
	)
)

(instance creditProp of Actor
	(properties
		view 792
	)
)

(instance volleyBall of Actor
	(properties
		x 43
		y 124
		view 792
		loop 8
	)
)

(instance sunnyTwo of Prop
	(properties
		x 286
		y 179
		view 792
		loop 7
	)
)

(instance wrapMusic of WrapMusic
	(properties)

	(method (init)
		(= wrapSound creditSound)
		(super init: &rest)
	)
)

(instance creditSound of Sound
	(properties)
)

(instance daggerEnd of View
	(properties
		x 88
		y 85
		view 401
		cel 1
	)

	(method (doVerb)
		(daggerInset doVerb: &rest)
	)
)

(instance daggerInset of Inset
	(properties
		picture 401
	)

	(method (handleEvent event)
		(gGame handsOff:)
		(event claimed: 1)
		(daggerEnd dispose:)
		(self dispose:)
	)

	(method (init)
		(super init: &rest)
		(daggerEnd init:)
		(gGame handsOn:)
		(gTheIconBar enable:)
	)
)

