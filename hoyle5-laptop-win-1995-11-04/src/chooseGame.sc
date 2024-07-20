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

(instance chooseGame of Room
	(properties
		picture 908
		style 14
	)

	(method (init &tmp temp0)
		(super init:)
		(= gCardGameScriptNumber 0)
		(gTheIconBar enable:)
		(gSound flags: 1)
		(Characters eachElementDo: #active 0 eachElementDo: #dispose)
		(User canControl: 1)
		(gGame setCursor: 999)
		(Load rsVIEW 903)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(= global199 0)
		(KeyMouse setList: gTheKeyMouseList)
		(PlaySong play: 2 0 1)
		(self setScript: chooseScript)
		(RedrawCast)
		(if (not (HaveMouse))
			(KeyMouse setCursor: chooseCrazy8s)
		)
		(DoAudio 14 0) ; AudPreload
	)

	(method (dispose)
		(chooseOldMaid dispose: deleteKeyMouse:)
		(chooseGinRummy dispose: deleteKeyMouse:)
		(chooseCribbage dispose: deleteKeyMouse:)
		(chooseKlondike dispose: deleteKeyMouse:)
		(chooseBridge dispose: deleteKeyMouse:)
		(chooseCheckers dispose: deleteKeyMouse:)
		(chooseCrazy8s dispose: deleteKeyMouse:)
		(choosePoker dispose: deleteKeyMouse:)
		(chooseBackgammon dispose: deleteKeyMouse:)
		(chooseHearts dispose: deleteKeyMouse:)
		(quitButton dispose: deleteKeyMouse:)
		(UnLoad 128 903)
		(gTheIconBar enable:)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (== (chooseScript state:) 1)
			(chooseOldMaid handleEvent: event)
			(chooseGinRummy handleEvent: event)
			(chooseCribbage handleEvent: event)
			(chooseKlondike handleEvent: event)
			(chooseCheckers handleEvent: event)
			(chooseBridge handleEvent: event)
			(choosePoker handleEvent: event)
			(chooseBackgammon handleEvent: event)
			(chooseCrazy8s handleEvent: event)
			(chooseHearts handleEvent: event)
			(quitButton handleEvent: event)
		)
	)
)

(instance chooseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(chooseOldMaid init: addKeyMouse:)
				(chooseGinRummy init: addKeyMouse:)
				(chooseCribbage init: addKeyMouse:)
				(chooseKlondike init: addKeyMouse:)
				(chooseCheckers init: addKeyMouse:)
				(chooseBridge init: addKeyMouse:)
				(chooseCrazy8s init: addKeyMouse:)
				(chooseBackgammon init: addKeyMouse:)
				(choosePoker init: addKeyMouse:)
				(chooseHearts init: addKeyMouse:)
				(quitButton init: addKeyMouse:)
			)
			(2
				(= ticks 60)
			)
			(3
				(= gNewRoomNum
					(if (== gCardGameScriptNumber 600)
						(if (>= global387 1) gCardGameScriptNumber else 600)
					else
						3
					)
				)
			)
		)
	)
)

(class chooseTrackingView of TrackingView
	(properties)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not (event claimed:))
				(not (& (event type:) evMOUSERELEASE))
				(not (& (event type:) evVERB))
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
			)
			(cond
				((proc0_2 event)
					(self enterKey:)
					(= temp0 1)
					(event claimed: 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(if (= temp0 (self track:))
						(gSound2 play: 901)
					)
					(event claimed: 1)
				)
			)
		)
		(return temp0)
	)
)

(instance quitButton of chooseTrackingView
	(properties
		x 496
		y 420
		view 902
		loop 5
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global748 0)
			((ScriptID 930 0) init: 9131 0 900) ; yesNo
			(DisposeScript 930)
			(if global748
				(gGame quitGame:)
			)
		)
	)
)

(instance chooseCrazy8s of HoyleTrackingView
	(properties
		x 429
		y 282
		priority 8
		view 903
		loop 9
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

(instance chooseOldMaid of HoyleTrackingView
	(properties
		x 17
		y 261
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
			(= gCardGameScriptNumber 200)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseGinRummy of HoyleTrackingView
	(properties
		x 33
		y 167
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

(instance chooseCribbage of HoyleTrackingView
	(properties
		x 428
		y 59
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
			(= gPlayerCount 1)
			(event claimed: 1)
			(= gCardGameScriptNumber 500)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseHearts of HoyleTrackingView
	(properties
		x 213
		y 239
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
			(= gCardGameScriptNumber 300)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseBridge of HoyleTrackingView
	(properties
		x 216
		y 351
		priority 8
		view 903
		loop 8
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

(instance chooseKlondike of HoyleTrackingView
	(properties
		x 18
		y 65
		priority 8
		view 903
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

(instance choosePoker of HoyleTrackingView
	(properties
		x 193
		y 30
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
			(= gCardGameScriptNumber 1100)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseCheckers of HoyleTrackingView
	(properties
		x 430
		y 166
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
			(= gPlayerCount 1)
			(event claimed: 1)
			(= gCardGameScriptNumber 1200)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseBackgammon of HoyleTrackingView
	(properties
		x 204
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
			(= gCardGameScriptNumber 1300)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseTitle of View ; UNUSED
	(properties
		x 320
		y 86
		priority 8
		view 903
		loop 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)
)

