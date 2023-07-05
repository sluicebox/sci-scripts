;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use eRS)
(use System)

(public
	rm420 0
)

(local
	local0
	local1 = 100
)

(instance rm420 of FPRoom
	(properties
		picture 420
	)

	(method (init)
		(proc0_9 0)
		(super init:)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (doit)
		(cond
			((and (== state 3) (== (PalVary pvGET_CURRENT_STEP) 64))
				(self cue:)
			)
			((and local0 local1)
				(Palette palSET_INTENSITY 0 255 (-- local1))
				(if (not local1)
					(self cue:)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
				(ClearFlag 1)
				(SetFlag 59)
			)
			(1
				(gMessager say: 1 0 0 0 self) ; "Freddy, I...I think you should leave."
			)
			(2
				(gTheIconBar disable: 1 2 3 4 5 6 7)
				(gGame setCursor: 996)
				(= seconds 1)
			)
			(3
				(PalVary pvINIT 630 5)
			)
			(4
				(= local0 1)
			)
			(5
				(PalVary pvUNINIT)
				(gCast eachElementDo: #dispose)
				(Palette palSET_INTENSITY 0 256 0)
				(gCurRoom drawPic: 780)
				(= cycles 1)
			)
			(6
				(gCurRoom newRoom: 26) ; actBreak
				(self dispose:)
			)
		)
	)
)

