;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Game)
(use User)
(use System)

(public
	rm103 0
)

(local
	local0
	[local1 18] = [216 202 180 159 195 146 137 185 185 144 132 124 134 69 58 97 93 0]
	[local19 27] = [61 44 27 37 92 47 46 66 80 83 75 83 94 88 104 112 127 0 0 45 90 135 180 225 270 315 360]
	local46
	local47
	local48
	local49
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp2 -1)
	(= temp1 10000)
	(if (> (+= param1 (* param3 25)) 360)
		(= param1 360)
	)
	(if (< (-= param2 (* param3 25)) 0)
		(= param2 0)
	)
	(= temp3 (+ 50 (* param3 10)))
	(for ((= temp0 0)) (< temp0 17) ((++ temp0))
		(if (!= temp0 local0)
			(= temp5
				(GetAngle
					[local1 local0]
					[local19 local0]
					[local1 temp0]
					[local19 temp0]
				)
			)
			(= temp6
				(GetDistance
					[local1 local0]
					[local19 local0]
					[local1 temp0]
					[local19 temp0]
				)
			)
			(= temp4 (+ 1 (/ (Abs (- (- param1 44) temp5)) 22)))
			(if
				(and
					(< temp6 temp3)
					(<= temp5 param1)
					(or
						(and (>= param2 0) (>= temp5 param2))
						(and
							(<= param2 0)
							(or (>= temp5 (+ 360 param2)) (>= temp5 0))
						)
					)
					(< (* temp4 temp6) temp1)
				)
				(= temp1 (* temp4 temp6))
				(= temp2 temp0)
			)
		)
	)
	(return temp2)
)

(procedure (localproc_1 param1 param2 &tmp [temp0 4] temp4 temp5 temp6 temp7)
	(-= param2 1)
	(TextSize @[temp0 0] param1 4 0)
	(= temp6 (- [temp0 3] [temp0 1]))
	(= temp7 (- [temp0 2] [temp0 0]))
	(= temp4 (- [local1 param2] (/ temp6 2)))
	(= temp5 (- [local19 param2] (+ temp7 10)))
	(Print
		param1
		#at
		(+ temp4 (/ temp6 2))
		(- temp5 11)
		#font
		4
		#width
		temp6
		#window
		SysWindow
		#dispose
	)
)

(instance rm103 of Rm
	(properties
		picture 3
	)

	(method (init)
		(super init:)
		(gRegMusic stop:)
		(if (== gPrevRoomNum 0)
			(= local0 9)
			(SetFlag 20)
			(= global116 1)
		)
		(= local46 1)
		(cond
			((== gPrevRoomNum 9)
				(= local0 9)
			)
			((or (== gPrevRoomNum 10) (== gPrevRoomNum 17))
				(= local0 10)
			)
			((== gPrevRoomNum 33)
				(= local0 8)
			)
			((== gPrevRoomNum 24)
				(= local0 2)
			)
		)
		(if (>= 22 gPrevRoomNum 18)
			(= local0 10)
		)
		(gEgo
			view: 101
			setLoop: (if (== global116 1) 0 else 1)
			setCel: 0
			posn: [local1 local0] (+ [local19 local0] 1)
			init:
		)
		(HandsOff)
		(User canControl: 1)
		(proc0_13 258)
		(gAddToPics doit:)
		(showInfo changeState: (+ local0 1))
		(= local47 local0)
		(self setScript: showInfo)
	)

	(method (doit &tmp [temp0 21])
		(super doit:)
		(if local48
			(++ local49)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== local0 local47)
			(ClearFlag 71)
		else
			(SetFlag 71)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(switch (event type:)
			(evMOUSEBUTTON
				(event claimed: 1)
				(clr)
				(= temp0 (event x:))
				(= temp1 (event y:))
				(for ((= temp2 0)) (< temp2 17) ((++ temp2))
					(if
						(and
							(>= temp0 [local1 temp2])
							(<= temp0 (+ [local1 temp2] 4))
							(>= temp1 [local19 temp2])
							(<= temp1 (+ [local19 temp2] 3))
						)
						(= local0 temp2)
						(= local46 1)
						(if
							(and
								(== (gEgo x:) [local1 local0])
								(== (gEgo y:) [local19 local0])
							)
							(travelTo changeState: (+ local0 1))
							(break)
						)
						(gEgo posn: [local1 local0] [local19 local0])
						(RedrawCast)
						(showInfo changeState: (+ local0 1))
						(break)
					else
						(= local46 0)
					)
				)
			)
			(evKEYBOARD
				(if (== (event message:) KEY_RETURN)
					(event claimed: 1)
					(if local46
						(clr)
						(travelTo changeState: (+ local0 1))
					)
				)
			)
			($0040 ; direction
				(event claimed: 1)
				(switch (event message:)
					(JOY_UP
						(= temp3 -45)
						(= temp4 45)
					)
					(JOY_UPRIGHT
						(= temp3 0)
						(= temp4 90)
					)
					(JOY_RIGHT
						(= temp3 45)
						(= temp4 135)
					)
					(JOY_DOWNRIGHT
						(= temp3 90)
						(= temp4 180)
					)
					(JOY_DOWN
						(= temp3 135)
						(= temp4 225)
					)
					(JOY_DOWNLEFT
						(= temp3 180)
						(= temp4 270)
					)
					(JOY_LEFT
						(= temp3 225)
						(= temp4 315)
					)
					(JOY_UPLEFT
						(= temp3 270)
						(= temp4 360)
					)
				)
				(= temp6 0)
				(while (< temp6 2)
					(if (>= (= temp5 (localproc_0 temp4 temp3 temp6)) 0)
						(clr)
						(= local0 temp5)
						(gEgo posn: [local1 local0] [local19 local0])
						(RedrawCast)
						(showInfo changeState: (+ local0 1))
						(break)
					else
						(++ temp6)
					)
				)
			)
			(evSAID
				(cond
					((Said 'look/room,chart')
						(Print 103 0) ; "You see the Summer Lands, as your kingdom is often known, with Cornwall to the west and river Thames coming from the east."
					)
					((Said 'merlin,talk')
						(Print 103 1) ; "I am already speaking."
					)
				)
			)
		)
	)
)

(instance showInfo of Script
	(properties)

	(method (init)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(localproc_1 {ST. LEONARD'S FOREST} state)
			)
			(2
				(localproc_1 {WINDSOR} state)
			)
			(3
				(localproc_1 {OT MOOR} state)
			)
			(4
				(localproc_1 {AVEBURY} state)
			)
			(5
				(localproc_1 {MOTTISTONE} state)
			)
			(6
				(localproc_1 {BATH} state)
			)
			(7
				(localproc_1 {KEYNSHAM} state)
			)
			(8
				(localproc_1 {WINCHESTER} state)
			)
			(9
				(localproc_1 {SOUTHAMPTON} state)
			)
			(10
				(localproc_1 {CAMELOT} state)
			)
			(11
				(localproc_1 {GLASTONBURY TOR} state)
			)
			(12
				(localproc_1 {SHAPWICK} state)
			)
			(13
				(localproc_1 {HALSTOCK} state)
			)
			(14
				(localproc_1 {BRAUNTON} state)
			)
			(15
				(localproc_1 {HARTLAND POINT} state)
			)
			(16
				(localproc_1 {EXETER} state)
			)
			(17
				(localproc_1 {TOTNES} state)
			)
		)
	)
)

(instance travelTo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(Print 103 2) ; "St. Leonard is long gone from his Forest and of no use to you."
			)
			(2
				(Print 103 3) ; "The joys of hunting Windsor must wait for another time."
			)
			(3
				(gCurRoom newRoom: 24)
			)
			(4
				(Print 103 4) ; "There is nothing in ancient Avebury to help your search."
			)
			(5
				(Print 103 5) ; "These silent stones of Mottistone have no tale to tell."
			)
			(6
				(Print 103 6) ; "Let us hope you never have need of the healing waters of Bath."
			)
			(7
				(Print 103 7) ; "St. Keyne of Keynsham has no connection with the Grail."
			)
			(8
				(Print 103 8) ; "The bishop of Winchester may be a miracle worker, but not even he knows where the Grail may be."
			)
			(9
				(gCurRoom newRoom: 33)
			)
			(10
				(gCurRoom newRoom: 9)
			)
			(11
				(if (and (IsFlag 43) (!= gPrevRoomNum 10))
					(gCurRoom newRoom: 17)
				else
					(gCurRoom newRoom: 10)
				)
			)
			(12
				(Print 103 9) ; "The martyrs of Shapwick provide no clue."
			)
			(13
				(Print 103 10) ; "Avoid Halstock, where St. Juthware could not keep her head."
			)
			(14
				(Print 103 11) ; "There is nothing of worth to milk from Braunton."
			)
			(15
				(Print 103 12) ; "Neither Hercules nor Hartland Point will lead to the Grail."
			)
			(16
				(Print 103 13) ; "St. Sidwell's waters in Exeter will reveal nothing of use."
			)
			(17
				(Print 103 14) ; "Neither Brutus, his giants nor clue of the Grail are to be found in Totnes."
			)
		)
	)
)

