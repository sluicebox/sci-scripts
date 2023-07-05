;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use Print)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro 0
)

(local
	local0
	local1
	local2
	local3
)

(instance intro of Rm
	(properties
		picture 950
		style 10
	)

	(method (init &tmp temp0)
		(super init:)
		(gTheIconBar disable:)
		(= local3 gSpeed)
		(= gSpeed 0)
		(Load rsVIEW 920)
		(Load rsVIEW 921)
		(Load rsVIEW 919)
		(Load rsVIEW 923)
		(Load rsFONT 2107)
		(= local2 0)
		(= global107 0)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(gGame setCursor: (= gTheCursor 996) 1)
		(if (not global119)
			(tradeMark
				view: 919
				loop: 8
				cel: 0
				setPri: 8
				posn: 162 132
				init:
				stopUpd:
			)
		)
		(self setScript: introScript)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(return)
		)
		(if (not (event claimed:))
			(if local2
				(if (event type:)
					(event claimed: 1)
					(if
						(and
							(or
								(& (event type:) evMOUSEBUTTON)
								(& (event type:) evKEYBOARD)
							)
							(> (event y:) 0)
						)
						(proc0_1)
						(gSound play: 901)
						(gCurRoom newRoom: 975) ; chooseGame
					)
				)
			else
				(playTheGame handleEvent: event)
				(introduction handleEvent: event)
				(aboutTheGame handleEvent: event)
				(tutorial handleEvent: event)
				(information handleEvent: event)
				(quitTheGame handleEvent: event)
			)
		)
	)

	(method (dispose)
		(UnLoad 128 920)
		(UnLoad 128 921)
		(UnLoad 128 919)
		(if (== gSpeed 0)
			(= gSpeed local3)
		)
		(playTheGame dispose: deleteKeyMouse:)
		(introduction dispose: deleteKeyMouse:)
		(aboutTheGame dispose: deleteKeyMouse:)
		(tutorial dispose: deleteKeyMouse:)
		(information dispose: deleteKeyMouse:)
		(quitTheGame dispose: deleteKeyMouse:)
		(super dispose:)
	)
)

(instance palScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 75)
			)
			(1
				(= ticks 75)
			)
			(2
				(-= state 2)
				(= ticks 1)
			)
		)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame setCursor: (= gTheCursor 996) 1)
				(if global119
					(= ticks 1)
					(= state 17)
				else
					(= ticks 30)
				)
				(= local0 0)
			)
			(1
				(gSong stop: setPri: 1 setLoop: -1)
				(PlaySong play: 10 0 1)
				(= ticks 250)
			)
			(2
				(tradeMark dispose:)
				(= ticks 2)
			)
			(3
				(= global119 1)
				(hoyleWord
					view: 921
					setLoop: 0
					posn: 26 18
					setPri: 15
					setCycle: End self
					cycleSpeed: 4
					init:
				)
			)
			(4
				(hoyleWord addToPic:)
				(= ticks 2)
			)
			(5
				(switch local0
					(0
						(= temp0 75)
						(= temp1 74)
					)
					(1
						(= temp0 37)
						(= temp1 75)
					)
					(2
						(= temp0 18)
						(= temp1 86)
					)
					(3
						(= temp0 18)
						(= temp1 121)
					)
					(4
						(= temp0 30)
						(= temp1 147)
					)
					(5
						(= temp0 88)
						(= temp1 93)
					)
					(6
						(= temp0 87)
						(= temp1 73)
					)
					(7
						(= temp0 83)
						(= temp1 111)
					)
				)
				(DrawCel 920 0 local0 temp0 temp1 15)
				(= ticks 1)
			)
			(6
				(if (== (++ local0) 8)
					(= local0 0)
				else
					(-= state 2)
				)
				(= ticks 1)
			)
			(7
				(switch local0
					(0
						(= temp0 105)
						(= temp1 101)
					)
					(1
						(= temp0 105)
						(= temp1 101)
					)
					(2
						(= temp0 126)
						(= temp1 96)
					)
					(3
						(= temp0 126)
						(= temp1 88)
					)
					(4
						(= temp0 164)
						(= temp1 88)
					)
					(5
						(= temp0 152)
						(= temp1 114)
					)
				)
				(DrawCel 920 1 local0 temp0 temp1 15)
				(= ticks 1)
			)
			(8
				(if (== (++ local0) 6)
					(= local0 0)
				else
					(-= state 2)
				)
				(= ticks 1)
			)
			(9
				(switch local0
					(0
						(= temp0 152)
						(= temp1 83)
					)
					(1
						(= temp0 198)
						(= temp1 79)
					)
					(2
						(= temp0 186)
						(= temp1 105)
					)
					(3
						(= temp0 220)
						(= temp1 73)
					)
					(4
						(= temp0 218)
						(= temp1 73)
					)
					(5
						(= temp0 241)
						(= temp1 71)
					)
					(6
						(= temp0 241)
						(= temp1 67)
					)
					(7
						(= temp0 240)
						(= temp1 67)
					)
					(8
						(= temp0 228)
						(= temp1 52)
					)
				)
				(DrawCel 920 2 local0 temp0 temp1 15)
				(= ticks 1)
			)
			(10
				(if (== (++ local0) 9)
					(= local0 0)
				else
					(-= state 2)
				)
				(= ticks 1)
			)
			(11
				(switch local0
					(0
						(= temp0 19)
						(= temp1 156)
					)
					(1
						(= temp0 57)
						(= temp1 156)
					)
					(2
						(= temp0 94)
						(= temp1 147)
					)
					(3
						(= temp0 127)
						(= temp1 135)
					)
				)
				(DrawCel 920 3 local0 temp0 temp1 15)
				(= ticks 1)
			)
			(12
				(if (== (++ local0) 4)
					(= local0 0)
				else
					(-= state 2)
				)
				(= ticks 1)
			)
			(13
				(switch local0
					(0
						(= temp0 169)
						(= temp1 127)
					)
					(1
						(= temp0 200)
						(= temp1 119)
					)
					(2
						(= temp0 231)
						(= temp1 112)
					)
					(3
						(= temp0 263)
						(= temp1 112)
					)
					(4
						(= temp0 292)
						(= temp1 116)
					)
					(5
						(= temp0 291)
						(= temp1 139)
					)
				)
				(DrawCel 920 4 local0 temp0 temp1 15)
				(= ticks 1)
			)
			(14
				(if (== (++ local0) 6)
					(= local0 0)
				else
					(-= state 2)
				)
				(= ticks 1)
			)
			(15
				(cardGameWord
					view: 921
					setLoop: 1
					posn: 120 147
					setPri: 15
					cycleSpeed: 5
					setCycle: End self
					init:
				)
			)
			(16
				(cardGameWord addToPic:)
				(= ticks 50)
			)
			(17
				(DrawPic (intro picture:) 9)
				(= ticks 1)
			)
			(18
				(while ((= temp2 (Event new:)) type:)
					(temp2 type: evNULL)
					(temp2 dispose:)
				)
				(temp2 dispose:)
				(proc0_3)
				(gTheIconBar enable:)
				(gGame setCursor: 999 1)
				(= local2 0)
				(panel init:)
				(playTheGame init: addKeyMouse:)
				(introduction init: addKeyMouse:)
				(aboutTheGame init: addKeyMouse:)
				(tutorial init: addKeyMouse:)
				(information init: addKeyMouse:)
				(quitTheGame init: addKeyMouse:)
				(= cycles 1)
			)
			(19
				(if (not (HaveMouse))
					(KeyMouse setCursor: playTheGame)
				)
			)
			(20
				(switch local1
					(1
						(gCurRoom newRoom: 19) ; credits
					)
					(2
						(gCurRoom newRoom: 975) ; chooseGame
					)
					(3
						(gCurRoom newRoom: 910) ; helpDemo
					)
					(4
						(= gQuit 1)
					)
					(5
						((ScriptID 4 0) init:) ; aboutCode
						(DisposeScript 4)
					)
				)
				(= state 19)
			)
		)
	)
)

(instance tradeMark of View
	(properties)
)

(instance hoyleWord of Actor
	(properties)
)

(instance cardGameWord of Actor
	(properties)
)

(instance panel of View
	(properties
		view 919
		priority 7
	)

	(method (init)
		(self setLoop: loop posn: 75 41 setPri: priority stopUpd:)
		(super init:)
	)
)

(instance playTheGame of TrackingView
	(properties
		view 919
		loop 2
		priority 8
		offsetX 88
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 39) (+ (panel y:) 12)
			setPri: priority
			stopUpd:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local1 loop)
			(introScript cue:)
		)
		(event claimed:)
	)
)

(instance introduction of TrackingView
	(properties
		view 919
		loop 1
		priority 8
		offsetX 88
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 39) (+ (panel y:) 30)
			setPri: priority
			stopUpd:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local1 loop)
			(introScript cue:)
		)
		(event claimed:)
	)
)

(instance aboutTheGame of TrackingView
	(properties
		view 919
		loop 5
		priority 8
		offsetX 88
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 39) (+ (panel y:) 48)
			setPri: priority
			stopUpd:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local1 loop)
			(introScript cue:)
		)
		(event claimed:)
	)
)

(instance tutorial of TrackingView
	(properties
		view 919
		loop 3
		priority 8
		offsetX 88
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 39) (+ (panel y:) 66)
			setPri: priority
			stopUpd:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local1 loop)
			(introScript cue:)
		)
		(event claimed:)
	)
)

(instance information of TrackingView
	(properties
		view 919
		loop 7
		priority 8
		offsetX 88
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 39) (+ (panel y:) 84)
			setPri: priority
			stopUpd:
		)
		(super init:)
	)

	(method (handleEvent event &tmp temp0 [temp1 500])
		(if (super handleEvent: event)
			(event claimed: 1)
			(for ((= temp0 1)) (<= temp0 11) ((++ temp0))
				(Message msgGET 4 3 0 0 temp0 @temp1)
				(if (not (Print addText: @temp1 init:))
					(break)
				)
			)
		)
		(event claimed:)
	)
)

(instance quitTheGame of TrackingView
	(properties
		view 919
		loop 4
		priority 8
		offsetX 88
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 39) (+ (panel y:) 102)
			setPri: priority
			stopUpd:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local1 loop)
			(introScript cue:)
		)
		(event claimed:)
	)
)

