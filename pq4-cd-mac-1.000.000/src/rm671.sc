;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 671)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm671 0
)

(local
	local0 = 4
	local1 = 4
)

(instance rm671 of Room
	(properties
		picture 0
	)

	(method (init)
		(gGlobalSound0 number: 671 loop: -1 play:)
		(Platform 0 2 1)
		(gGlobalSound1 stop:)
		(Palette 2 0 239 0) ; PalIntensity
		(gGame handsOff:)
		(gTheIconBar disable:)
		((= plane gThePlane)
			picture: -1
			back: 0
			style: style
			setRect: 0 0 319 199 1
		)
		(FrameOut)
		(super init: &rest)
		(gTheCursor hide:)
		(gGame intensity: 0)
		(gPqFlags set: 101)
		(self setScript: dreamScript)
	)

	(method (dispose)
		(gThePlane picture: -1 back: 0 style: 0 setRect: 0 0 319 152 1)
		(gGame intensity: 100)
		(FrameOut)
		(Palette 2 0 34 100) ; PalIntensity
		(Palette 2 37 37 100) ; PalIntensity
		(super dispose:)
	)
)

(instance dreamScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(mitchell
					view: 675
					x: 60
					y: 102
					loop: 0
					cel: 0
					init:
					signal: (| (mitchell signal:) $4000)
				)
				(self setScript: fadeUp self)
			)
			(2
				(mitchell setCycle: End self)
			)
			(3
				(mitchell loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= local0 2)
				(self setScript: fadeDown self)
			)
			(5
				(mitchell
					view: 678
					x: 244
					y: 150
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(= local1 2)
				(self setScript: fadeUp self)
			)
			(6)
			(7
				(= ticks 45)
			)
			(8
				(mitchell loop: 1 cel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(9
				(= local1 2)
				(= local0 4)
				(self setScript: fadeDown self)
			)
			(10
				(mitchell view: 676 x: 60 y: 150 loop: 0 cel: 0)
				(self setScript: fadeUp self)
			)
			(11
				(mitchell setCycle: End self)
			)
			(12
				(self setScript: fadeDown self)
			)
			(13
				(mitchell view: 679 x: 244 y: 102 loop: 0 cel: 0)
				(self setScript: fadeUp self)
			)
			(14
				(mitchell setCycle: End self)
			)
			(15
				(= ticks 45)
			)
			(16
				(mitchell loop: 1 cel: 0 setCycle: End self)
			)
			(17
				(self setScript: fadeDown self)
			)
			(18
				(mitchell view: 677 x: 160 y: 115 loop: 0 cel: 0)
				(self setScript: fadeUp self)
			)
			(19
				(mitchell setCycle: End self)
			)
			(20
				(= ticks 90)
			)
			(21
				(mitchell loop: 1 cel: 0 setCycle: End self)
			)
			(22
				(self setScript: fadeDown self)
			)
			(23
				(gGlobalSound0 fade: 0 5 1 1)
				(mitchell dispose:)
				(= cycles 2)
			)
			(24
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance fadeDown of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 100)
	)

	(method (doit)
		(if register
			(Palette 2 0 239 register) ; PalIntensity
			(FrameOut)
			(-= register local0)
		else
			(self dispose:)
		)
	)
)

(instance fadeUp of Script
	(properties)

	(method (init)
		(= caller 0)
		(super init: &rest)
		(= register 0)
	)

	(method (doit)
		(if (<= register 100)
			(Palette 2 0 239 register) ; PalIntensity
			(FrameOut)
			(+= register local1)
		else
			(self dispose:)
		)
	)
)

(instance mitchell of Actor
	(properties
		view 675
	)
)

