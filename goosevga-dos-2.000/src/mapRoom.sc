;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	mapRoom 0
)

(local
	local0
	[local1 2]
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
		(for ((= temp0 17)) (>= temp0 0) ((-- temp0))
			(if (not ((gGoals at: temp0) egoReturned:))
				(= local41 (* temp0 2))
				(themEggs
					add:
						((mouseProp new:)
							goal: temp0
							posn: [local4 local41] [local4 (++ local41)]
							init:
							yourself:
						)
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
		(MGHouse init: stopUpd:)
		(bakgndCloud init: hide:)
		(forgndCloud init: hide:)
		(flag1 setCycle: Fwd init: setScript: sparkle)
		(flag2 setCycle: Fwd init:)
		(flag3 setCycle: Fwd init:)
		(flag4 setCycle: Fwd init:)
		(= gDoInvBut doInvBut)
		(proc0_3)
	)

	(method (dispose)
		(= global104 0)
		(= gDoInvBut 0)
		(themEggs release: dispose:)
		(super dispose:)
	)
)

(instance sparkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 14))
			)
			(1
				(if local0
					(self changeState: 0)
				else
					(= local3 1)
					((= register
							(themEggs at: (+ (Random 1 (themEggs size:)) -1))
						)
						signal: 6
						setCycle: End self
					)
				)
			)
			(2
				(register setCycle: Beg self)
			)
			(3
				(= local3 0)
				(register signal: 257)
				(self changeState: 0)
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
				(= gDoInvBut 0)
				(egoLoc hide:)
				(client signal: (& (client signal:) $feff) startUpd:)
				(if (!= (client loop:) 6)
					(client setCycle: End self)
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
					(= temp0 (client goal:))
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
				(pairs posn: (client x:) (client y:) init:)
				(proc0_20)
				(if global119
					(if (!= (client loop:) 6)
						(Timer set60ths: self (DoAudio audPLAY (+ 505 temp0)))
					else
						(Timer set60ths: self (DoAudio audPLAY 523))
					)
				else
					(++ state)
				)
				(= ticks 120)
			)
			(3)
			(4
				(forgndCloud setCycle: Beg self)
			)
			(5
				(pairs dispose:)
				(forgndCloud hide:)
				(bakgndCloud setCycle: Beg self)
			)
			(6
				(bakgndCloud hide:)
				(if (!= (client loop:) 6)
					(client cel: (client lastCel:) setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(7
				(egoLoc show:)
				(= local0 0)
				(= global104 0)
				(client signal: 257)
				(if (not (sparkle seconds:))
					(sparkle changeState: 0)
				)
				(= gDoInvBut doInvBut)
				(self dispose:)
			)
		)
	)
)

(class mouseProp of Prop
	(properties
		view 640
		loop 1
		signal 4353
		goal 0
	)

	(method (doVerb)
		(if (not local0)
			(self setScript: propScript)
		)
	)
)

(class DoneProp of Prop
	(properties
		view 640
		loop 1
		signal 4353
		goal 0
	)

	(method (doVerb)
		(if (not local0)
			(localproc_0 goal)
		)
	)
)

(instance MGHouse of mouseProp
	(properties
		x 106
		y 132
		loop 6
	)
)

(instance bakgndCloud of Prop
	(properties
		view 640
		loop 2
		priority 13
		signal 16
		cycleSpeed 2
	)
)

(instance forgndCloud of Prop
	(properties
		view 640
		priority 15
		signal 16
		cycleSpeed 2
	)
)

(instance pairs of View
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
		cycleSpeed 15
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance doInvBut of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(if global130
			(for ((= temp0 0)) (<= temp0 (gCast size:)) ((++ temp0))
				(= temp2 (gCast at: temp0))
				(if
					(and
						(temp2 respondsTo: #goal)
						(== [local79 (temp2 goal:)] global130)
					)
					(break)
				)
			)
			(temp2 setScript: propScript)
		)
	)
)

(instance flag1 of Prop
	(properties
		x 112
		y 13
		view 640
		loop 7
		cycleSpeed 5
	)
)

(instance flag2 of Prop
	(properties
		x 122
		y 14
		view 640
		loop 9
		cycleSpeed 5
	)
)

(instance flag3 of Prop
	(properties
		x 143
		y 10
		view 640
		loop 7
		cycleSpeed 5
	)
)

(instance flag4 of Prop
	(properties
		x 153
		y 13
		view 640
		loop 8
		cycleSpeed 5
	)
)

(instance themEggs of List
	(properties)
)

