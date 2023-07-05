;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use crazy8s)
(use oldMaid)
(use heartsGame)
(use ginRummy)
(use cribbage)
(use klondike)
(use bridge)
(use pokerRoom)
(use checkers)
(use backgam)
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
		(2
			(= local4 0)
		)
		(3
			(= local4 5)
		)
		(4
			(= local4 3)
		)
		(5
			(= local4 4)
		)
		(6
			(= local4 2)
		)
		(7
			(= local4 1)
		)
		(else
			(= local4 6)
		)
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
		(if gAttitudeSetting
			(switch local4
				(0
					(= global878 2)
				)
				(1
					(= global878 7)
				)
				(2
					(= global878 6)
				)
				(3
					(= global878 4)
				)
				(4
					(= global878 5)
				)
				(5
					(= global878 3)
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
				(!= local6 local5)
			)
			(switch gCurRoomNum
				(100 ; crazy8s
					(proc100_2 local5)
					(gCrazy8s_opt doit: 3)
				)
				(200 ; oldMaid
					(proc200_4 local5)
					(gOldmaid_opt doit: 3)
				)
				(300 ; heartsGame
					(proc300_3 local5)
					(gHearts_opt doit: 3)
				)
				(400 ; ginRummy
					(proc400_5 local5)
					(gGinrummy_opt doit: 3)
				)
				(500 ; cribbage
					(proc500_2 local5)
					(gCribbage_opt doit: 3)
				)
				(600 ; klondike
					(proc600_4 local5)
					(gKlondike_opt doit: 3)
				)
				(700 ; bridge
					(proc700_11 local5)
					(gBridge_opt doit: 3)
				)
				(1100 ; pokerRoom
					(proc1100_16 local5)
					(gPoker_opt doit: 3)
				)
				(1300 ; backgam
					(proc1300_3 local5)
					(gBackgam_opt doit: 3)
				)
				(1200 ; checkers
					(proc1200_10 local5)
					(gCheckers_opt doit: 3)
				)
			)
		)
		(if (!= local2 global384)
			(if (and (> global117 0) (global117 size:))
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
		(if global878
			(PlaySong play: (+ 50 global878))
		else
			(PlaySong play: 51)
		)
		(gSong setLoop: 1)
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
			(= temp0 20)
		else
			(= temp0 12)
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
			(= temp0 20)
		else
			(= temp0 12)
		)
		(if (> (++ global384) (- temp0 1))
			(= global384 0)
		)
		(deckView setCel: global384)
		(deckView doit:)
	)
)

(instance iconBBMusic of ControlIcon ; UNUSED
	(properties
		nsLeft 33
		nsTop 160
		x 33
		y 160
		signal 387
		mainView 904
		mainLoop 7
		highlightColor -1
	)

	(method (init)
		(switch gCurRoomNum
			(100 ; crazy8s
				(= local5 (proc100_2))
			)
			(200 ; oldMaid
				(= local5 (proc200_4))
			)
			(300 ; heartsGame
				(= local5 (proc300_3))
			)
			(400 ; ginRummy
				(= local5 (proc400_5))
			)
			(500 ; cribbage
				(= local5 (proc500_2))
			)
			(600 ; klondike
				(= local5 (proc600_4))
			)
			(700 ; bridge
				(= local5 (proc700_11))
			)
			(1100 ; pokerRoom
				(= local5 (proc1100_16))
			)
			(1300 ; backgam
				(= local5 (proc1300_3))
			)
			(1200 ; checkers
				(= local5 (proc1200_10))
			)
		)
		(= local6 local5)
		(switch local5
			(1
				(= mainCel 0)
			)
			(0
				(= mainCel 2)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch local5
			(1
				(= mainCel 2)
				(gSong stop:)
				(= local5 0)
			)
			(0
				(= mainCel 0)
				(= local5 1)
				(gSong stop:)
				(if local5
					(if global878
						(PlaySong play: (+ 50 global878))
					else
						(PlaySong play: 51)
					)
				else
					(PlaySong play: 0)
				)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
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
			(= global385 7)
		)
		(backgroundView setCel: global385)
		(backgroundView doit:)
		(if (<= global385 6)
			(= local4 global385)
			(soundView setCel: local4)
			(soundView doit:)
		else
			(= local4 7)
			(soundView setCel: 7)
			(soundView doit:)
		)
		(switch local4
			(0
				(= global878 2)
			)
			(1
				(= global878 7)
			)
			(2
				(= global878 6)
			)
			(3
				(= global878 4)
			)
			(4
				(= global878 5)
			)
			(5
				(= global878 3)
			)
			(else
				(= global878 0)
			)
		)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
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
		(if (> (++ global385) 7)
			(= global385 0)
		)
		(backgroundView setCel: global385)
		(backgroundView doit:)
		(if (<= global385 6)
			(= local4 global385)
			(soundView setCel: local4)
			(soundView doit:)
		else
			(= local4 7)
			(soundView setCel: 7)
			(soundView doit:)
		)
		(switch local4
			(0
				(= global878 2)
			)
			(1
				(= global878 7)
			)
			(2
				(= global878 6)
			)
			(3
				(= global878 4)
			)
			(4
				(= global878 5)
			)
			(5
				(= global878 3)
			)
			(else
				(= global878 0)
			)
		)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
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
		(if (< (-- local4) 0)
			(= local4 6)
		)
		(soundView setCel: local4)
		(soundView doit:)
		(switch local4
			(0
				(= global878 2)
			)
			(1
				(= global878 7)
			)
			(2
				(= global878 6)
			)
			(3
				(= global878 4)
			)
			(4
				(= global878 5)
			)
			(5
				(= global878 3)
			)
			(else
				(= global878 0)
			)
		)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
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
		(if (> (++ local4) 6)
			(= local4 0)
		)
		(soundView setCel: local4)
		(soundView doit:)
		(switch local4
			(0
				(= global878 2)
			)
			(1
				(= global878 7)
			)
			(2
				(= global878 6)
			)
			(3
				(= global878 4)
			)
			(4
				(= global878 5)
			)
			(5
				(= global878 3)
			)
			(else
				(= global878 0)
			)
		)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
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

