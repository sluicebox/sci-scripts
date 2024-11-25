;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
(include sci.sh)
(use Main)
(use Sound)
(use Actor)
(use System)

(public
	DoPurse 0
)

(local
	local0
	[local1 6] = [0 52 53 90 90 90]
	[local7 6] = [0 137 83 97 109 121]
	[local13 6] = [0 84 81 107 107 107]
	[local19 6] = [0 147 92 107 118 130]
	[local25 6] = [0 0 0 1 1 1]
)

(procedure (DoPurse &tmp temp0 temp1 temp2)
	(if (or global132 (not (gEgo has: 3))) ; purse
		(DisposeScript 117)
		(return global132)
	)
	(= temp2 (GetPort))
	(SetPort 0)
	(= global129 (= global130 (= global131 0)))
	(PurseView view: (if (IsFlag 133) 508 else 507) stopUpd: init:)
	(giveIcon view: (if (IsFlag 133) 508 else 507) init:)
	(closeIcon view: (if (IsFlag 133) 508 else 507) init:)
	(RedrawCast)
	(for ((= temp0 5)) (> temp0 2) ((-- temp0))
		(= local0 temp0)
		(localproc_2)
	)
	(if (or gGold gSilver gCopper)
		(purseSound number: (proc0_20 21) play:)
	)
	(= local0 2)
	(localproc_2 4)
	(while 1
		(GlobalToLocal (= temp1 (Event new:)))
		(cond
			((and (== (temp1 type:) evKEYBOARD) (localproc_3 temp1))
				(break)
			)
			((!= (temp1 type:) evMOUSEBUTTON) 0)
			((and (localproc_2) (localproc_0 temp1 2))
				(proc0_18)
				(break)
			)
			((localproc_0 temp1 1)
				(break)
			)
			(else
				(for ((= temp0 3)) (<= temp0 5) ((++ temp0))
					(if (localproc_0 temp1 temp0)
						(= local0 temp0)
						(localproc_1)
					)
				)
			)
		)
		(localproc_2 4)
		(temp1 dispose:)
	)
	(temp1 dispose:)
	(closeIcon dispose:)
	(giveIcon dispose:)
	(PurseView dispose:)
	(purseSound dispose:)
	(RedrawCast)
	(DisposeScript 117)
	(SetPort temp2)
	(return global132)
)

(procedure (localproc_0 param1 param2)
	(OnButton
		param1
		(- [local1 param2] (if (< param2 3) 0 else 52))
		[local7 param2]
		[local13 param2]
		[local19 param2]
	)
)

(procedure (localproc_1)
	(switch local0
		(2
			(proc0_18)
		)
		(3
			(if gGold
				(-- gGold)
				(++ global129)
				(+= global132 (* global145 global145))
			)
		)
		(4
			(if gSilver
				(-- gSilver)
				(++ global130)
				(+= global132 global145)
			)
		)
		(5
			(if gCopper
				(-- gCopper)
				(++ global131)
				(++ global132)
			)
		)
	)
)

(procedure (localproc_2 param1 &tmp [temp0 8] temp8)
	(= temp8 (if argc param1 else [local25 local0]))
	(switch local0
		(1
			(if (== param1 4)
				(giveIcon setCel: 1)
			else
				(giveIcon setCel: 0)
			)
			(RedrawCast)
		)
		(2
			(if (== param1 4)
				(closeIcon setCel: 2)
			else
				(closeIcon setCel: 0)
			)
			(RedrawCast)
		)
		(else
			(Display
				(Format ; "%2d"
					@temp0
					117
					0
					(switch local0
						(3 gGold)
						(4 gSilver)
						(5 gCopper)
					)
				)
				dsCOORD
				[local1 local0]
				[local7 local0]
				dsCOLOR
				15
				dsBACKGROUND
				temp8
				dsFONT
				4
			)
		)
	)
	(return 1)
)

(procedure (localproc_3 param1)
	(localproc_2)
	(switch (param1 message:)
		(27
			(return 1)
		)
		(13
			(localproc_1)
			(if (<= local0 2)
				(return 1)
			)
		)
		(20480
			(if (> (++ local0) 5)
				(= local0 1)
			)
		)
		(18432
			(if (< (-- local0) 1)
				(= local0 5)
			)
		)
	)
	(localproc_2 0)
	(return 0)
)

(instance PurseView of View
	(properties
		y 150
		x 100
		view 507
		loop 1
		priority 15
		signal 16
	)
)

(instance purseSound of Sound
	(properties
		priority 15
	)
)

(instance giveIcon of View
	(properties
		y 147
		x 68
		view 507
		loop 2
		priority 15
		signal 16
	)
)

(instance closeIcon of View
	(properties
		y 93
		x 68
		view 507
		loop 2
		priority 15
		signal 16
	)
)

