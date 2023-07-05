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
		startTime 0
	)

	(method (syncStart number)
		(DoSync syncSTART self number)
		(if (!= syncCue -1)
			(= prevCue syncCue)
			(= syncTime 0)
			(= startTime (GetTime))
		)
	)

	(method (syncCheck)
		(if (!= syncCue -1)
			(cond
				(global119
					(if (u<= syncTime (+ gSyncBias (DoAudio audPOSITION)))
						(= prevCue syncCue)
						(DoSync syncNEXT self)
					)
				)
				((u<= syncTime (+ gSyncBias (- (GetTime) startTime)))
					(= prevCue syncCue)
					(DoSync syncNEXT self)
				)
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

	(method (init number)
		(if gTheSync
			(self cue:)
		)
		(= gTheSync (Sync new:))
		(gTheSync init:)
		(gTheSync syncStart: number)
		(if (!= (gTheSync prevCue:) -1)
			(= playing 1)
			(gRegions add: self)
		)
		(Timer set60ths: self (DoAudio audPLAY number))
		(if (not global157)
			(gLongSong number: number setLoop: 1 play:)
		)
	)

	(method (doit &tmp oldSignal)
		(if (!= (gTheSync prevCue:) -1)
			(repeat
				(if (== (= oldSignal (gTheSync prevCue:)) -1)
					(break)
				)
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
			(gTheSync syncStop:)
			(gTheSync dispose:)
			(= gTheSync 0)
		)
	)

	(method (handleEvent))
)

(class MouthSync of Cycle
	(properties)

	(method (init theObj no)
		(super init: theObj)
		(if gTheSync
			(gTheSync syncStop:)
			(gTheSync dispose:)
		)
		(= gTheSync (Sync new:))
		(if (== global169 1)
			(gTheSync syncStart: no)
		)
	)

	(method (check &tmp temp0 temp1 temp2 temp3)
		(cond
			((!= (gTheSync prevCue:) -1)
				(= temp3 (gTheSync syncTime:))
				(repeat
					(= temp2 (gTheSync syncTime:))
					(gTheSync syncCheck:)
					(if (== temp2 (gTheSync syncTime:))
						(break)
					)
				)
				(cond
					((!= temp3 (gTheSync syncTime:))
						(= temp1 (gTheSync prevCue:))
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
					((== (gTheSync prevCue:) 16)
						(gTheSync prevCue: 1)
						(client cel: 1)
						(if global246
							(global246 doit:)
						)
						(Animate (global247 elements:) 0)
					)
				)
			)
			((and global119 (!= (client cel:) (self nextCel:)))
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
		(if gTheSync
			(gTheSync syncStop:)
			(gTheSync dispose:)
			(= gTheSync 0)
		)
	)
)

