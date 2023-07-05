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

	(method (syncStart number)
		(DoSync syncSTART self number)
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

	(method (init number)
		(if gTheSync
			(self cue:)
		)
		((= gTheSync (Sync new:)) init: syncStart: number)
		(if (!= (gTheSync prevCue:) -1)
			(= playing 1)
			(gRegions add: self)
		)
		(Timer setTicks: (DoAudio audWPLAY number) self)
	)

	(method (doit &tmp oldSignal)
		(if (!= (gTheSync prevCue:) -1)
			(repeat
				(if (== (gTheSync prevCue:) -1)
					(break)
				)
				(= oldSignal (gTheSync prevCue:))
				(gTheSync syncCheck:)
				(if (== oldSignal (gTheSync prevCue:))
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

	(method (handleEvent))
)

(class MouthSync of Cycle
	(properties)

	(method (init theObj no &tmp a)
		(super init: theObj)
		(if (IsObject gTheSync)
			(gTheSync syncStop: -propDict-)
		)
		((= gTheSync (Sync new:)) syncStart: no)
	)

	(method (doit &tmp numCels newCel oldSignal theTime cntr)
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
					(!= (client cel:) (gTheSync prevCue:))
				)
				(= newCel (gTheSync prevCue:))
				(= numCels (client lastCel:))
				(if (or (< newCel 0) (> newCel numCels))
					(if (<= numCels 1)
						(= newCel numCels)
					else
						(repeat
							(if (!= (client cel:) (= newCel (Random 1 numCels)))
								(break)
							)
						)
					)
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

