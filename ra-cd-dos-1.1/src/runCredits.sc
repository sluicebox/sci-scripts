;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 782)
(include sci.sh)
(use Main)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	runCredits 0
)

(local
	local0
	local1
	local2
	[local3 16]
	local19
)

(procedure (localproc_0)
	(= local2 0)
	(for ((= local1 0)) (< local1 (creditTitle lastCel:)) ((++ local1))
		(= [local3 local1]
			(creditName
				view:
					(switch local0
						(11 793)
						(12 793)
						(13 793)
						(14 793)
						(15 793)
						(16 793)
						(17 795)
						(18 795)
						(19 793)
						(else 791)
					)
				new:
			)
		)
		([local3 local1]
			setLoop:
				(switch local0
					(11 0)
					(12 1)
					(13 2)
					(14 3)
					(15 4)
					(16 5)
					(17 0)
					(18 1)
					(19 6)
					(else local0)
				)
			setCel: (+ local1 1)
		)
		(++ local2)
	)
)

(instance runCredits of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(creditTitle
					view:
						(switch local0
							(11 793)
							(12 793)
							(13 793)
							(14 793)
							(15 793)
							(16 793)
							(17 795)
							(18 795)
							(19 793)
							(else 791)
						)
					setLoop:
						(switch local0
							(11 0)
							(12 1)
							(13 2)
							(14 3)
							(15 4)
							(16 5)
							(17 0)
							(18 1)
							(19 6)
							(else local0)
						)
					init:
					addToPic:
				)
				(localproc_0)
				(creditProp
					init:
					show:
					stopUpd:
					cel: 0
					ignoreActors:
					setCycle: (if (OneOf local0 14 15 16) Fwd else 0)
				)
				(if (OneOf local0 14 15 16)
					(creditProp2 init: setCycle: Fwd)
				)
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
						(creditProp view: 797 setLoop: 3 setCel: 0 x: 46 y: 175)
					)
					(13
						(creditProp view: 796 setLoop: 1 x: 0 y: 121 stopUpd:)
					)
					(14
						(creditProp view: 796 setLoop: 2 x: 46 y: 175)
						(creditProp2 setLoop: 4 x: 280 y: 175)
					)
					(15
						(creditProp setLoop: 5 x: 46 y: 175)
						(creditProp2 setLoop: 3 x: 280 y: 175)
					)
					(16
						(creditProp setLoop: 4 x: 46 y: 175)
						(creditProp2 setLoop: 6 x: 280 y: 175)
					)
					(17
						(creditProp view: 797 setLoop: 4 setCel: 0 x: 46 y: 175)
					)
					(18
						(creditProp view: 797 setCel: 0 setLoop: 2 x: 19 y: 186)
						(creditProp2
							view: 797
							setCel: 0
							setLoop: 1
							setPri: 15
							x: 10
							y: 179
							init:
							stopUpd:
						)
						(creditProp3
							view: 797
							setCel: 0
							cycleSpeed: 6
							setLoop: 0
							setPri: 15
							x: 51
							y: 184
							init:
							stopUpd:
						)
					)
					(19
						(creditProp view: 797 setLoop: 5 setCel: 0 x: 46 y: 175)
					)
				)
				(if (== (creditProp loop:) 7)
					(volleyBall init: x: 43 y: 124 hide:)
					(sunnyTwo init: show: stopUpd:)
				)
				(= cycles 1)
			)
			(1
				(if (OneOf local0 5 6 7 8 9 14 15)
					(= local19 90)
				else
					(= local19 40)
				)
				(= local1 0)
				([local3 0] init:)
				(= cycles 1)
			)
			(2
				([local3 local1] setMotion: MoveTo 86 local19 self)
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
					(+= local19 40)
				else
					(= local19 (+ (/ 164 local2) local19))
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
					(13
						(creditProp3 cycleSpeed: 1 setCycle: Fwd init:)
						(= ticks 300)
					)
					(14
						(= ticks 300)
					)
					(15
						(= ticks 300)
					)
					(16
						(= ticks 300)
					)
					(17
						(creditProp setCycle: End)
						(= ticks 300)
					)
					(18
						(creditProp2 setCycle: End)
						(creditProp3 setCycle: End)
						(= ticks 300)
					)
					(19
						(creditProp setCycle: End)
						(= ticks 300)
					)
				)
			)
			(6
				(if (OneOf local0 9 10)
					(volleyBall dispose:)
					(sunnyTwo dispose:)
				)
				(if (OneOf local0 13 17)
					(creditProp3 dispose:)
				)
				(if (OneOf local0 14 15 16 18)
					(creditProp2 dispose:)
				)
				(creditProp dispose:)
				(gAddToPics eachElementDo: #dispose)
				(gAddToPics eachElementDo: #delete)
				(gCast eachElementDo: #dispose)
				(gCast eachElementDo: #delete)
				(gCurRoom drawPic: 780)
				(= cycles 2)
			)
			(7
				(= cycles 2)
			)
			(8
				(if (< local0 19)
					(++ local0)
					(self changeState: -1)
					(= cycles 1)
				else
					(self dispose:)
				)
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
		moveSpeed 1
	)
)

(instance creditProp of Actor
	(properties
		view 792
	)
)

(instance creditProp2 of Actor
	(properties
		view 796
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

(instance creditProp3 of Prop
	(properties
		x 29
		y 171
		view 796
		priority 15
	)
)

