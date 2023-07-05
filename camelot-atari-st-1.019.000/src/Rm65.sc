;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use eRoom)
(use Motion)
(use System)

(public
	Rm65 0
)

(local
	local0
)

(instance Rm65 of eRoom
	(properties
		picture 65
		style 1
	)

	(method (init)
		(Load rsVIEW 45)
		(Load rsSOUND (proc0_20 78))
		(super init:)
		(HandsOff)
		(if (gEgo has: 3) ; purse
			(PutItem 3) ; purse
		)
		(if (gEgo has: 4) ; rose | apple | green_apple
			(PutItem 4 65) ; rose | apple | green_apple
		)
		(gRegMusic number: (proc0_20 78) priority: 1 loop: -1 play:)
		(gEgo
			init:
			setPri: 4
			view: 45
			setCycle: Fwd
			yStep: 7
			xStep: 9
			posn: 79 -22
		)
		(proc0_13 80)
		(gAddToPics doit:)
		(gEgo setScript: funkySlide)
	)
)

(instance funkySlide of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local0
			(gEgo y: (+ (gEgo y:) (- (Random 0 8) 4)))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(gEgo setLoop: 2 yStep: 16 setMotion: MoveTo 85 45 self)
			)
			(1
				(= local0 1)
				(gEgo
					setLoop: 0
					x: (+ (gEgo x:) 3)
					yStep: 7
					setMotion: MoveTo 103 49 self
				)
			)
			(2
				(gEgo setLoop: 1 setMotion: MoveTo 158 68 self)
			)
			(3
				(gEgo
					xStep: 17
					yStep: 15
					setLoop: 2
					setMotion: MoveTo 213 100 self
				)
			)
			(4
				(= local0 0)
				(gEgo setLoop: 1 setMotion: MoveTo 261 120 self)
			)
			(5
				(gEgo setLoop: 2 setMotion: MoveTo 260 145 self)
			)
			(6
				(= local0 1)
				(gEgo setLoop: 0 setMotion: MoveTo 216 160 self)
			)
			(7
				(gEgo setLoop: 2 setMotion: MoveTo 171 162 self)
			)
			(8
				(= local0 0)
				(gEgo yStep: 20 setLoop: 1 setMotion: MoveTo 136 212 self)
			)
			(9
				(HandsOn)
				(gCurRoom newRoom: 50)
			)
		)
	)
)

