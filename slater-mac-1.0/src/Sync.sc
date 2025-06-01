;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 929)
(include sci.sh)
(use Main)
(use Timer)
(use Motion)
(use System)

(class Sync of Obj
	(properties
		syncTime -1
		syncCue -1
		prevCue -1
		syncNum -1
	)

	(method (syncStart modnum noun verb case seq)
		(DoSync syncSTART self modnum noun verb case seq)
		(if (!= syncCue -1)
			(= prevCue syncCue)
			(= syncTime 0)
		)
	)

	(method (syncCheck &tmp temp0)
		(if (!= syncCue -1)
			(= temp0 (- global83 (GetTime)))
			(if (u<= syncTime temp0)
				(= prevCue syncCue)
				(DoSync syncNEXT self)
			)
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

	(method (init modNum noun verb case seq)
		(if gTheSync
			(self cue:)
		)
		((= gTheSync (Sync new:))
			init:
			syncStart: modNum noun verb case seq
		)
		(if (!= (gTheSync prevCue:) -1)
			(= playing 1)
			(gRegions add: self)
		)
		(Timer setTicks: self (DoAudio audWPLAY modNum noun verb case seq))
	)

	(method (doit &tmp oldSignal)
		(if (!= (gTheSync prevCue:) -1)
			(repeat
				(if (== (gTheSync prevCue:) -1)
					(break)
				)
				(= oldSignal (gTheSync syncTime:))
				(gTheSync syncCheck:)
				(if (== oldSignal (gTheSync syncTime:))
					(break)
				)
			)
			(= prevSignal (gTheSync prevCue:))
		)
	)

	(method (cue)
		(Animate (gCast elements:) 0)
		(= playing 0)
		(= prevSignal 32767)
		(gRegions delete: self)
		(if gTheSync
			(gTheSync syncStop: dispose:)
			(= gTheSync 0)
		)
	)
)

(class MouthSync of Cycle
	(properties)

	(method (init theObj modnum noun verb case seq)
		(super init: theObj)
		(if (IsObject gTheSync)
			(gTheSync syncStop: dispose:)
		)
		((= gTheSync (Sync new:)) syncStart: modnum noun verb case seq)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 -1)
		(super doit:)
		(if (!= (gTheSync prevCue:) -1)
			(= temp2 (gTheSync syncTime:))
			(gTheSync syncCheck:)
			(if
				(and
					(!= temp2 (gTheSync syncTime:))
					(!= (client cel:) (= temp0 (& $000f (gTheSync prevCue:))))
				)
				(client cel: temp0)
			)
		else
			(= completed 1)
			(self cycleDone:)
		)
	)

	(method (dispose)
		(super dispose:)
		(if gTheSync
			(gTheSync dispose:)
			(= gTheSync 0)
		)
	)

	(method (cue)
		(if gTheSync
			(gTheSync syncStop: dispose:)
			(= gTheSync 0)
			(if caller
				(caller cue:)
				(= caller 0)
			)
		)
	)
)

