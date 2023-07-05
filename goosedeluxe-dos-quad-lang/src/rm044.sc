;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm044 0
)

(instance rm044 of MGRoom
	(properties
		picture 44
		south 21
		edgeN -1
		edgeE 320
		edgeW -1
		edgeS 125
	)

	(method (init)
		(gGame handsOn:)
		(super init:)
		(= global305 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 47 120 74 125 92 127 114 127 132 122 152 114 183 112 183 126 195 126 195 105 191 104 187 104 163 104 157 101 137 101 132 102 116 111 104 112 57 110 47 110
					yourself:
				)
		)
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo init:)
		else
			(gEgo loop: 3 posn: 190 121 init:)
		)
		(table init:)
		(proc0_8 178 103 211 124)
		(if global150
			(global150 z: 13)
		)
		(if (and global130 (> global130 47))
			(global129 z: 13)
		)
		(= global301 0)
		(if ((gGoals at: 11) egoReturned:)
			(womanBod init:)
			(womanHead
				init:
					womanBod
					(CelHigh (womanBod view:) (womanBod loop:) (womanBod cel:))
			)
			(= global301 converse)
		)
		(gGame handsOn:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (> (gEgo y:) 121) (> (gEgo x:) 182))
				(gCurRoom newRoom: 21)
			)
		)
	)
)

(instance table of View
	(properties
		priority 1
		fixPriority 1
		view 149
		signal 26897
	)

	(method (init)
		(self posn: 178 103)
		(super init:)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance womanHead of Head
	(properties
		view 79
		loop 9
	)

	(method (init)
		(super init: &rest)
		(= x (+ (client x:) 3))
		(= z (client z:))
		(= y (- (client y:) 29))
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse)
			)
		)
	)

	(method (doit)
		(if (not script)
			(cond
				((> (gEgo x:) (+ x 20))
					(= loop 9)
				)
				((< (gEgo x:) (- x 20))
					(= loop 8)
				)
				(else
					(= loop 7)
				)
			)
		)
		(super doit:)
	)
)

(instance womanBod of View
	(properties
		x 112
		y 108
		view 79
		loop 11
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global516 gNarrator)
				(= gNarrator mgNarrator)
				(proc0_7 gEgo womanBod)
				(= cycles 1)
			)
			(1
				(gMessager say: 11 1 7 0 self 21) ; "Feeling better now?"
			)
			(2
				(proc0_5)
				(= gNarrator global516)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(25
				(womanHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(25
				(womanHead cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 38 (gEgo x:) 196))
				(= temp1 101)
			)
			(2
				(= temp0 222)
				(= temp1 (proc0_13 104 (gEgo y:) 120))
			)
			(3
				(= temp0 (proc0_13 190 (gEgo x:) 216))
				(= temp1 124)
			)
			(4
				(= temp0 16)
				(= temp1 (proc0_13 114 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0)
	)
)

