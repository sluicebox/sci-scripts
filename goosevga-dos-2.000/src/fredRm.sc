;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	fredRm 0
)

(local
	local0
)

(instance fredRm of Rm
	(properties
		style 0
	)

	(method (init)
		(SetPort 0 0 190 320 0 0)
		(super init:)
		(while (u> (GetTime) 64512)
		)
		(fred
			view: 99
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
		(= global170 0)
	)

	(method (dispose)
		(Animate (gCast elements:) 0)
		(super dispose:)
	)

	(method (doit &tmp [temp0 20])
		(super doit:)
		(if (== (++ global170) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (or (u< local0 (GetTime)) (== global170 255))
			(= gHowFast (if (<= global170 100) 0 else 1))
			(StrAt @global190 0 global170)
			(StrAt @global190 1 (+ gHowFast 32))
			(MemorySegment 0 @global190 0)
			(gCurRoom newRoom: 108)
		)
	)
)

(instance fred of Actor
	(properties)
)

