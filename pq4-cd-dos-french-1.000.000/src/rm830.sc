;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 830)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm830 0
)

(instance rm830 of Room
	(properties
		picture 830
	)

	(method (init)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 113 39 113 57 123 76 169 80 216 99 319 93 319 49 270 60 251 42 128 55 128 39
					yourself:
				)
		)
		(gEgo stopView: -1)
		(if (== gPrevRoomNum 840)
			(gEgo
				setHeading: 270
				normalize: 9830
				init:
				x: 288
				y: 75
				scaleSignal: 0
				setMotion: PolyPath 200 73
			)
			(danny view: 831 init:)
			(self setScript: egoLeaves)
		else
			(gEgo
				setHeading: 80
				normalize: 9830
				init:
				x: 125
				y: 46
				scaleSignal: 0
			)
			(danny init:)
			(self setScript: sEnter)
		)
		(gGame handsOff:)
	)

	(method (doit)
		(super doit:)
		(cond
			((> (gEgo x:) 300)
				(self newRoom: 840)
			)
			((< (gEgo y:) 40)
				(gEgo stopView: 5)
				(self newRoom: 860)
			)
		)
	)
)

(instance danny of Prop
	(properties
		x 130
		y 77
		view 831
	)
)

(instance egoLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(danny loop: 1 cel: 9 setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(danny setCycle: End self)
			)
			(1
				(danny loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setMotion: PolyPath 168 73 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

