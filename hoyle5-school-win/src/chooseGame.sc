;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use h5Messager)
(use Game)
(use User)
(use Actor)
(use System)

(public
	chooseGame 0
)

(local
	[local0 15]
	local15
	[local16 10]
)

(instance chooseGame of Room
	(properties
		picture 950
		style 14
	)

	(method (init &tmp temp0)
		(super init:)
		(= global459 0)
		(= gCardGameScriptNumber 0)
		(gTheIconBar enable:)
		(gSound flags: 1)
		(= local15 0)
		(Characters eachElementDo: #active 0 eachElementDo: #dispose)
		(User canControl: 1)
		(Load rsVIEW 903)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(= global199 0)
		(KeyMouse setList: gTheKeyMouseList)
		(self setScript: chooseScript)
		(if (OneOf gPrevRoomNum 100 200 300 400 500 600 700 800) ; crazy8s, oldMaid, heartsGame, ginRummy, cribbage, klondike
			(gSong stop:)
			(PlaySong play: 10)
		)
		(RedrawCast)
		(if (not (HaveMouse))
			(KeyMouse setCursor: chooseCrazy8s)
		)
	)

	(method (dispose)
		(chooseCrazy8s dispose: deleteKeyMouse:)
		(chooseOldMaid dispose: deleteKeyMouse:)
		(chooseHearts dispose: deleteKeyMouse:)
		(chooseGinRummy dispose: deleteKeyMouse:)
		(chooseCribbage dispose: deleteKeyMouse:)
		(chooseKlondike dispose: deleteKeyMouse:)
		(chooseEuchre dispose: deleteKeyMouse:)
		(chooseBridge dispose: deleteKeyMouse:)
		(UnLoad 128 903)
		(gTheIconBar enable:)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (== (chooseScript state:) 0)
			(chooseCrazy8s handleEvent: event)
			(chooseOldMaid handleEvent: event)
			(chooseHearts handleEvent: event)
			(chooseGinRummy handleEvent: event)
			(chooseCribbage handleEvent: event)
			(chooseKlondike handleEvent: event)
			(chooseEuchre handleEvent: event)
			(chooseBridge handleEvent: event)
		)
	)
)

(instance chooseScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 11])
		(switch (= state newState)
			(0
				(chooseCrazy8s init: addKeyMouse:)
				(chooseOldMaid init: addKeyMouse:)
				(chooseHearts init: addKeyMouse:)
				(chooseGinRummy init: addKeyMouse:)
				(chooseCribbage init: addKeyMouse:)
				(chooseKlondike init: addKeyMouse:)
				(chooseEuchre init: addKeyMouse:)
				(chooseBridge init: addKeyMouse:)
				(chooseTitle init:)
			)
			(1
				(RedrawCast)
				(= cycles 1)
			)
			(2
				(gSong fade: 0 5 10 1)
				(= ticks 60)
			)
			(3
				(gSound setLoop: 1)
				(gSound2 setLoop: 1)
				(= gNewRoomNum
					(cond
						((== gCardGameScriptNumber 600)
							(if (>= global387 1) gCardGameScriptNumber else 600)
						)
						(global462
							(if (>= global387 1) gCardGameScriptNumber else gCardGameScriptNumber)
						)
						(else 3)
					)
				)
				(gSong stop:)
				(switch gCardGameScriptNumber
					(100
						(PlaySong play: 50)
					)
					(200
						(PlaySong play: 80)
					)
					(300
						(PlaySong play: 70)
					)
					(400
						(PlaySong play: 90)
					)
					(500
						(PlaySong play: 20)
					)
					(600
						(PlaySong play: 60)
					)
					(800
						(PlaySong play: 99)
					)
					(700
						(PlaySong play: 95)
					)
				)
			)
		)
	)
)

(instance chooseCrazy8s of TrackingView
	(properties
		x 32
		y 50
		priority 8
		view 903
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= gPlayerCount 3)
			(event claimed: 1)
			(= gCardGameScriptNumber 100)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseOldMaid of TrackingView
	(properties
		x 32
		y 80
		priority 8
		view 903
		loop 1
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= gPlayerCount 3)
			(event claimed: 1)
			(= gCardGameScriptNumber 200)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseGinRummy of TrackingView
	(properties
		x 32
		y 110
		priority 8
		view 903
		loop 3
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= gPlayerCount 1)
			(event claimed: 1)
			(= gCardGameScriptNumber 400)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseCribbage of TrackingView
	(properties
		x 32
		y 140
		priority 8
		view 903
		loop 4
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= gPlayerCount 1)
			(event claimed: 1)
			(= gCardGameScriptNumber 500)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseHearts of TrackingView
	(properties
		x 185
		y 80
		priority 8
		view 903
		loop 2
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= gPlayerCount 3)
			(event claimed: 1)
			(= gCardGameScriptNumber 300)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseBridge of TrackingView
	(properties
		x 185
		y 50
		priority 8
		view 903
		loop 6
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= gPlayerCount 3)
			(event claimed: 1)
			(= gCardGameScriptNumber 700)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseKlondike of TrackingView
	(properties
		x 185
		y 140
		priority 8
		view 903
		loop 5
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= gPlayerCount 0)
			(event claimed: 1)
			(= gCardGameScriptNumber 600)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseEuchre of TrackingView
	(properties
		x 185
		y 110
		priority 8
		view 903
		loop 7
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= gPlayerCount 3)
			(event claimed: 1)
			(= gCardGameScriptNumber 800)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseTitle of View
	(properties
		x 160
		y 36
		priority 8
		view 903
		loop 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)
)

