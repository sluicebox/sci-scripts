;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 114)
(include sci.sh)
(use Main)
(use DText)
(use Str)
(use Print)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm114 0
)

(local
	local0
	local1
	local2
)

(instance rm114 of Room
	(properties)

	(method (init)
		(gThePlane setRect: 0 0 319 199)
		(= global121 0)
		(gGame setCursor: gNormalCursor 0)
		(User canInput: 1)
		(super init:)
		(self setScript: doDialog)
	)
)

(instance testProp of Prop
	(properties)
)

(instance doDialog of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(super dispose:)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((!= state 4)
				(return 0)
			)
			((& (event type:) evKEYBOARD)
				(self cue:)
				(event claimed: 1)
				(return)
			)
			((& (event type:) evMOUSEBUTTON)
				(self cue:)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame setCursor: gNormalCursor 1)
				(switch
					(= local0
						(Print
							font: gUserFont
							x: 5
							y: 0
							addText: {choose start view:}
							addButton: 3 {3} 20 12
							addButton: 7 {7} 10 26
							addButton: 6 {6} 30 26
							addButton: 1 {1} 0 40
							addButton: 0 {0} 40 40
							addButton: 5 {5} 10 54
							addButton: 4 {4} 30 54
							addButton: 2 {2} 20 68
							addButton: -1 {quit} 0 84
							init:
						)
					)
					(3
						(= local2 9050)
					)
					(7
						(= local2 9090)
					)
					(6
						(= local2 9080)
					)
					(1
						(= local2 9030)
					)
					(0
						(= local2 9020)
					)
					(5
						(= local2 9070)
					)
					(4
						(= local2 9060)
					)
					(2
						(= local2 9040)
					)
				)
				(if (== local0 -1)
					(= gQuit 1)
				else
					(testProp view: local0 loop: 0 cel: 0 init: posn: 160 140)
					(testProp cel: (testProp lastCel:))
				)
				(= cycles 2)
			)
			(2
				(= local1
					(+
						(= local1
							(Print
								font: gUserFont
								x: 5
								y: 0
								addText: {choose fidget view:}
								addButton: 0 {0} 0 12
								addButton: 1 {1} 10 12
								addButton: 2 {2} 21 12
								addButton: 3 {3} 32 12
								addButton: 4 {4} 43 12
								addButton: 5 {5} 54 12
								addButton: 6 {6} 65 12
								addButton: 7 {7} 76 12
								init:
							)
						)
						local2
					)
				)
				(= seconds 2)
			)
			(3
				(testProp view: local1 loop: 0 cel: 0 setCycle: End self)
				(= temp0 (Str format: {ego view: %d} (testProp view:)))
				((= register (DText new:))
					text: (KString 8 (temp0 data:)) ; StrDup
					fore: 1
					back: 0
					x: 130
					y: 154
					setSize: 240
					setPri: 255
					init:
				)
				(temp0 dispose:)
			)
			(4
				(testProp view: local0 loop: 0 cel: 0 init: posn: 160 140)
				(testProp cel: (testProp lastCel:))
			)
			(5
				(register dispose:)
				(testProp dispose:)
				(self init:)
			)
		)
	)
)

