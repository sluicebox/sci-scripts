;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use GameControls)
(use Window)

(public
	fpQuitGameControls 0
	quitWin 1
)

(class QuitControlIcon of ControlIcon
	(properties)

	(method (highlight param1 &tmp temp0)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(if (and argc param1)
			(= temp0 3)
		else
			(= temp0 0)
		)
		(DrawCel view loop temp0 nsLeft nsTop 15)
	)
)

(instance fpQuitGameControls of GameControls
	(properties)

	(method (init)
		(= gGameControls self)
		(self
			add: iconPlay iconQuit
			eachElementDo: #highlightColor 40
			eachElementDo: #lowlightColor 0
			curIcon: iconPlay
			window: quitWin
		)
		(super init: &rest)
	)

	(method (show)
		(gGame setCursor: 997)
		(super show: &rest)
	)

	(method (dispose)
		(super dispose:)
		(gGame setCursor: gNormalCursor)
		(DisposeScript 978)
		(DisposeScript 31)
	)
)

(instance quitWin of SysWindow
	(properties)

	(method (open &tmp temp0 [temp1 4] temp5 [temp6 20])
		(= type 128)
		(= left 48)
		(= top 24)
		(= right 272)
		(= bottom 176)
		(= lsLeft left)
		(= lsTop top)
		(= lsRight right)
		(= lsBottom bottom)
		(= priority 15)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(DrawCel 992 0 0 48 24 temp5) ; UNINIT
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(gGame setCursor: 999)
		(SetPort temp0)
	)
)

(instance iconQuit of QuitControlIcon
	(properties
		view 992
		loop 1
		cel 0
		nsLeft 184
		nsTop 59
		cursor 9
		message 8
		signal 451
		modNum 31
		helpVerb 7
	)

	(method (select)
		(= gQuit 1)
	)
)

(instance iconPlay of QuitControlIcon
	(properties
		view 992
		loop 2
		cel 0
		nsLeft 184
		nsTop 99
		cursor 9
		message 8
		signal 451
		modNum 31
		helpVerb 7
	)
)

