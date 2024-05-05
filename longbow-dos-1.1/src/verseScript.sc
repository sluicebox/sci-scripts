;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 806)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use Sound)
(use Motion)
(use Inventory)
(use System)

(public
	EgoDead 0
	SetScore 1
	AddToAddToPics 2
	AddToFeatures 3
	AddRansom 4
	AddOutlaws 5
	SetIcon 6
	verseScript 7
)

(procedure (EgoDead &tmp [temp0 80])
	(gGame setCursor: 999 1)
	(gRgnMusic stop:)
	(gSFX stop:)
	(gSFX2 stop:)
	(specialSound number: 172 init: play:)
	(if argc
		(Format @temp0 &rest)
	else
		(Format @temp0 806 0) ; "There's no use going to pieces. Pull yourself together and start again."
	)
	(repeat
		(switch
			(Print
				@temp0
				#mode
				1
				#button
				{__RESTORE__}
				1
				#button
				{__RESTART__}
				2
				#button
				{____QUIT____}
				3
				#icon
				deadIcon
				1
				0
			)
			(1
				(gGame restore:)
			)
			(2
				(gGame restart:)
			)
			(3
				(= gQuit 1)
				(break)
			)
		)
	)
)

(procedure (SetScore param1 param2)
	(if (> argc 1)
		(if (not (IsFlag param2))
			(specialSound number: (if (> param1 0) 916 else 917) init: play:)
			(+= gScore param1)
			((ScriptID 0 1) doit:) ; statLine
			(SetFlag param2)
		)
	else
		(specialSound number: (if (> param1 0) 916 else 917) init: play:)
		(+= gScore param1)
		((ScriptID 0 1) doit:) ; statLine
	)
	(if global143
		(return)
	)
)

(procedure (AddToAddToPics)
	(gAddToPics add: &rest eachElementDo: #init doit:)
	(DisposeScript 806)
)

(procedure (AddToFeatures)
	(gFeatures add: &rest eachElementDo: #init)
	(DisposeScript 806)
)

(procedure (AddRansom param1)
	(+= gRansom param1)
	((ScriptID 0 1) doit:) ; statLine
	(DisposeScript 806)
)

(procedure (AddOutlaws param1)
	(+= gOutlaws param1)
	((ScriptID 0 1) doit:) ; statLine
	(DisposeScript 806)
)

(procedure (SetIcon param1 &tmp temp0)
	(if (>= argc 2)
		(= temp0 (Inv at: param1))
		(gTheIconBar select: (gTheIconBar at: 6) curInvIcon: temp0)
	else
		(= temp0 (gTheIconBar at: param1))
		(gTheIconBar select: temp0)
	)
	(gGame setCursor: (temp0 cursor:) 1)
	(DisposeScript 806)
)

(instance specialSound of Sound
	(properties
		flags 1
	)

	(method (check)
		(super check: &rest)
		(if (== prevSignal -1)
			(specialSound dispose:)
			(if (not (verseScript client:))
				(DisposeScript 806)
			)
		)
	)
)

(instance deadIcon of DCIcon
	(properties
		view 903
		loop 1
		cycleSpeed 24
	)

	(method (init)
		((= cycler (End new:)) init: self)
	)
)

(instance verseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(gTheIconBar disable:)
				(= cycles 2)
			)
			(1
				(self setScript: (ScriptID 855) self) ; versePrinter
			)
			(2
				(= cycles 2)
			)
			(3
				(gTheIconBar enable:)
				((gInventory at: 16) cel: 2) ; fulkScroll
				(self dispose:)
				(DisposeScript 806)
			)
		)
	)
)

