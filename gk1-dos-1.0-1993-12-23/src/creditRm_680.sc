;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use n013)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	creditRm 0
)

(local
	local0
)

(instance creditRm of Room
	(properties
		modNum 680
		picture 99
		style 14
		exitStyle 13
	)

	(method (init)
		(super init: &rest)
		(gTheIconBar erase: disable:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(gGame setCursor: ((ScriptID 0 1) view: 996)) ; globeCursor
		(gGkMusic1
			number: (if (IsFlag 470) 990 else 5400)
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 5 10 0
		)
		(self
			setScript:
				(if (IsFlag 470)
					(LoadMany rsVIEW 790 791)
					doFloppyCredits
				else
					doCDCredits
				)
		)
	)

	(method (handleEvent)
		(= gQuit 1)
		(return 1)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance doCDCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(credit view: 790 loop: 0 init:)
				(= local0 772)
				(= seconds 3)
			)
			(1
				(credit dispose:)
				(gCurRoom drawPic: local0)
				(if (< local0 777)
					(-- state)
					(++ local0)
				)
				(if (<= 773 local0 774)
					(= ticks 300)
				else
					(= ticks 180)
				)
			)
			(2
				(gCurRoom drawPic: 99)
				(credit init: loop: 1 view: 791)
				(= local0 1)
				(= ticks
					(*
						(CelHigh (credit view:) (credit loop:) (credit cel:))
						4
						2
					)
				)
			)
			(3
				(credit loop: local0)
				(if (< local0 14)
					(-- state)
					(++ local0)
				else
					(credit view: 792)
					(= local0 0)
				)
				(= ticks
					(* (CelHigh (credit view:) (credit loop:) (credit cel:)) 4)
				)
			)
			(4
				(credit loop: local0)
				(if (< local0 4)
					(-- state)
					(++ local0)
				else
					(credit view: 793)
					(= local0 0)
				)
				(= ticks
					(* (CelHigh (credit view:) (credit loop:) (credit cel:)) 4)
				)
			)
			(5
				(credit loop: local0)
				(if (< local0 3)
					(-- state)
					(++ local0)
					(= ticks
						(*
							(CelHigh
								(credit view:)
								(credit loop:)
								(credit cel:)
							)
							4
						)
					)
				else
					(= gQuit 1)
				)
			)
		)
	)
)

(instance doFloppyCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(credit view: 790 loop: (= local0 0) init:)
				(= seconds 3)
			)
			(1
				(if (< local0 14)
					(-- state)
					(credit loop: (++ local0))
					(= ticks
						(*
							(CelHigh
								(credit view:)
								(credit loop:)
								(credit cel:)
							)
							4
						)
					)
				else
					(credit loop: (= local0 1) view: 791)
					(= ticks
						(*
							(CelHigh
								(credit view:)
								(credit loop:)
								(credit cel:)
							)
							4
							2
						)
					)
				)
			)
			(2
				(if (< local0 14)
					(-- state)
					(credit loop: (++ local0))
					(= ticks
						(*
							(CelHigh
								(credit view:)
								(credit loop:)
								(credit cel:)
							)
							4
						)
					)
				else
					(= gQuit 1)
				)
			)
		)
	)
)

(instance credit of View
	(properties
		x 160
		y 80
		view 790
	)
)

