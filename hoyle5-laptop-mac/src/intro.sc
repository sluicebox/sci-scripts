;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use RulesPrint)
(use Str)
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
	[local2 2]
	local4
	local5
	local6
)

(procedure (localproc_0)
	(= local1 1)
	(panel hide:)
	(playTheGame hide:)
	(introduction hide:)
	(aboutTheGame hide:)
	(tutorial hide:)
	(information hide:)
	(quitTheGame hide:)
)

(procedure (localproc_1 param1)
	(tempView view: param1 setCycle: End (gCurRoom script:))
)

(procedure (localproc_2)
	(= global469 1)
	(= global470 1)
	(= global471 1)
	(if
		(or
			(== gNewRoomNum 300) ; heartsGame
			(== gNewRoomNum 100) ; crazy8s
			(== gNewRoomNum 700) ; bridge
			(== gNewRoomNum 1100) ; pokerRoom
			(== gNewRoomNum 200) ; oldMaid
		)
		(gChar1 setChar: 1 0)
		(gChar2 setChar: 2 5)
		(gChar3 setChar: 3 6)
	else
		(switch (Random 0 2)
			(0
				(gChar1 setChar: 1 0)
			)
			(1
				(gChar1 setChar: 1 5)
			)
			(2
				(gChar1 setChar: 1 6)
			)
		)
	)
)

(instance oneCredit of Prop ; UNUSED
	(properties)
)

(instance intro of Room
	(properties
		picture 908
		style 14
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(super init:)
		(= temp1 (Str new:))
		(if (not global921)
			(Load 140 901) ; WAVE
			(Lock 140 901) ; WAVE
			(Load 140 902) ; WAVE
			(Lock 140 902) ; WAVE
			(Load 140 903) ; WAVE
			(Lock 140 903) ; WAVE
			(Load 140 904) ; WAVE
			(Lock 140 904) ; WAVE
			(Load 140 905) ; WAVE
			(Lock 140 905) ; WAVE
			(Load 140 906) ; WAVE
			(Lock 140 906) ; WAVE
			(Load 140 907) ; WAVE
			(Lock 140 907) ; WAVE
		)
		(GetConfig {Game} temp1)
		(if (temp1 size:)
			(= global924 (= local5 (temp1 asInteger:)))
			(= temp2 0)
			(= gPlayerCount
				(switch (= gCardGameScriptNumber local5)
					(100 3)
					(200 3)
					(300 3)
					(400 1)
					(500 1)
					(700 3)
					(1100 3)
					(1200 1)
					(1300 1)
					(else 0)
				)
			)
		else
			(GetConfig {JumpTo} temp1)
			(if (temp1 size:)
				(= temp2 (temp1 asInteger:))
			else
				(= temp2 0)
			)
		)
		(temp1 dispose:)
		(gTheIconBar disable:)
		(= local1 1)
		(= global107 0)
		(gGame setCursor: gTheCursor 1 319 199)
		(if temp2
			(= gCardGameScriptNumber temp2)
			(if (!= (= gNewRoomNum temp2) 600)
				(localproc_2)
			)
			(DisableCursor)
			(gTheIconBar enable:)
			(return)
		)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(self setScript: introScript)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(return)
		)
		(if (not (event claimed:))
			(if local1
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
						(gSound play: 901)
						(if (== (self script:) introScript)
							(if local5
								(self setScript: introScript)
								((self script:) state: 11 cue:)
							else
								(PlaySong play: 0)
								(gCurRoom newRoom: 975) ; chooseGame
							)
						else
							(PlaySong play: 1 0 1)
							(self setScript: introScript)
							((self script:) state: 17 cue:)
						)
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
		(UnLoad 128 923)
		(UnLoad 128 951)
		(UnLoad 128 952)
		(UnLoad 128 953)
		(UnLoad 128 954)
		(UnLoad 128 955)
		(UnLoad 128 956)
		(UnLoad 128 957)
		(UnLoad 128 925)
		(UnLoad 145 19)
		(UnLoad 130 19)
		(playTheGame dispose: deleteKeyMouse:)
		(introduction dispose: deleteKeyMouse:)
		(aboutTheGame dispose: deleteKeyMouse:)
		(tutorial dispose: deleteKeyMouse:)
		(information dispose: deleteKeyMouse:)
		(quitTheGame dispose: deleteKeyMouse:)
		(super dispose:)
	)
)

(instance tempView of Prop
	(properties)
)

(instance introScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2)
		(switch (= state newState)
			(0
				(tempView view: 950 posn: 320 240 init: setPri: 1)
				(if global119
					(tempView view: 950)
					(= state 3)
					(= ticks 1)
				else
					(tempView view: 900)
					(= seconds 1)
				)
			)
			(1
				(gSong stop: setPri: 1 setLoop: -1)
				(PlaySong play: 1 0 1)
				(= ticks 120)
			)
			(2
				(tempView view: 950)
				(UnLoad 128 900)
				(= cycles 1)
			)
			(3
				(= ticks 120)
			)
			(4
				(= cycles 1)
				(if global119
					(= state 17)
				)
			)
			(5
				(tempView view: 925)
				(= ticks 120)
			)
			(6
				(if 0
					(= state 11)
					(= cycles 1)
				else
					(tempView view: 950)
					(UnLoad 128 925)
					(= cycles 1)
				)
			)
			(7
				(= state 17)
				(= cycles 1)
			)
			(12
				(= gNewRoomNum (if (== gCardGameScriptNumber 600) 600 else 3))
			)
			(13
				(= state 20)
				(= cycles 1)
			)
			(18
				(while ((= temp2 (Event new:)) type:)
					(temp2 type: evNULL)
					(temp2 dispose:)
				)
				(temp2 dispose:)
				(EnableCursor)
				(gGame setCursor: 999 1)
				(gTheIconBar enable:)
				(= local1 0)
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
				(= local6 0)
				(if (not (HaveMouse))
					(KeyMouse setCursor: playTheGame)
				)
				(if (not global119)
					(= local0 1)
					(= global119 1)
				)
				(= cycles (= ticks 0))
			)
			(20
				(switch local0
					(1
						(= local4 0)
						(PlaySong play: 2 0 1)
						(gCurRoom setScript: creditsScript)
					)
					(2
						(PlaySong play: 0)
						(gCurRoom newRoom: 975) ; chooseGame
					)
					(3
						(PlaySong play: 2 0 1)
						(proc821_0 910 8 0 0)
						(PlaySong play: 1 0 1)
					)
					(4
						(= gQuit 1)
					)
					(5
						(PlaySong play: 2 0 1)
						(proc821_0 4 4 0 0)
						(PlaySong play: 1 0 1)
					)
					(6
						(PlaySong play: 2 0 1)
						(proc821_0 5 7 1 0)
						(PlaySong play: 1 0 1)
					)
				)
				(= state 19)
			)
		)
	)
)

(instance tradeMark of View ; UNUSED
	(properties)
)

(instance panel of View
	(properties
		priority 107
		view 919
	)

	(method (init)
		(self setLoop: loop posn: 226 102 setPri: priority)
		(super init:)
	)
)

(instance playTheGame of TrackingView
	(properties
		priority 108
		view 919
		loop 1
		offsetX 176
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 14) (+ (panel y:) 16)
			setPri: priority
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if local5
				(introScript state: 11 cue:)
			else
				(= local0 2)
				(introScript cue:)
			)
		)
		(event claimed:)
	)
)

(instance introduction of TrackingView
	(properties
		priority 108
		view 919
		loop 2
		offsetX 176
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 14) (+ (panel y:) 59)
			setPri: priority
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local0 1)
			(introScript cue:)
		)
		(event claimed:)
	)
)

(instance aboutTheGame of TrackingView
	(properties
		priority 108
		view 919
		loop 3
		offsetX 176
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 14) (+ (panel y:) 102)
			setPri: priority
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local0 5)
			(introScript cue:)
		)
		(event claimed:)
	)
)

(instance tutorial of TrackingView
	(properties
		priority 108
		view 919
		loop 4
		offsetX 176
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 14) (+ (panel y:) 145)
			setPri: priority
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local0 3)
			(introScript cue:)
			1
		)
		(event claimed:)
	)
)

(instance information of TrackingView
	(properties
		priority 108
		view 919
		loop 5
		offsetX 176
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 14) (+ (panel y:) 188)
			setPri: priority
		)
		(super init:)
	)

	(method (handleEvent event &tmp [temp0 501])
		(if (== (event modifiers:) $000f) ; emALT | emCTRL | emSHIFT
			(= local6 1)
			(event modifiers: $0000)
		)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local0 6)
			(introScript cue:)
		)
		(event claimed:)
	)
)

(instance creditsScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(localproc_1 (+ local4 951))
				(++ local4)
			)
			(2
				(if local6
					(gSound play: (+ (* local4 10) 9500) self 127)
				else
					(= ticks 300)
				)
				(if (< local4 10)
					(-= state 3)
				)
			)
			(3
				(PlaySong play: 1 0 1)
				(= local1 0)
				(panel show:)
				(playTheGame show:)
				(introduction show:)
				(aboutTheGame show:)
				(tutorial show:)
				(information show:)
				(quitTheGame show:)
				(gCurRoom setScript: introScript)
			)
		)
	)
)

(instance quitTheGame of TrackingView
	(properties
		priority 108
		view 919
		loop 6
		offsetX 176
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ (panel x:) 14) (+ (panel y:) 231)
			setPri: priority
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local0 4)
			(introScript cue:)
		)
		(event claimed:)
	)
)

