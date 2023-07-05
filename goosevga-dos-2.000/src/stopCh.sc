;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use GameControls)
(use IconBar)
(use Window)

(public
	stopCh 0
)

(local
	local0
)

(instance stopCh of GameControls
	(properties)

	(method (init)
		(= window stopWin)
		(self add: stopButton goButton)
		(super init: &rest)
	)

	(method (show)
		(self init:)
		(= curIcon (self at: 0))
		(super show: &rest)
		(return local0)
	)
)

(instance stopButton of IconI
	(properties
		view 801
		loop 0
		cel 0
		nsTop 1
		message 1
		signal 193
	)

	(method (highlight))

	(method (select)
		(if (super select: &rest)
			(= local0 message)
		)
	)
)

(instance goButton of IconI
	(properties
		view 801
		loop 5
		cel 0
		nsLeft 58
		nsTop 6
		message 0
		signal 193
	)

	(method (highlight))

	(method (select)
		(if (super select: &rest)
			(= local0 message)
			(return 1)
		)
	)
)

(instance stopWin of SysWindow
	(properties
		top 65
		left 83
		bottom 108
		right 188
		back 6
		lsTop 63
		lsLeft 81
		lsBottom 110
		lsRight 190
	)
)

