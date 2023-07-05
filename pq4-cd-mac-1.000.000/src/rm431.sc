;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 431)
(include sci.sh)
(use Main)
(use MoveToAndScale)
(use Array)
(use Game)
(use Actor)
(use System)

(public
	rm431 0
)

(local
	local0
	local1
	local2
)

(instance rm431 of Room
	(properties
		style 0
		picAngle 15
	)

	(method (init)
		(gTheIconBar disable:)
		(Platform 0 2 1)
		((= plane gThePlane)
			picture: -1
			back: 0
			style: style
			setRect: 0 0 319 199 1
		)
		(gTheCursor hide:)
		(super init:)
		(= local0
			(IntArray
				newWith:
					15
					225
					219
					213
					207
					203
					200
					198
					197
					198
					200
					203
					207
					213
					219
					222
			)
		)
		(= local1
			(IntArray newWith: 15 63 61 60 61 65 69 74 79 84 88 91 93 94 93 89)
		)
		(map
			view: (if (IsHiRes) 8018 else 8017)
			x: (if (IsHiRes) 140 else 159)
			y: (if (IsHiRes) 93 else 100)
			init:
			signal: (| (map signal:) $6800)
		)
		(self setScript: beeLineScr)
		(blip init: signal: (| (blip signal:) $6800))
	)

	(method (dispose)
		(gTheIconBar enable:)
		(Platform 0 2 0)
		(gThePlane setRect: 0 0 319 152)
		(gTheCursor show:)
		(super dispose:)
	)
)

(instance map of Actor
	(properties
		x 159
		y 100
		maxScale 127
		fixPriority 1
		view 8017
		scaleSignal 1
	)
)

(instance blip of Prop
	(properties
		x 230
		y 67
		priority 10
		fixPriority 1
		view 428
	)
)

(instance beeLineScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= register (List new:))
				(= cycles 2)
			)
			(1
				((= temp1 (blip new:))
					init:
					signal: 24576
					x: (local0 at: local2)
					y: (local1 at: local2)
				)
				(register add: temp1)
				(= cycles 5)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (< (++ local2) 15)
					(self start: 1 init:)
				else
					(= cycles 1)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(if (== (gGlobalSound0 prevSignal:) -1)
					(= cycles 2)
				else
					(self start: 4 init:)
				)
			)
			(6
				(blip z: 1000)
				(register eachElementDo: #z 1000)
				(FrameOut)
				(= temp0
					(Max
						1
						(/ (GetDistance (map x:) (map y:) 231 82) 10)
					)
				)
				(map origStep: (| (<< temp0 $0008) temp0))
				(map setMotion: mapMover 231 82 1 self)
			)
			(7
				(register dispose:)
				(gCurRoom newRoom: 700)
			)
		)
	)
)

(instance mapMover of MoveToAndScale
	(properties)

	(method (doit &tmp temp0 temp1 [temp2 4])
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(if
				(<=
					(= temp1 (GetDistance x y (client x:) (client y:)))
					(client xStep:)
				)
				(= temp0 const)
			else
				(= temp0 (+ (/ (* slopeNum temp1) slopeDen) const))
			)
			(client scaleX: temp0 scaleY: temp0)
			(return (= temp1 (DoBresen self)))
		else
			(return 0)
		)
	)
)

