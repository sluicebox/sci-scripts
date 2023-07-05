;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Plane)
(use Talker)
(use StopWalk)
(use Motion)

(public
	GKNarrator 0
)

(local
	local0
)

(class GKNarrator of Narrator
	(properties
		x 0
		y 157
		talkWidth 314
		modeless 2
	)

	(method (init)
		(self fore: global220 back: global214 font: gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(2 21)
				(1 54)
				(99 7)
				(64 7)
				(6 60)
				(8 30)
				(7 47)
				(4 26)
				(5 19)
				(22 61)
				(29 global234)
				(30 global221)
				(28 global217)
				(31 global223)
				(20 25)
				(17 136)
				(21 69)
				(9 36)
				(18 38)
				(14 38)
				(16 171)
				(19 global225)
				(15 19)
				(18 10)
				(13 19)
				(24 35)
				(40 45)
				(26 47)
				(10 19)
				(43 10)
				(12 10)
				(11 28)
				(45 26)
				(25 25)
				(34 35)
				(38 47)
				(37 61)
				(39 10)
				(36 5)
				(35 59)
				(23 11)
				(27 10)
				(46 11)
				(60 60)
				(42 47)
				(else global220)
			)
		)
		(if
			(and
				(== global180 1)
				(gCast contains: gEgo)
				(or (== (gEgo view:) 901) (== (gEgo view:) 900))
				(== (gEgo loop:) 8)
			)
			(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
				(= temp0 (+ (gEgo view:) 1000))
			else
				(if (== (gEgo view:) 900)
					(= temp0 (+ (gEgo view:) 1010 (gEgo cel:)))
				else
					(= temp0 (+ (gEgo view:) 1039 (gEgo cel:)))
				)
				(switch (Random 0 2)
					(0 1)
					(1
						(+= temp0 10)
					)
					(2
						(= temp0 (+ (gEgo view:) 1000))
					)
				)
			)
			(= local0 (gEgo cycleSpeed:))
			(= temp1 (gEgo cel:))
			(gEgo
				talking: 1
				oldView: (gEgo view:)
				oldLoop: (gEgo loop:)
				oldCel: (gEgo cel:)
				oldSig: (gEgo signal:)
				setCel: 0
				view: temp0
				setLoop: temp1
				ignoreActors:
				cycleSpeed: 14
			)
			(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
				(gEgo setCycle: ForRepeat)
			else
				(gEgo setCycle: Fwd)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if (and (!= gCurRoomNum 50) (gEgo talking:)) ; interrogation
			(gEgo
				view: (gEgo oldView:)
				setCel: 0
				setLoop: (gEgo oldLoop:)
				setCel: (gEgo oldCel:)
				signal: (gEgo oldSig:)
				cycleSpeed: local0
				setCycle: StopWalk -1
				talking: 0
			)
		)
		(super dispose:)
	)
)

(instance talkPlane of Plane ; UNUSED
	(properties)
)

(class ForRepeat of Fwd
	(properties)

	(method (cycleDone)
		(client cel: 8)
	)
)

