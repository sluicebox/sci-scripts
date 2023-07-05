;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	intro 0
)

(local
	local0
)

(instance intro of Rm
	(properties
		style 0
	)

	(method (init)
		(proc0_2)
		(SetPort 0 0 190 320 0 0)
		(gLongSong play:)
		(Palette palSET_INTENSITY 0 255 0)
		(super init:)
		(Palette palSET_INTENSITY 0 255 0)
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
			(if (<= global170 100)
				(= global157 0)
			else
				(= global157 1)
			)
			(StrAt @global190 0 global170)
			(StrAt @global190 1 (+ global157 32))
			(MemorySegment 0 @global190 0)
			(proc0_3)
			(gGame setSpeed: 3)
			(gCurRoom newRoom: 90) ; intro
		)
	)
)

(instance fred of Act
	(properties)
)

