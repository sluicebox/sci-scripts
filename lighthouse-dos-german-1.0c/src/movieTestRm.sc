;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use LightRoom)
(use Str)
(use Print)
(use System)

(public
	movieTestRm 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 2] = [1 1]
	local9
	local10
)

(instance movieTestRm of LightRoom
	(properties
		modNum 0
	)

	(method (init)
		(gGame handsOff:)
		(= local2 (Str newWith: 10 {}))
		(= local5 (Str newWith: 10 {}))
		(super init: &rest)
		(gGame handsOn: 1)
		(gCurRoom setScript: sMoviePlayer)
	)

	(method (handleEvent event)
		(if local9
			(= local10 1)
		)
		(super handleEvent: event)
	)
)

(instance sMoviePlayer of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local0 (Str newWith: 10 {}))
				(= local3 (Str newWith: 10 {}))
				(= local6 (Str newWith: 10 {}))
				(= cycles 1)
			)
			(1
				(gGame setCursor: gNormalCursor 1)
				(switch
					(Print
						font: gUserFont
						y: 90
						addTitle: {Let's Make Some Movie Magic}
						addText: {Movie Number} 0 6
						addEdit: local0 5 110 2 local2
						addText: {Gamma Value} 0 26
						addEdit: local3 5 110 22 local5
						addButton: 1 {Play} 72 45
						addButton: 2 {Exit} 73 70
						init:
					)
					(1
						(if (local0 size:)
							(= cycles 1)
						else
							(self changeState: 0)
						)
					)
					(2
						(gCurRoom newRoom: 6) ; whereTo
						(self dispose:)
					)
					(else
						(if (local0 size:)
							(= cycles 1)
						else
							(self changeState: 0)
						)
					)
				)
			)
			(2
				(if (local0 size:)
					(= local2 (local0 data:))
					(= local5 (local3 data:))
					(if (ResCheck 151 (local0 asInteger:)) ; VMD
						(= local1 (local0 asInteger:))
						(= local4 (local3 asInteger:))
						(local6 format: {%d.vmd} local1)
						(PlayVMD 0 (local6 data:)) ; Open
						(= cycles 1)
					else
						(Printf {*** %s.vmd Not Found! ***} local0)
						(self changeState: 0)
					)
				else
					(self changeState: 0)
				)
			)
			(3
				(PrintDebug {gamma level %d} local4)
				(PlayVMD 1 73 75 276 local4 0 236) ; Put
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 1)
			)
			(4
				(while ((= temp0 (Event new: evMOUSE)) type:)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(FrameOut)
				(if (and local9 (not local10))
					(self changeState: 2)
				else
					(= local10 0)
					(local6 dispose:)
					(Palette 1 999) ; PalLoad
					(self changeState: 0)
				)
			)
		)
	)
)

