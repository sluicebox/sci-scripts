;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use KeyMouse)
(use InvisibleWindow)
(use Interface)
(use GameControls)
(use File)
(use Game)
(use User)
(use System)

(public
	chooseGame 0
)

(local
	local0
	local1
	local2
	[local3 4]
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	[local16 10]
)

(procedure (localproc_0)
	(= local2 gGameControls)
	(if (== global187 200)
		(checkers_opt doit:)
	)
	(cond
		((or (== global187 200) (== global187 300))
			(= global195 2)
		)
		((== global187 400)
			(= global195 2)
			(= global196 2)
			(= global197 2)
		)
	)
	(cond
		((or (== global187 200) (== global187 300))
			(= local1 2)
			(= local0 2)
		)
		((== global187 500)
			(= local1 1)
			(= local0 4)
		)
		((== global187 400)
			(= local1 2)
			(= local0 4)
		)
	)
	((= gGameControls chooseControls)
		window: chooseWindow
		helpIconItem: 0
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(human1 theObj: human1 selector: #doit yourself:)
			(computer1 theObj: computer1 selector: #doit yourself:)
			(human2 theObj: human2 selector: #doit yourself:)
			(computer2 theObj: computer2 selector: #doit yourself:)
	)
	(if (> local0 2)
		(gGameControls
			add:
				(human3 theObj: human3 selector: #doit yourself:)
				(computer3 theObj: computer3 selector: #doit yourself:)
				(human4 theObj: human4 selector: #doit yourself:)
				(computer4 theObj: computer4 selector: #doit yourself:)
		)
	)
	(gGameControls
		add:
			(iconOK theObj: iconOK selector: #doit yourself:)
			(iconInfo theObj: iconInfo selector: #doit yourself:)
	)
	(gGameControls show:)
	(localproc_1)
)

(procedure (localproc_1)
	(= global179
		(= global188
			(+
				(not (mod (human1 loop:) 2))
				(not (mod (human2 loop:) 2))
				(not (mod (human3 loop:) 2))
				(not (mod (human4 loop:) 2))
			)
		)
	)
	(= global189
		(+
			(not (mod (computer1 loop:) 2))
			(not (mod (computer2 loop:) 2))
			(not (mod (computer3 loop:) 2))
			(not (mod (computer4 loop:) 2))
		)
	)
	(switch global187
		(500
			(switch global189
				(1
					(= global295 11)
				)
				(2
					(= global295 10)
				)
				(3
					(= global295 9)
				)
			)
		)
		(400
			(switch global189
				(1
					(= global295 14)
				)
				(2
					(= global295 13)
				)
				(3
					(= global295 12)
				)
			)
		)
		(100
			(= global295 8)
		)
		(300
			(= global295 7)
		)
		(200
			(= global295 6)
		)
	)
)

(instance chooseGame of Rm
	(properties
		picture 975
		style 10
	)

	(method (init &tmp temp0)
		(gSong fade: startSong)
		(super init:)
		(Format @local16 98 5) ; "OK"
		(gSound flags: 1)
		(= local15 0)
		(Characters eachElementDo: #active 0 eachElementDo: #dispose)
		(gSong play: 801 setLoop: -1)
		(User canControl: 1)
		(Load rsPIC 976)
		(Load rsVIEW 703)
		(Load rsVIEW 975)
		(Load rsVIEW 704)
		(Load rsSOUND 901)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(if (and (not global294) (DoSound sndGET_AUDIO_CAPABILITY))
			(= global545 1)
		else
			(= global545 0)
		)
		(= global198 0)
		(chooseControls add:)
		(KeyMouse setList: gTheKeyMouseList)
		(self setScript: chooseScript)
		(proc0_1)
		(if (not (HaveMouse))
			(KeyMouse setCursor: chooseCheckers)
		)
		(if global545
			(= global546 1)
			(gSong setVol: 70)
			(gSound2 play: 700 setLoop: 1)
		)
	)

	(method (doit)
		(super doit:)
		(if (and global546 (== (gSound2 prevSignal:) -1))
			(= global546 0)
			(gSong setVol: 127)
		)
	)

	(method (dispose)
		(chooseControls dispose:)
		(if (== global187 600)
			(chooseCheckers dispose: deleteKeyMouse:)
			(chooseBackGammon dispose: deleteKeyMouse:)
			(chooseYacht dispose: deleteKeyMouse:)
			(chooseDominoes dispose: deleteKeyMouse:)
			(chooseSnakes dispose: deleteKeyMouse:)
			(choosePachisi dispose: deleteKeyMouse:)
		)
		(super dispose: &rest)
		(gTheIconBar enable:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (== (chooseScript state:) 0)
			(chooseCheckers handleEvent: event)
			(chooseBackGammon handleEvent: event)
			(chooseYacht handleEvent: event)
			(chooseDominoes handleEvent: event)
			(chooseSnakes handleEvent: event)
			(choosePachisi handleEvent: event)
		)
	)
)

(instance chooseScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 10])
		(switch (= state newState)
			(0
				(= global194 1)
				(= global195 0)
				(= global196 0)
				(= global197 0)
				(chooseCheckers init: addKeyMouse:)
				(chooseBackGammon init: addKeyMouse:)
				(chooseYacht init: addKeyMouse:)
				(chooseDominoes init: addKeyMouse:)
				(chooseSnakes init: addKeyMouse:)
				(choosePachisi init: addKeyMouse:)
			)
			(1
				(gSound play: 901 setLoop: 1)
				(if (!= global187 600)
					(chooseCheckers dispose: deleteKeyMouse:)
					(chooseBackGammon dispose: deleteKeyMouse:)
					(chooseYacht dispose: deleteKeyMouse:)
					(chooseDominoes dispose: deleteKeyMouse:)
					(chooseSnakes dispose: deleteKeyMouse:)
					(choosePachisi dispose: deleteKeyMouse:)
				)
				(if global545
					(= global546 1)
					(gSong setVol: 70)
					(switch global187
						(100
							(gSound2 play: 708)
						)
						(200
							(gSound2 play: 701)
						)
						(300
							(gSound2 play: 704)
						)
						(400
							(gSound2 play: 706)
						)
						(500
							(gSound2 play: 709)
						)
						(600
							(gSound2 play: 707)
						)
					)
				)
				(gSong fade: startSong)
				(if (!= global187 600)
					(DrawPic 976 100)
				else
					(Wait 1)
					(Wait 70)
				)
				(proc0_1)
				(if (== global187 100)
					(= global195 2)
					(= local1 2)
					(= local0 2)
					(= global188 1)
					(= global189 1)
				)
				(if (and (!= global187 600) (!= global187 100))
					(localproc_0)
				)
				(= cycles 1)
			)
			(2
				(gTheIconBar disable:)
				(Format @temp1 975 0)
				(Format @global150 98 0) ; "Player 1"
				(Format @global157 98 1) ; "Player 2"
				(Format @global164 98 2) ; "Player 3"
				(Format @global171 98 3) ; "Player 4"
				(if (StrCmp @temp1 @global472)
					(StrCpy @global150 @global472)
				)
				(if (StrCmp @temp1 @global479)
					(StrCpy @global157 @global479)
				)
				(if (StrCmp @temp1 @global486)
					(StrCpy @global164 @global486)
				)
				(if (StrCmp @temp1 @global493)
					(StrCpy @global171 @global493)
				)
				(if (== global187 100)
					(Print 98 4 41 @global150 10 81 @local16) ; "Enter your name:"
					(StrCpy @global472 @global150)
					(if (not (StrCmp @global150 @temp1))
						(Format @global150 98 0) ; "Player 1"
					)
				else
					(if (not (mod (human1 loop:) 2))
						(Print 98 6 41 @global150 10 81 @local16) ; "Player 1, Enter your name:"
						(StrCpy @global472 @global150)
						(if (not (StrCmp @global150 @temp1))
							(Format @global150 98 0) ; "Player 1"
						)
					)
					(if (not (mod (human2 loop:) 2))
						(Print 98 7 41 @global157 10 81 @local16) ; "Player 2, Enter your name:"
						(StrCpy @global479 @global157)
						(if (not (StrCmp @global157 @temp1))
							(Format @global157 98 1) ; "Player 2"
						)
					)
					(if (not (mod (human3 loop:) 2))
						(Print 98 8 41 @global164 10 81 @local16) ; "Player 3, Enter your name:"
						(StrCpy @global486 @global164)
						(if (not (StrCmp @global164 @temp1))
							(Format @global164 98 2) ; "Player 3"
						)
					)
					(if (not (mod (human4 loop:) 2))
						(Print 98 9 41 @global171 10 81 @local16) ; "Player 4, Enter your name:"
						(StrCpy @global493 @global171)
						(if (not (StrCmp @global171 @temp1))
							(Format @global171 98 3) ; "Player 4"
						)
					)
				)
				(gGame_opt doit: 3)
				(= cycles 1)
			)
			(3
				(if
					(or
						(== (gSong number:) 800)
						(== (gSong number:) 801)
					)
					(startSong cue:)
				)
				(gSound setLoop: 1)
				(gSound2 setLoop: 1)
				(= gNewRoomNum
					(cond
						((== global187 600) 600)
						(global189 3)
						(else global187)
					)
				)
			)
		)
	)
)

(instance chooseCheckers of TrackingView
	(properties
		x 80
		y 80
		view 975
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (& (event modifiers:) emALT)
				(= local15 1)
			)
			(= global187 200)
			(= global295 6)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseBackGammon of TrackingView
	(properties
		x 236
		y 80
		view 975
		loop 3
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (& (event modifiers:) emALT)
				(= local15 1)
			)
			(= global187 300)
			(= global295 7)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseDominoes of TrackingView
	(properties
		x 78
		y 133
		view 975
		loop 5
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global187 100)
			(= global295 8)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseYacht of TrackingView
	(properties
		x 234
		y 133
		view 975
		loop 4
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global187 500)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseSnakes of TrackingView
	(properties
		x 80
		y 186
		view 975
		loop 2
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global187 600)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance choosePachisi of TrackingView
	(properties
		x 234
		y 186
		view 975
		loop 1
		priority 8
	)

	(method (init)
		(self setLoop: loop posn: x y setPri: priority)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global187 400)
			(chooseScript cue:)
		)
		(event claimed:)
	)
)

(instance chooseControls of GameControls
	(properties)

	(method (dispatchEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(Print 98 10) ; "The Icon Bar is not available at this time."
			(event message: JOY_NULL)
		)
		(super dispatchEvent: event &rest)
	)
)

(instance chooseWindow of InvisibleWindow
	(properties
		top 20
		left 50
		bottom 182
		right 277
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 703 0 0 0 0 15)
		(DrawCel
			975
			7
			(switch global187
				(200 0)
				(400 1)
				(600 2)
				(300 3)
				(500 4)
				(100 5)
			)
			42
			1
			15
		)
		(switch global187
			(200
				(if (== global266 200)
					(= local7 10)
					(= local11 11)
				else
					(= local7 4)
					(= local11 5)
				)
				(= local8 12)
				(= local12 13)
			)
			(300
				(= local7 6)
				(= local11 7)
				(= local8 8)
				(= local12 9)
			)
			(400
				(= local7 14)
				(= local11 15)
				(= local8 12)
				(= local12 13)
				(= local9 4)
				(= local13 5)
				(= local10 2)
				(= local14 3)
			)
			(500
				(= local7 4)
				(= local11 5)
				(= local8 4)
				(= local12 5)
				(= local9 4)
				(= local13 5)
				(= local10 4)
				(= local14 5)
			)
		)
		(human1 loop: (+ local7 (== global194 2)))
		(human2 loop: (+ local8 (== global195 2)))
		(human3 loop: (+ local9 (== global196 2)))
		(human4 loop: (+ local10 (== global197 2)))
		(computer1 loop: (+ local7 (== global194 1)))
		(computer2 loop: (+ local8 (== global195 1)))
		(computer3 loop: (+ local9 (== global196 1)))
		(computer4 loop: (+ local10 (== global197 1)))
		(if (== global187 500)
			(human2 loop: local12)
			(human3 loop: local13)
			(human4 loop: local14)
			(computer2 loop: local12)
			(computer3 loop: local13)
			(computer4 loop: local14)
		)
		(if (or (== global187 300) (== global187 200))
			(human3 loop: local11)
			(human4 loop: local12)
			(computer3 loop: local11)
			(computer4 loop: local12)
		)
		(if (> local0 2)
			(DrawCel 703 1 0 22 70 15)
			(DrawCel 703 1 1 22 88 15)
			(DrawCel 703 1 2 22 106 15)
			(DrawCel 703 1 3 22 124 15)
			(human1 nsTop: 67)
			(human2 nsTop: 85)
			(human3 nsTop: 103)
			(human4 nsTop: 121)
			(computer1 nsTop: 67)
			(computer2 nsTop: 85)
			(computer3 nsTop: 103)
			(computer4 nsTop: 121)
		else
			(DrawCel 703 1 0 22 85 15)
			(DrawCel 703 1 1 22 115 15)
			(human1 nsTop: 82)
			(human2 nsTop: 112)
			(computer1 nsTop: 82)
			(computer2 nsTop: 112)
		)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 703
		loop 2
		cel 0
		nsLeft 145
		nsTop 146
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(localproc_1)
		(cond
			((or (< (= temp0 (+ global188 global189)) local1) (> temp0 local0))
				(if (!= local1 local0)
					(Print (Format @global550 98 11 local1 local0)) ; "You must select between %d and %d Players."
				else
					(Print (Format @global550 98 12 local1)) ; "You must select %d Players."
				)
			)
			((== global188 0)
				(Print 98 13) ; "At least one human player must play."
			)
			(else
				(gGameControls hide:)
				(= gGameControls local2)
			)
		)
	)
)

(instance iconInfo of ControlIcon
	(properties
		view 703
		loop 3
		cel 0
		nsLeft 17
		nsTop 146
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(switch global187
			(400
				(Print 98 14 #at -1 10) ; "Select the number of players that will play and the type of players that they will be, and also the color of their playing pieces. The button colors match the playing pieces."
				(Print 98 15 #at -1 10) ; "Also, you may choose the placement of the players on the Pachisi board. Player 1 is in the upper left corner, and the rest follow in a clockwise manner."
				(Print 98 16 #at -1 10) ; "From 2 to 4 players of any combination may play as long as there is at least 1 human player selected."
			)
			(200
				(Print 98 17 #at -1 10) ; "Select the type of players that will play, and also the color of their playing pieces. The button colors match the playing pieces."
				(Print 98 18 #at -1 10) ; "The player playing with the black pieces (or green pieces if playing with the frogs) always goes first. The computer's pieces are always at the top of the screen."
				(Print 98 19 #at -1 10) ; "2 players of any combination may play as long as there is at least 1 human player selected."
			)
			(300
				(Print 98 20 #at -1 10) ; "Select the type of players that will play, and also the color of their playing pieces. The button colors match the playing pieces."
				(Print 98 21 #at -1 10) ; "Player 1's inner table is always at the bottom right of the screen. Player 2's inner table is always at the top right of the screen."
				(Print 98 22 #at -1 10) ; "2 players of any combination may play as long as there is at least 1 human player selected."
			)
			(500
				(Print 98 23 #at -1 10) ; "Select the type of players that will play. In Yacht, Player 1 always plays first, then player 2, ect."
				(Print 98 24 #at -1 10) ; "1 to 4 players of any combination may play as long as there is at least 1 human player selected."
			)
		)
	)
)

(instance human1 of ControlIcon
	(properties
		view 704
		cel 0
		nsLeft 88
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit)
		(if (== loop local7)
			(= loop local11)
			(= global194 0)
		else
			(= loop local7)
			(= global194 1)
			(computer1 loop: local11 show:)
		)
		(localproc_1)
		(self show:)
	)
)

(instance human2 of ControlIcon
	(properties
		view 704
		cel 0
		nsLeft 88
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit)
		(if (== loop local8)
			(= loop local12)
			(= global195 0)
		else
			(= loop local8)
			(= global195 1)
			(computer2 loop: local12 show:)
		)
		(localproc_1)
		(self show:)
	)
)

(instance human3 of ControlIcon
	(properties
		view 704
		cel 0
		nsLeft 88
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit)
		(if (== loop local9)
			(= loop local13)
			(= global196 0)
		else
			(= loop local9)
			(= global196 1)
			(computer3 loop: local13 show:)
		)
		(localproc_1)
		(self show:)
	)
)

(instance human4 of ControlIcon
	(properties
		view 704
		cel 0
		nsLeft 88
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit)
		(if (== loop local10)
			(= loop local14)
			(= global197 0)
		else
			(= loop local10)
			(= global197 1)
			(computer4 loop: local14 show:)
		)
		(localproc_1)
		(self show:)
	)
)

(instance computer1 of ControlIcon
	(properties
		view 704
		cel 0
		nsLeft 153
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit)
		(if (== loop local7)
			(= loop local11)
			(= global194 0)
		else
			(= loop local7)
			(= global194 2)
			(human1 loop: local11 show:)
		)
		(localproc_1)
		(self show:)
	)
)

(instance computer2 of ControlIcon
	(properties
		view 704
		cel 0
		nsLeft 153
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit)
		(if (== loop local8)
			(= loop local12)
			(= global195 0)
		else
			(= loop local8)
			(= global195 2)
			(human2 loop: local12 show:)
		)
		(localproc_1)
		(self show:)
	)
)

(instance computer3 of ControlIcon
	(properties
		view 704
		cel 0
		nsLeft 153
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit)
		(if (== loop local9)
			(= loop local13)
			(= global196 0)
		else
			(= loop local9)
			(= global196 2)
			(human3 loop: local13 show:)
		)
		(localproc_1)
		(self show:)
	)
)

(instance computer4 of ControlIcon
	(properties
		view 704
		cel 0
		nsLeft 153
		signal 387
		helpStr {}
		highlightColor -1
	)

	(method (doit)
		(if (== loop local10)
			(= loop local14)
			(= global197 0)
		else
			(= loop local10)
			(= global197 2)
			(human4 loop: local14 show:)
		)
		(localproc_1)
		(self show:)
	)
)

(instance checkers_opt of File
	(properties
		name {checkers.opt}
	)

	(method (doit &tmp [temp0 20] [temp20 8])
		(if (self open: 1)
			(= global244 (ReadNumber (self readString: @temp20 2)))
			(if (!= global188 2)
				(= global244 1)
			)
			(if
				(and
					(!=
						(= global266 (ReadNumber (self readString: @temp20 4)))
						200
					)
					(!= global266 250)
				)
				(= global266 200)
			)
			(self close:)
			(return 0)
		else
			(= global244 1)
			(= global266 200)
			(return 0)
		)
	)
)

(instance startSong of Script
	(properties)

	(method (cue)
		(switch global187
			(100
				(gSong play: 805)
			)
			(200
				(gSong play: 803)
			)
			(300
				(gSong play: 802)
			)
			(400
				(gSong play: 806)
			)
			(500
				(gSong play: 804)
			)
		)
	)
)

