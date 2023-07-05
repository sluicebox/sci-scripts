;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 342)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use System)

(public
	artFrames 0
)

(local
	local0
	[local1 25] = [70 91 92 73 70 71 72 73 90 91 92 93 70 71 72 73 70 71 72 73 70 71 72 73 94]
	[local26 6]
	[local32 18] = [138 168 199 230 261 292 137 169 201 230 260 291 139 169 200 230 261 291]
	[local50 18] = [43 47 44 36 33 29 10 9 6 4 2 0 85 77 76 67 64 59]
	[local68 18]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(for ((= local0 0)) (< local0 18) ((++ local0))
		(= temp0 (mod local0 6))
		(while (& [local26 temp0] (<< $0001 (= temp1 (Random 0 4))))
		)
		(|= [local26 temp0] (<< $0001 temp1))
		(= temp2 [local1 (+ (* temp0 4) temp1)])
		(= [local68 local0] (+ (* temp0 100) temp2))
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if (== global129 -1)
		(return 70)
	)
	(= temp1 [local68 (= temp0 (Random 0 global129))])
	(= [local68 temp0] [local68 global129])
	(-- global129)
	(return temp1)
)

(instance artFrames of Set
	(properties)

	(method (init &tmp temp0)
		(= global124 0)
		(= global125 0)
		(= gArtWin 0)
		(= global128 0)
		(= global129 0)
		(= global130 0)
		(for ((= local0 0)) (< local0 5) ((++ local0))
			(= [local26 local0] 16)
		)
		(= [local26 5] 0)
		(switch global114
			(0
				(= global130 6)
			)
			(1
				(= global130 12)
			)
			(2
				(= global130 18)
			)
		)
		(= global129 17)
		(localproc_0)
		(for ((= local0 0)) (< local0 18) ((++ local0))
			(self
				add:
					((frame new:)
						nsLeft: [local32 local0]
						nsTop: [local50 local0]
						value: (= temp0 (localproc_1))
						loop:
							(if (< local0 global130)
								(+ (/ (mod temp0 100) 10) (Random 0 1))
							else
								(/ temp0 100)
							)
						cel:
							(if (< local0 global130)
								2
							else
								(mod (mod temp0 100) 10)
							)
						yourself:
					)
			)
		)
		(super init: &rest)
	)
)

(instance frame of CodeIcon
	(properties
		view 346
	)

	(method (highlight)
		(if (>= loop 7)
			(super highlight: &rest)
		)
	)

	(method (select)
		(if
			(and
				(if (>= loop 7)
					(super select: &rest)
				else
					1
				)
				(not global128)
			)
			(= global124 value)
			(= global125 self)
			(= global128 1)
			(= gArtWin (((ScriptID 349 2) new:) open: global124 yourself:)) ; artWin
		)
	)
)

