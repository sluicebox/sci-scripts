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
		plane: deckWindow
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
		left 95
		top 43
		right 225
		bottom 163
	)

	(method (init &tmp temp0)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 904 0 0 0 0 15 self)
		(proc0_10 904 4 global384 24 22 15 self)
		(proc0_10 904 5 global385 69 22 15 self)
	)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 41
		nsTop 91
		x 41
		y 91
		signal 387
		mainView 904
		mainLoop 3
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(or (!= local1 global385) (!= local2 global384))
		(if (!= local2 global384)
			(if (and (> gTheHands 0) (gTheHands size:))
				(gTheHands eachElementDo: #newBacks)
			)
			(= global388 1)
			(if (Deck size:)
				(Deck newBacks:)
			)
			(if global419
				(global419 newBacks:)
			)
		)
	)
)

(instance iconDeckLeft of ControlIcon
	(properties
		nsLeft 21
		nsTop 70
		x 21
		y 70
		signal 387
		mainView 904
		mainLoop 1
		highlightColor -1
	)

	(method (doit)
		(if (< (-- global384) 0)
			(= global384 8)
		)
		(proc0_10 904 4 global384 24 22 15 deckWindow)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconDeckRight of ControlIcon
	(properties
		nsLeft 41
		nsTop 70
		x 41
		y 70
		signal 387
		mainView 904
		mainLoop 2
		highlightColor -1
	)

	(method (doit)
		(if (> (++ global384) 8)
			(= global384 0)
		)
		(proc0_10 904 4 global384 24 22 15 deckWindow)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconBoardLeft of ControlIcon
	(properties
		nsLeft 67
		nsTop 70
		x 67
		y 70
		signal 387
		mainView 904
		mainLoop 1
		highlightColor -1
	)

	(method (doit)
		(if (< (-- global385) 0)
			(= global385 9)
		)
		(proc0_10 904 5 global385 69 22 15 deckWindow)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconBoardRight of ControlIcon
	(properties
		nsLeft 87
		nsTop 70
		x 87
		y 70
		signal 387
		mainView 904
		mainLoop 2
		highlightColor -1
	)

	(method (doit)
		(if (> (++ global385) 9)
			(= global385 0)
		)
		(proc0_10 904 5 global385 69 22 15 deckWindow)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

