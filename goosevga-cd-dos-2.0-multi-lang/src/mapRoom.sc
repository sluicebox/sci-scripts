;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	mapRoom 0
)

(local
	local0
	local1
	local2
	local3
	[local4 36] = [53 66 76 104 45 110 210 121 211 72 246 44 180 104 116 44 88 59 130 30 169 71 243 102 160 138 20 47 74 133 25 93 148 44 130 80]
	local40
	local41
	[local42 35] = [18 65 104 129 150 169 238 18 49 89 129 165 214 238 18 50 86 129 167 205 238 18 43 79 130 170 212 238 18 40 69 105 155 196 238]
	local77
	local78
	[local79 18] = [42 44 45 46 47 48 49 50 51 52 41 54 55 56 57 58 59 60]
	[local97 18] = [9 41 23 27 13 7 43 3 36 37 12 21 33 1 31 15 5 18]
)

(procedure (localproc_0 param1)
	(= global173 (gEgo x:))
	(= global174 (gEgo y:))
	(for ((= global172 0)) (<= global172 17) ((++ global172))
		(if ((gGoals at: global172) egoHas:)
			(break)
		)
	)
	(if (< global172 18)
		((gGoals at: global172) egoHas: 0)
	)
	(if (== global130 60)
		(-= global114 300)
	)
	(++ global172)
	(= global175 gPrevRoomNum)
	(DisposeScript 608)
	(DisposeScript 603)
	(DisposeScript 609)
	(DisposeScript 604)
	(DisposeScript 606)
	(DisposeScript 605)
	((gGoals at: param1) egoHas: 1 egoReturned: 0)
	(= global130 [local79 param1])
	(= gCurRoomNum 0)
	(gCurRoom newRoom: [local97 param1])
)

(procedure (localproc_1)
	(= gPrevRoomNum global175)
	(if (< (-- global172) 18)
		(= global130 [local79 global172])
		((gGoals at: global172) egoHas: 1)
	)
	(if (== global130 60)
		(+= global114 300)
	)
	(= global172 0)
	(gEgo x: global173 y: global174)
)

(instance FindGoldBall of Code
	(properties)

	(method (doit param1)
		(if (not (StrCmp (param1 name:) {mouseProp}))
			(= local41 (* (- local1 1) 2))
			(if
				(and
					(not local0)
					(== (param1 x:) [local4 local41])
					(== (param1 y:) [local4 (++ local41)])
				)
				(param1 setScript: (if global162 propScript else sparkle))
			)
		)
	)
)

(instance mapRoom of Rm
	(properties
		picture 64
		style 0
	)

	(method (init &tmp temp0)
		(super init:)
		(if global172
			(localproc_1)
		)
		(cond
			(
				(<
					(= temp0
						(switch gPrevRoomNum
							(36 10)
							(37 4)
							(38 12)
							(39 13)
							(40 15)
							(41 24)
							(42 32)
							(43 26)
							(44 21)
							(else gPrevRoomNum)
						)
					)
					8
				)
				(= local77 37)
			)
			((< temp0 15)
				(= local77 62)
			)
			((< temp0 22)
				(= local77 84)
			)
			((< temp0 29)
				(= local77 110)
			)
			(else
				(= local77 137)
			)
		)
		(egoLoc
			posn: [local42 (- temp0 1)] local77
			setPri: 15
			setCycle: Fwd
			init:
		)
		(for ((= temp0 0)) (<= temp0 17) ((++ temp0))
			(if (not ((gGoals at: temp0) egoReturned:))
				(= local41 (* temp0 2))
				((mouseProp new:)
					goal: temp0
					posn: [local4 local41] [local4 (++ local41)]
					init:
				)
				(++ local40)
			else
				(= local41 (* temp0 2))
				((DoneProp new:)
					setLoop: (if (< temp0 13) 3 else 4)
					setCel:
						(if (< temp0 13)
							temp0
						else
							(- temp0 13)
						)
					goal: temp0
					posn: [local4 local41] [local4 (++ local41)]
					init:
				)
			)
		)
		(MGHouse init: stopUpd: hide:)
		(bakgndCloud init: hide:)
		(forgndCloud init: hide:)
		(pairs init: hide:)
		(flag1 setCycle: Fwd init:)
		(flag2 setCycle: Fwd init:)
		(flag3 setCycle: Fwd init:)
		(flag4 setCycle: Fwd init:)
		(proc0_3)
	)

	(method (doit &tmp temp0)
		(cond
			((== global162 1)
				(= local1 0)
				(if (not local0)
					(++ global162)
					(for ((= temp0 0)) (<= temp0 17) ((++ temp0))
						(if ((gGoals at: temp0) egoHas:)
							(= local1 (+ temp0 1))
							(gCast eachElementDo: #perform FindGoldBall)
						)
					)
				)
				(= global162 local1)
			)
			((and (not local0) (not local3) local40 (> (Random 1 200) 198))
				(= local1 local2)
				(while (== local1 local2)
					(if (> local40 1)
						(= local1 (Random 1 local40))
					else
						(= local1 1)
						(= local2 0)
					)
				)
				(= local2 local1)
				(gCast eachElementDo: #perform FindGoldBall)
			)
		)
	)

	(method (dispose)
		(= global104 0)
		(= global162 0)
		(super dispose:)
	)
)

(instance sparkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(client signal: 6 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(self dispose:)
				(= local3 0)
				(client signal: 257)
			)
		)
	)
)

(instance propScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global104 1)
				(egoLoc hide:)
				(client startUpd: signal: (& (client signal:) $feff))
				(if (!= (client loop:) 6)
					(client cycleSpeed: 1 setCycle: End self)
				else
					(= cycles 1)
				)
				(= local0 1)
			)
			(1
				(bakgndCloud
					posn: (client x:) (client y:)
					show:
					setCycle: End self
				)
			)
			(2
				(forgndCloud posn: (client x:) (client y:) setCycle: End show:)
				(if (!= (client loop:) 6)
					(for ((= temp0 0)) (<= temp0 17) ((++ temp0))
						(= local41 (* temp0 2))
						(breakif
							(and
								(== (client x:) [local4 local41])
								(== (client y:) [local4 (++ local41)])
							)
						)
					)
					(pairs
						loop: (if (< temp0 13) 3 else 4)
						cel:
							(if (< temp0 13)
								temp0
							else
								(- temp0 13)
							)
					)
				else
					(pairs loop: 4 cel: 5)
				)
				(pairs posn: (client x:) (client y:) show:)
				(proc0_20)
				(if (!= (client loop:) 6)
					(Timer set60ths: self (DoAudio audPLAY (+ 505 temp0)))
				else
					(Timer set60ths: self (DoAudio audPLAY 523))
				)
				(= cycles 10)
			)
			(3)
			(4
				(DoSound sndMASTER_VOLUME global125)
				(forgndCloud setCycle: Beg self)
			)
			(5
				(pairs hide:)
				(forgndCloud hide:)
				(bakgndCloud setCycle: Beg self)
			)
			(6
				(bakgndCloud hide:)
				(if (!= (client loop:) 6)
					(client
						cel: (client lastCel:)
						setCycle: Beg self
						setScript: 0
					)
				else
					(= cycles 1)
				)
			)
			(7
				(egoLoc show:)
				(= local0 0)
				(= global104 0)
				(= global162 0)
				(client signal: 257)
			)
		)
	)
)

(class mouseProp of Prop
	(properties
		view 640
		loop 1
		signal 257
		goal 0
	)

	(method (handleEvent event)
		(if (proc0_18 self event)
			(event claimed: 1)
			(if (not local0)
				(self setScript: propScript)
			)
		)
	)
)

(class DoneProp of Prop
	(properties
		view 640
		loop 1
		signal 257
		goal 0
	)

	(method (handleEvent event)
		(if (proc0_18 self event)
			(event claimed: 1)
			(if (not local0)
				(localproc_0 goal)
			)
		)
	)
)

(instance MGHouse of mouseProp
	(properties
		y 132
		x 106
		loop 6
	)
)

(instance bakgndCloud of Prop
	(properties
		view 640
		loop 2
		priority 13
		signal 16
	)
)

(instance forgndCloud of Prop
	(properties
		view 640
		priority 15
		signal 16
	)
)

(instance pairs of Prop
	(properties
		view 640
		priority 14
		signal 16
	)
)

(instance egoLoc of Prop
	(properties
		view 640
		loop 5
		cycleSpeed 4
	)
)

(instance flag1 of Prop
	(properties
		y 13
		x 112
		view 640
		loop 7
		cycleSpeed 4
	)
)

(instance flag2 of Prop
	(properties
		y 14
		x 122
		view 640
		loop 9
		cycleSpeed 4
	)
)

(instance flag3 of Prop
	(properties
		y 10
		x 143
		view 640
		loop 7
		cycleSpeed 4
	)
)

(instance flag4 of Prop
	(properties
		y 13
		x 153
		view 640
		loop 8
		cycleSpeed 4
	)
)

