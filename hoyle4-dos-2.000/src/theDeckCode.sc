;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use GameControls)
(use System)

(public
	theDeckCode 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(= local1 global385)
	(= local2 global384)
	((= gGameControls deckControls)
		window: deckWindow
		helpIconItem: 0
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconDeckLeft theObj: iconDeckLeft selector: #doit yourself:)
			(iconDeckRight theObj: iconDeckRight selector: #doit yourself:)
			(iconBoardLeft theObj: iconBoardLeft selector: #doit yourself:)
			(iconBoardRight theObj: iconBoardRight selector: #doit yourself:)
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance theDeckCode of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance deckControls of HoyleGameControls
	(properties)
)

(instance deckWindow of InvisibleWindow
	(properties
		top 43
		left 95
		bottom 163
		right 225
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 904 0 0 0 0 15)
		(DrawCel 904 4 global384 24 22 15)
		(DrawCel 904 5 global385 69 22 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 904
		loop 3
		cel 0
		nsLeft 41
		nsTop 91
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
		(if (or (!= local1 global385) (!= local2 global384))
			(gGame_opt doit: 3)
		)
		(if (!= local2 global384)
			(if (and (IsObject global117) (global117 size:))
				(global117 eachElementDo: #newBacks)
			)
			(= global388 1)
			(if (Deck size:)
				(Deck newBacks:)
			)
			(if global419
				(global419 newBacks:)
			)
		)
		(DisposeScript 13)
	)
)

(instance iconDeckLeft of ControlIcon
	(properties
		view 904
		loop 1
		cel 0
		nsLeft 21
		nsTop 70
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (< (-- global384) 0)
			(= global384 8)
		)
		(DrawCel 904 4 global384 24 22 15)
	)
)

(instance iconDeckRight of ControlIcon
	(properties
		view 904
		loop 2
		cel 0
		nsLeft 41
		nsTop 70
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (> (++ global384) 8)
			(= global384 0)
		)
		(DrawCel 904 4 global384 24 22 15)
	)
)

(instance iconBoardLeft of ControlIcon
	(properties
		view 904
		loop 1
		cel 0
		nsLeft 67
		nsTop 70
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (< (-- global385) 0)
			(= global385 9)
		)
		(DrawCel 904 5 global385 69 22 15)
	)
)

(instance iconBoardRight of ControlIcon
	(properties
		view 904
		loop 2
		cel 0
		nsLeft 87
		nsTop 70
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (> (++ global385) 9)
			(= global385 0)
		)
		(DrawCel 904 5 global385 69 22 15)
	)
)

