;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use CursorCoords)
(use Jump)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	introRm 0
)

(local
	local0
	local1
	[local2 5] = [59 103 145 188 233]
	local7 = 1
	local8
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (= temp0 (GetTime 1))) ; SysTime12
	(while param1
		(= temp2 (Event new:))
		(MenuBar handleEvent: temp2)
		(if
			(and
				(not (temp2 claimed:))
				(or
					(== (temp2 type:) evMOUSEBUTTON)
					(and
						(== (temp2 type:) evKEYBOARD)
						(or
							(== (temp2 message:) KEY_INSERT)
							(== (temp2 message:) KEY_RETURN)
						)
					)
				)
			)
			(temp2 dispose:)
			(proc0_7 128 1 2 3 4 5 6 8 9 10 11 12 13 14 15 16 17 18 19)
			(introRm newRoom: 101) ; selectRoom
			(return)
		)
		(temp2 dispose:)
		(= temp0 (GetTime 1)) ; SysTime12
		(if (or (!= temp1 temp0) (not param1))
			(= temp1 temp0)
			(if (not (-- param1))
				(if (== argc 2)
					(param2 cue:)
					(continue)
				)
			else
				(continue)
			)
		else
			(continue)
		)
		(return)
	)
)

(class CT of Cycle
	(properties
		endCel 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(super init: param1)
		(= cycleDir param3)
		(if (== argc 4)
			(= caller param4)
		)
		(= temp0 (client lastCel:))
		(= endCel (if (> param2 temp0) temp0 else param2))
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (client lastCel:))
		(if (> endCel temp1)
			(= endCel temp1)
		)
		(= temp0 (self nextCel:))
		(client
			cel:
				(cond
					((> temp0 temp1) 0)
					((< temp0 0) temp1)
					(else temp0)
				)
		)
		(if (and (== cycleCnt 0) (== endCel (client cel:)))
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(if caller
			(= global58 1)
		else
			(self motionCue:)
		)
	)
)

(class End of CT
	(properties)

	(method (init param1 param2)
		(super init: param1 (param1 lastCel:) 1 (if (== argc 2) param2 else 0))
	)
)

(instance introRm of Rm
	(properties
		picture 100
	)

	(method (init)
		((= global517 inList) add:)
		(Load rsVIEW 500)
		(Load rsVIEW 503)
		(Load rsVIEW 502)
		(Load rsVIEW 501)
		(super init:)
		(cards init: setPri: 10 addToPic:)
		(chips init: setPri: 12 addToPic:)
		(Title1 init:)
		(Title2 init:)
		(firstName init:)
		(lastName init:)
		(= global506 1)
	)

	(method (doit)
		(super doit:)
		(if local7
			(= local7 0)
			(switch local8
				(0
					((= local0 (Clone crd1))
						posn: -20 232
						init:
						setMotion: JumpTo [local2 local1] 20
						setCycle: End self
					)
				)
				(1
					(local0 setLoop: 1 setCycle: End self)
				)
				(2
					(local0 setLoop: 2 setCycle: End self)
				)
				(3
					(local0 setLoop: 3 setCycle: End self)
				)
				(4
					(local0 setLoop: 4 setCycle: End self)
				)
				(5
					(local0 view: 502 setLoop: 0 setCycle: End self)
				)
				(6
					(local0 view: 503 setLoop: local1 setCycle: End self)
				)
				(7
					(local0 addToPic:)
					(if (<= (++ local1) 4)
						(= local7 1)
						(= local8 0)
					else
						(volume1 setLoop: 5 setPri: 14 init:)
						(self cue:)
					)
				)
				(8
					(Title1 setLoop: 0 cel: 0 show:)
					(Title2 setLoop: 0 cel: 1 show:)
					(firstName setLoop: 9 cel: 2 show:)
					(lastName setLoop: 9 cel: 3 show:)
					(localproc_0 2 self)
				)
				(9
					(Title1 setLoop: 0 cel: 1)
					(Title2 hide:)
					(firstName setLoop: 9 cel: 0)
					(lastName setLoop: 9 cel: 1)
					(localproc_0 2 self)
				)
				(10
					(Title1 setLoop: 1 cel: 1)
					(firstName setLoop: 5 cel: 0)
					(lastName setLoop: 5 cel: 1)
					(localproc_0 2 self)
				)
				(11
					(Title1 setLoop: 2 cel: 0)
					(localproc_0 2 self)
				)
				(12
					(firstName setLoop: 5 cel: 4)
					(lastName setLoop: 5 cel: 5)
					(localproc_0 2 self)
				)
				(13
					(Title1 setLoop: 2 cel: 2)
					(Title2 setLoop: 2 cel: 3 show:)
					(firstName setLoop: 5 cel: 6)
					(lastName setLoop: 5 cel: 7)
					(localproc_0 2 self)
				)
				(14
					(firstName setLoop: 5 cel: 8)
					(lastName hide:)
					(localproc_0 2 self)
				)
				(15
					(Title1 setLoop: 3 cel: 0)
					(Title2 setLoop: 3 cel: 1 show:)
					(firstName setLoop: 6 cel: 0)
					(lastName setLoop: 6 cel: 1)
					(lastName show:)
					(localproc_0 2 self)
				)
				(16
					(firstName setLoop: 7 cel: 0)
					(lastName setLoop: 7 cel: 1)
					(localproc_0 2 self)
				)
				(17
					(firstName setLoop: 5 cel: 0)
					(lastName setLoop: 5 cel: 1)
					(localproc_0 2 self)
				)
				(18
					(Title1 setLoop: 1 cel: 2)
					(Title2 setLoop: 1 cel: 3)
					(firstName setLoop: 9 cel: 4)
					(lastName setLoop: 9 cel: 5)
					(localproc_0 2 self)
				)
				(19
					(Title1 setLoop: 4 cel: 0)
					(Title2 setLoop: 4 cel: 1)
					(firstName setLoop: 8 cel: 0)
					(lastName setLoop: 8 cel: 1)
					(localproc_0 2 self)
				)
				(20
					(firstName setLoop: 8 cel: 2)
					(lastName setLoop: 8 cel: 3)
					(localproc_0 2 self)
				)
				(21
					(firstName setLoop: 8 cel: 4)
					(lastName setLoop: 8 cel: 5)
					(localproc_0 2 self)
				)
				(22
					(firstName setLoop: 8 cel: 6)
					(lastName setLoop: 8 cel: 7)
					(localproc_0 2 self)
				)
				(23
					(Title1 setLoop: 1 cel: 0)
					(Title2 hide:)
					(firstName setLoop: 7 cel: 2)
					(lastName setLoop: 7 cel: 3)
					(localproc_0 2 self)
				)
				(24
					(firstName setLoop: 7 cel: 4)
					(lastName setLoop: 7 cel: 5)
					(localproc_0 2 self)
				)
				(25
					(Title1 hide:)
					(Title2 hide:)
					(firstName hide:)
					(lastName hide:)
					(localproc_0 2 self)
				)
				(26
					(localproc_0 2)
					(gCurRoom newRoom: 900 1) ; aRoom
				)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
			)
			(event claimed: 1)
			(proc0_7 128 1 2 3 4 5 6 8 9 10 11 12 13 14 15 16 17 18 19)
			(self newRoom: 101) ; selectRoom
		)
	)

	(method (cue)
		(++ local8)
		(= local7 1)
	)

	(method (dispose)
		(DisposeScript 991)
		(global517 empty: dispose:)
		(DisposeScript 891)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== argc 1)
			(Title1 setLoop: 3 cel: 2 init: show:)
			(Title2 hide:)
			(firstName hide:)
			(lastName hide:)
			(proc0_5)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance volume1 of View
	(properties
		y 70
		x 160
		view 503
	)
)

(instance chips of View
	(properties
		y 143
		x 172
		view 500
	)
)

(instance cards of View
	(properties
		y 178
		x 155
		view 500
		cel 1
	)
)

(instance crd1 of Act
	(properties
		y 220
		view 501
		priority 14
	)
)

(instance Title1 of View
	(properties
		y 110
		x 211
		view 601
		loop 1
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance Title2 of View
	(properties
		y 119
		x 234
		view 601
		loop 1
		cel 1
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance firstName of View
	(properties
		y 132
		x 235
		view 601
		loop 5
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance lastName of View
	(properties
		y 142
		x 252
		view 601
		loop 5
		cel 1
	)

	(method (init)
		(super init:)
		(self hide:)
	)
)

(instance inList of InputList
	(properties)
)

