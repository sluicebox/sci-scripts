;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm040 0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (<= (= temp0 (+ (* -11 param1) 3870)) (* 15 param2))
		(return 1)
	else
		(return 0)
	)
)

(instance rm040 of MGRoom
	(properties
		picture 40
		horizon 1
		picAngle 50
		edgeN -1
		edgeE 225
		edgeW -1
		edgeS 135
	)

	(method (init)
		(Load rsVIEW 149)
		(if ((gGoals at: 15) egoReturned:)
			(Load rsVIEW 83)
		)
		(super init:)
		(= global305 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 56 101 96 121 99 119 109 112 125 113 160 115 166 120 165 126 167 127 178 123 182 132 189 123 184 118 209 96 198 97 190 94 180 94 160 88 157 81 146 79 128 80 127 85 119 90 89 100 76 95
					yourself:
				)
		)
		(if (!= gPrevRoomNum 45) ; mapRoom
			(gEgo loop: 1 posn: 184 118)
		)
		(gEgo init:)
		(table init:)
		(proc0_8 205 94 215 126)
		(if global150
			(global150 z: 13)
		)
		(if (and global130 (> global130 47))
			(global129 z: 13)
		)
		(if ((gGoals at: 15) egoReturned:)
			(man init:)
			(catMouse init:)
			(= global301 converse6)
		)
		(gGame handsOn:)
	)

	(method (doit)
		(if (localproc_0 (gEgo x:) (gEgo y:))
			(self newRoom: 15)
		)
		(super doit:)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global516 gNarrator)
				(= gNarrator mgNarrator)
				(proc0_7 gEgo man)
				(= cycles 1)
			)
			(1
				(gMessager say: 9 1 7 0 self 15) ; "I suppose I should thank you for finding my crooked sixpence, youngster. I really am appreciative. I don't need anything else, though. Thanks, anyway. Now get out of here!"
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
			(19
				(man setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(19
				(man cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

(instance man of Actor
	(properties
		x 116
		y 116
		priority 180
		fixPriority 1
		view 83
		loop 10
	)

	(method (doit)
		(if (not script)
			(cond
				((> (gEgo x:) (+ x 20))
					(= loop 10)
				)
				((< (gEgo x:) (- x 20))
					(= loop 12)
				)
				(else
					(= loop 11)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: global301)
			)
		)
	)
)

(instance catMouse of View
	(properties
		x 103
		y 70
		view 82
	)
)

(instance table of View
	(properties
		priority 40
		fixPriority 1
		view 149
		signal 16400
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(self posn: 205 94)
		(super init:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 102 (gEgo x:) 187))
				(= temp1 75)
			)
			(2
				(= temp0 225)
				(= temp1 (proc0_13 89 (gEgo y:) 108))
			)
			(3
				(= temp0 (proc0_13 189 (gEgo x:) 218))
				(= temp1 156)
			)
			(4
				(= temp0 51)
				(= temp1 (proc0_13 98 (gEgo y:) 124))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0)
	)
)

