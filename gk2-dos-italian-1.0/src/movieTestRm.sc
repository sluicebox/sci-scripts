;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use n011)
(use Str)
(use Print)
(use Game)
(use System)

(public
	movieTestRm 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5 = 1
	local6
	local7
	local8
)

(instance movieTestRm of Room
	(properties
		modNum 0
	)

	(method (init)
		(= local8 (IsFlag 34))
		(gGame handsOff:)
		(gTopMessage BAD_SELECTOR: {Movie Player})
		(= local2 (Str newWith: 10 {}))
		(super init: &rest)
		(gGame handsOn: 1)
		(gCurRoom setScript: sMoviePlayer)
	)

	(method (dispose)
		(if local8
			(SetFlag 34)
		else
			(ClearFlag 34)
		)
		(gTopMessage BAD_SELECTOR: 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(if local6
			(= local7 1)
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
				(= cycles 1)
			)
			(1
				(gGame setCursor: gNormalCursor 1)
				(switch
					(Print
						font: gUserFont
						y: 70
						addTitle: {Let's Make Some Movie Magic}
						addText: {Movie Number} 0 6
						addEdit: local0 5 110 2 local2
						addButton: 5 {Play} 72 25
						addButton:
							1
							(if local5 {Black Lines ON } else {Black Lines OFF})
							37
							50
						addButton:
							2
							(if local4 {Double Size YES} else {Double Size NO })
							36
							70
						addButton:
							3
							(if local6 {Loop Movie  YES} else {Loop Movie  NO })
							35
							90
						addButton: 4 {Exit} 73 115
						init:
					)
					(1
						(if local5
							(= local5 0)
						else
							(= local5 1)
						)
						(self changeState: 0)
					)
					(2
						(if local4
							(SetFlag 34)
							(= local4 0)
						else
							(ClearFlag 34)
							(= local4 1)
						)
						(self changeState: 0)
					)
					(3
						(if local6
							(= local6 0)
						else
							(= local6 1)
						)
						(self changeState: 0)
					)
					(4
						(gCurRoom newRoom: 24) ; whereTo
						(self dispose:)
					)
					(5
						(= cycles 1)
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
					(PlayVMDFile (local0 asInteger:))
					(self cue:)
				else
					(self changeState: 0)
				)
			)
			(3
				(while ((= temp0 (Event new: 3)) type:)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(FrameOut)
				(if (and local6 (not local7))
					(self changeState: 2)
				else
					(= local7 0)
					(local3 dispose:)
					(Palette 1 999) ; PalLoad
					(self changeState: 0)
				)
			)
		)
	)
)

