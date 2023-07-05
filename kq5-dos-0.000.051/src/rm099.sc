;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm099 0
)

(local
	local0
	local1
)

(instance rm099 of Rm
	(properties
		picture 55
	)

	(method (init)
		(HandsOff)
		(super init:)
		(= global327 0)
		(while (u> (GetTime) -1024)
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
		(= local1 0)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (u< local0 (GetTime))
			(if (<= local1 90)
				(= global286 0)
				(= global81 1)
			else
				(= global286 2)
			)
			(HandsOn)
			(gGame setSpeed: 2)
			(Palette palSET_INTENSITY 0 255 100)
			(cond
				((and (not global327) global100)
					(proc0_20)
				)
				((GameIsRestarting)
					(gEgo get: 28) ; Wand
					(self newRoom: 1)
				)
				(else
					(= global287 (GetTime))
					(gCurRoom newRoom: 119) ; kq5Title
				)
			)
		)
	)
)

(instance fred of Act
	(properties)
)

