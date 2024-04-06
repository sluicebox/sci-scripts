;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use PAvoider)
(use StopWalk)
(use Inventory)
(use User)
(use System)

(public
	HandsOff 1
	HandsOn 2
	SetFlag 3
	ClearFlag 4
	IsFlag 5
	NormalEgo 6
	proc10_7 7
	Face 9
	proc10_11 11
	proc10_12 12
	proc10_13 13
	proc10_14 14
	proc10_15 15
	proc10_16 16
	proc10_17 17
	proc10_18 18
	proc10_19 19
	proc10_20 20
	proc10_21 21
	proc10_22 22
	proc10_23 23
	proc10_24 24
	proc10_25 25
	proc10_26 26
	proc10_27 27
	proc10_28 28
	proc10_29 29
)

(procedure (HandsOff)
	(if (not global100)
		(= global100 0)
		(User canControl: 0 canInput: 0)
		(gEgo setMotion: 0)
		(gTheIconBar disable: 0 1 2 3 4 5 6)
		(gTheIconBar curIcon: (gTheIconBar at: 0))
		(gGame setCursor: 996 1)
		(if global147
			(gTheIconBar show:)
		)
	)
	(++ global100)
)

(procedure (HandsOn param1)
	(if (and argc param1)
		(= global100 1)
	)
	(if (<= (-- global100) 0)
		(= global100 0)
		(User canControl: 1 canInput: 1)
		(gTheIconBar enable: 0 1 2 3 4 5 6 curIcon: (gTheIconBar at: 0))
		(gGame setCursor: ((gTheIconBar at: 0) cursor:) 1)
		(if global147
			(gTheIconBar show:)
		)
	)
)

(procedure (localproc_0 param1) ; UNUSED
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (SetFlag param1)
	(|= [global250 (/ param1 16)] (>> $8000 (mod param1 16)))
)

(procedure (ClearFlag param1)
	(&= [global250 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
)

(procedure (IsFlag param1)
	(return (& [global250 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (NormalEgo param1 param2 param3 &tmp temp0)
	(= temp0 0)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
			(if (> argc 2)
				(= temp0 param3)
			)
		)
	)
	(if (not temp0)
		(= temp0 1)
	)
	(gEgo
		setLoop: -1
		selection: 0
		setPri: -1
		setMotion: 0
		setCycle: StopWalk
		setStep: 3 2
		setAvoider: PAvoider
		ignoreActors: 0
		moveSpeed: (gGame egoMoveSpeed:)
		cycleSpeed: (gGame egoMoveSpeed:)
	)
)

(procedure (proc10_13 param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1 temp2 temp3)
	(= temp1 (param2 talkerObj:))
	(= temp2 (param2 talkerID:))
	(cond
		((not param3) 0)
		((>= (param3 x:) (param2 x:))
			(temp1 facingDir: 3)
		)
		((< (param3 x:) (param2 x:))
			(temp1 facingDir: 7)
		)
		(else
			(temp1 facingDir: 3)
		)
	)
	(cond
		((OneOf temp2 2 4 3)
			(= global142 gCindStory)
		)
		((== temp2 5)
			(= global142 gJackStory)
		)
		((OneOf temp2 6 7 8 9 10 11)
			(= global142 gBremenStory)
		)
		((OneOf temp2 12 13 14)
			(= global142 gBeautyStory)
		)
		((OneOf temp2 15 16 17)
			(= global142 gSnowStory)
		)
	)
	(if (or (== param3 gEgo) (== param2 gEgo))
		(if (== param2 gEgo)
			(Face gEgo param3)
		else
			(Face gEgo param2)
		)
		(if (gEgo head:)
			(gEgo doit:)
			((gEgo head:) doit:)
		)
		(proc10_15)
		(proc10_15)
	)
	(if (!= temp2 global148)
		(if (IsObject global149)
			(global149 dispose:)
		)
		(= global148 temp2)
		((= global149 temp1) show: param1)
	)
	(temp1 say: param6 param7 0 param5 (if (== param4 -1) 0 else param4))
	(if (== param4 -1)
		(while gFastCast
			(gFastCast eachElementDo: #doit)
			(if (and ((= temp3 (Event new:)) type:) gFastCast)
				(gFastCast firstTrue: #handleEvent temp3)
			)
			(temp3 dispose:)
		)
	)
)

(procedure (proc10_15)
	(Animate (gCast elements:) 0)
)

(procedure (proc10_7) ; UNUSED
	(Print 10 0) ; "You need to move closer."
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (and (IsObject temp3) temp3))
)

(procedure (proc10_11)
	(= gQuit
		(Print ; "Thank you for playing. Come back soon!"
			10
			1
			#title
			{Good-bye}
			#button
			{Stop}
			1
			#button
			{Keep Playing}
			0
			#icon
			global139
			0
			0
		)
	)
)

(procedure (proc10_16 param1 &tmp temp0 temp1 temp2)
	(= temp1 (gInventory size:))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(= temp2 (gInventory at: temp0))
		(if (and (== (temp2 owner:) gCurRoomNum) (== (temp2 superClass:) param1))
			(return temp2)
		)
	)
	(return 0)
)

(procedure (proc10_17 param1 &tmp temp0 temp1 temp2)
	(= temp1 (gInventory size:))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(= temp2 (gInventory at: temp0))
		(if (and (== (temp2 owner:) gEgo) (== (temp2 superClass:) param1))
			(return temp2)
		)
	)
	(return 0)
)

(procedure (proc10_18 &tmp temp0 temp1 temp2)
	(= temp1 (gStorySet size:))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(= temp2 (gStorySet at: temp0))
		(if (and (temp2 selected:) (not (temp2 done:)))
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2) ; UNUSED
	(= temp1 (gStorySet size:))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(= temp2 (gStorySet at: temp0))
		(if (temp2 done:)
			(return 1)
		)
	)
	(return 0)
)

(procedure (proc10_19 param1 &tmp temp0 temp1)
	(= temp0 (Random 1 [global129 0]))
	(param1 owner: [global129 temp0])
	(for ((= temp1 temp0)) (< temp1 [global129 0]) ((++ temp1))
		(= [global129 temp1] [global129 (+ temp1 1)])
	)
	(-- [global129 0])
)

(procedure (proc10_20 param1 &tmp temp0 temp1)
	(= temp0 (Random 1 [global134 0]))
	(param1 owner: [global134 temp0])
	(for ((= temp1 temp0)) (< temp1 [global134 0]) ((++ temp1))
		(= [global134 temp1] [global134 (+ temp1 1)])
	)
	(-- [global134 0])
)

(procedure (proc10_12))

(procedure (proc10_14)
	(StrCpy @global110 { })
)

(procedure (proc10_21 param1 param2 param3 param4)
	(Display param1 dsCOORD (+ param3 1) param4 dsCOLOR (+ param2 2) dsALIGN alLEFT &rest)
	(Display param1 dsCOORD param3 param4 dsCOLOR param2 dsALIGN alLEFT &rest)
)

(procedure (proc10_22)
	(Print &rest #at -1 12)
)

(procedure (proc10_23)
	(Print &rest #at -1 158)
)

(procedure (proc10_24 param1 param2 &tmp temp0 [temp1 500] [temp501 4])
	(if (u< (= temp0 param2) 1000)
		(= temp0 @temp1)
		(Format @temp1 param2 &rest)
	)
	(TextSize @[temp501 0] temp0 param1 0)
	(= global227 (- [temp501 3] [temp501 1]))
	(= global228 (- [temp501 2] [temp501 0]))
	(return global227)
)

(procedure (proc10_26 param1)
	(if (or (< param1 65) (> param1 90))
		(return param1)
	else
		(return (+ (- param1 65) 97))
	)
)

(procedure (proc10_25 param1 param2 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp1 (StrLen param2))
	(for
		((= temp0 (- (= temp0 (StrLen param1)) temp1)))
		(>= temp0 0)
		((-- temp0))
		
		(= temp3 0)
		(for ((= temp2 temp0)) (< temp3 temp1) ((++ temp2))
			(if
				(!=
					(proc10_26 (StrAt param2 temp3))
					(proc10_26 (StrAt param1 temp2))
				)
				(break)
			)
			(++ temp3)
		)
		(if (== temp3 temp1)
			(return (+ temp3 1))
		)
	)
	(return 0)
)

(procedure (proc10_27)
	(if global147
		(SetPort -1)
		(DrawCel 900 9 0 0 0 15)
		(DrawCel 900 9 1 277 0 15)
		(SetPort 0)
	)
)

(procedure (proc10_28 &tmp temp0 temp1)
	(for ((= temp1 0)) (< temp1 (Inv size:)) ((++ temp1))
		(if (== ((= temp0 (Inv at: temp1)) owner:) gEgo)
			(break)
		)
		(= temp0 0)
	)
	(gTheIconBar curInvIcon: temp0 show:)
)

(procedure (proc10_29)
	(cond
		((and (not (gGlobalMusic2 handle:)) (> global225 0))
			(if (== global225 6)
				(gGame setScript: gWalkMusic)
			else
				(gGlobalMusic2 number: global225 priority: 15 setLoop: -1 play:)
				(= global225 0)
			)
		)
		((and (gGlobalMusic2 handle:) (== (gGlobalMusic2 number:) 37) (== global225 6))
			(gGlobalMusic2 stop:)
			(gGame setScript: gWalkMusic)
		)
	)
)

