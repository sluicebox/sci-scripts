;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 910)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use Menu)
(use System)

(public
	DrawSword 0
	SheatheSword 1
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(StrCpy (User inputLineAddr:) param1)
	((= temp0 (User curEvent:)) type: evSAID claimed: 0)
	(Parse (User inputLineAddr:) temp0)
	(gCast eachElementDo: #handleEvent temp0)
	(if (not (temp0 claimed:))
		(gRegions eachElementDo: #handleEvent temp0)
	)
	(= temp1 (or (not (temp0 claimed:)) (== global125 2)))
	(if (temp0 claimed:)
		0
	else
		(Print 800 (Random 35 38))
		(= global125 2)
	)
	(temp0 dispose:)
	(return temp1)
)

(instance DrawSword of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global153 (User canInput:))
				(= global154 (User controls:))
				(= global155 global80)
				(= global214 (gEgo illegalBits:))
				(HandsOff)
				(User echo: 0)
				(= global149 (gEgo view:))
				(= global156 (gEgo cycler:))
				(gEgo
					cycler: 0
					view:
						(cond
							((and (>= 80 gCurRoomNum 75) (gEgo has: 7)) 656) ; crystal_heart | charcoal | helm
							((== global149 3) 5)
							((== global149 0) 4)
							((or (== global149 9) (== global149 65)) 56)
							((or (== global149 8) (== global149 64)) 55)
							(else 4)
						)
					illegalBits: 0
					setCel: 0
					setCycle: End self
				)
				(= global150 (gEgo view:))
			)
			(1
				(gEgo
					view:
						(switch (gEgo view:)
							(5 7)
							(4 6)
							(56 9)
							(55 8)
							(656 87)
						)
					illegalBits: global214
					setCycle: global156
					setScript: 0
				)
				(= global125 0)
				(= global156 0)
				(= global124 1)
				(HandsOn)
				(User canInput: 0)
				(User controls: global154)
				(if (not (localproc_0 {draw sword}))
					(proc997_1)
				)
				(DisposeScript 910)
			)
		)
	)
)

(instance SheatheSword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global156 (gEgo cycler:))
				(= global214 (gEgo illegalBits:))
				(gEgo
					cycler: 0
					view: global150
					illegalBits: 0
					setCel: 255
					setCycle: Beg self
				)
			)
			(1
				(gEgo view: global149 illegalBits: global214 setScript: 0)
				(if global156
					(gEgo setCycle: 0 cycler: global156)
					(= global156 0)
				else
					(gEgo setCycle: Walk)
				)
				(= global125 0)
				(= global124 0)
				(proc997_1)
				(User canInput: global153)
				(User controls: global154)
				(= global80 global155)
				(User echo: 32)
				(DisposeScript 912)
				(DisposeScript 910)
			)
		)
	)
)

