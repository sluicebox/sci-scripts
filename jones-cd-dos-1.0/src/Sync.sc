;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 976)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(local
	[local0 10]
	local10
	local11
)

(class Sync of Obj
	(properties
		syncTime -1
		syncCue -1
		prevCue -1
		syncNum -1
	)

	(method (syncStart param1)
		(if (== (DoSound sndGET_POLYPHONY) 1)
			(gASong pause: 1)
		else
			(gASong
				fade:
					(if (>= (- global520 10) 0)
						(* (- global520 10) 8)
					else
						0
					)
					2
					5
					0
			)
		)
		(= global554 (PicNotValid))
		(PicNotValid 0)
		(DoSync syncSTART self param1)
		(if (!= syncCue -1)
			(= prevCue syncCue)
			(= syncTime 0)
		)
		(= global557 1)
	)

	(method (syncCheck)
		(if (and (!= syncCue -1) (u<= syncTime (+ global559 (DoAudio audPOSITION))))
			(= prevCue syncCue)
			(DoSync syncNEXT self)
		)
	)

	(method (syncStop)
		(= prevCue -1)
		(DoSync syncSTOP)
		(PicNotValid global554)
		(= global557 0)
		(if global555
			(Printf ; "Syncs missed for number %d: %d %x %x %x %x %x %x %x"
				976
				0
				local11
				global556
				[local0 0]
				[local0 1]
				[local0 2]
				[local0 3]
				[local0 4]
				[local0 5]
				[local0 6]
			)
			(DoAudio audCD)
		)
	)
)

(class MouthSync of Cycle
	(properties)

	(method (init param1 param2 &tmp temp0)
		(= local11 param2)
		(= caller (= client (= global556 0)))
		(super init: param1)
		(= local10 0)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(= [local0 temp0] 0)
		)
		(if global558
			(global558 syncStop:)
			(= global558 0)
		)
		(= ticksToDo 1)
		((= global558 gSyncInstance) syncStart: param2)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if global558
			(if (== (DoAudio audPOSITION) -1)
				(self cue:)
				(return)
			)
			(if (!= (global558 prevCue:) -1)
				(= temp1 0)
				(repeat
					(= temp0 (global558 syncTime:))
					(global558 syncCheck:)
					(if (== temp0 (global558 syncTime:))
						(break)
					)
					(client cel: (& $000f (global558 prevCue:)))
					(if (and (> (++ temp1) 1) (< local10 10))
						(= [local0 local10] temp0)
						(++ local10)
					)
				)
				(if (> temp1 1)
					(+= global556 (- temp1 1))
				)
			)
		)
	)

	(method (cue)
		(if global558
			(global558 syncStop:)
			(= global558 0)
			(if caller
				(if (== (DoSound sndGET_POLYPHONY) 1)
					(gASong pause: 0)
				else
					(gASong fade: (* global520 8) 2 5 0)
				)
				(caller cue:)
				(= caller 0)
			)
			(if client
				(client cel: 0 draw:)
				(= client 0)
			)
		)
	)
)

