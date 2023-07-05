;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 411)
(include sci.sh)
(use Main)
(use System)

(public
	proc411_0 0
	proc411_1 1
)

(local
	[local0 31]
	local31 = -1
)

(procedure (proc411_0 param1 &tmp temp0 temp1 temp2)
	(if (< global170 90)
		((= global247 (EventHandler new:)) add:)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(global247 add: [param1 temp1])
		)
		(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
			(= temp2 (gCast at: temp0))
			(if (not (& (temp2 signal:) $0004))
				(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
					(if (== temp2 [param1 temp1])
						(= temp2 0)
					)
				)
				(if temp2
					(= [local0 (++ local31)] temp2)
					(temp2 stopUpd:)
				)
			)
		)
	else
		(= global247 gCast)
	)
)

(procedure (proc411_1 &tmp temp0 [temp1 2])
	(if (< global170 90)
		(global247 release: dispose:)
		(for ((= temp0 0)) (<= temp0 local31) ((++ temp0))
			([local0 temp0] startUpd:)
		)
	)
	(DisposeScript 411)
)

