;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	logo 0
)

(instance logo of LBRoom
	(properties
		picture 105
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 108)
		(LoadMany rsPIC 780)
		(LoadMany rsSOUND 105)
		(self setRegions: 92) ; intro
		(gCurRoom drawPic: 780)
		(super init:)
		(sparkle init:)
		(gUser canControl: 0 canInput: 0)
		(gGameMusic1 number: 105 flags: 1 loop: 1 play:)
		(self setScript: sRunIt)
	)
)

(instance sRunIt of Script
	(properties)

	(method (doit)
		(Palette palANIMATE 95 224 1)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 0 254 0)
				(gCurRoom drawPic: 105 10)
				(= cycles 1)
			)
			(1
				(gGame handsOff: setCursor: 996 1 304 172)
				(= seconds 6)
			)
			(2
				(if (== (gGameMusic1 prevSignal:) 20)
					(sparkle setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3
				(if (== (gGameMusic1 prevSignal:) 30)
					(sparkle x: 60 y: 145 loop: 1 cel: 0 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(4
				(if
					(and
						(== (sparkle cel:) (sparkle lastCel:))
						(== (gGameMusic1 prevSignal:) -1)
					)
					(sparkle dispose:)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(5
				(gCurRoom newRoom: 100)
				(self dispose:)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 121
		y 54
		view 108
		priority 15
		signal 16
	)
)

