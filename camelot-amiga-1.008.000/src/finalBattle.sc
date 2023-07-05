;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 133)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	finalBattle 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	[local34 11] = [0 1 2 2 2 1 4 0 4 1 0]
	local45
	[local46 5] = [6 6 6 6 8]
	[local51 3] = [1 4 4]
	[local54 20] = [0 2 1 1 1 2 1 0 1 2 0 0 0 0 0 0 0 0 0 0]
	[local74 9] = [9 1 8 7 6 5 4 3 2]
	[local83 9] = [9 1 2 3 4 5 6 7 8]
	[local92 17] = [8 0 2 2 2 0 3 -10 3 0 0 0 0 0 0 0 0]
	[local109 7] = [-59 -61 -54 0 -50 0 -50]
	[local116 7] = [47 48 42 0 45 0 45]
	[local123 11] = [50 0 60 60 60 30 90 40 90 20 80]
	[local134 11] = [50 20 60 60 60 20 90 40 90 0 80]
	[local145 11] = [50 30 60 60 60 0 90 40 90 20 80]
	[local156 11] = [50 0 60 60 60 30 90 40 90 20 80]
	[local167 11] = [50 30 60 60 60 0 90 40 90 20 80]
	local178
	local179
	[local180 6] = [3 2 2 2 10 -1]
	[local186 6] = [3 3 4 4 10 -1]
	[local192 6] = [2 2 4 4 10 -1]
	[local198 6] = [2 3 4 4 10 -1]
	[local204 6] = [4 4 2 2 10 -1]
	[local210 6] = [4 3 2 3 10 -1]
	local216
	local217
	local218
	local219
	local220
	local221
	local222
)

(procedure (localproc_0 &tmp temp0)
	(repeat
		(= temp0 (Event new:))
		(if (not (temp0 type:))
			(break)
		)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(= temp0
		(switch param1
			(2 [local123 param2])
			(3 [local134 param2])
			(4 [local145 param2])
			(8 [local156 param2])
			(6 [local167 param2])
			(else 50)
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(repeat
		(= temp0
			(switch local178
				(1 [local180 local179])
				(2 [local186 local179])
				(3 [local192 local179])
				(4 [local198 local179])
				(5 [local204 local179])
				(6 [local210 local179])
			)
		)
		(++ local179)
		(if (== temp0 -1)
			(= local178 (Random 1 6))
			(= local179 0)
		else
			(if (and (== global108 1) (Random 0 2) (> local18 (* local3 2)))
				(= temp0
					(cond
						((>= local15 (- local3 2)) 2)
						((>= local16 (- local3 2)) 3)
						(else 4)
					)
				)
				(continue)
			)
			(if (and (== temp0 11) (< local1 15))
				(= temp0 7)
			)
			(break)
		)
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(= temp0
		(switch global108
			(1 20)
			(2 10)
			(3 6)
		)
	)
	(= temp1
		(switch local31
			(2
				(cond
					((> (Random 1 temp0) 5) 1)
					((> (Random 1 temp0) 5) 9)
					(else 5)
				)
			)
			(4
				(cond
					((> (Random 1 temp0) 5) 5)
					((> (Random 1 temp0) 5) 9)
					(else 1)
				)
			)
			(else
				(cond
					((> (Random 1 temp0) 5) 9)
					((> (Random 1 temp0) 5) 5)
					(else 1)
				)
			)
		)
	)
)

(procedure (localproc_4 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 50])
	(= temp0 (param1 x:))
	(= temp2 0)
	(= temp1 0)
	(cond
		((> (Abs (- (param1 x:) (param2 x:))) 55)
			(= temp2 0)
		)
		(param5
			(= temp1
				(<=
					(+= temp0 [local109 (- (param1 loop:) 2)])
					(param2 x:)
					(+ temp0 20)
				)
			)
		)
		(else
			(= temp1
				(<=
					(- (+= temp0 [local116 (- (param1 loop:) 2)]) 20)
					(param2 x:)
					temp0
				)
			)
		)
	)
	(if temp1
		(= temp3 (localproc_1 param3 param4))
		(if param6
			(/= temp3 2)
		)
		(= temp4 (Random 0 100))
		(if (and (== param1 gEgo) (> (+= temp3 local12) 100))
			(= temp3 100)
		)
		(= temp2 (if (> temp3 temp4) 1 else 0))
	)
	(return temp2)
)

(procedure (localproc_5 param1)
	(gCurRoom drawPic: param1)
	(proc0_13 113)
	(switch param1
		(75
			(atp1 view: 175 loop: 0 cel: 0 x: 260 y: 118)
			(gAddToPics add: atp1)
		)
		(76
			(atp1 view: 176 6 0 cel: 0 x: 186 y: 128 priority: 1 signal: 16384)
			(atp2
				view: 176
				loop: 0
				cel: 1
				x: 186
				y: 128
				priority: 1
				signal: 16384
			)
			(gAddToPics add: atp1 atp2)
		)
	)
	(gAddToPics doit:)
)

(procedure (localproc_6 param1 param2 &tmp temp0 temp1 temp2)
	(if (> (= temp0 (- (param1 x:) (* param2 2))) (param1 x:))
		(= temp1 (param1 x:))
		(= temp2 temp0)
	else
		(= temp1 temp0)
		(= temp2 (param1 x:))
	)
	(return
		(& (OnControl CONTROL temp1 (- (param1 y:) 2) temp2 (+ (param1 y:) 2)) $c000)
	)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2)
	(if (> (= temp0 (- (param1 x:) (* param2 3))) (param1 x:))
		(= temp1 (param1 x:))
		(= temp2 temp0)
	else
		(= temp1 temp0)
		(= temp2 (param1 x:))
	)
	(return
		(& (OnControl CONTROL temp1 (- (param1 y:) 2) temp2 (+ (param1 y:) 2)) $c000)
	)
)

(procedure (localproc_8)
	(cond
		((and (not local221) (<= local5 8))
			(= local221 1)
			(Print 133 3) ; "You grow steadily weaker. Seek triumph from strategy, my king, as your strength wanes."
		)
		((and (not local222) (<= local5 3))
			(= local222 1)
			(Print 133 4) ; "Your death is near! You must win now or lose all."
		)
		((and (<= local5 0) (not local27))
			(= local27 1)
			(gEgo setScript: egoKeelsOver)
			(saracen setScript: 0)
		)
		((and (not local217) (< local0 8))
			(= local217 1)
			(Print 133 5) ; "Arthur, you are over-exerting yourself. Slow down, or you will lack the strength to fight."
		)
		((and (not local218) (<= local0 0))
			(= local218 1)
			(Print 133 6) ; "Your sword feels as heavy as lead. Defend yourself with your shield until some of your strength returns."
		)
		(
			(and
				(not local220)
				local25
				(> local0 8)
				(> local22 (* local4 2))
				(< local18 (* local3 2))
			)
			(= local220 1)
			(Print 133 7) ; "Excaliber flashes in your skilled hands. Victory is imminent!"
		)
		((and (not local219) local25 (> local0 8) (> local18 (- local4 2)))
			(= local219 1)
			(Print 133 8) ; "The Saracen weakens under your skillful attack. Keep fighting like this and you will be victorious."
		)
	)
)

(instance saracen of Act
	(properties)
)

(instance hitFlash of Prop
	(properties
		view 77
		loop 6
		priority 15
		signal 18448
	)

	(method (cue)
		(self dispose:)
	)
)

(instance fighterBaseSetter of Code
	(properties)

	(method (doit param1)
		(param1
			brTop: (- (param1 y:) 4)
			brBottom: (param1 y:)
			brLeft: (- (param1 x:) 12)
			brRight: (+ (param1 x:) 12)
		)
	)
)

(instance finalBattle of Rm
	(properties
		picture 75
	)

	(method (init)
		(Load rsVIEW 378)
		(Load rsVIEW 381)
		(Load rsVIEW 382)
		(Load rsVIEW 379)
		(Load rsVIEW 73)
		(Load rsVIEW 74)
		(Load rsVIEW 82)
		(Load rsVIEW 77)
		(if (== gPrevRoomNum 75)
			(Load rsPIC 75)
			(Load rsVIEW 175)
			(Load rsPIC 78)
			(Load rsVIEW 178)
		else
			(Load rsPIC 76)
			(Load rsVIEW 176)
			(Load rsPIC 77)
		)
		(Load rsSOUND 107)
		(Load rsSOUND 112)
		(Load rsSOUND 113)
		(Load rsSOUND (proc0_20 6))
		(super init:)
		(localproc_5 gPrevRoomNum)
		(saracen posn: global196 global197)
		(if (> (gEgo x:) global196)
			(= local45 1)
		else
			(= local45 0)
		)
		(gEgo
			view: (if local45 73 else 74)
			setLoop: 0
			cel: 0
			init:
			looper: 0
			illegalBits: 0
			baseSetter: fighterBaseSetter
			setScript: egoAttack
		)
		(saracen
			view: (if local45 378 else 381)
			init:
			baseSetter: fighterBaseSetter
			illegalBits: 0
			setScript: saracenAttack
		)
		(if (not (= local11 (gEgo priority:)))
			(= local11 8)
		)
		(MenuBar state: 0)
		(User canInput: 0)
		(= global109 6)
		(= local1 40)
		(= local4 8)
		(= local0 30)
		(= local3 6)
		(if (IsFlag 175)
			(+= local0 20)
			(+= local3 6)
		)
		(if (IsFlag 199)
			(+= local0 10)
			(+= local3 2)
		)
		(= local5 local0)
		(= local178 (Random 1 6))
		(= local179 0)
		(= local9 (= local8 1))
		(= local2 0)
		(= local27 0)
		(staminaUpdate seconds: 1)
		(= local216 (== global103 1))
		(gRmMusic number: 107 loop: -1 play:)
		(gSFX number: (proc0_20 6) loop: 1)
		(switch global108
			(3
				(-= local4 2)
				(+= local0 15)
				(= local12 30)
			)
			(2
				(= local12 15)
			)
			(1
				(= local12 0)
			)
		)
	)

	(method (dispose)
		(DisposeScript 969)
		(super dispose:)
	)

	(method (doit &tmp [temp0 100])
		(super doit:)
		(staminaUpdate doit:)
	)
)

(instance staminaUpdate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Wait 0)
				(= seconds 2)
			)
			(1
				(if (and global171 (> (++ local2) 4))
					(= local2 0)
					(-- local5)
				)
				(if (and (not local6) (< local0 local5))
					(++ local0)
				)
				(if (and (not local7) (< local1 40))
					(++ local1)
				)
				(gEgo
					cycleSpeed:
						(cond
							((<= local0 12) 1)
							((<= local0 6) 2)
							(else 0)
						)
				)
				(= local9 (+ (gEgo cycleSpeed:) 1))
				(saracen
					cycleSpeed:
						(cond
							((<= local1 12) 1)
							((<= local1 6) 2)
							(else 0)
						)
				)
				(= local8 (+ (saracen cycleSpeed:) 1))
				(= local6 0)
				(= local7 0)
				(self changeState: 0)
			)
		)
	)
)

(instance egoAttack of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			($0040 ; direction
				(event claimed: 1)
				(if (not local29)
					(= local29 1)
					(= local31
						(if local45
							[local74 (event message:)]
						else
							[local83 (event message:)]
						)
					)
					(self changeState: 0)
				)
			)
			(evMOUSEBUTTON
				(event claimed: 1)
			)
			(evKEYBOARD
				(= temp0 (event message:))
				(if (>= KEY_z temp0 KEY_a)
					(+= temp0 $ffe0)
				)
				(= temp1 -1)
				(switch temp0
					(KEY_U
						(= temp1 8)
					)
					(KEY_I
						(= temp1 1)
					)
					(KEY_O
						(= temp1 2)
					)
					(KEY_J
						(= temp1 7)
					)
					(KEY_K
						(= temp1 0)
					)
					(KEY_L
						(= temp1 3)
					)
					(KEY_M
						(= temp1 6)
					)
					(KEY_SNAPSHOT
						(= temp1 5)
					)
					($003c ; <
						(= temp1 5)
					)
					(KEY_DECIMAL
						(= temp1 4)
					)
					($003e ; >
						(= temp1 4)
					)
					(KEY_R
						(event claimed: 1)
						(cond
							(local29 0)
							(
								(or
									(> (Abs (- (gEgo x:) (saracen x:))) 55)
									(< local0 5)
								)
								0
							)
							((localproc_7 gEgo (if local45 -10 else 10)) 0)
							(local45
								(-= local0 4)
								(gCurRoom setScript: rotateUp)
							)
							(else
								(-= local0 4)
								(gCurRoom setScript: rotateDown)
							)
						)
					)
				)
				(if (and (!= temp1 -1) (not local29))
					(= local29 1)
					(= local31
						(if local45 [local74 temp1] else [local83 temp1])
					)
					(self changeState: 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(switch state
			(-1
				(if
					(and
						(not local29)
						(or
							(not local26)
							(and
								local26
								(> (Abs (- (gEgo x:) (saracen x:))) 80)
							)
						)
						(> (Abs (- (gEgo x:) (saracen x:))) 55)
						(> local0 6)
					)
					(= local31 0)
					(= local33 0)
					(= local29 1)
					(self changeState: 1)
				)
			)
			(3
				(if (and (== local33 2) (!= local32 1))
					(= cycles 0)
					(self cue:)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 [temp2 3] temp5)
		(switch (= state newState)
			(0
				(gEgo setLoop: local31 cel: 0)
				(= local26 0)
				(if (== (= local33 [local54 local31]) 2)
					(gEgo cel: 1)
				)
				(if (and (<= local0 0) (== local33 1))
					(self changeState: 4)
				else
					(gGame setCursor: gWaitCursor 1)
					(= cycles (* [local51 local33] local9))
					(if local216
						(= cycles (+ (/ cycles 2) 1))
					)
				)
			)
			(1
				(= local6 (if (== local33 1) 1 else 0))
				(= local13 [local92 local31])
				(if (not local45)
					(= local13 (- 0 local13))
				)
				(cond
					((== local33 2)
						(self changeState: 3)
					)
					((== local31 0)
						(gEgo setLoop: 7 setCel: 255 setCycle: Beg self)
					)
					((== local33 1)
						(if (or (== local31 8) (== local31 6))
							(gEgo
								setCycle: CT (- (gEgo lastCel:) 1) 1 self
							)
						else
							(= cycles 3)
							(gEgo cel: 1)
						)
					)
					(else
						(gEgo setCycle: End self)
					)
				)
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(if
					(and
						(< (Abs (- temp0 (saracen x:))) 40)
						(or
							(and local45 (> local13 0))
							(and (not local45) (< local13 0))
						)
					)
					(= local13 0)
				)
				(cond
					((and local13 (!= local33 0))
						(gEgo setMotion: MoveTo (- temp0 local13) temp1)
					)
					((== local31 7)
						(if
							(or
								(localproc_6 gEgo local13)
								(> (Abs (- (gEgo x:) (saracen x:))) 80)
							)
							(= local13 0)
							(self changeState: 4)
						else
							(= local26 1)
						)
					)
					((== local31 0)
						(gEgo posn: (- temp0 local13) temp1)
					)
				)
			)
			(2
				(if (== local33 1)
					(= local23
						(localproc_4
							gEgo
							saracen
							local31
							local30
							local45
							local24
						)
					)
					(if
						(or
							(and local45 local23)
							(and (not local45) (not local23))
						)
						(gEgo setPri: (+ local11 1))
					else
						(gEgo setPri: (- local11 1))
					)
					(gEgo setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(-= local0 [local34 local31])
				(cond
					((== local33 2)
						(if (!= local32 1)
							(= cycles 1)
						else
							(= cycles 6)
						)
					)
					((!= local33 1)
						(= cycles 2)
					)
					((not local23)
						(= local25 0)
						(gEgo setCycle: Beg self)
					)
					(else
						(= local25 1)
						(= temp5
							(cond
								((or (== local31 2) (== local31 8))
									(Random 35 45)
								)
								((== local31 3)
									(Random 24 30)
								)
								(else
									(Random 15 20)
								)
							)
						)
						(gSFX play:)
						(saracen
							posn:
								(+ (saracen x:) (if local45 4 else -4))
								(saracen y:)
						)
						(hitFlash
							init:
							posn: (saracen x:) (- (saracen y:) temp5)
							setCel: 0
							setCycle: End hitFlash
						)
						(switch local31
							(2
								(+= local19 1)
							)
							(8
								(+= local19 2)
							)
							(3
								(+= local20 1)
							)
							(4
								(+= local21 1)
							)
							(6
								(+= local21 2)
							)
						)
						(++ local22)
						(if
							(not
								(= local28
									(cond
										((> local19 local4) 1)
										((> local20 local4) 2)
										((> local21 local4) 3)
										(else 0)
									)
								)
							)
							(gEgo setCycle: Beg self)
						else
							(self changeState: 5)
						)
					)
				)
			)
			(4
				(gGame setCursor: gNormalCursor (HaveMouse))
				(localproc_0)
				(if (== local31 7)
					(gEgo posn: (- (gEgo x:) local13) (gEgo y:))
				)
				(= cycles 0)
				(= local31 -1)
				(= local33 0)
				(= local24 0)
				(localproc_8)
				(= local25 0)
				(gEgo
					setLoop: 0
					cel: 0
					setCycle: 0
					setMotion: 0
					setPri: local11
				)
				(= local29 0)
				(= state -1)
				(if (or (< (gEgo x:) 30) (> (gEgo x:) 290))
					(gCurRoom setScript: moveToNewRoom)
				)
			)
			(5
				(gEgo setLoop: 0 cel: 0)
				(saracen setScript: 0)
				(saracen
					view: 379
					loop: (+ (if local45 3 else 0) (- local28 1))
					cel: 0
					cycleSpeed: 3
					illegalBits: -32768
					setCycle: End
					setMotion: 0
				)
				(gRmMusic stop: number: 113 loop: 1 play:)
				(= seconds 5)
			)
			(6
				(SetFlag 207)
				(self setScript: 0)
				(MenuBar state: 1)
				(+=
					global210
					(switch global108
						(1 40)
						(2 30)
						(3 20)
					)
				)
				(gCurRoom setScript: saracenKilled)
			)
		)
	)
)

(instance saracenAttack of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(or (== state -1) (== state 0))
				(== local33 1)
				(or (== local30 10) (== local30 11))
				(<= (Abs (- (gEgo x:) (saracen x:))) 55)
			)
			(= cycles 0)
			(self changeState: 0)
		)
	)

	(method (changeState newState &tmp [temp0 41] temp41 temp42 temp43 [temp44 3] temp47 temp48)
		(switch (= state newState)
			(0
				(= local32
					[local54
						(= local30
							(cond
								(
									(>
										(= temp48
											(Abs (- (gEgo x:) (saracen x:)))
										)
										55
									)
									(if (or (> local1 8) (== (Random 1 4) 1))
										0
									else
										10
									)
								)
								((and (== local33 1) (>= (Random 1 10) 3))
									(localproc_3)
								)
								((== (Random 1 5) 3) 11)
								((<= local1 8)
									(if
										(and
											(< temp48 55)
											(not
												(localproc_6
													saracen
													(if local45 -8 else 8)
												)
											)
											(Random 0 1)
										)
										7
									else
										10
									)
								)
								((and (> local1 8) (== (Random 1 8) 8))
									(if (Random 0 1) 8 else 6)
								)
								((>= (Random 1 10) 6)
									(= temp47 (localproc_2))
								)
								(else 11)
							)
						)
					]
				)
				(cond
					((== local30 11)
						(-- state)
						(= cycles (Random 2 3))
					)
					((== local30 10)
						(-- state)
						(= cycles (Random 10 12))
					)
					((== local32 2)
						(= cycles (+ (Random 2 4) local9))
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(saracen setLoop: local30)
				(if (== local32 2)
					(saracen cel: 1)
				)
				(= cycles (* [local51 local32] local8))
				(if local216
					(= cycles (+ (/ cycles 2) 1))
				)
			)
			(2
				(= local7 (if (== local32 1) 1 else 0))
				(= local14 [local92 local30])
				(if (not local45)
					(= local14 (- 0 local14))
				)
				(cond
					((== local32 2)
						(self changeState: 4)
					)
					((== local30 0)
						(saracen setLoop: 7 setCel: 255 setCycle: Beg self)
						(= local14 (if local45 8 else -8))
					)
					((== local32 1)
						(if (or (== local30 8) (== local30 6))
							(saracen
								setCycle: CT (- (saracen lastCel:) 1) 1 self
							)
						else
							(= cycles 3)
							(saracen cel: 1)
						)
					)
					((== local30 7)
						(if (localproc_6 saracen local14)
							(self changeState: 5)
						else
							(saracen setCycle: End self)
						)
					)
					(else
						(saracen setCycle: End self)
					)
				)
				(= temp41 (saracen x:))
				(= temp42 (saracen y:))
				(if
					(and
						(< (Abs (- (gEgo x:) temp41)) 40)
						(or
							(and local45 (> local14 0))
							(and (not local45) (< local14 0))
						)
					)
					(= local14 0)
				)
				(cond
					((and local14 (!= local32 0))
						(saracen setMotion: MoveTo (+ temp41 local14) temp42)
					)
					((== local30 0)
						(saracen posn: (+ temp41 local14) temp42)
					)
				)
			)
			(3
				(if (== local32 1)
					(= local24
						(localproc_4
							saracen
							gEgo
							local30
							local31
							(not local45)
							local23
						)
					)
					(if
						(or
							(and local45 local24)
							(and (not local45) (not local24))
						)
						(saracen setPri: (- local11 1))
					else
						(saracen setPri: (+ local11 1))
					)
					(saracen setCycle: End self)
				else
					(self cue:)
				)
			)
			(4
				(-= local1 [local34 local30])
				(cond
					((== local32 2)
						(if (!= local33 1)
							(= cycles 1)
						else
							(= cycles (+ 6 local9))
						)
					)
					((!= local32 1)
						(= cycles 2)
					)
					((not local24)
						(saracen setCycle: Beg self)
					)
					(else
						(= temp43
							(cond
								((or (== local30 2) (== local30 8))
									(Random 35 45)
								)
								((== local30 3)
									(Random 26 30)
								)
								(else
									(Random 18 22)
								)
							)
						)
						(gSFX play:)
						(gEgo
							posn:
								(+ (gEgo x:) (if local45 4 else -4))
								(gEgo y:)
						)
						(hitFlash
							init:
							posn:
								(+ (gEgo x:) (if local45 5 else -5))
								(- (gEgo y:) temp43)
							setCel: 0
							setCycle: End hitFlash
						)
						(switch local30
							(2
								(+= local15 1)
							)
							(8
								(+= local15 2)
							)
							(3
								(+= local16 1)
							)
							(4
								(+= local17 1)
							)
							(6
								(+= local17 2)
							)
						)
						(++ local18)
						(if
							(not
								(= local28
									(cond
										((> local15 local3) 1)
										((> local16 local3) 2)
										((> local17 local3) 3)
										(else 0)
									)
								)
							)
							(saracen setCycle: Beg self)
						else
							(self changeState: 6)
						)
					)
				)
			)
			(5
				(if (== local30 7)
					(saracen posn: (+ (saracen x:) local14) (saracen y:))
				)
				(= local30 -1)
				(= local23 0)
				(saracen
					setLoop: 0
					cel: 0
					setCycle: 0
					setMotion: 0
					setPri: local11
				)
				(if (or (< (saracen x:) 30) (> (saracen x:) 290))
					(gCurRoom setScript: moveToNewRoom)
				else
					(= state -1)
					(= cycles (Random 2 4))
				)
			)
			(6
				(if (not local27)
					(HandsOff)
					(= local27 1)
					(saracen setLoop: 0 cel: 0)
					(= local31 -1)
					(gEgo setScript: 0 setMotion: 0)
					(gEgo
						view: 77
						loop: (+ (if local45 0 else 3) (- local28 1))
						cel: 0
						cycleSpeed: 3
						illegalBits: -32768
						setCycle: End
						setMotion: 0
					)
					(gRmMusic stop: number: 112 loop: 1 play:)
					(= seconds 5)
				)
			)
			(7
				(EgoDead 133 0) ; "You have been hacked to death by the Saracen. Let us hope you will be a better swordsman in your next life."
			)
		)
	)
)

(instance moveToNewRoom of Script
	(properties)

	(method (doit)
		(super doit:)
		(switch state
			(0
				(if (and (not (gEgo script:)) (not (saracen script:)))
					(self cue:)
				)
			)
			(1
				(if (and (not (gEgo script:)) (not (saracen script:)))
					(self cue:)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gGame setCursor: gWaitCursor 1)
				(saracen setLoop: 7 cel: 0 setMotion: 0 setScript: 0)
				(gEgo setLoop: 7 cel: 0 setMotion: 0 setScript: 0)
				(if (< (gEgo x:) 150)
					(= local10 (if local45 0 else 7))
				else
					(= local10 (if local45 7 else 0))
				)
				(if
					(or
						(and local45 (== local10 7))
						(and (not local45) (== local10 0))
					)
					(= local13 3)
				else
					(= local13 -3)
				)
				(advanceFighter register: local13)
				(retreatFighter register: local13)
				(if (== local10 7)
					(gEgo setScript: retreatFighter)
					(saracen setScript: advanceFighter)
				else
					(gEgo setScript: advanceFighter)
					(saracen setScript: retreatFighter)
				)
			)
			(1
				(localproc_5
					(switch (gCurRoom curPic:)
						(76 77)
						(77 76)
						(75 78)
						(78 75)
					)
				)
				(if (< (gEgo x:) 150)
					(gEgo x: (if local45 340 else 280))
					(saracen x: (if local45 280 else 340))
				else
					(gEgo x: (if local45 60 else 0))
					(saracen x: (if local45 0 else 60))
				)
				(if
					(or
						(and local45 (== local10 7))
						(and (not local45) (== local10 0))
					)
					(= local13 6)
				else
					(= local13 -6)
				)
				(advanceFighter register: local13)
				(retreatFighter register: local13)
				(if (== local10 7)
					(gEgo setScript: retreatFighter)
					(saracen setScript: advanceFighter)
				else
					(gEgo setScript: advanceFighter)
					(saracen setScript: retreatFighter)
				)
			)
			(2
				(saracen
					setLoop: -1
					loop: 0
					cel: 0
					setCycle: 0
					setMotion: 0
					setScript: saracenAttack
				)
				(gEgo
					setLoop: -1
					loop: 0
					cel: 0
					setCycle: 0
					setMotion: 0
					setScript: egoAttack
				)
				(= local31 local10)
				(= local30 (if (== local10 0) 7 else 0))
				(= local29 0)
				(localproc_0)
				(User canControl: 1)
				(= local13 0)
				(= local14 0)
				(gGame setCursor: gNormalCursor (HaveMouse))
				(client setScript: 0)
			)
		)
	)
)

(instance advanceFighter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setCel: 255
					setCycle: Beg self
					posn:
						(+ (client x:) (if (>= register 0) 10 else -10))
						(client y:)
				)
			)
			(1
				(= cycles 3)
			)
			(2
				(cond
					((> register 0)
						(-- register)
					)
					((< register 0)
						(++ register)
					)
					(else
						(client setScript: 0)
					)
				)
				(if (client script:)
					(self changeState: 0)
				)
			)
		)
	)
)

(instance retreatFighter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: -1 cel: -1 setCycle: End self)
			)
			(1
				(client
					setCel: 0
					posn:
						(+ (client x:) (if (>= register 0) 10 else -10))
						(client y:)
				)
				(= cycles 3)
			)
			(2
				(cond
					((> register 0)
						(-- register)
					)
					((< register 0)
						(++ register)
					)
					(else
						(client setScript: 0)
					)
				)
				(if (client script:)
					(self changeState: 0)
				)
			)
		)
	)
)

(instance rotateUp of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 4) (not (gEgo script:)) (not (saracen script:)))
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setScript: 0)
				(gGame setCursor: gWaitCursor 1)
				(User canControl: 0)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 82
					loop: 0
					cel: 5
					setStep: 6 3
					setCycle: 0
					ignoreActors:
				)
				(saracen
					view: 382
					loop: 1
					cel: 0
					setStep: 6 3
					setCycle: 0
					ignoreActors:
					setScript: 0
				)
				(= register 0)
				(= cycles 1)
			)
			(2
				(if (< register 5)
					(-- state)
					(= temp0 (- 5 register))
					(gEgo
						cel: temp0
						posn: (- (gEgo x:) [local46 temp0]) (gEgo y:)
					)
					(saracen
						cel: register
						posn: (+ (saracen x:) [local46 register]) (saracen y:)
					)
				)
				(= cycles 2)
				(++ register)
			)
			(3
				(= local45 0)
				(gEgo
					view: 74
					loop: 0
					cel: 0
					setStep: 3 2
					ignoreActors: 0
					posn: (- (gEgo x:) 18) (gEgo y:)
					setMotion: 0
				)
				(saracen
					view: 381
					loop: 0
					cel: 0
					setStep: 3 2
					ignoreActors: 0
					posn: (+ (saracen x:) 10) (saracen y:)
					setMotion: 0
				)
				(= seconds 1)
			)
			(4
				(retreatFighter register: 1)
				(gEgo setScript: retreatFighter)
				(advanceFighter register: 1)
				(saracen setScript: advanceFighter)
			)
			(5
				(gEgo setScript: egoAttack)
				(saracen setScript: saracenAttack)
				(= local31 7)
				(= local30 0)
				(= local29 0)
				(localproc_0)
				(gGame setCursor: gNormalCursor (HaveMouse))
				(User canControl: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance rotateDown of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 4) (not (gEgo script:)) (not (saracen script:)))
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setScript: 0)
				(gGame setCursor: gWaitCursor 1)
				(User canControl: 0)
				(= cycles 2)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(User canControl: 0)
				(gEgo
					view: 82
					loop: 1
					cel: 0
					setStep: 6 3
					setCycle: 0
					ignoreActors:
					setScript: 0
				)
				(saracen
					view: 382
					loop: 0
					cel: 5
					setStep: 6 3
					setCycle: 0
					ignoreActors:
					setScript: 0
				)
				(= register 0)
				(= cycles 2)
			)
			(2
				(if (< register 5)
					(-- state)
					(= temp0 (- 5 register))
					(gEgo
						cel: register
						posn: (+ (gEgo x:) [local46 register]) (gEgo y:)
					)
					(saracen
						cel: temp0
						posn: (- (saracen x:) [local46 temp0]) (saracen y:)
					)
				)
				(= cycles 2)
				(++ register)
			)
			(3
				(= local45 1)
				(gEgo
					view: 73
					loop: 0
					cel: 0
					setStep: 3 2
					ignoreActors: 0
					posn: (+ (gEgo x:) 10) (gEgo y:)
					setMotion: 0
				)
				(saracen
					view: 378
					loop: 0
					cel: 0
					setStep: 3 2
					ignoreActors: 0
					posn: (- (saracen x:) 18) (saracen y:)
					setMotion: 0
				)
				(= seconds 1)
			)
			(4
				(retreatFighter register: 1)
				(gEgo setScript: retreatFighter)
				(advanceFighter register: 1)
				(saracen setScript: advanceFighter)
			)
			(5
				(gEgo setScript: egoAttack)
				(saracen setScript: saracenAttack)
				(= local31 7)
				(= local30 0)
				(= local29 0)
				(localproc_0)
				(gGame setCursor: gNormalCursor (HaveMouse))
				(User canControl: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance egoKeelsOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(gRmMusic stop: number: 112 loop: 1 play:)
				(gEgo
					view: 77
					loop: (if local45 1 else 4)
					setCel: 0
					cycleSpeed: 3
					illegalBits: -32768
					setCycle: End self
					setMotion: 0
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(EgoDead 133 1) ; "Ah. The rat's poison has caught up with you. You have lost your desperate battle against time. Now, you shall have eternity to regret it."
			)
		)
	)
)

(instance theHelm of Prop
	(properties
		view 88
		loop 4
	)
)

(instance helmFlash of Prop
	(properties
		view 88
		loop 2
	)
)

(instance saracenKilled of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not (self script:)))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(saracen hide:)
				(= global196 (saracen x:))
				(= global197 (saracen y:))
				(= global179 (saracen loop:))
				(self setScript: (ScriptID 202 0)) ; saracenDead
			)
			(1
				(DisposeScript 202)
				(gEgo
					view: 656
					loop: (if local45 1 else 0)
					setCel: 255
					setCycle: Beg self
				)
			)
			(2
				(if (gEgo loop:)
					(theHelm posn: (- (gEgo x:) 12) (- (gEgo y:) 29))
				else
					(theHelm posn: (+ (gEgo x:) 14) (- (gEgo y:) 30))
				)
				(helmFlash
					posn: (theHelm x:) (theHelm y:)
					setPri:
						(+ (gEgo priority:) (if (gEgo loop:) -2 else 1))
					init:
					setCycle: End self
				)
				(theHelm setPri: (+ (helmFlash priority:) 1) init:)
			)
			(3
				(gEgo view: 0 cel: 0)
				(theHelm dispose:)
				(helmFlash loop: 3 cel: 5 setCycle: Beg self)
			)
			(4
				(helmFlash loop: 2 cel: 2 setCycle: Beg self)
			)
			(5
				(helmFlash dispose:)
				(gEgo view: 0 loop: (if local45 1 else 0) setCycle: Walk)
				(= seconds 3)
			)
			(6
				(Print 133 2) ; "Now that the fight is over, the helmet also disappears."
				(gCurRoom newRoom: (gCurRoom curPic:))
			)
		)
	)
)

(instance atp1 of PV
	(properties)
)

(instance atp2 of PV
	(properties)
)

