;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 914)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	doMusicControls 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconMusic init:)
	(unknown_914_4 init:)
	((= gGameControls musicControls)
		window: musicWindow
		helpIconItem: 0
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconMusic theObj: iconMusic selector: #doit yourself:)
			(unknown_914_4 theObj: unknown_914_4 selector: #doit yourself:)
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 914)
)

(instance doMusicControls of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance musicWindow of InvisibleWindow
	(properties
		top 57
		left 94
		bottom 144
		right 227
	)

	(method (open)
		(super open:)
		(DrawCel 914 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance musicControls of HoyleGameControls
	(properties)
)

(instance iconMusic of ControlIcon
	(properties
		view 914
		loop 1
		cel 0
		nsLeft 10
		nsTop 9
		signal 387
		highlightColor -1
		noun 3
		modNum 914
		helpVerb 4
	)

	(method (init)
		(switch global121
			(1
				(= loop 1)
			)
			(2
				(= loop 2)
			)
			(3
				(= loop 3)
			)
		)
	)

	(method (doit)
		(switch global121
			(1
				(= global121 (= loop 2))
				(gSong mute: 0)
			)
			(2
				(= global121 (= loop 3))
				(gSong mute: 1)
			)
			(3
				(= global121 (= loop 1))
				(gSong mute: 0)
			)
		)
		(self show:)
	)
)

(instance unknown_914_4 of ControlIcon
	(properties
		view 914
		loop 5
		cel 0
		nsLeft 10
		nsTop 40
		signal 387
		highlightColor -1
		modNum 914
	)

	(method (init)
		(switch global748
			(1
				(= loop 5)
			)
			(0
				(= loop 6)
			)
		)
	)

	(method (doit)
		(switch global748
			(1
				(= loop 6)
				(= global748 0)
				(= gMsgType 1)
			)
			(0
				(= loop 5)
				(= global748 1)
				(= gMsgType 2)
			)
		)
		(self show:)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 914
		loop 4
		cel 0
		nsLeft 10
		nsTop 58
		signal 387
		highlightColor -1
		noun 2
		modNum 914
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(gGame_opt doit: 3)
		(= gGameControls local0)
	)
)

