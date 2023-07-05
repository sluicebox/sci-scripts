;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 976)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class Sync of Obj
	(properties
		syncTime -1
		syncCue -1
		prevCue -1
		syncNum -1
	)

	(method (syncStart param1)
		(DoSync syncSTART self param1)
		(if (!= syncCue -1)
			(= prevCue syncCue)
			(= syncTime 0)
		)
	)

	(method (syncCheck)
		(if (and (!= syncCue -1) (u<= syncTime (+ global74 (DoAudio audPOSITION))))
			(= prevCue syncCue)
			(DoSync syncNEXT self)
		)
	)

	(method (syncStop)
		(= prevCue -1)
		(DoSync syncSTOP)
	)
)

(class ScriptSync of Obj
	(properties
		prevSignal -1
		playing 0
	)

	(method (init param1)
		(if gSync
			(self cue:)
		)
		(= gSync (Sync new:))
		(gSync init:)
		(gSync syncStart: param1)
		(if (!= (gSync prevCue:) -1)
			(= playing 1)
			(gRegions add: self)
		)
		(Timer set60ths: self (DoAudio audPLAY param1))
	)

	(method (doit &tmp temp0)
		(if (!= (gSync prevCue:) -1)
			(repeat
				(if (== (gSync prevCue:) -1)
					(break)
				)
				(= temp0 (gSync prevCue:))
				(gSync syncCheck:)
				(if (== temp0 (gSync prevCue:))
					(break)
				)
			)
			(= prevSignal (gSync prevCue:))
		)
	)

	(method (cue)
		(Animate (gCast elements:) 0)
		(= playing 0)
		(= prevSignal 32767)
		(gRegions delete: self)
		(if gSync
			(gSync syncStop:)
			(gSync dispose:)
			(= gSync 0)
		)
	)

	(method (handleEvent))
)

(class MouthSync of Cycle
	(properties)

	(method (init param1 param2)
		(super init: param1)
		(if gSync
			(gSync syncStop:)
			(gSync dispose:)
		)
		(= gSync (Sync new:))
		(if (== global169 1)
			(gSync syncStart: param2)
		)
	)

	(method (check &tmp temp0 temp1 temp2 temp3)
		(cond
			((!= (gSync prevCue:) -1)
				(= temp3 (gSync syncTime:))
				(repeat
					(= temp2 (gSync syncTime:))
					(gSync syncCheck:)
					(if (== temp2 (gSync syncTime:))
						(break)
					)
				)
				(cond
					((!= temp3 (gSync syncTime:))
						(= temp1 (gSync prevCue:))
						(= temp0 (client lastCel:))
						(if (> temp1 temp0)
							(cond
								((== temp1 16)
									(= temp1 0)
								)
								((== (= temp1 (Random 1 temp0)) (client cel:))
									(if (== temp1 temp0)
										(-= temp1 1)
									else
										(+= temp1 1)
									)
								)
							)
						)
						(client cel: temp1)
						(if global246
							(global246 doit:)
						)
						(Animate (global247 elements:) 0)
					)
					((== (gSync prevCue:) 16)
						(gSync prevCue: 1)
						(client cel: 1)
						(if global246
							(global246 doit:)
						)
						(Animate (global247 elements:) 0)
					)
				)
			)
			((== 2 (Random 1 3))
				(client setCel: (Random 0 (- (NumCels client) 1)))
			)
		)
	)

	(method (doit)
		(while 1
			(self check:)
			(if (>= (- (GetTime) global248) 0)
				(break)
			)
		)
	)

	(method (cue)
		(if gSync
			(gSync syncStop:)
			(gSync dispose:)
			(= gSync 0)
		)
	)
)

