;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use Character)
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

(instance chooseGame of Rm
	(properties
		picture 950
		style 10
	)

	(method (init &tmp temp0)
		(super init:)
		(= global459 0)
		(= global193 0)
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
		(if (OneOf gPrevRoomNum 100 200 300 400 500 600 700 800) ; crazy8s, oldMaid, heartsGame, ginRummy, cribbage, klondike, bridge, euchre
			(gSong stop:)
			(PlaySong play: 1010)
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
		(super dispose: &rest)
		(gTheIconBar enable:)
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
				(Wait 1)
				(Wait 10)
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
						((== global193 600)
							(if (>= global387 1) 21 else 600)
						)
						(global462
							(if (>= global387 1) 21 else global193)
						)
						(else 3)
					)
				)
				(gSong stop:)
				(switch global193
					(100
						(PlaySong play: 1050)
					)
					(200
						(PlaySong play: 1080)
					)
					(300
						(PlaySong play: 1070)
					)
					(400
						(PlaySong play: 1090)
					)
					(500
						(PlaySong play: 1020)
					)
					(600
						(PlaySong play: 1060)
					)
					(800
						(PlaySong play: 1099)
					)
					(700
						(PlaySong play: 1095)
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
		view 903
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global194 3)
			(event claimed: 1)
			(= global193 100)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseOldMaid of TrackingView
	(properties
		x 32
		y 80
		view 903
		loop 1
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global194 3)
			(event claimed: 1)
			(= global193 200)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseGinRummy of TrackingView
	(properties
		x 32
		y 110
		view 903
		loop 3
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global194 1)
			(event claimed: 1)
			(= global193 400)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseCribbage of TrackingView
	(properties
		x 32
		y 140
		view 903
		loop 4
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global194 1)
			(event claimed: 1)
			(= global193 500)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseHearts of TrackingView
	(properties
		x 185
		y 80
		view 903
		loop 2
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global194 3)
			(event claimed: 1)
			(= global193 300)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseBridge of TrackingView
	(properties
		x 185
		y 50
		view 903
		loop 6
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global194 3)
			(event claimed: 1)
			(= global193 700)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseKlondike of TrackingView
	(properties
		x 185
		y 140
		view 903
		loop 5
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global194 0)
			(event claimed: 1)
			(= global193 600)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseEuchre of TrackingView
	(properties
		x 185
		y 110
		view 903
		loop 7
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global194 3)
			(event claimed: 1)
			(= global193 800)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseTitle of View
	(properties
		x 160
		y 36
		view 903
		loop 8
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority stopUpd:)
		(super init:)
	)
)

