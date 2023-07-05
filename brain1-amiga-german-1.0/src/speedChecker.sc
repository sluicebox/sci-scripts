;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 802)
(include sci.sh)
(use Main)
(use dummyClient)
(use Motion)
(use Game)
(use Actor)

(public
	speedChecker 0
)

(local
	local0
)

(instance fred of Actor
	(properties)
)

(instance speedChecker of Rm
	(properties
		picture 802
		style 6
	)

	(method (init)
		(proc5_1)
		(super init:)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 803
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
		(= global164 0)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (== (++ global164) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (u< local0 (GetTime))
			(cond
				((<= global164 24)
					(= gHowFast 0)
				)
				((<= global164 44)
					(= gHowFast 1)
				)
				((<= global164 80)
					(= gHowFast 2)
				)
				(else
					(= gHowFast 3)
				)
			)
			(= global165 gHowFast)
			(= temp0 (FileIO fiOPEN {version} 1))
			(FileIO fiREAD_STRING gVersion 9 temp0)
			(FileIO fiCLOSE temp0)
			(gGame setSpeed: 5)
			(Animate (gCast elements:) 0)
			(proc5_2)
			(gCurRoom newRoom: global107)
		)
	)
)

