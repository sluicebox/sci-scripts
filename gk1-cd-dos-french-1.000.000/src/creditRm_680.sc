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
		(self
			setScript:
				(if (IsFlag 470)
					(LoadMany rsVIEW 790 791 795)
					doFloppyCredits
				else
					(LoadMany rsPIC 772 773 774 775 776 777)
					doCDCredits
				)
		)
		(gGkMusic1
			number: (if (IsFlag 470) 990 else 5400)
			number:
				(cond
					((IsFlag 470) 990)
					((DoSound sndGET_AUDIO_CAPABILITY) 5400)
					(else 990)
				)
			setLoop: -1
			play: self
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 5 10 0
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
				(credit view: 795 loop: 0 init:)
				(= local0 0)
				(= seconds 3)
			)
			(1
				(credit loop: local0)
				(if (< local0 4)
					(-- state)
					(++ local0)
				)
				(= ticks
					(+
						15
						(*
							(CelHigh
								(credit view:)
								(credit loop:)
								(credit cel:)
							)
							3
						)
					)
				)
			)
			(2
				(= local0 771)
				(self cue:)
			)
			(3
				(credit dispose:)
				(if (< local0 777)
					(-- state)
					(++ local0)
					(gCurRoom drawPic: local0)
				else
					(gCurRoom drawPic: 99)
					(= local0 0)
					(credit loop: 0 view: 7911 init:)
				)
				(if (<= 773 local0 774)
					(= ticks 350)
				else
					(= ticks 225)
				)
			)
			(4
				(if (< (++ local0) 16)
					(-- state)
					(credit loop: local0)
				else
					(credit view: 792 loop: 0)
					(= local0 0)
				)
				(= ticks
					(+
						15
						(*
							(CelHigh
								(credit view:)
								(credit loop:)
								(credit cel:)
							)
							3
						)
					)
				)
			)
			(5
				(if (< (++ local0) 5)
					(-- state)
					(credit loop: local0)
				else
					(credit view: 793 loop: 0)
					(= local0 0)
				)
				(= ticks
					(+
						15
						(*
							(CelHigh
								(credit view:)
								(credit loop:)
								(credit cel:)
							)
							3
						)
					)
				)
			)
			(6
				(if (< (++ local0) 3)
					(-- state)
					(credit loop: local0)
					(= ticks
						(+
							15
							(*
								(CelHigh
									(credit view:)
									(credit loop:)
									(credit cel:)
								)
								3
							)
						)
					)
				else
					(credit view: 791 loop: 1)
					(= local0 1)
					(= ticks 250)
				)
			)
			(7
				(if (< (++ local0) 15)
					(-- state)
					(credit loop: local0)
					(= ticks
						(+
							15
							(*
								(CelHigh
									(credit view:)
									(credit loop:)
									(credit cel:)
								)
								3
							)
						)
					)
				else
					(credit dispose:)
					(gGkMusic1 setLoop: 1)
					(= seconds 10)
				)
			)
			(8
				(= gQuit 1)
			)
		)
	)
)

(instance doFloppyCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(credit view: 795 loop: (= local0 0) init:)
				(= seconds 3)
			)
			(1
				(credit loop: local0)
				(if (< local0 4)
					(-- state)
					(++ local0)
				)
				(= ticks
					(+
						15
						(*
							(CelHigh
								(credit view:)
								(credit loop:)
								(credit cel:)
							)
							3
						)
					)
				)
			)
			(2
				(= local0 0)
				(self cue:)
			)
			(3
				(if (< local0 14)
					(-- state)
					(credit view: 790 loop: (++ local0))
					(= ticks
						(+
							15
							(*
								(CelHigh
									(credit view:)
									(credit loop:)
									(credit cel:)
								)
								3
							)
						)
					)
				else
					(credit loop: (= local0 1) view: 791)
					(= ticks
						(*
							(+
								15
								(*
									(CelHigh
										(credit view:)
										(credit loop:)
										(credit cel:)
									)
									3
								)
							)
							2
						)
					)
				)
			)
			(4
				(if (< local0 14)
					(-- state)
					(credit loop: (++ local0))
					(= ticks
						(+
							15
							(*
								(CelHigh
									(credit view:)
									(credit loop:)
									(credit cel:)
								)
								3
							)
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

