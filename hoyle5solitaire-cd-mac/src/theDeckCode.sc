;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use ManualSort)
(use klondike)
(use Print)
(use GameControls)
(use Actor)
(use System)

(public
	theDeckCode 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
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
			(iconBackLeft theObj: iconBackLeft selector: #doit yourself:)
			(iconBackRight theObj: iconBackRight selector: #doit yourself:)
			(iconSoundLeft theObj: iconSoundLeft selector: #doit yourself:)
			(iconSoundRight theObj: iconSoundRight selector: #doit yourself:)
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(= local3 global878)
	(switch global878
		(0
			(= local4 6)
		)
		(31
			(= local4 0)
		)
		(32
			(= local4 1)
		)
		(33
			(= local4 2)
		)
		(34
			(= local4 3)
		)
		(35
			(= local4 4)
		)
		(36
			(= local4 5)
		)
		(37
			(= local4 7)
		)
		(else
			(= local4 6)
		)
	)
	(= local5 local4)
	(gGameControls show:)
)

(instance theDeckCode of Code
	(properties)

	(method (doit)
		(if global921
			(Print
				x: 300
				y: 358
				ticks: 400
				margin: 4
				fore: 0
				mode: 1
				addBitmap: 917 5 0
				addText: {Room Disabled In Laptop Version} 35 11
				init:
			)
			(return)
		else
			(Platform 0 2 1)
			(localproc_0)
			(Platform 0 2 0)
		)
	)
)

(instance deckControls of HoyleGameControls
	(properties)
)

(instance deckWindow of InvisibleWindow
	(properties)

	(method (init &tmp temp0)
		(= top (/ (- gScreenHeight 288) 2))
		(= left (/ (- gScreenWidth 350) 2))
		(= bottom (+ (/ (- gScreenHeight 288) 2) 288))
		(= right (+ (/ (- gScreenWidth 350) 2) 350))
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 904 0 0 0 0 15 self)
		(soundView init:)
		(backgroundView init:)
		(deckView init:)
	)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 228
		nsTop 160
		x 228
		y 160
		signal 387
		mainView 904
		mainLoop 3
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(if global896
			(switch local4
				(0
					(= global878 31)
				)
				(1
					(= global878 32)
				)
				(2
					(= global878 33)
				)
				(3
					(= global878 34)
				)
				(4
					(= global878 35)
				)
				(5
					(= global878 36)
				)
				(7
					(= global878 37)
				)
				(else
					(= global878 0)
				)
			)
		)
		(if
			(or
				(!= local1 global385)
				(!= local2 global384)
				(!= local3 global878)
				(!= local7 local6)
				(!= local5 local4)
			)
			(proc6005_4 local6)
			(gGame_opt doit: 3)
			(global929 doit: 3)
		)
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
		(if (or (!= local5 local4) (and (== local4 6) (== local5 local4)))
			(if global878
				(PlaySong play: (+ 50 global878))
			)
			(if (> 38 global878 30)
				(gSong setLoop: -1)
			else
				(gSong setLoop: 1)
			)
		)
		(soundView dispose:)
		(deckView dispose:)
		(backgroundView dispose:)
	)
)

(instance iconDeckLeft of ControlIcon
	(properties
		nsLeft 221
		nsTop 126
		x 221
		y 126
		signal 387
		mainView 904
		mainLoop 1
		highlightColor -1
	)

	(method (doit param1 &tmp temp0)
		(if (== (param1 modifiers:) 15)
			(= temp0 21)
		else
			(= temp0 13)
		)
		(if (< (-- global384) 0)
			(= global384 (- temp0 1))
		)
		(deckView setCel: global384)
		(deckView doit:)
	)
)

(instance iconDeckRight of ControlIcon
	(properties
		nsLeft 262
		nsTop 126
		x 262
		y 126
		signal 387
		mainView 904
		mainLoop 2
		highlightColor -1
	)

	(method (doit param1 &tmp temp0)
		(if (== (param1 modifiers:) 15)
			(= temp0 21)
		else
			(= temp0 13)
		)
		(if (> (++ global384) (- temp0 1))
			(= global384 0)
		)
		(deckView setCel: global384)
		(deckView doit:)
	)
)

(instance iconBackLeft of ControlIcon
	(properties
		nsLeft 24
		nsTop 126
		x 24
		y 126
		signal 387
		mainView 904
		mainLoop 1
		highlightColor -1
	)

	(method (doit)
		(if (< (-- global385) 0)
			(= global385 9)
		)
		(backgroundView setCel: global385)
		(backgroundView doit:)
		(proc0_7)
	)
)

(instance iconBackRight of ControlIcon
	(properties
		nsLeft 65
		nsTop 126
		x 65
		y 126
		signal 387
		mainView 904
		mainLoop 2
		highlightColor -1
	)

	(method (doit)
		(if (> (++ global385) 9)
			(= global385 0)
		)
		(backgroundView setCel: global385)
		(backgroundView doit:)
		(proc0_7)
	)
)

(instance iconSoundLeft of ControlIcon
	(properties
		nsLeft 123
		nsTop 126
		x 123
		y 126
		signal 387
		mainView 904
		mainLoop 1
		highlightColor -1
	)

	(method (doit)
		(if (not global527)
			(if (< (-- local4) 0)
				(= local4 7)
			)
			(if (>= local4 1)
				(= global220 1)
			else
				(= global220 0)
			)
			(soundView setCel: local4)
			(soundView doit:)
			(switch local4
				(0
					(= global878 31)
				)
				(1
					(= global878 32)
				)
				(2
					(= global878 33)
				)
				(3
					(= global878 34)
				)
				(4
					(= global878 35)
				)
				(5
					(= global878 36)
				)
				(7
					(= global878 37)
				)
				(else
					(= global878 0)
				)
			)
			(gSong stop:)
			(if (> 38 global878 30)
				(PlaySong play: (+ 50 global878))
			)
		)
		(proc0_7)
	)
)

(instance iconSoundRight of ControlIcon
	(properties
		nsLeft 164
		nsTop 126
		x 164
		y 126
		signal 387
		mainView 904
		mainLoop 2
		highlightColor -1
	)

	(method (doit)
		(if (not global527)
			(if (> (++ local4) 7)
				(= local4 0)
			)
			(if (>= local4 7)
				(= global220 1)
			else
				(= global220 0)
			)
			(soundView setCel: local4)
			(soundView doit:)
			(switch local4
				(0
					(= global878 31)
				)
				(1
					(= global878 32)
				)
				(2
					(= global878 33)
				)
				(3
					(= global878 34)
				)
				(4
					(= global878 35)
				)
				(5
					(= global878 36)
				)
				(7
					(= global878 37)
				)
				(else
					(= global878 0)
				)
			)
			(gSong stop:)
			(if (> 38 global878 30)
				(PlaySong play: (+ 50 global878))
			)
		)
		(proc0_7)
	)
)

(instance soundView of View
	(properties)

	(method (init)
		(self view: 904 setLoop: 5 cel: local4 posn: 114 33 setPri: 15)
		(super init: ((deckWindow casts:) at: 0))
	)
)

(instance backgroundView of View
	(properties)

	(method (init)
		(self
			view: 904
			setLoop: 4
			cel: global385
			posn: 15 33
			setPri: 15
			plane: deckWindow
		)
		(super init: ((deckWindow casts:) at: 0))
	)
)

(instance deckView of View
	(properties)

	(method (init)
		(self
			view: 904
			setLoop: 6
			cel: global384
			posn: 212 33
			setPri: 15
			plane: deckWindow
		)
		(super init: ((deckWindow casts:) at: 0))
	)
)

