;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1015)
(include sci.sh)
(use Main)
(use RamaRoom)
(use SoundManager)
(use n1111)
(use VMDMovie)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	easyPickins 0
)

(local
	[local0 5] = [30 150 270 390 510]
	local5
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 (Random 0 2))) (== temp0 local5) ((= temp0 (Random 0 2)))
	)
	(switch (= local5 temp0)
		(0
			(proc1111_7 1008 0 137 0 0 195 0 self)
		)
		(1
			(proc1111_7 1009 213 28 0 0 195 0 self)
		)
		(2
			(proc1111_7 1010 433 137 0 0 195 0 self)
		)
	)
)

(instance easyPickins of RamaRoom
	(properties
		picture 61
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(WalkieTalkie plane: plane)
		(if (== gPrevRoomNum -1)
			(sierra_Splash play:)
		)
		(self setScript: introScript)
		(if (== gPrevRoomNum 15) ; prologue
			(DisposeScript 16)
		)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (gUser canInput:) (== (event type:) evKEYBOARD))
			(switch (event message:)
				($0018
					(gGame quitGame:)
					(event claimed: 1)
				)
				(KEY_ALT_x
					(gGame quitGame:)
					(event claimed: 1)
				)
			)
		)
		(event claimed:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(WalkieTalkie plane: 0)
		(if (!= gNewRoomNum 1300) ; creditRoom
			(SoundManager fadeMusic: 0 20 10 1)
		)
		(self drawPic: 61)
		(proc1111_6)
		(buttonSet release:)
		(super dispose: &rest)
	)
)

(instance delayButtons of Script ; UNUSED
	(properties)

	(method (init)
		(= register 0)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (gThePlane onMe: event) register)
			(= ticks 0)
			(self cue:)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= register 1)
				(= ticks 180)
			)
			(2
				(= register 0)
				(buttonSet eachElementDo: #show)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class GenButton of View
	(properties
		isDownOnMe 0
	)

	(method (init)
		(&= signal $efff)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (doit &tmp temp0)
		(if (self onMe: (= temp0 (gUser curEvent:)))
			(cond
				((and (& evMOUSEBUTTON (temp0 type:)) (!= cel 2))
					(= cel 2)
					(= isDownOnMe 1)
				)
				((not cel)
					(= cel 1)
				)
			)
		else
			(if isDownOnMe
				(= isDownOnMe 0)
			)
			(if cel
				(= cel 0)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evMOUSERELEASE)
					(self onMe: event)
					(self isNotHidden:)
					isDownOnMe
				)
				(= isDownOnMe 0)
				(self cel: 0)
				(UpdateScreenItem self)
				(FrameOut)
				(self action:)
				(event claimed: 1)
				(return 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (action))
)

(instance newButn of GenButton
	(properties
		x -7
		y 353
		view 1015
	)

	(method (action)
		(gGame newGame:)
	)
)

(instance loadButn of GenButton
	(properties
		x 150
		y 352
		view 1015
		loop 1
	)

	(method (action)
		(gGame panelObj: gGame panelSelector: 83)
	)
)

(instance proButn of GenButton
	(properties
		x 277
		y 352
		view 1015
		loop 2
	)

	(method (action)
		(gCurRoom newRoom: 15) ; prologue
	)
)

(instance credButn of GenButton
	(properties
		x 387
		y 352
		view 1015
		loop 3
	)

	(method (action)
		(gCurRoom newRoom: 1300) ; creditRoom
	)
)

(instance vidButn of GenButton
	(properties
		x 486
		y 345
		view 1015
		loop 4
	)

	(method (action)
		(gCurRoom newRoom: 89) ; videoMenu
	)
)

(instance buttonSet of Set
	(properties)
)

(instance introScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD)) (< state 3))
			(proc1111_6)
			(leye setLoop: 6)
			(meye setLoop: 6)
			(reye setLoop: 6)
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SoundManager stopMusic:)
				(SoundManager playMusic: 0 1 1001)
				(leye init: setLoop: 6 setPri: 190)
				(meye init: setLoop: 5 setPri: 190)
				(reye init: setLoop: 5 setPri: 190)
				(proc1111_7 1000 0 137 0 0 198 0 self)
			)
			(1
				(meye setLoop: 6 posn: 213 214)
				(proc1111_7 1001 213 28 0 0 198 0 self)
			)
			(2
				(reye setLoop: 6 posn: 433 327)
				(proc1111_7 1002 433 137 0 0 198 0 self)
			)
			(3
				(leye dispose:)
				(meye dispose:)
				(reye dispose:)
				(gCurRoom drawPic: 1000)
				(ramaTitle init: setLoop: 7 setPri: 200)
				(SoundManager stopMusic: playMusic: 0 -1 5010)
				(buttonSet
					add: newButn loadButn proButn credButn vidButn
					eachElementDo: #init
					eachElementDo: #show
				)
				(gGame handsOn:)
				(= cycles 1)
			)
			(4
				(RemapColors 2 238 40) ; ByPercent
				(= start state)
				(proc1111_7 1003 0 0 0 0 255 0 self)
			)
			(5
				(localproc_0)
			)
			(6
				(proc1111_7 1004 0 0 0 0 255 0 self)
			)
			(7
				(localproc_0)
			)
			(8
				(proc1111_7 1005 0 0 0 0 255 0 self)
			)
			(9
				(proc1111_7 1007 0 0 0 0 255 0 self)
			)
			(10
				(localproc_0)
			)
			(11
				(proc1111_7 1006 0 0 0 0 255 0 self)
			)
			(12
				(proc1111_7 1008 0 137 0 0 195 0 self)
			)
			(13
				(proc1111_7 1009 213 28 0 0 195 0 self)
			)
			(14
				(proc1111_7 1010 433 137 0 0 195 0 self)
			)
			(15
				(self init:)
			)
		)
	)
)

(instance ramaTitle of View
	(properties
		x 39
		y 326
		view 1015
		loop 7
	)
)

(instance leye of View
	(properties
		y 321
		view 1015
		loop 5
	)
)

(instance meye of View
	(properties
		x 213
		y 214
		view 1015
		loop 5
		cel 1
	)
)

(instance reye of View
	(properties
		x 433
		y 327
		view 1015
		loop 5
		cel 2
	)
)

(instance sierra_Splash of VMDMovie
	(properties
		movieName 100
		x 112
		y 84
	)

	(method (play)
		(|= waitEvents $0004)
		(super play: &rest)
	)
)

