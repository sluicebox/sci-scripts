;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50300)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use Motion)
(use Actor)
(use System)

(public
	roAirDuctEnd 0
)

(local
	bKillShmutz
	oShmutzArray
)

(instance oTorinCycle of Walk
	(properties)
)

(instance aoTorinFalls of Actor
	(properties
		view 50301
		yStep 50
		moveSpeed 0
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance aoBoogleFalls of Actor
	(properties
		view 50301
		yStep 50
		moveSpeed 0
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance aoTorinCrawls of Actor
	(properties
		view 50201
		xStep 10
	)

	(method (init)
		(super init: &rest)
		(self setCycle: oTorinCycle)
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance oWhoosh of TPSound ; UNUSED
	(properties)
)

(instance aoShmutz of Actor
	(properties
		x 300
		y 500
		view 50302
		yStep 35
		scaleSignal 4
		moveSpeed 0
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
		(self setScript: (soFlyBy new:))
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance soFlyBy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 10 500))
			)
			(1
				(if bKillShmutz
					(self dispose:)
					(return)
				)
				(= ticks (Random 20 60))
			)
			(2
				(client x: (Random 10 622))
				(client cel: (Random 0 1))
				(client yStep: (Random 60 70))
				(client y: (Random 370 380))
				(client setMotion: MoveTo (client x:) -100 self)
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance soJiggleUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(= ticks 6)
			)
			(1
				(self changeState: (Random 2 5))
			)
			(2
				(client posn: (+ (client x:) 4) (client y:))
				(++ register)
				(if (== register 4)
					(self changeState: 0)
					(return)
				)
				(= ticks 6)
			)
			(3
				(client posn: (client x:) (+ (client y:) 4))
				(++ register)
				(if (== register 4)
					(self changeState: 0)
					(return)
				)
				(= ticks 6)
			)
			(4
				(client posn: (- (client x:) 4) (client y:))
				(++ register)
				(if (== register 4)
					(self changeState: 0)
					(return)
				)
				(= ticks 6)
			)
			(5
				(client posn: (client x:) (- (client y:) 5))
				(++ register)
				(if (== register 4)
					(self changeState: 0)
					(return)
				)
				(= ticks 6)
			)
			(6
				(self changeState: 2)
			)
		)
	)
)

(instance soJiggleDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(= ticks 6)
			)
			(1
				(self changeState: (Random 2 5))
			)
			(2
				(client posn: (+ (client x:) 4) (client y:))
				(++ register)
				(if (== register 4)
					(self changeState: 0)
					(return)
				)
				(= ticks 6)
			)
			(3
				(client posn: (client x:) (+ (client y:) 6))
				(++ register)
				(if (== register 4)
					(self changeState: 0)
					(return)
				)
				(= ticks 6)
			)
			(4
				(client posn: (- (client x:) 4) (client y:))
				(++ register)
				(if (== register 4)
					(self changeState: 0)
					(return)
				)
				(= ticks 6)
			)
			(5
				(client posn: (client x:) (- (client y:) 4))
				(++ register)
				(if (== register 4)
					(self changeState: 0)
					(return)
				)
				(= ticks 6)
			)
			(6
				(self changeState: 2)
			)
		)
	)
)

(instance oFoosh of TPSound
	(properties)
)

(instance soTorinFallsThroughSpace of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom picture: 50300)
				(gCurRoom drawPic: 50300)
				(goSound1 preload: 50302 50301 50303)
				(aoTorinCrawls
					setSpeed: 7
					loop: 0
					cel: 4
					posn: 660 80
					init:
					setMotion: MoveTo 390 80 self
				)
			)
			(1
				(aoTorinCrawls dispose:)
				(aoTorinFalls loop: 0 cel: 0 posn: 390 80 init:)
				(goMusic1 setMusic: 0)
				(goSound1 playSound: 50302)
				(aoTorinFalls setCycle: CT 17 1 self)
			)
			(2
				(gMessager say: 0 0 1 1 self) ; "(SLOWLY AND SOFTLY) Uh, oh."
			)
			(3
				(aoTorinFalls setCycle: CT 19 1 self)
			)
			(4
				(goSound1 playSound: 50301)
				(aoTorinFalls setCycle: End self)
			)
			(5
				(aoTorinFalls dispose:)
				(FrameOut)
				(gCurRoom picture: -1)
				(gCurRoom drawPic: -1)
				(oFoosh setAmbient: 50303)
				(aoTorinFalls
					loop: 1
					cel: 0
					posn: 316 100
					init:
					setCycle: Fwd
					setScript: (soJiggleDown new:)
				)
				(aoBoogleFalls
					loop: 2
					cel: 0
					posn: 260 40
					init:
					setCycle: Fwd
					setScript: (soJiggleUp new:)
				)
				(= bKillShmutz 0)
				(= oShmutzArray (Set new:))
				(oShmutzArray
					addToEnd:
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
						((aoShmutz new:) init: yourself:)
				)
				(gMessager say: 0 0 1 2 self) ; "(LONG AND ROADRUNNERISH) Ahhhhhhhhhhhhhhhhh  hhhhhhhhhhhhhhh!"
			)
			(6
				(aoTorinFalls setCycle: 0 loop: 4 cel: 0)
				(= ticks 6)
			)
			(7
				(aoTorinFalls loop: 3 cel: 0 setCycle: Fwd)
				(gMessager say: 0 0 1 3 self) ; "Boogle! Save us!!"
			)
			(8
				(aoTorinFalls setCycle: 0 loop: 4 cel: 0)
				(= ticks 6)
			)
			(9
				(aoTorinFalls loop: 1 cel: 0 setCycle: Fwd)
				(aoTorinFalls setMotion: MoveTo 316 370 self)
				(aoBoogleFalls setMotion: MoveTo 316 370 self)
				(= bKillShmutz 1)
			)
			(10)
			(11
				(= ticks 120)
			)
			(12
				(if oShmutzArray
					(oShmutzArray dispose:)
					(= oShmutzArray 0)
				)
				(FrameOut)
				(gCurRoom newRoom: 50400) ; roInPlanter
			)
		)
	)

	(method (ff)
		(if oShmutzArray
			(oShmutzArray dispose:)
			(= oShmutzArray 0)
		)
		(gCurRoom newRoom: 50400) ; roInPlanter
	)

	(method (rewind)
		(goMusic1 setMusic: 50100)
		(oFoosh stop:)
		(aoTorinFalls dispose:)
		(aoBoogleFalls dispose:)
		(aoTorinCrawls dispose:)
		(if oShmutzArray
			(oShmutzArray dispose:)
			(= oShmutzArray 0)
		)
		(gCurRoom setScript: self)
	)
)

(instance roAirDuctEnd of TPRoom
	(properties
		picture 50300
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 50100)
		(gCurRoom setScript: soTorinFallsThroughSpace)
	)

	(method (gimme))
)

