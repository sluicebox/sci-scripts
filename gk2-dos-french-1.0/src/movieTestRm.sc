;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
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
)

(instance movieTestRm of Room
	(properties
		modNum 0
	)

	(method (init)
		(gGame handsOff:)
		(gTopMessage newText: {Movie Player})
		(= local2 (Str newWith: 10 {}))
		(super init: &rest)
		(gGame handsOn: 1)
		(gCurRoom setScript: sMoviePlayer)
	)

	(method (dispose)
		(gTopMessage newText: 0)
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
							(if local6 {Loop Movie__YES} else {Loop Movie__NO })
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
							(= local4 0)
						else
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
					(if (ResCheck 151 (local0 asInteger:)) ; VMD
						(= local1 (local0 asInteger:))
						(local3 format: {%d.vmd} local1)
						(PlayVMD 0 (local3 data:)) ; Open
						(cond
							(local5
								(if local4
									(PlayVMD 1 12 14 21 25 16 256) ; Put
								else
									(PlayVMD 1 165 98 20 25 16 256) ; Put
								)
							)
							(local4
								(PlayVMD 1 12 14 1 25 16 256) ; Put
							)
							(else
								(PlayVMD 1 165 98 0 16 256) ; Put
							)
						)
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
				(PlayVMD 23 16 236) ; RestrictPalette
				(PlayVMD 21 12 14 627 349) ; Black
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

