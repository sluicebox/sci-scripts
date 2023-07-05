;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Print)
(use BorderWindow)
(use ForwardCounter)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm001 0
)

(local
	local0
	local1
)

(instance myDialog of Dialog
	(properties)

	(method (handleEvent)
		(if (and (not (rmScript register:)) (IsFlag 0))
			(switch local0
				(1
					(Palette palANIMATE 208 213 1)
					(Palette palANIMATE 213 218 1)
					(Palette palANIMATE 218 223 1)
					(Palette palANIMATE 223 228 1)
					(Palette palANIMATE 229 234 -1)
					(Palette palANIMATE 234 239 -1)
					(Palette palANIMATE 239 244 -1)
					(Palette palANIMATE 244 249 -1)
				)
				(0
					(Palette palANIMATE 96 218 -1)
				)
			)
		)
		(super handleEvent: &rest)
	)
)

(instance rm001 of PQRoom
	(properties
		picture 106
	)

	(method (init)
		(Palette palSET_FROM_RESOURCE 999 2)
		(Load rsPIC 106 100)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super init:)
		(= global206 1)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(= gNormalCursor 601)
		(gGame setCursor: 601 1)
		(gTheIconBar hide: disable:)
		(User canInput: 1)
		(= local1 gSystemWindow)
		(= gSystemWindow BorderWindow)
		(if global108
			(gGame setScript: haltScript)
		else
			(self setScript: rmScript)
		)
	)

	(method (dispose)
		(gTheIconBar hide: enable:)
		(= gNormalCursor 999)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(if (IsObject gSystemWindow)
			(gSystemWindow dispose:)
		)
		(= gSystemWindow local1)
		(super dispose: &rest)
	)
)

(instance sparkle of Prop
	(properties
		x 121
		y 54
		view 993
		priority 15
		signal 16
	)
)

(instance angel of Prop
	(properties
		x 144
		y 138
		view 850
	)
)

(instance bullseye of View
	(properties
		x 158
		y 153
		view 853
		priority 15
		signal 16
	)
)

(instance sonny of Prop
	(properties
		x 200
		y 189
		view 804
	)
)

(instance haltScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gLongSong pause: 1)
				(= cycles 3)
			)
			(1
				(gGame setCursor: 999 1)
				(if (> (= temp2 (GetNumber {Game State:})) 0)
					(= global211 temp2)
				)
				(= global206
					(Print
						addText: {Which clothes?}
						addButton: 2 {inDisguise} 0 12
						addButton: 0 {inUniform} 0 26
						addButton: 1 {inStreetClothes} 0 40
						addButton: 124 {inTowel} 0 54
						addButton: 125 {inTowelWithDye} 0 68
						addButton: 177 {inClothesAndSuit} 0 82
						init:
					)
				)
				(= global207
					(Print
						addText: {Which car?}
						addButton: 914 {squad car} 0 12
						addButton: 104 {tBird} 0 26
						addButton: 105 {camaro} 0 39
						init:
					)
				)
				(if (> (= temp1 (GetNumber {Teleport to:})) 0)
					(gLongSong stop:)
					(gLongSong2 stop:)
					(client script: 0)
					(ClearFlag 1)
					(gCurRoom newRoom: temp1)
				else
					(= cycles 2)
				)
			)
			(2
				(gLongSong pause: 0)
				(gGame setCursor: 601 1)
				(gCurRoom setScript: rmScript)
				(self dispose:)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (doit)
		(if (and (not register) (IsFlag 0))
			(switch local0
				(1
					(Palette palANIMATE 208 213 1)
					(Palette palANIMATE 213 218 1)
					(Palette palANIMATE 218 223 1)
					(Palette palANIMATE 223 228 1)
					(Palette palANIMATE 229 234 -1)
					(Palette palANIMATE 234 239 -1)
					(Palette palANIMATE 239 244 -1)
					(Palette palANIMATE 244 249 -1)
				)
				(0
					(Palette palANIMATE 96 218 -1)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp [temp0 2] temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global250 gTheCursor)
				(gGame setCursor: 996 1)
				(SetFlag 1)
				(sparkle init:)
				(= ticks 30)
			)
			(1
				(= local0 0)
				(gLongSong number: 1001 loop: 1 play:)
				(= cycles 1)
			)
			(2
				(if (== (gLongSong prevSignal:) 20)
					(sparkle setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3
				(if (== (gLongSong prevSignal:) 30)
					(sparkle x: 60 y: 145 loop: 1 cel: 0 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(4
				(if
					(and
						(== (sparkle cel:) (sparkle lastCel:))
						(== (gLongSong prevSignal:) -1)
					)
					(sparkle dispose:)
					(LoadMany rsPIC 4 100)
					(= cycles 1)
				else
					(-- state)
					(= register 1)
					(Load rsPIC 1)
					(= cycles 2)
				)
			)
			(5
				(sparkle dispose:)
				(gLongSong client: 0)
				(gCurRoom drawPic: 1 -32758)
				(LoadMany rsVIEW 804)
				(= local0 1)
				(= cycles 2)
			)
			(6
				(= gNormalCursor 999)
				(gGame setCursor: 999 1)
				(switch
					(= temp2
						(Print
							dialog: myDialog
							font: 0
							mode: 1
							addText: 9 1 0 5 0 0 0 ; "Police Quest:"
							addText: 9 1 0 6 0 12 0 ; "The Death Angel"
							font: gUserFont
							addButton: 0 9 1 0 1 0 28 0 ; "Intro/Credits"
							addButton: 1 9 1 0 2 0 44 0 ; "Play New Game"
							addButton: 2 9 1 0 3 0 60 0 ; "Restore Old Game"
							addButton: 3 9 1 0 4 0 76 0 ; "Quit"
							init:
						)
					)
					(0
						(= register 0)
						(gLongSong
							number: (if (>= (DoSound sndGET_POLYPHONY) 11) 9999 else 2001)
							loop: 1
							play: self
						)
						(= gNormalCursor 601)
						(gGame setCursor: 601 1)
					)
					(1
						(= gNormalCursor 601)
						(gGame setCursor: 601 1)
						(self changeState: 19)
					)
					(2
						(gGame restore:)
						(self changeState: state)
					)
					(3
						(= gQuit 1)
					)
				)
			)
			(7
				(gCurRoom style: 100 overlay: 100 100)
			)
			(8
				(= local0 2)
				(gCurRoom drawPic: 4 10)
				(sonny init:)
				(if (< (gGame detailLevel:) 2)
					(sonny setCel: (sonny lastCel:))
				else
					(sonny cycleSpeed: 24 setCycle: End)
				)
			)
			(9
				(sonny dispose:)
				(gCurRoom drawPic: 500 10)
				(LoadMany rsPIC 501)
			)
			(10
				(gCurRoom drawPic: 501 10)
				(LoadMany rsPIC 502)
			)
			(11
				(gCurRoom drawPic: 502 10)
				(LoadMany rsPIC 503)
			)
			(12
				(gCurRoom drawPic: 503 10)
				(LoadMany rsVIEW 851 852 850 853)
				(LoadMany rsPIC 71)
			)
			(13
				(gCurRoom drawPic: 71 10)
				(angel
					init:
					cycleSpeed: 24
					setPri: 14
					setCycle: ForwardCounter (gGame detailLevel:) self
				)
			)
			(14
				(bullseye init:)
				(angel
					view: 851
					setLoop: 0
					setCel: 0
					setPri: 14
					cycleSpeed: 24
					setCycle: End self
				)
			)
			(15
				(angel
					view: 852
					setLoop: 0
					setCel: 1
					cycleSpeed: 40
					setCycle: End self
				)
			)
			(16
				(LoadMany rsPIC 504 505 3)
			)
			(17
				(angel dispose:)
				(bullseye dispose:)
				(gCurRoom drawPic: 504 10)
			)
			(18
				(gCurRoom drawPic: 505 10)
			)
			(19
				(= gNormalCursor 601)
				(gGame setCursor: 601 1)
				(= local0 2)
				(gCurRoom drawPic: 3 10)
				(gLongSong fade: 0 10 5)
				(= seconds 3)
			)
			(20
				(gLongSong2 number: 915 play:)
				(gMessager say: 0 0 1 0 self) ; "Lytton, California"
			)
			(21
				(ClearFlag 1)
				(gCurRoom newRoom: 10)
			)
		)
	)
)

