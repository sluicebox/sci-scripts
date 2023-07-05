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

	(method (syncCheck)
		(if
			(and
				(!= syncCue -1)
				(or (u<= syncTime gSyncBias) (<= syncTime (DoAudio audPOSITION)))
			)
			(if (== (& $fff0 syncCue) 0)
				(= prevCue (| (& prevCue $fff0) syncCue))
			else
				(= prevCue syncCue)
			)
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

	(method (doit &tmp newCel oldSignal theTime cntr)
		(super doit:)
		(if (!= (gTheSync prevCue:) -1)
			(= theTime (gTheSync syncTime:))
			(= cntr 0)
			(repeat
				(= oldSignal (gTheSync syncTime:))
				(gTheSync syncCheck:)
				(if (== oldSignal (gTheSync syncTime:))
					(break)
				)
			)
			(if
				(and
					(!= theTime (gTheSync syncTime:))
					(!= (client cel:) (= newCel (& $000f (gTheSync prevCue:))))
				)
				(client cel: newCel)
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

