;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 128)
(include sci.sh)
(use Main)
(use Interface)
(use bordWindow)
(use DCIcon)
(use Save)

(public
	EgoDead 0
)

(procedure (EgoDead)
	(HandsOff)
	(Wait 5)
	(gSounds eachElementDo: #dispose)
	(gRmMusic number: 32 loop: 1 priority: 15 play:)
	(if argc
		(Print &rest #window BorderedWindow #width 0)
	)
	(HandsOn)
	(repeat
		(switch
			(Print ; "Another quest turned to dust, Another feast for the worms."
				128
				0
				#window
				SysWindow
				#button
				{Restore}
				1
				#button
				{ Restart }
				2
				#button
				{ Quit }
				3
				#icon
				myIcon
				0
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

(instance myIcon of DCIcon
	(properties
		view 999
		cycleSpeed 14
	)
)

(instance BorderedWindow of bordWindow
	(properties)
)

